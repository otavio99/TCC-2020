package com.tcc.bebedouro.dao;

import com.tcc.fazenda.dao.Fazenda;

import com.tcc.invernada.dao.Invernada;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

@Entity
public class Bebedouro {

    @Id
    public long id;
    public float altura;
    public String condicaoAcesso;
    public String limpeza;

    public ToOne<Invernada> invernada;

    public Bebedouro(float altura, String condicaoAcesso, String limpeza) {
        this.altura = altura;
        this.condicaoAcesso = condicaoAcesso;
        this.limpeza = limpeza;
    }

    public Bebedouro( ) {

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

    @Override
    public String toString(){
        return "altura: " + this.altura+"; condição de acesso: " + this.condicaoAcesso+"; limpeza: "+this.limpeza;
    }
}

