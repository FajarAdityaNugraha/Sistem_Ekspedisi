import java.util.Scanner;

/**
 * PenjadwalanPengiriman
 */
public class PenjadwalanPengiriman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Inisialisasi data armada dan rute
        String[] armada = {"Armada 1", "Armada 2", "Armada 3"};
        String[] rute = {"Rute A", "Rute B", "Rute C"};

        // Input jumlah paket
        System.out.print("Masukkan jumlah paket: ");
        int jumlahPaket = input.nextInt();

        // Inisialisasi array untuk menyimpan jadwal pengiriman
        String[][] jadwalPengiriman = new String[jumlahPaket][2];

        // Loop untuk setiap paket
        for (int i = 0; i < jumlahPaket; i++) {
            System.out.println("Paket " + (i + 1) + ":");
            System.out.print("  - Berat (kg): ");
            int berat = input.nextInt();
            System.out.print("  - Volume (m3): ");
            double volume = input.nextDouble();

            // Loop untuk setiap armada
            for (String armadaItem : armada) {
                // Loop untuk setiap rute
                for (String ruteItem : rute) {
                    // Lakukan penjadwalan pengiriman di sini (contoh: jika berat <= 100 dan volume <= 5)
                    if (berat <= 100 && volume <= 5) {
                        jadwalPengiriman[i][0] = armadaItem;
                        jadwalPengiriman[i][1] = ruteItem;
                    }
                }
            }
        }

        // Tampilkan jadwal pengiriman
        for (int i = 0; i < jumlahPaket; i++) {
            System.out.println("Paket " + (i + 1) + " dikirim dengan " + jadwalPengiriman[i][0] + " melalui " + jadwalPengiriman[i][1]);
        }

        input.close();
    }
}
