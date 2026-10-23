public class Radio {
    private int currentStation;
    private int currentVolume;

    public Radio() {
        this.currentStation = 0;
        this.currentVolume = 0;
    }

    // Переключение на следующую станцию (с циклом 9 -> 0)
    public void next() {
        if (currentStation == 9) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    // Переключение на предыдущую станцию (с циклом 0 -> 9)
    public void prev() {
        if (currentStation == 0) {
            currentStation = 9;
        } else {
            currentStation--;
        }
    }

    // Установка станции напрямую с проверкой диапазона [0; 9]
    public void setCurrentStation(int station) {
        if (station >= 0 && station <= 9) {
            this.currentStation = station;
        }
        // Если значение вне диапазона — ничего не делаем (как принято в таких задачах)
    }

    public int getCurrentStation() {
        return currentStation;
    }

    // Увеличение громкости на 1 (не выше 100)
    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    // Уменьшение громкости на 1 (не ниже 0)
    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }
}

