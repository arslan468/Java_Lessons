import java.util.Scanner;

public class hafta2lab_kitap {
    private String yazar, baslik;
    private int sayfaSayisi, basimYili;
    private double fiyat;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Yazar: ");
        String yazar = scanner.nextLine();

        System.out.print("Kitap Başlığı yazınız: ");
        String baslik = scanner.nextLine();

        System.out.print("Sayfa Sayısını giriniz: ");
        int sayfa = scanner.nextInt();

        System.out.print("Basım yılını giriniz: ");
        int basim = scanner.nextInt();

        System.out.print("Fiyatını giriniz: ");
        double urunFiyat = scanner.nextDouble();

        hafta2lab_kitap kitap = new hafta2lab_kitap(yazar, baslik, sayfa, basim, urunFiyat);

        System.out.println("========== KAYDEDİLEN YENİ KİTAP BİLGİLERİ ==========");
        System.out.println("Başlık: " + kitap.getBaslik());
        System.out.println("Yazar: "+ kitap.getYazar());
        System.out.println("Sayfa Sayısı: "+ kitap.getSayfaSayisi());
        System.out.println("Basım Yılı: "+ kitap.getBasimYili());
        System.out.println("Fiyatı: "+ kitap.getFiyat());
        System.out.println("============================================================");

        System.out.println("\n--- Fonksiyon Sonuçları ---");
        System.out.println("Kalın mı? (>400 sayfa): " + kitap.kalınMi());
        System.out.println("Sayfa başına fiyat: " + kitap.sayfaBasinaFiyat() + " TL");

        System.out.print("\nKitabın yaşını hesaplamak için güncel yılı girin: ");
        int guncelYil = scanner.nextInt();
        System.out.println("Kitabın yaşı: " + kitap.yasi(guncelYil));

        System.out.print("\nUygulanacak indirim yüzdesini girin (örn: 15): ");
        double indirim = scanner.nextDouble();
        kitap.indirimUygula(indirim);
        System.out.println("İndirimli yeni fiyat: " + kitap.getFiyat() + " TL");

        System.out.print("\nFiyatı doğrudan değiştirmek için yeni bir fiyat girin: ");
        double yeniFiyat = scanner.nextDouble();
        kitap.setFiyat(yeniFiyat);
        System.out.println("Güncel son fiyat: " + kitap.getFiyat() + " TL");

        System.out.println("\n--- Kopya Nesne Testi ---");
        hafta2lab_kitap kopyaKitap = new hafta2lab_kitap(kitap);
        System.out.println("Kopya kitabın başlığı: " + kopyaKitap.getBaslik() + " | Fiyatı: " + kopyaKitap.getFiyat() + " TL");

        scanner.close();

    }


    public hafta2lab_kitap(String yazar, String baslik, int sayfaSayisi, int basimYili, double fiyat)
    {
        if (baslik == null || baslik.isBlank())
        {
            this.baslik = "İsimsiz";
        }
        else
        {
            this.baslik = baslik;
        }

        if( yazar == null || yazar.isBlank())
        {
            this.yazar = "Bilinmiyor";
        }
        else
        {
            this.yazar = yazar;
        }

        this.sayfaSayisi = (sayfaSayisi >  0 ) ? sayfaSayisi:1;

        this.basimYili = (basimYili >= 1450 && basimYili <= 2100 ) ? basimYili:2026;

        this.fiyat = (fiyat >= 0) ? fiyat:0.0;



    }

    public hafta2lab_kitap(String yazar, String baslik, int sayfaSayisi, int basimYili)
    {
        this( yazar,baslik, sayfaSayisi, basimYili, 0.0);
    }

    public hafta2lab_kitap(String yazar, String baslik)
    {
        this(yazar, baslik, 1, 2026, 0.0);
    }

    public hafta2lab_kitap( hafta2lab_kitap kaynak)
    {
        this(kaynak.yazar, kaynak.baslik, kaynak.sayfaSayisi, kaynak.basimYili, kaynak.fiyat );
    }



    public String getYazar()
    {
        return yazar;
    }

    public String getBaslik()
    {
        return baslik;
    }

    public int getSayfaSayisi()
    {
        return sayfaSayisi;
    }

    public int getBasimYili()
    {
        return basimYili;
    }

    public double getFiyat()
    {
        return fiyat;
    }

    public void setFiyat(double fiyat)
    {
        if (fiyat < 0)
        {
            System.out.println("Fiyat negatif olamaz!!! Değişiklik yapılamadı.");
        }
        else
        {
            this.fiyat = fiyat;
        }
    }

    public boolean kalınMi()
    {
        return sayfaSayisi > 400;
    }

    public double sayfaBasinaFiyat()
    {
        return (fiyat/sayfaSayisi);
    }

    public void indirimUygula (double yuzde)
    {
        if(yuzde < 0|| yuzde >100 )
        {
            System.out.println("İndirim oranı 0-100 arası olmak zorunda indirim uygulanmadı !!!");
        }
        else
        {
            this.fiyat -= (yuzde/100) * this.fiyat;
        }

    }

    public int yasi (int bugununYili)
    {
        return bugununYili - basimYili;
    }

}