import java.util.Scanner;

class MorseTreeNode {
    char letter;
    MorseTreeNode dot;  // Left child
    MorseTreeNode dash; // Right child

    public MorseTreeNode(char letter) {
        this.letter = letter;
        this.dot = null;
        this.dash = null;
    }

        public static void main(String[] args) {
            MorseCodeTree morseCodeTree = new MorseCodeTree();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Introduce los códigos Morse separados por espacios (por ejemplo: . - .. .- -.-. .):");
            String input = scanner.nextLine();

            String[] morseCodes = input.split(" ");

            for (String code : morseCodes) {
                String letter = morseCodeTree.getLetter(code);
                System.out.println("Morse Code: " + code + " -> Letter: " + letter);
            }

            scanner.close();
        }

}

 class MorseCodeTree {
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
