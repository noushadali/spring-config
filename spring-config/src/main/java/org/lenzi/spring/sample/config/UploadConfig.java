package org.lenzi.spring.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * Configure Spring's CommonsMultipartResolver, because why not. HTTP upload is fun!
 * 
 * @author slenzi
 */
@Configuration
public class UploadConfig {

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver createMultipartResolver() {
		
	    CommonsMultipartResolver resolver = new CommonsMultipartResolver();
	    
	    // -1 = no limit on upload size
	    resolver.setMaxUploadSize(-1L);
	    
	    // optionally set where temporary directory where uploaded files get stored.
	    // Default is the servlet container's temporary directory for the web application.
	    //resolver.setUploadTempDir(uploadTempDir);
	    
	    resolver.setDefaultEncoding("utf-8");
	    return resolver;
	    
	}

}
