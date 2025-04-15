package model;

public class PemilikVIP extends Pemilik {
    private String membershipLevel;

    public PemilikVIP(int id, String nama, String alamat, String noTelp, String email, String membershipLevel) {
        super(id, nama, alamat, noTelp, email);
        this.membershipLevel = membershipLevel;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(String membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    @Override
    public String toString() {
        return super.toString() + "\nMembership Level: " + membershipLevel;
    }
}