import java.util.Random;
import java.util.Scanner;

public class ProjectSistemEkspedisi {
    public static Scanner inputEkspedisi = new Scanner(System.in);
    // Deklarasi Array
    public static int maxPengiriman = 10;
    public static String[][] dataPengiriman = new String[maxPengiriman][20];
    // Deklarasi indeks
    public static int i = 0;
    // Deklarasi variabel untuk menghitung Ongkir
    public static double JarakPengiriman = 0.0, biayaOngkir = 0.0, BeratBarang = 0.0;
    int JumlahBarang;
    // Konfirmasi Pembayaran
    public static boolean pembayaranSelesai;
    // deklarasi variabel random
    private static Random random = new Random();

    // fungsi untuk membuat No Resi
    public static String BuatNoResi() {
        int Resi = random.nextInt(100000);
        return String.valueOf(Resi);
    }

    // fungsi untuk Menyimpan nilai didalam variabel Resi kedalam array
    public static void inisialisasiDataPengiriman() {
        for (int i = maxPengiriman - 1; i >= 0; i--) {
            // Menyimpan Nilai agar tidak berubah-ubah saat ditampilkan kembali
            if (dataPengiriman[i][0] == null) {
                dataPengiriman[i][0] = BuatNoResi();
            }
        }
    }

    // Inialisasi biaya ongkir
    public static void inisialisasiOngkir(double biayaOngkir) {
        // Menyimpan Nilai dari variabel biaya ongkir kedalam array
        dataPengiriman[i][14] = String.valueOf(biayaOngkir);
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
            System.out.println("| 2.  Saran dan Kritik                                                |");
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
                    saranKritik();
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
            System.out.println("| 7. Penilaian Pelanggan                                              |");
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
                    Pembayaran();
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
                    penilaian();
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

    ///////////////////////////// MENU ADMIN /////////////////////////////
    private static void DataPengirimanan() {
        // HALAMAN INPUT DATA PENGIRIMAN
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
                case 1: // INPUT DATA PENGIRIMAN
                    do {
                        inisialisasiDataPengiriman();
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
                        .println("-------------------------- Pengirim --------------------------------");
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
                    System.out.println(
                            "======================= DATA PENGIRIMAN KE-" + (i + 1)
                                    + " =======================");
                    System.out
                            .println("====================================================================");
                    System.out.println(" Nomor Resi                : " + dataPengiriman[i][0]);
                    System.out
                            .println("-------------------------- Pengirim --------------------------------");
                    System.out.println(" Nama Pengirim            : " + dataPengiriman[i][1]);
                    System.out.println(" Alamat Pengirim          : " + dataPengiriman[i][2]);
                    System.out.println(" Nomor Telepon Pengirim   : " + dataPengiriman[i][3]);
                    System.out.println(" Email Pengirim           : " + dataPengiriman[i][4]);
                    System.out
                            .println("-------------------------- Pengirim --------------------------------");
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
                    System.out.println();
                    System.out.println("====================================================================");
                    System.out.println("|       Silahkan Pilih Layanan Ekspedisi yang akan digunakan !     |");
                    System.out.println("====================================================================");
                    System.out.println("|                                                                  |");
                    System.out.println("| 1. Hemat                                                         |");
                    System.out.println("| 2. Reguler                                                       |");
                    System.out.println("| 3. Kargo                                                         |");
                    System.out.println("|                                                                  |");
                    System.out.println("--------------------------------------------------------------------");
                    System.out.print("Masukkan pilihan anda : ");
                    int layananPengiriman = inputEkspedisi.nextInt();
                    System.out.println("====================================================================");
                    switch (layananPengiriman) {
                        case 1:
                            // Pemilihan pengiriman dengan layanan ekspedisi hemat
                            Hemat();
                            inisialisasiOngkir(biayaOngkir);

                            break;
                        case 2:
                            // Pemilihan pengiriman dengan layanan ekspedisi reguler
                            Reguler();
                            inisialisasiOngkir(biayaOngkir);

                            break;
                        case 3:
                            // Pemilihan pengiriman dengan layanan ekspedisi kargo
                            Kargo();
                            inisialisasiOngkir(biayaOngkir);

                            break;
                        default:
                            System.out.println(
                                    "---------------- Layanan ekspedisi tidak valid ! -------------------");
                    }
                    // Tampilan setelah memilih layanan ekspedisi
                    System.out.println(
                            "========================= PENGIRIMAN KE-" + (i + 1) + " ==========================");
                    System.out.println(" Nomor Resi                : " + dataPengiriman[i][0]);
                    System.out
                            .println("-------------------------- Pengirim --------------------------------");
                    System.out.println(" Nama Pengirim            : " + dataPengiriman[i][1]);
                    System.out.println(" Alamat Pengirim          : " + dataPengiriman[i][2]);
                    System.out.println(" Nomor Telepon Pengirim   : " + dataPengiriman[i][3]);
                    System.out.println(" Email Pengirim           : " + dataPengiriman[i][4]);
                    System.out
                            .println("-------------------------- Pengirim --------------------------------");
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
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println(" Total Biaya ongkir       = Rp." + dataPengiriman[i][14]);
                    System.out.println("====================================================================");
                    System.out.println();
                    System.out.println("------------- Silahkan Lanjutkan ke proses berikutnya! -------------");
                    i++; // Menambah jumlah data setiap baru menginput
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

    public static void Pembayaran() {
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
        for (i = 0; i < maxPengiriman; i++) { // Fitur pencarian data pengiriman
            if (dataPengiriman[i][1] != null && !dataPengiriman[i][1].isEmpty()) {
                if (nomorPesananCari == i + 1) {
                    ditemukan = true;
                    inputEkspedisi.nextLine();
                    System.out.println(
                            "========================= PENGIRIMAN KE-" + (i + 1) + " ==========================");
                    System.out.println("Nomor Resi : " + dataPengiriman[i][0]);
                    System.out
                            .println("-------------------------- Pengirim --------------------------------");
                    System.out.println(" Nama Pengirim            : " + dataPengiriman[i][1]);
                    System.out.println(" Alamat Pengirim          : " + dataPengiriman[i][2]);
                    System.out.println(" Nomor Telepon Pengirim   : " + dataPengiriman[i][3]);
                    System.out.println(" Email Pengirim           : " + dataPengiriman[i][4]);
                    System.out
                            .println("-------------------------- Pengirim --------------------------------");
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
                if (!ditemukan) {
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println(
                            "[       Data Pengiriman dengan nomor pesanan " + nomorPesananCari
                                    + " tidak ditemukan !      ]");
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println();
                }
                break;
            }
        }
    }

    public static void Penjadwalan() {

    }

    public static void updPengiriman() {
    }

    public static void RiwayatPengiriman() {
    }

    /////////////////////////// MENU PELANGGAN ////////////////////////////////

    public static void cekPaket() {
        inputEkspedisi.nextLine();
        System.out.print("Masukkan No.Resi yang ingin dicari: ");
        String cariPaket = inputEkspedisi.nextLine();
        for (int i = 0; i < dataPengiriman.length; i++) {
            if (dataPengiriman[i][0].equals(cariPaket)) {
                System.out
                        .println("=======================================================================");
                System.out.println("|                         Ekspedisi Pattimura                         |");
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
                        .println("-------------------------- Pengirim -----------------------------------");
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
                System.out
                        .println("=======================================================================");
                break;
            }
        }
        System.out.println("Nilai tidak ditemukan dalam array");
    }

    public static void penilaian() {

    }

    public static void saranKritik() {
    }
}