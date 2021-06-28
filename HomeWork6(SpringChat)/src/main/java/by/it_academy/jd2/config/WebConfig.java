package by.it_academy.jd2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("by.it_academy.jd2.web")
public class WebConfig implements WebMvcConfigurer {




}
