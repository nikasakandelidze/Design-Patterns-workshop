package Invoker;

import Command.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {
    private List<Command> historyOfCommands = new ArrayList<>();

    public CommandInvoker(){ }

    public void execute(Command command){
        historyOfCommands.add(command);
        command.execute();
    }

    public void redoAllHistoryCommands(){
        historyOfCommands.forEach(Command::execute);
    }
}
