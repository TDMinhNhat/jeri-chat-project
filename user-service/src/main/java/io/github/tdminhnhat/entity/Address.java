package io.github.tdminhnhat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity @Table(name = "addresses")
@Getter @Setter
@NoArgsConstructor
@DynamicInsert @DynamicUpdate
public class Address extends BaseEntityJPA {

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "ward", length = 50)
    private String ward;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "country", length = 50)
    private String country;

    @Column(name = "zip_code", length = 50)
    private String zipCode;

    @OneToOne(mappedBy = "address")
    private User user;

    public Address(String address, String ward, String city, String country, String zipCode) {
        this.address = address;
        this.ward = ward;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
    }
}
