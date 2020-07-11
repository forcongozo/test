package com.congozo.service.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ERLEBNIS")
public class Erlebnis extends BaseEntity {

    private String erlebnisname;

    private Time dauer;

    private Date datum;

    private Time uhrZeit;

    private BigDecimal ausgaben;

    private Integer maximaleTeilnehmerzahl;

    private String geeignetFuer;

    private Blob foto;

    private String beschreibung;

    private String teilnahmevoraussetzung;

    private String hashtag;

    private String erlebnissOrt;

    @OneToOne
    @JoinColumn(name = "benutzer_id")
    private Benutzer benutzer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "erlebnis")
    private List<ErlebnisFoto> erlebnisFotos;

    public String getErlebnisname() {
        return erlebnisname;
    }

    public void setErlebnisname(String erlebnisname) {
        this.erlebnisname = erlebnisname;
    }

    public Time getDauer() {
        return dauer;
    }

    public void setDauer(Time dauer) {
        this.dauer = dauer;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Time getUhrZeit() {
        return uhrZeit;
    }

    public void setUhrZeit(Time uhrZeit) {
        this.uhrZeit = uhrZeit;
    }

    public BigDecimal getAusgaben() {
        return ausgaben;
    }

    public void setAusgaben(BigDecimal ausgaben) {
        this.ausgaben = ausgaben;
    }

    public Integer getMaximaleTeilnehmerzahl() {
        return maximaleTeilnehmerzahl;
    }

    public void setMaximaleTeilnehmerzahl(Integer maximaleTeilnehmerzahl) {
        this.maximaleTeilnehmerzahl = maximaleTeilnehmerzahl;
    }

    public String getGeeignetFuer() {
        return geeignetFuer;
    }

    public void setGeeignetFuer(String geeignetFuer) {
        this.geeignetFuer = geeignetFuer;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getTeilnahmevoraussetzung() {
        return teilnahmevoraussetzung;
    }

    public void setTeilnahmevoraussetzung(String teilnahmevoraussetzung) {
        this.teilnahmevoraussetzung = teilnahmevoraussetzung;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public String getErlebnissOrt() {
        return erlebnissOrt;
    }

    public void setErlebnissOrt(String erlebnissOrt) {
        this.erlebnissOrt = erlebnissOrt;
    }

    public Benutzer getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(Benutzer benutzer) {
        this.benutzer = benutzer;
    }

    public List<ErlebnisFoto> getErlebnisFotos() {
        return erlebnisFotos;
    }

    public void setErlebnisFotos(List<ErlebnisFoto> erlebnisFotos) {
        this.erlebnisFotos = erlebnisFotos;
    }

}
