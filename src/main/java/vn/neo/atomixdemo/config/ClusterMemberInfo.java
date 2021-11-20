package vn.neo.atomixdemo.config;

import java.io.Serializable;

/**
 * @author acer on 11/20/2021
 * @project atomix-demo
 */
public class ClusterMemberInfo implements Serializable {
    private String nodeId;
    private String host;
    private int port;

    public ClusterMemberInfo() {
    }

    public ClusterMemberInfo(String nodeId, String host, int port) {
        this.nodeId = nodeId;
        this.host = host;
        this.port = port;
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

    @Override
    public String toString() {
        return "ClusterMemberInfo{" +
                "nodeId='" + nodeId + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                '}';
    }
}
