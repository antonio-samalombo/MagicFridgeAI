package dev.samalombo.MagicFridgeAI.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FooditemDTO {

    private Long id;
    private String nome;
    private String categoria;
    private Integer quantidade;
    private LocalDate validade;



}
