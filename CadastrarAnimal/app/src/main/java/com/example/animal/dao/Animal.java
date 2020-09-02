package com.example.animal.dao;

import com.example.fazenda.dao.Fazenda;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

@Entity
public class Animal {
    @Id
    public long id;
    public String nome;
    public int quantidade;

    public ToOne<Fazenda> fazendaToOne;

    public Animal( String nome, int quantidade) {

        this.nome = nome;
        this.quantidade = quantidade;
    }

    public Animal( ) {

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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ToOne<Fazenda> getFazendaToOne() {
        return fazendaToOne;
    }

    public void setFazendaToOne(ToOne<Fazenda> fazendaToOne) {
        this.fazendaToOne = fazendaToOne;
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome + ", " + "Quantidade: " + this.quantidade + ".";
    }
}