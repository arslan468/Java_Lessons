void main() {

    Urun[] sepet = new Urun[3];
    sepet[0] = new Urun("Kitap", 150.0 );


    Ogrenci[] sinif = new Ogrenci[3];
    sinif[0] = new Ogrenci("Mehmet", 1386);
    sinif[1] = sinif[0];
    System.out.println("AD: "+ sinif[0].ad + "  - No: " + sinif[0].numara);
    sinif[1].ad = "Alp";
    sinif[1].numara = 455144;
    System.out.println("0. indeks Ad: "+ sinif[0].ad + "  - No: " + sinif[0].numara);

    System.out.println("1. indeks AD: "+ sinif[1].ad + "  - No: " + sinif[1].numara);

}

class BankaHesabi
{
    private double bakiye;

    BankaHesabi(double bakiye)
    {
        this.bakiye= bakiye;
    }

    public double getBakiye(double bakiye)
    {
        return bakiye;
    }

    public Boolean paraYatir(double tutar)
    {
        if (tutar <= 0 )
        {
            System.out.println("Yatırılacak para miktarı pozitif olmalıdır işlem başarısız!!!");
            return false;
        }
        this.bakiye+=tutar;
        return true;
    }
}

class Ogrenci
{
    private String ad;
    private int numara;
    public Ogrenci(String ad, int numara)
    {
        this.ad = ad;
        this.numara = numara;
    }

}
class Urun
{
    private String ad;
    private double fiyat;


    public Urun(String ad, double fiyat)
    {
        this.ad = ad;
        this.fiyat = fiyat;
    }
    public Urun(Urun egitim)
    {
        this(egitim.ad, egitim.fiyat);
        //this.ad = egitim.ad;
        //this.fiyat = egitim.fiyat;
    }

    public Urun(String ad)
    {
        this(ad,0.0);
    }

    public double getFiyat()
    {
        return this.fiyat;
    }
    public void setFiyat(double fiyat){
        if (fiyat < 0)
        {
            System.out.println("Fiyat sıfır'dan küçük olamaz");
            return;
        }
        else
        {
            this.fiyat = fiyat;
        }
    }

    @Override
    public String toString()
    {
        return "Urun: "+this.ad + " - Fiyat: " + this.fiyat;
    }

    // Kaynağı try'ın yanındaki normal parantez içinde üretiyoruz
    //try (GeciciDosya dosya = new GeciciDosya()) {
    // Kaynağı kullanıyoruz
    //dosya.kullan();
    //} // Blok bittiği an Java arka planda otomatik olarak dosya.close() metodunu çağırır!
}
