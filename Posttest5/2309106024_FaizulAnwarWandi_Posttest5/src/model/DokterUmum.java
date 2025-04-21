package model;

public final class DokterUmum extends Dokter { // Menambahkan final pada kelas

    public DokterUmum(String noLisensi, String nama, String noTelp) {
        super(noLisensi, nama, noTelp);
    }

    @Override
    public String getSpesialisasi() {
        return "Umum";
    }
}
