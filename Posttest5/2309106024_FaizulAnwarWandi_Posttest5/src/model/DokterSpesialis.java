package model;

public class DokterSpesialis extends Dokter {
    private final String bidangSpesialisasi; // Menambahkan final pada atribut

    public DokterSpesialis(String noLisensi, String nama, String noTelp, String bidangSpesialisasi) {
        super(noLisensi, nama, noTelp);
        this.bidangSpesialisasi = bidangSpesialisasi;
    }

    public String getBidangSpesialisasi() {
        return bidangSpesialisasi;
    }

    @Override
    public String getSpesialisasi() {
        return "Spesialis " + bidangSpesialisasi;
    }
}

