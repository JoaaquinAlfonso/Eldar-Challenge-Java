package eldar.challenge.model.entity;

import eldar.challenge.model.enums.CardBrand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Card")
@Table(name = "CARD")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)//@Column(nullable = false)
    private CardBrand cardBrand;

    @Column(unique = true, length = 16, nullable = false)
    private String cardNumber;

    @Column(length = 30, nullable = false)
    private String cardHolder;

    @Column(nullable = false)
    private LocalDate expireDate;

    @Column
    @OneToMany(mappedBy = "transactionCard")
    private List<Transaction> transactions;
}
