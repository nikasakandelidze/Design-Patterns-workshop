public class Main {
    public static void main(String[] args) {
        var hero = new Hero.Builder("Zoro","sakana")
                           .withAge(12).withHeight(222).withNumWeapons(12)
                           .withWeight(11).build();

    }
}
