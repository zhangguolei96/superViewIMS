package com.crud.bean;

public class HardDiskMgt {
    private Integer sendId;

    private String sendName;

    private String sendNum;

    private Integer dId;

    private String receiveName;

    private String sendDate;

    private Destination destination;



    public Integer getSendId() {
        return sendId;
    }

    public void setSendId(Integer sendId) {
        this.sendId = sendId;
    }

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public String getSendNum() {
        return sendNum;
    }

    public void setSendNum(String sendNum) {
        this.sendNum = sendNum;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "HardDiskMgt{" +
                "sendId=" + sendId +
                ", sendName='" + sendName + '\'' +
                ", sendNum=" + sendNum +
                ", dId=" + dId +
                ", receiveName='" + receiveName + '\'' +
                ", sendDate='" + sendDate + '\'' +
                ", destination=" + destination +
                '}';
    }
}
