package com.example.animal.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity

public class Animal {

    @Id(autoincrement = true)
    private Long id;
    private String nome;
    private int quantidade;

    public Animal(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    @Generated(hash = 834439969)
    public Animal(Long id, String nome, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    @Generated(hash = 308569294)
    public Animal() {
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String toString (){
        return this.id+" "+ this.nome+" "+this.quantidade;
    }
}
