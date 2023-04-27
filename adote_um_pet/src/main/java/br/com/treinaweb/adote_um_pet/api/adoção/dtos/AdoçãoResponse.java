package br.com.treinaweb.adote_um_pet.api.adoção.dtos;

import java.math.BigDecimal;

import br.com.treinaweb.adote_um_pet.api.pet.dtos.PetResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdoçãoResponse{

    private Long id;
    private String email;
    private BigDecimal valor;
    private PetResponse pet;
}