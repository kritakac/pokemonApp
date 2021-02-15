package com.kristina.pokemonapp.service;

import com.kristina.pokemonapp.model.Pokemon;

import java.util.List;

public interface PokemonService {
    List<Pokemon> getAllPokemons();
    void savePokemon(Pokemon pokemon);
    Pokemon getPokemonById(long id);
}
