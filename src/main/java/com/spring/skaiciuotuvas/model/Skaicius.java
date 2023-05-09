package com.spring.skaiciuotuvas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "skaiciai")
public class Skaicius {
    @Id // PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    @Column(name = "id")
    private int id;
    @Min(value = 0, message = "Validacijos klaida: skaičius nagali būti neigiamas")
    @Column(name = "sk1")
    private double sk1;
    @Min(value = 0, message = "Validacijos klaida: skaičius nagali būti neigiamas")
    @Column(name = "sk2")
    private double sk2;
    @Column(name = "zenklas")
    private String zenklas;
    @Column(name = "rezultatas")
    private double rezultatas;

    public Skaicius() {
    }

    public Skaicius(double sk1, double sk2, String zenklas, double rezultatas) {
        this.sk1 = sk1;
        this.sk2 = sk2;
        this.zenklas = zenklas;
        this.rezultatas = rezultatas;
    }

    public Skaicius(int id, double sk1, double sk2, String zenklas, double rezultatas) {
        this.id = id;
        this.sk1 = sk1;
        this.sk2 = sk2;
        this.zenklas = zenklas;
        this.rezultatas = rezultatas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSk1() {
        return sk1;
    }

    public void setSk1(double sk1) {
        this.sk1 = sk1;
    }

    public double getSk2() {
        return sk2;
    }

    public void setSk2(double sk2) {
        this.sk2 = sk2;
    }

    public String getZenklas() {
        return zenklas;
    }

    public void setZenklas(String zenklas) {
        this.zenklas = zenklas;
    }

    public double getRezultatas() {
        return rezultatas;
    }

    public void setRezultatas(double rezultatas) {
        this.rezultatas = rezultatas;
    }

    @Override
    public String toString() {
        return "Skaicius{" +
                "id=" + id +
                ", sk1=" + sk1 +
                ", sk2=" + sk2 +
                ", zenklas='" + zenklas + '\'' +
                ", rezultatas=" + rezultatas +
                '}';
    }
}
