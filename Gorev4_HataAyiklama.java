public class Gorev4_HataAyiklama {
    public static void main(String[] args)
    {
        String ad;//değişkenler tanımlandı
        int stok;
        double fiyat;

        Urun u1 = new Urun("Klavye", 750.0, 3);
        Urun u2 = new Urun("Fare"); //u2 için eksik yapıcı eklemesi yapıldı yalnızca ad parametresi olan
        Urun u3 = new Urun(); // u3 için boş bir yapıcı eklendi parametresiz
        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);



    }
}

class Urun
{
    private String ad;
    private double fiyat;
    private int stok;

    // get metotları eklendi
    public String getAd()
    {
        return ad;
    }
    public double getFiyat()
    {
        return fiyat;
    }
    public int getStok(){
        return stok;
    }


    public Urun(String ad, double fiyat, int stok)
    {
        this.ad = ad;  // this eklendi
        this.fiyat = fiyat; // this eklendi
        this.stok = stok; // this eklendi

    }
    // eksik yapıcılar eklendi
    public Urun (String ad)//u2 için
    {
        this.ad = ad;
        this.fiyat = 0.0;
        this.stok = 0;
    }

    public Urun()//u3 için
    {
        this.ad = "İsimsiz";
        this.fiyat = 0.0;
        this.stok = 0;
    }

    public void setFiyat(double fiyat)
    {
        if (fiyat < 0)
        {
            System.out.println("FİYAT NEGATİD OLAMAZ!!! İŞLEM YAPILAMADI");
        }
        else {
            this.fiyat = fiyat;
        }
    }

    public void stokEkle(int stok)
    {
        int mevcutStok = this.stok;

        if ((mevcutStok-stok)<0)
        {
            System.out.println("YETERLİ STOK OLMADIĞI İÇİN İŞLEM YAPILAMADI STOK NEGATİF OLAMAZ!!! \nGüncel stok: " + mevcutStok);
        }
        else {
            this.stok = stok;
        }
    }




    @Override
    public String toString()
    {
        return String.format("%-10s %9.2f TL stok: %3d", ad, fiyat, stok);
    }

}