package br.unesp.mateusflores.companyhubapp.domain.subscription;

import br.unesp.mateusflores.companyhubapp.domain.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "module_name", unique = true, nullable = false)
    private String moduleName;

    @Column(name = "module_description")
    private String moduleDescription;

    @Column(name = "base_price", nullable = false, precision = 19, scale = 2)
    private BigDecimal basePrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "is_main_module", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean isMainModule;

    @ManyToMany(mappedBy = "modules")
    private Set<Subscription> subscriptions;

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Module module)) return false;

        return Objects.equals(id, module.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
