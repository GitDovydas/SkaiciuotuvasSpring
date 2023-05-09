package com.spring.skaiciuotuvas.service;

import com.spring.skaiciuotuvas.model.Skaicius;

import java.util.List;

public interface SkaiciusService {
    void create(Skaicius skaicius);
    List<Skaicius> readAll();
    Skaicius read(int id);
    void update(Skaicius skaicius);
    void delete(int id);
}
