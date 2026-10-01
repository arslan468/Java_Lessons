public class class_object {
    public static void main(String[] args)
    {
        Telefon telefon1 = new Telefon("İphone", 512, 24890);
        Telefon telefon2 = new Telefon("Samsung", 512, 18000);

        telefon1.yazdir();
        telefon2.yazdir();

        telefon1.ZamYap();
        telefon1.yazdir();



    }
}

class Telefon
{
    String marka;
    int hafiza;
    int fiyat;

    public Telefon(String marka,int hafiza, int fiyat)
    {
        this.marka = marka;
        this.hafiza = hafiza;
        this.fiyat = fiyat;
    }

    void yazdir()
    {
        System.out.println("Telefonun markası: " + marka);
        System.out.println("Telefonun hafızası: " + hafiza + "GB");
        System.out.println("Telefonun fiyatı: " + fiyat +"TL");
    }

    void ZamYap()
    {
        fiyat += 1000;
        System.out.println(marka +" Telefonun güncel fiyatı " + fiyat + " TL olmuştur.");
    }
}
