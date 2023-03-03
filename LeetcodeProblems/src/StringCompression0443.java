public class StringCompression0443 {

    public static void main(String[] args) {

        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};

        new StringCompression0443().compress(chars);

    }

    public int compress(char[] chars) {
        int index = 0;
        int counter = 0;
        int length = chars.length;
        boolean counterReset = true;
        StringBuilder sBuilder = new StringBuilder();
        for (char c : chars) {
            if (index < length - 1 && c == chars[index + 1]) {
                counter++;
                index++;
                continue;
            } else {
                if (++counter == 1) {
                    sBuilder.append(c);
                } else {
                    sBuilder.append(c).append(counter);
                }
                counterReset = true;
            }
            if (counterReset) {
                counter = 0;
            }
            index++;
        }
        String s = sBuilder.toString();


        System.out.println(s);


        chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }

        System.out.println(chars);
        System.out.println(chars.length);

        return chars.length;
    }
}
