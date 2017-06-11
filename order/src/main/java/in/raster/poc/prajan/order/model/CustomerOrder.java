package in.raster.poc.prajan.order.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import in.raster.poc.prajan.order.payment.PaymentInfo;
import lombok.Data;

@Data
@Entity
public class CustomerOrder
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    private String customerFirstName;

    private String customerLastName;

    private String customerEmail;

    private String customerPhoneNumber;

    @OneToMany(mappedBy = "parentCustomerOrder", cascade = CascadeType.ALL)
    private List<OrderLine> orderLineList = new ArrayList<>();

    @Transient
    private PaymentInfo paymentInfo;

    private PaymentStatus paymentStatus = PaymentStatus.INPROCESS;

    public BigDecimal getOrderTotal()
    {
        return orderLineList.stream().map(OrderLine::getLineTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
