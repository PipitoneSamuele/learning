import entities.Pokemon;
import externalResources.PokemonAPI;

import java.util.List;

public class Main {

    public static void main(String []args) throws Exception {

        PokemonAPI pokemonAPI = new PokemonAPI();
        List<Pokemon> pokemons = pokemonAPI.getListOfGen1Pokemon();
        printList(pokemons);

    }

    public static void printList(List<?> list) {
        for (Object o : list) {
            System.out.println(o.toString());
        }
    }

}
