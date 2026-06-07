package entities;

import java.util.Objects;
import java.util.Scanner;

public abstract class VideoMedia extends MediaObject {
    private int brightness;

    public VideoMedia(String title) {
        super(title);
        this.brightness = 5;
    }

    public int getBrightness() {
        return brightness;
    }

    public void checkBrightness() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n" + "Regola la luminosità con + o - (premi 0 per continuare)");
            String input = scanner.nextLine();
            if (Objects.equals(input, "+")) {
                increaseBrightness();
                System.out.println("Brightness: " + getBrightness());
            } else if (Objects.equals(input, "-")) {
                decreaseBrightness();
                System.out.println("Brightness: " + getBrightness());
            } else if (Objects.equals(input, "0")) {
                break;
            } else {
                System.out.println("Input non valido.");
            }
        }
    }

    public void increaseBrightness() {
        if (brightness >= 5) {
            System.out.println("Luminosità già al massimo");
        } else {
            this.brightness++;
        }
    }

    public void decreaseBrightness() {
        if (brightness <= 0) {
            System.out.println("Luminosità già al minimo");
        } else {
            this.brightness--;
        }
    }
}
