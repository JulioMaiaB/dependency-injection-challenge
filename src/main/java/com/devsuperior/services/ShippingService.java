package com.devsuperior.services;

import com.devsuperior.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    private static final double SHIPPING_RATE_UNDER_100 = 20.00;
    private static final double SHIPPING_RATE_100_TO_200 = 12.00;

    public double shipment(Order order) {
        Double valueToDiscount = order.getBasic() * order.getDiscount() / 100.00;
        return calculateShipment(order.getBasic() - valueToDiscount);
    }

    private double calculateShipment(Double basicWithDiscount) {
        if (basicWithDiscount < 100.00) {
            return SHIPPING_RATE_UNDER_100;
        } else if (basicWithDiscount <= 200.00) {
            return SHIPPING_RATE_100_TO_200;
        } else {
            return 0.0;
        }
    }
}
