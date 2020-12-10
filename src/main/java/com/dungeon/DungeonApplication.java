package com.dungeon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class DungeonApplication {

	public static void main(String[] args) {
		SpringApplication.run(DungeonApplication.class, args);
	}

}
