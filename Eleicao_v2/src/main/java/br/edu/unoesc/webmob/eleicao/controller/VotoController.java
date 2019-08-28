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

import br.edu.unoesc.webmob.eleicao.model.Voto;
import br.edu.unoesc.webmob.eleicao.service.VotoService;
import br.edu.unoesc.webmob.eleicao.service.CandidatoService;
import br.edu.unoesc.webmob.eleicao.service.EleitorService;

@Controller
@RequestMapping("/voto")
public class VotoController {

	@Autowired
	private VotoService votoService;
	
	//@Autowired
	private CandidatoService candidatoService;

	//@Autowired
	private EleitorService eleitorService;

	@PostMapping("/salvar")
	public String salvar(@Valid Voto voto, BindingResult erros) {
		if (erros.hasErrors()) {
			return "voto/novo";
		}
		votoService.salvar(voto);
		return "redirect:/voto/listar";
	}

	@PostMapping("/alterar")
	public String alterar(@Valid Voto voto, BindingResult erros) {
		if (erros.hasErrors()) {
			return "voto/visualizar";

		}
		votoService.salvar(voto);
		return "redirect:/voto/listar";
	}

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("votos", votoService.dadosGrid());
		// caminho + nome do JSP que será renderizado para a tela
		System.out.println("************!!!!!!!!!!!!!");
		return "voto/lista";
	}

	@GetMapping("/novo")
	public String novo(Model model) {
		//model.addAttribute("candidatos", candidatoService.listar());
		//model.addAttribute("eleitores", eleitorService.listar());
		//model.addAttribute("cargos", Arrays.asList(Cargo.values()));
		System.out.println("AAAAAAAAA");
		return "voto/novo";
	}

	/*@GetMapping("/deletar/{codigo}")
	public String deletar(@PathVariable("codigo") Integer codigo) {

			votoService.excluir(new Voto(codigo));
			return "redirect:/voto/listar";
		
	}*/

	@GetMapping("/visualizar/{codigo}")
	public String visualizar(@PathVariable("codigo") Integer codigo, Model model) {
		model.addAttribute("candidato", candidatoService.buscarPorCodigo(codigo));
		model.addAttribute("eleitores", eleitorService.listar());
		//model.addAttribute("cargos", Arrays.asList(Cargo.values()));
		return "voto/visualizar";
	}

	@GetMapping("/rest/urna/{urna}")
	@ResponseBody
	public List<Voto> listarPorUrna(@PathVariable("urna") Long urna) {
		System.out.println("antes listar urna");
		//return votoService.dadosGrid();
		return votoService.listarPorUrna(urna);
		//System.out.println("depois listar urna");
	}
	

	@GetMapping("/rest/codigoRegistro/{codigoRegistro}")
	@ResponseBody
	public List<Voto> listarPorCandidato(@PathVariable("codigoRegistro") Integer codigoRegistro) {
		System.out.println("TESTE");
		//return votoService.dadosGrid();
		return votoService.listarPorCandidato(codigoRegistro);
	}

}