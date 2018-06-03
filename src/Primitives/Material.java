package Primitives;

public class Material {
    Double Kd,Ks;
    int nshaininess;

    //****************************constructors****************************************//

    public Material(Double kd, Double ks, int nshaininess) {
        Kd = kd;
        Ks = ks;
        this.nshaininess = nshaininess;
    }

    public Material(Material material) {
        Kd = material.Kd;
        Ks = material.Ks;
        this.nshaininess = material.nshaininess;
    }

    public Material(){
        Kd=1.0;
        Ks=1.0;
        nshaininess=1;
    }
    //************************************getters and setters****************************************//

    public Double getKd() {
        return Kd;
    }

    public void setKd(Double kd) {
        Kd = kd;
    }

    public Double getKs() {
        return Ks;
    }

    public void setKs(Double ks) {
        Ks = ks;
    }

    public int getNshaininess() {
        return nshaininess;
    }

    public void setNshaininess(int nshaininess) {
        this.nshaininess = nshaininess;
    }
}
