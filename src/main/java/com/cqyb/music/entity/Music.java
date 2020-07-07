package com.cqyb.music.entity;

import java.io.Serializable;
import java.util.Date;

public class Music implements Serializable {
    private String id;

    private String name;

    private String pid;

    private String image;

    private String mp3;

    private String lyrics;

    private Integer dnumber;

    private Integer snumber;

    private Integer cnumber;

    private Integer pnumber;

    private Integer isDelete;

    private Integer isAudit;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getMp3() {
        return mp3;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3 == null ? null : mp3.trim();
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics == null ? null : lyrics.trim();
    }

    public Integer getDnumber() {
        return dnumber;
    }

    public void setDnumber(Integer dnumber) {
        this.dnumber = dnumber;
    }

    public Integer getSnumber() {
        return snumber;
    }

    public void setSnumber(Integer snumber) {
        this.snumber = snumber;
    }

    public Integer getCnumber() {
        return cnumber;
    }

    public void setCnumber(Integer cnumber) {
        this.cnumber = cnumber;
    }

    public Integer getPnumber() {
        return pnumber;
    }

    public void setPnumber(Integer pnumber) {
        this.pnumber = pnumber;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsAudit() {
        return isAudit;
    }

    public void setIsAudit(Integer isAudit) {
        this.isAudit = isAudit;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Music other = (Music) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()))
            && (this.getMp3() == null ? other.getMp3() == null : this.getMp3().equals(other.getMp3()))
            && (this.getLyrics() == null ? other.getLyrics() == null : this.getLyrics().equals(other.getLyrics()))
            && (this.getDnumber() == null ? other.getDnumber() == null : this.getDnumber().equals(other.getDnumber()))
            && (this.getSnumber() == null ? other.getSnumber() == null : this.getSnumber().equals(other.getSnumber()))
            && (this.getCnumber() == null ? other.getCnumber() == null : this.getCnumber().equals(other.getCnumber()))
            && (this.getPnumber() == null ? other.getPnumber() == null : this.getPnumber().equals(other.getPnumber()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getIsAudit() == null ? other.getIsAudit() == null : this.getIsAudit().equals(other.getIsAudit()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        result = prime * result + ((getMp3() == null) ? 0 : getMp3().hashCode());
        result = prime * result + ((getLyrics() == null) ? 0 : getLyrics().hashCode());
        result = prime * result + ((getDnumber() == null) ? 0 : getDnumber().hashCode());
        result = prime * result + ((getSnumber() == null) ? 0 : getSnumber().hashCode());
        result = prime * result + ((getCnumber() == null) ? 0 : getCnumber().hashCode());
        result = prime * result + ((getPnumber() == null) ? 0 : getPnumber().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getIsAudit() == null) ? 0 : getIsAudit().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}