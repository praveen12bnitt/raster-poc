package in.raster.poc.prajan.order.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.raster.poc.prajan.order.dao.OrderRepository;
import in.raster.poc.prajan.order.model.CustomerOrder;
import in.raster.poc.prajan.order.model.PaymentStatus;
import in.raster.poc.prajan.order.payment.PaymentInfo;
import in.raster.poc.prajan.order.payment.PaymentService;

@Service
@Transactional
public class OrderService
{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentService paymentService;

    public CustomerOrder saveOrder(CustomerOrder customerOrder)
    {

        // Call save, so that we have a orderId
        customerOrder = orderRepository.save(customerOrder);

        // Now, lets see if we have payment info in it.
        if(customerOrder.getPaymentInfo() != null)
        {
            PaymentInfo paymentInfo = customerOrder.getPaymentInfo();

            paymentInfo.setOrderId(customerOrder.getOrderId());
            paymentInfo.setAmountToCharge(customerOrder.getOrderTotal());

            // Post payment info to payment component for processing.
            paymentService.createPayment(customerOrder.getPaymentInfo());
            customerOrder.setPaymentStatus(PaymentStatus.INPROCESS);
        }
        else
        {
            customerOrder.setPaymentStatus(PaymentStatus.NO_PAYMENT);
        }

        return customerOrder;
    }
}
