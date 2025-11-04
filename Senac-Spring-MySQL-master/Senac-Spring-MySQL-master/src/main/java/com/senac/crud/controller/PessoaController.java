package com.senac.crud.controller;

import com.senac.crud.model.Pessoa;
import com.senac.crud.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pessoas", pessoaRepository.findAll());
        return "lista";
    }

    @GetMapping("/nova")
    public String novaPessoaForm(Model model) {
        model.addAttribute("pessoa", new Pessoa());
        return "form";
    }

    @PostMapping
    public String salvar(@ModelAttribute Pessoa pessoa) {
        pessoaRepository.save(pessoa);
        return "redirect:/pessoas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("pessoa", pessoa);
        return "form";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        pessoaRepository.deleteById(id);
        return "redirect:/pessoas";
    }
}
