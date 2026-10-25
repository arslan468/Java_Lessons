
public class Gorev1_KitapDemo {
    public static void main(String[] args) {
        System.out.println("--- BAŞARILI NESNE OLUŞTURMA TESTLERİ ---");
        Kitap kitap1 = new Kitap("978-01", "Uzaktan gelen arkadaş");
        System.out.println("Kitap 1: " + kitap1);

        Kitap kitap2 = new Kitap("978-02", "Sefiller", "Victor Hugo");
        System.out.println("Kitap 2: " + kitap2);

        Kitap kitap3 = new Kitap("978-03", "Suç ve Ceza", "Dostoyevski", 680, 2020);
        System.out.println("Kitap 3: " + kitap3);


        System.out.println("\n--- HATA DENETİMİ VE İSTİSNA TESTLERİ ---");
        try {
            Kitap hataliKitap1 = new Kitap("", "Baslik Yok");
        } catch (IllegalArgumentException e) {
            System.out.println("HATA (ISBN): " + e.getMessage());
        }
        try {
            Kitap hataliKitap2 = new Kitap("978-04", null);
        } catch (IllegalArgumentException e) {
            System.out.println("HATA (Baslik): " + e.getMessage());
        }
        try {
            Kitap hataliKitap3 = new Kitap("978-05", "Dönüşüm", "Franz Kafka", -10, 2015);
        } catch (IllegalArgumentException e) {
            System.out.println("HATA (Sayfa Sayısı): " + e.getMessage());
        }
        try {
            Kitap hataliKitap4 = new Kitap("978-06", "1984", "George Orwell", 328, 2030); // Gelecek yıl/hata
        } catch (IllegalArgumentException e) {
            System.out.println("HATA (Basım Yılı): " + e.getMessage());
        }
    }
}

//KONTROL SORULARI
//  1. başlı,sayfasayısı ve basim yılı yoktu
//  2. yeni eklenen sayfa sayısı yapıcısından ret aldı çünkü negatif depğer girilmişti
//  3. bri satır değiştirmek gerekir kitap.java dosyasında 9. satır sadece