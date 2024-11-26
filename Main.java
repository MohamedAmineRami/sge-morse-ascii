import java.util.HashMap;
import java.util.Scanner;

// Traducir ascii a morse
public class Main {

    public void main(String[] args) {
        MorseCodeTree morseCodeTree = new MorseCodeTree();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce los códigos Morse separados por espacios (por ejemplo: . - .. .- -.-. .):");
        String input = scanner.nextLine();

        String[] morseCodes = input.split(" ");

        for (String code : morseCodes) {
            String letter = morseCodeTree.getLetter(code);
            System.out.println("Morse Code: " + code + " -> Letter: " + letter);
        }

        HashMap<Character, String> asciiMorse = new HashMap<>();
        asciiMorse.put('a', "._");
        asciiMorse.put('b', "_...");
        asciiMorse.put('c', "_._.");
        asciiMorse.put('d', "_..");
        asciiMorse.put('e', ".");
        asciiMorse.put('f', ".._.");
        asciiMorse.put('g', "__.");
        asciiMorse.put('h', "....");
        asciiMorse.put('i', "..");
        asciiMorse.put('j', ".___");
        asciiMorse.put('k', "_._");
        asciiMorse.put('l', "._..");
        asciiMorse.put('m', "__");
        asciiMorse.put('n', "_.");
        asciiMorse.put('ñ', "__.__");
        asciiMorse.put('o', "___");
        asciiMorse.put('p', ".__.");
        asciiMorse.put('q', "__._");
        asciiMorse.put('r', "._.");
        asciiMorse.put('s', "...");
        asciiMorse.put('t', "_");
        asciiMorse.put('u', ".._");
        asciiMorse.put('v', "..._");
        asciiMorse.put('w', ".__");
        asciiMorse.put('x', "_.._");
        asciiMorse.put('y', "");
        asciiMorse.put('z', "__..");

        System.out.println("Escribe una frase, la traducire a morse");

        String frase = scanner.nextLine();

        for (int i = 0; i < frase.length(); i++){
            if (frase.charAt(i) != ' ' ){
                System.out.print(asciiMorse.get(frase.charAt(i)) + " ");
            }else{
                System.out.print(" ");
            }
        }
    }


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


}
