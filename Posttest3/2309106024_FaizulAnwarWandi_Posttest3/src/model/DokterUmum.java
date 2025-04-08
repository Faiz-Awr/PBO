package model;

public class DokterUmum extends Dokter {

    public DokterUmum(String noLisensi, String nama, String noTelp) {
        super(noLisensi, nama, noTelp);
    }

    @Override
    public String toString() {
        return "[Dokter Umum]\n" + super.toString();
    }
}
