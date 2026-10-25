public class Kitap {
    private final String isbn;
    private String baslik;
    private String yazar;
    private int sayfaSayisi;
    private int basimYili;

    public Kitap(String isbn, String baslik) {
        this(isbn, baslik, "Bilinmiyor", 100, 2026);
    }

    public Kitap(String isbn, String baslik, String yazar) {
        this(isbn, baslik, yazar, 100, 2026);
    }

    public Kitap(String isbn, String baslik, String yazar, int sayfaSayisi, int basimYili) {
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("ISBN bos olamaz");
        }
        if (baslik == null || baslik.isBlank()) {
            throw new IllegalArgumentException("Baslik bos olamaz");
        }
        if (yazar == null || yazar.isBlank()) {
            throw new IllegalArgumentException("Yazar bos olamaz");
        }
        if (sayfaSayisi <= 0) {//BU EKLENDİ
            throw new IllegalArgumentException("Sayfa sayisi 0'dan buyuk olmalidir");
        }
        if (basimYili <= 0 || basimYili > 2026) {//BU KODDA EKLENDİ EKSİKTİ
            throw new IllegalArgumentException("Gecersiz basim yili");
        }
        this.isbn = isbn;
        this.baslik = baslik;
        this.yazar = yazar;
        this.sayfaSayisi = sayfaSayisi;
        this.basimYili = basimYili;
    }

    public String getIsbn() { return isbn; }
    public String getBaslik() { return baslik; }
    public String getYazar() { return yazar; }
    public int getSayfaSayisi() { return sayfaSayisi; }
    public int getBasimYili() { return basimYili; }

    @Override
    public String toString() {
        return "Kitap{" +
                "ISBN='" + isbn + '\'' +
                ", Başlık='" + baslik + '\'' +
                ", Yazar='" + yazar + '\'' +
                ", Sayfa Sayısı=" + sayfaSayisi +
                ", Basım Yılı=" + basimYili +
                '}';
    }
}