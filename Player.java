public class Player {
    private String name;
    private Location currentLocation;
    private int strength; // Add a strength attribute

    public Player(String name) {
        this.name = name;
        this.strength = 10; // Default strength value
    }

    public String getName() {
        return name;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
