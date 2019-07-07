public class Main {
    public static void main(String[] args) {
        Rover rover = new Rover();
        rover.move(23,7);
        rover.turnTo(Direction.WEST);
        System.out.println(rover);
    }
}
