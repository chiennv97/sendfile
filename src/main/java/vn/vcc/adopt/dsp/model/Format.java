package vn.vcc.adopt.dsp.model;

public class Format {
    private int w;
    private int h;

    public Format() {
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Format [w=");
        builder.append(w);
        builder.append(", h=");
        builder.append(h);
        builder.append("]");
        return builder.toString();
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

}