package br.com.treinaweb.adote_um_pet.api.adoção.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinaweb.adote_um_pet.api.adoção.Mappers.AdoçãoMapper;
import br.com.treinaweb.adote_um_pet.api.adoção.dtos.AdoçãoRequest;
import br.com.treinaweb.adote_um_pet.api.adoção.dtos.AdoçãoResponse;
import br.com.treinaweb.adote_um_pet.core.Repositories.AdoçãoRepository;

@Service
public class AdoçãoService {
    
    @Autowired
    private AdoçãoRepository adoçãoRepository;

    @Autowired
    private AdoçãoMapper adoçãoMapper;

    public AdoçãoResponse create(AdoçãoRequest adoçãoRequest){
        var adoçãoToCreate = adoçãoMapper.toModel(adoçãoRequest);
        var createdAdoção = adoçãoRepository.save(adoçãoToCreate);
        return adoçãoMapper.toResponse(createdAdoção);

    }
    public List<AdoçãoResponse> findAll(){
        return adoçãoRepository.findAll()
        .stream()
        .map(adoçãoMapper::toResponse)
        .toList();
    }
}
