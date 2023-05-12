package com.spring.skaiciuotuvas.model;

import java.util.List;

public interface SkaiciusDAO {
    void create(Skaicius skaicius);
    List<Skaicius> readAll();
    Skaicius read(int id);
    void update(Skaicius skaicius);
    void delete(int id);
}
