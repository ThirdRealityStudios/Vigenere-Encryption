public class Main {
    public static void main(String[] args) {

        Main m = new Main();

        String input = "Hallo Welt, holla die Waldfee, gell?!";

        String key = "123j12nkjf sdaoök2l§";

        String encryptedText = m.cryptVigenere(input, key);

        System.out.println("Encrypted text: " + encryptedText);

        String decryptedText = m.decryptVigenere(encryptedText, key);

        System.out.println("Decrypted text: " + decryptedText);
    }

    public String crypt(String input, String key) {

        return cryptVigenere(input, key);
    }

    public String decrypt(String input, String key) {

        return decryptVigenere(input, key);
    }

    public char cryptCaesar(char input, char key) {
        int match = input + key;

        // Prevent overflow issues
        char mod = (char) Math.floorMod(match, Character.MAX_VALUE);

        return mod;
    }

    public char decryptCaesar(char input, char key) {
        int match = input - key;

        boolean overflow = key > input;

        return overflow ? (char) (Character.MAX_VALUE + match) : (char) match;
    }

    public String createVigenereKeyFrom(String input, String key)
    {
        return matchKeyToInputLength(input, key);
    }

    private String matchKeyToInputLength(String input, String key) {
        int keyTimes = input.length() / key.length();

        int keyPart = input.length() - (keyTimes * key.length());

        String missingPart = keyPart > 0 ? key.substring(0, keyPart) : "";

        return key.repeat(keyTimes) + missingPart;
    }

    public String cryptVigenere(String input, String key) {
        char[] ciphertext = new char[input.length()];

        String matchedKey = createVigenereKeyFrom(input, key);

        for(int i = 0; i < input.length(); i++)
        {
            ciphertext[i] = cryptCaesar(input.charAt(i), matchedKey.charAt(i));
        }

        return new String(ciphertext);
    }

    public String decryptVigenere(String input, String key) {
        char[] cleartext = new char[input.length()];

        String matchedKey = createVigenereKeyFrom(input, key);

        for(int i = 0; i < input.length(); i++)
        {
            cleartext[i] = decryptCaesar(input.charAt(i), matchedKey.charAt(i));
        }

        return new String(cleartext);
    }
}
