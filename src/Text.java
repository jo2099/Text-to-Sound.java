
public class Text {
    private final Character[] content;
    private int size;

    public Text(Character[] content) {    
        this.content = content;
        this.size = content.length;
    }

    public Character[] getContent() {
        return this.content.clone();
    }

    public int getSize() {
        return this.size;
    }
}
