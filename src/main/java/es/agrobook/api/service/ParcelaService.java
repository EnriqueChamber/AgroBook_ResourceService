package es.agrobook.api.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import es.agrobook.api.model.Parcela;
import es.agrobook.api.repository.ParcelaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParcelaService{
    
    private final ParcelaRepository parcelaRepository;


    

	public Optional<Parcela> findById(Long id) {
		return parcelaRepository.findById(id);
	}

	public Parcela saveAndFlush(Parcela parcela) {
		return parcelaRepository.saveAndFlush(parcela);
	}
}
