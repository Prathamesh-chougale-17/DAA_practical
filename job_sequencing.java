import java.util.*;

class job_sequencing {
    char id;
    int profit, deadline;

    public job_sequencing() {
    }

    public job_sequencing(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    void print_sequence(ArrayList<job_sequencing> arr, int t) {
        int n = arr.size();
        Collections.sort(arr, (a, b) -> b.profit - a.profit);
        boolean result[] = new boolean[t];
        char job[] = new char[t];
        for (int i = 0; i < n; i++) {
            for (int j = Math.min(t - 1, arr.get(i).deadline - 1); j >= 0; j--) {
                if (result[j] == false) {
                    result[j] = true;
                    job[j] = arr.get(i).id;
                    break;
                }
            }

            for (char jb : job)
                System.out.print(jb + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<job_sequencing> arr = new ArrayList<job_sequencing>();
        arr.add(new job_sequencing('a', 2, 100));
        arr.add(new job_sequencing('b', 1, 19));
        arr.add(new job_sequencing('c', 2, 27));
        arr.add(new job_sequencing('d', 1, 25));
        arr.add(new job_sequencing('e', 3, 105));

        System.out.println("Followong is maximum Profit sequence of job");

        job_sequencing job = new job_sequencing();

        job.print_sequence(arr, 3);
    }
}
