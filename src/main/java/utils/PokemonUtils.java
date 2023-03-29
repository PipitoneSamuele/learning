package utils;

import entities.Pokemon;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;

public class PokemonUtils {

    public static Pokemon jsonToPokemonMap(JSONObject object) {
        return new Pokemon(object.getString("name"), object.getString("url"));
    }

    public static HttpRequest createGen1Request() throws URISyntaxException {
        return  HttpRequest
                .newBuilder()
                .uri(new URI(ConstantUtils.POKEMON_BASE_URI + "/pokemon?limit=151"))
                .GET()
                .build();
    }

}
