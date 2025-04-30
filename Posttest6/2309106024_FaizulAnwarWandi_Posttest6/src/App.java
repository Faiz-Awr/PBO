import model.Hewan;
import model.Pemilik;
import model.Dokter;
import model.Kunjungan;
import model.Resep;
import model.Jadwal;
import model.Pembayaran;
import model.Obat;
import model.Stok;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    static ArrayList<Hewan> dataHewan = new ArrayList<Hewan>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        while (true) {
            try {
                System.out.println("\n=== MENU CRUD KLINIK HEWAN ===");
                System.out.println("1. Kelola Data Hewan");
                System.out.println("2. Kelola Data Pemilik");
                System.out.println("3. Kelola Data Dokter");
                System.out.println("4. Kelola Data Kunjungan");
                System.out.println("5. Kelola Data Resep Obat");
                System.out.println("6. Kelola Data Jadwal Konsultasi");
                System.out.println("7. Kelola Data Pembayaran");
                System.out.println("8. Kelola Data Obat");
                System.out.println("9. Kelola Data Stok Obat");
                System.out.println("10. Keluar");
                System.out.print("Pilih entitas yang ingin dikelola: ");

                int pilihan = input.nextInt();
                input.nextLine(); 

                switch (pilihan) {
                    case 1 -> Hewan.kelolaHewan();
                    case 2 -> Pemilik.kelolaPemilik();
                    case 3 -> Dokter.kelolaDokter();
                    case 4 -> Kunjungan.kelolaKunjungan(dataHewan, new ArrayList<Dokter>());
                    case 5 -> Resep.kelolaResepObat();
                    case 6 -> Jadwal.kelolaJadwalKonsultasi();
                    case 7 -> Pembayaran.kelolaPembayaran();
                    case 8 -> Obat.kelolaObat();
                    case 9 -> Stok.kelolaStokObat();
                    case 10 -> {
                        System.out.println("Program Dikeluarkan");
                        input.close();
                        return;
                    }
                    default -> System.out.println("Pilihan tidak valid. Coba lagi!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                input.nextLine(); 
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
        }
    }
}
