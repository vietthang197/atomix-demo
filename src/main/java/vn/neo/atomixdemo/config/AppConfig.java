package vn.neo.atomixdemo.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.atomix.cluster.AtomixCluster;
import io.atomix.cluster.AtomixClusterBuilder;
import io.atomix.cluster.Node;
import io.atomix.cluster.discovery.BootstrapDiscoveryProvider;
import io.atomix.core.Atomix;
import io.atomix.core.AtomixBuilder;
import io.atomix.core.profile.Profile;
import io.atomix.utils.net.Address;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

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
    public AtomixCluster atomix() throws JsonProcessingException {
        List<Node> members = new ArrayList<>();
        clusterConfig.getMembers().forEach(item -> {
            members.add(Node.builder()
                    .withId(item.getNodeId())
                    .withAddress(new Address(item.getHost(), item.getPort()))
                    .build()
            );
        });
        AtomixClusterBuilder builder = AtomixCluster.builder();
        AtomixCluster atomix = builder
                .withClusterId(clusterConfig.getClusterId())
                .withMemberId(clusterConfig.getNodeId())
                .withHost(clusterConfig.getHost())
                .withPort(clusterConfig.getPort())
                .withMembershipProvider(
                        BootstrapDiscoveryProvider.builder()
                                .withNodes(members)
                                .build()
                )
                .build();
        atomix.start().join();
        return atomix;
    }
}
