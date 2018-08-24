package vn.vcc.adopt.adxmob.model.raw;

import java.sql.Date;

/**
 * Created by tran on 11/20/14.
 */
public class RawBanner {
    private int campaignId;
    private String fileName;
    private int filetype;
    private String url;
    private String bannerName;
    private String locationAd;
    private String la;
    private int width;
    private int height;
    private String linkView;
    private String type;
    private int bannerType;
    private int is_default;
    private String fileBackup;
    private int cpa;
    private Date createDate;
    private String cities;
    private int is_sponsor;
    private int tablet;
    private double ctrByZone;
    private long pr;
    private String desc;
    private int r;
    private String fileName_replace;

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getTablet() {
        return tablet;
    }

    public int getFiletype() {
        return filetype;
    }

    public void setFiletype(int filetype) {
        this.filetype = filetype;
    }

    public void setTablet(int tablet) {
        this.tablet = tablet;
    }

    public double getCtrByZone() {
        return ctrByZone;
    }

    public void setCtrByZone(double ctrByZone) {
        this.ctrByZone = ctrByZone;
    }

    public String getFileName_replace() {
        return fileName_replace;
    }

    public void setFileName_replace(String fileName_replace) {
        this.fileName_replace = fileName_replace;
    }

    public long getPr() {
        return pr;
    }

    public void setPr(long pr) {
        this.pr = pr;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getIs_sponsor() {
        return is_sponsor;
    }

    public boolean Is_sponsor() {
        return is_sponsor == 1 ? true : false;
    }

    public void setIs_sponsor(int is_sponsor) {
        this.is_sponsor = is_sponsor;
    }

    public boolean isDefault() {
        return is_default == 1 ? true : false;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    public String getLocationAd() {
        return locationAd;
    }

    public void setLocationAd(String locationAd) {
        this.locationAd = locationAd;
    }

    public String getLa() {
        return la;
    }

    public void setLa(String la) {
        this.la = la;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getLinkView() {
        return linkView;
    }

    public void setLinkView(String linkView) {
        this.linkView = linkView;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBannerType() {
        return bannerType;
    }

    public void setBannerType(int bannerType) {
        this.bannerType = bannerType;
    }

    public int getIs_default() {
        return is_default;
    }

    public void setIs_default(int is_default) {
        this.is_default = is_default;
    }

    public String getFileBackup() {
        return fileBackup;
    }

    public void setFileBackup(String fileBackup) {
        this.fileBackup = fileBackup;
    }

    public int getCpa() {
        return cpa;
    }

    public void setCpa(int cpa) {
        this.cpa = cpa;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n [bannerId=");
        builder.append(", campaignId=");
        builder.append(campaignId);
        builder.append(", fileName=");
        builder.append(fileName);
        builder.append(", url=");
        builder.append(url);
        builder.append(", bannerName=");
        builder.append(bannerName);
        builder.append(", locationAd=");
        builder.append(locationAd);
        builder.append(", la=");
        builder.append(la);
        builder.append(", width=");
        builder.append(width);
        builder.append(", height=");
        builder.append(height);
        builder.append(", linkView=");
        builder.append(linkView);
        builder.append(", type=");
        builder.append(type);
        builder.append(", bannerType=");
        builder.append(bannerType);
        builder.append(", is_default=");
        builder.append(is_default);
        builder.append(", fileBackup=");
        builder.append(fileBackup);
        builder.append(", cpa=");
        builder.append(cpa);
        builder.append(", createDate=");
        builder.append(createDate);
        builder.append(", cities=");
        builder.append(cities);
        builder.append("]");
        return builder.toString();
    }

}