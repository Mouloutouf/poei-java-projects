public class Person
{
    public Person(String name, String address)
    {
        this.name = name;
        this.address = address;
    }

    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    private String address;
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
