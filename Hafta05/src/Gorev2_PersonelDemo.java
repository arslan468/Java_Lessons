public class Gorev2_PersonelDemo {
    public static void main(String[] args) {
        System.out.println("=== 1) Kaynak nesne hazirlaniyor ===");
        Personel kaynak = new Personel("P-1001", "Betul Mumcu", 42000.00);
        kaynak.gorevEkle("Laboratuvar");
        kaynak.gorevEkle("Odev degerlendirme");
        System.out.println(kaynak);
        System.out.println();

        System.out.println("=== 2) DERIN kopya: diziler AYRI ===");
        Personel derinKopya = new Personel(kaynak); // false varsayılan (Derin kopya)
        derinKopya.setAd("Betul Mumcu (yedek kayit)");
        derinKopya.zamYap(10); // 42000 -> 46200

        System.out.println("Kaynak : " + kaynak);
        System.out.println("Kopya  : " + derinKopya);
        System.out.println("Kopyanin 0. gorevi degisti, KAYNAGINKI DEGISMEDI.");
        System.out.println();

        System.out.println("=== 3) SIG kopya: dizi PAYLASILIYOR ===");
        Personel paylasimliKaynak = new Personel("P-1002", "Diger Personel", 30000.00);
        paylasimliKaynak.gorevEkle("Teori dersi");
        paylasimliKaynak.gorevEkle("Danismanlik");

        Personel sigKopya = new Personel(paylasimliKaynak, true); // true = Sığ kopya

        System.out.println("Kopyalama sonrasi:");
        System.out.println("  Kaynak : " + paylasimliKaynak.gorevleriYaz());
        System.out.println("  Kopya  : " + sigKopya.gorevleriYaz());

        System.out.println("  Kaynak : " + paylasimliKaynak.gorevleriYaz());
        System.out.println("  Kopya  : " + sigKopya.gorevleriYaz());
        System.out.println("KAYNAK DA DEGISTI -> iki nesne AYNI diziyi gosteriyor.");
        System.out.println();

        // --- BÖLÜM 4: İlkel Alan Kopyalaması ---
        System.out.println("=== 4) Ilkel alanlar her zaman kopyalanir ===");
        Personel pA = new Personel("P-1003", "Test Kisi", 20000.00);
        Personel pB = new Personel(pA, true); // Sığ da olsa ilkel alanlar ayrılır
        pB.zamYap(50); // pB'nin maaşı 30000 olur, pA 20000 kalır

        System.out.println("a maas : " + String.format("%.2f", pA.getMaas()));
        System.out.println("b maas : " + String.format("%.2f", pB.getMaas()));
        System.out.println("double alan kopyalandi; sig/derin ayrimi ilkel turleri etkilemez.");
        System.out.println();

        System.out.println("=== 5) Gecersiz istekler ===");
        Personel deneme = new Personel("P-1003", "Deneme Kisi");
        deneme.zamYap(-5);
        deneme.gorevEkle("");
        deneme.setAd("   ");
        System.out.println("Nesne durumu korundu : " + deneme);
    }
}
