package eldar.challenge.service;

import eldar.challenge.exception.CardException;
import eldar.challenge.model.dto.request.CardRequestDTO;
import eldar.challenge.model.dto.response.CardResponseDTO;
import eldar.challenge.model.dto.response.ResponseInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CardService {

    CardResponseDTO getCardInfo(CardRequestDTO cardToFind) throws CardException;

    ResponseInfo validateCard(CardRequestDTO cardToValidate, HttpServletRequest httpServletRequest) throws CardException;

    ResponseInfo compareCards(String cardToCompare, CardRequestDTO cardCompared, HttpServletRequest httpServletRequest) throws CardException;

    List<CardResponseDTO> getAllCards() throws CardException;

}
