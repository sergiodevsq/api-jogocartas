package br.net.sq.cartas.resources;

import java.net.URI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.net.sq.cartas.models.Carta;
import br.net.sq.cartas.services.CartaService;

@RestController
@RequestMapping(value="/cartas")
public class CartaResource {

	@Autowired
	private CartaService cartaService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Carta> listarCartas(){
		List<Carta> listaCartas = cartaService.listarTodasCartas();
		return listaCartas;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> listarCartaPorId(@PathVariable Integer id) {
		Carta carta = cartaService.buscar(id);
		return ResponseEntity.ok().body(carta);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> inserirCarta(@RequestBody Carta carta){
		carta = cartaService.inserirCarta(carta);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(carta.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> atualizarCarta(@RequestBody Carta carta, @PathVariable Integer id){
		Carta ct = cartaService.buscar(id);
		if(ct != null) {
			ct.setAtaque(carta.getAtaque());
			ct.setClasse(carta.getClasse());
			ct.setDefesa(carta.getDefesa());
			ct.setDescricao(carta.getDescricao());
			ct.setNome(carta.getNome());
			ct.setTipo(carta.getTipo());
			carta = cartaService.atualizarCarta(ct);
		}
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletarCarta(@PathVariable Integer id){
		Carta ct = cartaService.buscar(id);
		if(ct != null) {
			cartaService.deletarCarta(id);
		}
		return ResponseEntity.noContent().build();
	}
	
	
}
