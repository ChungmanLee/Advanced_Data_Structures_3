package ie.ucd.csnl.comp47500.api;

public class Workstation{
    
    private Integer id;
    private String stationName;
    
    public Workstation() {
    }
    
    public Workstation(Integer id, String stationName) {
        this.id = id;
        this.stationName = stationName;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getStationName() {
        return stationName;
    }
    
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public String toString() {
        return "Workstation [id=" + id + ", stationName=" + stationName + "]";
    }
        
}
