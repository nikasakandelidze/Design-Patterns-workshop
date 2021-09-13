package Decorator;

import Car.Car;

//Sports car is regular car + some improvements
public class SportsCar implements Car {
    private Car decoratedCar;

    public SportsCar(Car car){
        this.decoratedCar = car;
    }

    @Override
    public void assemble() {
        decoratedCar.assemble();
        System.out.println("Adding some more sporty improvements to regular car.");
    }
}
