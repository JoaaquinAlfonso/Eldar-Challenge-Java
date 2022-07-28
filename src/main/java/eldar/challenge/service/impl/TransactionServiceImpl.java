package eldar.challenge.service.impl;

import eldar.challenge.exception.TransactionException;
import eldar.challenge.model.dto.request.TransactionRequestDTO;
import eldar.challenge.model.dto.response.ResponseInfo;
import eldar.challenge.model.enums.CardBrand;
import eldar.challenge.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class TransactionServiceImpl implements TransactionService {

    /**
     * Informar si una operación es valida.
     *
     * @param transactionRequestDTO
     * @param httpServletRequest
     */
    @Override
    public ResponseInfo validateTransaction(TransactionRequestDTO transactionRequestDTO, HttpServletRequest httpServletRequest) {

        if (transactionRequestDTO.getCardConsumption() < 1000) {
            return new ResponseInfo("The transaction is valid to make ($" + transactionRequestDTO.getCardConsumption() + ")",
                    httpServletRequest.getServletPath(),
                    HttpStatus.OK.value());
        } else {
            throw new TransactionException("Transaction isn't valid because the amount is greater than $1000 ($" + transactionRequestDTO.getCardConsumption() + ")");
        }

    }

    /**
     * Obtener por medio de un método la tasa de una operación informando marca e importe
     *
     * @param transactionRequestDTO
     * @param httpServletRequest
     * @return
     */
    @Override
    public ResponseInfo getInterestRateTransaction(TransactionRequestDTO transactionRequestDTO, HttpServletRequest httpServletRequest) {

        CardBrand cardBrand = transactionRequestDTO.getTransactionCard().getCardBrand();
        double interestRate = cardBrand.getInterestRate();
        double totalSpent = transactionRequestDTO.getCardConsumption() + ((interestRate / 100) * transactionRequestDTO.getCardConsumption());

        return new ResponseInfo("The interest rate of the transaction is %" + interestRate +
                " belonging to the card " + cardBrand + ". Total: $" + totalSpent,
                httpServletRequest.getServletPath(),
                HttpStatus.OK.value());

    }
}
