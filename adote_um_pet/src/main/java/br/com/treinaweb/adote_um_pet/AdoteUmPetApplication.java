package br.com.treinaweb.adote_um_pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.treinaweb.adote_um_pet.core.Repositories.PetRepository;
import br.com.treinaweb.adote_um_pet.core.models.Pet;

@SpringBootApplication
public class AdoteUmPetApplication implements CommandLineRunner {

	@Autowired
	private PetRepository petRepository;

	public static void main(String[] args) {
		SpringApplication.run(AdoteUmPetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		var pet= new Pet();
		pet.setNome("Cleiton");
		pet.setHistoria("Triste história");
		pet.setFoto("https://super.abril.com.br/wp-content/uploads/2018/05/filhotes-de-cachorro-alcanc3a7am-o-c3a1pice-de-fofura-com-8-semanas1.png");
		petRepository.save(pet);
	}

}
