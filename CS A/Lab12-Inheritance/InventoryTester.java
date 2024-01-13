
//Name: 

public class InventoryTester
{
    public static void main(String[] args)
    {
        Car c = new Car("Ur mom", 0000, 0.2, 8);
        Car c2 = new Car("You", 1500, 0.1, 9);
        Truck t = new Truck("A big truck", 1900, 10000, 9000000);
        Truck t2 = new Truck("A small truck", 7080, 1, 9000000);
        Motorcycle m = new Motorcycle("Suzuki DR-Z400", 2020, 7399.0, false);
        Motorcycle m2 = new Motorcycle("Ural Geo", 2021, 17597.0, true);
        Inventory garage = new Inventory();
        garage.addVehicle(c);
        garage.addVehicle(c2);
        garage.addVehicle(t);
        garage.addVehicle(t2);
        garage.addVehicle(m);
        garage.addVehicle(m2);
        garage.listInventory();
    }
}
