package br.edu.unoesc.webmob.eleicao.service;

import java.util.List;

import br.edu.unoesc.webmob.eleicao.model.Voto;
import br.edu.unoesc.webmob.eleicao.model.VotoCandidato;

public interface VotoService {
	public void salvar(Voto voto);
	public void excluir(Voto voto);
	public List<Voto> listarPorUrna(Long urna);
	public Integer totalPorCandidato(Integer codigoRegistro);
	public List<Voto> listarPorCandidato(Integer codigoRegistro);
	public List<Voto> dadosGrid();
	public List<VotoCandidato>contaVotosPorCandidato();

}
