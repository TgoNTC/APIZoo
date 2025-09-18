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
//    @ManyToMany
//    @JoinTable(
//            name="animal_cuidador",
//            joinColumns = @JoinColumn(name= "animal_id"),
//            inverseJoinColumns = @JoinColumn(name="cuidador_id")
//    )
//    private List<Cuidador> cuidadores;
    private String cuidador;
}
