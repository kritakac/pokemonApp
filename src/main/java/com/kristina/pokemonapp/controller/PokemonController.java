package com.kristina.pokemonapp.controller;

import com.kristina.pokemonapp.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listPokemons", pokemonService.getAllPokemons());
        return "index";
    }
}
