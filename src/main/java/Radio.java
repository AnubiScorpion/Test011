import lombok.Data;

@Data
public class Radio {
    private int currentStation;
    private int volume;
    private final int stationsCount;

    public Radio() {
        this.stationsCount = 10;
        this.currentStation = 0;
        this.volume = 0;
    }

    public Radio(int stationsCount) {
        if (stationsCount <= 0) {
            throw new IllegalArgumentException("Stations count must be positive");
        }
        this.stationsCount = stationsCount;
        this.currentStation = 0;
        this.volume = 0;
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
}

