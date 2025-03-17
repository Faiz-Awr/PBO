package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Hewan {
    public int id;
    String nama, jenis, ras, jenisKelamin;
    int usia;
    boolean statusVaksinasi;

    public int getId() {
        return id;
    }
    public Hewan(int id, String nama, String jenis, String ras, String jenisKelamin, int usia, boolean statusVaksinasi) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.ras = ras;
        this.jenisKelamin = jenisKelamin;
        this.usia = usia;
        this.statusVaksinasi = statusVaksinasi;
    }
    @Override
    public String toString() {
        return "\nID: " + id + "\nNama: " + nama + "\nJenis: " + jenis + "\nRas: " + ras + 
        "\nJenis Kelamin: " + jenisKelamin + "\nUsia: " + usia + "\nStatus Vaksinasi: " + (statusVaksinasi? "Sudah" : "Belum");
    }

    static ArrayList<Hewan> daftarHewan = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void kelolaHewan() {
        while (true) {
            System.out.println("\n=== CRUD DATA HEWAN ===");
            System.out.println("1. Tambah Hewan");
            System.out.println("2. Lihat Daftar Hewan");
            System.out.println("3. Update Data Hewan");
            System.out.println("4. Hapus Data Hewan");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih opsi: ");
            
            int pilihan = input.nextInt();
            input.nextLine(); // Clear buffer

            switch (pilihan) {
                case 1 -> tambahHewan();
                case 2 -> lihatHewan();
                case 3 -> updateHewan();
                case 4 -> hapusHewan();
                case 5 -> {
                    System.out.println("Kembali ke menu utama...");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public static void tambahHewan() {
        System.out.println("\n>> Tambah Data Hewan <<");
        System.out.print("ID Hewan: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Nama Hewan: ");
        String nama = input.nextLine();
        System.out.print("Jenis: ");
        String jenis = input.nextLine();
        System.out.print("Ras: ");
        String ras = input.nextLine();
        System.out.print("Jenis Kelamin: ");
        String jenisKelamin = input.nextLine();
        System.out.print("Usia: ");
        int usia = input.nextInt();
        input.nextLine();
        System.out.print("Status Vaksinasi (true/false): ");
        boolean vaksinasi = input.nextBoolean();

        daftarHewan.add(new Hewan(id, nama, jenis, ras, jenisKelamin, usia, vaksinasi));
        System.out.println("Data hewan berhasil ditambahkan!");
    }

    public static void lihatHewan() {
        System.out.println("\n>> Daftar Hewan <<");
        if (daftarHewan.isEmpty()) {
            System.out.println("Belum ada data hewan.");
            return;
        }
        for (Hewan hewan : daftarHewan) {
            System.out.println(hewan);
        }
    }

    public static void updateHewan() {
        System.out.println("\n>> Update Data Hewan <<");
        System.out.print("Masukkan ID Hewan yang ingin diupdate: ");
        int id = input.nextInt();
        input.nextLine();

        for (Hewan hewan : daftarHewan) {
            if (hewan.id == id) {
                System.out.print("Nama Baru: ");
                hewan.nama = input.nextLine();
                System.out.print("Jenis Baru: ");
                hewan.jenis = input.nextLine();
                System.out.print("Ras Baru: ");
                hewan.ras = input.nextLine();
                System.out.print("Jenis Kelamin Baru: ");
                hewan.jenisKelamin = input.nextLine();
                System.out.print("Usia Baru: ");
                hewan.usia = input.nextInt();
                input.nextLine();
                System.out.print("Status Vaksinasi Baru (true/false): ");
                hewan.statusVaksinasi = input.nextBoolean();

                System.out.println("Data hewan berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Hewan dengan ID tersebut tidak ditemukan.");
    }

    public static void hapusHewan() {
        System.out.println("\n>> Hapus Data Hewan <<");
        System.out.print("Masukkan ID Hewan yang ingin dihapus: ");
        int id = input.nextInt();
        input.nextLine();

        boolean removed = daftarHewan.removeIf(hewan -> hewan.id == id);
        if (removed) {
            System.out.println("Data hewan berhasil dihapus!");
        } else {
            System.out.println("Hewan dengan ID tersebut tidak ditemukan.");
        }
    }
}

