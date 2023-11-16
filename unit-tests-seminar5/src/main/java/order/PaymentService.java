package order;

/*
Задание №3
У вас есть сервис по обработке заказов, состоящий из двух классов: OrderService и
PaymentService. Класс OrderService обрабатывает заказы и делает вызовы к
PaymentService для обработки платежей. Ваша задача - написать интеграционный тест,
который проверяет, что OrderService и PaymentService взаимодействуют корректно.
 */

public class PaymentService {
    public boolean processPayment(String orderId, double amount) {
        // Здесь обычно был бы код для обработки платежей, но для примера просто возвращаем true
        return true;
    }
}