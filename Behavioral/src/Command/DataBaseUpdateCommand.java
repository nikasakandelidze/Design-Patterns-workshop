package Command;

import Command.Command;
import Request.DataBase;

public class DataBaseUpdateCommand implements Command {
    private DataBase dataBase;

    public DataBaseUpdateCommand(DataBase dataBase){
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        dataBase.updateInDataBase();
    }
}
