package com.cg.dto.payment;

  import lombok.Data;
import lombok.experimental.Accessors;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Accessors(chain = true)
public class PaymentCustomerResult {

    private Long id;

    private Instant createdAt;

    private Long userId;

    private Long orderId;

    private BigDecimal paid;
}
