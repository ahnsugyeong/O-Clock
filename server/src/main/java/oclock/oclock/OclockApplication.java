package oclock.oclock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class OclockApplication {

    public static void main(String[] args) {
        SpringApplication.run(OclockApplication.class, args);
    }

}
