package com.example.bebedouro.dao;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

@Entity
public class BebedouroRetangular {

    @Id
    public long id;
    public float comprimento;
    public float largura;

    public ToOne<Bebedouro> bebedouroToOne;

    public BebedouroRetangular(float comprimento, float largura) {
        this.comprimento = comprimento;
        this.largura = largura;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public ToOne<Bebedouro> getBebedouroToOne() {
        return bebedouroToOne;
    }

    public void setBebedouroToOne(ToOne<Bebedouro> bebedouroToOne) {
        this.bebedouroToOne = bebedouroToOne;
    }
    @Override
    public String toString(){
        return "comprimento: " + this.comprimento+", largura: "+ this.largura;
    }
}
