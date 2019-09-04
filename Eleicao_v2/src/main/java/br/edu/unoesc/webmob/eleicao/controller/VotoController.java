package br.edu.unoesc.webmob.eleicao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.unoesc.webmob.eleicao.model.Voto;
import br.edu.unoesc.webmob.eleicao.service.VotoService;
import br.edu.unoesc.webmob.eleicao.service.CandidatoService;
import br.edu.unoesc.webmob.eleicao.service.EleitorService;

@Controller
@RequestMapping("/voto")
public class VotoController {

	@Autowired
	private VotoService votoService;
	
	@Autowired
	private CandidatoService candidatoService;

	@Autowired
	private EleitorService eleitorService;

	@PostMapping("/salvar")
	public String salvar(@Valid Voto voto, BindingResult erros) {
		if (erros.hasErrors()) {
			return "voto/novo";
		}
		votoService.salvar(voto);
		return "voto/votoFinalizado";
	}
	
	@GetMapping("/listar/{codigoRegistro}")
	public String codigoRegistro(@PathVariable Integer codigoRegistro, Model model) {
		System.out.println("**** Total por candidato *********");
		int total = votoService.totalPorCandidato(codigoRegistro);
		model.addAttribute("total", total);
		System.out.println("Total = " + total);
		return "voto/listarPorCandidato";
	}

	@GetMapping("/listarGeral")
	public String listar(Model model) {
		model.addAttribute("votos", votoService.dadosGrid());
		return "voto/lista";
	}

	@GetMapping("/novo")
	public String novo(Model model) {
		model.addAttribute("candidatos", candidatoService.listar());
		model.addAttribute("eleitores", eleitorService.listar());
		return "voto/novo";
	}

	@GetMapping("/rest/urna/{urna}")
	@ResponseBody
	public List<Voto> listarPorUrna(@PathVariable("urna") Long urna) {
		return votoService.listarPorUrna(urna);
	}
	

	@GetMapping("/rest/codigoRegistro/{codigoRegistro}")
	@ResponseBody
	public List<Voto> listarPorCandidato(@PathVariable("codigoRegistro") Integer codigoRegistro) {
		return votoService.listarPorCandidato(codigoRegistro);
	}
	
	@GetMapping("/rest/totalCandidato/{codigoRegistro}")
	@ResponseBody
	public Integer totalPorCandidato(@PathVariable("codigoRegistro") Integer codigoRegistro) {
		return votoService.totalPorCandidato(codigoRegistro);
	}

}