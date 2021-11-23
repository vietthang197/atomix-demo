package vn.neo.atomixdemo.controller;

import com.hazelcast.cluster.Member;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author acer on 11/22/2021
 * @project atomix-demo
 */
@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    @Qualifier("hazelCastInstance")
    private HazelcastInstance hazelcast;

    @GetMapping
    public boolean test() {
        Member oldestMember = hazelcast.getCluster()
                .getMembers().iterator().next();

        hazelcast.getMap("abc").forEach((k, v) -> System.out.println(k +" - " + v));
        return oldestMember.localMember();
    }
}
