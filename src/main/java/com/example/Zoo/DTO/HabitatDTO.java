package com.example.Zoo.DTO;

import com.example.Zoo.Models.TipoHabitat;

public record HabitatDTO(String nome, TipoHabitat tipo, int capacidadeMaxAnimais ) {
}
