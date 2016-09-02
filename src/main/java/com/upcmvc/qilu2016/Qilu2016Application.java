package com.upcmvc.qilu2016;

import com.upcmvc.qilu2016.controller.UpLoadFileController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class Qilu2016Application {

	public static void main(String[] args) {
		SpringApplication.run(Qilu2016Application.class, args);
	}



	@Bean
	CommandLineRunner init() {
		return (args) -> {
			FileSystemUtils.deleteRecursively(new File(UpLoadFileController.ROOT));
			Files.createDirectory(Paths.get(UpLoadFileController.ROOT));
		};
	}
}
