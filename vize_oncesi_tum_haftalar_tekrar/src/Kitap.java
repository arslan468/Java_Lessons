public class Kitap {
    private final String isbn;
    private int toplamAdet;
    private int odunctekiAdet=0;
    private Yazar yazar;
    private static int olusturulanKitapSayisi=0;


    public Kitap(String isbn, int toplamAdet) {
        this(isbn, toplamAdet,new Yazar("Bilinmiyor"));
    }

    public Kitap(String isbn, int toplamAdet, Yazar yazar){
        kontrolIsbn(isbn);
        kontrolAdet(toplamAdet);
        this.isbn=isbn;
        this.toplamAdet=toplamAdet;
        olusturulanKitapSayisi++;
        this.yazar=yazar;
    }

    private void kontrolIsbn(String isbn){
        if (isbn == null ||  isbn.isBlank()){
            throw new IllegalArgumentException("İsbn boş olamaz");
        }
    }

    private void kontrolAdet(int toplamAdet){
        if (toplamAdet<0){
            throw new IllegalArgumentException("Toplam adet pozitif olmalıdır!");
        }
    }

    public String getYazarAdi(){
        return yazar.getAd();
    }

    public String getIsbn(){
        return isbn;
    }

    public boolean oduncVer(){
        if (getKalanAdet()>0){
            odunctekiAdet++;
            System.out.println("Ödünç verildi");
            return true;
        }
        System.out.println("Ödünç verilemedi");
        return false;
    }

    public int getKalanAdet(){
        return toplamAdet-odunctekiAdet;
    }

    public Kitap(Kitap diger) {
        this(diger.isbn, diger.toplamAdet, new Yazar(diger.yazar.getAd()));
        this.odunctekiAdet = diger.odunctekiAdet;
    }

    public static Kitap tekNusha(String isbn) {
        return new Kitap(isbn,1);
    }








}

final class KitapKimligi{
    private final String isbn;
    private final String dilKodu;

    public KitapKimligi(String isbn, String dilKodu){
        this.isbn=isbn;
        this.dilKodu=dilKodu;
    }

    public String getIsbn(){
        return isbn;
    }

    public String getDilKodu(){
        return dilKodu;
    }
}

class Yazar{
    private String ad;

    public Yazar(String ad){
        this.ad=ad;
    }

    public String getAd(){
        return ad;
    }

    public void setAd(String ad){
        this.ad = ad;
    }
}

class OduncRaporu implements AutoCloseable {
    public void yaz() {
        throw new IllegalStateException("Yazma hatası");
    }

    @Override
    public void close() {
        System.out.println("Rapor kapatıldı");
    }
}