package com.spring.skaiciuotuvas.controller;

import com.spring.skaiciuotuvas.model.Skaicius;
import com.spring.skaiciuotuvas.service.SkaiciusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

//Reikia susikurti controleri (spring framework)
//RestController - Tai yra web controleris. Pazymi mvc valdikli. Leidzia viduje naudoti @RequestMapping (uzklausu susiejimo) anotacija.
//RestConroller anotacija nurodo jog nenaudosime jokio vaizdo, tai yra pvz. string tipo rezultatas vartotojui turetu buti isspausdinamas toks koks yra (neidedant i forma).
//RestControlleris naudojamas rest aplikaciju kurime, kai vaizdu uzsiima front-end technologija (JavaScript, Angular, React). Tuo tarpu Spring yra back-end technologija. Visgi mes kursime Spring mvc aplikacijas, tai yra naudosime Spring tiek front-end(naudosime Spring zymu(JavaServerPages tag library(JSPTL sutrumpinimas)) biblioteka) tiek back-end.
//@RestController
//EnableAutoConfiguration anotacija zymi konfiguracijos komponenta. Viduje leidzia kurti Bean per metodus su @Bean anotacija.
//Si klases lygio anotacija nurodo Spring karkasui (atspeti konfiguracija)
//Remiantis priklausomybemis (Jar bibliotekomis) kurias programuotojas itraukia i projekta (pom.xml)
//Siuo atveju ji veikia kartu su main metodu
@EnableAutoConfiguration
// Rescontroller negrąžina view (vaizdo)
// Kadangi mums reikia grąžinti view pagal SPRING MVC naudojame Controller anoticją
@Controller
public class SkaiciuotuvasController {
    @Autowired
    @Qualifier("SkaiciusServiceImpl")
    private SkaiciusService skaiciusService;
    //Marsrutizavimo informacija (susiejimas). Siuo atveju ji nurodo Spring karkasui jog visas HTTP uzklausas, kuriu kelias yra "/" apdoros metodas helloWorld
    //"/" - reiskia root, pvz. skaiciuotuvas.lt (titulinis puslapis)
    //Taciau jeigu mes noretume prisijungti tada butu skaiciuotuvas.lt/login
    //Vadinasi butu "/login"
    @RequestMapping (method = RequestMethod.GET, value = "/")
    String index(Model model){
        // Jeigu model'is 'skaicius' nepraeina validacijos - per jį grąžinamos validacijos klaidos į vaizdą (view)
        model.addAttribute("skaicius", new Skaicius());
        // Grąžina jsp failą. Turi būti talpinami 'webapp -> WEB-INF -> JSP' aplanke
        return "skaiciuotuvas";
    }

    // URL pavyzdys http://localhost:8080/skaiciuoti?sk1=3&sk2=1&zenklas=%2B (+) %2F (/)
    // specialiems symboliams siųsti per url: https://meyerweb.com/eric/tools/dencoder/
    @RequestMapping(method = RequestMethod.POST, value = "/skaiciuoti")
    // SVARBU!!! Parametras BindingResult turi eiti iš karto po anotacijos @Valid
    // kitu atveju bus 'Validation failed for object'
    public String skaiciuoti(
            @Valid @ModelAttribute("skaicius") Skaicius skaicius2,
            BindingResult bindingResult,
            @RequestParam HashMap<String,String> ivedimoSarasas,
            ModelMap isvedimoSarasas) {
        double sk1 = Double.parseDouble(ivedimoSarasas.get("sk1"));
        double sk2 = Double.parseDouble(ivedimoSarasas.get("sk2"));
        String zenklas = ivedimoSarasas.get("zenklas");

        if (bindingResult.hasErrors()) { // Jeigu validacijos klaidos (žr. skaicius.java aprašytą validaciją prie kiekvieno skaičiaus)
            return "skaiciuotuvas"; // Vartotojas lieka skaičiuotuvo lange tol kol neišlaiko validacijos klaidų
        } else { // Praėjo validaciją - skaičiuojamas rezultatas
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
            // Sąrašas (modelis) naudojamas siųsti reikšmes iš Spring MVC controller į JSP (vaizdą)
            isvedimoSarasas.put("sk1", sk1);
            isvedimoSarasas.put("sk2", sk2);
            isvedimoSarasas.put("zenklas", zenklas);
            isvedimoSarasas.put("rezultatas", rezultatas);

            // Kreipiamės į service, kuris savo ruožtu kreipiasi į DAO ir išsaugo įrašą DB
            skaiciusService.create(new Skaicius(sk1, sk2, zenklas, rezultatas));

            return "skaiciuoti";
        }
    }
}
