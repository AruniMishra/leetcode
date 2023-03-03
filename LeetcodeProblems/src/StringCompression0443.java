public class StringCompression0443 {

    public static void main(String[] args) {

        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};

        System.out.println(new StringCompression0443().compress(chars));

    }

    public int compress(char[] chars) {
        int index = 0;
        int counter = 0;
        int length = chars.length;
        boolean counterReset = true;
        char[] result = new char[30];
        int resultIndex = 0;
        for (char c : chars) {
            if (index < length - 1 && c == chars[index + 1]) {
                if (counterReset) {
                    counter = 0;
                }
                counter++;
                index++;
                counterReset = false;
                continue;
            } else {
                if (++counter == 1) {
                    result[resultIndex++] = c;
                } else {
                    result[resultIndex++] = c;
                    result[resultIndex++] = (char) (counter + '0');
                }
                System.out.println(counter);

                counterReset = true;
            }

            index++;

        }

        System.out.println(result);

        return result.length;
    }
}
