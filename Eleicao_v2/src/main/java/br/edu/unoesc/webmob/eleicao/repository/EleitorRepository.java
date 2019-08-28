package br.edu.unoesc.webmob.eleicao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.unoesc.webmob.eleicao.model.Eleitor;

public interface EleitorRepository extends JpaRepository<Eleitor, Long> {
	public List<Eleitor> findByNomeLike(String nome);
	public List<Eleitor> findByNomeMaeLike(String nomeMae);
	
	@Query("select z from Eleitor z where z.zonaEleitoral = :zonaEleitoral")
	List<Eleitor> porZonaEleitoral(@Param("zonaEleitoral") Short zonaEleitoral);
	
	@Query("select s from Eleitor s where s.secao = :secao")
	List<Eleitor> porSecao(@Param("secao") Short secao);
	
	@Query("select p from Eleitor p where p.numeroTitulo = :numeroTitulo")
	List<Eleitor> porNumeroTitulo(@Param("numeroTitulo") Long numeroTitulo);
	
}
