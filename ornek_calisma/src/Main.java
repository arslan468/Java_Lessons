void main() {

//    Urun[] sepet = new Urun[3];
//    sepet[0] = new Urun("Kitap", 150.0 );
//    Ogrenci[] sinif = new Ogrenci[3];
//    sinif[0] = new Ogrenci("Mehmet", 1386);
//    sinif[1] = sinif[0];
//    System.out.println("AD: "+ sinif[0].ad + "  - No: " + sinif[0].numara);
//    sinif[1].ad = "Alp";
//    sinif[1].numara = 455144;
//    System.out.println("0. indeks Ad: "+ sinif[0].ad + "  - No: " + sinif[0].numara);
//    System.out.println("1. indeks AD: "+ sinif[1].ad + "  - No: " + sinif[1].numara);


    //Sekil[] s1 = new Sekil[]{new Kare((double)5.0, "Siyah")};

    Sekil s1 = new Kare(5.0, "Siyah");
    System.out.println("Karenin alanı: "+s1.alan());

}

// 1. Sınıf AutoCloseable arayüzünü (sözleşmesini) uygular
static class DosyaKaynagi implements AutoCloseable {

    public void yaz(String metin) {
        System.out.println("Dosyaya yazıldı: " + metin);
    }

    // 2. İş bitince çalışacak garantili kapatma metodu
    @Override
    public void close() {
        System.out.println("Dosya güvenle kapatıldı.");
    }
}

class Main {
    public static void main(String[] args) {
        // 3. Nesne try (...) parantezleri içinde üretilir
        try (DosyaKaynagi dosya = new DosyaKaynagi()) {

            dosya.yaz("Merhaba Java!");
            // İçeride bir hata (Exception) çıksa bile...

        }
        // ... try bloğu biter bitmez Java otomatik olarak dosya.close() metodunu çağırır!
    }
}

static class Bilet
{
    private String kalkis;
    private String varis;
    private double fiyat;

    private Bilet(String kalkis, String varis, double fiyat)
    {
        this.kalkis=kalkis;
        this.varis=varis;
        this.fiyat=fiyat;
    }

    public static Bilet tam(String kalkis, String varis)
    {
        return new Bilet(kalkis, varis, 200.0);
    }

    public static Bilet ogrenci(String kalkis, String varis)
    {
        return new Bilet(kalkis, varis, 100.0);

    }

}

class Personel
{
    private String ad;
    private int[] mesai;

    public Personel(Personel Kaynak)
    {
        this.ad = Kaynak.ad;
        this.mesai = Kaynak.mesai.clone();

    }
}

class Kitap
{
    private String isbn;
    private String baslik;
    private int sayfaSayisi;

    public Kitap(String isbn,String baslik, int sayfaSayisi)
    {
        if (!(sayfaSayisi<=0))
        {
            this.baslik=baslik;
            this.isbn=isbn;
            this.sayfaSayisi=sayfaSayisi;
        }
        else
        {
            throw new IllegalArgumentException("Sayfa sayısı 0 veya daha küçük olamaz!");        }
    }

    public Kitap(String isbn, String baslik)
    {
        this(isbn, baslik, 100);
    }
}

class Zaman
{
    private final int saat;
    private final int dakika;

    public Zaman(int saat, int dakika)
    {
        if (saat<24 && 0<=saat && 0<dakika && dakika<60)
        {
            this.saat=saat;
            this.dakika=dakika;
        }
        else
        {
            this.saat=0;
            this.dakika=0;
        }
    }
}

class Dikdortgen
{
    private double kisaKenar;
    private double uzunKenar;

    public double getAlan()
    {
        return (this.kisaKenar*this.uzunKenar);
    }
}

class Sifre
{
    private String deger;

    public Sifre(String deger)
    {
        this.deger=deger;
    }

    public boolean dogrula(String deneme)
    {
        return this.deger.equals(deneme);
    }

    public boolean degistir(String eskiSifre, String yeniSifre)
    {
        if (this.deger.equals(eskiSifre))
        {
            if (yeniSifre.length()>=8)
            {
                this.deger=yeniSifre;
                System.out.println("İşlem başarılı şifre değiştirildi.");
                return true;
            }
            System.out.println("Yeni şifreniz yeterli uzunlukta değil işleminiz başarısız!!!");
            return false;

        }
        System.out.println("Eski şifre hatalı girildi işlem başarısız!!!");
        return false;
    }
}


abstract class Sekil
{
    private String renk;

    public Sekil(String renk)
    {
        this.renk = renk;
    }

    public String getRenk()
    {
        return renk;
    }

    public abstract double alan();

}

class Kare extends Sekil
{
    private double kenar;

    public Kare (double kenar, String renk)
    {
        super(renk);
        this.kenar=kenar;
    }

    @Override
    public double alan()
    {
        return this.kenar*this.kenar;
    }
}

class BankaHesabi
{
    private double bakiye;

    BankaHesabi(double bakiye)
    {
        this.bakiye= bakiye;
    }

    public double getBakiye()
    {
        return bakiye;
    }

    public boolean paraYatir(double tutar)
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
