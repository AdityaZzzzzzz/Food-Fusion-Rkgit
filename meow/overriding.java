class life
{

    void Species()
    {
        System.out.println("Life exists");
    }
}

class human extends life
{
    @Override
    void Species()
    {
        System.out.println("Tragic misstep in evolution");
    }
}

public class overriding
{
    public static void main(String args[])
    {
        human x = new human();
        x.Species();
    }
}