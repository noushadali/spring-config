package org.lenzi.spring.sample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Spring project configuration setup
 * 
 * @author slenzi
 */
@Configuration
@ComponentScan(basePackages = "org.lenzi.spring.sample")
@Import({ PropertyConfig.class, PersistenceConfig.class, UploadConfig.class })
public class AppConfig {

}
