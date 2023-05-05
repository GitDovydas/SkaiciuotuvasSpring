package com.spring.skaiciuotuvas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Pagrindine klase, nes turi main metoda.
//Spring boot application anotacija - yra lygi @Configuration, @EnableAutoConfiguration, @ComponentScan anotacijoms kartu sudejus.
//Si anotacija nurodoma klaseje turincioje pagrindini (main metoda).
@SpringBootApplication //anotacija
public class Skaiciuotuvas {

	public static void main(String[] args) {
		//Programos kontrole deleguojama statiniam klases SpringApplication metodui run
		//Nurodant aplikacijos saknini komponenta (SkaiciuotuvasApplication.class)
		//Spring karkasas (framework) paleis aplikacija, tai yra startuos tomcat serveri su numatytais parametrais.
		SpringApplication.run(Skaiciuotuvas.class, args);
	}
}
