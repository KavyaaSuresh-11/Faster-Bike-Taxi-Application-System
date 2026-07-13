package velocityventures.mobili.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import velocityventures.mobili.entity.enums.Role;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @Column(name = "profile_image")
    private String profileImage;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "profile_completed")
    private Boolean profileCompleted;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @OneToMany(mappedBy = "user")
    private List<DriverApplication> driverapplication;
    
    
    public User() {
    }



    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public String getPasswordHash() {
        return passwordHash;
    }



    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }



    public Role getRole() {
        return role;
    }



    public void setRole(Role role) {
        this.role = role;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }



    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public String getProfileImage() {
        return profileImage;
    }



    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }



    public Boolean getIsActive() {
        return isActive;
    }



    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }



    public Boolean getProfileCompleted() {
        return profileCompleted;
    }



    public void setProfileCompleted(Boolean profileCompleted) {
        this.profileCompleted = profileCompleted;
    }



    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    public LocalDateTime getLastLogin() {
        return lastLogin;
    }



    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public User(Long id, String username, String email, String passwordHash, Role role, String phoneNumber,
            String profileImage, Boolean isActive, Boolean profileCompleted, LocalDateTime createdAt,
            LocalDateTime lastLogin, List<DriverApplication> driverapplication) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.profileImage = profileImage;
        this.isActive = isActive;
        this.profileCompleted = profileCompleted;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
        this.driverapplication = driverapplication;
    }

}

