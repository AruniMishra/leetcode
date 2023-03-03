import java.util.Arrays;

public class StringCompression0443 {

    public static void main(String[] args) {

        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char[] chars2 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};

        new StringCompression0443().compress(chars);

        System.out.println("---------------");

        new StringCompression0443().compress2(chars2);

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
