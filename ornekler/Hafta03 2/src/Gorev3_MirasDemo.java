public class Gorev3_MirasDemo {
    public static void main(String[] args) {

        System.out.println("--- Devralinan uyeler ---");
        Kisi k = new Kisi("Alp Arslan", "12345678901", 2006);
        System.out.println(k.tanit());

        Ogrenci o = new Ogrenci("Mehmet Alp Arslan", "98765432109", 2005, 376512, 3.92);
        System.out.println(o.tanit());

        System.out.println("\n--- Ogrenci, Kisi'den NELERI devraldi? ---");
        System.out.println("o.getAd()       = " + o.getAd());
        System.out.println("o.maskeliTc()   = " + o.maskeliTc());
        System.out.println("o.yas()         = " + o.yas());
        System.out.println("(bu uc uye Ogrenci.java icinde HIC yazilmadi)");

        System.out.println("\n--- IS-A iliskisi ---");
        System.out.println("o instanceof Ogrenci = " + (o instanceof Ogrenci));
        System.out.println("o instanceof Kisi    = " + (o instanceof Kisi));
        System.out.println("k instanceof Ogrenci = " + (k instanceof Ogrenci));

        System.out.println("\n--- Kapsulleme mirasi bozmuyor ---");
        Ogrenci o2 = new Ogrenci("Mehmet Alp Arslan", "98765432109", 2005, 455144, 5.0);
        System.out.println("ortalama = " + o2.getOrtalama());
        o2.setOrtalama(3.75);
        System.out.println("ortalama = " + o2.getOrtalama());
        System.out.println(o2.tanit());
    }
}