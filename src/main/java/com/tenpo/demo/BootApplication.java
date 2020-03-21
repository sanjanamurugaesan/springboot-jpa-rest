package com.tenpo.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@ComponentScan(basePackages = "com.tenpo")
@SpringBootApplication
public class BootApplication extends SpringBootServletInitializer {
	private static final Log LOGGER= LogFactory.getLog(BootApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
		LOGGER.info("BootApplication Started .............");
	}
}
