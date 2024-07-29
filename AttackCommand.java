public class AttackCommand extends Command {
    private Character target;

    public AttackCommand(String name, String description, Character target) {
        super(name, description);
        this.target = target;
    }

    @Override
    public void execute(Game game, String... args) {
        Location currentLocation = game.getCurrentLocation();
        if (currentLocation == null) {
            System.out.println("No current location set.");
            return;
        }

        if (target != null && target.isHostile()) {
            Player player = game.getPlayer();
            int attackStrength = player.getStrength(); // Assume player has a strength attribute

            System.out.println("Attacking " + target.getName() + " with strength " + attackStrength);

            target.takeDamage(attackStrength);

            if (target.getHealth() <= 0) {
                System.out.println(target.getName() + " has been defeated!");
                currentLocation.getCharacters().remove(target);
            } else {
                System.out.println(target.getName() + " has " + target.getHealth() + " health remaining.");
            }
        } else {
            System.out.println("No target to attack or target is not hostile.");
        }
    }

    public void setTarget(Character target) {
        this.target = target;
    }
}
