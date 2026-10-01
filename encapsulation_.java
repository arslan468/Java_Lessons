import java.util.Scanner;

public class encapsulation_ {

    private int password = 123;

    public int getPassword()
    {
        return password;
    }

    public void setPassword(int newPassword)
    {
        password = newPassword;
    }


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        encapsulation_ nesne1 = new encapsulation_();

        System.out.println("Mevcut Şifre: "+ nesne1.getPassword());

        System.out.print("Yeni şifreyi giriniz:  ");
        int newPassword = scanner.nextInt();

        nesne1.setPassword(newPassword);

        System.out.println(("   Şifreniz güncellendi yeni şifreniz:  "+ nesne1.getPassword()));


    }
}
