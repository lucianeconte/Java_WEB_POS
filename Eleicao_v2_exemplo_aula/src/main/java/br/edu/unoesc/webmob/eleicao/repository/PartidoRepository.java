package br.edu.unoesc.webmob.eleicao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.webmob.eleicao.model.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Integer> {
	public List<Partido> findByNomeLike(String nome);
	
	public List<Partido> findBySiglaLike(String sigla);

}
