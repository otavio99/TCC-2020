package com.example.fazenda.dao;

import com.example.animal.dao.Animal;
import com.example.bebedouro.dao.Bebedouro;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

@Entity
public class Fazenda {
    @Id
    public long id;
    public String nome;

    @Backlink(to = "fazendaToOne")
    public ToMany<Animal> animais;
    @Backlink(to = "fazendaToOne")
    public ToMany<Bebedouro> bebedouros;
    private static long id_temp;

    public Fazenda(String nome) {
        this.nome = nome;

    }

    public static long getId_temp() {
        return id_temp;
    }

    public static void setId_temp(long id_temp) {
        Fazenda.id_temp = id_temp;
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

    public ToMany<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(ToMany<Animal> animais) {
        this.animais = animais;
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome;
    }
}
