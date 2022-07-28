package eldar.challenge.model.dto.response;

import eldar.challenge.model.entity.Card;
import eldar.challenge.model.enums.CardBrand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CardResponseDTO {

    CardBrand cardBrand;

    String cardNumber;

    String cardHolder;

    LocalDate expireDate;

    public CardResponseDTO(Card card) {
        this.cardBrand = card.getCardBrand();
        this.cardNumber = card.getCardNumber();
        this.cardHolder = card.getCardHolder();
        this.expireDate = card.getExpireDate();
    }
}
