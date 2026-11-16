public class Dergi extends Yayin{
    public static final int DERGI_GUN = 7;
    private final int sayiNo;
    private final String periyot;
    protected boolean guncelSayi;

    public Dergi(String baslik, int yil, int sayiNo, String periyot, boolean guncelSayi) {
        super(baslik, yil);
        if (sayiNo <= 0) {
            throw new IllegalArgumentException("Sayı numarası pozitif olmalıdır.");
        }
        if (periyot == null || periyot.trim().isEmpty()) {
            throw new IllegalArgumentException("Periyot boş olamaz.");
        }
        this.sayiNo = sayiNo;
        this.periyot = periyot;
        this.guncelSayi = guncelSayi;
    }

    public int getSayiNo()
    {
        return sayiNo;
    }
    public String getPeriyot()
    {
        return periyot;
    }
    public boolean guncelSayiMi()
    {
        return guncelSayi;
    }
    public void arsivleyeAl()
    {
        this.guncelSayi = false;
        System.out.println(" " + getDemirbasNo()+"arşivde ödünç verilir");
    }

    @Override
    protected int oduncteGunSayisi()
    {
        return DERGI_GUN;
    }



}
