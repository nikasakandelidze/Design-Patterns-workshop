public class Main {

    public static void main(String[] args) {
        Sheep sheep1 = new Sheep("sheep1","kandelaki");
        try {
            Sheep sheep2 = sheep1.clone();
            assert sheep1.equals(sheep2);
        } catch (CloneNotSupportedException e) { }
    }
}
