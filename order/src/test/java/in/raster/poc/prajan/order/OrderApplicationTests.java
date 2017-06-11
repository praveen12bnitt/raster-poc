package in.raster.poc.prajan.order;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.times;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.raster.poc.prajan.order.model.CustomerOrder;
import in.raster.poc.prajan.order.model.OrderLine;
import in.raster.poc.prajan.order.payment.PaymentInfo;
import in.raster.poc.prajan.order.payment.PaymentService;
import in.raster.poc.prajan.order.service.OrderService;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"eureka.client.enabled = false"})
public class OrderApplicationTests {

	@Autowired
	OrderService orderService;

	@MockBean
 	PaymentService paymentService;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createOrderWithNoPayment()
	{
		CustomerOrder customerOrder = new CustomerOrder();

		customerOrder.setCustomerFirstName("Palanivelrajan");
		customerOrder.setCustomerPhoneNumber("404-509-7085");

		List<OrderLine> orderLines = new ArrayList<>();
		OrderLine orderLine = new OrderLine();
		orderLine.setOrderLineId(1);
		orderLine.setItem("t-shirt");
		orderLine.setQuantity(2.0f);
		orderLine.setUnitPrice(BigDecimal.valueOf(10.00));
		orderLine.setParentCustomerOrder(customerOrder);
		orderLines.add(orderLine);
		customerOrder.setOrderLineList(orderLines);

		orderService.saveOrder(customerOrder);

		assertThat(customerOrder.getOrderId(), notNullValue());

		assertThat(customerOrder.getOrderLineList().get(0).getLineTotal(), comparesEqualTo(BigDecimal.valueOf(20.00)));

	}

	@Test
	public void createOrderWithPayment()
	{
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setCustomerFirstName("Palanivelrajan");

		PaymentInfo paymentInfo = new PaymentInfo();
		paymentInfo.setCardType("VISA");
		paymentInfo.setCardNumber("1234567890");
		customerOrder.setPaymentInfo(paymentInfo);

		List<OrderLine> orderLines = new ArrayList<>();
		OrderLine orderLine = new OrderLine();
		orderLine.setOrderLineId(1);
		orderLine.setItem("t-shirt");
		orderLine.setQuantity(2.0f);
		orderLine.setUnitPrice(BigDecimal.valueOf(10.00));
		orderLine.setParentCustomerOrder(customerOrder);
		orderLines.add(orderLine);
		customerOrder.setOrderLineList(orderLines);

		customerOrder = orderService.saveOrder(customerOrder);

		ArgumentCaptor<PaymentInfo> paymentInfoArgumentCaptor = ArgumentCaptor.forClass(PaymentInfo.class);

		Mockito.verify(paymentService, times(1)).createPayment(paymentInfoArgumentCaptor.capture());

		PaymentInfo value = paymentInfoArgumentCaptor.getValue();

		assertThat(value.getOrderId(), is(customerOrder.getOrderId()));
		assertThat(value.getAmountToCharge(), is(customerOrder.getOrderTotal()));
	}

	@Test
	public void newTest() throws JsonProcessingException
	{
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setCustomerFirstName("Palanivelra");

		String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(customerOrder);

		System.out.println(json);
	}

}
