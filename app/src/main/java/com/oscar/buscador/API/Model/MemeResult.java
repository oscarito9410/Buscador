
package com.oscar.buscador.API.Model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemeResult implements Serializable
{

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("elapsedMS")
    @Expose
    private Integer elapsedMS;
    @SerializedName("warning")
    @Expose
    private String warning;

    @SerializedName("result")
    @Expose
    private List<Result> listMemes = null;


    private final static long serialVersionUID = 4042287671480412518L;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getElapsedMS() {
        return elapsedMS;
    }

    public void setElapsedMS(Integer elapsedMS) {
        this.elapsedMS = elapsedMS;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }


    public List<Result> getListMemes() {
        return listMemes;
    }

    public void setListMemes(List<Result> listMemes) {
        this.listMemes = listMemes;
    }
}
