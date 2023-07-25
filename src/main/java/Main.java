import entities.Pokemon;
import externalResources.PokemonAPI;

import java.util.List;

public class Main {

    public static void main(String []args) throws Exception {
/*
        PokemonAPI pokemonAPI = new PokemonAPI();
        List<Pokemon> pokemons = pokemonAPI.getListOfGen1Pokemon();
        printList(pokemons);
*/
        String[] strings = {"maio", "maco", "mico", "calo", "cica"};
        closestSubstring(2, strings, strings[0]);
    }

    public static String closestSubstring(int d, String[] strings, String currentString) {

        int closeString = 0;

        if(d < 0) return "not found";

        for(int i = 0; i < strings.length; i++) {
            for(int j = 0; j < strings.length; j++) {
                if(i != j && hammingDistance(strings[i], strings[j]) > d+1) return "not found";
                else if (i != j && hammingDistance(strings[i], strings[j]) < d) closeString += 1;
            }
        }

        if(closeString == strings.length) return currentString;



        return null;
    }

    public static int hammingDistance(String s1, String s2) {
        int distance = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) distance += 1;
        }
        return distance;
    }

    public static void printList(List<?> list) {
        for (Object o : list) {
            System.out.println(o.toString());
        }
    }

}
