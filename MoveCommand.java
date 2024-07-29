public class MoveCommand extends Command {
    private Location destination;

    public MoveCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(Game game, String... args) {
        if (args.length > 0) {
            String locationName = args[0];
            Location newLocation = game.getCurrentLocation().getConnectedLocations().get(locationName);
            if (newLocation != null) {
                game.getPlayer().setCurrentLocation(newLocation);
                game.setCurrentLocation(newLocation);
                System.out.println("Moved to " + newLocation.getName());
            } else {
                System.out.println("Location not found.");
            }
        } else {
            System.out.println("No location specified.");
        }
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }
}
