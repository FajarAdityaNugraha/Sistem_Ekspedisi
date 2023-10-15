import java.util.Scanner;

public class ProjectSistemEkspedisi {
    public static void main(String[] args) {
        Scanner log = new Scanner(System.in);
        Scanner admin = new Scanner(System.in);
        Scanner pengirim = new Scanner(System.in);
        Scanner penerima = new Scanner(System.in);
        Scanner Barang = new Scanner(System.in);
        Scanner ongkir = new Scanner(System.in);
        // login
        String username, password;
        // input data pengirim
        String namapng = "";
        String alamatpng = "";
        String provpng = "";
        String kotapng = "";
        String Rpng = "";
        String telpng = "";
        String emailpng = "";
        String kdpng = "";
        String kcpng = "";
        String dpng = "";
        // input data penerima
        String namapnr = "";
        String alamatpnr = "";
        String provpnr = "";
        String kotapnr = "";
        String Rpnr = "";
        String telpnr = "";
        String emailpnr = "";
        String kdpnr = "";
        String kcpnr = "";
        String dpnr = "";
        // input data barang
        String NamaBarang = "";
        String pecahbelahInput = "";
        String Deskripsi = "";

        boolean pecahbelah;
        // perhitungan ongkos kirim
        int jumlah = 0;
        float Berat = 0;
        float jarakPengiriman;
        float biayaPerKg = 1000;
        float biayaPerKm = 1000;
        float biayaPengiriman = 0;

        Byte pilihan;

        System.out.println("==================== Silahkan login terlebih dahulu =====================");
        System.out.println(); //
        System.out.print(" Masukkan Username anda  : ");
        username = log.nextLine();
        System.out.print(" Masukkan Password Anda  : ");
        password = log.nextLine();
        System.out.println(); //

        // Memeriksa apakah username dan password valid

        if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("operator123")) {
            System.out.println("=========================== login Berhasil ! ============================");
            System.out.println();//

            do {
                System.out.println("------------------------------ Menu Utama -----------------------------");
                System.out.println();//
                System.out.println("1. Input data Pengiriman ");
                System.out.println("2. Input data Penerima");
                System.out.println("3. Input data Barang");
                System.out.println("4. Hitung Biaya Ongkir dan Pilih Layanan Ekspedisi");
                System.out.println("5. Konfirmasi Pembayaran");
                System.out.println("6. Penjadwalan Pengiriman Barang");
                System.out.println("0. Keluar");
                System.out.print("Silahkan Pilih menu : ");
                pilihan = admin.nextByte();

                switch (pilihan) {
                    case 1: // Halaman Untuk Menginput Data Pengirim

                        System.out.println("======================= Masukkan Data Pengirim ==========================");
                        System.out.println();//
                        System.out.print(" Nama Pengirim                : ");
                        namapng = pengirim.next();
                        pengirim.nextLine();
                        System.out.print(" Alamat Lengkap Pengirim      : ");
                        alamatpng = pengirim.nextLine();
                        System.out.print(" RT dan RW Pengirim           : ");
                        Rpng = pengirim.nextLine();
                        System.out.print(" Kelurahan atau Desa Pengirim : ");
                        dpng = pengirim.nextLine();
                        System.out.print(" Kecamatan Pengirim           : ");
                        kcpng = pengirim.nextLine();
                        System.out.print(" Kota atau Kabupaten Pengirim : ");
                        kotapng = pengirim.nextLine();
                        System.out.print(" Provinsi Pengirim            : ");
                        provpng = pengirim.nextLine();
                        System.out.print(" Kodepos Pengirim             : ");
                        kdpng = pengirim.nextLine();
                        System.out.print(" Nomor Telepon Pengirim       : ");
                        telpng = pengirim.nextLine();
                        System.out.print(" Email Pengirim               : ");
                        emailpng = pengirim.nextLine();
                        System.out.println("=======================================================================");
                        System.out.println();////

                        break;
                    case 2:

                        System.out.println("====================== Masukkan Data Penerima =========================");
                        System.out.print(" Nama Penerima                : ");
                        namapnr = penerima.nextLine();
                        System.out.print(" Alamat Lengkap Penerima      : ");
                        alamatpnr = penerima.nextLine();
                        System.out.print(" RT dan RW Penerima           : ");
                        Rpnr = penerima.nextLine();
                        System.out.print(" Kelurahan atau Desa Penerima : ");
                        dpnr = penerima.nextLine();
                        System.out.print(" Kecamatan Penerima           : ");
                        kcpnr = penerima.nextLine();
                        System.out.print(" Kota atau Kabupaten Penerima : ");
                        kotapnr = penerima.nextLine();
                        System.out.print(" Provinsi Penerima            : ");
                        provpnr = penerima.nextLine();
                        System.out.print(" Kodepos Penerima             : ");
                        kdpnr = penerima.nextLine();
                        System.out.print(" Nomor Telepon Penerima       : ");
                        telpnr = penerima.nextLine();
                        System.out.print(" Email Penerima               : ");
                        emailpnr = penerima.nextLine();
                        System.out.println("=======================================================================");

                        System.out.println();//

                        break;
                    case 3:

                        System.out.println("Masukkan data barang yang akan dikirim:");
                        System.out.println();//
                        System.out.print("Nama Barang                       : ");
                        NamaBarang = Barang.nextLine();
                        System.out.print("Deskripsi Barang (Opsional)       : ");
                        Deskripsi = Barang.nextLine();
                        System.out.print("Jenis barang (Pecah Belah/Bukan)  : ");
                        pecahbelahInput = Barang.nextLine();
                        pecahbelah = pecahbelahInput.equalsIgnoreCase("Pecah belah");
                        System.out.print("Jumlah Barang                     : ");
                        jumlah = Barang.nextInt();
                        System.out.print("Berat (kg)                        : ");
                        Berat = Barang.nextFloat();

                        System.out.println();//

                        System.out.println("======================================================================");
                        System.out.println("|                       Rincian Data Barang                          |");
                        System.out.println("======================================================================");
                        System.out.println("Nama Barang        :" + NamaBarang);
                        System.out.println("Jenis Barang       :" + pecahbelahInput);
                        System.out.println("Jumlah Barang      :" + jumlah + " Pcs");
                        System.out.println("Berat Barang       :" + Berat + " Kg");
                        System.out.println("Deskripsi Barang   :" + Deskripsi);
                        System.out.println();//
                        if (pecahbelah) {
                            System.out.println("(Barang akan mendapat ekstra perlindungan)");
                        } else {
                            System.out.println("(Barang tidak memerlukan ekstra perlindungan)");
                        }

                        System.out.println("======================================================================");

                        break;
                    case 4:

                        System.out.println("======================================================================");
                        System.out.println("|                    Hitung Biaya Ongkos Kirim                       |");
                        System.out.println("======================================================================");
                        System.out.println();//
                        System.out.println("Nama Barang               : " + NamaBarang);
                        System.out.println("Jenis Barang              : " + pecahbelahInput);
                        System.out.println("Jumlah Barang             : " + jumlah + " Pcs");
                        System.out.println("Berat Barang              : " + Berat + " Kg");
                        System.out.print("Masukkan Jarak Pengiriman : ");
                        jarakPengiriman = ongkir.nextFloat();
                        System.out.println();//

                        biayaPengiriman = ((Berat * biayaPerKg) + (jarakPengiriman * biayaPerKm));
                        System.out.println("Total Biaya yang Harus dibayar = Rp." + biayaPengiriman);

                        if (jarakPengiriman > 100) {
                            if (Berat > 50) {
                                System.out.println("Menggunakan pengiriman ekspres paket berat");
                            } else {
                                System.out.println("Menggunakan pengiriman ekspress paket ringan");
                            }
                        } else {
                            System.out.println("Menggunakan pengiriman Reguler");
                        }

                        break;
                    case 5:

                        break;
                    case 0:
                        System.out.println("Terima Kasih Telah Menggunakan Sistem Ekspedisi !");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid");
                }
            } while (pilihan != 0);
        } else {
            System.out.println("Login gagal. Username atau password salah.");
        }

    }
}
