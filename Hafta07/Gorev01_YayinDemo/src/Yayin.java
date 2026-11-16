public class Yayin {
    private static int sonrakiSira = 1;
    public static final int VARSAYILAN_GUN = 15;
    private final String demirbasNo;
    private final String baslik;
    private final int yil;
    protected boolean oduncte;
    protected String oduncAlan;


    public Yayin(String baslik, int yil) {
        if (baslik == null || baslik.trim().isEmpty()) {
            throw new IllegalArgumentException("Başlık boş olamaz.");
        }
        if (yil <= 0) {
            throw new IllegalArgumentException("Geçersiz yıl.");
        }
        this.demirbasNo = String.format("D-%04d", sonrakiSira++);
        this.baslik = baslik;
        this.yil = yil;
        this.oduncte = false;
        this.oduncAlan = null;
    }

    public final String getDemirbasNo()
    {
        return demirbasNo;
    }

    public String getBaslik()
    {
        return baslik;
    }
    public int getYil()
    {
        return  yil;
    }

    public boolean getOduncteMi()
    {
        return oduncte;
    }

    protected int oduncteGunSayisi()
    {
        return VARSAYILAN_GUN;
    }

    public boolean oduncVerilirmi()
    {
        return !oduncte;
    }

    public void oduncVer(String kime) {
        if (!oduncVerilirmi()) {
            System.out.println("  RET: " + demirbasNo + " zaten " + oduncAlan + " tarafindan alinmis.");
            return;
        }
        this.oduncte = true;
        this.oduncAlan = kime;
        System.out.println("  OK : " + demirbasNo + " -> " + kime + " (" + oduncteGunSayisi() + " gun)");
    }

    public void iadeAl() {
        if (!oduncte) {
            System.out.println("  RET: " + demirbasNo + " zaten rafta.");
            return;
        }
        String eskiAlan = this.oduncAlan;
        this.oduncte = false;
        this.oduncAlan = null;
        System.out.println("  OK : " + demirbasNo + " iade alindi (" + eskiAlan + ")");
    }

    public String kunye() {
        return demirbasNo + " | " + baslik + " (" + yil + ")";
    }




}
/*


}*/