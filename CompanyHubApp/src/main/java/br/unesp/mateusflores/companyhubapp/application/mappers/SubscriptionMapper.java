package br.unesp.mateusflores.companyhubapp.application.mappers;

import br.unesp.mateusflores.companyhubapp.application.dtos.subscription.SubscriptionCreateRequestDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.subscription.SubscriptionSummaryResponseDTO;
import br.unesp.mateusflores.companyhubapp.application.dtos.subscription.SubscriptionUpdateRequestDTO;
import br.unesp.mateusflores.companyhubapp.domain.subscription.Subscription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, CompanyMapper.class})
public interface SubscriptionMapper extends GenericMapper<Subscription, SubscriptionCreateRequestDTO,
        SubscriptionUpdateRequestDTO, SubscriptionSummaryResponseDTO> {
}
