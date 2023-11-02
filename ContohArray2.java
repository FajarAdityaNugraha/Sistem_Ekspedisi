import java.util.Scanner;

public class ProjectTerbaru {
    public static void main(String[] args) {
        Scanner Log = new Scanner(System.in);
        String username, password, Lanjut;
        do {
            System.out.println("==================== Silahkan Login terlebih dahulu =====================");
            System.out.println();
            System.out.print(" Masukkan Username anda  : ");
            username = Log.nextLine();
            System.out.print(" Masukkan Password Anda  : ");
            password = Log.nextLine();
            System.out.println();
            // Memeriksa apakah username dan password valid
            if (username.equalsIgnoreCase("a") && password.equalsIgnoreCase("a")) {
                System.out.println("=========================== login Berhasil ! ============================");
                System.out.println();//
                byte Pilihan;
                Scanner Datapelanggan = new Scanner(System.in);
                int maxPengiriman = 10;
                String[][] dataPengirim = new String[maxPengiriman][4];
                String[][] dataPenerima = new String[maxPengiriman][4];

                boolean kembaliKeMenuUtama = false;
                do {
                    System.out.println("------------------------------ Menu Utama -----------------------------");
                    System.out.println();
                    System.out.println("1. Input data Pengiriman ");
                    System.out.println("2. Konfirmasi Pembayaran");
                    System.out.println("3. Jadwalkan Pengiriman ");
                    System.out.println("0. Keluar");
                    System.out.print("Silahkan Pilih menu : ");
                    Pilihan = Log.nextByte();

                    switch (Pilihan) {
                        case 1:
                            do {
                                // Sub Menu Pada Pilihan 1
                                System.out.println();//
                                System.out.println("1. Tambah data pengiriman");
                                System.out.println("2. Tampilkan Semua Data Pengiriman");
                                System.out.println("3. Kembali ke Menu Utama");
                                System.out.print("Silahkan pilih menu : ");
                                Byte SubMenuPilihan = Log.nextByte();

                                switch (SubMenuPilihan) {
                                    case 1: // Halaman Tambah Data Pengiriman

                                        for (int i = 0; i < maxPengiriman; i++) {
                                            System.out.println("Masukkan data pengirim ke-" + (i + 1) + ":");
                                            System.out.print("Nama Pengirim: ");
                                            dataPengirim[i][0] = Datapelanggan.nextLine();
                                            System.out.print("Alamat Pengirim: ");
                                            dataPengirim[i][1] = Datapelanggan.nextLine();
                                            System.out.print("Nomor Pengirim: ");
                                            dataPengirim[i][2] = Datapelanggan.nextLine();
                                            System.out.print("Email Pengirim: ");
                                            dataPengirim[i][3] = Datapelanggan.nextLine();
                                            System.out.println();
                                            System.out.println("Masukkan data penerima ke-" + (i + 1) + ":");
                                            System.out.print("Nama Penerima: ");
                                            dataPenerima[i][0] = Datapelanggan.nextLine();
                                            System.out.print("Alamat Penerima: ");
                                            dataPenerima[i][1] = Datapelanggan.nextLine();
                                            System.out.print("Nomor Penerima: ");
                                            dataPenerima[i][2] = Datapelanggan.nextLine();
                                            System.out.print("Email Penerima: ");
                                            dataPenerima[i][3] = Datapelanggan.nextLine();
                                            System.out.println();
                                            System.out.print(
                                                    "Apakah anda ingin menambah data pengiriman ? (ya/tidak) : ");
                                            Lanjut = Datapelanggan.next();
                                            if (Lanjut.equalsIgnoreCase("tidak")) {
                                                break;
                                            }
                                        }

                                        break;
                                    case 2: // Halaman untuk Menampilkan semua Data yang sudah diinput

                                        for (int i = 0; i < maxPengiriman; i++) {
                                            System.out.println("Data Pengirim:");
                                            System.out.println();
                                            System.out.println("Nama: " + dataPengirim[i][0]);
                                            System.out.println("Alamat: " + dataPengirim[i][1]);
                                            System.out.println("Nomor: " + dataPengirim[i][2]);
                                            System.out.println("Email: " + dataPengirim[i][3]);
                                            System.out.println();
                                            System.out.println("Data Penerima:");
                                            System.out.println("Nama: " + dataPenerima[i][0]);
                                            System.out.println("Alamat: " + dataPenerima[i][1]);
                                            System.out.println("Nomor: " + dataPenerima[i][2]);
                                            System.out.println("Email: " + dataPenerima[i][3]);
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

                } while (Pilihan != 0);

            } else {
                System.out.println("---------------- Login gagal!Username atau password salah ---------------");
                System.out.println("--------------------------- Silahkan Coba Lagi --------------------------");
                System.out.println();//
            }
        } while (true);

    }
}
