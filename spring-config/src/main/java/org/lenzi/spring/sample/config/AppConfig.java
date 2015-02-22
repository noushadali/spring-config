package org.lenzi.spring.sample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

/**
 * Spring project configuration setup
 * 
 * Ignore controller beans. Our MVC setup class will load those.
 * 
 * @see org.lenzi.spring.sample.config.WebMvcConfig
 * 
 * @author slenzi
 */
@Configuration
@ComponentScan(basePackages = "org.lenzi.spring.sample", excludeFilters = {
		@ComponentScan.Filter(value = Controller.class, type = FilterType.ANNOTATION),
		@ComponentScan.Filter(value = Configuration.class, type = FilterType.ANNOTATION) })
@Import({ PropertyConfig.class, PersistenceConfig.class, UploadConfig.class, CxfConfig.class })
public class AppConfig {

}
