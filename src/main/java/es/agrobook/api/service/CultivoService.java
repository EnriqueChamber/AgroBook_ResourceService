package es.agrobook.api.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import es.agrobook.api.model.Cultivo;
import es.agrobook.api.repository.CultivoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CultivoService{
    
    private final CultivoRepository cultivoRepository;


    

	public Optional<Cultivo> findById(Long id) {
		return cultivoRepository.findById(id);
	}

	public Cultivo saveAndFlush(Cultivo cultivo) {
		return cultivoRepository.saveAndFlush(cultivo);
	}
}
