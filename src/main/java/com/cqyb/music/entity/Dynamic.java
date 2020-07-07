package com.cqyb.music.entity;

import java.io.Serializable;
import java.util.Date;

public class Dynamic implements Serializable {
    private String id;

    private String uid;

    private Integer znumber;

    private Integer fnumber;

    private Integer pnumber;

    private String comment;

    private Date time;

    private String file;

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

    public Integer getZnumber() {
        return znumber;
    }

    public void setZnumber(Integer znumber) {
        this.znumber = znumber;
    }

    public Integer getFnumber() {
        return fnumber;
    }

    public void setFnumber(Integer fnumber) {
        this.fnumber = fnumber;
    }

    public Integer getPnumber() {
        return pnumber;
    }

    public void setPnumber(Integer pnumber) {
        this.pnumber = pnumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
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
        Dynamic other = (Dynamic) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getZnumber() == null ? other.getZnumber() == null : this.getZnumber().equals(other.getZnumber()))
            && (this.getFnumber() == null ? other.getFnumber() == null : this.getFnumber().equals(other.getFnumber()))
            && (this.getPnumber() == null ? other.getPnumber() == null : this.getPnumber().equals(other.getPnumber()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getFile() == null ? other.getFile() == null : this.getFile().equals(other.getFile()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getZnumber() == null) ? 0 : getZnumber().hashCode());
        result = prime * result + ((getFnumber() == null) ? 0 : getFnumber().hashCode());
        result = prime * result + ((getPnumber() == null) ? 0 : getPnumber().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getFile() == null) ? 0 : getFile().hashCode());
        return result;
    }
}