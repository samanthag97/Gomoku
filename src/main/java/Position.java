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
        return content != Player.EMPTY;
    }

    public void print() {
        System.out.print(content.getCharacter());
    }


}
