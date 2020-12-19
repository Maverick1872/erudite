package com.jonathonterry.eruditecore;

import com.jonathonterry.eruditecore.service.storage.StorageProperties;
import com.jonathonterry.eruditecore.service.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class EruditeCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(EruditeCoreApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}
