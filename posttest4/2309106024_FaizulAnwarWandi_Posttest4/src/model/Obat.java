package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Obat {
    private int id_obat;
    private String nama_obat;
    private String kategori;
    private String komposisi;
    private String indikasi;
    private String dosis;
    private String efek_samping;

    private static List<Obat> obatList = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public Obat(int id_obat, String nama_obat, String kategori, String komposisi, String indikasi, String dosis, String efek_samping) {
        this.id_obat = id_obat;
        this.nama_obat = nama_obat;
        this.kategori = kategori;
        this.komposisi = komposisi;
        this.indikasi = indikasi;
        this.dosis = dosis;
        this.efek_samping = efek_samping;
    }

    public int getIdObat() {
        return id_obat;
    }

    public void setIdObat(int id_obat) {
        this.id_obat = id_obat;
    }

    public String getNamaObat() {
        return nama_obat;
    }

    public void setNamaObat(String nama_obat) {
        this.nama_obat = nama_obat;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getKomposisi() {
        return komposisi;
    }

    public void setKomposisi(String komposisi) {
        this.komposisi = komposisi;
    }

    public String getIndikasi() {
        return indikasi;
    }

    public void setIndikasi(String indikasi) {
        this.indikasi = indikasi;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getEfekSamping() {
        return efek_samping;
    }

    public void setEfekSamping(String efek_samping) {
        this.efek_samping = efek_samping;
    }

    @Override
    public String toString() {
        return "\nID Obat: " + id_obat + "\nNama Obat: " + nama_obat + "\nKategori: " + kategori +
               "\nKomposisi: " + komposisi + "\nIndikasi: " + indikasi + "\nDosis: " + dosis +
               "\nEfek Samping: " + efek_samping;
    }

    public static void kelolaObat() {
        while (true) {
            System.out.println("\n=== CRUD DATA OBAT ===");
            System.out.println("1. Tambah Obat");
            System.out.println("2. Lihat Daftar Obat");
            System.out.println("3. Update Data Obat");
            System.out.println("4. Hapus Data Obat");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih opsi: ");
            
            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1 -> tambahObat();
                case 2 -> lihatObat();
                case 3 -> updateObat();
                case 4 -> hapusObat();
                case 5 -> {
                    System.out.println("Kembali ke menu utama...");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public static void tambahObat() {
        System.out.println("\n>> Tambah Data Obat <<");
        System.out.print("ID Obat: ");
        int id_obat = input.nextInt();
        input.nextLine();
        System.out.print("Nama Obat: ");
        String nama_obat = input.nextLine();
        System.out.print("Kategori: ");
        String kategori = input.nextLine();
        System.out.print("Komposisi: ");
        String komposisi = input.nextLine();
        System.out.print("Indikasi: ");
        String indikasi = input.nextLine();
        System.out.print("Dosis: ");
        String dosis = input.nextLine();
        System.out.print("Efek Samping: ");
        String efek_samping = input.nextLine();

        obatList.add(new Obat(id_obat, nama_obat, kategori, komposisi, indikasi, dosis, efek_samping));
        System.out.println("Data obat berhasil ditambahkan!");
    }

    public static void lihatObat() {
        System.out.println("\n>> Daftar Obat <<");
        if (obatList.isEmpty()) {
            System.out.println("Belum ada data obat.");
            return;
        }
        for (Obat obat : obatList) {
            System.out.println(obat);
        }
    }

    public static void updateObat() {
        System.out.println("\n>> Update Data Obat <<");
        System.out.print("Masukkan ID Obat yang ingin diupdate: ");
        int id_obat = input.nextInt();
        input.nextLine();

        for (Obat obat : obatList) {
            if (obat.getIdObat() == id_obat) {
                System.out.print("Nama Obat Baru: ");
                obat.setNamaObat(input.nextLine());
                System.out.print("Kategori Baru: ");
                obat.setKategori(input.nextLine());
                System.out.print("Komposisi Baru: ");
                obat.setKomposisi(input.nextLine());
                System.out.print("Indikasi Baru: ");
                obat.setIndikasi(input.nextLine());
                System.out.print("Dosis Baru: ");
                obat.setDosis(input.nextLine());
                System.out.print("Efek Samping Baru: ");
                obat.setEfekSamping(input.nextLine());

                System.out.println("Data obat berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Obat dengan ID tersebut tidak ditemukan.");
    }

    public static void hapusObat() {
        System.out.println("\n>> Hapus Data Obat <<");
        System.out.print("Masukkan ID Obat yang ingin dihapus: ");
        int id_obat = input.nextInt();
        input.nextLine();

        boolean removed = obatList.removeIf(obat -> obat.getIdObat() == id_obat);
        if (removed) {
            System.out.println("Data obat berhasil dihapus!");
        } else {
            System.out.println("Obat dengan ID tersebut tidak ditemukan.");
        }
    }
}
