package br.unesp.mateusflores.companyhubapp.application.repositories;

import br.unesp.mateusflores.companyhubapp.domain.subscription.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
