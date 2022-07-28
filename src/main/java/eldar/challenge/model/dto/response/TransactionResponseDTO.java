package eldar.challenge.model.dto.response;

import eldar.challenge.model.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponseDTO {

    private String transactionCardBrand;
    private String transactionCardHolder;
    private Float cardConsumption;

    public TransactionResponseDTO(Transaction transaction) {
        this.transactionCardBrand = transaction.getTransactionCard().getCardBrand().toString();
        this.transactionCardHolder = transaction.getTransactionCard().getCardHolder();
        this.cardConsumption = transaction.getCardConsumption();
    }
}
