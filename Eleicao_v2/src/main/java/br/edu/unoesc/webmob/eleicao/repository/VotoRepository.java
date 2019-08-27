package br.edu.unoesc.webmob.eleicao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.unoesc.webmob.eleicao.model.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long> {
	public List<Voto> findByUrnaLike(Long urna);
	
	@Query("select count(v) from Voto v where v.candidato = :candidato")
	List<Voto> porCandidato(@Param("candidato") Integer candidato);
}
