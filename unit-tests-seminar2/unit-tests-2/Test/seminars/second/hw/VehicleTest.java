package seminars.second.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seminars.second.simple_shopping_cart.Cart;
import seminars.second.simple_shopping_cart.Shop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    private Car car;
    private Motorcycle motorcycle;

    @BeforeEach
    void setup() {
        car = new Car("Toyota", "Toyota Land Cruiser", 2023);
        motorcycle = new Motorcycle("Suzuki", "Suzuki GSX 1300 R Hayabusa", 2023);
    }


    /**
     * Проверить, что экземпляр объекта Car также является экземпляром транспортного средства
     * (используя оператор instanceof).
     */
    @DisplayName("Car also is a Vehicle")
    @Test
    void carIsVehicle() {
        assertThat(car instanceof Vehicle).isEqualTo(true);
    }

    /**
     * Проверить, что экземпляр объекта Motorcycle также является экземпляром транспортного средства
     * (используя оператор instanceof).
     */
    @DisplayName("Motorcycle also is a Vehicle")
    @Test
    void motorcycleIsVehicle() {
        assertThat(motorcycle instanceof Vehicle).isEqualTo(true);
    }

    /**
     * Проверить, что объект Car создается с 4-мя колесами.
     */
    @DisplayName("Car have four wheels")
    @Test
    void carHasFourWheels() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    /**
     * Проверить, что объект Car развивает скорость 60 в режиме тестового вождения
     * (используя метод testDrive()).
     */
    @DisplayName("Car speed in test drive - 60 km/h")
    @Test
    void carSpeedInTestDrive() {
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    /**
     * Проверить, что объект Motorcycle создается с 2-мя колесами.
     */
    @DisplayName("Motorcycle have two wheels")
    @Test
    void motorcycleHasTwoWheels() {
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    /**
     * Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового вождения
     * (используя метод testDrive()).
     */
    @DisplayName("Motorcycle speed in test drive - 75 km/h")
    @Test
    void motorcycleSpeedInTestDrive() {
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    /**
     * Проверить, что в режиме парковки (сначала testDrive,
     * потом park, т.е. эмуляция движения транспорта) машина останавливается (speed = 0).
     */
    @DisplayName("car speed in park - 0 km/h")
    @Test
    void carSpeedInPark() {
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    /**
     * Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта)
     * мотоцикл останавливается (speed = 0).
     */
    @DisplayName("Motorcycle speed in park - 0 km/h")
    @Test
    void motorcycleSpeedInPark() {
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }

}