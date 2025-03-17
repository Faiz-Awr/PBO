package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pembayaran {
    private int id_pembayaran;
    private int id_kunjungan;
    private double total_biaya;
    private String metode_pembayaran;

    private static List<Pembayaran> pembayaranList = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public Pembayaran(int id_pembayaran, int id_kunjungan, double total_biaya, String metode_pembayaran) {
        this.id_pembayaran = id_pembayaran;
        this.id_kunjungan = id_kunjungan;
        this.total_biaya = total_biaya;
        this.metode_pembayaran = metode_pembayaran;
    }

    @Override
    public String toString() {
        return "\nPembayaran{" +
                "id_pembayaran=" + id_pembayaran +
                ", id_kunjungan=" + id_kunjungan +
                ", total_biaya=" + total_biaya +
                ", metode_pembayaran='" + metode_pembayaran + '\'' +
                '}';
    }

    public static void kelolaPembayaran() {
        while (true) {
            System.out.println("\n=== CRUD DATA PEMBAYARAN ===");
            System.out.println("1. Tambah Pembayaran");
            System.out.println("2. Lihat Daftar Pembayaran");
            System.out.println("3. Update Data Pembayaran");
            System.out.println("4. Hapus Data Pembayaran");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih opsi: ");
            
            int pilihan = input.nextInt();
            input.nextLine(); 

            switch (pilihan) {
                case 1 -> tambahPembayaran();
                case 2 -> lihatPembayaran();
                case 3 -> updatePembayaran();
                case 4 -> hapusPembayaran();
                case 5 -> {
                    System.out.println("Kembali ke menu utama...");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public static void tambahPembayaran() {
        System.out.println("\n>> Tambah Data Pembayaran <<");
        System.out.print("ID Pembayaran: ");
        int id_pembayaran = input.nextInt();
        input.nextLine();
        System.out.print("ID Kunjungan: ");
        int id_kunjungan = input.nextInt();
        input.nextLine();
        System.out.print("Total Biaya: ");
        double total_biaya = input.nextDouble();
        input.nextLine();
        System.out.print("Metode Pembayaran: ");
        String metode_pembayaran = input.nextLine();

        pembayaranList.add(new Pembayaran(id_pembayaran, id_kunjungan, total_biaya, metode_pembayaran));
        System.out.println("Data pembayaran berhasil ditambahkan!");
    }

    public static void lihatPembayaran() {
        System.out.println("\n>> Daftar Pembayaran <<");
        if (pembayaranList.isEmpty()) {
            System.out.println("Belum ada data pembayaran.");
            return;
        }
        for (Pembayaran pembayaran : pembayaranList) {
            System.out.println(pembayaran);
        }
    }

    public static void updatePembayaran() {
        System.out.println("\n>> Update Data Pembayaran <<");
        System.out.print("Masukkan ID Pembayaran yang ingin diupdate: ");
        int id_pembayaran = input.nextInt();
        input.nextLine();

        for (Pembayaran pembayaran : pembayaranList) {
            if (pembayaran.id_pembayaran == id_pembayaran) {
                System.out.print("ID Kunjungan Baru: ");
                pembayaran.id_kunjungan = input.nextInt();
                input.nextLine();
                System.out.print("Total Biaya Baru: ");
                pembayaran.total_biaya = input.nextDouble();
                input.nextLine();
                System.out.print("Metode Pembayaran Baru: ");
                pembayaran.metode_pembayaran = input.nextLine();

                System.out.println("Data pembayaran berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Pembayaran dengan ID tersebut tidak ditemukan.");
    }

    public static void hapusPembayaran() {
        System.out.println("\n>> Hapus Data Pembayaran <<");
        System.out.print("Masukkan ID Pembayaran yang ingin dihapus: ");
        int id_pembayaran = input.nextInt();
        input.nextLine();

        boolean removed = pembayaranList.removeIf(pembayaran -> pembayaran.id_pembayaran == id_pembayaran);
        if (removed) {
            System.out.println("Data pembayaran berhasil dihapus!");
        } else {
            System.out.println("Pembayaran dengan ID tersebut tidak ditemukan.");
        }
    }
}
