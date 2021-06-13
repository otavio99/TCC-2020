package com.tcc.invernada.dao;

import com.tcc.animal.dao.Animal;
import com.tcc.bebedouro.dao.Bebedouro;
import com.tcc.bebedouro.dao.BebedouroCircular;
import com.tcc.bebedouro.dao.BebedouroRetangular;
import com.tcc.fazenda.dao.Fazenda;
import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Transient;
import io.objectbox.relation.ToMany;
import io.objectbox.relation.ToOne;

@Entity
public class Invernada {
    @Id
    public long id;
    public String nome;

    public ToOne<Fazenda> fazenda;

    @Backlink(to = "invernada")
    public ToMany<Animal> animais;

    @Backlink(to = "invernada")
    public ToMany<BebedouroCircular> bebedourosCir;

    @Backlink(to = "invernada")
    public ToMany<BebedouroRetangular> bebedourosRet;

    @Transient
    private static long id_temp;

    public Invernada() {
    }

    public Invernada(String nome) {
        this.nome = nome;
    }

    public static long getId_temp() {
        return id_temp;
    }

    public static void setId_temp(long id_temp) {
        Invernada.id_temp = id_temp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome;
    }
}
