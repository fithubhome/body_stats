package ro.fithubhome.bodystats.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.bodystats.api.repository")
public class BeanConfig {

}