package br.net.sq.cartas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.net.sq.cartas.models.Carta;
import br.net.sq.cartas.repositories.CartaRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CartaService {
	
	@Autowired
	private CartaRepository cartaRepository;
	
	
	
	public Carta buscar(Integer id) {
		Optional<Carta> carta = cartaRepository.findById(id);		
		return carta.orElse(null);
	}
	
	public List<Carta> listarTodasCartas() {
		List<Carta> cartas = cartaRepository.findAll();
		return cartas;
	}
	
	public Carta inserirCarta(Carta carta) {
		carta.setId(null);
		return cartaRepository.save(carta);
	}
	
	public Carta atualizarCarta(Carta carta) {	
		return cartaRepository.save(carta);
	}
	
	public void deletarCarta(Integer id){
		
		cartaRepository.deleteById(id);
		
	}
	
}
