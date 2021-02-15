package com.kristina.pokemonapp.service.impl;

import com.kristina.pokemonapp.model.Pokemon;
import com.kristina.pokemonapp.repository.PokemonRepository;
import com.kristina.pokemonapp.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Pokemon getPokemonById(long id) {
        Optional<Pokemon> optional = pokemonRepository.findById(id);
        Pokemon pokemon = null;
        if(optional.isPresent()) {
            pokemon = optional.get();
        }else {
            throw new RuntimeException(" Pokemon not found for id :: " + id);
        }
        return pokemon;
    }


}
