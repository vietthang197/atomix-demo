package vn.neo.atomixdemo.controller;

import com.alipay.sofa.jraft.RaftGroupService;
import com.alipay.sofa.jraft.entity.PeerId;
import org.springframework.beans.factory.annotation.Autowired;
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
    private RaftGroupService raftGroupService;

    @GetMapping("/")
    public PeerId test() {
        return raftGroupService.getRaftNode().getLeaderId();
    }
}
