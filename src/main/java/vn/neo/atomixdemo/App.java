package vn.neo.atomixdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.neo.atomixdemo.config.AtomixServer;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        AtomixServer.getInstance().start();
    }

}
