package entities;

public abstract class MediaObject {
    protected String title;

    public MediaObject(String title) {
        this.title = title;
    }

    public abstract void execute();

}
