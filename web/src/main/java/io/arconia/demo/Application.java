package io.arconia.demo;

import io.arconia.core.multitenancy.context.TenantContextHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	RouterFunction<ServerResponse> routerFunction() {
		return RouterFunctions.route()
				.GET("/", request -> ServerResponse.ok()
						.body("Welcome! Tenant: %s".formatted(TenantContextHolder.getTenantIdentifier())))
				.build();
	}

}
