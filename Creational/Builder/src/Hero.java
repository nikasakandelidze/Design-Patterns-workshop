//So let's assume that name and surname are two must have parameters other parameters are willingly.
public class Hero {
    private final String name;
    private final String surName;
    private final Integer height;
    private final Integer weight;
    private final Integer age;
    private final Integer numWeapons;


    //!!!!!!!!!!!!!!!!!!!BAD!!!!!!!!!!!!!!!!!!!!!!
//    public Hero(String name, String surName, Integer height, Integer weight, Integer age, Integer numWeapons) {
//        this.name = name;
//        this.surName = surName;
//        this.height = height;
//        this.weight = weight;
//        this.age = age;
//        this.numWeapons = numWeapons;
//    }

    private Hero(Builder builder){
        age = builder.age;
        height = builder .height;
        name = builder.name;
        weight = builder.weight;
        numWeapons = builder.numWeapons;
        surName = builder.surName;
    }

    public static class Builder{
        private final String name;
        private final String surName;
        private  Integer height;
        private  Integer weight;
        private  Integer age;
        private  Integer numWeapons;

        public Builder(String name,String surName){
            this.name =name;
            this.surName = surName;
        }

        public Builder withHeight(Integer height){
            this.height = height;
            return this;
        }

        public Builder withWeight(Integer weight){
            this.weight = weight;
            return this;
        }

        public Builder withAge(Integer withAge){
            this.age = withAge;
            return this;
        }

        public Builder withNumWeapons(Integer numWeapons){
            this.numWeapons = numWeapons;
            return this;
        }

        public Hero build(){
            return new Hero(this);
        }
    }
}
