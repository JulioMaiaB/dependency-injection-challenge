package com.devsuperior.services;

import com.devsuperior.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order) {
        double discountedAmount = order.getBasic() * order.getDiscount() / 100.00;
        double shipmentValue = shippingService.shipment(order);
        return order.getBasic() - discountedAmount + shipmentValue;
    }
}
