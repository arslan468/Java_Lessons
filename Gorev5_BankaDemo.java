public class Gorev5_BankaDemo {
    public static void main(String[] args) {
        BankaHesabi hesap1 = new BankaHesabi("TR100001", "Ahmet", 1000);
        BankaHesabi hesap2 = new BankaHesabi("TR100002", "Mehmet");

        hesap1.paraYatir(500);
        hesap1.paraCek(200);

        System.out.println(hesap1.toString());

        hesap1.transferEt(hesap2, 300);
        System.out.println("Transfer Sonrası Hesap 1: " + hesap1.toString());
        System.out.println("Transfer Sonrası Hesap 2: " + hesap2.toString());

        System.out.println("\n5) try-with-resources ile otomatik kapanis:");
        try (BankaHesabi gecici = new BankaHesabi("TR100003", "Gecici Hesap", 150)) {
            System.out.println(gecici.toString());
        }
        try {
            hesap1.close(); // Elle kapatma
            hesap1.close(); // İkinci kez çağırma (etkisiz)
            hesap1.paraYatir(100); // Hata fırlatacak
        } catch (IllegalStateException e) {
            System.out.println("Beklenen Hata Yakalandı: " + e.getMessage());
        }
    }
}

class BankaHesabi implements AutoCloseable {
    private final String hesapNo;
    private final String sahip;
    private double bakiye;
    private int islemSayisi;
    private boolean acikMi;

    public BankaHesabi(String hesapNo, String sahip, double baslangicBakiyesi)
    {
        this.hesapNo = (hesapNo == null || hesapNo.trim().isEmpty()?"Bilinmeyen": hesapNo);
        this.sahip = (sahip == null || sahip.trim().isEmpty()) ? "Sahibi Bilinmiyo": sahip;
        if (baslangicBakiyesi < 0)
        {
            this.bakiye = 0;
        }
        else
        {
            this.bakiye = baslangicBakiyesi;
        }
        this.islemSayisi = 0;
        this.acikMi = true;
        System.out.println("[HESAP ACILDI] " + this.hesapNo + " - " + this.sahip);

    }


    public BankaHesabi(String hesapNo, String sahip) {
        this(hesapNo, sahip, 0.0);
    }


    private void hesapDurumKontrol() {
        if (!acikMi) {
            throw new IllegalStateException("Hesap kapalı, işlem yapılamaz.");
        }
    }

    public void paraYatir(double miktar) {
        hesapDurumKontrol();
        if (miktar <= 0) {
            System.out.println("Uyarı: Yatırılacak tutar pozitif olmalıdır.");
            return;
        }
        bakiye += miktar;
        islemSayisi++;
    }

    public void paraCek(double miktar) {
        hesapDurumKontrol();
        if (miktar <= 0 || miktar > bakiye) {
            System.out.println("Uyarı: Geçersiz veya bakiyeden büyük tutar.");
            return;
        }
        bakiye -= miktar;
        islemSayisi++;
    }

    public void transferEt(BankaHesabi hedef, double miktar) {
        hesapDurumKontrol();
        if (miktar <= 0 || miktar > this.bakiye) {
            System.out.println("Uyarı: Yetersiz bakiye veya geçersiz tutar.");
            return;
        }
        this.bakiye -= miktar;
        this.islemSayisi++;

        hedef.bakiye += miktar;
        hedef.islemSayisi++;
    }

    @Override
    public void close() {
        if (acikMi) {
            acikMi = false;
            System.out.printf("[HESAP KAPANDI] %s - son bakiye: %.2f TL\n", hesapNo, bakiye);
        }
    }

    @Override
    public String toString() {
        String durum = acikMi ? "acik" : "kapali";
        return String.format("%s \t %s \t %.2f TL \t islem: %d \t %s", hesapNo, sahip, bakiye, islemSayisi, durum);
    }
}

