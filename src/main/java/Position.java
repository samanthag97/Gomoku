public class Position {

    private char content; ///////TODO Enum?
    private static final char EMPTY = '+';

    public Position() {
        content = EMPTY;
    }

    public void changeContent(char newContent) {
//////////TODO check
        content = newContent;
    }

    public char getContent() {
        return content;
    }

    public boolean isTaken() {
        if (content != EMPTY) {
            return true;
        }
        return false;
    }

    public void print(){
        System.out.print(content);
    }


}
