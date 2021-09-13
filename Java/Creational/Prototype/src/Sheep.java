public class Sheep implements Cloneable {
    private String name;
    private String surName;

    public Sheep(String name,String surName){
        this.name = name;
        this.surName = surName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    @Override
    public Sheep clone() throws CloneNotSupportedException {
        return (Sheep)super.clone();
    }


    @Override
    public String toString(){
        return name+","+surName;
    }
}
