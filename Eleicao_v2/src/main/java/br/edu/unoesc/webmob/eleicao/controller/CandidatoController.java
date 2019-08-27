package br.edu.unoesc.webmob.eleicao.controller;

import java.util.Arrays;
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

import br.edu.unoesc.webmob.eleicao.model.Candidato;
import br.edu.unoesc.webmob.eleicao.model.Cargo;
import br.edu.unoesc.webmob.eleicao.service.CandidatoService;
import br.edu.unoesc.webmob.eleicao.service.PartidoService;

@Controller
@RequestMapping("/candidato")
public class CandidatoController {

	@Autowired
	private CandidatoService candidatoService;

	@Autowired
	private PartidoService partidoService;

	@PostMapping("/salvar")
	public String salvar(@Valid Candidato candidato, BindingResult erros) {
		if (erros.hasErrors()) {
			return "candidato/novo";
		}
		candidatoService.salvar(candidato);
		return "redirect:/candidato/listar";
	}

	@PostMapping("/alterar")
	public String alterar(@Valid Candidato candidato, BindingResult erros) {
		if (erros.hasErrors()) {
			return "candidato/visualizar";

		}
		candidatoService.salvar(candidato);
		return "redirect:/candidato/listar";
	}

	@GetMapping("/listar")
	public String listar(Model model) {
		// Torna a lista de pessoa acessível no JSP
		model.addAttribute("candidatos", candidatoService.dadosGrid());
		// caminho + nome do JSP que será renderizado para a tela
		return "candidato/lista";
	}

	@GetMapping("/novo")
	public String novo(Model model) {
		model.addAttribute("partidos", partidoService.listar());
		model.addAttribute("cargos", Arrays.asList(Cargo.values()));
		return "candidato/novo";
	}

	@GetMapping("/deletar/{codigo}")
	public String deletar(@PathVariable("codigo") Integer codigo) {
		candidatoService.excluir(new Candidato(codigo));
		return "redirect:/candidato/listar";
	}

	@GetMapping("/visualizar/{codigo}")
	public String visualizar(@PathVariable("codigo") Integer codigo, Model model) {
		model.addAttribute("candidato", candidatoService.buscarPorCodigo(codigo));
		model.addAttribute("partidos", partidoService.listar());
		model.addAttribute("cargos", Arrays.asList(Cargo.values()));
		return "candidato/visualizar";
	}

	@GetMapping("/rest/nome/{nome}")
	@ResponseBody
	public List<Candidato> listarPorNome(@PathVariable("nome") String nome) {
		return candidatoService.listarPorNome(nome);
	}

	@GetMapping("/rest/cpf/{cpf}")
	@ResponseBody
	public List<Candidato> listarPorCPF(@PathVariable("cpf") Long cpf) {
		return candidatoService.listarPorCPF(cpf);
	}

}
