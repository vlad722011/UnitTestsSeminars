package seminars.second.simple_shopping_cart;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    // Создаем набор продуктов для магазина:
    public static List<Product> getStoreItems() {
        List<Product> products = new ArrayList<>();

        // Три массива Названия, Цены, Кол-во
        String[] productNames = {"bacon", "beef", "ham", "salmon", "carrot", "potato", "onion", "apple", "melon", "rice", "eggs", "yogurt"};
        Double[] productPrice = {170.00d, 250.00d, 200.00d, 150.00d, 15.00d, 30.00d, 20.00d, 59.00d, 88.00d, 100.00d, 80.00d, 55.00d};
        Integer[] stock = {10, 10, 10, 10, 10, 10, 10, 70, 13, 30, 40, 60};

        // Последовательно наполняем список продуктами
        for (int i = 0; i < productNames.length; i++) {
            products.add(new Product(i + 1, productNames[i], productPrice[i], stock[i]));
        }
        return products;
    }

    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    private Shop shop;
    private Cart cart;

    @BeforeEach
    void setup() {
        shop = new Shop(getStoreItems());
        cart = new Cart(shop);
    }

/*
            ID | Название  | Цена, р. | Кол-во в магазине, шт.
            1  | bacon     | 170.0    | 10
            2  | beef      | 250.0    | 10
            3  | ham       | 200.0    | 10
            4  | salmon    | 150.0    | 10
            5  | carrot    | 15.0     | 10
            6  | potato    | 30.0     | 10
            7  | onion     | 20.0     | 10
            8  | apple     | 59.0     | 70
            9  | melon     | 88.0     | 13
            10 | rice      | 100.0    | 30
            11 | eggs      | 80.0     | 40
            12 | yogurt    | 55.0     | 60
*/

    /**
     * 2.1. Разработайте модульный тест для проверки, что общая стоимость
     * корзины с разными товарами корректно рассчитывается
     * <br><b>Ожидаемый результат:</b>
     * Стоимость корзины посчиталась корректно
     */
    @Test
    void priceCartIsCorrectCalculated() {
        // Arrange (Подготовка)
        // Shop shop = new Shop(getStoreItems());
        // Cart cart = new Cart(shop);

        // Act (Выполнение)
        cart.addProductToCartByID(1); // 170 +
        cart.addProductToCartByID(2); // 250 +
        cart.addProductToCartByID(3); // 200 +
        cart.addProductToCartByID(4); // 150 +

        // Assert
        assertThat(cart.getTotalPrice()).isEqualTo(770.0);
    }

    /**
     * 2.2. Создайте модульный тест для проверки, что общая стоимость
     * корзины с множественными экземплярами одного и того же продукта корректно рассчитывается.
     * <br><b>Ожидаемый результат:</b>
     * Стоимость корзины посчиталась корректно
     */
    @Test
    void priceCartProductsSameTypeIsCorrectCalculated() {
        // Arrange

        // Act
        for (int i = 0; i < 5; i++) {
            cart.addProductToCartByID(1); // 170 +
        }

        // Assert
        assertThat(cart.getTotalPrice()).isEqualTo(850.0);
    }

    /**
     * 2.3. Напишите модульный тест для проверки, что при удалении
     * товара из корзины происходит перерасчет общей стоимости корзины.
     * <br><b>Ожидаемый результат:</b>
     * Вызывается метод пересчета стоимости корзины, стоимость корзины меняется
     */
    @Test
    void whenChangingCartCostRecalculationIsCalled() {
        // Act
        for (int i = 0; i < 5; i++) {
            cart.addProductToCartByID(1); // 170 +
        }
        cart.removeProductByID(1);

        // Assert
        assertThat(cart.getTotalPrice()).isEqualTo(680.0);
    }

    /**
     * 2.4. Разработайте модульный тест для проверки, что при добавлении определенного количества товара в корзину,
     * общее количество этого товара в магазине соответствующим образом уменьшается.
     * <br><b>Ожидаемый результат:</b>
     * Количество товара в магазине уменьшается на число продуктов в корзине пользователя
     */

    @Test
    void quantityProductsStoreChanging() {
        // Act
        for (int i = 0; i < 5; i++) {
            cart.addProductToCartByID(1); // 170 +
        }
        int baconInShop = shop.getProductsShop().get(0).getQuantity();

        // Assert
        assertThat(baconInShop).isEqualTo(5);
    }

    /**
     * 2.5. Создайте модульный тест для проверки, что если пользователь забирает все имеющиеся продукты
     * определенного типа из магазина, эти продукты больше не доступны для заказа.
     * <br><b>Ожидаемый результат:</b>
     * Больше такой продукт заказать нельзя, он не появляется на полке
     */

    @Test
    void lastProductsDisappearFromStore() {
        // Act
        for (int i = 0; i < 10; i++) {
            cart.addProductToCartByID(1); // 170 +
        }
        int baconInShop = shop.getProductsShop().get(0).getQuantity();
        // Assert
        assertThat(baconInShop).isEqualTo(0);
        // Act
        cart.addProductToCartByID(1);
        // Assert
        assertThat(baconInShop).isEqualTo(0);
    }

    /**
     * 2.6. Напишите модульный тест для проверки, что при удалении товара из корзины,
     * общее количество этого товара в магазине соответствующим образом увеличивается.
     * <br><b>Ожидаемый результат:</b>
     * Количество продуктов этого типа на складе увеличивается на число удаленных из корзины продуктов
     */
    @Test
    void deletedProductIsReturnedToShop() {
        // Act
        for (int i = 0; i < 10; i++) {
            cart.addProductToCartByID(1); // 170 +
        }
        int baconInShop = shop.getProductsShop().get(0).getQuantity();
        // Assert
        assertThat(baconInShop).isEqualTo(0);
        // Act
        cart.removeProductByID(1);
        int baconInShopAfterRemove = shop.getProductsShop().get(0).getQuantity();
        // Assert
        assertThat(baconInShopAfterRemove).isEqualTo(1);
    }

    /**
     * 2.7. Разработайте параметризованный модульный тест для проверки,
     * что при вводе неверного идентификатора товара генерируется исключение RuntimeException.
     * <br><b>Ожидаемый результат:</b>
     * Исключение типа RuntimeException и сообщение Не найден продукт с id
     * *Сделать тест параметризованным
     */

    @ParameterizedTest
    @ValueSource(ints = {50, -10, 23})
    void incorrectProductSelectionCausesException(int i) {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            cart.addProductToCartByID(i);
        });
        assertThat(exception.getMessage()).isEqualTo("Не найден продукт с id: " + i);
    }

    /**
     * 2.8.      * 2.8. Создайте модульный тест для проверки, что при попытке удалить из корзины больше товаров,
     * чем там есть, генерируется исключение RuntimeException.удаляет продукты до того, как их добавить)
     * <br><b>Ожидаемый результат:</b> Исключение типа NoSuchFieldError и сообщение "В корзине не найден продукт с id"
     */
    @Test
    void incorrectProductRemoveCausesException() {
        int baconInShopBefore = shop.getProductsShop().get(0).getQuantity();
        for (int i = 0; i < 3; i++) {
            cart.addProductToCartByID(1);
        }
        int baconInShopAfter = shop.getProductsShop().get(0).getQuantity();
        int baconInCart = baconInShopBefore - baconInShopAfter;

        for (int i = 0; i < baconInCart; i++) {
            cart.removeProductByID(1);
        }
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
            cart.removeProductByID(1);
        });
        assertThat(runtimeException.getMessage()).isEqualTo("В корзине не найден продукт с id: " + 1);
    }

    /**
     * 2.9. Нужно восстановить тест
     */
    @Test
    void broken() {
        // Arrange (Подготовка)
        Shop shop = new Shop(getStoreItems());
        Cart cart = new Cart(shop);
        // Act (Выполнение)
        cart.addProductToCartByID(2); // 250
        cart.addProductToCartByID(2); // 250
        // Assert (Проверка утверждения)
        assertThat(cart.getTotalPrice()).isEqualTo(500.0);
    }

    /**
     * 2.10. Нужно оптимизировать тестовый метод, согласно следующим условиям:
     * <br> 1. Отображаемое имя - "Advanced test for calculating TotalPrice"
     * <br> 2. Тест повторяется 10 раз
     * <br> 3. Установлен таймаут на выполнение теста 70 Миллисекунд (unit = TimeUnit.MILLISECONDS)
     * <br> 4. После проверки работоспособности теста, его нужно выключить
     */

    // @Disabled
    @DisplayName("Advanced test for calculating TotalPrice")
    @RepeatedTest(10)
    @Timeout(value = 70, unit = TimeUnit.MILLISECONDS)
    @Disabled
    void testSUM() {
        // Arrange (Подготовка)
        // Act (Выполнение)
        // cart.addProductToCartByID(2); // 250
        // Assert (Проверка утверждения)
        //assertThat(cart.getTotalPrice()).isEqualTo(250.0);
    }
}