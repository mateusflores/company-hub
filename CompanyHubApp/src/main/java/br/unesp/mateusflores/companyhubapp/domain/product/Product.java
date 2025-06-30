package br.unesp.mateusflores.companyhubapp.domain.product;

import br.unesp.mateusflores.companyhubapp.domain.subscription.Subscription;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false, unique = true)
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Module> modules;

    @OneToMany(mappedBy = "product")
    private Set<Subscription> subscriptions;

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Product product)) return false;

        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
