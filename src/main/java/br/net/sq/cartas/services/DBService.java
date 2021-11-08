package br.net.sq.cartas.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.net.sq.cartas.models.Carta;
import br.net.sq.cartas.models.Classe;
import br.net.sq.cartas.models.Tipo;
import br.net.sq.cartas.repositories.CartaRepository;

@Service
public class DBService {
	
	@Autowired
	private CartaRepository cartaRepository;
	
	public void instantiateTestDatabase() {
		
		Carta carta1 = new Carta(null, "As de Copas", "Primeira carta", 1, 2, Tipo.MAGIA, Classe.PALADINO);
		Carta carta2 = new Carta(null, "As de Paus", "Segunda carta", 3, 4, Tipo.MAGIA, Classe.PALADINO);
		cartaRepository.saveAll(Arrays.asList(carta1, carta2));
		
	}
	
}
