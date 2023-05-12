package com.spring.skaiciuotuvas.service;

import com.spring.skaiciuotuvas.model.Skaicius;
import com.spring.skaiciuotuvas.model.SkaiciusDAO;
import com.spring.skaiciuotuvas.model.SkaiciusDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

// Service anotacija skirta verslo logikai aprašyti
// Po service sluoksniu kreipiamės į DAO
@Service
public class SkaiciusServiceImpl implements SkaiciusService{
    // Autowired anotacija naudojama automatinei priklausomybių injekcijai (inversion of control) (pagal nurodytą interface randamas tą interface realizuojančios klasės objektas)
    // Kad panaudoti Autowired anotaciją pirmiausiai reikia turėti apsirašius @Bean @Configuration klasę
    @Autowired
    // Qualifier anotacija kartu su Autowired patikslina su kuriuos konkrečiu Bean susieti priklausomybę
    // Jeigu @Confuguration klasėje yra daugiau nei vienas @Bean @Qualifier anotacija yra privaloma,
    // kitu atveju metama klaida:
    // 'Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans,
    // or using @Qualifier to identify the bean that should be consumed'
    @Qualifier("SkaiciusDAOImpl")
    private SkaiciusDAO skaiciusDAO;

    @Override
    public void create(Skaicius skaicius) {
        skaiciusDAO.create(skaicius);
    }

    @Override
    public List<Skaicius> readAll() {
        return skaiciusDAO.readAll();
    }

    @Override
    public Skaicius read(int id) {
        return skaiciusDAO.read(id);
    }

    @Override
    public void update(Skaicius skaicius) {
        skaiciusDAO.update(skaicius);
    }

    @Override
    public void delete(int id) {
        skaiciusDAO.delete(id);
    }
}
