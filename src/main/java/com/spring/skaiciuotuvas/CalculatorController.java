package com.spring.skaiciuotuvas;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

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
    String index(){
        return "<h1>Internetinis skaičiuotuvas</h1>" +
                "<p>Galimo operacijos:</p>" +
                "<p>&nbsp;&nbsp;Sudėti</p>" +
                "<p>&nbsp;&nbsp;Atimti</p>" +
                "<p>&nbsp;&nbsp;Dauginti</p>" +
                "<p>&nbsp;&nbsp;Dalinti</p>";
    }

    // URL pavyzdys http://localhost:8080/skaiciuoti?sk1=3&sk2=1&zenklas=%2B (+) %2F (/)
    // specialiems symboliams siųsti per url: https://meyerweb.com/eric/tools/dencoder/
    @RequestMapping(method = RequestMethod.GET, value = "/skaiciuoti")
    public String skaiciuoti(@RequestParam HashMap<String, String> skaiciai) {
        double sk1 = Double.parseDouble(skaiciai.get("sk1"));
        double sk2 = Double.parseDouble(skaiciai.get("sk2"));
        String zenklas = skaiciai.get("zenklas");
        // TODO: Pagal įvestą ženklą atlikti operaciją ir atspausdinti rezultatą
        double rezultatas = 0;
        if (zenklas.equals("+")) {
            rezultatas = sk1 + sk2;
        } else if (zenklas.equals("-")) {
            rezultatas = sk1 - sk2;
        } else if (zenklas.equals("/")) {
            rezultatas = sk1 / sk2;
        } else if (zenklas.equals("*")) {
            rezultatas = sk1 * sk2;
        }
        return sk1 + " " + zenklas + " " + sk2 + " = " + rezultatas;
    }
}
