public class Gorev4_CokBicimlilikDemo {

    public static void main(String[] args)
    {
        Kisi k = new Kisi("Alp Arslan", "12345678901", 2006);
        System.out.println(k.tanit());

        Personel p = new Personel("Mehmet Alp", "24312393643", 2006, "Mühendis", 4 );
        System.out.println(p.tanit());

        Ogrenci o = new Ogrenci("Mehmet Alp Arslan", "98765432109", 2005, 376512, 3.92);
        System.out.println(o.tanit());

        Ogrenci o1 = new Ogrenci("Ogrenci", "11111111111", 2005, 376512, 3.92);
        System.out.println(o1.tanit());



    }




}
