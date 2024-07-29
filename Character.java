import java.util.ArrayList;
import java.util.List;

public class Character {
    private String name;
    private String description;
    private int health;
    private boolean hostile;
    private List<String> dialogue;
    private List<Item> inventory;

    public Character(String name, String description) {
        this.name = name;
        this.description = description;
        this.health = 100; // Default health value
        this.hostile = false;
        this.dialogue = new ArrayList<>();
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0;
    }

    public boolean isHostile() {
        return hostile;
    }

    public void setHostile(boolean hostile) {
        this.hostile = hostile;
    }

    public List<String> getDialogue() {
        return dialogue;
    }

    public List<Item> getInventory() {
        return inventory;
    }
}
