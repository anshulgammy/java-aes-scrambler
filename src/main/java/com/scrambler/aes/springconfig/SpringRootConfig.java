package com.scrambler.aes.springconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan({"com.scrambler.aes"})
public class SpringRootConfig implements WebMvcConfigurer {
	
}
