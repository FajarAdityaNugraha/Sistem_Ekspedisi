import java.util.Scanner;

public class Ongkoskirim {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan berat barang (kg): ");
        double beratBarang = input.nextDouble();

        System.out.print("Masukkan jarak pengiriman (km): ");
        double jarakPengiriman = input.nextDouble();

        double ongkosKirim = 0.0;

        if (beratBarang <= 1) {
            if (jarakPengiriman <= 5) {
                ongkosKirim = 5000;
            } else {
                ongkosKirim = 10000;
            }
        } else if (beratBarang <= 10) {
            if (jarakPengiriman <= 10) {
                ongkosKirim = 10000;
            } else {
                ongkosKirim = 15000;
            }
        } else {
            if (jarakPengiriman <= 15) {
                ongkosKirim = 15000;
            } else {
                ongkosKirim = 20000;
            }
        }

        System.out.println("Ongkos kirim untuk barang berat " + beratBarang + " kg, dan jarak " + jarakPengiriman
                + " km adalah: Rp " + ongkosKirim);

        input.close();
    }
}
