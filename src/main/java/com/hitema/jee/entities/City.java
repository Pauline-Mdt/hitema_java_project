package com.hitema.jee.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", nullable = false)
    private Long id;

    private String city ;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    private Boolean capital;

    @OneToMany(mappedBy = "city")
    private List<Picture> pictures;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Boolean getCapital() {
        return capital;
    }

    public void setCapital(Boolean capital) {
        this.capital = capital;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("City{");
        sb.append("id=").append(id);
        sb.append(", city='").append(city).append('\'');
        sb.append(", country=").append(country);
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append(", capital=").append(capital);
        sb.append(", pictures=").append(pictures);
        sb.append('}');
        return sb.toString();
    }
}