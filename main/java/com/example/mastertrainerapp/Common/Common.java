package com.example.mastertrainerapp.Common;

import com.example.mastertrainerapp.Model.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Common {
    public static List<Pokemon> commonPokemonList;

    public static List<Pokemon> getList() {
        if (commonPokemonList == null)
            commonPokemonList = new ArrayList<>();
        return commonPokemonList;
    }
}
