package com.dora.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhou
 */
@EnableAdminServer
@SpringBootApplication
public class MonitorAdminApplication {
	public static void main(String[] args) {
		SpringApplication.run(MonitorAdminApplication.class, args);
	}
}
