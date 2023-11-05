import java.util.ArrayList;
import java.util.Scanner;

public class ProjectSistemEkspedisiBeta {
    public static Scanner inputEkspedisi = new Scanner(System.in);
    public static int maxPengiriman = 10;
    public static String[][] dataPengirim = new String[maxPengiriman][4];
    public static String[][] dataPenerima = new String[maxPengiriman][4];
    public static String[][] dataBarang = new String[maxPengiriman][4];

    public static void main(String[] args) {
        logIn();
    }

    public static void logOut() {
        System.out.println();
        System.out.println("=======================================================================");
        System.out.println("|                         Anda Telah Log Out !                        |");
        System.out.println("=======================================================================");
        inputEkspedisi.nextLine();
        logIn();
    }

    public static void logIn() {
        String[][] LoginUser = {
                { "a", "a" },
                { "User", "User" },
        };

        String username = "", password = "";
        byte Pilihan = 0;
        while (Pilihan < 3) {
            System.out.println();
            System.out.println("=================== Silahkan Login terlebih dahulu ====================");
            System.out.println();
            System.out.print(" Masukkan Username anda  : ");
            username = inputEkspedisi.nextLine();
            System.out.print(" Masukkan Password Anda  : ");
            password = inputEkspedisi.nextLine();
            System.out.println();
            System.out.println("=======================================================================");
            System.out.println();

            if (LoginUser[0][0].equalsIgnoreCase(username) && LoginUser[0][1].equalsIgnoreCase(password)) {
                System.out.println("=======================================================================");
                System.out.println("|                           Login Berhasil !                          |");
                System.out.println("=======================================================================");
                BerandaAdmin();

            } else if (LoginUser[1][0].equalsIgnoreCase(username) && LoginUser[1][1].equalsIgnoreCase(password)) {
                System.out.println("=======================================================================");
                System.out.println("|                           Login Berhasil !                          |");
                System.out.println("=======================================================================");
                BerandaPelanggan();
            } else {
                System.out.println("|=====================================================================|");
                System.out.println("|             Login gagal. Username atau password salah !             |");
                System.out.println("|                         Silahkan Coba Lagi                          |");
                System.out.println("|=====================================================================|");
                Pilihan++;
            }
        }
        if (Pilihan == 3) {
            System.out.println();
            System.out.println("|=====================================================================|");
            System.out.println("|                Anda telah melebihi batas upaya login !              |");
            System.out.println("|=====================================================================|");
            System.exit(0);
        }
    }

    private static void BerandaAdmin() {

        do {
            System.out.println();
            System.out.println("=======================================================================");
            System.out.println("|                           Selamat Datang !                          |");
            System.out.println("|                Beranda Admin Sistem Ekspedisi Pattimura             |");
            System.out.println("|=====================================================================|");
            System.out.println("|                                                                     |");
            System.out.println("| 1. Input Data Pengiriman                                            |");
            System.out.println("| 2. Konfirmasi Pembayaran                                            |");
            System.out.println("| 3. Penjadwalan Pengiriman                                           |");
            System.out.println("| 4. Cek Status Pengiriman                                            |");
            System.out.println("| 5. Update Pengiriman                                                |");
            System.out.println("| 6. Konfirmasi Pengiriman                                            |");
            System.out.println("| 7. Riwayat Pengiriman                                               |");
            System.out.println("| 8.                                                                  |");
            System.out.println("| 9.                                                                  |");
            System.out.println("| 0. LogOut                                                           |");
            System.out.println("|                                                                     |");
            System.out.println("=======================================================================");
            System.out.print(" Pilih Menu : ");
            byte Pilih = inputEkspedisi.nextByte();
            System.out.println("-----------------------------------------------------------------------");
            System.out.println();

            switch (Pilih) {
                case 1:
                    inDataPengiriman();
                    break;
                case 2:
                    Pembayaran();
                    break;
                case 3:
                    Penjadwalan();
                    break;
                case 4:
                    cekStatusPengiriman();
                    break;
                case 5:
                    updPengiriman();
                    break;
                case 6:
                    konfirmasiPengiriman();
                    break;
                case 7:
                    RiwayatPengiriman();
                    break;
                case 8:
                    Kosong();
                    break;
                case 9:
                    contactAdmin();
                    break;
                case 0:
                    logOut();
                default:
                    System.out.println();
                    System.out.println("------------------------- Pilihan Tidak Valid! ------------------------");
            }
        } while (true);
    }

    private static void BerandaPelanggan() {
        while (true) {
            System.out.println();
            System.out.println("=======================================================================");
            System.out.println("|             Selamat Datang di Sistem Ekspedisi Pattimura !          |");
            System.out.println("=======================================================================");
            System.out.println("|                                                                     |");
            System.out.println("| 1. ");
            System.out.println("| 2. ");
            System.out.println("| 3. ");
            System.out.println("| 4. ");
            System.out.println("| 0. Log out                                                          |");
            System.out.println("|                                                                     |");
            System.out.println("-----------------------------------------------------------------------");
            System.out.print("Masukkan pilihan anda : ");
            byte Pilih = inputEkspedisi.nextByte();
            System.out.println("=======================================================================");

            switch (Pilih) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    logOut();
                default:
                    System.out.println();
                    System.out.println("------------------------- Pilihan Tidak Valid! ------------------------");
            }
        }
    }

    // HALAMAN INPUT DATA PENGIRIMAN
    private static void inDataPengiriman() {

        while (true) {
            System.out.println("");
            System.out.println("=======================================================================");
            System.out.println("|                        Halaman Data Pengiriman                      |");
            System.out.println("=======================================================================");
            System.out.println("|                                                                     |");
            System.out.println("| 1. Tambahkan Data Pengiriman                                        |");
            System.out.println("| 2. Cek Data Pengiriman                                              |");
            System.out.println("| 3. Cek status Pembayaran                                            |");
            System.out.println("| 4. Cek status Pengiriman                                            |");
            System.out.println("| 0. Kembali ke Beranda                                               |");
            System.out.println("|                                                                     |");
            System.out.println("-----------------------------------------------------------------------");
            System.out.print("Masukkan pilihan anda : ");
            byte Pilih = inputEkspedisi.nextByte();
            System.out.println("=======================================================================");

            switch (Pilih) {
                case 1: // INPUT DATA PENGIRIMAN

                    System.out.println("=======================================================================");
                    System.out.println("|                    Silahkan input Data Pengiriman                   |");
                    System.out.println("=======================================================================");

                    for (int i = 0; i < maxPengiriman; i++) {
                        System.out.println(" DATA PENGIRIMAN KE-" + (i + 1));
                        inputEkspedisi.nextLine();
                        System.out.println("-----------------------------------------------------------------------");
                        System.out.println("[                       Masukkan Data Pengirim                        ]");
                        System.out.println("-----------------------------------------------------------------------");
                        System.out.print(" Nama Pengirim            : ");
                        dataPengirim[i][0] = inputEkspedisi.nextLine();
                        System.out.print(" Alamat Pengirim          : ");
                        dataPengirim[i][1] = inputEkspedisi.nextLine();
                        System.out.print(" Nomor Telepon Pengirim   : ");
                        dataPengirim[i][2] = inputEkspedisi.nextLine();
                        System.out.print(" Email Pengirim           : ");
                        dataPengirim[i][3] = inputEkspedisi.nextLine();
                        System.out.println("-----------------------------------------------------------------------");
                        System.out.println("[                       Masukkan Data Penerima                        ]");
                        System.out.println("-----------------------------------------------------------------------");
                        System.out.print(" Nama Penerima            : ");
                        dataPenerima[i][0] = inputEkspedisi.nextLine();
                        System.out.print(" Alamat Penerima          : ");
                        dataPenerima[i][1] = inputEkspedisi.nextLine();
                        System.out.print(" Nomor Telepon Penerima   : ");
                        dataPenerima[i][2] = inputEkspedisi.nextLine();
                        System.out.print(" Email Penerima           : ");
                        dataPenerima[i][3] = inputEkspedisi.nextLine();
                        System.out.println("-----------------------------------------------------------------------");
                        System.out.println("[                        Masukkan Data Barang                         ]");
                        System.out.println("-----------------------------------------------------------------------");
                        System.out.println();

                        i++;
                        break;
                    }
                    break;
                case 2: // PENGECEKAN DATA PENGIRIMAN YANG SUDAH DIINPUT
                    break;
                case 3: // PENGECEKAN STATUS PEMBAYARAN
                    break;
                case 4: // PENGECEKAN STATUS PENGIRIMAN
                    break;
                case 0: // KEMBALI
                    BerandaAdmin();
                default:
                    System.out.println();
                    System.out.println("------------------------- Pilihan Tidak Valid! ------------------------");
            }
        }

    }

    private static void Pembayaran() {
    }

    private static void Penjadwalan() {
    }

    private static void cekStatusPengiriman() {
    }

    private static void updPengiriman() {
    }

    private static void konfirmasiPengiriman() {
    }

    private static void RiwayatPengiriman() {
    }

    private static void Kosong() {
    }

    public static void contact() {
    }

    public static void contactAdmin() {
    }

}
