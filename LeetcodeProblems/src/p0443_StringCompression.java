/**
 * Given an array of characters chars, compress it using the following algorithm:
 * <p>
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 * <p>
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 * <p>
 * After you are done modifying the input array, return the new length of the array.
 * <p>
 * You must write an algorithm that uses only constant extra space.
 *
 *
 * <p>
 * Example 1:
 * Input: chars = ["a","a","b","b","c","c","c"]
 * Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
 * </p>
 *
 * <p>
 * Example 2:
 * Input: chars = ["a"]
 * Output: Return 1, and the first character of the input array should be: ["a"]
 * Explanation: The only group is "a", which remains uncompressed since it's a single character.
 * </p>
 *
 * <p>
 * Example 3:
 * Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
 * </p>
 */
public class p0443_StringCompression {

    public static void main(String[] args) {

        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char[] chars2 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};

        new p0443_StringCompression().compress(chars);

        System.out.println("---------------");

        new p0443_StringCompression().compress2(chars2);

    }

    public int compress(char[] chars) {
        int index = 0;
        int counter = 0;
        int length = chars.length;
        StringBuilder sBuilder = new StringBuilder();
        for (char c : chars) {
            if (index < length - 1 && c == chars[++index]) {
                counter++;
                continue;
            } else {
                if (++counter == 1) {
                    sBuilder.append(c);
                } else {
                    sBuilder.append(c).append(counter);
                }
            }
            counter = 0;
        }
        String compressed = sBuilder.toString();
        //chars = compressed.toCharArray();
        for (int i = 0; i < compressed.length(); i++) {
            chars[i] = compressed.charAt(i);
        }

        System.out.println("compressed: " + compressed);
        System.out.println(compressed.length());
        System.out.println("chars: " + String.valueOf(chars));
        System.out.println(chars.length);

        return compressed.length();
    }

    public int compress2(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        StringBuilder result = new StringBuilder();
        char current = chars[0];
        int sum = 0;

        for (char aChar : chars) {
            if (aChar == current) {
                sum++;
            } else {
                if (sum == 1) {
                    result.append(current);
                } else {
                    result.append(current).append(sum);
                }
                sum = 1;
                current = aChar;
            }
        }

        if (sum == 1) {
            result.append(current);
        } else {
            result.append(current).append(sum);
        }
        String compressed = result.toString();
        for (int i = 0; i < compressed.length(); i++) {
            chars[i] = compressed.charAt(i);
        }
        System.out.println("compressed: " + compressed);
        System.out.println(compressed.length());
        System.out.println("chars: " + String.valueOf(chars));
        System.out.println(chars.length);

        return compressed.length();
    }
}
