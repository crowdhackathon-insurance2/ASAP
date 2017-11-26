package com.hack.hackathonSpring.dto;

public class TestDataSendDto {
    Long id;
    Double longtitude;
    Double latitude;

    public TestDataSendDto() {
    }

    public TestDataSendDto(Long id, Double longtitude, Double latitude) {
        this.id = id;
        this.longtitude = longtitude;
        this.latitude = latitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
