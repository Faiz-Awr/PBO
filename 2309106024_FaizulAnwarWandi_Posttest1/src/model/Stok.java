package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stok {
    int id_stok, id_obat;
    int jumlah_stok;
    String kadaluarsa;

    private static List<Stok> stokList = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public Stok(int id_stok, int id_obat, int jumlah_stok, String kadaluarsa) {
        this.id_stok = id_stok;
        this.id_obat = id_obat;
        this.jumlah_stok = jumlah_stok;
        this.kadaluarsa = kadaluarsa;
    }

    @Override
    public String toString() {
        return "\nID Stok: " + id_stok + "\nID Obat: " + id_obat + "\nJumlah Stok: " + jumlah_stok + 
               "\nKadaluarsa: " + kadaluarsa;
    }

    public static void kelolaStokObat() {
        while (true) {
            System.out.println("\n=== CRUD DATA STOK ===");
            System.out.println("1. Tambah Stok");
            System.out.println("2. Lihat Daftar Stok");
            System.out.println("3. Update Data Stok");
            System.out.println("4. Hapus Data Stok");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih opsi: ");
            
            int pilihan = input.nextInt();
            input.nextLine(); 

            switch (pilihan) {
                case 1 -> tambahStok();
                case 2 -> lihatStok();
                case 3 -> updateStok();
                case 4 -> hapusStok();
                case 5 -> {
                    System.out.println("Kembali ke menu utama...");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public static void tambahStok() {
        System.out.println("\n>> Tambah Data Stok <<");
        System.out.print("ID Stok: ");
        int id_stok = input.nextInt();
        input.nextLine();
        System.out.print("ID Obat: ");
        int id_obat = input.nextInt();
        input.nextLine();
        System.out.print("Jumlah Stok: ");
        int jumlah_stok = input.nextInt();
        input.nextLine();
        System.out.print("Kadaluarsa: ");
        String kadaluarsa = input.nextLine();

        stokList.add(new Stok(id_stok, id_obat, jumlah_stok, kadaluarsa));
        System.out.println("Data stok berhasil ditambahkan!");
    }

    public static void lihatStok() {
        System.out.println("\n>> Daftar Stok <<");
        if (stokList.isEmpty()) {
            System.out.println("Belum ada data stok.");
            return;
        }
        for (Stok stok : stokList) {
            System.out.println(stok);
        }
    }

    public static void updateStok() {
        System.out.println("\n>> Update Data Stok <<");
        System.out.print("Masukkan ID Stok yang ingin diupdate: ");
        int id_stok = input.nextInt();
        input.nextLine();

        for (Stok stok : stokList) {
            if (stok.id_stok == id_stok) {
                System.out.print("ID Obat Baru: ");
                stok.id_obat = input.nextInt();
                input.nextLine();
                System.out.print("Jumlah Stok Baru: ");
                stok.jumlah_stok = input.nextInt();
                input.nextLine();
                System.out.print("Kadaluarsa Baru: ");
                stok.kadaluarsa = input.nextLine();

                System.out.println("Data stok berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Stok dengan ID tersebut tidak ditemukan.");
    }

    public static void hapusStok() {
        System.out.println("\n>> Hapus Data Stok <<");
        System.out.print("Masukkan ID Stok yang ingin dihapus: ");
        int id_stok = input.nextInt();
        input.nextLine();

        boolean removed = stokList.removeIf(stok -> stok.id_stok == id_stok);
        if (removed) {
            System.out.println("Data stok berhasil dihapus!");
        } else {
            System.out.println("Stok dengan ID tersebut tidak ditemukan.");
        }
    }
}
