package br.edu.unoesc.webmob.eleicao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.unoesc.webmob.eleicao.model.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {
	public List<Candidato> findByNomeLike(String nome);

	@Query("select p from Candidato p where p.cpf = :cpf")
	List<Candidato> porCpf(@Param("cpf") Long cpf);

	@Query("select p from Candidato p inner join fetch p.partido")
	List<Candidato> dadosGrid();
	
//	@Modifying
//	@Query("update Candidato p set p.nome = ?1 where p.codigoRegistro = ?2")
//	void alteracao(String nome, Integer userId);
}
