package com.example.bebedouro.dao;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

@Entity
public class BebedouroRetangular {

    @Id
    public long id;
    public String comprimento;
    public String largura;

    public ToOne<Bebedouro> bebedouroToOne;

    public BebedouroRetangular(String comprimento, String largura) {
        this.comprimento = comprimento;
        this.largura = largura;
    }

    public BebedouroRetangular() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComprimento() {
        return comprimento;
    }

    public void setComprimento(String comprimento) {
        this.comprimento = comprimento;
    }

    public String getLargura() {
        return largura;
    }

    public void setLargura(String largura) {
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
