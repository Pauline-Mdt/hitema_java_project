package com.hitema.jee.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Base64;

@Entity
@Table(name = "city_picture")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String name;

    private String type;

    private String size;

    private byte[] file;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFile() {
        return Base64.getEncoder().encodeToString(this.file);
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Picture{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", size='").append(size).append('\'');
        sb.append(", file='").append(file).append('\'');
        sb.append(", city=").append(city);
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append('}');
        return sb.toString();
    }
}
