package com.spring.skaiciuotuvas.config;

import com.spring.skaiciuotuvas.model.SkaiciusDAO;
import com.spring.skaiciuotuvas.model.SkaiciusDAOImpl;
import com.spring.skaiciuotuvas.service.SkaiciusService;
import com.spring.skaiciuotuvas.service.SkaiciusServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Configuration anotacija žymi konfiguracijos komponentą
// Paleidus Spring aplikaciją Spring'as automagiškai peržiūrės konfiguracijoje aprašytus Bean'us
// Įgyvendindamas Autowired anotaciją (perduos objektus per interface'us) - automatinė inversijų kontrolė
// Viduje leidžia kurti Bean per metodus su @Bean anotacija
@Configuration
public class SpringConfig {
    // Bean - tai objektai, kurie sudaro Spring aplikacijos pagrindą
    // Paprastai, tai Java klasė realizuojanti tam tikrą interface'ą ir Java Bean specifikaciją
    // Bean atitinka Singleton šabloną - vienintelis egzempliorius
    // Tai naudinga, kai reikia tiksliai vieno objekto norint koordinuoti veiksmus visoje sistemoje
    @Bean
    // Qualifier anotacija kartu su Autowired patikslina su kuriuos konkrečiu Bean susieti priklausomybę
    // Jeigu @Confuguration klasėje yra daugiau nei vienas @Bean @Qualifier anotiacija yra privaloma,
    // kitu atveju metama klaida:
    // 'Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans,
    // or using @Qualifier to identify the bean that should be consumed'
    @Qualifier("SkaiciusDAOImpl")
    public SkaiciusDAO getSkaiciusDAO() {
        return new SkaiciusDAOImpl();
    }

    @Bean
    @Qualifier("SkaiciusServiceImpl")
    public SkaiciusService getSkaiciusService() {
        return new SkaiciusServiceImpl();
    }
}
