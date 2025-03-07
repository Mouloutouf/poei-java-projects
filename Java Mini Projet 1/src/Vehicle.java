public class Vehicle
{
    public Vehicle(String brand, String model, int year)
    {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    protected String brand;
    protected String model;
    protected int year;

    protected String getDisplayTitle()
    {
        return "Vehicle";
    }

    public void displayInfo()
    {
        System.out.print(getDisplayTitle() + " : " + brand + " " + model + " " + year);
    }
}
