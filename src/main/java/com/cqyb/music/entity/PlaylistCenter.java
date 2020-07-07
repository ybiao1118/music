package com.cqyb.music.entity;

import java.io.Serializable;

public class PlaylistCenter implements Serializable {
    private String id;

    private String plid;

    private String mid;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPlid() {
        return plid;
    }

    public void setPlid(String plid) {
        this.plid = plid == null ? null : plid.trim();
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
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
        PlaylistCenter other = (PlaylistCenter) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPlid() == null ? other.getPlid() == null : this.getPlid().equals(other.getPlid()))
            && (this.getMid() == null ? other.getMid() == null : this.getMid().equals(other.getMid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPlid() == null) ? 0 : getPlid().hashCode());
        result = prime * result + ((getMid() == null) ? 0 : getMid().hashCode());
        return result;
    }
}