package br.unesp.mateusflores.companyhubapp.application.repositories;

import br.unesp.mateusflores.companyhubapp.domain.company.CompanyAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyAddressRepository extends JpaRepository<CompanyAddress, UUID> {
}
