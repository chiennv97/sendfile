package vn.vcc.adopt.dsp.model;

import java.util.ArrayList;
import java.util.List;

public class BannerReq {
    private String id;
    private List<Integer> btype;
    private List<Integer> battr;
    private int pos;
    private List<String> mimes;
    private int topframe;
    private List<Integer> expdir;
    private List<Integer> api;

    private int w;
    private int h;
    private List<Format> format;
    private int wmax;
    private int hmax;
    private int wmin;
    private int hmin;

    public BannerReq() {
        mimes = new ArrayList<>();
        expdir = new ArrayList<>();
        api = new ArrayList<>();
        format = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Banner [id=");
        builder.append(id);
        builder.append(", btype=");
        builder.append(btype);
        builder.append(", battr=");
        builder.append(battr);
        builder.append(", pos=");
        builder.append(pos);
        builder.append(", mimes=");
        builder.append(mimes);
        builder.append(", topframe=");
        builder.append(topframe);
        builder.append(", expdir=");
        builder.append(expdir);
        builder.append(", api=");
        builder.append(api);
        builder.append(", w=");
        builder.append(w);
        builder.append(", h=");
        builder.append(h);
        builder.append(", format=");
        builder.append(format);
        builder.append(", wmax=");
        builder.append(wmax);
        builder.append(", hmax=");
        builder.append(hmax);
        builder.append(", wmin=");
        builder.append(wmin);
        builder.append(", hmin=");
        builder.append(hmin);
        builder.append("]");
        return builder.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Integer> getBtype() {
        return btype;
    }

    public void setBtype(List<Integer> btype) {
        this.btype = btype;
    }

    public List<Integer> getBattr() {
        return battr;
    }

    public void setBattr(List<Integer> battr) {
        this.battr = battr;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public List<String> getMimes() {
        return mimes;
    }

    public void setMimes(List<String> mimes) {
        this.mimes = mimes;
    }

    public int getTopframe() {
        return topframe;
    }

    public void setTopframe(int topframe) {
        this.topframe = topframe;
    }

    public List<Integer> getExpdir() {
        return expdir;
    }

    public void setExpdir(List<Integer> expdir) {
        this.expdir = expdir;
    }

    public List<Integer> getApi() {
        return api;
    }

    public void setApi(List<Integer> api) {
        this.api = api;
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

    public List<Format> getFormat() {
        return format;
    }

    public void setFormat(List<Format> format) {
        this.format = format;
    }

    public int getWmax() {
        return wmax;
    }

    public void setWmax(int wmax) {
        this.wmax = wmax;
    }

    public int getHmax() {
        return hmax;
    }

    public void setHmax(int hmax) {
        this.hmax = hmax;
    }

    public int getWmin() {
        return wmin;
    }

    public void setWmin(int wmin) {
        this.wmin = wmin;
    }

    public int getHmin() {
        return hmin;
    }

    public void setHmin(int hmin) {
        this.hmin = hmin;
    }
}