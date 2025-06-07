package br.unesp.mateusflores.companyhubapp.application.repositories.company;

import br.unesp.mateusflores.companyhubapp.domain.company.CompanyContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyContactRepository extends JpaRepository<CompanyContact, UUID> {
}
