package in.raster.poc.prajan.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.raster.poc.prajan.payment.model.PaymentInfo;
import in.raster.poc.prajan.payment.service.PaymentInfoService;

@RestController
@RequestMapping("/payment")
public class PaymentController
{
    @Autowired
    private PaymentInfoService paymentInfoService;

    @PutMapping
    public PaymentInfo createPaymentInfo(@RequestBody  PaymentInfo paymentInfo)
    {
        return paymentInfoService.createPaymentInfo(paymentInfo);
    }
}
