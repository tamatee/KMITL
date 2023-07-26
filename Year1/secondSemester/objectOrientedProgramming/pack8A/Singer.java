package objectOrientedProgramming.pack8A;

public class Singer {
    private String name;
    private String style;
    public Singer() {

    }
    public Singer(String name) {
        this.name = name;
    }

    public Singer(String name, String style) {
        this.name = name;
        this.style = style;
    }

    public String getName() {
        return name;
    }

    public String getStyle() {
        return style;
    }
    @Override
    public String toString() {
        return String.format("Singer (%s-SingerStyle.%s)",name ,style );
    }
}
