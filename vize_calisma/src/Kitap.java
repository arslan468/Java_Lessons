public class Kitap {
    private final String baslik;

    public Kitap(String baslik){
        this.baslik=baslik;
        System.out.println("Kitap çalişti");
    }

    public String getBaslik(){
        return baslik;
    }

    public String tanit(){
        return "Kitap: " + baslik;
    }
}

class Roman extends Kitap{
    private final String yazar;

    public Roman(String baslik, String yazar){
        super(baslik);
        this.yazar = yazar;
        System.out.println("Roman çalıştı");
    }

    @Override
    public String tanit(){
        return super.tanit() + " | Yazar: " + yazar;
    }

}
