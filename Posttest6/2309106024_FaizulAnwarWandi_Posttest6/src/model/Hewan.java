package model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Hewan implements CRUD {
    private int id;
    private String nama;
    private String jenis;
    private String ras;
    private String jenisKelamin;
    private int usia;
    private boolean statusVaksinasi;

    static ArrayList<Hewan> daftarHewan = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public Hewan(int id, String nama, String jenis, String ras, String jenisKelamin, int usia, boolean statusVaksinasi) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.ras = ras;
        this.jenisKelamin = jenisKelamin;
        this.usia = usia;
        this.statusVaksinasi = statusVaksinasi;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getJenis() {
        return jenis;
    }

    public String getRas() {
        return ras;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public int getUsia() {
        return usia;
    }

    public boolean isStatusVaksinasi() {
        return statusVaksinasi;
    }

    @Override
    public void create() {
        try {
            System.out.print("Masukkan ID Hewan: ");
            int id = input.nextInt();
            input.nextLine(); // Membersihkan buffer
            System.out.print("Masukkan Nama Hewan: ");
            String nama = input.nextLine();
            System.out.print("Masukkan Jenis Hewan: ");
            String jenis = input.nextLine();
            System.out.print("Masukkan Ras Hewan: ");
            String ras = input.nextLine();
            System.out.print("Masukkan Jenis Kelamin Hewan: ");
            String jenisKelamin = input.nextLine();
            System.out.print("Masukkan Usia Hewan: ");
            int usia = input.nextInt();
            input.nextLine(); // Membersihkan buffer
            System.out.print("Apakah Hewan Sudah Divaksinasi? (true/false): ");
            boolean statusVaksinasi = input.nextBoolean();
            input.nextLine(); // Membersihkan buffer

            daftarHewan.add(new Hewan(id, nama, jenis, ras, jenisKelamin, usia, statusVaksinasi));
            System.out.println("Hewan berhasil ditambahkan!");
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Pastikan ID dan usia berupa angka, serta status vaksinasi berupa true/false.");
            input.nextLine(); // Membersihkan buffer input
        }
    }

    @Override
    public void read() {
        System.out.println("\n>> Daftar Hewan <<");
        if (daftarHewan.isEmpty()) {
            System.out.println("Belum ada data hewan.");
        } else {
            for (Hewan hewan : daftarHewan) {
                System.out.println(hewan);
            }
        }
    }

    @Override
    public String toString() {
        return "ID: " + id +
               ", Nama: " + nama +
               ", Jenis: " + jenis +
               ", Ras: " + ras +
               ", Jenis Kelamin: " + jenisKelamin +
               ", Usia: " + usia +
               ", Status Vaksinasi: " + (statusVaksinasi ? "Sudah" : "Belum");
    }

    public static void kelolaHewan() {
        while (true) {
            try {
                System.out.println("\n=== KELOLA DATA HEWAN ===");
                System.out.println("1. Tambah Hewan");
                System.out.println("2. Lihat Hewan");
                System.out.println("3. Kembali");
                System.out.print("Pilih menu: ");

                int pilihan = input.nextInt();
                input.nextLine(); // Membersihkan buffer input

                Hewan hewan = new Hewan(0, "", "", "", "", 0, false); // Objek sementara untuk memanggil metode
                switch (pilihan) {
                    case 1 -> hewan.create();
                    case 2 -> hewan.read();
                    case 3 -> {
                        System.out.println("Kembali ke menu utama.");
                        return;
                    }
                    default -> System.out.println("Pilihan tidak valid. Coba lagi!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                input.nextLine(); // Membersihkan buffer input
            }
        }
    }
}

