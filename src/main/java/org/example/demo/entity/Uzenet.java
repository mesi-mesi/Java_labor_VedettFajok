package org.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "uzenetek")
public class Uzenet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A név megadása kötelező!")
    @Size(min = 2, max = 100, message = "A név 2 és 100 karakter között legyen!")
    private String nev;

    @NotBlank(message = "Az e-mail cím megadása kötelező!")
    @Email(message = "Érvényes e-mail címet adj meg!")
    private String email;

    @NotBlank(message = "Az üzenet nem lehet üres!")
    @Size(min = 10, max = 1000, message = "Az üzenet 10 és 1000 karakter között legyen!")
    @Column(length = 1000)
    private String szoveg;

    private LocalDateTime kuldesIdeje;   // a szerver tölti ki mentéskor

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNev() { return nev; }
    public void setNev(String nev) { this.nev = nev; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSzoveg() { return szoveg; }
    public void setSzoveg(String szoveg) { this.szoveg = szoveg; }

    public LocalDateTime getKuldesIdeje() { return kuldesIdeje; }
    public void setKuldesIdeje(LocalDateTime kuldesIdeje) { this.kuldesIdeje = kuldesIdeje; }
}