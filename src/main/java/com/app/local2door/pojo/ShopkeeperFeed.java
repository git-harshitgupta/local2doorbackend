package com.app.local2door.pojo;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import java.time.LocalDate;
import java.time.LocalTime;


@Embeddable
public class ShopkeeperFeed {
	@Type(type = "text")
    private String title;
    @Lob
    @Column(name = "caption_image")
    private byte[] captionImage;
    @Column(name = "upload_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate uploadDate;
    @Column(name = "upload_time")
    private LocalTime uploadTime;
    public ShopkeeperFeed() {
    }

    public LocalDate getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }

    public LocalTime getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(LocalTime uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getCaptionImage() {
        return captionImage;
    }

    public void setCaptionImage(byte[] captionImage) {
        this.captionImage = captionImage;
    }
}	
