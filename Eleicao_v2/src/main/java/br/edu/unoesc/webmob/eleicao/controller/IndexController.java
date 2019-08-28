package br.edu.unoesc.webmob.eleicao.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(Model model) {
		List<String> nomes = new ArrayList<String>();
		nomes.add("Maria");
		nomes.add("Nome 2");
		nomes.add("Nome 3");

		model.addAttribute("nomes", nomes);

		return "index";
	}

	@RequestMapping("/teste")
	public String teste(Model model) {
		return "index";
	}

	@GetMapping("/variavel/{nome}")
	public String variavel(@PathVariable String nome, Model model) {
		model.addAttribute("nome", nome.toUpperCase());
		return "index";
	}

	@PostMapping("/variavelpost/")
	public String variavelpost(@RequestParam String nome, Model model) {
		model.addAttribute("nome", nome.toUpperCase());
		return "index";
	}

	@GetMapping("/rest/nomes")
	@ResponseBody
	public List<String> getNomes() {
		List<String> nomes = new ArrayList<String>();
		nomes.add("Luciane");
		nomes.add("Nome 2");
		nomes.add("Nome 3");
		return nomes;
	}

}