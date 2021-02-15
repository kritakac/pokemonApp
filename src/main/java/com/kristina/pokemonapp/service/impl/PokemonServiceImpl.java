package com.kristina.pokemonapp.service.impl;

import com.kristina.pokemonapp.model.Pokemon;
import com.kristina.pokemonapp.repository.PokemonRepository;
import com.kristina.pokemonapp.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Override
    public List<Pokemon> getAllPokemons() {
        return pokemonRepository.findAll();
    }

    @Override
    public void savePokemon(Pokemon pokemon) {
        this.pokemonRepository.save(pokemon);
    }


}
