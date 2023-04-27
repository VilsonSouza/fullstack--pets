package br.com.treinaweb.adote_um_pet.api.adoção.Mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.treinaweb.adote_um_pet.api.adoção.dtos.AdoçãoRequest;
import br.com.treinaweb.adote_um_pet.api.adoção.dtos.AdoçãoResponse;
import br.com.treinaweb.adote_um_pet.api.pet.Mappers.PetMapper;
import br.com.treinaweb.adote_um_pet.core.Repositories.PetRepository;
import br.com.treinaweb.adote_um_pet.core.models.Adoção;

@Component
public class AdoçãoMapper{
    @Autowired
    private PetRepository petRepository;
    
    @Autowired
    private PetMapper petMapper;

    public Adoção toModel(AdoçãoRequest adoçãoRequest){

        return Adoção.builder()
        .email(adoçãoRequest.getEmail())
        .valor(adoçãoRequest.getValor())
        .pet(petRepository.findByIdOrElseThrow(adoçãoRequest.getPetId()))
        .build();

    }

    public AdoçãoResponse toResponse(Adoção adoção){
        return AdoçãoResponse.builder()
        .id(adoção.getId())
        .email(adoção.getEmail())
        .valor(adoção.getValor())
        .pet(petMapper.toResponse(adoção.getPet()))
        .build();

    }
}