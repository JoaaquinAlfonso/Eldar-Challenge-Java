package eldar.challenge.controller;

import eldar.challenge.model.dto.request.TransactionRequestDTO;
import eldar.challenge.model.dto.response.ResponseInfo;
import eldar.challenge.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin("*")
@RequestMapping(value = "api/v1/transactions")
@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/validate")
    public ResponseEntity<ResponseInfo> validateTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO, HttpServletRequest httpServletRequest) {
        return ResponseEntity.ok().body(transactionService.validateTransaction(transactionRequestDTO, httpServletRequest));
    }

    @GetMapping(value = "/interest_rate")
    public ResponseEntity<ResponseInfo> getInterestRate(@RequestBody TransactionRequestDTO transactionToValidate, HttpServletRequest httpServletRequest) {
        return ResponseEntity.ok().body(transactionService.getInterestRateTransaction(transactionToValidate, httpServletRequest));
    }

}
