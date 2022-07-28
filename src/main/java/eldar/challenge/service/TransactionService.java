package eldar.challenge.service;

import eldar.challenge.exception.TransactionException;
import eldar.challenge.model.dto.request.TransactionRequestDTO;
import eldar.challenge.model.dto.response.ResponseInfo;

import javax.servlet.http.HttpServletRequest;

public interface TransactionService {

    ResponseInfo validateTransaction(TransactionRequestDTO transactionRequestDTO, HttpServletRequest httpServletRequest) throws TransactionException;

    ResponseInfo getInterestRateTransaction(TransactionRequestDTO transactionRequestDTO, HttpServletRequest httpServletRequest);

}
