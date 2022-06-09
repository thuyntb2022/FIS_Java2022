import java.sql.Date;
import java.time.LocalDateTime;

public class Trans {
    private LocalDateTime ngay;
    private String mayATM;
    private String soThe;
    private String soGD;
    private String soTK;
    private double soTien;
    private double soDu;
    private double lePhi;
    private double vat;

    public Trans(String mayATM, String soThe, String soGD, String soTK, double soTien, double soDu,
                 double lePhi) {
        this.mayATM = mayATM;
        this.soThe = soThe;
        this.soGD = soGD;
        this.soTK = soTK;
        this.soTien = soTien;
        this.soDu = soDu;
        this.lePhi = lePhi;
        this.ngay = java.time.LocalDateTime.now();
    }

    public Trans() {
    }

    public LocalDateTime getNgay() {
        return ngay;
    }

    public void setNgay(LocalDateTime ngay) {
        this.ngay = ngay;
    }

    public String getMayATM() {
        return mayATM;
    }

    public void setMayATM(String mayATM) {
        this.mayATM = mayATM;
    }

    public String getSoThe() {
        return soThe;
    }

    public void setSoThe(String soThe) {
        this.soThe = soThe;
    }

    public String getSoGD() {
        return soGD;
    }

    public void setSoGD(String soGD) {
        this.soGD = soGD;
    }

    public String getSoTK() {
        return soTK;
    }

    public void setSoTK(String soTK) {
        this.soTK = soTK;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public double getSoDu() {
        return soDu;
    }

    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }

    public double getLePhi() {
        return lePhi;
    }

    public void setLePhi(double lePhi) {
        this.lePhi = lePhi;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }
}
