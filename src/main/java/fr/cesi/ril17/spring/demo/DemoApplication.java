package fr.cesi.ril17.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.cesi.ril17.spring.demo.services.DataLoader;
import lombok.extern.slf4j.Slf4j;

/*
Done by @SpringBootApplication
-------
@Configuration
@ComponentScan(basePackages = {
	"fr.cesi.ril17.spring.demo.*"	
})*/
@SpringBootApplication
public class DemoApplication {
	
	@Autowired
	private DataLoader dataLoader;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
