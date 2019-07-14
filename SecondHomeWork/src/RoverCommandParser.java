import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoverCommandParser {
    private RoverCommand lastOp;
    private Deque<RoverCommand> cmdsStr = new ArrayDeque<>();


    public RoverCommandParser(Rover rover, String str){
        str = str.trim();
        for(String cmd : str.split(" ")){
            if(cmd.contains("move")){
                Pattern pattern = Pattern.compile("\\d+.{1}\\d+");
                Matcher m = pattern.matcher(cmd);
                String[] params = new String[2];
                while(m.find()){
                    params = cmd.substring(m.start(),m.end()).split(",");
                }
                lastOp = new MoveCommand(rover,Integer.parseInt(params[0]),Integer.parseInt(params[1]));
                cmdsStr.push(lastOp);
            }
            if(cmd.contains("turn")){
                Pattern pattern = Pattern.compile("[A-Z]+");
                Matcher m = pattern.matcher(cmd);
                Direction param = null;
                while(m.find()){
                    switch (cmd.substring(m.start(),m.end())){
                        case "WEST":
                            param = Direction.WEST;
                            break;
                        case "SOUTH":
                            param = Direction.SOUTH;
                            break;
                        case "EAST":
                            param = Direction.EAST;
                            break;
                        case "NORTH":
                            param = Direction.NORTH;
                            break;
                    }
                }
                lastOp = new TurnCommand(rover,param);
                cmdsStr.push(lastOp);
            }
            if(cmd.contains("log")){
                cmdsStr.push(new LoggingCommand(lastOp));
            }
            if(cmd.contains("import")){
                Pattern pattern = Pattern.compile("out.+.txt");
                Matcher m = pattern.matcher(cmd);
                String param = null;
                while(m.find()){
                    param = cmd.substring(m.start(),m.end());
                }
                lastOp = new ImportCommand(rover,param);
                cmdsStr.push(lastOp);
            }
        }
    }

    public RoverCommand readNextCommand(){
      return cmdsStr.pollLast();
    }

    public void executeAll(){
        while (!cmdsStr.isEmpty()){
            readNextCommand().execute();
        }
    }

}
