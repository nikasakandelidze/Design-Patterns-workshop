import Car.Car;
import Car.RegularCar;
import Decorator.SportsCar;

public class Main {
    public static void main(String[] args) {
        //Make factory assemble regular car
        Car regularCar = new RegularCar();
        assemblingCarFactory(regularCar);

        //but now we need factory to assemble Sports Car.Car.
        //So use decorator we created called SportsCar
        assemblingCarFactory(new SportsCar(regularCar));
    }

    //Car.Car factory assembles car.
    private static void assemblingCarFactory(Car car){
        car.assemble();
    }
}
