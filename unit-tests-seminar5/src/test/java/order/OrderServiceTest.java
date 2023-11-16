package order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class OrderServiceTest {

    @BeforeEach
    void setUp() {
        String orderId = String.valueOf(23);
        double amount = 1500.00;

    }
    @Test
    void placeOrder() {
        PaymentService paymentService = new PaymentService();
        boolean isOrder = paymentService.processPayment("23", 1500.00);
        OrderService orderService = new OrderService(paymentService);
        assertThat(isOrder).isEqualTo(orderService.placeOrder("23", 1500.0));
    }
}