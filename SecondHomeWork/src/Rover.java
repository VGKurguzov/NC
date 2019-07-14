import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Rover implements Moveable, Turnable, ProgramFileAware   {

    private GroundVisor groundVisor;
    private Direction direction;
    private int x,y;
    private RoverCommandParser roverCommandParser;


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

    @Override
    public void executeProgramFile(String str) {
        try(BufferedReader in = new BufferedReader(new FileReader(str))){
           StringBuilder commands = new StringBuilder();
           String line;
               while((line = in.readLine()) != null){

                   commands.append(line + " ");
               }
               roverCommandParser = new RoverCommandParser(this,commands.toString());
               roverCommandParser.executeAll();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
