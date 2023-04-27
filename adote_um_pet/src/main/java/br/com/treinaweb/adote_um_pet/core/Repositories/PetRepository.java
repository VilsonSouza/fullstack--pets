package br.com.treinaweb.adote_um_pet.core.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.adote_um_pet.core.exceptions.PetNotFoundException;
import br.com.treinaweb.adote_um_pet.core.models.Pet;

public interface PetRepository extends JpaRepository<Pet,Long> {
    
    default Pet findByIdOrElseThrow(Long id){
       
        return findById(id)
            .orElseThrow(PetNotFoundException::new);
        
    }
}
