package com.example.bebedouro.dao;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;
import io.objectbox.relation.ToOne;

@Entity
public class Bebedouro {

    @Id
    public long id;
    public float altura;
    public String condicaoAcesso;
    public String limpeza;
    @Backlink(to = "bebedouro")
    public ToMany<BebedouroRetangular> bebedouroRetangularToMany;
    @Backlink(to = "bebedouro")
    public ToMany<BebedouroCircular> bebedouroCircularToMany;

    public Bebedouro(float altura, String condicaoAcesso, String limpeza) {
        this.altura = altura;
        this.condicaoAcesso = condicaoAcesso;
        this.limpeza = limpeza;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getCondicaoAcesso() {
        return condicaoAcesso;
    }

    public void setCondicaoAcesso(String condicaoAcesso) {
        this.condicaoAcesso = condicaoAcesso;
    }

    public String getLimpeza() {
        return limpeza;
    }

    public void setLimpeza(String limpeza) {
        this.limpeza = limpeza;
    }

    public ToMany<BebedouroRetangular> getBebedouroRetangularToMany() {
        return bebedouroRetangularToMany;
    }

    public void setBebedouroRetangularToMany(ToMany<BebedouroRetangular> bebedouroRetangularToMany) {
        this.bebedouroRetangularToMany = bebedouroRetangularToMany;
    }

    public ToMany<BebedouroCircular> getBebedouroCircularToMany() {
        return bebedouroCircularToMany;
    }

    public void setBebedouroCircularToMany(ToMany<BebedouroCircular> bebedouroCircularToMany) {
        this.bebedouroCircularToMany = bebedouroCircularToMany;
    }
}

