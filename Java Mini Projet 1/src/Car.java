public class Car extends Vehicle
{
    public Car(String brand, String model, int year, double initialPrice)
    {
        super(brand, model, year);
        this.initialPrice = initialPrice;
    }

    private double initialPrice;

    public double calculateResellValue()
    {
        return initialPrice - (initialPrice * (2025 - year) * 0.1);
    }

    @Override
    protected String getDisplayTitle()
    {
        return "Car";
    }

    @Override
    public void displayInfo()
    {
        super.displayInfo();
        System.out.print(", bought at: " + initialPrice + "€, current market value: " + calculateResellValue() + "€");
        System.out.println();
    }
}
