package entities;

import interfaces.Playable;

public class Video extends VideoMedia implements Playable {
    private int duration;
    private int volume;

    public Video(String title) {
        super(title);
        this.duration = 0;
        this.volume = 3;
    }

    @Override
    public void execute() {
        checkBrightness();
        play();
    }

    @Override
    public void setDuration(int duration) {
        if (duration < 0 || duration > 10) {
            System.out.println("Inserisci un numero positivo minore di 10");
        } else {
            this.duration = duration;
        }
    }

    @Override
    public void play() {
        for (int i = 0; i < duration; i++) {
            System.out.println(title + " " + "!".repeat(volume) + " " + "*".repeat(getBrightness()));
        }
    }

    @Override
    public void increaseVolume() {
        if (volume >= 5) {
            System.out.println("Volume già al massimo");
        } else {
            this.volume++;
        }
    }

    @Override
    public void decreaseVolume() {
        if (volume <= 0) {
            System.out.println("Volume già al minimo");
        } else {
            this.volume--;
        }
    }

    @Override
    public String toString() {
        return "Video{" +
                "title='" + title + '\'' +
                ", volume=" + volume +
                ", duration=" + duration +
                '}';
    }
}



