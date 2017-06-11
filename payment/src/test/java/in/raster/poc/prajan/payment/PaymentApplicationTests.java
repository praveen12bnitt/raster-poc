package in.raster.poc.prajan.payment;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import in.raster.poc.prajan.payment.model.PaymentInfo;
import in.raster.poc.prajan.payment.model.PaymentStatus;
import in.raster.poc.prajan.payment.service.PaymentInfoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentApplicationTests {

	@Autowired
	PaymentInfoService paymentInfoService;

	@Test
	public void createPaymentInfo()
	{
		PaymentInfo paymentInfo = new PaymentInfo();
		paymentInfo.setOrderId(12);
		paymentInfo.setCardNumber("12345678");
		paymentInfo.setCardType("VISA");
		paymentInfo.setAmountToCharge(BigDecimal.valueOf(100));
		paymentInfo.setPaymentStatus(PaymentStatus.RECEIVED);

		paymentInfoService.createPaymentInfo(paymentInfo);
	}

}
