package org.example.demo.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "ertek")
public class Ertek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int forint;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getForint() {
        return forint;
    }

    public void setForint(int forint) {
        this.forint = forint;
    }
}
