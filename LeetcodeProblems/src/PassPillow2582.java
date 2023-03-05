public class PassPillow2582 {
    public static void main(String[] args) {

        int n = 18;
        int time = 38;

        System.out.println("~~~" + new PassPillow2582().passThePillow(n, time));

    }

    public int passThePillow(int n, int time) {

        int counterTime = 0;
        int index = 1;
        boolean increment = true;

        while (++counterTime <= time) {
            if (increment) {
                ++index;
                if (index == n) {
                    increment = false;
                }
            } else {
                --index;
                if (index == 1) {
                    increment = true;
                }
            }

        }
        return index;
    }
}
