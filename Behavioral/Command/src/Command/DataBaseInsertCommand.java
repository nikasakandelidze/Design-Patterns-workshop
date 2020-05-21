package Command;

import Request.DataBase;

public class DataBaseInsertCommand implements Command {
    private DataBase dataBase;

    public DataBaseInsertCommand(DataBase dataBase){
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        dataBase.insertIntoDataBase();
    }
}
