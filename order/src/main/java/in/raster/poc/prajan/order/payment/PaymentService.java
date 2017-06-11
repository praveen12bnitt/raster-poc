package in.raster.poc.prajan.order.payment;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("PAYMENT")
@RequestMapping("/payment")
public interface PaymentService
{
    @PutMapping
    PaymentInfo createPayment(PaymentInfo paymentInfo);
}
