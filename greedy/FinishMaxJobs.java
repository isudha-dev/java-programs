package greedy;

import java.util.Arrays;

public class FinishMaxJobs {

    public static void main(String[] args) {
        solve(new int[] { 1, 5, 7, 1 }, new int[] { 7, 8, 8, 8 });
    }

    public static int solve(int[] A, int[] B) {
        Jobs[] jobs = new Jobs[A.length];

        for (int i = 0; i < A.length; i++)
            jobs[i] = new Jobs(A[i], B[i]);

        // sort based on endtime
        Arrays.sort(jobs, (a, b) -> (a.endtime - b.endtime));

        int activitiesCount = 1;
        int previousEndtime = jobs[0].endtime;
        for (int i = 1; i < jobs.length; i++) {
            if (jobs[i].starttime >= previousEndtime) {
                previousEndtime = jobs[i].endtime;
                activitiesCount++;
            }

        }

        return activitiesCount;
    }

    static class Jobs {
        int starttime;
        int endtime;

        Jobs(int s, int e) {
            starttime = s;
            endtime = e;
        }
    }

}
