package br.edu.unoesc.webmob.eleicao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.unoesc.webmob.eleicao.model.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long> {
	public List<Voto> findByUrnaLike(Long urna);
	
	@Query("select v from Voto v where v.urna = :urna")
	List<Voto> porUrna(@Param("urna") Long urna);
	
	//@Query("select count(v) from Voto v where v.candidato = :candidato")
	@Query("select count(v) from Voto v inner join v.candidato where v.candidato.codigoRegistro = :codigoRegistro")
	Integer totalPorCandidato(@Param("codigoRegistro") Integer codigoRegistro);
	
	@Query("select v from Voto v inner join fetch v.candidato where v.candidato.codigoRegistro = :codigoRegistro")
	List<Voto> listarPorCandidato(@Param("codigoRegistro") Integer codigoRegistro);
	
	@Query("select v from Voto v inner join fetch v.eleitor")
	List<Voto> dadosGrid();
}
