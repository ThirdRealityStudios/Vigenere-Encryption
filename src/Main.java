public class Main {
    public static void main(String[] args) {

        Main m = new Main();

        String input = "ABCDEFGHIJKLMNOQRSTUVWXYZ";

        String key = "\u0000\u0001"; // shift by 1 AND 0

        System.out.println(m.cryptVigenere(input, key));
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

    private String matchKeyToInputLength(String input, String key) {
        int keyTimes = input.length() / key.length();

        int keyPart = input.length() - (keyTimes * key.length());

        String missingPart = keyPart > 0 ? key.substring(0, keyPart) : "";

        return key.repeat(keyTimes) + missingPart;
    }

    public String cryptVigenere(String input, String key) {
        char[] ciphertext = new char[input.length()];

        String matchedKey = matchKeyToInputLength(input, key);

        for(int i = 0; i < input.length(); i++)
        {
            ciphertext[i] = cryptCaesar(input.charAt(i), matchedKey.charAt(i));
        }

        return new String(ciphertext);
    }

    public String decryptVigenere(String input, String key) {
        String cleartext = "";

        String fullsizeKey = "";

        return cleartext;
    }
}
