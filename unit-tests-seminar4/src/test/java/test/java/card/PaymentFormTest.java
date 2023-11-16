package card;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class PaymentFormTest {

    /**
     * 4.2. Используя библиотеку Mockito, напишите модульные тесты для проверки функциональности формы оплаты на сайте.
     * * Вместо реальной кредитной карты используйте мок-объект.
     * Создайте класс `CreditCard` с методами `getCardNumber()`, `getCardHolder()`, `getExpiryDate()`, `getCvv()`, `charge(double amount)`.
     * Создайте класс `PaymentForm` с методом `pay(double amount)`.
     * В тестовом классе, создайте мок-объект для класса `CreditCard`.
     * Определите поведение мок-объекта с помощью метода `when()`.
     * Создайте объект класса `PaymentForm`, передайте ему мок-объект в качестве аргумента.
     * Вызовите метод `pay()` и убедитесь, что мок-объект вызывает метод `charge()`
     */
    @Test
    void testPaymentForm() {
        CreditCard card = mock(CreditCard.class);
        when(card.getCardNumber()).thenReturn("123321");
        when(card.getCardHolder()).thenReturn("Test Human");
        when(card.getExpiryDate()).thenReturn("05/25");
        when(card.getCvv()).thenReturn("111");

        PaymentForm paymentForm = new PaymentForm(card);
        paymentForm.pay(100);
        verify(card, times(1)).charge(100);

    }


}