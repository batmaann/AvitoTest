package avito.apiConfig;

public class PositionData {
    private String addressId;
    private int zoom;
    private String esid;
    private String params;
    private String itemId;
    private double latitude;
    private double longitude;
    private boolean getAddress;


    public PositionData(String addressId, int zoom, String esid, String params, String itemId, double latitude, double longitude, boolean getAddress) {
        this.addressId = addressId;
        this.zoom = zoom;
        this.esid = esid;
        this.params = params;
        this.itemId = itemId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.getAddress = getAddress;
    }


    // Геттеры и сеттеры
    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public String getEsid() {
        return esid;
    }

    public void setEsid(String esid) {
        this.esid = esid;
    }

    public Object getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setGetAddress(boolean getAddress) {
        this.getAddress = getAddress;
    }

}