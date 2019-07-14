public class Main {
    public static void main(String[] args) {
        Rover rover = new Rover();
        rover.getVisor().setGround(new Ground(19,21));
        System.out.println("---------");
        rover.turnTo(Direction.WEST);
        System.out.println(rover);
        System.out.println("---------");
        if (!rover.getVisor().hasObstacles(8,8))
            rover.move(8,8);
        if (!rover.getVisor().hasObstacles(6,7))
            rover.move(6,7);
        System.out.println("---------");

        rover.executeProgramFile("out1.txt");
        System.out.println(rover);
    }
}
