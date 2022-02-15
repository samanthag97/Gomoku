package sdm.project.gomoku;

enum Player {
    BLACK('B'), WHITE('W'), EMPTY('+');
    private final char character;

    Player(char character) {
        this.character = character;
    }

    char getCharacter() {
        return character;
    }
}