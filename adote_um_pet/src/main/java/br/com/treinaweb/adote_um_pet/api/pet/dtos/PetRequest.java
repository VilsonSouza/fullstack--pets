package br.com.treinaweb.adote_um_pet.api.pet.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetRequest {
    @NotNull
    @NotEmpty
    @Size(min=3, max =255)
    private String nome;

    @NotNull
    @NotEmpty
    @Size(min=3, max =255)
    private String historia;
    
    @NotNull
    @NotEmpty
    @Size(max =255)
    @URL
    private String foto;
}
