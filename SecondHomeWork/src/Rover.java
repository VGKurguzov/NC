public class Rover implements Moveable, Turnable   {

    private GroundVisor groundVisor;
    private Direction direction;
    private int x,y;

    public Rover() {
        this.groundVisor = new GroundVisor();
    }

    public GroundVisor getVisor() {
        return groundVisor;
    }

    @Override
    public void move(int x, int y) throws GroundVisorException {
            groundVisor.hasObstacles(x,y);
            this.x = x;
            this.y = y;
        System.out.println("successful move on x: " + x + " ,y: " + y);

    }

    @Override
    public void turnTo(Direction direction) {
        this.direction=direction;
    }

    @Override
    public String toString() {
        return  "direction = " + direction +
                ",x = " + x +
                ",y = " + y;
    }
}
