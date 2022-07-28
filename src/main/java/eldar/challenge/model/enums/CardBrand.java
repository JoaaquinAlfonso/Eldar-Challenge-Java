package eldar.challenge.model.enums;

import eldar.challenge.exception.CardException;

import java.time.LocalDate;

public enum CardBrand {
    VISA, NARA, AMEX;

    private double interestRate;

    public double getInterestRate() {
        LocalDate currentdate = LocalDate.now();

        switch (this) {

            case AMEX:
                return currentdate.getMonth().getValue() * 0.1;
            case NARA:
                return currentdate.getDayOfMonth() * 0.5;
            case VISA:
                return currentdate.getYear() / currentdate.getMonth().getValue();
            default:
                throw new CardException("We didn't found that card brand, check again");
        }

    }

}
