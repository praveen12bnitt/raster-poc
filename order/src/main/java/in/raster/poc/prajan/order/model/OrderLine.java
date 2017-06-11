package in.raster.poc.prajan.order.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class OrderLine
{
    @Id
    private Integer orderLineId;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private CustomerOrder parentCustomerOrder;

    private String item;
    private String itemDesc;
    private Float quantity;
    private BigDecimal unitPrice = BigDecimal.ZERO;

    public BigDecimal getLineTotal()
    {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }
}
