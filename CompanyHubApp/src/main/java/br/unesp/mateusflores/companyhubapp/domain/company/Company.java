package br.unesp.mateusflores.companyhubapp.domain.company;

import br.unesp.mateusflores.companyhubapp.domain.clientaccount.ClientAccount;
import br.unesp.mateusflores.companyhubapp.domain.subscription.Subscription;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Version
    private Long version;

    private Long internalIdentifier;

    @Column(length = 14, nullable = false, unique = true)
    private String cnpj;

    @Column(nullable = false)
    private String companyName;

    private String tradingName;

    private LocalDate registrationDate;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<CompanyContact> contacts;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<CompanyAddress> addresses;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private ClientAccount clientAccount;

    @OneToMany(mappedBy = "company")
    private Set<Subscription> subscriptions;

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Company company)) return false;

        return Objects.equals(id, company.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
