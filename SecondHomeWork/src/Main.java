public class Main {
    public static void main(String[] args) {
        Rover rover = new Rover();
        rover.getVisor().setGround(new Ground(8,8));
        rover.turnTo(Direction.WEST);
        System.out.println(rover);

        if (!rover.getVisor().hasObstacles(8,8))
            rover.move(8,8);
        if (!rover.getVisor().hasObstacles(6,7))
            rover.move(6,7);

        rover.move(9,9);

    }
}
