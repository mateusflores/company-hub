package br.unesp.mateusflores.companyhubapp.domain.company;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company_addresses")
public class CompanyAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Version
    private Long version;
    @Column(length = 8)
    private String postalCode;
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof CompanyAddress that)) return false;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

