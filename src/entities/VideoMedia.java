package entities;

public abstract class VideoMedia extends MediaObject {
    private int brightness;

    public VideoMedia(String title) {
        super(title);
        this.brightness = 5;
    }

    public int getBrightness() {
        return brightness;
    }

    public void increaseBrightness(int amount) {
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
