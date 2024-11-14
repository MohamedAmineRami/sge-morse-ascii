public class MorseCodeTree {
    private final MorseTreeNode root;

    public MorseCodeTree() {
        root = new MorseTreeNode(' ');
        root.dot = new MorseTreeNode('E');
        root.dash = new MorseTreeNode('T');
        root.dot.dot = new MorseTreeNode('I');
        root.dot.dash = new MorseTreeNode('A');
        root.dash.dot = new MorseTreeNode('N');
        root.dash.dash = new MorseTreeNode('M');
    }

    public String getLetter(String morseCode) {
        MorseTreeNode current = root;
        for (char ch : morseCode.toCharArray()) {
            if (ch == '.') {
                current = current.dot;
            } else if (ch == '-') {
                current = current.dash;
            }
            if (current == null) {
                return "Invalid Morse Code";
            }
        }
        return String.valueOf(current.letter);
    }
}
