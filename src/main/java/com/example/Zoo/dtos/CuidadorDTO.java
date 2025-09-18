package com.example.Zoo.dtos;

import lombok.Data;

@Data
public class CuidadorDTO {

    private Long id;
    private String nome;
    private String especialidade;
    private String turnoDeTrabalho;
}
