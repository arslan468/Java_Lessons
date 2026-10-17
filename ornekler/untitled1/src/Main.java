
interface Kargo
{
    void ucretHesapla();
}

class hizliKargo implements Kargo{
    @Override
    public void ucretHesapla()
    {
        System.out.println("Hızlı kargo ücreti 100TL");
    }
}

class normalKargo implements Kargo{
    @Override
    public void ucretHesapla()
    {
        System.out.println("Normal kargo ücreti 50TL");
    }
}


public class Main{
    public static void main(String args[])
    {
        Kargo teslimat = new hizliKargo();
        Kargo teslimat1 = new normalKargo();

        teslimat.ucretHesapla();
        teslimat1.ucretHesapla();
    }
}