# Vigenere encryption and decryption implementation

This is a simple implementation of the Vigenere encryption and decryption algorithm.
I just created this due to a short school task we've gotten..

**Note!**
This is the "kind" or "version" of Vigenere which simply makes the
key as long as the cleartext, meaning it copies the key until it has
the same length of the cleartext.
Unlike the other version, by just attaching all unused signs of the alphabet to the key,
this implementation does NOT ! I did not do that in order to keep it simple
as the charset of ASCII has at least 128 different signs, or UTF-16 even 2^16 (meaning 65536) signs.