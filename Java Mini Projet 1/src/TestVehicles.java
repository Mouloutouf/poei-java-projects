public class TestVehicles
{
    private static VehicleManager vehicleManager = new VehicleManager();

    public static void showAllVehicles()
    {
        for (Vehicle vehicle : vehicleManager.getVehicles())
        {
            vehicle.displayInfo();
        }
    }

    public static void main(String[] args)
    {
        vehicleManager.addVehicle(new Car("Chevrolet", "Camaro", 1966, 200000));
        vehicleManager.addVehicle(new Motorcycle("Triumph", "Daytona", 2001, 50000));
        vehicleManager.addVehicle(new Truck("Mercedes", "Actros", 2016, 40000, 500));

        showAllVehicles();
    }
}
