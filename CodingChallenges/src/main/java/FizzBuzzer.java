public class FizzBuzzer {
    public String FizzBuzz(int x) {

        for(int i = 0; i < x; i++) {
            if ((i % 5== 0) && (i % 3 == 0)) {
                return ", FizzBuzz";
            } else if (i % 3 == 0) {
                return ", Fizz";
            } else if (i % 5 == 0) {
                return ", Buzz";
            } else {
                return ", " + i;
            }
        }

    }
}
