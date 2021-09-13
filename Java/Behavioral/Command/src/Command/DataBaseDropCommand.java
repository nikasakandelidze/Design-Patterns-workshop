package Command;

import Request.DataBase;

public class DataBaseDropCommand implements Command{
    private DataBase dataBase;

    public DataBaseDropCommand(DataBase dataBase){
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        dataBase.dropDataBase();
    }
}
