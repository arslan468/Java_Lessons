public class Personel {

    private final String sicil;
    private String ad;
    private double maas;
    private String[] gorevler;
    private int gorevAdedi;

    public Personel(String sicil, String ad)
    {
        this(sicil,ad, 97000.0 );
    }

//    public Personel(String sicil, String ad, double maas) {
//
//        this.sicil=sicil;
//        this.ad=ad;
//        this.maas=maas;
//    }

    public Personel(Personel kaynak, boolean sigKopya)
    {
        this.sicil = kaynak.sicil;
        this.ad = kaynak.ad;
        this.maas = kaynak.maas;//ilkel
        this.gorevAdedi = kaynak.gorevAdedi;


        if (sigKopya) {
            this.gorevler = kaynak.gorevler;//aynı diziyi paylaşırlear
        } else {
            //  dizinin aynı bağımsız bir klonunu oluşturur
            this.gorevler = kaynak.gorevler.clone();
        }

    }

    public Personel(Personel kaynak) {
        this(kaynak, false);
    }

    public String getSicil() { return sicil; }

    public double getMaas() { return maas; }

    public String getAd() { return ad; }

    public Personel(String sicil, String ad, double maas) {
        if (sicil == null || sicil.isBlank()) throw new IllegalArgumentException("Sicil bos olamaz");
        if (ad == null || ad.isBlank()) throw new IllegalArgumentException("Ad bos olamaz");
        if (maas < 0) throw new IllegalArgumentException("Maas negatif olamaz");

        this.sicil = sicil;
        this.ad = ad;
        this.maas = maas;
        this.gorevler = new String[8]; // 8 elemanlı dizi
        this.gorevAdedi = 0;
    }

    public void setAd(String ad) {
        if (ad == null || ad.trim().isEmpty()) {
            System.out.println("ad boş olamaz");
            return;
        }
        this.ad = ad;
    }

    public void zamYap(double yuzde) {
        if (yuzde < 0 || yuzde > 100) {
            System.out.println("zam yuzdesi 0-100 araliginda olmali");
            return;
        }
        this.maas += this.maas * (yuzde / 100.0);
    }

    public void gorevEkle(String gorev) {
        if (gorev == null || gorev.isBlank()) {
            System.out.println("RED: gorev adi bos olamaz");
            return;
        }
        if (gorevAdedi >= 8) {
            System.out.println("RED: gorev listesi dolu");
            return;
        }
        this.gorevler[gorevAdedi] = gorev;
        this.gorevAdedi++;
    }

    public String gorevleriYaz() {
        if (gorevAdedi == 0) return "gorev yok";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gorevAdedi; i++) {
            sb.append(gorevler[i]);
            if (i < gorevAdedi - 1) sb.append(", ");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("Personel[%s, %s, %.2f TL, gorev={%s}]",
                sicil, ad, maas, gorevleriYaz());
    }




}
