import java.util.Date;

public class TestDataDTO {
    Date date;
    Boolean isCritical;
    String type;
    Double longtitude;
    Double latitude;
    Long id;

    public TestDataDTO(Date date, Boolean isCritical, String type, Double longtitude, Double latitude, Long id) {
        this.date = date;
        this.isCritical = isCritical;
        this.type = type;
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getCritical() {
        return isCritical;
    }

    public void setCritical(Boolean critical) {
        isCritical = critical;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
