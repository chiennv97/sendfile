package vn.vcc.adopt.dsp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import vn.vcc.adopt.adxmob.model.raw.RawBanner;
import vn.vcc.adopt.type.BidType;
import vn.vcc.adopt.type.KeywordType;

public class Banner extends RawBanner implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private long userID;
    private int id;
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

    private int bidType;
    private int typeGroup;
    private int minBid;
    private long demoGraphic;
    private int targetAuid;
    private int campaignId;

    String os;
    String device;
    private String os_version;
    private String click2Call;
    private String htmlCode;

    private String scriptHtml;

    private String is_banner_serving;

    private List<Integer> targetCarrier;// nhà mạng

    private KeywordType keywordType;

    private boolean is3g;

    private boolean isCPD;

    private int productType;

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public boolean isCPD() {
        return isCPD;
    }

    public void setCPD(boolean isCPD) {
        this.isCPD = isCPD;
    }

    public boolean isIs3g() {
        return is3g;
    }

    public void setIs3g(boolean is3g) {
        this.is3g = is3g;
    }

    public Banner() {
        mimes = new ArrayList<>();
        expdir = new ArrayList<>();
        api = new ArrayList<>();
        format = new ArrayList<>();
        targetCarrier = new ArrayList<>();
    }

    public String getScriptHtml() {
        return scriptHtml;
    }

    public void setScriptHtml(String scriptHtml) {
        this.scriptHtml = scriptHtml;
    }

    public Banner(BannerReq bannerReq) {
        id = Integer.parseInt(bannerReq.getId());
        btype = bannerReq.getBtype();
        battr = bannerReq.getBattr();
        pos = bannerReq.getPos();
        mimes = bannerReq.getMimes();
        topframe = bannerReq.getTopframe();
        expdir = bannerReq.getExpdir();

        api = bannerReq.getApi();

        w = bannerReq.getW();
        h = bannerReq.getH();
        format = bannerReq.getFormat();
        wmax = bannerReq.getWmax();
        hmax = bannerReq.getHmax();
        wmin = bannerReq.getWmin();
        hmin = bannerReq.getHmin();
    }

    @Override
    public String toString() {
        return "Banner [id=" + id + ", btype=" + btype + ", battr=" + battr + ", pos=" + pos + ", mimes=" + mimes
                + ", topframe=" + topframe + ", expdir=" + expdir + ", api=" + api + ", w=" + w + ", h=" + h
                + ", format=" + format + ", wmax=" + wmax + ", hmax=" + hmax + ", wmin=" + wmin + ", hmin=" + hmin
                + ", bidType=" + bidType + ", typeGroup=" + typeGroup + ", minBid=" + minBid + ", demoGraphic="
                + demoGraphic + ", targetAuid=" + targetAuid + ", campaignId=" + campaignId + ", os=" + os + ", device="
                + device + ", os_version=" + os_version + ", click2Call=" + click2Call + ", htmlCode=" + htmlCode
                + ", scriptHtml=" + scriptHtml + ", is_banner_serving=" + is_banner_serving + ", targetCarrier="
                + targetCarrier + ", keywordType=" + keywordType + ", is3g=" + is3g + "]";
    }

    public KeywordType getKeywordType() {
        return keywordType;
    }

    public void setKeywordType(KeywordType keywordType) {
        this.keywordType = keywordType;
    }

    public String getIs_banner_serving() {
        return is_banner_serving;
    }

    public void setIs_banner_serving(String is_banner_serving) {
        this.is_banner_serving = is_banner_serving;
    }

    public List<Integer> getTargetCarrier() {
        return targetCarrier;
    }

    public void setTargetCarrier(List<Integer> targetCarrier) {
        this.targetCarrier = targetCarrier;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getOs_version() {
        return os_version;
    }

    public void setOs_version(String os_version) {
        this.os_version = os_version;
    }

    public String getClick2Call() {
        return click2Call;
    }

    public void setClick2Call(String click2Call) {
        this.click2Call = click2Call;
    }

    public String getHtmlCode() {
        return htmlCode;
    }

    public void setHtmlCode(String htmlCode) {
        this.htmlCode = htmlCode;
    }

    public void setBidType(int bidType) {
        this.bidType = bidType;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public int getTargetAuid() {
        return targetAuid;
    }

    public void setTargetAuid(int targetAuid) {
        this.targetAuid = targetAuid;
    }

    public long getDemoGraphic() {
        return demoGraphic;
    }

    public void setDemoGraphic(long demoGraphic) {
        this.demoGraphic = demoGraphic;
    }

    public String toString(int numberTab) {
        StringBuilder builder = new StringBuilder();
        String tab = "";
        String tab1 = "";

        for (int i = 0; i < numberTab; i++) {
            tab1 += "\t";
            tab += "\t";
        }
        tab += "\t";
        builder.append(tab1 + "Banner===>" + System.lineSeparator());
        builder.append(tab + "w= ");
        builder.append(tab + w + System.lineSeparator());

        builder.append(tab + "h= ");
        builder.append(tab + h + System.lineSeparator());

        builder.append(tab + "pos= ");
        builder.append(tab + pos + System.lineSeparator());

        return builder.toString();
    }

    public int getTypeGroup() {
        return typeGroup;
    }

    public void setTypeGroup(int typeGroup) {
        this.typeGroup = typeGroup;
    }

    public int getMinBid() {
        return minBid;
    }

    public void setMinBid(int minBid) {
        this.minBid = minBid;
    }

    public int getBidType() {
        return bidType;
    }

    public void setBidType(BidType bidType2) {
        this.bidType = bidType2.getValue();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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