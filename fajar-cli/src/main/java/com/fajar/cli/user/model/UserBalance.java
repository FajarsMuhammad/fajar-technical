package com.fajar.cli.user.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@Entity
@Table(name = "user_balance")
@NoArgsConstructor
@AllArgsConstructor
public class UserBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private BigDecimal balance;

    @Column(name = "balance_type")
    private BalanceType balanceType;

    public enum BalanceType {
        DEBIT, KREDIT
    }

}
