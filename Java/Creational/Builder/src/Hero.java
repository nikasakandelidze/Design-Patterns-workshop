//So let's assume that name and surname are two must have parameters other parameters are willingly.
public class Hero {
    private final String name;
    private final String surName;
    private final Integer height;
    private final Integer weight;
    private final Integer age;
    private final Integer numWeapons;

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getNumWeapons() {
        return numWeapons;
    }

//!!!!!!!!!!!!!!!!!!!BAD!!!!!!!!!!!!!!!!!!!!!!
//    public Hero(String name, String surName, Integer height, Integer weight, Integer age, Integer numWeapons) {
//        this.name = name;
//        this.surName = surName;
//        this.height = height;
//        this.weight = weight;
//        this.age = age;
//        this.numWeapons = numWeapons;
//    }

    private Hero(HeroBuilderImpl heroBuilderImpl){
        age = heroBuilderImpl.age;
        height = heroBuilderImpl.height;
        name = heroBuilderImpl.name;
        weight = heroBuilderImpl.weight;
        numWeapons = heroBuilderImpl.numWeapons;
        surName = heroBuilderImpl.surName;
    }

    public static HeroBuilder getBuilder(){
        return new HeroBuilderImpl();
    }

    public interface HeroBuilder{
        HeroBuilder withHeight(Integer height);

        HeroBuilder withWeight(Integer weight);

        HeroBuilder withAge(Integer withAge);

        HeroBuilder withNumWeapons(Integer numWeapons);

        Hero build();
    }

    private static class HeroBuilderImpl implements HeroBuilder {
        private  String name;
        private  String surName;
        private  Integer height;
        private  Integer weight;
        private  Integer age;
        private  Integer numWeapons;

        public HeroBuilderImpl() {
        }

        public HeroBuilderImpl(String name, String surName){
            this.name =name;
            this.surName = surName;
        }

        @Override
        public HeroBuilderImpl withHeight(Integer height){
            this.height = height;
            return this;
        }

        @Override
        public HeroBuilderImpl withWeight(Integer weight){
            this.weight = weight;
            return this;
        }

        @Override
        public HeroBuilderImpl withAge(Integer withAge){
            this.age = withAge;
            return this;
        }

        @Override
        public HeroBuilderImpl withNumWeapons(Integer numWeapons){
            this.numWeapons = numWeapons;
            return this;
        }

        @Override
        public Hero build(){
            return new Hero(this);
        }
    }
}
