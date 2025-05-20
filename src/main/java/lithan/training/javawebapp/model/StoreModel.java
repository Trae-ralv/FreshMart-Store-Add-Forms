package lithan.training.javawebapp.model;

import jakarta.persistence.*;
import lithan.training.javawebapp.model.converter.StringArrayConverter;

// JPA entity representing a StoreModel in the database
@Entity
@Table(name = "stores")
public class StoreModel {
    // Primary key with auto-increment
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Name of the store
    @Column(nullable = false)
    private String name;

    // Phone number of the store
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    // Array of localities served by the store, stored as comma-separated string
    @Column(nullable = false)
    @Convert(converter = StringArrayConverter.class)
    private String[] localities;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String[] getLocalities() {
        return localities;
    }

    public void setLocalities(String[] localities) {
        this.localities = localities;
    }
}