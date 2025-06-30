package br.unesp.mateusflores.companyhubapp.domain.subscription;

import br.unesp.mateusflores.companyhubapp.domain.company.Company;
import br.unesp.mateusflores.companyhubapp.domain.product.Module;
import br.unesp.mateusflores.companyhubapp.domain.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToMany
    @JoinTable(
            name = "subscription_module",
            joinColumns = @JoinColumn(name = "subscription_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id")
    )
    private Set<Module> modules;

    @Column(name = "discount_percentage", precision = 19, scale = 2)
    private BigDecimal discountPercentage = BigDecimal.valueOf(0.00);

    @Column(name = "valid_until")
    private LocalDate validUntil;

    @Column(name = "is_valid", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean isValid;

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Subscription subscription)) return false;

        return Objects.equals(id, subscription.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
