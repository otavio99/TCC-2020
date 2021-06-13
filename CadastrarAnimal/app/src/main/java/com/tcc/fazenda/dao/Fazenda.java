package com.tcc.fazenda.dao;

import com.tcc.invernada.dao.Invernada;
import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Transient;
import io.objectbox.relation.ToMany;

@Entity
public class Fazenda {
    @Id
    public long id;
    public String nome;

    @Backlink(to = "fazenda")
    public ToMany<Invernada> invernada;

    @Transient
    private static long id_temp;

    public Fazenda() {
    }

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

    @Override
    public String toString(){
        return "Nome: " + this.nome;
    }
}
