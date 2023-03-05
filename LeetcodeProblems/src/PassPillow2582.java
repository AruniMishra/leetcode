public class PassPillow2582 {
    public static void main(String[] args) {

        int n = 4;
        int time = 5;

        System.out.println("~~~" + new PassPillow2582().passThePillow(n, time));

    }

    public int passThePillow(int n, int time) {

        int counterTime = 0;
        int index = 1;
        boolean increment = true;

        while (++counterTime <= time) {

            if (!increment) {
                --index;
                if (index == 1) {
                    increment = true;
                }
            }

            if (increment) {
                ++index;

                if (index == n) {
                    increment = false;
                }
            }

            System.out.println(index);

        }
        return index;
    }

}
