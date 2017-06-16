package com.rvir.projekt;

/**
 * Created by Marko on 6/15/2017.
 */

public class Uporabnik {

    private int id;
    private String ime;
    private String email;
    private String geslo;
    private String spol;
    private String starost;
    private String visina;
    private String teza;
    private double kalorije;

    public Uporabnik() {
    }

    public Uporabnik(String ime, String email, String geslo, String spol, String starost, String visina, String teza, double kalorije) {

        this.ime = ime;
        this.email = email;
        this.geslo = geslo;
        this.spol = spol;
        this.starost = starost;
        this.visina = visina;
        this.teza = teza;
        this.kalorije = kalorije;
    }

    public Uporabnik(int id,String ime, String email, String geslo, String spol, String starost, String visina, String teza, double kalorije) {

        this.id = id;
        this.ime = ime;
        this.email = email;
        this.geslo = geslo;
        this.spol = spol;
        this.starost = starost;
        this.visina = visina;
        this.teza = teza;
        this.kalorije = kalorije;
    }

    public Uporabnik(String _username, String _password) {
        this.ime = _username;
        this.geslo = _password;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGeslo() {
        return geslo;
    }

    public void setGeslo(String geslo) {
        this.geslo = geslo;
    }

    public String getSpol() {
        return spol;
    }

    public void setSpol(String spol) {
        this.spol = spol;
    }

    public String getStarost() {
        return starost;
    }

    public void setStarost(String starost) {
        this.starost = starost;
    }

    public String getVisina() {
        return visina;
    }

    public void setVisina(String visina) {
        this.visina = visina;
    }

    public String getTeza() {
        return teza;
    }

    public void setTeza(String teza) {
        this.teza = teza;
    }

    public double getKalorije() {
        return kalorije;
    }

    public void setKalorije(double kalorije) {
        this.kalorije = kalorije;
    }





}
