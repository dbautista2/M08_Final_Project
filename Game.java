import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private Map<String, Command> commands;
    private Player player;
    private Location currentLocation;

    public Game() {
        this.commands = new HashMap<>();
        initializeGame();
    }

    private void initializeGame() {
        // Create locations
        Location forest = new Location("Forest", "A dense forest with tall trees.");
        Location cave = new Location("Cave", "A damp and dark cave.");
        Location village = new Location("Village", "A small, peaceful village.");

        // Connect locations
        forest.getConnectedLocations().put("cave", cave);
        cave.getConnectedLocations().put("forest", forest);
        village.getConnectedLocations().put("forest", forest);

        // Create player
        this.player = new Player("Hero");
        this.player.setCurrentLocation(forest);
        this.currentLocation = forest; // Set the current location of the game

        // Create characters
        Character goblin = new Character("Goblin", "A small green creature");
        goblin.setHostile(true);
        Character troll = new Character("Troll", "A large, brutish troll");
        troll.setHostile(true);
        Character villager = new Character("Villager", "A friendly villager");
        villager.setHostile(false);

        // Add characters to locations
        forest.getCharacters().add(goblin);
        cave.getCharacters().add(troll);
        village.getCharacters().add(villager);

        // Create items
        Item sword = new Item("Sword", "A shiny sword.");
        Item healingPotion = new Item("Healing Potion", "Restores health.");
        Item goldCoin = new Item("Gold Coin", "A shiny gold coin.");

        // Add items to locations
        forest.getItems().add(sword);
        cave.getItems().add(healingPotion);
        village.getItems().add(goldCoin);

        // Initialize commands
        this.commands.put("move", new MoveCommand("Move", "Move to a new location"));
        this.commands.put("attack", new AttackCommand("Attack", "Attack an enemy", goblin));
    }

    public void executeCommand(String commandName, String... args) {
        Command command = commands.get(commandName);
        if (command != null) {
            command.execute(this, args);
        } else {
            System.out.println("Invalid command.");
        }
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }

    public Player getPlayer() {
        return player;
    }

    public void showGameStatus() {
        if (player != null) {
            System.out.println("Current location: " + player.getCurrentLocation().getName());
        } else {
            System.out.println("Player not initialized.");
        }
    }

    public void start() {
        System.out.println("Game has started!");
        showGameStatus();
    }

    public List<String> getAvailableLocations() {
        List<String> locations = new ArrayList<>();
        for (String locationName : player.getCurrentLocation().getConnectedLocations().keySet()) {
            locations.add(locationName);
        }
        return locations;
    }

    public List<String> getAvailableCommands() {
        List<String> commandNames = new ArrayList<>();
        for (String commandName : commands.keySet()) {
            commandNames.add(commandName);
        }
        return commandNames;
    }
}
