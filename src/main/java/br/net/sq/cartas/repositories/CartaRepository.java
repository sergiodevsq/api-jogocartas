package br.net.sq.cartas.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.net.sq.cartas.models.Carta;

@Repository
public interface CartaRepository extends JpaRepository<Carta, Integer>  {

}
