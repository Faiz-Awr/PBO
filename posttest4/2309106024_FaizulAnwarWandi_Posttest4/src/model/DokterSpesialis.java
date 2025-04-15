package model;

public class DokterSpesialis extends Dokter {
    private String spesialisasi;

    public DokterSpesialis(String noLisensi, String nama, String noTelp, String spesialisasi) {
        super(noLisensi, nama, noTelp);
        this.spesialisasi = spesialisasi;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi = spesialisasi;
    }

    @Override
    public String toString() {
        return "[Dokter Spesialis]\n" + super.toString() + "\nSpesialisasi: " + spesialisasi;
    }
}

