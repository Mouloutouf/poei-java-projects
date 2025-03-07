public class Motorcycle extends Vehicle
{
    public Motorcycle(String brand, String model, int year, double initialPrice)
    {
        super(brand, model, year);
        this.initialPrice = initialPrice;
    }

    private double initialPrice;

    public double calculateResellValue()
    {
        return initialPrice - (initialPrice * (2025 - year) * 0.08);
    }

    @Override
    protected String getDisplayTitle()
    {
        return "Motorcycle";
    }

    @Override
    public void displayInfo()
    {
        super.displayInfo();
        System.out.print(", bought at: " + initialPrice + "€, current market value: " + calculateResellValue() + "€");
        System.out.println();
    }
}
