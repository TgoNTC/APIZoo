package com.example.Zoo.DTO;

import com.example.Zoo.Models.Animal;
import lombok.Data;


public record AlimentacaoDto(String comida, Long qtdDiaria, Animal animal) {

}
