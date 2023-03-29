package externalResources;

import entities.Pokemon;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.PersistCSVUtils;
import utils.PokemonUtils;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class PokemonAPI {
    private boolean isGen1Cached;

    public PokemonAPI()  {
        isGen1Cached = false;
    }

    public List<Pokemon> getListOfGen1Pokemon() throws Exception {

        List<Pokemon> pokemons = new ArrayList<>();

        if(!isGen1Cached) {

            HttpRequest request = PokemonUtils.createGen1Request();
            HttpClient client = HttpClient.newHttpClient();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == 200) {

                JSONObject jsonResponse = new JSONObject(response.body());
                JSONArray jsonArrayOfPokemon = (JSONArray) jsonResponse.get("results");

                for(int i = 0; i < jsonArrayOfPokemon.length(); i++) {
                    pokemons.add(PokemonUtils.jsonToPokemonMap(jsonArrayOfPokemon.getJSONObject(i)));
                }

                this.isGen1Cached = true;

            } else {
                throw new Exception("Status != 200");
            }
        } else {
           pokemons = PersistCSVUtils.readPokemonCSV();
        }
        return pokemons;
    }

}
