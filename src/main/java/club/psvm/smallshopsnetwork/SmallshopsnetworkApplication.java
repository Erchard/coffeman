package club.psvm.smallshopsnetwork;

import club.psvm.smallshopsnetwork.services.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SmallshopsnetworkApplication {

    @Autowired
    InitService initService;

    public static void main(String[] args) {
        SpringApplication.run(SmallshopsnetworkApplication.class, args);
    }

    @PostConstruct
    void init() {
        initService.init();
    }

}
