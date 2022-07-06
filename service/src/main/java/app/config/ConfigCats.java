package app.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;


@Configuration
//@EnableJpaRepositories(basePackages={"service"})
@EntityScan(basePackages = {"entity"})
public class ConfigCats {
}
