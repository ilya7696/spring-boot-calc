package by.tovpenets.springbootcalc.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter @Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentRequest {
    int userId;
    String itemId;
    double payment;
    double discount;
}
