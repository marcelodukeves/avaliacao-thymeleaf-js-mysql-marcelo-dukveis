package com.example.demo.controller;

import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaRepository repository;

    public PessoaController(PessoaRepository repository) {
        this.repository = repository;
    }

    @GetMapping({"", "/"})
    public String listar(Model model) {
        model.addAttribute("pessoas", repository.findAll());
        model.addAttribute("pessoa", new Pessoa());
        return "index";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute Pessoa pessoa, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("pessoas", repository.findAll());
            return "index";
        }
        repository.save(pessoa);
        return "redirect:/pessoas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Pessoa p = repository.findById(id).orElse(null);
        model.addAttribute("pessoa", p != null ? p : new Pessoa());
        model.addAttribute("pessoas", repository.findAll());
        return "index";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/pessoas";
    }
}
