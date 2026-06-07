package entities;

import interfaces.Playable;

import java.util.Objects;
import java.util.Scanner;

public class AudioRec extends MediaObject implements Playable {

    private int duration;
    private int volume;

    public AudioRec(String title) {
        super(title);
        this.duration = 0;
        this.volume = 3;
    }

    @Override
    public void execute() {
        checkVolume();
        play();
    }

    public int getVolume() {
        return volume;
    }


    @Override
    public void play() {
        for (int i = 0; i < duration; i++) {
            System.out.println(title + " " + "!".repeat(volume));
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
    public void checkVolume() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Regola il volume con + o - (premi 0 per continuare)");
            String input = scanner.nextLine();
            if (Objects.equals(input, "+")) {
                increaseVolume();
                System.out.println("Volume: " + volume);
            } else if (Objects.equals(input, "-")) {
                decreaseVolume();
                System.out.println("Volume: " + volume);
            } else if (Objects.equals(input, "0")) {
                System.out.println("Continua.");
                break;
            } else {
                System.out.println("Input non valido.");
            }
        }
    }

    @Override
    public void setDuration(int duration) {
        if (duration < 0 || duration > 10) {
            System.out.println("\n" + "Inserisci un numero positivo minore di 10");
        } else {
            this.duration = duration;
        }
    }

    @Override
    public String toString() {
        return "AudioRec{" +
                "duration=" + duration +
                ", volume=" + volume +
                ", title='" + title + '\'' +
                '}';
    }
}
