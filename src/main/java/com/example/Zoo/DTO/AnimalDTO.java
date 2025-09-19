package com.example.Zoo.DTO;

import com.example.Zoo.Models.Cuidador;
import com.example.Zoo.Models.Habitat;

public record AnimalDTO(String nome, String especie, int idade, Habitat habitat, Cuidador cuidador) {
}
