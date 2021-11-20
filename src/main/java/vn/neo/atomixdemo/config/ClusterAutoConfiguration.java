package vn.neo.atomixdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author acer on 11/20/2021
 * @project atomix-demo
 */
@Configuration
@ConfigurationProperties(prefix = "app.clusters")
public class ClusterAutoConfiguration implements Serializable {
    private String clusterName;
    private int timeout;
    private String nodeId;
    private String host;
    private int port;
    private int checkInterval;
    private String profiles;
    private String clusterId;
    private List<ClusterMemberInfo> members = new ArrayList<>();

    public ClusterAutoConfiguration() {
    }

    public ClusterAutoConfiguration(String clusterName, int timeout, String nodeId, String host, int port, int checkInterval, String profiles, String clusterId, List<ClusterMemberInfo> members) {
        this.clusterName = clusterName;
        this.timeout = timeout;
        this.nodeId = nodeId;
        this.host = host;
        this.port = port;
        this.checkInterval = checkInterval;
        this.profiles = profiles;
        this.clusterId = clusterId;
        this.members = members;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getCheckInterval() {
        return checkInterval;
    }

    public void setCheckInterval(int checkInterval) {
        this.checkInterval = checkInterval;
    }

    public List<ClusterMemberInfo> getMembers() {
        return members;
    }

    public void setMembers(List<ClusterMemberInfo> members) {
        this.members = members;
    }

    public String getProfiles() {
        return profiles;
    }

    public void setProfiles(String profiles) {
        this.profiles = profiles;
    }

    public String getClusterId() {
        return clusterId;
    }

    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
    }

    @Override
    public String toString() {
        return "ClusterAutoConfiguration{" +
                "clusterName='" + clusterName + '\'' +
                ", timeout=" + timeout +
                ", nodeId='" + nodeId + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", checkInterval=" + checkInterval +
                ", profiles='" + profiles + '\'' +
                ", clusterId='" + clusterId + '\'' +
                ", members=" + members +
                '}';
    }
}
