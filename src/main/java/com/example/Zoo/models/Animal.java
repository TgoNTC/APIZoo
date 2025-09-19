package com.example.Zoo.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String especie;
    private int idade;
    @ManyToOne
    @JoinColumn(name="habitat_id")
    private Habitat habitat;
    @ManyToOne
    @JoinColumn(name="cuidador_id")
    private Cuidador cuidador;
}
