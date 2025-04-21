package model;

public final class PemilikVIP extends Pemilik { // Menambahkan final pada kelas
    private String membershipLevel;

    public PemilikVIP(int id, String nama, String alamat, String noTelp, String membershipLevel) {
        super(id, nama, alamat, noTelp);
        this.membershipLevel = membershipLevel;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }
}