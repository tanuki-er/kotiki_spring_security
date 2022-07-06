package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("app.entity")
public class SpirngKoteJavaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpirngKoteJavaApplication.class, args);
    }
}
