import java.util.Scanner;

public class AntrianKRSmain {

    public static void tampilkanMenu() {
        System.out.println("\n========================================");
        System.out.println("   SISTEM ANTRIAN PERSETUJUAN KRS DPA  ");
        System.out.println("========================================");
        System.out.println(" 1. Tambah Mahasiswa ke Antrian");
        System.out.println(" 2. Panggil Antrian (Proses KRS - 2 mhs)");
        System.out.println(" 3. Tampilkan Semua Antrian");
        System.out.println(" 4. Tampilkan 2 Antrian Terdepan");
        System.out.println(" 5. Tampilkan Antrian Paling Akhir");
        System.out.println(" 6. Cek Antrian Kosong");
        System.out.println(" 7. Cek Antrian Penuh");
        System.out.println(" 8. Cetak Jumlah Antrian");
        System.out.println(" 9. Cetak Jumlah Sudah Proses KRS");
        System.out.println("10. Cetak Jumlah Belum Proses KRS");
        System.out.println("11. Kosongkan Antrian");
        System.out.println(" 0. Keluar");
        System.out.println("----------------------------------------");
        System.out.print("Pilih menu: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int MAX_ANTRIAN = 10;

        AntrianKRS antrian = new AntrianKRS(MAX_ANTRIAN);

        System.out.println("========================================");
        System.out.println("  Selamat Datang di Sistem Antrian KRS  ");
        System.out.println("  Kapasitas antrian : " + MAX_ANTRIAN + " mahasiswa");
        System.out.println("  Maks layanan DPA  : 30 mahasiswa");
        System.out.println("========================================");

        int pilihan;

        do {
            tampilkanMenu();
            pilihan = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (pilihan) {
                case 1:
                    System.out.println("--- Tambah Mahasiswa ke Antrian ---");
                    System.out.print("NIM   : ");
                    String nim = sc.nextLine();
                    System.out.print("Nama  : ");
                    String nama = sc.nextLine();
                    System.out.print("Prodi : ");
                    String prodi = sc.nextLine();
                    System.out.print("Kelas : ");
                    String kelas = sc.nextLine();
                    Mahasiswa mhs = new Mahasiswa(nim, nama, prodi, kelas);
                    antrian.tambahAntrian(mhs);
                    break;

                case 2:
                    antrian.panggilAntrian();
                    break;

                case 3:
                    antrian.tampilkanSemua();
                    break;

                case 4:
                    antrian.tampilkanDuaTerdepan();
                    break;

                case 5:
                    antrian.tampilkanPalingAkhir();
                    break;

                case 6:
                    if (antrian.isEmpty()) {
                        System.out.println("Status: Antrian KOSONG.");
                    } else {
                        System.out.println("Status: Antrian TIDAK kosong. (" + antrian.getJumlahAntrian() + " mahasiswa mengantri)");
                    }
                    break;

                case 7:
                    if (antrian.isFull()) {
                        System.out.println("Status: Antrian PENUH (" + antrian.getJumlahAntrian() + "/" + MAX_ANTRIAN + ").");
                    } else {
                        System.out.println("Status: Antrian BELUM penuh (" + antrian.getJumlahAntrian() + "/" + MAX_ANTRIAN + ").");
                    }
                    break;

                case 8:
                    System.out.println("Jumlah mahasiswa dalam antrian saat ini: " + antrian.getJumlahAntrian());
                    break;

                case 9:
                    System.out.println("Jumlah mahasiswa yang sudah proses KRS: " + antrian.getTotalDilayani());
                    break;

                case 10:
                    System.out.println("Jumlah mahasiswa belum proses KRS (masih mengantri): " + antrian.getBelumProses());
                    break;

                case 11:
                    antrian.kosongkanAntrian();
                    break;

                case 0:
                    System.out.println("\n=== Ringkasan Sesi KRS ===");
                    System.out.println("Total mahasiswa diproses KRS : " + antrian.getTotalDilayani());
                    System.out.println("Mahasiswa masih mengantri    : " + antrian.getBelumProses());
                    System.out.println("Terima kasih. Sistem antrian KRS ditutup.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

        } while (pilihan != 0);

        sc.close();
    }
}