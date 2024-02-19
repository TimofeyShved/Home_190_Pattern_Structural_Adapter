package com.company;

public class Main {

    public static void main(String[] args) {
        MyCar car = new MyCar();
        car.washCar(new Audi());
        car.washCar(new TrackWrappper(new Kamaz()));
    }
}


// у нас есть 2 класса, но у них разные методы, одинаковые для нас по смыслу
interface Track{
    void clear();
}

class Kamaz implements Track{
    @Override
    public void clear() {
        System.out.println("Clear track");
    }
}


interface Car{
    void wash();
}

class Audi implements Car{
    @Override
    public void wash() {
        System.out.println("wash car");
    }
}


// но при этом класс отвечающий за вызов только 1
class MyCar{
    public void washCar(Car car){
        car.wash();
    }
}

// поэтому мы создаём обёртку (по паттерну адаптера)
class TrackWrappper implements Car{
    Track track;

    public TrackWrappper(Track track){
        this.track = track;
    }

    @Override
    public void wash() {
        track.clear();
    }
}