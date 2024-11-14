class MorseTreeNode {
    char letter;
    MorseTreeNode dot;  // Left child
    MorseTreeNode dash; // Right child

    public MorseTreeNode(char letter) {
        this.letter = letter;
        this.dot = null;
        this.dash = null;
    }
}
