package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Resep {
    private int id_resep;
    private int id_kunjungan;
    private String nama_obat;
    private String dosis;

    private static List<Resep> resepList = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public Resep(int id_resep, int id_kunjungan, String nama_obat, String dosis) {
        this.id_resep = id_resep;
        this.id_kunjungan = id_kunjungan;
        this.nama_obat = nama_obat;
        this.dosis = dosis;
    }

    public int getIdResep() {
        return id_resep;
    }

    public void setIdResep(int id_resep) {
        this.id_resep = id_resep;
    }

    public int getIdKunjungan() {
        return id_kunjungan;
    }

    public void setIdKunjungan(int id_kunjungan) {
        this.id_kunjungan = id_kunjungan;
    }

    public String getNamaObat() {
        return nama_obat;
    }

    public void setNamaObat(String nama_obat) {
        this.nama_obat = nama_obat;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    @Override
    public String toString() {
        return "\nResep{" +
                "id_resep=" + id_resep +
                ", id_kunjungan=" + id_kunjungan +
                ", nama_obat='" + nama_obat + '\'' +
                ", dosis='" + dosis + '\'' +
                '}';
    }

    public static void kelolaResepObat() {
        while (true) {
            System.out.println("\n=== CRUD DATA RESEP ===");
            System.out.println("1. Tambah Resep");
            System.out.println("2. Lihat Daftar Resep");
            System.out.println("3. Update Data Resep");
            System.out.println("4. Hapus Data Resep");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih opsi: ");
            
            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1 -> tambahResep();
                case 2 -> lihatResep();
                case 3 -> updateResep();
                case 4 -> hapusResep();
                case 5 -> {
                    System.out.println("Kembali ke menu utama...");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public static void tambahResep() {
        System.out.println("\n>> Tambah Data Resep <<");
        System.out.print("ID Resep: ");
        int id_resep = input.nextInt();
        input.nextLine();
        System.out.print("ID Kunjungan: ");
        int id_kunjungan = input.nextInt();
        input.nextLine();
        System.out.print("Nama Obat: ");
        String nama_obat = input.nextLine();
        System.out.print("Dosis: ");
        String dosis = input.nextLine();

        resepList.add(new Resep(id_resep, id_kunjungan, nama_obat, dosis));
        System.out.println("Data resep berhasil ditambahkan!");
    }

    public static void lihatResep() {
        System.out.println("\n>> Daftar Resep <<");
        if (resepList.isEmpty()) {
            System.out.println("Belum ada data resep.");
            return;
        }
        for (Resep resep : resepList) {
            System.out.println(resep);
        }
    }

    public static void updateResep() {
        System.out.println("\n>> Update Data Resep <<");
        System.out.print("Masukkan ID Resep yang ingin diupdate: ");
        int id_resep = input.nextInt();
        input.nextLine();

        for (Resep resep : resepList) {
            if (resep.getIdResep() == id_resep) {
                System.out.print("ID Kunjungan Baru: ");
                resep.setIdKunjungan(input.nextInt());
                input.nextLine();
                System.out.print("Nama Obat Baru: ");
                resep.setNamaObat(input.nextLine());
                System.out.print("Dosis Baru: ");
                resep.setDosis(input.nextLine());

                System.out.println("Data resep berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Resep dengan ID tersebut tidak ditemukan.");
    }

    public static void hapusResep() {
        System.out.println("\n>> Hapus Data Resep <<");
        System.out.print("Masukkan ID Resep yang ingin dihapus: ");
        int id_resep = input.nextInt();
        input.nextLine();

        boolean removed = resepList.removeIf(resep -> resep.getIdResep() == id_resep);
        if (removed) {
            System.out.println("Data resep berhasil dihapus!");
        } else {
            System.out.println("Resep dengan ID tersebut tidak ditemukan.");
        }
    }
}
