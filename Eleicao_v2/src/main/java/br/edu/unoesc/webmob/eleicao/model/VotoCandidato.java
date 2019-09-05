package br.edu.unoesc.webmob.eleicao.model;

public class VotoCandidato {

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	private Long total;
	private Candidato candidato;

	public VotoCandidato(Candidato candidato, Long total) {
		this.candidato = candidato;
		this.total = total;
	}

}
