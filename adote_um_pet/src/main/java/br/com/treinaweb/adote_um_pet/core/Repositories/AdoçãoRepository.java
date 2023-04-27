package br.com.treinaweb.adote_um_pet.core.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.treinaweb.adote_um_pet.core.models.Adoção;

public interface AdoçãoRepository extends JpaRepository<Adoção, Long> {
    
}
