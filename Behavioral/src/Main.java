import Command.DataBaseDropCommand;
import Command.DataBaseInsertCommand;
import Command.DataBaseSelectCommand;
import Command.DataBaseUpdateCommand;
import Invoker.CommandInvoker;
import Request.DataBase;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        CommandInvoker commandInvoker = new CommandInvoker();
        commandInvoker.execute(new DataBaseDropCommand(dataBase));
        commandInvoker.execute(new DataBaseInsertCommand(dataBase));
        commandInvoker.execute(new DataBaseInsertCommand(dataBase));
        commandInvoker.execute(new DataBaseUpdateCommand(dataBase));
        commandInvoker.execute(new DataBaseSelectCommand(dataBase));

        System.out.println("Now redoing whole history of commands once again");
        commandInvoker.redoAllHistoryCommands();
    }
}
