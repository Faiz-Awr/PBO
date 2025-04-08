package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pemilik {
    private int id;
    private String nama;
    private String alamat;
    private String noTelp;
    private String email;

    private static List<Pemilik> pemilikList = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public Pemilik(int id, String nama, String alamat, String noTelp, String email) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "\nID: " + id + "\nNama: " + nama + "\nAlamat: " + alamat +
               "\nNo Telp: " + noTelp + "\nEmail: " + email;
    }

    public static void kelolaPemilik() {
        while (true) {
            System.out.println("\n=== CRUD DATA PEMILIK ===");
            System.out.println("1. Tambah Pemilik");
            System.out.println("2. Lihat Daftar Pemilik");
            System.out.println("3. Update Data Pemilik");
            System.out.println("4. Hapus Data Pemilik");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih opsi: ");
            
            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1 -> tambahPemilik();
                case 2 -> lihatPemilik();
                case 3 -> updatePemilik();
                case 4 -> hapusPemilik();
                case 5 -> {
                    System.out.println("Kembali ke menu utama...");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public static void tambahPemilik() {
        System.out.println("\n>> Tambah Data Pemilik <<");
        System.out.print("ID Pemilik: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Nama Pemilik: ");
        String nama = input.nextLine();
        System.out.print("Alamat: ");
        String alamat = input.nextLine();
        System.out.print("No Telp: ");
        String noTelp = input.nextLine();
        System.out.print("Email: ");
        String email = input.nextLine();

        pemilikList.add(new Pemilik(id, nama, alamat, noTelp, email));
        System.out.println("Data pemilik berhasil ditambahkan!");
    }

    public static void lihatPemilik() {
        System.out.println("\n>> Daftar Pemilik <<");
        if (pemilikList.isEmpty()) {
            System.out.println("Belum ada data pemilik.");
            return;
        }
        for (Pemilik pemilik : pemilikList) {
            System.out.println(pemilik);
        }
    }

    public static void updatePemilik() {
        System.out.println("\n>> Update Data Pemilik <<");
        System.out.print("Masukkan ID Pemilik yang ingin diupdate: ");
        int id = input.nextInt();
        input.nextLine();

        for (Pemilik pemilik : pemilikList) {
            if (pemilik.getId() == id) {
                System.out.print("Nama Baru: ");
                pemilik.setNama(input.nextLine());
                System.out.print("Alamat Baru: ");
                pemilik.setAlamat(input.nextLine());
                System.out.print("No Telp Baru: ");
                pemilik.setNoTelp(input.nextLine());
                System.out.print("Email Baru: ");
                pemilik.setEmail(input.nextLine());

                System.out.println("Data pemilik berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Pemilik dengan ID tersebut tidak ditemukan.");
    }

    public static void hapusPemilik() {
        System.out.println("\n>> Hapus Data Pemilik <<");
        System.out.print("Masukkan ID Pemilik yang ingin dihapus: ");
        int id = input.nextInt();
        input.nextLine();

        boolean removed = pemilikList.removeIf(pemilik -> pemilik.getId() == id);
        if (removed) {
            System.out.println("Data pemilik berhasil dihapus!");
        } else {
            System.out.println("Pemilik dengan ID tersebut tidak ditemukan.");
        }
    }
}
