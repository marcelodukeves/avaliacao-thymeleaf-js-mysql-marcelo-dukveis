package com.senac.crud.controller;

import com.senac.crud.model.Pessoa;
import com.senac.crud.repository.PessoaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaRepository repository;

    public PessoaController(PessoaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pessoas", repository.findAll());
        return "pessoas";
    }

    @PostMapping("/salvar")
    public String salvar(@RequestParam String nome, @RequestParam String email) {
        repository.save(new Pessoa(nome, email));
        return "redirect:/pessoas";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/pessoas";
    }
}
