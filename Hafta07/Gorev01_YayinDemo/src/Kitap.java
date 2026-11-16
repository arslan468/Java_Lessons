public class Kitap extends Yayin {
    public static final int KITAP_GUN = 21;
    private final String yazar;
    private final int sayfaSayisi;
    private final String isbn;

    public Kitap(String baslik, int yil, String yazar, int sayfaSayisi, String isbn) {
        super(baslik, yil);
        if (yazar == null || yazar.trim().isEmpty()) {
            throw new IllegalArgumentException("Yazar boş olamaz.");
        }
        if (sayfaSayisi <= 0) {
            throw new IllegalArgumentException("Sayfa sayısı pozitif olmalıdır.");
        }
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN boş olamaz.");
        }
        this.yazar = yazar;
        this.sayfaSayisi = sayfaSayisi;
        this.isbn = isbn;
    }

    public String getYazar() {
        return yazar;
    }

    public int getSayfaSayisi() {
        return sayfaSayisi;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean kalinMi() {
        return sayfaSayisi >= 500;
    }

    @Override
    protected int oduncteGunSayisi() {
        return KITAP_GUN;
    }

    @Override
    public String kunye() {
        return super.kunye() + " | " + yazar + ", " + sayfaSayisi + " s., ISBN " + isbn;
    }
}

/*

1. SORU
ÖDÜNÇ VERİLEBİLİR Mİ METODUNU EZDİĞİMİZ ZAMAN DİĞER ÜRÜN GRUPLARINDA SORUN OLABİLİRDİ ALT SINIFLAR ODUNCTE KISMINI OKUYAMAZDI
KAPSÜLLEME ZAYIFLARDI

2.SORU
DEMİRBAŞ TÜM KÜTÜPHANE İÇİN STANDART OLMALIDIR HER ÜRÜNÜN FARKLI BİR FORMATTA DEMİRBAŞO OLMASI DÜZENSİZLİĞE VE TAKİPSİZLİĞE YOL AÇAR

3.SORU
EXTENDS İLE MİRAS ALMAMIZ SAYESİNDE MÜMKÜN HALE GELİYOR


* */