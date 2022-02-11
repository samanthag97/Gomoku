public class Position {
    private Player content;

    public Position() {
        content = Player.EMPTY;
    }

    protected void changeContent(Player newContent) {
        content = newContent;
    }

    protected Player getContent() {
        return content;
    }

    protected boolean isTaken() {
        return content != Player.EMPTY;
    }

    protected void print() {
        System.out.print(content.getCharacter());
    }


}
