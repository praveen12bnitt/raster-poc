package in.raster.poc.prajan.order.payment;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PaymentInfo
{
    private Integer orderId;
    private String cardType;
    private String cardNumber;
    private BigDecimal amountToCharge;
}
