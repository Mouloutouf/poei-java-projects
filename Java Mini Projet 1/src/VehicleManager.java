import java.util.ArrayList;

public class VehicleManager
{
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle)
    {
        vehicles.add(vehicle);
    }

    public ArrayList<Vehicle> getVehicles() { return vehicles; }
}