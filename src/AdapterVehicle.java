interface Car {
    void beep();
    void drive();
}


class BMWCar implements Car {
    public void beep() {
        System.out.println("Beep! Beep!");
    }

    public void drive() {
        System.out.println("Vroom Vroom");
    }
}

interface ElectricBike {
    void bell();
    void cycle();
}

class BMWElectricBike implements ElectricBike {
    public void bell(){
        System.out.println("Ring! Ring! Ring!");
    }

    public void cycle(){
        System.out.println("vrmmmm");
    }
}

class ElectricBikeAdapter implements Car {
    ElectricBike bike;

    public ElectricBikeAdapter(ElectricBike bike) {
        this.bike = bike;
    }

    public void beep() {
        bike.bell();
    }

    public void drive() {
        bike.cycle();
    }
}

public class AdapterVehicle {
    public static void main(String[] args) {
        BMWCar car = new BMWCar();//create a BMW Car
        BMWElectricBike bike = new BMWElectricBike();// create a Bike
        /*
         *wrap the bike in a bikeAdapter which will make it look like,
         * a Car.
         **/
        Car bikeAdapter = new ElectricBikeAdapter(bike);

        System.out.println("The bike does...");
        bike.bell();
        bike.cycle();

        System.out.println("The car does...");
        car.beep();
        car.drive();

        System.out.println("The bikeAdapter does...");
        bikeAdapter.beep();
        bikeAdapter.drive();

        System.out.println("testing car below");
        testCar(car);
    }

    static void testCar(Car car) {
        car.beep();
        car.drive();
    }
}
