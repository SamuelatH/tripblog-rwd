package com.java017.tripblog.entity;

import javax.persistence.*;
import java.util.Arrays;

/**
 * @author Sandy
 * @date
 */

@Entity
@Table(name = "intro")
public class Intro {

    //主鍵 會員編號外鍵
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //自我介紹頁首圖 先抄網路的不確定用法對不對
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "banner_pic", columnDefinition = "longblob", nullable = true)
    private byte[] bannerPic;


    //自我介紹標題
    private String introTitle;

    //自我介紹內文
    private String introContent;

    //FB Link
    private String fbLink;

    //Ig Link
    private String igLink;

    //YT Link
    private String ytLink;

    //Email Link
    private String emailLink;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getBannerPic() {
        return bannerPic;
    }

    public void setBannerPic(byte[] bannerPic) {
        this.bannerPic = bannerPic;
    }

    public String getIntroTitle() {
        return introTitle;
    }

    public void setIntroTitle(String introTitle) {
        this.introTitle = introTitle;
    }

    public String getIntroContent() {
        return introContent;
    }

    public void setIntroContent(String introContent) {
        this.introContent = introContent;
    }

    public String getFbLink() {
        return fbLink;
    }

    public void setFbLink(String fbLink) {
        this.fbLink = fbLink;
    }

    public String getIgLink() {
        return igLink;
    }

    public void setIgLink(String igLink) {
        this.igLink = igLink;
    }

    public String getYtLink() {
        return ytLink;
    }

    public void setYtLink(String ytLink) {
        this.ytLink = ytLink;
    }

    public String getEmailLink() {
        return emailLink;
    }

    public void setEmailLink(String emailLink) {
        this.emailLink = emailLink;
    }

    @Override
    public String toString() {
        return "Intro{" +
                "id=" + id +
                ", bannerPic=" + Arrays.toString(bannerPic) +
                ", introTitle='" + introTitle + '\'' +
                ", introContent='" + introContent + '\'' +
                ", fbLink='" + fbLink + '\'' +
                ", igLink='" + igLink + '\'' +
                ", ytLink='" + ytLink + '\'' +
                ", emailLink='" + emailLink + '\'' +
                '}';
    }
}

