public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] counts = new int[n + 2]; // Ensure enough space for all possible counts

        for (int t = 0; t < trials; t++) {
            boolean[] birthdays = new boolean[n];
            int people = 0;
            while (true) {
                people++;
                int birthday = (int) (Math.random() * n);
                if (birthdays[birthday]) {
                    break;
                }
                birthdays[birthday] = true;
            }
            counts[people]++;
        }

        double cumulative = 0.0;
        int i = 1;
        while (cumulative < 0.5 && i < counts.length) { // Continue until 50% or end of counts
            cumulative += (double) counts[i] / trials;
            System.out.println(i + "\t" + counts[i] + "\t" + cumulative);
            i++;
        }
    }
}