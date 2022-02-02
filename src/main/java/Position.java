public class Position {
    private Player content;

    public Position() {
        content = Player.EMPTY;
    }

    public void changeContent(Player newContent) {
        content = newContent;
    }

    public Player getContent() {
        return content;
    }

    public boolean isTaken() {
        if (content != Player.EMPTY) {
            return true;
        }
        return false;
    }

    public void print() {
        System.out.print(content.getCharacter());
    }


}
