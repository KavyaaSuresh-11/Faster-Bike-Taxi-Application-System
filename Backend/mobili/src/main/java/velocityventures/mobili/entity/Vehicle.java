package velocityventures.mobili.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import velocityventures.mobili.entity.enums.VehicleConditions;
import velocityventures.mobili.entity.enums.VehicleStatus;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , unique = true, length = 20)
    private String registrationNumber;

    @Column(nullable = false, length = 30)
    private String vehicleType;

    @Column(length = 25)
    private String brand;

    @Column
    private String model;

    @Column
    private String color;

    private  String manufactureYear;

    @Column(nullable = false, unique = true)
    private String insurancePolicyNumber;

    @Column
    private String insuranceExpiry;

    @Column(length = 50)
private String pollutionCertificateNumber;

private String pollutionExpiry;

@Enumerated(EnumType.STRING)
private VehicleConditions vehicleConditions;

@Enumerated(EnumType.STRING)
private VehicleStatus vehicleStatus;

@CreationTimestamp
private LocalDateTime createdAt;

@OneToOne
@JoinColumn(name = "driver_applicationid")
private DriverApplication driverApplication;

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

public void setPollutionCertificateExpiry(String pollutionExpiry) {
    this.pollutionExpiry = pollutionExpiry;
}

public VehicleConditions getVehicleConditions() {
    return vehicleConditions;
}

public void setVehicleConditions(VehicleConditions vehicleConditions) {
    this.vehicleConditions = vehicleConditions;
}

public VehicleStatus getVehicleStatus() {
    return vehicleStatus;
}

public void setVehicleStatus(VehicleStatus vehicleStatus) {
    this.vehicleStatus = vehicleStatus;
}

public LocalDateTime getCreatedAt() {
    return createdAt;
}

public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
}

public DriverApplication getDriverApplication() {
    return driverApplication;
}

public void setDriverApplication(DriverApplication driverApplication) {
    this.driverApplication = driverApplication;
}

public Vehicle(){

}

@lombok.Builder
public Vehicle(Long id, String registrationNumber, String vehicleType, String brand, String model, String color,
        String manufactureYear, String insurancePolicyNumber,String insuranceExpiry,
        String pollutionCertificateNumber, String pollutionExpiry, VehicleConditions vehicleConditions,
        VehicleStatus vehicleStatus, LocalDateTime createdAt, DriverApplication driverApplication) {
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
    this.vehicleConditions = vehicleConditions;
    this.vehicleStatus = vehicleStatus;
    this.createdAt = createdAt;
    this.driverApplication = driverApplication;
}





}
