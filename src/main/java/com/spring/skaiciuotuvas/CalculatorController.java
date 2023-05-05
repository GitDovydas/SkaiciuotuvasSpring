package com.spring.skaiciuotuvas;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Reikia susikurti controleri (spring framework)
//RestController - Tai yra web controleris. Pazymi mvc valdikli. Leidzia viduje naudoti @RequestMapping (uzklausu susiejimo) anotacija.
//RestConroller anotacija nurodo jog nenaudosime jokio vaizdo, tai yra pvz. string tipo rezultatas vartotojui turetu buti isspausdinamas toks koks yra (neidedant i forma).
//RestControlleris naudojamas rest aplikaciju kurime, kai vaizdu uzsiima front-end technologija (JavaScript, Angular, React). Tuo tarpu Spring yra back-end technologija. Visgi mes kursime Spring mvc aplikacijas, tai yra naudosime Spring tiek front-end(naudosime Spring zymu(JavaServerPages tag library(JSPTL sutrumpinimas)) biblioteka) tiek back-end.
@RestController
//EnableAutoConfiguration anotacija zymi konfiguracijos komponenta. Viduje leidzia kurti Bean per metodus su @Bean anotacija.
//Si klases lygio anotacija nurodo Spring karkasui (atspeti konfiguracija)
//Remiantis priklausomybemis (Jar bibliotekomis) kurias programuotojas itraukia i projekta (pom.xml)
//Siuo atveju ji veikia kartu su main metodu
@EnableAutoConfiguration
public class CalculatorController {
    //Marsrutizavimo informacija (susiejimas). Siuo atveju ji nurodo Spring karkasui jog visas HTTP uzklausas, kuriu kelias yra "/" apdoros metodas helloWorld
    //"/" - reiskia root, pvz. skaiciuotuvas.lt (titulinis puslapis)
    //Taciau jeigu mes noretume prisijungti tada butu skaiciuotuvas.lt/login
    //Vadinasi butu "/login"
    @RequestMapping (method = RequestMethod.GET, value = "/")
    String helloWorld(){

        return "Sveikas Pasauli";
    }


}
