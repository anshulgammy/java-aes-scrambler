package com.techbrunch.innovation.aes_scrambler.springconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.techbrunch.innovation.aes_scrambler")
public class Config {

}
