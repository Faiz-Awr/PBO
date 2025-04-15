package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jadwal {
    private int id_jadwal;
    private int id_hewan;
    private String no_lisensi;
    private String tanggal_waktu;

    private static List<Jadwal> jadwalList = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public Jadwal(int id_jadwal, int id_hewan, String no_lisensi, String tanggal_waktu) {
        this.id_jadwal = id_jadwal;
        this.id_hewan = id_hewan;
        this.no_lisensi = no_lisensi;
        this.tanggal_waktu = tanggal_waktu;
    }

    public int getIdJadwal() {
        return id_jadwal;
    }

    public void setIdJadwal(int id_jadwal) {
        this.id_jadwal = id_jadwal;
    }

    public int getIdHewan() {
        return id_hewan;
    }

    public void setIdHewan(int id_hewan) {
        this.id_hewan = id_hewan;
    }

    public String getNoLisensi() {
        return no_lisensi;
    }

    public void setNoLisensi(String no_lisensi) {
        this.no_lisensi = no_lisensi;
    }

    public String getTanggalWaktu() {
        return tanggal_waktu;
    }

    public void setTanggalWaktu(String tanggal_waktu) {
        this.tanggal_waktu = tanggal_waktu;
    }

    @Override
    public String toString() {
        return "\nJadwal{" +
                "id_jadwal=" + id_jadwal +
                ", id_hewan=" + id_hewan +
                ", no_lisensi='" + no_lisensi + '\'' +
                ", tanggal_waktu='" + tanggal_waktu + '\'' +
                '}';
    }

    public static void kelolaJadwalKonsultasi() {
        while (true) {
            System.out.println("\n=== CRUD DATA JADWAL ===");
            System.out.println("1. Tambah Jadwal");
            System.out.println("2. Lihat Daftar Jadwal");
            System.out.println("3. Update Data Jadwal");
            System.out.println("4. Hapus Data Jadwal");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih opsi: ");
            
            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1 -> tambahJadwal();
                case 2 -> lihatJadwal();
                case 3 -> updateJadwal();
                case 4 -> hapusJadwal();
                case 5 -> {
                    System.out.println("Kembali ke menu utama...");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public static void tambahJadwal() {
        System.out.println("\n>> Tambah Data Jadwal <<");
        System.out.print("ID Jadwal: ");
        int id_jadwal = input.nextInt();
        input.nextLine();
        System.out.print("ID Hewan: ");
        int id_hewan = input.nextInt();
        input.nextLine();
        System.out.print("No Lisensi: ");
        String no_lisensi = input.nextLine();
        System.out.print("Tanggal dan Waktu: ");
        String tanggal_waktu = input.nextLine();

        jadwalList.add(new Jadwal(id_jadwal, id_hewan, no_lisensi, tanggal_waktu));
        System.out.println("Data jadwal berhasil ditambahkan!");
    }

    public static void lihatJadwal() {
        System.out.println("\n>> Daftar Jadwal <<");
        if (jadwalList.isEmpty()) {
            System.out.println("Belum ada data jadwal.");
            return;
        }
        for (Jadwal jadwal : jadwalList) {
            System.out.println(jadwal);
        }
    }

    public static void updateJadwal() {
        System.out.println("\n>> Update Data Jadwal <<");
        System.out.print("Masukkan ID Jadwal yang ingin diupdate: ");
        int id_jadwal = input.nextInt();
        input.nextLine();

        for (Jadwal jadwal : jadwalList) {
            if (jadwal.getIdJadwal() == id_jadwal) {
                System.out.print("ID Hewan Baru: ");
                jadwal.setIdHewan(input.nextInt());
                input.nextLine();
                System.out.print("No Lisensi Baru: ");
                jadwal.setNoLisensi(input.nextLine());
                System.out.print("Tanggal dan Waktu Baru: ");
                jadwal.setTanggalWaktu(input.nextLine());

                System.out.println("Data jadwal berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Jadwal dengan ID tersebut tidak ditemukan.");
    }

    public static void hapusJadwal() {
        System.out.println("\n>> Hapus Data Jadwal <<");
        System.out.print("Masukkan ID Jadwal yang ingin dihapus: ");
        int id_jadwal = input.nextInt();
        input.nextLine();

        boolean removed = jadwalList.removeIf(jadwal -> jadwal.getIdJadwal() == id_jadwal);
        if (removed) {
            System.out.println("Data jadwal berhasil dihapus!");
        } else {
            System.out.println("Jadwal dengan ID tersebut tidak ditemukan.");
        }
    }
}
