package com.congozo.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table( name = "BENUTZER", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class Benutzer extends BaseEntity {

    @Size(max =50)
    private String vorname;

    @Size(max = 50)
    private String nachname;

    private String geschlecht;

    @Size(max = 50)
    private String username;

    private Integer alt;

    private Date geburtsdatum;

    private String sprachen;

    private String stadt;
    private String land;
    private String hashtag;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @Size(max = 20)
    private String handynummer;

    @NotBlank
    @Size(max = 120)
    private String password;

    @OneToOne
    @JoinColumn(name = "BENUTZER_FOTO_ID")
    private Benutzerfoto benutzerfoto;
    private String fachgebiet;
    @Size(max = 2000)
    private String info;
    private boolean aktive;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "BENUTZER_ROLE",
            joinColumns = @JoinColumn(name = "benutzer_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<CongozoRole> congozoRoles = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "benutzer")
    @JsonIgnore
    private List<KontoAktivierungsCode> aktivierungsCodeList;

    public Benutzer(){

    }
    public Benutzer(String vorname, String nachname, String geschlecht, String username,
                    Date geburtsdatum, String email, String handynummer,String password,
                    String info, String stadt, String land, String hashtag) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geschlecht = geschlecht;
        this.username = username;
        this.geburtsdatum = geburtsdatum;
        this.email = email;
        this.handynummer = handynummer;
        this.password = password;
        this.info = info;
        this.stadt = stadt;
        this.land = land;
        this.hashtag = hashtag;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAlt() {
        return alt;
    }

    public void setAlt(Integer alt) {
        this.alt = alt;
    }

    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(Date geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public String getSprachen() {
        return sprachen;
    }

    public void setSprachen(String sprachen) {
        this.sprachen = sprachen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHandynummer() {
        return handynummer;
    }

    public void setHandynummer(String handynummer) {
        this.handynummer = handynummer;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Benutzerfoto getBenutzerfoto() {
        return benutzerfoto;
    }

    public void setBenutzerfoto(Benutzerfoto benutzerfoto) {
        this.benutzerfoto = benutzerfoto;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public String getFachgebiet() {
        return fachgebiet;
    }

    public void setFachgebiet(String fachgebiet) {
        this.fachgebiet = fachgebiet;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Set<CongozoRole> getCongozoRoles() {
        return congozoRoles;
    }

    public void setCongozoRoles(Set<CongozoRole> congozoRoles) {
        this.congozoRoles = congozoRoles;
    }

    public boolean isAktive() {
        return aktive;
    }

    public void setAktive(boolean aktive) {
        this.aktive = aktive;
    }

    public List<KontoAktivierungsCode> getAktivierungsCodeList() {
        return aktivierungsCodeList;
    }

    public void setAktivierungsCodeList(List<KontoAktivierungsCode> aktivierungsCodeList) {
        this.aktivierungsCodeList = aktivierungsCodeList;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Benutzer benutzer = (Benutzer) o;
        return aktive == benutzer.aktive &&
                Objects.equals(vorname, benutzer.vorname) &&
                Objects.equals(nachname, benutzer.nachname) &&
                Objects.equals(geschlecht, benutzer.geschlecht) &&
                Objects.equals(username, benutzer.username) &&
                Objects.equals(alt, benutzer.alt) &&
                Objects.equals(geburtsdatum, benutzer.geburtsdatum) &&
                Objects.equals(sprachen, benutzer.sprachen) &&
                Objects.equals(stadt, benutzer.stadt) &&
                Objects.equals(land, benutzer.land) &&
                Objects.equals(email, benutzer.email) &&
                Objects.equals(handynummer, benutzer.handynummer) &&
                Objects.equals(password, benutzer.password) &&
                Objects.equals(benutzerfoto, benutzer.benutzerfoto) &&
                Objects.equals(hashtag, benutzer.hashtag) &&
                Objects.equals(fachgebiet, benutzer.fachgebiet) &&
                Objects.equals(info, benutzer.info) &&
                Objects.equals(congozoRoles, benutzer.congozoRoles) &&
                Objects.equals(aktivierungsCodeList, benutzer.aktivierungsCodeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), vorname, nachname, geschlecht, username, alt, geburtsdatum, sprachen, stadt, land, email, handynummer, password, benutzerfoto, hashtag, fachgebiet, info, aktive, congozoRoles, aktivierungsCodeList);
    }
}
