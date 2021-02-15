package com.kristina.pokemonapp.controller;

import com.kristina.pokemonapp.model.Pokemon;
import com.kristina.pokemonapp.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listPokemons", pokemonService.getAllPokemons());
        return "index";
    }

    @GetMapping("/showNewPokemonForm")
    public String showNewPokemonForm(Model model) {
        // create model attribute to bind form data
        Pokemon pokemon = new Pokemon();
        model.addAttribute("pokemon", pokemon);
        return "new_pokemon";
    }

    @PostMapping("/savePokemon")
    public String saveEmployee(@ModelAttribute("pokemon") Pokemon pokemon) {
        // save employee to database
        pokemonService.savePokemon(pokemon);
        return "redirect:/";
    }

    @GetMapping("showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {

        // get pokemon from the service
        Pokemon pokemon = pokemonService.getPokemonById(id);
        // set pokemon as a model attribute to pre-populate the form
        model.addAttribute("pokemon", pokemon);
        return "update_pokemon";
    }
}
