public class MoveCommand implements RoverCommand {

   private Moveable moveable;
   private int x;
   private int y;

    @Override
    public void execute() {
        moveable.move(this.x,this.y);
    }

    public MoveCommand(Moveable moveable, int x, int y) {
        this.moveable = moveable;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "operation - move(" + x + "," + y + ")";
    }
}
