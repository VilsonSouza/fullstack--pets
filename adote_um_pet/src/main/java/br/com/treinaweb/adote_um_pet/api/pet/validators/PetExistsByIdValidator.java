package br.com.treinaweb.adote_um_pet.api.pet.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.treinaweb.adote_um_pet.core.Repositories.PetRepository;

@Component
public class PetExistsByIdValidator implements ConstraintValidator <PetExistisById, Long>{

    @Autowired
    private PetRepository petRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
       if(value == null){
        return true;
       }
       return petRepository.existsById(value);
    }
    
}
