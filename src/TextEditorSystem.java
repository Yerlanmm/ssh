import java.util.HashMap;
import java.util.Map;

// 1. Character class with intrinsic and extrinsic state
class Character {
    private char value; // Intrinsic state
    private String font; // Intrinsic state
    private int size;    // Intrinsic state

    public Character(char value, String font, int size) {
        this.value = value;
        this.font = font;
        this.size = size;
    }

    public void render(int position) { // Extrinsic state (position)
        System.out.println("Rendering '" + value + "' at position " + position + " with font " + font + " and size " + size);
    }
}

// 2. CharacterFactory that manages character flyweights
class CharacterFactory {
    private Map<String, Character> characterMap = new HashMap<>();

    public Character getCharacter(char value, String font, int size) {
        String key = value + "_" + font + "_" + size;
        if (!characterMap.containsKey(key)) {
            characterMap.put(key, new Character(value, font, size));
            System.out.println("Creating new Character: " + key);
        }
        return characterMap.get(key);
    }
}

// 3. TextEditor class that uses the CharacterFactory
class TextEditor {
    private CharacterFactory characterFactory;
    private StringBuilder document;

    public TextEditor() {
        characterFactory = new CharacterFactory();
        document = new StringBuilder();
    }

    public void insertText(String text, String font, int size) {
        for (char c : text.toCharArray()) {
            Character character = characterFactory.getCharacter(c, font, size);
            document.append(c);
            character.render(document.length() - 1); // Render at the current position
        }
    }

    public void renderDocument() {
        System.out.println("\nRendering Document:");
        for (int i = 0; i < document.length(); i++) {
            char c = document.charAt(i);
            System.out.print(c);
        }
        System.out.println(); // Print newline after the document
    }
}

// 4. TextEditorApp class to demonstrate memory efficiency
public class TextEditorSystem {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();

        // Insert text with shared characters
        textEditor.insertText("Hello ", "Arial", 12);
        textEditor.insertText("World!", "Arial", 12);
        textEditor.insertText(" Flyweight Pattern.", "Arial", 12);

        // Render the entire document
        textEditor.renderDocument();

        // Insert more text with different font and size
        textEditor.insertText("New text with a different font!", "Times New Roman", 14);

        // Render the entire document again
        textEditor.renderDocument();
    }
}
