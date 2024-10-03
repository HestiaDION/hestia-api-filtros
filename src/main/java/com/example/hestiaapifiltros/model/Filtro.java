package com.example.hestiaapifiltros.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity(name = "filtros")
public class Filtro {
    @Id
    UUID uid;
    String cnome;
    String ccategoria;

    public Filtro(){}
    public Filtro(UUID uid, String cnome, String ccategoria) {
        this.uid = uid;
        this.cnome = cnome;
        this.ccategoria = ccategoria;
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public String getCnome() {
        return cnome;
    }

    public void setCnome(String cnome) {
        this.cnome = cnome;
    }

    public String getCcategoria() {
        return ccategoria;
    }

    public void setCcategoria(String categoria) {
        this.ccategoria = categoria;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Filtro{");
        sb.append("uid=").append(uid);
        sb.append(", cnome='").append(cnome).append('\'');
        sb.append(", categoria='").append(ccategoria).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
