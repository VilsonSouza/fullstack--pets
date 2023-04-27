package br.com.treinaweb.adote_um_pet.api.pet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import br.com.treinaweb.adote_um_pet.api.pet.Mappers.PetMapper;
import br.com.treinaweb.adote_um_pet.core.Repositories.PetRepository;
import br.com.treinaweb.adote_um_pet.api.pet.dtos.PetRequest;
import br.com.treinaweb.adote_um_pet.api.pet.dtos.PetResponse;

@Service
public class PetService {
    
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetMapper petMapper;

    @GetMapping("/api/pets")
    public List<PetResponse> findAll(){
        return petRepository.findAll()
        .stream()
        .map(petMapper::toResponse)
        .toList();
    }
    public PetResponse create(PetRequest petRequest){
        var petToCreate = petMapper.toModel(petRequest);
        var createdPet = petRepository.save(petToCreate);
        return petMapper.toResponse(createdPet);

    }
}
