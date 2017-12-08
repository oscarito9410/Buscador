
package com.oscar.buscador.API.Model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EntityVotesSummary implements Serializable
{

    @SerializedName("entityName")
    @Expose
    private String entityName;
    @SerializedName("entityID")
    @Expose
    private Integer entityID;
    @SerializedName("totalVotesSum")
    @Expose
    private Integer totalVotesSum;
    @SerializedName("userID")
    @Expose
    private Integer userID;
    @SerializedName("userVoteScore")
    @Expose
    private Integer userVoteScore;
    private final static long serialVersionUID = -5862497468251353691L;

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Integer getEntityID() {
        return entityID;
    }

    public void setEntityID(Integer entityID) {
        this.entityID = entityID;
    }

    public Integer getTotalVotesSum() {
        return totalVotesSum;
    }

    public void setTotalVotesSum(Integer totalVotesSum) {
        this.totalVotesSum = totalVotesSum;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getUserVoteScore() {
        return userVoteScore;
    }

    public void setUserVoteScore(Integer userVoteScore) {
        this.userVoteScore = userVoteScore;
    }

}
