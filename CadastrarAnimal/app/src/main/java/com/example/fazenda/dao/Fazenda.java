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

    public Fazenda(String nome) {
        this.nome = nome;

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
