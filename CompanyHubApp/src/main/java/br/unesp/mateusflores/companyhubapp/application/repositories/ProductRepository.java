package br.unesp.mateusflores.companyhubapp.application.repositories;

import br.unesp.mateusflores.companyhubapp.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
