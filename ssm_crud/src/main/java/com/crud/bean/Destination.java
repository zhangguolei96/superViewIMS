package com.crud.bean;

public class Destination {
    private Integer destinationId;

    private String destinationName;

    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public Destination() { super();}

    public Destination(Integer destinationId, String destinationName){
        super();
        this.destinationId = destinationId;
        this.destinationName = destinationName;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "destinationId=" + destinationId +
                ", destinationName='" + destinationName + '\'' +
                '}';
    }
}
