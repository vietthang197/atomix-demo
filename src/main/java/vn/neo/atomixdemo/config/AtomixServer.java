package vn.neo.atomixdemo.config;

import io.atomix.core.Atomix;
import io.atomix.core.AtomixConfig;

/**
 * @author acer on 11/22/2021
 * @project atomix-demo
 */
public class AtomixServer extends Thread {

    private static final AtomixServer INSTANCE;
    private final Atomix atomix;
    static {
        INSTANCE = new AtomixServer();
    }

    public AtomixServer() {
        AtomixConfig atomixConfig = Atomix.config("D:\\Idea Projects\\atomix-demo\\src\\main\\resources\\atomix.conf");
        this.atomix = Atomix.builder(atomixConfig).build();
    }

    public void run() {
        this.atomix.start().join();
    }

    public static AtomixServer getInstance() {
        return INSTANCE;
    }
}
