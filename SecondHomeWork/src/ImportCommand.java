import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ImportCommand implements RoverCommand {

    private String nameF;
    RoverCommandParser roverCommandParser;

    public ImportCommand(Rover rover,String str) {
        this.nameF = str;
        StringBuilder commands = new StringBuilder();

        try(BufferedReader in = new BufferedReader(new FileReader(str))){
            String line;
            while((line = in.readLine()) != null){
                commands.append(line + " ");
            }

            System.out.println("File " + str + " is empty");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        roverCommandParser = new RoverCommandParser(rover,commands.toString());

    }

    @Override
    public void execute() {
        roverCommandParser.executeAll();
    }

    @Override
    public String toString() {
        return "operation - import(" + nameF + ")";
    }
}
