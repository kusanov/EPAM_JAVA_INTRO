package com.company.epam.part4.AggAndComp.Car;

public class MainCar {
    public static void main(String[] args) {

//2. Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
//    менять колесо, вывести на консоль марку автомобиля.

        Car car = new Car("Renault", "Laguna", "hatchback", engine, 2001, 70, 50, wheels);
        car.printTitle();
        car.driveCar();
        car.refuelCar(30);
        car.replaceWheel(newWheel, 3);
        //Вывод в консоль описание автомобиля для проверки замены колеса и измененния уровня топлива (заправки авто)
        System.out.println('\n' + car.toString());
    }

    private static Wheel[] createArrWheels(Wheel wheel) {
        Wheel[] wheelsArr = new Wheel[4];
        for (int i = 0; i < wheelsArr.length; i++) {
            wheelsArr[i] = wheel;
        }
        return wheelsArr;
    }
    private static Wheel[] wheels = createArrWheels(new Wheel(205, 55, 'R', 16, "summer"));
    private static Engine engine = new Engine(1800, "Бензин", 8.5, 121);
    private static Wheel newWheel = new Wheel(205, 55, 'R', 16, "winter");
}