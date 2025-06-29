package br.unesp.mateusflores.companyhubapp.application.repositories;


import br.unesp.mateusflores.companyhubapp.domain.clientaccount.ClientAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientAccountRepository extends JpaRepository<ClientAccount, UUID> {
}
