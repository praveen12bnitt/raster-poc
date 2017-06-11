package in.raster.poc.prajan.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.raster.poc.prajan.order.model.CustomerOrder;
import in.raster.poc.prajan.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController
{

    @Autowired
    private OrderService orderService;

    @PutMapping
    public CustomerOrder createOrder(@RequestBody CustomerOrder customerOrder)
    {
        return orderService.saveOrder(customerOrder);
    }
}
