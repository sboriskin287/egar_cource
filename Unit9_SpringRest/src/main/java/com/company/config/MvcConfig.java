package com.company.config;

import com.company.converter.ElfElfResConverter;
import com.company.converter.IntElfConverter;
import com.company.formatter.ElfFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@EnableWebMvc
@Configuration
@ComponentScan("com.company")
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {
    private final IntElfConverter intElfConverter;
    private final ElfElfResConverter elfElfResConverter;
    private final ElfFormatter elfFormatter;

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter());
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        //registry.addConverter(intElfConverter);
        //registry.addConverter(elfElfResConverter);
        //registry.addFormatter(elfFormatter);
    }
}

