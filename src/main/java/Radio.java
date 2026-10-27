public class Radio {
    private final int stationsCount;
    private int currentStation;
    private int volume;

    // Конструктор с заданным количеством станций
    public Radio(int stationsCount) {
        if (stationsCount <= 0) {
            throw new IllegalArgumentException("Количество станций должно быть больше 0");
        }
        this.stationsCount = stationsCount;
        this.currentStation = 0;
        this.volume = 0;
    }

    // Конструктор по умолчанию: 10 станций
    public Radio() {
        this(10);
    }

    public void next() {
        if (currentStation == stationsCount - 1) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    public void prev() {
        if (currentStation == 0) {
            currentStation = stationsCount - 1;
        } else {
            currentStation--;
        }
    }

    public void setCurrentStation(int station) {
        if (station >= 0 && station < stationsCount) {
            this.currentStation = station;
        }
        // Если вне диапазона — ничего не делаем (можно вместо этого кидать исключение)
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getStationsCount() {
        return stationsCount;
    }

    public void increaseVolume() {
        if (volume < 100) {
            volume++;
        }
    }

    public void decreaseVolume() {
        if (volume > 0) {
            volume--;
        }
    }

    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume;
        }
    }

    public int getVolume() {
        return volume;
    }
}

