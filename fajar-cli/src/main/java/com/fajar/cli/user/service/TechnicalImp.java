package com.fajar.cli.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class TechnicalImp {

    private static final Logger log = LoggerFactory
        .getLogger(TechnicalImp.class);

    public BigDecimal sum(BigDecimal x, BigDecimal y) {
        BigDecimal sum = x.add(y);
        log.info("Sum : {}", sum);
        return sum;
    }

    public BigDecimal multiply(BigDecimal x, BigDecimal y) {
        BigDecimal multiply = x.multiply(y);
        log.info("multiply : {}", multiply);
        return multiply;
    }

    public String prime(int n) {
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            int counter = 0;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    counter++;
                    break;
                }
            }

            if (counter == 0 && i > 1) {
                result.append(i).append(" ");
            }
        }
        log.info("Prime Numbers : {} ", result);
        return result.toString();
    }

    // 0 1 1 2 3 5 8
    public String fibonacci(int n) {
        StringBuilder result = new StringBuilder();
        int one = 0;
        int two = 1;
        for (int i = 0; i < n; i++) {
            result.append(one).append(" ");
            int temp = one + two;
            one = two;
            two = temp;
        }
        log.info("fibonacci : {} ", result);
        return result.toString();
    }

}