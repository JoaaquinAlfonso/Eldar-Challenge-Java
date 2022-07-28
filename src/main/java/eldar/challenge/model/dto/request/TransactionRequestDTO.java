package eldar.challenge.model.dto.request;

import eldar.challenge.model.entity.Card;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TransactionRequestDTO {

    private Card transactionCard;

    private float cardConsumption;
}
