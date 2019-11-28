package com.fesine.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AccountDubboServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountDubboServiceApplication.class, args);
	}

}
