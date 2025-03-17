package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kunjungan {
    private int id_kunjungan;
    private int id_hewan;
    private String no_lisensi;
    private String tanggal_kunjungan;
    private String keluhan;
    private String diagnosa;
    private String tindakan;

    private static List<Kunjungan> kunjunganList = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    // Constructor
    public Kunjungan(int id_kunjungan, int id_hewan, String no_lisensi, String tanggal_kunjungan, String keluhan, String diagnosa, String tindakan) {
        this.id_kunjungan = id_kunjungan;
        this.id_hewan = id_hewan;
        this.no_lisensi = no_lisensi;
        this.tanggal_kunjungan = tanggal_kunjungan;
        this.keluhan = keluhan;
        this.diagnosa = diagnosa;
        this.tindakan = tindakan;
    }
    @Override
    public String toString() {
        return "\nKunjungan{" +
                "id_kunjungan=" + id_kunjungan +
                ", id_hewan=" + id_hewan +
                ", no_lisensi='" + no_lisensi + '\'' +
                ", tanggal_kunjungan='" + tanggal_kunjungan + '\'' +
                ", keluhan='" + keluhan + '\'' +
                ", diagnosa='" + diagnosa + '\'' +
                ", tindakan='" + tindakan + '\'' +
                '}';
    }

    public static void kelolaKunjungan(List<Hewan> hewanList, List<Dokter> dokterList) {
        while (true) {
            System.out.println("\n=== CRUD DATA KUNJUNGAN ===");
            System.out.println("1. Tambah Kunjungan");
            System.out.println("2. Lihat Daftar Kunjungan");
            System.out.println("3. Update Data Kunjungan");
            System.out.println("4. Hapus Data Kunjungan");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih opsi: ");
            
            int pilihan = input.nextInt();
            input.nextLine(); 

            switch (pilihan) {
                case 1 -> tambahKunjungan(hewanList, dokterList, kunjunganList, input);
                case 2 -> lihatKunjungan();
                case 3 -> updateKunjungan();
                case 4 -> hapusKunjungan();
                case 5 -> {
                    System.out.println("Kembali ke menu utama...");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public static void tambahKunjungan(List<Hewan> hewanList, List<Dokter> dokterList, List<Kunjungan> kunjunganList, Scanner input) {
        System.out.println("\n>> Tambah Data Kunjungan <<");
        
        System.out.print("ID Kunjungan: ");
        int id_kunjungan = input.nextInt();
        input.nextLine();
        System.out.print("ID Hewan: ");
        int id_hewan = input.nextInt();
        input.nextLine();
        String no_lisensi;
        System.out.print("No Lisensi: ");
        no_lisensi = input.nextLine();
        System.out.print("Tanggal Kunjungan: ");
        String tanggal_kunjungan = input.nextLine();
        System.out.print("Keluhan: ");
        String keluhan = input.nextLine();
        System.out.print("Diagnosa: ");
        String diagnosa = input.nextLine();
        System.out.print("Tindakan: ");
        String tindakan = input.nextLine();
    
        kunjunganList.add(new Kunjungan(id_kunjungan, id_hewan, no_lisensi, tanggal_kunjungan, keluhan, diagnosa, tindakan));
        System.out.println("✅ Data kunjungan berhasil ditambahkan!");
    }
    

    public static void lihatKunjungan() {
        System.out.println("\n>> Daftar Kunjungan <<");
        if (kunjunganList.isEmpty()) {
            System.out.println("Belum ada data kunjungan.");
            return;
        }
        for (Kunjungan kunjungan : kunjunganList) {
            System.out.println(kunjungan);
        }
    }

    public static void updateKunjungan() {
        System.out.println("\n>> Update Data Kunjungan <<");
        System.out.print("Masukkan ID Kunjungan yang ingin diupdate: ");
        int id_kunjungan = input.nextInt();
        input.nextLine();

        for (Kunjungan kunjungan : kunjunganList) {
            if (kunjungan.id_kunjungan == id_kunjungan) {
                System.out.print("ID Hewan Baru: ");
                kunjungan.id_hewan = input.nextInt();
                input.nextLine();
                System.out.print("No Lisensi Baru: ");
                kunjungan.no_lisensi = input.nextLine();
                System.out.print("Tanggal Kunjungan Baru: ");
                kunjungan.tanggal_kunjungan = input.nextLine();
                System.out.print("Keluhan Baru: ");
                kunjungan.keluhan = input.nextLine();
                System.out.print("Diagnosa Baru: ");
                kunjungan.diagnosa = input.nextLine();
                System.out.print("Tindakan Baru: ");
                kunjungan.tindakan = input.nextLine();

                System.out.println("Data kunjungan berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Kunjungan dengan ID tersebut tidak ditemukan.");
    }

    public static void hapusKunjungan() {
        System.out.println("\n>> Hapus Data Kunjungan <<");
        System.out.print("Masukkan ID Kunjungan yang ingin dihapus: ");
        int id_kunjungan = input.nextInt();
        input.nextLine();

        boolean removed = kunjunganList.removeIf(kunjungan -> kunjungan.id_kunjungan == id_kunjungan);
        if (removed) {
            System.out.println("Data kunjungan berhasil dihapus!");
        } else {
            System.out.println("Kunjungan dengan ID tersebut tidak ditemukan.");
        }
    }
}
