package com.fajar.cli.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Builder
@Entity
@Table(name = "user",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "username")
    })
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    private BigDecimal totalBalance;

    private User(String username) {
        this.username = username;
        this.totalBalance = BigDecimal.ZERO;
    }

    public User addBalance(BigDecimal deposit){
        this.totalBalance = totalBalance.add(deposit);
        return this;
    }

    public User decreaseBalance(BigDecimal deposit){
        this.totalBalance = totalBalance.subtract(deposit);
        return this;
    }

    public static User valueOf(String username) {
        return new User(username);
    }

}
