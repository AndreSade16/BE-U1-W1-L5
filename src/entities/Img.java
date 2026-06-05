package entities;

public class Img extends VideoMedia {

    public Img(String title) {
        super(title);
    }

    @Override
    public void execute() {
        show();
    }

    public void show() {
        System.out.println(title + " " + "*".repeat(getBrightness()));
    }

    @Override
    public String toString() {
        return "Img{" +
                "title='" + title + '\'' +
                "brightness='" + getBrightness() + '\'' +
                '}';
    }
}
