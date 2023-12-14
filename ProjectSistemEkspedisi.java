import java.util.Random;
import java.util.Scanner;

public class ProjectSistemEkspedisi {
    public static Scanner inputEkspedisi = new Scanner(System.in);
    // Deklarasi Array
    public static int maxPengiriman = 10;
    public static String[][] dataPengiriman = new String[maxPengiriman][30];
    // Deklarasi indeks
    public static int i = 0;
    // Deklarasi variabel untuk menghitung Ongkir
    public static double JarakPengiriman = 0.0, biayaOngkir = 0.0, BeratBarang = 0.0;
    public static int JumlahBarang = 0;
    // Konfirmasi Pembayaran
    public static boolean pembayaranSelesai;
    // deklarasi variabel random
    private static Random random = new Random();
    // Array Feedback
    public static int maxFeedback = 10;
    public static String[][] dataFeedback = new String[maxFeedback][6];

    // fungsi untuk membuat No Resi
    public static String BuatNoResi() {
        int Resi = random.nextInt(100000);
        return String.valueOf(Resi);
    }

    // fungsi untuk Menyimpan nilai didalam variabel Resi kedalam array
    public static void inisialisasiDataNoResi() {
        for (int i = maxPengiriman - 1; i >= 0; i--) {
            // Menyimpan Nilai agar tidak berubah-ubah saat ditampilkan kembali
            if (dataPengiriman[i][0] == null) {
                dataPengiriman[i][0] = BuatNoResi();
                i++;
            }
        }
    }

    // Inialisasi biaya ongkir
    public static void inisialisasiOngkir(double biayaOngkir) {
        // Menyimpan Nilai dari variabel biaya ongkir kedalam array
        dataPengiriman[i][14] = String.valueOf(biayaOngkir);
    }

    // Deklarasi data pengiriman pertama
    public static void inialisasipengirimanpertama() {
        dataPengiriman[0][1] = " Vanessa"; // Nama Pengirim
        dataPengiriman[0][2] = " Jl. Simbar Menjangan"; // Alamat Pengirim
        dataPengiriman[0][3] = " 085812431350"; // Nomor Telepon Pengirim
        dataPengiriman[0][4] = " cristinvanessa6@gmail.com"; // Email Pengirim
        dataPengiriman[0][5] = " Salsa"; // Nama Penerima
        dataPengiriman[0][6] = " Jl. Kahyangan"; // Alamat Penerima
        dataPengiriman[0][7] = " 0845873452721"; // Nomor Telepon Penerima
        dataPengiriman[0][8] = " salsabila@gmail.com"; // Email Penerima
        dataPengiriman[0][9] = " Baju"; // Nama Barang
        dataPengiriman[0][10] = " 15"; // Jumlah Barang
        dataPengiriman[0][11] = " 2.3"; // Berat Barang
        dataPengiriman[0][12] = " 23.7"; // Total Jarak Pengiriman
        dataPengiriman[0][13] = " Baju Thrift"; // Deskripsi (Opsional)
        i++;
    }

    public static void inisialisasiPembayaran() {

    }

    public static void main(String[] args) {
        // Tampilan Menu Utama sistem Ekspedisi
        BerandaSistemEkspedisi();
    }

    public static void BerandaSistemEkspedisi() {
        do {
            System.out.println();
            System.out.println("=======================================================================");
            System.out.println("|                           Selamat Datang !                          |");
            System.out.println("|                         Ekspedisi Pattimura                         |");
            System.out.println("|=====================================================================|");
            System.out.println("|                                                                     |");
            System.out.println("| 1. Login ( Khusus Admin )                                           |");
            System.out.println("| 2. Cek Paket                                                        |");
            System.out.println("|                                                                     |");
            System.out.println("=======================================================================");
            System.out.print(" Pilih Menu : ");
            byte Pilih = inputEkspedisi.nextByte();
            System.out.println("-----------------------------------------------------------------------");
            System.out.println();
            switch (Pilih) {
                case 1:
                    logIn();
                    break;
                case 2:
                    BerandaPelanggan();
                    break;
                default:
                    System.out.println();
                    System.out.println("------------------------- Pilihan Tidak Valid! ------------------------");
            }
        } while (true);
    }

    // Variabel Global data untuk login
    public static String username = "", password = "";

    public static void logIn() {
        inputEkspedisi.nextLine();
        String[][] LoginUser = {
                { "admin1", "admin1", "1" },
                { "admin2", "admin2", "1" },
                { "admin3", "admin3", "1" }, };

        byte Kesempatan = 0;
        // Halaman Login !
        while (Kesempatan < 3) {
            System.out.println("=================== Silahkan Login terlebih dahulu ====================");
            System.out.print(" Masukkan Username anda  : ");
            username = inputEkspedisi.nextLine();
            System.out.print(" Masukkan Password Anda  : ");
            password = inputEkspedisi.nextLine();
            System.out.println();
            System.out.println("=======================================================================");
            System.out.println();

            for (String[] user : LoginUser) {
                String storedUsername = user[0];
                String storedPassword = user[1];
                String role = user[2];
                // Tampilan Jika Login Berhasil !
                if (storedUsername.equals(username) && storedPassword.equals(password) && role.equals("1")) {
                    System.out.println("Selamat datang " + username);
                    System.out.println("=======================================================================");
                    System.out.println("|                           Login Berhasil !                          |");
                    System.out.println("=======================================================================");
                    BerandaAdmin();
                } else { // Tampilan Jika Login Gagal !
                    continue;
                }
            }
            System.out.println("|=====================================================================|");
            System.out.println("|             Login gagal. Username atau password salah !             |");
            System.out.println("|                         Silahkan Coba Lagi                          |");
            System.out.println("|=====================================================================|");
            Kesempatan++;
        }
        if (Kesempatan == 3) { // Jika Login gagal lebih dari 3 kali maka akan keluar dari program
            System.out.println();
            System.out.println("|=====================================================================|");
            System.out.println("|                Anda telah melebihi batas upaya login !              |");
            System.out.println("|=====================================================================|");
            System.exit(0);
        }
    }

    private static void BerandaPelanggan() {
        do {
            System.out.println();
            System.out.println("=======================================================================");
            System.out.println("|                         Ekspedisi Pattimura                         |");
            System.out.println("|=====================================================================|");
            System.out.println("|                                                                     |");
            System.out.println("| 1.  Cek Paket Anda                                                  |");
            System.out.println("| 2.  Feedback                                                        |");
            System.out.println("| 0.  Kembali                                                         |");
            System.out.println("|                                                                     |");
            System.out.println("=======================================================================");
            System.out.print(" Pilih Menu : ");
            byte Pilih = inputEkspedisi.nextByte();
            System.out.println("-----------------------------------------------------------------------");
            System.out.println();
            switch (Pilih) {
                case 1:
                    cekPaket();
                    break;
                case 2:
                    feedbackPelanggan();
                    break;
                case 0:
                    BerandaSistemEkspedisi();
                    break;
                default:
                    System.out.println();
                    System.out.println("------------------------- Pilihan Tidak Valid! ------------------------");
            }
        } while (true);
    }

    private static void BerandaAdmin() {

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
            System.out.println("| 7. Feedback Pelanggan                                               |");
            System.out.println("| 8. Help                                                             |");
            System.out.println("| 0. Log out                                                          |");
            System.out.println("|                                                                     |");
            System.out.println("=======================================================================");
            System.out.print(" Pilih Menu : ");
            byte Pilih = inputEkspedisi.nextByte();
            System.out.println("-----------------------------------------------------------------------");
            System.out.println();
            switch (Pilih) {
                case 1:
                    DataPengirimanan();
                    break;
                case 2:
                    layananEkspedisi();
                    break;
                case 3:
                    MenuPembayaran();
                    break;
                case 4:
                    Penjadwalan();
                    break;
                case 5:
                    updPengiriman();
                    break;
                case 6:
                    RiwayatPengiriman();
                    break;
                case 7:
                    feedback();
                    break;
                case 8:
                    MenuHelp();
                    break;
                case 0:
                    System.out.println("=======================================================================");
                    System.out.println("|                         Anda Telah Log Out !                        |");
                    System.out.println("=======================================================================");
                    BerandaSistemEkspedisi();
                    break;
                default:
                    System.out.println();
                    System.out.println("------------------------- Pilihan Tidak Valid! ------------------------");
            }
        } while (true);
    }

    private static void DataPengirimanan() {// MENU ADMIN
        // Halaman data pengiriman
        inialisasipengirimanpertama();
        inisialisasiDataNoResi();
        while (true) {
            System.out.println("");
            System.out.println("=======================================================================");
            System.out.println("|                        Halaman Data Pengiriman                      |");
            System.out.println("=======================================================================");
            System.out.println("|                                                                     |");
            System.out.println("| 1. Tambahkan Data Pengiriman                                        |");
            System.out.println("| 2. Cek Seluruh Data Pengiriman                                      |");
            System.out.println("| 0. Kembali ke Beranda                                               |");
            System.out.println("|                                                                     |");
            System.out.println("-----------------------------------------------------------------------");
            System.out.print("Masukkan pilihan anda : ");
            byte Pilih = inputEkspedisi.nextByte();
            System.out.println("=======================================================================");
            System.out.println();
            switch (Pilih) {
                case 1: // Halaman input data pengiriman
                    do {
                        inputEkspedisi.nextLine();
                        System.out.println("=======================================================================");
                        System.out.println("|                    Silahkan input Data Pengiriman                   |");
                        System.out.println("=======================================================================");
                        System.out.println();
                        System.out.println(
                                "========================= DATA PENGIRIMAN KE-" + (i + 1)
                                        + " ========================");
                        System.out.println(" Nomor Resi                : " + dataPengiriman[i][0]);
                        System.out
                                .println("----------------------- Masukkan Data Pengirim ------------------------");
                        System.out.print(" Nama Pengirim            : ");
                        dataPengiriman[i][1] = inputEkspedisi.nextLine();
                        System.out.print(" Alamat Pengirim          : ");
                        dataPengiriman[i][2] = inputEkspedisi.nextLine();
                        System.out.print(" Nomor Telepon Pengirim   : ");
                        dataPengiriman[i][3] = inputEkspedisi.nextLine();
                        System.out.print(" Email Pengirim           : ");
                        dataPengiriman[i][4] = inputEkspedisi.nextLine();
                        System.out
                                .println("----------------------- Masukkan Data Penerima ------------------------");
                        System.out.print(" Nama Penerima            : ");
                        dataPengiriman[i][5] = inputEkspedisi.nextLine();
                        System.out.print(" Alamat Penerima          : ");
                        dataPengiriman[i][6] = inputEkspedisi.nextLine();
                        System.out.print(" Nomor Telepon Penerima   : ");
                        dataPengiriman[i][7] = inputEkspedisi.nextLine();
                        System.out.print(" Email Penerima           : ");
                        dataPengiriman[i][8] = inputEkspedisi.nextLine();
                        System.out
                                .println("----------------------- Masukkan Data Barang --------------------------");
                        System.out.print(" Nama Barang              : ");
                        dataPengiriman[i][9] = inputEkspedisi.nextLine();
                        System.out.print(" Jumlah Barang            : ");
                        dataPengiriman[i][10] = inputEkspedisi.nextLine();
                        System.out.print(" Berat Barang             : ");
                        dataPengiriman[i][11] = inputEkspedisi.nextLine();
                        System.out.print(" Total Jarak Pengiriman   : ");
                        dataPengiriman[i][12] = inputEkspedisi.nextLine();
                        System.out.print(" Deskripsi (Opsional)     : ");
                        dataPengiriman[i][13] = inputEkspedisi.nextLine();
                        System.out.println("---------------------------------------------------------------------");
                        System.out.println("Apakah Anda ingin input data pengiriman lagi ? ");
                        System.out.println("[ 1 untuk 'Iya'  ]");
                        System.out.println("[ 0 untuk 'Tidak ]");
                        System.out.print("Pilih Salah Satu          : ");
                        int lanjut = inputEkspedisi.nextInt();
                        System.out.println("=====================================================================");
                        System.out.println();
                        i++; // Menambah jumlah data setiap baru menginput
                        if (lanjut == 0) {
                            break;
                        }
                    } while (true);
                    break;
                case 2: // PENGECEKAN DATA PENGIRIMAN YANG ADA
                    System.out.println("=======================================================================");
                    System.out.println("|                             Data Pengiriman                         |");
                    System.out.println("=======================================================================");
                    System.out.println();
                    cekDataPengiriman();
                    break;
                case 0: // KEMBALI KE MENU UTAMA ADMIN
                    BerandaAdmin();
                default:
                    System.out.println();
                    System.out.println("------------------------- Pilihan Tidak Valid! ------------------------");
            }
        }
    }

    public static void cekDataPengiriman() {
        // Menampilkan Data pengiriman yang sudah diinput
        // Hanya Menampilkan data pengiriman yang sudah diinput saja
        for (int i = 0; i < maxPengiriman; i++) {
            if (dataPengiriman[i][1] != null && !dataPengiriman[i][1].isEmpty()) {
                System.out.println(
                        "======================= DATA PENGIRIMAN KE-" + (i + 1) + " =======================");
                System.out
                        .println("====================================================================");
                System.out.println(" Nomor Resi               : " + dataPengiriman[i][0]);
                System.out.println("====================================================================");
                System.out
                        .println("-------------------------- Pengirim --------------------------------");
                System.out.println(" Nama Pengirim            : " + dataPengiriman[i][1]);
                System.out.println(" Alamat Pengirim          : " + dataPengiriman[i][2]);
                System.out.println(" Nomor Telepon Pengirim   : " + dataPengiriman[i][3]);
                System.out.println(" Email Pengirim           : " + dataPengiriman[i][4]);
                System.out
                        .println("-------------------------- Penerima --------------------------------");
                System.out.println(" Nama Penerima            : " + dataPengiriman[i][5]);
                System.out.println(" Alamat Penerima          : " + dataPengiriman[i][6]);
                System.out.println(" Nomor Telepon Penerima   : " + dataPengiriman[i][7]);
                System.out.println(" Email Penerima           : " + dataPengiriman[i][8]);
                System.out
                        .println("------------------------ Detail Barang -----------------------------");
                System.out.println(" Nama Barang              : " + dataPengiriman[i][9]);
                System.out.println(" Jumlah Barang            : " + dataPengiriman[i][10] + " Pcs");
                System.out.println(" Berat Barang             : " + dataPengiriman[i][11] + " Kg");
                System.out.println(" Jarak Pengiriman         : " + dataPengiriman[i][12] + " Km");
                System.out.println(" Deskripsi (Opsional)     : " + dataPengiriman[i][13]);
                System.out
                        .println("====================================================================");
                System.out.println();
            }
        }
    }

    public static void layananEkspedisi() { // Pemilihan layanan ekspedisi yang ingin digunakan
        inialisasipengirimanpertama();
        System.out.println();
        System.out.println("=======================================================================");
        System.out.println("|                        Pilih Layanan Ekspedisi                      |");
        System.out.println("=======================================================================");
        System.out.println("------------------ Cari Nomor Pesanan Terlebih dahulu -----------------");
        System.out.println();
        System.out.print(" Silahkan Cari Data Pengiriman Ke- : ");
        int nomorPesananCari = inputEkspedisi.nextInt();
        System.out.println("-----------------------------------------------------------------------");
        boolean ditemukan = false;
        System.out.println();
        for (i = 0; i < maxPengiriman; i++) { // Fitur pencarian data pengiriman
            if (dataPengiriman[i][1] != null && !dataPengiriman[i][1].isEmpty()) {
                if (nomorPesananCari == i + 1) {
                    ditemukan = true;
                    inputEkspedisi.nextLine();
                    pilihLayananOtomatis(); // Pemilihan layanan pengiriman secara otomatis
                    inisialisasiDataNoResi(); // Untuk menampilkan No Resi
                    // Tampilan setelah memilih layanan ekspedisi
                    System.out.println(
                            "======================= DATA PENGIRIMAN KE-" + (i + 1)
                                    + " =======================");
                    System.out
                            .println("====================================================================");
                    System.out.printf("|%-67s|\n", " Nomor Resi : " + dataPengiriman[i][0]);
                    System.out
                            .println("-------------------------- Pengirim --------------------------------");
                    System.out.println(" Nama Pengirim            : " + dataPengiriman[i][1]);
                    System.out.println(" Alamat Pengirim          : " + dataPengiriman[i][2]);
                    System.out.println(" Nomor Telepon Pengirim   : " + dataPengiriman[i][3]);
                    System.out.println(" Email Pengirim           : " + dataPengiriman[i][4]);
                    System.out
                            .println("-------------------------- Penerima --------------------------------");
                    System.out.println(" Nama Penerima            : " + dataPengiriman[i][5]);
                    System.out.println(" Alamat Penerima          : " + dataPengiriman[i][6]);
                    System.out.println(" Nomor Telepon Penerima   : " + dataPengiriman[i][7]);
                    System.out.println(" Email Penerima           : " + dataPengiriman[i][8]);
                    System.out
                            .println("------------------------ Detail Barang -----------------------------");
                    System.out.println(" Nama Barang              : " + dataPengiriman[i][9]);
                    System.out.println(" Jumlah Barang            : " + dataPengiriman[i][10] + " Pcs");
                    System.out.println(" Berat Barang             : " + dataPengiriman[i][11] + " Kg");
                    System.out.println(" Deskripsi (Opsional)     : " + dataPengiriman[i][13]);
                    System.out
                            .println("====================================================================");
                    System.out.println(dataPengiriman[i][21]);
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("Total Biaya ongkir        = Rp." + dataPengiriman[i][14]);
                    System.out.println("====================================================================");
                    System.out.println();
                    System.out.println("------------- Silahkan Lanjutkan ke proses berikutnya! -------------");
                    break;
                }
            }
        }
        if (!ditemukan) {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println(
                    "[       Data Pengiriman dengan nomor pesanan " + nomorPesananCari + " tidak ditemukan !      ]");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println();
        }
    }

    public static void pilihLayananOtomatis() { // Pemilihan Layanan Ekspedisi secara otomatis
        double beratBarang = Double.parseDouble(dataPengiriman[i][11]);
        double jarakPengiriman = Double.parseDouble(dataPengiriman[i][12]);

        if (beratBarang <= 10 && jarakPengiriman <= 20) {
            // Pemilihan pengiriman dengan layanan ekspedisi hemat
            dataPengiriman[i][21] = "pengiriman dengan layanan ekspedisi hemat";
            Hemat();
        } else if ((beratBarang > 10 && beratBarang <= 50) || jarakPengiriman > 20) {
            // Pemilihan pengiriman dengan layanan ekspedisi reguler
            dataPengiriman[i][21] = "pengiriman dengan layanan ekspedisi reguler";
            Reguler();
        } else if (beratBarang > 50) {
            // Pemilihan pengiriman dengan layanan ekspedisi kargo
            dataPengiriman[i][21] = "pengiriman dengan layanan ekspedisi kargo";
            Kargo();
        } else {
            // Logika tambahan sesuai kebutuhan
            System.out.println("Tidak ada layanan ekspedisi yang sesuai dengan kriteria pengiriman.");
        }
    }

    public static void Hemat() { // Jika berat Barang Kurang dari 10kg dan Jarak Kurang Dari 20km
        double beratBarang = Double.parseDouble(dataPengiriman[i][11]);
        double JarakPengiriman = Double.parseDouble(dataPengiriman[i][12]);
        int TarifPerKm = 0;
        int TarifPerKg = 500;
        int TarifDasar = 2000;
        biayaOngkir = ((JarakPengiriman * TarifPerKm) + (beratBarang * TarifPerKg) + TarifDasar);
        inisialisasiOngkir(biayaOngkir);
    }

    public static void Reguler() { // Jika Berat Barang >10kg & >50kg dan Jarak Lebih Dari 20km
        double beratBarang = Double.parseDouble(dataPengiriman[i][11]);
        double JarakPengiriman = Double.parseDouble(dataPengiriman[i][12]);
        int TarifPerKm = 1000;
        int TarifPerKg = 1000;
        int TarifDasar = 5000;
        biayaOngkir = ((JarakPengiriman * TarifPerKm) + (beratBarang * TarifPerKg) + TarifDasar);
        inisialisasiOngkir(biayaOngkir);

    }

    public static void Kargo() { // Jika Berat Barang Lebih dari 50kg
        double beratBarang = Double.parseDouble(dataPengiriman[i][11]);
        double JarakPengiriman = Double.parseDouble(dataPengiriman[i][12]);
        int TarifPerKm = 1000;
        int TarifPerKg = 1000;
        int TarifDasar = 50000;
        biayaOngkir = ((JarakPengiriman * TarifPerKm) + (beratBarang * TarifPerKg) + TarifDasar);
        inisialisasiOngkir(biayaOngkir);

    }

    public static void MenuPembayaran() {
        do {
            System.out.println();
            System.out.println("=======================================================================");
            System.out.println("|                         Ekspedisi Pattimura                         |");
            System.out.println("|=====================================================================|");
            System.out.println("|                                                                     |");
            System.out.println("| 1.  Konfirmasi Pembayaran                                           |");
            System.out.println("| 2.  Riwayat Transaksi                                               |");
            System.out.println("| 0.  Kembali                                                         |");
            System.out.println("|                                                                     |");
            System.out.println("=======================================================================");
            System.out.print(" Pilih Menu : ");
            byte Pilih = inputEkspedisi.nextByte();
            System.out.println("-----------------------------------------------------------------------");
            System.out.println();
            switch (Pilih) {
                case 1:
                    Pembayaran();
                    break;
                case 2:
                    RiwayatTransaksi();
                    break;
                case 0:
                    BerandaAdmin();
                    break;
                default:
                    System.out.println();
                    System.out.println("------------------------- Pilihan Tidak Valid! ------------------------");
            }
        } while (true);
    }

    public static void Pembayaran() {
        inialisasipengirimanpertama();
        System.out.println();
        System.out.println("=======================================================================");
        System.out.println("|                         Konfirmasi Pembayaran                       |");
        System.out.println("=======================================================================");
        System.out.println("------------------ Cari Nomor Pesanan Terlebih dahulu -----------------");
        System.out.println();
        System.out.print(" Silahkan Cari Data Pengiriman Ke- : ");
        int nomorPesananCari = inputEkspedisi.nextInt();
        System.out.println("-----------------------------------------------------------------------");
        System.out.println();
        boolean ditemukan = false;
        System.out.println();
        for (int i = 0; i < maxPengiriman; i++) { // Fitur pencarian data pengiriman
            if (dataPengiriman[i][1] != null && !dataPengiriman[i][1].isEmpty()) {
                if (nomorPesananCari == i + 1) {
                    ditemukan = true;
                    inputEkspedisi.nextLine();
                    System.out.println(
                            "========================= PENGIRIMAN KE-" + (i + 1) + " ==========================");
                    System.out.printf("|%-67s|\n", " Nomor Resi : " + dataPengiriman[i][0]);
                    System.out
                            .println("-------------------------- Pengirim --------------------------------");
                    System.out.println(" Nama Pengirim            : " + dataPengiriman[i][1]);
                    System.out.println(" Alamat Pengirim          : " + dataPengiriman[i][2]);
                    System.out.println(" Nomor Telepon Pengirim   : " + dataPengiriman[i][3]);
                    System.out.println(" Email Pengirim           : " + dataPengiriman[i][4]);
                    System.out
                            .println("-------------------------- Penerima --------------------------------");
                    System.out.println(" Nama Penerima            : " + dataPengiriman[i][5]);
                    System.out.println(" Alamat Penerima          : " + dataPengiriman[i][6]);
                    System.out.println(" Nomor Telepon Penerima   : " + dataPengiriman[i][7]);
                    System.out.println(" Email Penerima           : " + dataPengiriman[i][8]);
                    System.out
                            .println("------------------------ Detail Barang -----------------------------");
                    System.out.println(" Nama Barang              : " + dataPengiriman[i][9]);
                    System.out.println(" Jumlah Barang            : " + dataPengiriman[i][10] + " Pcs");
                    System.out.println(" Berat Barang             : " + dataPengiriman[i][11] + " Kg");
                    System.out.println(" Deskripsi (Opsional)     : " + dataPengiriman[i][13]);
                    System.out.println("------------------------------------------------------------------");
                    System.out.println(" Total Biaya Yang Harus Dibayar : Rp." + dataPengiriman[i][14]);
                    System.out.println("==================================================================");
                    System.out.println();

                    if (!pembayaranSelesai) {
                        System.out.print("Masukkan jumlah uang yang dibayarkan untuk biaya pengiriman: Rp.");
                        double uangDibayarkan = inputEkspedisi.nextDouble();
                        double kembalian = uangDibayarkan - biayaOngkir;
                        dataPengiriman[i][20] = String.valueOf(uangDibayarkan);
                        dataPengiriman[i][19] = String.valueOf(kembalian);
                        System.out.println("=======================================================================");
                        System.out.println("|                           Rincian Pembayaran                        |");
                        System.out.println("=======================================================================");
                        System.out.println(" Nomor Resi                     : " + dataPengiriman[i][0]);
                        System.out.println("-----------------------------------------------------------------------");
                        System.out.println(" Uang yang dibayarkan           : Rp." + uangDibayarkan);
                        System.out.println(" Biaya Ongkir                   : Rp." + biayaOngkir);
                        System.out.println(" Kembalian                      : Rp." + kembalian);
                        System.out.println(" Status Pembayaran              : Pembayaran Terkonfirmasi!");
                        System.out.println("-----------------------------------------------------------------------");
                        System.out.println();//
                        System.out.println("-------------- Silahkan Lanjutkan ke proses berikutnya! ---------------");
                    } else {
                        System.out.println();//
                        System.out.println(
                                "------------- Pembayaran Belum Selesai. Silahkan Selesaikan Pembayaran! -------------");
                    }
                }
            }
        }
        if (!ditemukan) {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println(
                    "[       Data Pengiriman dengan nomor pesanan " + nomorPesananCari
                            + " tidak ditemukan !      ]");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println();
        }

    }

    public static void RiwayatTransaksi() {
        inisialisasiDataNoResi();
        for (int i = 0; i < maxPengiriman; i++) {
            if (dataPengiriman[i][1] != null && !dataPengiriman[i][1].isEmpty()) {
                System.out.println("=======================================================================");
                System.out.printf("|%-69s|\n", " Riwayat Transaksi Pengiriman Ke- " + (i + 1));
                System.out.println("=======================================================================");
                System.out.println(" Nomor Resi                     : " + dataPengiriman[i][0]);
                System.out.println("--------------------------- Detail Pengiriman -------------------------");
                System.out.println(" Pengirim                       : " + dataPengiriman[i][1]);
                System.out.println(" Penerima                       : " + dataPengiriman[i][5]);
                System.out.println("-----------------------------------------------------------------------");
                if (dataPengiriman[i][20] == null || dataPengiriman[i][20].isEmpty() || dataPengiriman[i][19] == null
                        || dataPengiriman[i][19].isEmpty()) {
                    // Jika data pembayaran belum dilakukan
                    System.out.println(" Uang yang dibayarkan           : -");
                    System.out.println(" Biaya Ongkir                   : Rp." + dataPengiriman[i][14]);
                    System.out.println(" Kembalian                      : -");
                    System.out.println(" Status Pembayaran              : Belum Bayar / Terkonfirmasi!");
                } else {
                    // Jika data pembayaran sudah dilakukan
                    System.out.println(" Uang yang dibayarkan           : Rp." + dataPengiriman[i][20]);
                    System.out.println(" Biaya Ongkir                   : Rp." + dataPengiriman[i][14]);
                    System.out.println(" Kembalian                      : Rp." + dataPengiriman[i][19]);
                    System.out.println(" Status Pembayaran              : Pembayaran Terkonfirmasi!");
                }
                System.out.println("=======================================================================");
                System.out.println();
            }
        }
    }

    public static void Penjadwalan() {
        inialisasipengirimanpertama();
        inisialisasiDataNoResi();
        System.out.println();
        System.out.println("=======================================================================");
        System.out.println("|                      Jadwalkan Pengiriman Paket                     |");
        System.out.println("=======================================================================");
        System.out.println("------------------ Cari Nomor Pesanan Terlebih dahulu -----------------");
        System.out.println();
        System.out.print(" Silahkan Cari Data Pengiriman Ke- : ");
        int nomorPesananCari = inputEkspedisi.nextInt();
        System.out.println("-----------------------------------------------------------------------");
        boolean ditemukan = false;
        System.out.println();
        inputEkspedisi.nextLine();
        for (int i = 0; i < maxPengiriman; i++) {
            if (dataPengiriman[i][1] != null && !dataPengiriman[i][1].isEmpty()) {
                if (nomorPesananCari == i + 1) {
                    ditemukan = true;
                    System.out.println(
                            "====================== JADWAL PENGIRIMAN KE-" + (i + 1) + " =========================");
                    System.out.printf("|%-69s|\n", " Nomor Resi : " + dataPengiriman[i][0]);
                    System.out
                            .println("----------------------------- Pengirim --------------------------------");
                    System.out.println(" Nama Pengirim            : " + dataPengiriman[i][1]);
                    System.out.println(" Alamat Pengirim          : " + dataPengiriman[i][2]);
                    System.out.println(" Nomor Telepon Pengirim   : " + dataPengiriman[i][3]);
                    System.out.println(" Email Pengirim           : " + dataPengiriman[i][4]);
                    System.out
                            .println("----------------------------- Penerima --------------------------------");
                    System.out.println(" Nama Penerima            : " + dataPengiriman[i][5]);
                    System.out.println(" Alamat Penerima          : " + dataPengiriman[i][6]);
                    System.out.println(" Nomor Telepon Penerima   : " + dataPengiriman[i][7]);
                    System.out.println(" Email Penerima           : " + dataPengiriman[i][8]);
                    System.out
                            .println("--------------------------- Detail Barang -----------------------------");
                    System.out.println(" Nama Barang              : " + dataPengiriman[i][9]);
                    System.out.println(" Jumlah Barang            : " + dataPengiriman[i][10] + " Pcs");
                    System.out.println(" Berat Barang             : " + dataPengiriman[i][11] + " Kg");
                    System.out.println(" Deskripsi (Opsional)     : " + dataPengiriman[i][13]);
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.printf("|%-69s|\n", " Total Biaya Yang Harus Dibayar : Rp." + dataPengiriman[i][14]);

                    System.out.println("-----------------------------------------------------------------------");
                    System.out.print(" Masukkan Tanggal Pengiriman (dd/mm/yy) : ");
                    dataPengiriman[i][15] = inputEkspedisi.nextLine();
                    System.out.print(" Masukkan waktu pengiriman (WIB)        : ");
                    dataPengiriman[i][16] = inputEkspedisi.nextLine();
                    dataPengiriman[i][17] = "PAKET SEDANG DALAM PROSES PENGEMASAN";
                    System.out
                            .println("-----------------------------------------------------------------------");
                    System.out.printf("|%-69s|\n", " Status Pengiriman : " + dataPengiriman[i][17]);
                    System.out.println("-----------------------------------------------------------------------");
                }
            }
        }
        if (!ditemukan) {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println(
                    "[       Data Pengiriman dengan nomor pesanan " + nomorPesananCari
                            + " tidak ditemukan !      ]");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println();
        }
    }

    public static int ubah = -1;

    public static void updPengiriman() {
        inputEkspedisi.nextLine();
        System.out.println();
        System.out.println("=======================================================================");
        System.out.println("|                      Update status Pengiriman                       |");
        System.out.println("=======================================================================");
        System.out.println("--------------------- Cari Pesanan Dengan No Resi ---------------------");
        System.out.print("Masukkan nilai yang ingin dicari: ");
        String updatePaket = inputEkspedisi.nextLine();
        System.out.println("-----------------------------------------------------------------------");
        System.out.println();
        boolean ditemukan = false;
        // Cari nomor resi dalam dataPengiriman
        for (int i = 0; i < dataPengiriman.length; i++) {
            if (dataPengiriman[i][0].equals(updatePaket)) {
                ditemukan = true;
                System.out
                        .println("=======================================================================");
                System.out.println("|                         Ekspedisi Pattimura                         |");
                System.out.println("=======================================================================");
                System.out.printf("| %-60s %-6s |\n", "Tanggal pengiriman : " + dataPengiriman[i][15],
                        dataPengiriman[i][16]);
                System.out.println("=======================================================================");
                System.out.println(" Nomor Resi               : " + dataPengiriman[i][0]);
                System.out.println("=======================================================================");
                System.out
                        .println("-------------------------- Pengirim -----------------------------------");
                System.out.println(" Nama Pengirim            : " + dataPengiriman[i][1]);
                System.out.println(" Alamat Pengirim          : " + dataPengiriman[i][2]);
                System.out.println(" Nomor Telepon Pengirim   : " + dataPengiriman[i][3]);
                System.out.println(" Email Pengirim           : " + dataPengiriman[i][4]);
                System.out
                        .println("-------------------------- Penerima -----------------------------------");
                System.out.println(" Nama Penerima            : " + dataPengiriman[i][5]);
                System.out.println(" Alamat Penerima          : " + dataPengiriman[i][6]);
                System.out.println(" Nomor Telepon Penerima   : " + dataPengiriman[i][7]);
                System.out.println(" Email Penerima           : " + dataPengiriman[i][8]);
                System.out
                        .println("------------------------ Detail Barang --------------------------------");
                System.out.println(" Nama Barang              : " + dataPengiriman[i][9]);
                System.out.println(" Jumlah Barang            : " + dataPengiriman[i][10] + " Pcs");
                System.out.println(" Berat Barang             : " + dataPengiriman[i][11] + " Kg");
                System.out.println(" Deskripsi (Opsional)     : " + dataPengiriman[i][13]);
                System.out
                        .println("=======================================================================");
                System.out.println(" Total Biaya Pengiriman : " + dataPengiriman[i][14]);

                System.out
                        .println("-----------------------------------------------------------------------");
                System.out.printf("|%-69s|\n", " Status Pengiriman : " + dataPengiriman[i][17]);
                System.out.println("-----------------------------------------------------------------------");
                ubah = i;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println(
                    "[       Data Pengiriman dengan nomor pesanan tidak ditemukan !      ]");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println();
        }
        // Mengecek apakah nomor resi ditemukan
        if (ubah >= 0 && ubah < dataPengiriman.length) {
            // Menampilkan menu pilihan status pengiriman
            System.out.println(" Pilih Update status pengiriman:");
            System.out.println("1. PAKET MENUNGGU DI PICK-UP OLEH KURIR");
            System.out.println("2. PAKET TELAH DI PICK-UP OLEH KURIR");
            System.out.println("3. PAKET DALAM PERJALAN MENUJU KOTA TUJUAN");
            System.out.println("4. PAKET DALAM PERJALAN MENUJU ALAMAT TUJUAN");
            System.out.println("5. PAKET DITERIMA");
            // Menerima input status baru
            System.out.print("Masukkan pilihan status pengiriman (1-5): ");
            int pilihanStatus = inputEkspedisi.nextInt();
            // Mengecek input yang valid
            if (pilihanStatus >= 1 && pilihanStatus <= 5) {
                // Mengubah status pengiriman sesuai pilihan
                String statusBaru = "";
                switch (pilihanStatus) {
                    case 1:
                        statusBaru = "SEDANG DIPACKING";
                        break;
                    case 2:
                        statusBaru = "PAKET TELAH DI PICK-UP OLEH KURIR";
                        break;
                    case 3:
                        statusBaru = "PAKET DALAM PERJALAN MENUJU KOTA TUJUAN";
                        break;
                    case 4:
                        statusBaru = "PAKET DALAM PERJALAN MENUJU ALAMAT TUJUAN";
                        break;
                    case 5:
                        statusBaru = "PAKET DITERIMA";
                        break;
                }
                dataPengiriman[ubah][17] = statusBaru;
                // Menampilkan hasil update
                if ("DITERIMA".equalsIgnoreCase(dataPengiriman[ubah][17])) {
                    System.out.println("Pengiriman sudah DITERIMA, tidak dapat diubah lagi !");
                } else {
                    System.out.println("Pengiriman berhasil diupdate " + username + " !");
                }
            } else {
                System.out.println("Input tidak valid. Harap pilih angka antara 1-5.");
            }
        } else {
            System.out.println("Nomor resi tidak ditemukan.");
        }
    }

    public static void RiwayatPengiriman() {
        inisialisasiDataNoResi();
        for (int i = 0; i < maxPengiriman; i++) {
            if (dataPengiriman[i][1] != null && !dataPengiriman[i][1].isEmpty()) {
                if (!"DITERIMA".equalsIgnoreCase(dataPengiriman[ubah][17])) {
                    System.out
                            .println("=======================================================================");
                    System.out.println("|                         Ekspedisi Pattimura                         |");
                    System.out.println("=======================================================================");
                    System.out.printf("| %-60s %-5s |\n", "Tanggal Pengiriman : " + dataPengiriman[i][15],
                            dataPengiriman[i][16]);
                    System.out.println("=======================================================================");
                    System.out.println(" Nomor Resi               : " + dataPengiriman[i][0]);
                    System.out.println("=======================================================================");
                    System.out
                            .println("-------------------------- Pengirim -----------------------------------");
                    System.out.println(" Nama Pengirim            : " + dataPengiriman[i][1]);
                    System.out.println(" Alamat Pengirim          : " + dataPengiriman[i][2]);
                    System.out.println(" Nomor Telepon Pengirim   : " + dataPengiriman[i][3]);
                    System.out.println(" Email Pengirim           : " + dataPengiriman[i][4]);
                    System.out
                            .println("-------------------------- Penerima -----------------------------------");
                    System.out.println(" Nama Penerima            : " + dataPengiriman[i][5]);
                    System.out.println(" Alamat Penerima          : " + dataPengiriman[i][6]);
                    System.out.println(" Nomor Telepon Penerima   : " + dataPengiriman[i][7]);
                    System.out.println(" Email Penerima           : " + dataPengiriman[i][8]);
                    System.out
                            .println("------------------------ Detail Barang --------------------------------");
                    System.out.println(" Nama Barang              : " + dataPengiriman[i][9]);
                    System.out.println(" Jumlah Barang            : " + dataPengiriman[i][10] + " Pcs");
                    System.out.println(" Berat Barang             : " + dataPengiriman[i][11] + " Kg");
                    System.out.println(" Deskripsi (Opsional)     : " + dataPengiriman[i][13]);
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println(" Total Biaya Pengiriman : " + dataPengiriman[i][14]);
                    dataPengiriman[i][14] = String.valueOf(biayaOngkir);
                    System.out
                            .println("=======================================================================");
                    System.out.printf("|%-69s|\n", " Status Pengiriman : " + dataPengiriman[i][17]);
                    System.out
                            .println("=======================================================================");
                    if (dataPengiriman[i][18] != null && !dataPengiriman[i][18].isEmpty()) {
                        System.out.println(" Penilaian Pelanggan      : " + dataPengiriman[i][18] + " bintang");
                        System.out.println("-----------------------------------------------------------------------");
                        System.out.println();
                    } else {
                        System.out.println(" Pelanggan belum memberikan penilaian.");
                        System.out.println("-----------------------------------------------------------------------");
                        System.out.println();
                    }
                }
            }
        }
    }

    public static void cekPaket() { // Halaman Cek Paket untuk Pelanggan
        inputEkspedisi.nextLine();
        System.out.print("Masukkan No. Resi yang ingin dicari : ");
        String cariPaket = inputEkspedisi.nextLine();

        for (int i = 0; i < dataPengiriman.length; i++) {
            if (dataPengiriman[i][0].equals(cariPaket)) {
                System.out
                        .println("=======================================================================");
                System.out.println("|                         Ekspedisi Pattimura                         |");
                System.out.println("=======================================================================");
                System.out.printf("| %-60s %-6s |\n", "Tanggal Pengiriman :" + dataPengiriman[i][15],
                        dataPengiriman[i][16]);
                System.out.println("=======================================================================");
                System.out.println(" Nomor Resi               : " + dataPengiriman[i][0]);
                System.out.println("=======================================================================");
                System.out
                        .println("-------------------------- Pengirim -----------------------------------");
                System.out.println(" Nama Pengirim            : " + dataPengiriman[i][1]);
                System.out.println(" Alamat Pengirim          : " + dataPengiriman[i][2]);
                System.out.println(" Nomor Telepon Pengirim   : " + dataPengiriman[i][3]);
                System.out.println(" Email Pengirim           : " + dataPengiriman[i][4]);
                System.out
                        .println("-------------------------- Penerima -----------------------------------");
                System.out.println(" Nama Penerima            : " + dataPengiriman[i][5]);
                System.out.println(" Alamat Penerima          : " + dataPengiriman[i][6]);
                System.out.println(" Nomor Telepon Penerima   : " + dataPengiriman[i][7]);
                System.out.println(" Email Penerima           : " + dataPengiriman[i][8]);
                System.out
                        .println("------------------------ Detail Barang --------------------------------");
                System.out.println(" Nama Barang              : " + dataPengiriman[i][9]);
                System.out.println(" Jumlah Barang            : " + dataPengiriman[i][10] + " Pcs");
                System.out.println(" Berat Barang             : " + dataPengiriman[i][11] + " Kg");
                System.out.println(" Deskripsi (Opsional)     : " + dataPengiriman[i][13]);
                System.out.println("-----------------------------------------------------------------------");
                System.out.println(" Total Biaya Pengiriman : " + dataPengiriman[i][14]);
                dataPengiriman[i][14] = String.valueOf(biayaOngkir);
                System.out
                        .println("-----------------------------------------------------------------------");
                System.out.printf("|%-69s|\n", " Status Pengiriman : " + dataPengiriman[i][17]);
                System.out
                        .println("=======================================================================");
                if ("PAKET DITERIMA".equals(dataPengiriman[i][17])) {
                    // mengambil input penilaian
                    System.out.print("Masukkan penilaian pelanggan (1-5): ");
                    int penilaian = inputEkspedisi.nextInt();
                    inputEkspedisi.nextLine();
                    // Update penilaian dari pelanggan
                    dataPengiriman[i][18] = String.valueOf(penilaian);
                    System.out.println("penilaian : " + dataPengiriman[i][18]);
                }
                return;
            }
        }
        System.out.println("Nomo Resi Tidak Ditemukan !");
    }

    public static void feedback() {
        System.out.println("=======================================================================");
        System.out.println("|                    Feedback Dari Pelanggan                          |");
        System.out.println("=======================================================================");
        for (int i = 0; i < maxFeedback; i++) {
            if (dataFeedback[i][0] != null && !dataFeedback[i][0].isEmpty()) {

                System.out.println(" Nama                                   : " + dataFeedback[i][0]);
                System.out.println(" Kepuasan terhadap pelayanan            : " + dataFeedback[i][1]);
                System.out.println(" Kepuasan terhadap kecepatan pengiriman : " + dataFeedback[i][2]);
                System.out.println(" Kendala yang dihadapi pelanggan        : " + dataFeedback[i][3]);
                System.out.println(" Masukan atau Kritik & Saran            : " + dataFeedback[i][4]);
                System.out
                        .println("=======================================================================");
            }
        }
    }

    public static void feedbackPelanggan() {
        inputEkspedisi.nextLine();
        System.out.println("=======================================================================");
        System.out.println("|                   Bagikan Pengalaman Anda !                         |");
        System.out.println("=======================================================================");
        System.out.print("Apakah Anda ingin membagikan identitas Anda? (ya/tidak) : ");
        String pilihanIdentitas = inputEkspedisi.nextLine();
        String nama = "Anonymous"; // Defautl menjadi "Anonymous" jika user tidak ingin membagikan identitas
        if (pilihanIdentitas.equalsIgnoreCase("ya")) {
            System.out.print("Nama                                       : ");
            nama = inputEkspedisi.nextLine();
        }
        System.out.print("Seberapa puas anda dengan layanan kami     : ");
        String puasLayanan = inputEkspedisi.nextLine();
        System.out.print("Seberapa puas anda dengan pengiriman kami  : ");
        String puasPengiriman = inputEkspedisi.nextLine();
        System.out.print("Apakah ada kendala yang anda hadapi        : ");
        String kendala = inputEkspedisi.nextLine();
        System.out.print("Apa Masukan anda untuk sistem kami         : ");
        String masukanSistem = inputEkspedisi.nextLine();
        // untuk Menyiampan variabel kedalam array
        dataFeedback[i][0] = nama;
        dataFeedback[i][1] = puasLayanan;
        dataFeedback[i][2] = puasPengiriman;
        dataFeedback[i][3] = kendala;
        dataFeedback[i][4] = masukanSistem;
        i++;// Menambahkan data baru
    }

    public static void MenuHelp() {
        int pilihan;
        do {
            System.out.println();
            System.out.println("=======================================================================");
            System.out.println("|                          PANDUAN PENGGUNAAN !                       |");
            System.out.println("|                      Sistem Ekspedisi Pattimura                     |");
            System.out.println("|=====================================================================|");
            System.out.println("|                                                                     |");
            System.out.println("| 1. Panduan Penggunaan Fitur Data Pengiriman                         |");
            System.out.println("| 2. Panduan Penggunaan Fitur Pilih Layanan Ekspedisi                 |");
            System.out.println("| 3. Panduan Penggunaan Fitur Konfirmasi Pembayaran                   |");
            System.out.println("| 4. Panduan Penggunaan Fitur Penjadwalan Pengiriman                  |");
            System.out.println("| 5. Panduan Penggunaan Fitur Update Pengiriman                       |");
            System.out.println("| 6. Panduan Penggunaan Fitur Riwayat Pengiriman                      |");
            System.out.println("| 7. Panduan Penggunaan Fitur Feedback Pelanggan                      |");
            System.out.println("| 0. Kembali                                                          |");
            System.out.println("|                                                                     |");
            System.out.println("=======================================================================");
            System.out.print("Masukkan pilihan Anda : ");
            pilihan = inputEkspedisi.nextInt();
            System.out.println();
            switch (pilihan) {
                case 1:
                    PanduanFitur1();
                    break;
                case 2:
                    PanduanFitur2();
                    break;
                case 3:
                    PanduanFitur3();
                    break;
                case 4:
                    PanduanFitur4();
                    break;
                case 5:
                    PanduanFitur5();
                    break;
                case 6:
                    PanduanFitur6();
                    break;
                case 7:
                    PanduanFitur7();
                    break;
                case 0:
                    BerandaAdmin();
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        } while (pilihan != 0);
        inputEkspedisi.close();
    }

    public static void PanduanFitur1() {
        System.out.println("==================== PANDUAN FITUR DATA PENGIRIMAN ====================");
        System.out.println();
        System.out.println("Pada Fitur Data Pengiriman terdapat 3 menu yaitu :");
        System.out.println();
        System.out.println(
                "1. Input Data Pengiriman\n Dalam Fitur ini Admin bertugas menginput Data Pengiriman seperti :");
        System.out.println("- Identitas Pengirim\n- Identitas Penerima\n- Detail Barang yang akan dikirim");
        System.out.println(
                "2. Cek Seluruh Data Pengiriman\n Fitur ini Menampilkan Data Pengiriman Yang sudah diinput");
        System.out.println("3. Kembali\n Fitur ini mengarahkan Admin Kembali ke Menu Utama");
        System.out.println("=======================================================================");
    }

    public static void PanduanFitur2() {
        System.out.println("=============== PANDUAN FITUR PILIH LAYANAN EKSPEDISI =================");
        System.out.println(
                "Pada Fitur ini terdapat 3 jenis pilihan layanan Ekspedisi yaitu\nHemat,Reguler, dan Kargo yang akan dipilih secara otomatis oleh sistem\nAlur yang harus dilakukan oleh Admin adlah sebagai berikut :");
        System.out.println(
                "1. Admin memilih No.2 pada menu beranda Admin\n2. Admin mencari Pesanan sesuai No Pesanan\n3. Kemudian akan tampil Pesanan beserta Biaya Ongkir yang harus dibayarkan ");
        System.out.println("=======================================================================");
    }

    public static void PanduanFitur3() {
        System.out.println("======================= PANDUAN FITUR PEMBAYARAN ======================");
        System.out.println();
        System.out.println("Pada Fitur Pembayaran terdapat 3 menu yaitu :");
        System.out.println(
                "1. Konfirmasi Pembayaran\nPada Fitur ini Admin bertugas Menginput uang yang dibayarkan pelanggan\n-pertama Admin Mecari pesanan berdasarkan No Pesanan\n-Kemudian Admin Menginput Sejumlah Nominal dari pelanggan sesuai Biaya Ongkir\n-Setelah itu akan Tampil Struk Pembayaran");
        System.out.println(
                "2. Riwayat Transaksi\nPada Fitur ini Menyimpan dan Menampilkan seluruh Transaksi yang sudah Terjadi\n3. Kembali\nFitur ini mengarahkan Admin Kembali ke Menu Utama");
        System.out.println("=======================================================================");
    }

    public static void PanduanFitur4() {
        System.out.println("================ PANDUAN FITUR PENJADWALAN PENGIRIMAN =================");
        System.out.println();
        System.out.println("Pada Fitur ini Admin Bertugas Menginput Tanggal dan jam Pengiriman Paket");
        System.out.println(
                "1. Admin memilih No.4 pada menu beranda Admin\n2. Admin mencari Pesanan sesuai No Pesanan\n3. Kemudian akan tampil Pesanan\n4. Setelah itu admin Menginput Tanggal dan jam Pengiriman\n5. Rincian Pengiriman akan Tampil dengan status pesanan 'PAKET SEDANG DALAM PROSES PENGEMASAN' ");
        System.out.println("=======================================================================");
    }

    public static void PanduanFitur5() {
        System.out.println("=================== PANDUAN FITUR UPDATE PENGIRIMAN ===================");
        System.out.println();
        System.out.println("Pada Fitur ini Admin Bertugas Mengupdate status Pengiriman ");
        System.out.println(
                "1. Admin Mencari Data Pengiriman Berdasarkan No resi\n2. Kemudian Admin Mengupdate satus pengiriman sesuai Kondisi paket\n3. setelah paket Berstatus 'PAKET DITERIMA' maka status pengiriman tidak dapat diubah lagi");
        System.out.println("=======================================================================");
    }

    public static void PanduanFitur6() {
        System.out.println("=================== PANDUAN FITUR RIWAYAT PENGIRIMAN ==================");
        System.out.println();
        System.out.println("Pada Fitur ini akan Menampilkan Riwayat pengiriman yang sudah dilakukan");
        System.out.println("=======================================================================");
    }

    public static void PanduanFitur7() {
        System.out.println("=================== PANDUAN FITUR FEEDBACK PELANGGAN ==================");
        System.out.println();
        System.out.println("Pada Fitur ini Menampilkan feedback dari pelanggan ");
        System.out.println("=======================================================================");
    }
}