package com.rems.yumPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RealEstateManagementPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealEstateManagementPortalApplication.class, args);
	}

}
