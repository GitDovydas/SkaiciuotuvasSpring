package com.spring.skaiciuotuvas.config;

import com.spring.skaiciuotuvas.Skaiciuotuvas;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//Servlet yra java programa veikianti web serveryje.
//Servlet paleidziamas kai vartotojas paspaudzia nuoroda, pateikia forma ar atlieka kito tipo veiksmus internetineje svetaineje.
//Kiekviena kliento uzklausa (request) praeina per Servlet, kuris ja perduoda controlerio request maping (uzklausu susiejimas) atributu.
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		//Nurodome pagrindine aplikacijos klase (turincia main metoda).
		return application.sources(Skaiciuotuvas.class);
	}

}
