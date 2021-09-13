package Command;

import Request.DataBase;

public class DataBaseSelectCommand implements Command {

    private DataBase dataBase;

    public DataBaseSelectCommand(DataBase dataBase){
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        dataBase.selectFromDataBase();
    }
}
