package com.tcc.bebedouro.dao;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

@Entity
public class BebedouroCircular {
        @Id
        public long id;
        public String raio;
        public String vazao;

        public ToOne<Bebedouro> bebedouroToOne;

    public BebedouroCircular(String raio, String vazao) {
        this.raio = raio;
        this.vazao = vazao;
    }

    public BebedouroCircular( ) {

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRaio() {
        return raio;
    }

    public void setRaio(String raio) {
        this.raio = raio;
    }

    public String getVazao() {
        return vazao;
    }

    public void setVazao(String vazao) {
        this.vazao = vazao;
    }

    public ToOne<Bebedouro> getBebedouroToOne() {
        return bebedouroToOne;
    }

    public void setBebedouroToOne(ToOne<Bebedouro> bebedouroToOne) {
        this.bebedouroToOne = bebedouroToOne;
    }
    @Override
    public String toString(){
        return "raio: " + this.raio+", vazão: "+ this.vazao;
    }
}
