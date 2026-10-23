import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void next_normalCase() {
        Radio radio = new Radio();
        radio.setCurrentStation(3);
        radio.next();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void next_wrapAroundFrom9To0() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void prev_normalCase() {
        Radio radio = new Radio();
        radio.setCurrentStation(3);
        radio.prev();
        assertEquals(2, radio.getCurrentStation());
    }

    @Test
    void prev_wrapAroundFrom0To9() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void setCurrentStation_validValue() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void setCurrentStation_tooLow_ignored() {
        Radio radio = new Radio();
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation()); // осталось 0 (начальное)
    }

    @Test
    void setCurrentStation_tooHigh_ignored() {
        Radio radio = new Radio();
        radio.setCurrentStation(10);
        assertEquals(0, radio.getCurrentStation()); // осталось 0
    }

    @Test
    void increaseVolume_normalCase() {
        Radio radio = new Radio();
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    void increaseVolume_atMax_noChange() {
        Radio radio = new Radio();
        // быстро доводим до максимума
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
        radio.increaseVolume(); // попытка увеличить сверх максимума
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void decreaseVolume_normalCase() {
        Radio radio = new Radio();
        radio.increaseVolume(); // ставим 1
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void decreaseVolume_atMin_noChange() {
        Radio radio = new Radio();
        assertEquals(0, radio.getCurrentVolume());
        radio.decreaseVolume(); // попытка уменьшить ниже минимума
        assertEquals(0, radio.getCurrentVolume());
    }
}
