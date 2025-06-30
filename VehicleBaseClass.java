public class VehicleSystem {

//Base Class: Vehicle
static class Vehicle {
  protected int speed;
  private double fuel;

  public Vehicle(int speed, double fuel) {
    this.speed = speed;
    this.fuel = fuel;
  }

  public void stop() {
    System.out.println("The vehicle has started.");
  }

  public void stop() {
    System.out.println("The vehicle has stopped.");
  }

  public final void displayFuel() {
    System.out.println("Fuel level: " + fuel + " liters");
  }

  public void refuel(double amount) {
    if (amount > 0) {
      fuel += amount;
      system.out.println(Refueled " + amount + " liters. New fuel level: " + fuel + " liters");
    }
    else {
      System.out.println("Invalid refuel amount.");
    }
  }

  public String getSpeedCategory() {
    if (speed < 20) return "Slow";
    else if (speed < 60) return "Moderate";
    else return "Fast";
  }

  //Getters and setters
  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;

  public double getFuel() {
    return fuel;
  }

  public void setFuel(double fuel) {
    this.fuel = fuel;
  }
}

  //Subclass: Car
  static class Car extends Vehicle {
    private int numberOfDoors;

    public Car(int speed, double fuel, int numberOfDoors) {
      super(speed, fuel);
      this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void start() {
      System.out.println("The car has started. Vroom Vroom!");
    }

    public void honk() {
      System.out.println("Beep Beep!");
    }

    //Getters and setters
    public int getNumberOfDoors() {
      return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
      this.numberOfDoors = numberOfDoors;
    }
  }

  //Subclass: Bicycle
  static class Bicycle extends Vehicle {
    private boolean hasBell;
    private int gearCount;

    public Bicycle(int speed, double fuel, boolean hasBell, int gearCount) {
      super(speed, fuel);
      this.hasBell = hasBell;
      this.gearCount = gearCount;
    }

    @Override
    public void start() {
      System.out.println("Pedal away! The bicycle has started.");
    }

    public void ringBell() {
      if (hasBell) {
        System.out.println("ring Ring!");
      }
      else {
        System.out.println("This bicycle has no bell.");
      }
    }

    // Getters and setters
    public boolean getHasBell() {
      return hasBell;
    }

    public void setHasBell(boolean hasBell) {
      this.hasBell = hasBell;
    }

    public int getGearCount() {
      return gearCount;
    }

    public void setGearCount(int gearCount) {
      this.gearCount = gearCount;
    }
  }

  //Main method
  public static void main(String[] args) {
    
    //Test car
    Car myCar = new Car(85, 40.0, 4);
    myCar.start();
    myCar.displayFuel();
    myCar.honk();
    System.out.println("Car speed category: " + myCan.getSpeedCategory());
    myCar.refuel(10.0);
    System.out.println("Number of doors: " + myCar.getNumberOfDoors());

    System.out.println();

    //Test bicycle
    Bicycle myBike = new Bicycle(15, 0.0, true, 6);
    myBike.start();
    myBike.displayFuel();
    myBike.ringBell();
    System.out.println("Bike speed category: " + myBike.getSpeedCategory());
    System.out.println("Gear count: " + myBike.getGearCount());

    System.out.println();

    //Encapsulation check
    myCar.setSpeed(100);
    System.out.println("Updated car speed: " + myCar.getSpeed());
  }
}
