public class Main {
    public static void main(String[] args) {

        Main m = new Main();

        String input = "Holla die Waldfee, gell? AA";

        String key = "\u0000" + "\u0001"; // shift by 1 AND 0

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

    public String cryptVigenereRange(String input, int initialOffset, String key, int maxLength) {
        String ciphertext = "";

        // Attach the key as long as it fits and does not exceed the length of the input.
        for(int i = 0; i < key.length() && i < maxLength; i++)
        {
            ciphertext += cryptCaesar(input.charAt(initialOffset + i), key.charAt(i));
        }

        return ciphertext;
    }

    public String decryptVigenereRange(String input, int initialOffset, String key, int maxLength) {
        String ciphertext = "";

        // Attach the key as long as it fits and does not exceed the length of the input.
        for(int i = 0; i < key.length() && i < maxLength; i++)
        {
            ciphertext += decryptCaesar(input.charAt(initialOffset + i), key.charAt(i));
        }

        return ciphertext;
    }

    public String cryptVigenere(String input, String key) {
        int maxTimes = input.length() / key.length();

        String ciphertext = "";

        for(int i = 0; i < maxTimes; i++) {
            ciphertext += cryptVigenereRange(input, i * key.length(), key, key.length());
        }

        int remainingLength = input.length() - key.length() * maxTimes;

       ciphertext += cryptVigenereRange(ciphertext, input.length() - remainingLength - 1, key, remainingLength);

        return ciphertext;
    }

    public String decryptVigenere(String input, String key) {
        int maxTimes = input.length() / key.length();

        String ciphertext = "";

        for(int i = 0; i < maxTimes; i++) {
            ciphertext += decryptVigenereRange(input, i * key.length(), key, key.length());
        }

        int remainingLength = input.length() - key.length() * maxTimes;

        ciphertext += decryptVigenereRange(ciphertext, input.length() - remainingLength - 1, key, remainingLength);

        return ciphertext;
    }
}
