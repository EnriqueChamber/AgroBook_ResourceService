package es.agrobook.api.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import es.agrobook.api.model.location.ParcelaSigpac;
import es.agrobook.api.repository.ParcelaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParcelaService{
    
    private final ParcelaRepository parcelaRepository;


    

	public Optional<ParcelaSigpac> findById(Long id) {
		return parcelaRepository.findById(id);
	}

	public ParcelaSigpac saveAndFlush(ParcelaSigpac parcela) {
		return parcelaRepository.saveAndFlush(parcela);
	}
}
