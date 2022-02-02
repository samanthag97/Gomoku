public enum Player {
    BLACK('B'), WHITE('W'), EMPTY('+');
    private final char character;

    Player(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}