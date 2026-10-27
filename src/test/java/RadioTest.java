import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void defaultConstructorShouldSet10Stations() {
        Radio radio = new Radio();
        assertEquals(10, radio.getStationsCount());
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void constructorWithParameterShouldSetStationsCount() {
        Radio radio = new Radio(30);
        assertEquals(30, radio.getStationsCount());
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void nextShouldWrapAround() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void prevShouldWrapAround() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void setCurrentStationShouldValidateRange() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(3);
        assertEquals(3, radio.getCurrentStation());

        radio.setCurrentStation(-1); // вне диапазона
        assertEquals(3, radio.getCurrentStation()); // не изменилось

        radio.setCurrentStation(5); // вне диапазона (максимум 4)
        assertEquals(3, radio.getCurrentStation()); // не изменилось
    }

    @Test
    void increaseVolumeShouldNotExceed100() {
        Radio radio = new Radio();
        for (int i = 0; i < 150; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getVolume());
    }

    @Test
    void decreaseVolumeShouldNotGoBelow0() {
        Radio radio = new Radio();
        radio.setVolume(100); // если добавишь сеттер, или просто сделай цикл уменьшения
        for (int i = 0; i < 150; i++) {
            radio.decreaseVolume();
        }
        assertEquals(0, radio.getVolume());
    }

    @Test
    void singleStationShouldWrapImmediately() {
        Radio radio = new Radio(1);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
        radio.prev();
        assertEquals(0, radio.getCurrentStation());
    }
}
