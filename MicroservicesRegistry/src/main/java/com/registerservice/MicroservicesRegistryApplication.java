package com.registerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroservicesRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesRegistryApplication.class, args);
		
//		System.out.println("MicroservicesRegistryApplication.main()"+"|The Application Started Sucessfully...");
	}

}
