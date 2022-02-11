public enum Player {
    BLACK('B'), WHITE('W'), EMPTY('+');
    private final char character;

    Player(char character) {
        this.character = character;
    }

    protected char getCharacter() {
        return character;
    }
}