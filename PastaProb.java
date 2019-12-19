import java.util.ArrayList;
import java.util.HashSet;

public class PastaProb {
    public static void main(String[] args) {

        //This data structure is best for this project as it only stores unique elements,
        // thus no manual checking is required when obtaining new tickets.
        HashSet<Integer> set;
        //I use ArrayList here because it is potentially more space efficient than
        // creating an array. Otherwise, to accommodate the worst case of getting all 100 tickets
        // each trial, one would need an int array of size 'totalTrials'.
        ArrayList<Integer> trials = new ArrayList<>();
        //as per the problem, we have 900 days to collect tickets 1-100, with a 3/4 chance
        // that the individual will actually get pasta on that day. This is roughly the same
        // as a total number of days equal to 3/4 * 900.
        int days = (int) (900.0 * 0.75);
        int totalTrials = 10000;
        int r;

        //10,000 total trials in this case. the mean of the random variables in our 'trials' ArrayList
        // should converge to the expected value as sample size increases, as per the Law of Large Numbers.
        for (int j = 0; j < totalTrials; j++) {
            //each trial, add elements 1-100 to hashSet.
            set = new HashSet<>();
            for (int i = 0; i < days; i++) {
                r = (int) (Math.random() * 100) + 1;
                set.add(r);
                //once the hashSet is full (meaning we have tickets 1-100), add the
                // number of days to the 'trials' ArrayList.
                if (set.size() == 100) {
                    trials.add(i);
                    break;
                }
            }
        }
        //The remaining code is designed to average the number of days required to complete the task
        double sum = 0;
        for (int t : trials) { sum += t; }
        System.out.printf("Expected number of days over %d trials: %.2f\n", totalTrials, sum/trials.size());
        System.out.printf("Probability of getting all tickets before graduation: %.2f%%", (double)trials.size()/totalTrials * 100);
    }
}
