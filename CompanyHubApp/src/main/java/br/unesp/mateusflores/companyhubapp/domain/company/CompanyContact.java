package br.unesp.mateusflores.companyhubapp.domain.company;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "company_contacts", schema = "companyhub")
public class CompanyContact {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Version
    private Long version;
    private String name;
    private String email;
    @Column(length = 30)
    private String phone;
    @Column(name = "alternate_phone")
    private String alternatePhone;
    private String department;
    private String notes;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof CompanyContact that)) return false;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
