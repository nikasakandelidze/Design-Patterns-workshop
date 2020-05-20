public class Main {
    //Compare two instances of Singleton object by addresses,
    //making sure that they are one and a same objects.
    public static void main(String[] args) {
        MotherLand motherLand1 = MotherLand.getMotherLand();
        MotherLand motherLand2 = MotherLand.getMotherLand();
        assert motherLand1 == motherLand2;
    }
}

