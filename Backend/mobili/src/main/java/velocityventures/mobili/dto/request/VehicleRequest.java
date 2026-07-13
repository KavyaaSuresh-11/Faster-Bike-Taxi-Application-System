package velocityventures.mobili.dto.request;

import lombok.Builder;

@Builder
public class VehicleRequest {
    
    private Long id;
    private String registrationNumber;
    private String vehicleType;
    private String brand;
    private String model;
    private String color;
    private String manufactureYear;
    private String insurancePolicyNumber;
    private String insuranceExpiry;
    private String pollutionCertificateNumber;
    private String pollutionExpiry;

    public VehicleRequest(){
        
    }

    public VehicleRequest(Long id, String registrationNumber, String vehicleType, String brand, String model,
            String color, String manufactureYear, String insurancePolicyNumber, String insuranceExpiry,
            String pollutionCertificateNumber, String pollutionExpiry) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.manufactureYear = manufactureYear;
        this.insurancePolicyNumber = insurancePolicyNumber;
        this.insuranceExpiry = insuranceExpiry;
        this.pollutionCertificateNumber = pollutionCertificateNumber;
        this.pollutionExpiry = pollutionExpiry;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    public String getVehicleType() {
        return vehicleType;
    }
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getManufactureYear() {
        return manufactureYear;
    }
    public void setManufactureYear(String manufactureYear) {
        this.manufactureYear = manufactureYear;
    }
    public String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }
    public void setInsurancePolicyNumber(String insurancePolicyNumber) {
        this.insurancePolicyNumber = insurancePolicyNumber;
    }
    public String getInsuranceExpiry() {
        return insuranceExpiry;
    }
    public void setInsuranceExpiry(String insuranceExpiry) {
        this.insuranceExpiry = insuranceExpiry;
    }
    public String getPollutionCertificateNumber() {
        return pollutionCertificateNumber;
    }
    public void setPollutionCertificateNumber(String pollutionCertificateNumber) {
        this.pollutionCertificateNumber = pollutionCertificateNumber;
    }
    public String getPollutionExpiry() {
        return pollutionExpiry;
    }
    public void setPollutionExpiry(String pollutionExpiry) {
        this.pollutionExpiry = pollutionExpiry;
    }

    


}
