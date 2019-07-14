public class LoggingCommand implements RoverCommand {

    private RoverCommand command;

    public LoggingCommand(RoverCommand command) {
        this.command = command;
    }

    @Override
    public void execute() {
        System.out.println(command);
    }

    @Override
    public String toString() {
        return "operation - log";
    }
}
