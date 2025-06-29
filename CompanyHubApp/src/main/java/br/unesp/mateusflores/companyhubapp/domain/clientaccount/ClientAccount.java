package br.unesp.mateusflores.companyhubapp.domain.clientaccount;

import br.unesp.mateusflores.companyhubapp.domain.company.Company;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "client_accounts")
public class ClientAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Version
    private Long version;
    @Column(name = "username", nullable = false, length = 50)
    private String userName;
    @Column(nullable = false, length = 100)
    private String identifier;
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "clientAccount"
    )
    private Set<Company> companies = new HashSet<>();

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof ClientAccount that)) return false;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
