package vn.neo.atomixdemo.config;

import io.atomix.core.Atomix;
import io.atomix.core.AtomixBuilder;
import io.atomix.core.AtomixConfig;
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

}
