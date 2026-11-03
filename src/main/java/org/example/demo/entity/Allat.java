package org.example.demo.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "allat")
public class Allat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nev;
    private int ertekid;
    private Integer ev;     // lehetséges null miatt int helyett Integer
    private int katid;

    @ManyToOne
    @JoinColumn(name = "ertekid", insertable = false, updatable = false)
    private Ertek ertek;

    @ManyToOne
    @JoinColumn(name = "katid", insertable = false, updatable = false)
    private Kategoria kategoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getErtekid() {
        return ertekid;
    }

    public void setErtekid(int ertekid) {
        this.ertekid = ertekid;
    }

    public Integer getEv() {
        return ev;
    }

    public void setEv(Integer ev) {
        this.ev = ev;
    }

    public int getKatid() {
        return katid;
    }

    public void setKatid(int katid) {
        this.katid = katid;
    }

    public Ertek getErtek() {
        return ertek;
    }

    public void setErtek(Ertek ertek) {
        this.ertek = ertek;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }
}
