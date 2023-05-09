package com.spring.skaiciuotuvas;

import jakarta.validation.constraints.Min;

public class Skaicius {
    @Min(value = 0, message = "Validacijos klaida: skaičius nagali būti neigiamas")
    private double sk1;
    @Min(value = 0, message = "Validacijos klaida: skaičius nagali būti neigiamas")
    private double sk2;
    private String zenklas;
    private double rezultatas;

    public Skaicius() {
    }

    public Skaicius(double sk1, double sk2, String zenklas, double rezultatas) {
        this.sk1 = sk1;
        this.sk2 = sk2;
        this.zenklas = zenklas;
        this.rezultatas = rezultatas;
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
                "sk1=" + sk1 +
                ", sk2=" + sk2 +
                ", zenklas='" + zenklas + '\'' +
                ", rezultatas=" + rezultatas +
                '}';
    }
}
