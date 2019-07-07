public class Rover implements Moveable, Turnable   {

    private Direction direction;
    private int x,y;


    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
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
