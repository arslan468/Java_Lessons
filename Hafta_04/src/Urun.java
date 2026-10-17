import java.util.Locale;

public class Urun {
    // 1. barkod: private final - yalnızca getter (salt-okunur)
    private final String barkod;

    // 2. ad: private - getter + setter; boş ya da yalnızca boşluk olamaz
    // İpucu uyarınca yapıcıdan önce başlangıç değeri atanmıştır
    private String ad = "";

    // 3. fiyat: private - getter + setter; negatif olamaz
    private double fiyat;

    // 4. stok: private - yalnızca getter; setStok() yazılmayacak
    private int stok;

    // Yapıcı (Constructor)
    public Urun(String barkod, String ad, double fiyat, int stok) {
        this.barkod = barkod;
        // İpucu uyarınca doğrulama kurallarını tekrar yazmamak için metotlar çağrılır
        setAd(ad);
        setFiyat(fiyat);
        stokGir(stok); 
    }

    // barkod getter (salt-okunur)
    public String getBarkod() {
        return barkod;
    }

    // ad getter ve setter
    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        if (ad == null || ad.trim().isEmpty()) {
            System.out.println("RED: urun adi bos olamaz.");
            return;
        }
        this.ad = ad;
    }

    // fiyat getter ve setter
    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        if (fiyat < 0) {
            System.out.printf(Locale.US, "RED: fiyat negatif olamaz (%.2f).\n", fiyat);
            return;
        }
        this.fiyat = fiyat;
    }

    // stok getter (setStok yazılmaz!)
    public int getStok() {
        return stok;
    }

    // Stok artışı: adet pozitif olmalı
    public void stokGir(int adet) {
        if (adet <= 0) {
            System.out.println("RED: girilecek adet pozitif olmali.");
            return;
        }
        this.stok += adet;
    }

    // Stok azalışı: adet pozitif ve stoktan küçük/eşit olmalı
    public void stokCik(int adet) {
        if (adet <= 0) {
            System.out.println("RED: cikarilacak adet pozitif olmali.");
            return;
        }
        if (adet > this.stok) {
            System.out.printf("RED: stok yetersiz (%d > %d).\n", adet, this.stok);
            return;
        }
        this.stok -= adet;
    }

    // Türetilmiş bilgi: fiyat * stok, alan tutulmaz
    public double getStokDegeri() {
        return this.fiyat * this.stok;
    }

    // toString() ezilir: barkod, ad, fiyat ve stok görünür
    @Override
    public String toString() {
        return String.format(Locale.US, "Urun[%s, %s, %.2f TL, stok=%d]", barkod, ad, fiyat, stok);
    }
}
