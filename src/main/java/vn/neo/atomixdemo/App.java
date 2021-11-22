package vn.neo.atomixdemo;

import io.atomix.core.Atomix;
import io.atomix.core.AtomixConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        new Thread(new Runnable() {
            @Override
            public void run() {
                AtomixConfig atomixConfig = Atomix.config("D:\\Idea Projects\\atomix-demo\\src\\main\\resources\\atomix.conf");
                Atomix.builder(atomixConfig).build().start().join();
            }
        }).start();
    }

}
