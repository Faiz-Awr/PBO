package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dokter {
    String noLisensi;
    String nama, spesialisasi, noTelp;

    private static List<Dokter> dokterList = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public String getNoLisensi() {
        return noLisensi;
    }

    public Dokter(String noLisensi, String nama, String spesialisasi, String noTelp) {
        this.noLisensi = noLisensi;
        this.nama = nama;
        this.spesialisasi = spesialisasi;
        this.noTelp = noTelp;
    }

    @Override
    public String toString() {
        return "\nNo Lisensi: " + noLisensi + "\nNama: " + nama + "\nSpesialisasi: " + spesialisasi + 
               "\nNo Telp: " + noTelp;
    }

    public static void kelolaDokter() {
        while (true) {
            System.out.println("\n=== CRUD DATA DOKTER ===");
            System.out.println("1. Tambah Dokter");
            System.out.println("2. Lihat Daftar Dokter");
            System.out.println("3. Update Data Dokter");
            System.out.println("4. Hapus Data Dokter");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih opsi: ");
            
            int pilihan = input.nextInt();
            input.nextLine(); // Clear buffer

            switch (pilihan) {
                case 1 -> tambahDokter();
                case 2 -> lihatDokter();
                case 3 -> updateDokter();
                case 4 -> hapusDokter();
                case 5 -> {
                    System.out.println("Kembali ke menu utama...");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public static void tambahDokter() {
        System.out.println("\n>> Tambah Data Dokter <<");
        System.out.print("No Lisensi: ");
        String noLisensi = input.nextLine();
        input.nextLine();
        System.out.print("Nama: ");
        String nama = input.nextLine();
        System.out.print("Spesialisasi: ");
        String spesialisasi = input.nextLine();
        System.out.print("No Telp: ");
        String noTelp = input.nextLine();

        dokterList.add(new Dokter(noLisensi, nama, spesialisasi, noTelp));
        System.out.println("Data dokter berhasil ditambahkan!");
    }

    public static void lihatDokter() {
        System.out.println("\n>> Daftar Dokter <<");
        if (dokterList.isEmpty()) {
            System.out.println("Belum ada data dokter.");
            return;
        }
        for (Dokter dokter : dokterList) {
            System.out.println(dokter);
        }
    }

    public static void updateDokter() {
        System.out.println("\n>> Update Data Dokter <<");
        System.out.print("Masukkan No Lisensi Dokter yang ingin diupdate: ");
        String noLisensi = input.nextLine();
        input.nextLine();

        for (Dokter dokter : dokterList) {
            if (dokter.noLisensi == noLisensi) {
                System.out.print("Nama Baru: ");
                dokter.nama = input.nextLine();
                System.out.print("Spesialisasi Baru: ");
                dokter.spesialisasi = input.nextLine();
                System.out.print("No Telp Baru: ");
                dokter.noTelp = input.nextLine();

                System.out.println("Data dokter berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Dokter dengan No Lisensi tersebut tidak ditemukan.");
    }

    public static void hapusDokter() {
        System.out.println("\n>> Hapus Data Dokter <<");
        System.out.print("Masukkan No Lisensi Dokter yang ingin dihapus: ");
        String noLisensi = input.nextLine();
        input.nextLine();

        boolean removed = dokterList.removeIf(dokter -> dokter.noLisensi == noLisensi);
        if (removed) {
            System.out.println("Data dokter berhasil dihapus!");
        } else {
            System.out.println("Dokter dengan No Lisensi tersebut tidak ditemukan.");
        }
    }
}
