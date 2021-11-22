package vn.neo.atomixdemo.config;

import com.alipay.remoting.rpc.RpcServer;
import com.alipay.sofa.jraft.RaftGroupService;
import com.alipay.sofa.jraft.entity.PeerId;
import com.alipay.sofa.jraft.option.NodeOptions;
import com.alipay.sofa.jraft.rpc.RaftRpcServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author acer on 11/20/2021
 * @project atomix-demo
 */
@Configuration
public class AppConfig {

    private final ClusterAutoConfiguration clusterConfig;

    public AppConfig(ClusterAutoConfiguration clusterConfig) {
        this.clusterConfig = clusterConfig;
    }

    @Bean
    public RaftGroupService test() throws InterruptedException {
        PeerId serverId = new PeerId();
        serverId.parse("localhost:6788");
        RpcServer rpcServer = new RpcServer(serverId.getPort());
        RaftRpcServerFactory.addRaftRequestProcessors(rpcServer);
        NodeOptions nodeOptions = new NodeOptions();
        // 为了测试, 调整 snapshot 间隔等参数
        nodeOptions.setElectionTimeoutMs(5000);
        nodeOptions.setDisableCli(false);
        nodeOptions.setSnapshotIntervalSecs(30);
        com.alipay.sofa.jraft.conf.Configuration configuration = new com.alipay.sofa.jraft.conf.Configuration();
        configuration.parse("localhost:6788,localhost:6789");
        nodeOptions.setInitialConf(configuration);
        // 设置存储路径
        // 日志, 必须
        nodeOptions.setLogUri("D:/temp/log");
        // 元信息, 必须
        nodeOptions.setRaftMetaUri("D:/temp/raft_meta");
        // snapshot, 可选, 一般都推荐
        nodeOptions.setSnapshotUri("D:/temp/snapshot");
        // 初始化 raft group 服务框架
        RaftGroupService aftGroupService = new RaftGroupService("abc", serverId, nodeOptions, rpcServer);
        aftGroupService.start().join();
        return aftGroupService;
    }

}
