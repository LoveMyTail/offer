package TestArea.SolutionForJob.Entity;

public class Item {
    private Long id;
    private String priceA;
    private String priceB;
    private String priceC;
    private String priceD;
    private String priceE;
    private String priceF;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPriceA() {
        return priceA;
    }

    public void setPriceA(String priceA) {
        this.priceA = priceA;
    }

    public String getPriceB() {
        return priceB;
    }

    public void setPriceB(String priceB) {
        this.priceB = priceB;
    }

    public String getPriceC() {
        return priceC;
    }

    public void setPriceC(String priceC) {
        this.priceC = priceC;
    }

    public String getPriceD() {
        return priceD;
    }

    public void setPriceD(String priceD) {
        this.priceD = priceD;
    }

    public String getPriceE() {
        return priceE;
    }

    public void setPriceE(String priceE) {
        this.priceE = priceE;
    }

    public String getPriceF() {
        return priceF;
    }

    public void setPriceF(String priceF) {
        this.priceF = priceF;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", priceA='" + priceA + '\'' +
                ", priceB='" + priceB + '\'' +
                ", priceC='" + priceC + '\'' +
                ", priceD='" + priceD + '\'' +
                ", priceE='" + priceE + '\'' +
                ", priceF='" + priceF + '\'' +
                '}';
    }
}
