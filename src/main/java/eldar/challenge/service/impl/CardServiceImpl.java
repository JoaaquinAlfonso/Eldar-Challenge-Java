package eldar.challenge.service.impl;

import eldar.challenge.exception.CardException;
import eldar.challenge.model.dto.request.CardRequestDTO;
import eldar.challenge.model.dto.response.CardResponseDTO;
import eldar.challenge.model.dto.response.ResponseInfo;
import eldar.challenge.model.entity.Card;
import eldar.challenge.repository.CardRepository;
import eldar.challenge.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;


    /**
     * Invocar un método que devuelva toda la información de una tarjeta.
     *
     * @param cardToFind
     */
    @Override
    public CardResponseDTO getCardInfo(CardRequestDTO cardToFind) {
        Card searchedCard = cardRepository.findByCardNumber(cardToFind.getCardNumber()).orElse(null);

        if (searchedCard != null) {
            return new CardResponseDTO(searchedCard);
        } else {
            throw new CardException("We didn't found in our database a card with cardnumber [" + cardToFind.getCardNumber() + "]");
        }

    }

    /**
     * Informar si una tarjeta es válida para operar.
     *
     * @param cardToValidate
     * @param httpServletRequest
     */
    @Override
    public ResponseInfo validateCard(CardRequestDTO cardToValidate, HttpServletRequest httpServletRequest) throws CardException {
        Card searchedCard = cardRepository.findByCardNumber(cardToValidate.getCardNumber()).orElse(null);

        if (searchedCard != null) {
            if (searchedCard.getExpireDate().compareTo(LocalDate.now()) >= 0) {
                return new ResponseInfo("Valid card to make transactions",
                        httpServletRequest.getServletPath(),
                        HttpStatus.OK.value());
            } else {
                throw new CardException("The card is not valid because its date has expired (" + searchedCard.getExpireDate() + ")");
            }
        } else {
            throw new CardException("We didn't found in our database a card with cardnumber [" + cardToValidate.getCardNumber() + "]");
        }


    }

    /**
     * Identificar si una tarjeta es distinta a otra.
     *
     * @param card
     * @param cardRequestDTO
     * @param httpServletRequest
     */
    @Override
    public ResponseInfo compareCards(String card, CardRequestDTO cardRequestDTO, HttpServletRequest httpServletRequest) {

        Card cardToCompare = cardRepository.findByCardNumber(card).orElse(null);
        Card cardCompared = cardRepository.findByCardNumber(cardRequestDTO.getCardNumber()).orElse(null);

        if (cardToCompare != null && cardCompared != null) {
            if (!cardCompared.equals(cardToCompare)) {
                return new ResponseInfo("Both cards are different (compared with card number " + cardCompared.getCardNumber() + ")",
                        httpServletRequest.getServletPath(),
                        HttpStatus.OK.value());
            } else {
                return new ResponseInfo("Both cards are equals",
                        httpServletRequest.getServletPath(),
                        HttpStatus.BAD_REQUEST.value());
            }
        } else {
            throw new CardException("We didn't found in our database a cards with that numbers, check your info");
        }


    }

    /**
     * Método para obtener todas las tarjetas cargadas en la BBDD
     */
    @Override
    public List<CardResponseDTO> getAllCards() throws CardException {

        List<Card> cardList = cardRepository.findAll();
        List<CardResponseDTO> cardResponseDTOList = new ArrayList<>();

        if (cardList != null) {

            cardList.parallelStream().forEach(card -> {
                cardResponseDTOList.add(new CardResponseDTO(card));
            });

            return cardResponseDTOList;

        } else {
            throw new CardException("The database doesnt have any cards in their register");
        }

    }

}
