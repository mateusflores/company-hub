package br.unesp.mateusflores.companyhubapp.application.repositories;

import br.unesp.mateusflores.companyhubapp.domain.product.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
}
