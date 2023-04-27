package br.com.treinaweb.adote_um_pet.api.adoção.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.adote_um_pet.api.adoção.Services.AdoçãoService;
import br.com.treinaweb.adote_um_pet.api.adoção.dtos.AdoçãoRequest;
import br.com.treinaweb.adote_um_pet.api.adoção.dtos.AdoçãoResponse;


@RestController
@RequestMapping("/api/adoções")
public class AdoçãoController {
    @Autowired
    private AdoçãoService adoçãoService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AdoçãoResponse create( @RequestBody @Valid AdoçãoRequest adoçãoRequest){
        return adoçãoService.create(adoçãoRequest);
    }

    @GetMapping
    public List<AdoçãoResponse> findAll() {
        return adoçãoService.findAll();
    }
    
}
