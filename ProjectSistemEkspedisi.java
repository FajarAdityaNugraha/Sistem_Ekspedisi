import java.util.Scanner;

public class ProjectSistemEkspedisi {

        public static void main(String[] args) {
                Scanner inputEkspedisi = new Scanner(System.in);
                int maxPengiriman = 10;
                String[][] dataPengiriman = new String[maxPengiriman][14];
                String username, password;

                do {
                        System.out.println("==================== Silahkan Login terlebih dahulu =====================");
                        System.out.println();
                        System.out.print(" Masukkan Username anda  : ");
                        username = inputEkspedisi.nextLine();
                        System.out.print(" Masukkan Password Anda  : ");
                        password = inputEkspedisi.nextLine();
                        System.out.println();
                        // Memeriksa apakah username dan password valid
                        if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
                                System.out.println(
                                                "=========================== login Berhasil ! ============================");
                                System.out.println();//
                                byte Pilihan;
                                byte Pilih; // Declare the variable outside the do-while loop
                                boolean kembaliKeMenuUtama = false;

                                do {
                                        System.out.println();
                                        System.out.println(
                                                        "=======================================================================");
                                        System.out.println(
                                                        "|                           Selamat Datang !                          |");
                                        System.out.println(
                                                        "|                Beranda Admin Sistem Ekspedisi Pattimura             |");
                                        System.out.println(
                                                        "|=====================================================================|");
                                        System.out.println(
                                                        "|                                                                     |");
                                        System.out.println(
                                                        "| 1. Data Pengiriman                                                  |");
                                        System.out.println(
                                                        "| 2. Pilih Layanan Ekspedisi                                          |");
                                        System.out.println(
                                                        "| 3. Konfirmasi Pembayaran                                            |");
                                        System.out.println(
                                                        "| 4. Penjadwalan Pengiriman                                           |");
                                        System.out.println(
                                                        "| 5. Update Pengiriman                                                |");
                                        System.out.println(
                                                        "| 6. Riwayat Pengiriman                                               |");
                                        System.out.println(
                                                        "| 7. Penilaian Pelanggan                                              |");
                                        System.out.println(
                                                        "| 8. Return Barang                                                    |");
                                        System.out.println(
                                                        "| 0. Log out                                                          |");
                                        System.out.println(
                                                        "|                                                                     |");
                                        System.out.println(
                                                        "=======================================================================");
                                        System.out.print(" Pilih Menu : ");
                                        Pilih = inputEkspedisi.nextByte();
                                        System.out.println(
                                                        "-----------------------------------------------------------------------");
                                        System.out.println();
                                        switch (Pilih) {
                                                case 1:
                                                        do {
                                                                // Sub Menu Pada Pilihan 1
                                                                System.out.println();//
                                                                System.out.println("1. Tambah data pengiriman");
                                                                System.out.println(
                                                                                "2. Tampilkan Semua Data Pengiriman");
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
                                                                                                        "========================= DATA PENGIRIMAN KE-"
                                                                                                                        + (i + 1)
                                                                                                                        + " ========================");
                                                                                        System.out
                                                                                                        .println(
                                                                                                                        "----------------------- Masukkan Data Pengirim ------------------------");
                                                                                        System.out.print(
                                                                                                        " Nama Pengirim            : ");
                                                                                        dataPengiriman[i][1] = inputEkspedisi
                                                                                                        .nextLine();
                                                                                        System.out.print(
                                                                                                        " Alamat Pengirim          : ");
                                                                                        dataPengiriman[i][2] = inputEkspedisi
                                                                                                        .nextLine();
                                                                                        System.out.print(
                                                                                                        " Nomor Telepon Pengirim   : ");
                                                                                        dataPengiriman[i][3] = inputEkspedisi
                                                                                                        .nextLine();
                                                                                        System.out.print(
                                                                                                        " Email Pengirim           : ");
                                                                                        dataPengiriman[i][4] = inputEkspedisi
                                                                                                        .nextLine();
                                                                                        System.out
                                                                                                        .println("----------------------- Masukkan Data Penerima ------------------------");
                                                                                        System.out.print(
                                                                                                        " Nama Penerima            : ");
                                                                                        dataPengiriman[i][5] = inputEkspedisi
                                                                                                        .nextLine();
                                                                                        System.out.print(
                                                                                                        " Alamat Penerima          : ");
                                                                                        dataPengiriman[i][6] = inputEkspedisi
                                                                                                        .nextLine();
                                                                                        System.out.print(
                                                                                                        " Nomor Telepon Penerima   : ");
                                                                                        dataPengiriman[i][7] = inputEkspedisi
                                                                                                        .nextLine();
                                                                                        System.out.print(
                                                                                                        " Email Penerima           : ");
                                                                                        dataPengiriman[i][8] = inputEkspedisi
                                                                                                        .nextLine();
                                                                                        System.out
                                                                                                        .println("----------------------- Masukkan Data Barang --------------------------");
                                                                                        System.out.print(
                                                                                                        " Nama Barang              : ");
                                                                                        dataPengiriman[i][9] = inputEkspedisi
                                                                                                        .nextLine();
                                                                                        System.out.print(
                                                                                                        " Jumlah Barang            : ");
                                                                                        dataPengiriman[i][10] = inputEkspedisi
                                                                                                        .nextLine();
                                                                                        System.out.print(
                                                                                                        " Berat Barang             : ");
                                                                                        dataPengiriman[i][11] = inputEkspedisi
                                                                                                        .nextLine();
                                                                                        System.out.print(
                                                                                                        " Total Jarak Pengiriman   : ");
                                                                                        dataPengiriman[i][12] = inputEkspedisi
                                                                                                        .nextLine();
                                                                                        System.out.print(
                                                                                                        " Deskripsi (Opsional)     : ");
                                                                                        dataPengiriman[i][13] = inputEkspedisi
                                                                                                        .nextLine();
                                                                                        System.out.println(
                                                                                                        "---------------------------------------------------------------------");
                                                                                        System.out.println(
                                                                                                        "Apakah Anda ingin input data pengiriman lagi ? ");
                                                                                        System.out.println(
                                                                                                        "[ 1 untuk 'Iya'  ]");
                                                                                        System.out.println(
                                                                                                        "[ 0 untuk 'Tidak ]");
                                                                                        System.out.print(
                                                                                                        "Pilih Salah Satu          : ");
                                                                                        int lanjut = inputEkspedisi
                                                                                                        .nextInt();
                                                                                        System.out.println(
                                                                                                        "=====================================================================");
                                                                                        System.out.println();

                                                                                        if (lanjut == 0) {
                                                                                                break;
                                                                                        }

                                                                                }

                                                                                break;
                                                                        case 2: // Halaman untuk Menampilkan semua Data
                                                                                // yang sudah diinput

                                                                                System.out.println(
                                                                                                "=======================================================================");
                                                                                System.out.println(
                                                                                                "|                             Data Pengiriman                         |");
                                                                                System.out.println(
                                                                                                "=======================================================================");
                                                                                System.out.println();

                                                                                for (int i = 0; i < maxPengiriman; i++) {
                                                                                        if (dataPengiriman[i][0] != null
                                                                                                        && !dataPengiriman[i][0]
                                                                                                                        .isEmpty()) {

                                                                                                System.out.println(
                                                                                                                "======================= DATA PENGIRIMAN KE-"
                                                                                                                                + (i + 1)
                                                                                                                                + " =======================");
                                                                                                System.out.println(
                                                                                                                "====================================================================");
                                                                                                System.out
                                                                                                                .println(
                                                                                                                                "-------------------------- Pengirim --------------------------------");
                                                                                                System.out.print(
                                                                                                                " Nama Pengirim            : ");
                                                                                                dataPengiriman[i][1] = inputEkspedisi
                                                                                                                .nextLine();
                                                                                                System.out.print(
                                                                                                                " Alamat Pengirim          : ");
                                                                                                dataPengiriman[i][2] = inputEkspedisi
                                                                                                                .nextLine();
                                                                                                System.out.print(
                                                                                                                " Nomor Telepon Pengirim   : ");
                                                                                                dataPengiriman[i][3] = inputEkspedisi
                                                                                                                .nextLine();
                                                                                                System.out.print(
                                                                                                                " Email Pengirim           : ");
                                                                                                dataPengiriman[i][4] = inputEkspedisi
                                                                                                                .nextLine();
                                                                                                System.out
                                                                                                                .println("----------------------- Masukkan Data Penerima ------------------------");
                                                                                                System.out.print(
                                                                                                                " Nama Penerima            : ");
                                                                                                dataPengiriman[i][5] = inputEkspedisi
                                                                                                                .nextLine();
                                                                                                System.out.print(
                                                                                                                " Alamat Penerima          : ");
                                                                                                dataPengiriman[i][6] = inputEkspedisi
                                                                                                                .nextLine();
                                                                                                System.out.print(
                                                                                                                " Nomor Telepon Penerima   : ");
                                                                                                dataPengiriman[i][7] = inputEkspedisi
                                                                                                                .nextLine();
                                                                                                System.out.print(
                                                                                                                " Email Penerima           : ");
                                                                                                dataPengiriman[i][8] = inputEkspedisi
                                                                                                                .nextLine();
                                                                                                System.out
                                                                                                                .println("----------------------- Masukkan Data Barang --------------------------");
                                                                                                System.out.print(
                                                                                                                " Nama Barang              : ");
                                                                                                dataPengiriman[i][9] = inputEkspedisi
                                                                                                                .nextLine();
                                                                                                System.out.print(
                                                                                                                " Jumlah Barang            : ");
                                                                                                dataPengiriman[i][10] = inputEkspedisi
                                                                                                                .nextLine();
                                                                                                System.out.print(
                                                                                                                " Berat Barang             : ");
                                                                                                dataPengiriman[i][11] = inputEkspedisi
                                                                                                                .nextLine();
                                                                                                System.out.print(
                                                                                                                " Total Jarak Pengiriman   : ");
                                                                                                dataPengiriman[i][12] = inputEkspedisi
                                                                                                                .nextLine();
                                                                                                System.out.print(
                                                                                                                " Deskripsi (Opsional)     : ");
                                                                                                dataPengiriman[i][13] = inputEkspedisi
                                                                                                                .nextLine();
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
                                                        } while (!kembaliKeMenuUtama); // Anda bisa menentukan kriteria
                                                                                       // berhenti perulangan di sini
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
                                                                if (dataPengiriman[i][0] != null
                                                                                && !dataPengiriman[i][0].isEmpty()) {
                                                                        if (nomorPesananCari == i + 1) {
                                                                                ditemukan = true;

                                                                                inputEkspedisi.nextLine();
                                                                                System.out.println(
                                                                                                "======================= DATA PENGIRIMAN KE-"
                                                                                                                + (i + 1)
                                                                                                                + " =======================");
                                                                                System.out
                                                                                                .println(
                                                                                                                "====================================================================");
                                                                                System.out.println();
                                                                                System.out
                                                                                                .println(
                                                                                                                "-------------------------- Pengirim --------------------------------");
                                                                                System.out.print(
                                                                                                " Nama Pengirim            : ");
                                                                                dataPengiriman[i][1] = inputEkspedisi
                                                                                                .nextLine();
                                                                                System.out.print(
                                                                                                " Alamat Pengirim          : ");
                                                                                dataPengiriman[i][2] = inputEkspedisi
                                                                                                .nextLine();
                                                                                System.out.print(
                                                                                                " Nomor Telepon Pengirim   : ");
                                                                                dataPengiriman[i][3] = inputEkspedisi
                                                                                                .nextLine();
                                                                                System.out.print(
                                                                                                " Email Pengirim           : ");
                                                                                dataPengiriman[i][4] = inputEkspedisi
                                                                                                .nextLine();
                                                                                System.out
                                                                                                .println("----------------------- Masukkan Data Penerima ------------------------");
                                                                                System.out.print(
                                                                                                " Nama Penerima            : ");
                                                                                dataPengiriman[i][5] = inputEkspedisi
                                                                                                .nextLine();
                                                                                System.out.print(
                                                                                                " Alamat Penerima          : ");
                                                                                dataPengiriman[i][6] = inputEkspedisi
                                                                                                .nextLine();
                                                                                System.out.print(
                                                                                                " Nomor Telepon Penerima   : ");
                                                                                dataPengiriman[i][7] = inputEkspedisi
                                                                                                .nextLine();
                                                                                System.out.print(
                                                                                                " Email Penerima           : ");
                                                                                dataPengiriman[i][8] = inputEkspedisi
                                                                                                .nextLine();
                                                                                System.out
                                                                                                .println("----------------------- Masukkan Data Barang --------------------------");
                                                                                System.out.print(
                                                                                                " Nama Barang              : ");
                                                                                dataPengiriman[i][9] = inputEkspedisi
                                                                                                .nextLine();
                                                                                System.out.print(
                                                                                                " Jumlah Barang            : ");
                                                                                dataPengiriman[i][10] = inputEkspedisi
                                                                                                .nextLine();
                                                                                System.out.print(
                                                                                                " Berat Barang             : ");
                                                                                dataPengiriman[i][11] = inputEkspedisi
                                                                                                .nextLine();
                                                                                System.out.print(
                                                                                                " Total Jarak Pengiriman   : ");
                                                                                dataPengiriman[i][12] = inputEkspedisi
                                                                                                .nextLine();
                                                                                System.out.print(
                                                                                                " Deskripsi (Opsional)     : ");
                                                                                dataPengiriman[i][13] = inputEkspedisi
                                                                                                .nextLine();
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
                                                case 4:
                                                        break;
                                                case 5:
                                                        break;
                                                case 6:
                                                        break;
                                                case 7:
                                                        break;
                                                case 8:
                                                        break;
                                                case 0:
                                                        System.out.println(
                                                                        "------------------------- Anda telah Log out! ------------------------");
                                                        System.exit(0);
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
                                System.out.println(
                                                "---------------- Login gagal!Username atau password salah ---------------");
                                System.out.println(
                                                "--------------------------- Silahkan Coba Lagi --------------------------");
                                System.out.println();//
                        }
                } while (true);

        }
}
