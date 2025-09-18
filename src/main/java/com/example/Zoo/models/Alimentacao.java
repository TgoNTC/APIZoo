package com.example.Zoo.Models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Alimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comida;

    private Long qtdDiaria;

    private String animal;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public Long getQtdDiaria() {
        return qtdDiaria;
    }

    public void setQtdDiaria(Long qtdDiaria) {
        this.qtdDiaria = qtdDiaria;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }
}
