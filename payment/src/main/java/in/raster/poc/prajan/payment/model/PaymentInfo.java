package in.raster.poc.prajan.payment.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PaymentInfo
{
    @Id
    private Integer orderId;
    private String cardType;
    private String cardNumber;
    private BigDecimal amountToCharge;
    private PaymentStatus paymentStatus;
}
