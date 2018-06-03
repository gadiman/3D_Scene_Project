package Primitives;

public class Material {
    Double Kd,Ks,Kr,Kt;
    int nshaininess;

    //****************************constructors****************************************//

    public Material(Double kd, Double ks,Double kr,Double kt, int nshaininess) {
        Kd = kd;
        Ks = ks;
        Kt=kt;
        Kr=kr;
        this.nshaininess = nshaininess;
    }

    public Material(Material material) {
        Kd = material.Kd;
        Ks = material.Ks;
        Kr=material.Kr;
        Kt=material.Kt;
        this.nshaininess = material.nshaininess;
    }

    public Material(){
        Kd=1.0;
        Ks=1.0;
        Kr=0.0;
        Kt=0.0;
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

    public Double getKr() {
        return Kr;
    }

    public void setKr(Double kr) {
        Kr = kr;
    }

    public Double getKt() {
        return Kt;
    }

    public void setKt(Double kt) {
        Kt = kt;
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
