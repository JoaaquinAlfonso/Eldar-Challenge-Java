package eldar.challenge.controller;

import eldar.challenge.model.dto.request.CardRequestDTO;
import eldar.challenge.model.dto.response.CardResponseDTO;
import eldar.challenge.model.dto.response.ResponseInfo;
import eldar.challenge.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "api/v1/cards")
@RestController
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping(value = "/search")
    public ResponseEntity<CardResponseDTO> getCardInfo(@RequestBody CardRequestDTO cardRequestDTO) {
        return ResponseEntity.ok().body(cardService.getCardInfo(cardRequestDTO));
    }

    @GetMapping(value = "/validate")
    public ResponseEntity<ResponseInfo> validateCard(@RequestBody CardRequestDTO cardToValidate, HttpServletRequest httpServletRequest) {
        return ResponseEntity.ok().body(cardService.validateCard(cardToValidate, httpServletRequest));
    }

    @GetMapping(value = "/compare/{cardNumberToCompare}")
    public ResponseEntity<ResponseInfo> compareCards(@PathVariable String cardNumberToCompare, @RequestBody CardRequestDTO cardCompared, HttpServletRequest httpServletRequest) {
        return ResponseEntity.ok().body(cardService.compareCards(cardNumberToCompare, cardCompared, httpServletRequest));
    }

    @GetMapping
    public ResponseEntity<List<CardResponseDTO>> getAllCards() {
        return ResponseEntity.ok().body(cardService.getAllCards());
    }


}
