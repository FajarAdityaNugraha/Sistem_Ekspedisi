import java.util.Scanner;

public class ProgressSistemEkspedisi {

    public static void main(String[] args) {
        Scanner inputEkspedisi = new Scanner(System.in);
        int maxPengiriman = 10;
        String[][] dataPengirim = new String[maxPengiriman][4];
        String[][] dataPenerima = new String[maxPengiriman][4];
        String[][] dataBarang = new String[maxPengiriman][4];
        String username, password, Lanjut;

        do {
            System.out.println("==================== Silahkan Login terlebih dahulu =====================");
            System.out.println();
            System.out.print(" Masukkan Username anda  : ");
            username = inputEkspedisi.nextLine();
            System.out.print(" Masukkan Password Anda  : ");
            password = inputEkspedisi.nextLine();
            System.out.println();
            // Memeriksa apakah username dan password valid
            if (username.equalsIgnoreCase("a") && password.equalsIgnoreCase("a")) {
                System.out.println("=========================== login Berhasil ! ============================");
                System.out.println();//
                byte Pilihan;
                byte Pilih; // Declare the variable outside the do-while loop
                boolean kembaliKeMenuUtama = false;

                do {
                    System.out.println();
                    System.out.println("=======================================================================");
                    System.out.println("|                           Selamat Datang !                          |");
                    System.out.println("|                Beranda Admin Sistem Ekspedisi Pattimura             |");
                    System.out.println("|=====================================================================|");
                    System.out.println("|                                                                     |");
                    System.out.println("| 1. Data Pengiriman                                                  |");
                    System.out.println("| 2. Pilih Layanan Ekspedisi                                          |");
                    System.out.println("| 3. Konfirmasi Pembayaran                                            |");
                    System.out.println("| 4. Penjadwalan Pengiriman                                           |");
                    System.out.println("| 5. Update Pengiriman                                                |");
                    System.out.println("| 6. Riwayat Pengiriman                                               |");
                    System.out.println("| 7. Penilaian Pelanggan                                              |");
                    System.out.println("| 8. Return Barang                                                    |");
                    System.out.println("| 0. Log out                                                          |");
                    System.out.println("|                                                                     |");
                    System.out.println("=======================================================================");
                    System.out.print(" Pilih Menu : ");
                    Pilih = inputEkspedisi.nextByte();
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println();
                    switch (Pilih) {
                        case 1:
                            do {
                                // Sub Menu Pada Pilihan 1
                                System.out.println();//
                                System.out.println("1. Tambah data pengiriman");
                                System.out.println("2. Tampilkan Semua Data Pengiriman");
                                System.out.println("3. Kembali ke Menu Utama");
                                System.out.print("Silahkan pilih menu : ");
                                Byte SubMenuPilihan = inputEkspedisi.nextByte();

                                switch (SubMenuPilihan) {
                                    case 1: // Halaman Tambah Data Pengiriman

                                        for (int i = 0; i < maxPengiriman; i++) {
                                            inputEkspedisi.nextLine();
                                            System.out.println(
                                                    "=======================================================================");
                                            System.out.println(
                                                    "|                    Silahkan input Data Pengiriman                   |");
                                            System.out.println(
                                                    "=======================================================================");
                                            System.out.println();
                                            System.out.println(
                                                    "========================= DATA PENGIRIMAN KE-" + (i + 1)
                                                            + " ========================");
                                            System.out
                                                    .println(
                                                            "----------------------- Masukkan Data Pengirim ------------------------");
                                            System.out.print(" Nama Pengirim            : ");
                                            dataPengirim[i][0] = inputEkspedisi.nextLine();
                                            System.out.print(" Alamat Pengirim          : ");
                                            dataPengirim[i][1] = inputEkspedisi.nextLine();
                                            System.out.print(" Nomor Telepon Pengirim   : ");
                                            dataPengirim[i][2] = inputEkspedisi.nextLine();
                                            System.out.print(" Email Pengirim           : ");
                                            dataPengirim[i][3] = inputEkspedisi.nextLine();
                                            System.out
                                                    .println(
                                                            "----------------------- Masukkan Data Penerima ------------------------");
                                            System.out.print(" Nama Penerima            : ");
                                            dataPenerima[i][0] = inputEkspedisi.nextLine();
                                            System.out.print(" Alamat Penerima          : ");
                                            dataPenerima[i][1] = inputEkspedisi.nextLine();
                                            System.out.print(" Nomor Telepon Penerima   : ");
                                            dataPenerima[i][2] = inputEkspedisi.nextLine();
                                            System.out.print(" Email Penerima           : ");
                                            dataPenerima[i][3] = inputEkspedisi.nextLine();
                                            System.out
                                                    .println(
                                                            "----------------------- Masukkan Data Barang --------------------------");
                                            System.out.print(" Nama Barang              : ");
                                            dataBarang[i][0] = inputEkspedisi.nextLine();
                                            System.out.print(" Jumlah Barang            : ");
                                            dataBarang[i][1] = inputEkspedisi.nextLine();
                                            System.out.print(" Berat Barang             : ");
                                            dataBarang[i][2] = inputEkspedisi.nextLine();
                                            System.out.print(" Deskripsi (Opsional)     : ");
                                            dataBarang[i][3] = inputEkspedisi.nextLine();
                                            System.out.println(
                                                    "---------------------------------------------------------------------");
                                            System.out.println("Apakah Anda ingin input data pengiriman lagi ? ");
                                            System.out.println("[ 1 untuk 'Iya'  ]");
                                            System.out.println("[ 0 untuk 'Tidak ]");
                                            System.out.print("Pilih Salah Satu          : ");
                                            int lanjut = inputEkspedisi.nextInt();
                                            System.out.println(
                                                    "=====================================================================");
                                            System.out.println();

                                            if (lanjut == 0) {
                                                break;
                                            }

                                        }

                                        break;
                                    case 2: // Halaman untuk Menampilkan semua Data yang sudah diinput

                                        System.out.println(
                                                "=======================================================================");
                                        System.out.println(
                                                "|                             Data Pengiriman                         |");
                                        System.out.println(
                                                "=======================================================================");
                                        System.out.println();

                                        for (int i = 0; i < maxPengiriman; i++) {
                                            if (dataPengirim[i][0] != null && !dataPengirim[i][0].isEmpty()) {

                                                System.out.println(
                                                        "======================= DATA PENGIRIMAN KE-" + (i + 1)
                                                                + " =======================");
                                                System.out.println(
                                                        "====================================================================");
                                                System.out
                                                        .println(
                                                                "-------------------------- Pengirim --------------------------------");
                                                System.out.println(" Nama Pengirim            : " + dataPengirim[i][0]);
                                                System.out.println(" Alamat Pengirim          : " + dataPengirim[i][1]);
                                                System.out.println(" Nomor Telepon Pengirim   : " + dataPengirim[i][2]);
                                                System.out.println(" Email Pengirim           : " + dataPengirim[i][3]);
                                                System.out
                                                        .println(
                                                                "-------------------------- Pengirim --------------------------------");
                                                System.out.println(" Nama Penerima            : " + dataPenerima[i][0]);
                                                System.out.println(" Alamat Penerima          : " + dataPenerima[i][1]);
                                                System.out.println(" Nomor Telepon Penerima   : " + dataPenerima[i][2]);
                                                System.out.println(" Email Penerima           : " + dataPenerima[i][3]);
                                                System.out
                                                        .println(
                                                                "------------------------ Detail Barang -----------------------------");
                                                System.out.println(" Nama Barang              : " + dataBarang[i][0]);
                                                System.out.println(
                                                        " Jumlah Barang            : " + dataBarang[i][1] + " Pcs");
                                                System.out.println(
                                                        " Berat Barang             : " + dataBarang[i][2] + " Kg");
                                                System.out.println(
                                                        " Jarak Pengiriman         : " + dataBarang[i][3] + " Km");
                                                System.out.println(" Deskripsi (Opsional)     : " + dataBarang[i][4]);
                                                System.out
                                                        .println(
                                                                "====================================================================");
                                                System.out.println();
                                            }

                                        }
                                        break;
                                    case 3: // Kembali ke Menu Utama
                                        kembaliKeMenuUtama = true;
                                        break;
                                    default:
                                        System.out.println();//
                                        System.out.println(
                                                "------------------------- Pilihan Tidak Valid! ------------------------");
                                }
                            } while (!kembaliKeMenuUtama); // Anda bisa menentukan kriteria berhenti perulangan di sini
                            System.out.println();//
                            break;

                        case 2:
                            System.out.println();
                            System.out
                                    .println("=======================================================================");
                            System.out
                                    .println("|                        Pilih Layanan Ekspedisi                      |");
                            System.out
                                    .println("=======================================================================");
                            System.out
                                    .println("------------------ Cari Nomor Pesanan Terlebih dahulu -----------------");
                            System.out.println();
                            System.out.print(" Silahkan Cari Data Pengiriman Ke- : ");
                            int nomorPesananCari = inputEkspedisi.nextInt();
                            System.out
                                    .println("-----------------------------------------------------------------------");
                            boolean ditemukan = false;
                            System.out.println();
                            for (int i = 0; i < maxPengiriman; i++) {
                                if (dataPengirim[i][0] != null && !dataPengirim[i][0].isEmpty()) {
                                    if (nomorPesananCari == i + 1) {
                                        ditemukan = true;

                                        inputEkspedisi.nextLine();
                                        System.out.println(
                                                "======================= DATA PENGIRIMAN KE-" + (i + 1)
                                                        + " =======================");
                                        System.out
                                                .println(
                                                        "====================================================================");
                                        System.out.println();
                                        System.out
                                                .println(
                                                        "-------------------------- Pengirim --------------------------------");
                                        System.out.println(" Nama Pengirim            : " + dataPengirim[i][0]);
                                        System.out.println(" Alamat Pengirim          : " + dataPengirim[i][1]);
                                        System.out.println(" Nomor Telepon Pengirim   : " + dataPengirim[i][2]);
                                        System.out.println(" Email Pengirim           : " + dataPengirim[i][3]);
                                        System.out
                                                .println(
                                                        "-------------------------- Pengirim --------------------------------");
                                        System.out.println(" Nama Penerima            : " + dataPenerima[i][0]);
                                        System.out.println(" Alamat Penerima          : " + dataPenerima[i][1]);
                                        System.out.println(" Nomor Telepon Penerima   : " + dataPenerima[i][2]);
                                        System.out.println(" Email Penerima           : " + dataPenerima[i][3]);
                                        System.out
                                                .println(
                                                        "------------------------ Detail Barang -----------------------------");
                                        System.out.println(" Nama Barang              : " + dataBarang[i][0]);
                                        System.out.println(" Jumlah Barang            : " + dataBarang[i][1] + " Pcs");
                                        System.out.println(" Berat Barang             : " + dataBarang[i][2] + " Kg");
                                        System.out.println(" Deskripsi (Opsional)     : " + dataBarang[i][4]);
                                        System.out
                                                .println(
                                                        "====================================================================");
                                        System.out.println();
                                    }
                                }
                            }
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println();//
                            System.out.println(
                                    "------------------------- Pilihan Tidak Valid! ------------------------");
                            System.out.println(
                                    "-------------------------- Silahkan Coba Lagi -------------------------");
                            System.out.println();//
                    }

                } while (Pilih != 0);

            } else {
                System.out.println("---------------- Login gagal!Username atau password salah ---------------");
                System.out.println("--------------------------- Silahkan Coba Lagi --------------------------");
                System.out.println();//
            }
        } while (true);

    }
}
