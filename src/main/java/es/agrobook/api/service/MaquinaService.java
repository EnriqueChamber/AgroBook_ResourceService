package es.agrobook.api.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import es.agrobook.api.model.Maquina;
import es.agrobook.api.repository.MaquinaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MaquinaService{
    
    private final MaquinaRepository maquinaRepository;


    

	public Optional<Maquina> findById(Long id) {
		return maquinaRepository.findById(id);
	}

	public Maquina saveAndFlush(Maquina maquina) {
		return maquinaRepository.saveAndFlush(maquina);
	}
}
