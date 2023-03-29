package utils;

import entities.Pokemon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersistCSVUtils {

    public static List<Pokemon> readPokemonCSV() throws FileNotFoundException {

        List<Pokemon> pokemons = new ArrayList<>();

        File pokemonCSV = new File("C:\\Users\\samue\\OneDrive\\Desktop\\projects\\learning\\src\\main\\resources\\pokemons.csv");
        Scanner scanner = new Scanner(pokemonCSV);
        scanner.useDelimiter(",");

        while(scanner.hasNext()) {
            Pokemon pokemon = new Pokemon();
            pokemon.setName(scanner.next());
            pokemon.setUrl(scanner.next());
            pokemons.add(pokemon);
        }
        return pokemons;
    }

    public static void writePokemonCSV(List<Pokemon> pokemons) throws IOException {

        FileWriter writer = new FileWriter("C:\\Users\\samue\\OneDrive\\Desktop\\projects\\learning\\src\\main\\resources\\pokemons.csv");

        pokemons.forEach(pokemon -> {
            try {
                writer.append(pokemon.getName());
                writer.append(",");
                writer.append(pokemon.getUrl());
                writer.append("\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        writer.flush();
        writer.close();
    }

}
