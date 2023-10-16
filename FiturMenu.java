import java.util.Scanner;

public class FiturMenu {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Admin login untuk menginput data pengirim
        System.out.println("==================== Silahkan login terlebih dahulu =====================");
        System.out.println(); //
        System.out.print(" Masukkan Username anda  : ");
        String username = scanner.nextLine();
        System.out.print(" Masukkan Password Anda  : ");
        String password = scanner.nextLine();
        System.out.println(); //

        // Memeriksa apakah username dan password valid

        if (username.equals("ADMIN") && password.equals("OPERATOR123")) {
            System.out.println("=========================== login Berhasil ! ============================");

            Scanner input = new Scanner(System.in);
            int pilihan;

            do {
                System.out.println("Menu sistem ekspedisi");
                System.out.println("1. Input data pengirim ");
                System.out.println("2. input data penerima ");
                System.out.println("3. input data barang");
                System.out.print("Silahkan Pilih menu  1/2/3 : ");
                pilihan = input.nextInt();

                switch (pilihan) {
                    case 1:
                        System.out.println("Silahkan input data pengirim");
                        break;
                    case 2:
                        System.out.println("Silahkan input data penerima");
                        break;
                    case 3:
                        System.out.println("Silahkan input data Barang");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                        break;
                }
            } while (pilihan != 0);
        } else {
            System.out.println("Login gagal. Username atau password salah.");
        }

    }
}
