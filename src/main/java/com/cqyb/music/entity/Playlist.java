package com.cqyb.music.entity;

import java.io.Serializable;

public class Playlist implements Serializable {
    private String id;

    private String uid;

    private Integer pnumber;

    private Integer cnumber;

    private Integer isOnline;

    private String name;

    private String image;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public Integer getPnumber() {
        return pnumber;
    }

    public void setPnumber(Integer pnumber) {
        this.pnumber = pnumber;
    }

    public Integer getCnumber() {
        return cnumber;
    }

    public void setCnumber(Integer cnumber) {
        this.cnumber = cnumber;
    }

    public Integer getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Integer isOnline) {
        this.isOnline = isOnline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
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
        Playlist other = (Playlist) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getPnumber() == null ? other.getPnumber() == null : this.getPnumber().equals(other.getPnumber()))
            && (this.getCnumber() == null ? other.getCnumber() == null : this.getCnumber().equals(other.getCnumber()))
            && (this.getIsOnline() == null ? other.getIsOnline() == null : this.getIsOnline().equals(other.getIsOnline()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getPnumber() == null) ? 0 : getPnumber().hashCode());
        result = prime * result + ((getCnumber() == null) ? 0 : getCnumber().hashCode());
        result = prime * result + ((getIsOnline() == null) ? 0 : getIsOnline().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        return result;
    }
}