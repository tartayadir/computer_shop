package com.yaroslav.computer_shop;

import com.yaroslav.model.computer.entity.Computer;
import com.yaroslav.model.computer.entity.Laptop;
import com.yaroslav.model.computer.enums.OperationSystem;
import com.yaroslav.model.computer.repository.ComputerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.yaroslav")
@EnableJpaRepositories(basePackages = "com.yaroslav")
@EntityScan(basePackages = "com.yaroslav")
public class ComputerShopApplication {

	public static void main(String[] args) {

		SpringApplication.run(ComputerShopApplication.class, args);
	}
}
