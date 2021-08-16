package com.ot6.transacao.domains.establishments;

import com.ot6.transacao.domains.establishments.dtos.EstablishmentListResponse;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "establishments")
public class Establishment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String city;

    @NotBlank
    @Column(nullable = false)
    private String address;

    @Deprecated
    public Establishment() {}

    public Establishment(
            @NotBlank String name,
            @NotBlank String city,
            @NotBlank String address
    ) {
        this.name = name;
        this.city = city;
        this.address = address;
    }

    public EstablishmentListResponse toListResponse() {
        return new EstablishmentListResponse(this.name, this.city, this.address);
    }
}
