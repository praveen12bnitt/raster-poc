package in.raster.poc.prajan.payment.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.raster.poc.prajan.payment.dao.PaymentInfoRepository;
import in.raster.poc.prajan.payment.model.PaymentInfo;

@Service
@Transactional
public class PaymentInfoService
{
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    public PaymentInfo createPaymentInfo(PaymentInfo paymentInfo)
    {
        return paymentInfoRepository.save(paymentInfo);
    }
}
