import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Location {
    private String name;
    private String description;
    private Map<String, Location> connectedLocations;
    private List<Character> characters;
    private List<Item> items;

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
        this.connectedLocations = new HashMap<>();
        this.characters = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Location> getConnectedLocations() {
        return connectedLocations;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public List<Item> getItems() {
        return items;
    }
}
