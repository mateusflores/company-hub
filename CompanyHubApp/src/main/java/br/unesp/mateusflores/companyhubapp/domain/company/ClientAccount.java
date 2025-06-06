package br.unesp.mateusflores.companyhubapp.domain.company;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "client_accounts", schema = "companyhub")
public class ClientAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Version
    private Long version;
    @Column(nullable = false)
    private String identifier;
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "clientAccount"
    )
    private Set<Company> companies;

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
