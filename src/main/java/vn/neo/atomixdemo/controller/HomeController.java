package vn.neo.atomixdemo.controller;

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
    public String test() {
        System.out.println(hazelcast.getCPSubsystem());;
        System.out.println(hazelcast.getCPSubsystem().getCPSubsystemManagementService());;
        System.out.println(hazelcast.getCPSubsystem().getCPSessionManagementService());;
        return "OK";
    }
}
