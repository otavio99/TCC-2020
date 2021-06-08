package com.tcc.animal.dao;

import com.tcc.fazenda.dao.Fazenda;

import com.tcc.invernada.dao.Invernada;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

@Entity
public class Animal {
    @Id
    public long id;
    public String nome;
    public int quantidade;
    public String tipo;

    public ToOne<Invernada> invernada;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome + ", " + "Quantidade: " + this.quantidade + ".";
    }
}