public class Truck extends Vehicle
{
    public Truck(String brand, String model, int year, double initialPrice, int capacityInTons)
    {
        super(brand, model, year);
        this.initialPrice = initialPrice;
        this.capacityInTons = capacityInTons;
    }

    private double initialPrice;
    private int capacityInTons;

    public double calculateResellValue()
    {
        return initialPrice - (initialPrice * (2025 - year) * 0.12);
    }

    @Override
    protected String getDisplayTitle()
    {
        return "Truck";
    }

    @Override
    public void displayInfo()
    {
        super.displayInfo();
        System.out.print(", with capacity of " + capacityInTons + " tons, current market value: " + calculateResellValue() + "€");
        System.out.println();
    }
}
