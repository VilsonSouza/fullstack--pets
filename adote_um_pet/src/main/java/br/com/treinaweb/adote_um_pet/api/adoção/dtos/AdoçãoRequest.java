package br.com.treinaweb.adote_um_pet.api.adoção.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import br.com.treinaweb.adote_um_pet.api.pet.validators.PetExistisById;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
public class AdoçãoRequest {
 
    @NotNull
    @Email
    @Size(max =255)
    @NotEmpty
    private String email;

    @NotNull
    @Min(10)
    @Max(100)
    private BigDecimal valor;

    @NotNull
    @Positive
    @PetExistisById
    private Long petId;
}
