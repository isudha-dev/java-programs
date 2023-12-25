package dsa.practise.array;

import java.util.ArrayList;

public class ArraysPractise {

    public static void main(String[] args) {
//        rainWaterHarvesting(new int[] {2,1,0,2,1,0,1,3,2,1,2,1});
//        firstMissingPositiveGreaterThan0(new int[] {1});
//        maxArr(new int[] {-98,-5,37,-97,38,22,70,42,61,84});
//        maxSumSubarray(new int[] {-120,-202,-293,-60,-261,-67,10,82,-334,-393,-428,-182,-138,-167,-465,-347,-39,-51,-61,-491,-216,-36,-281,-361,-271,-368,-122,-114,-53,-488,-327,-182,-221,-381,-431,-161,-59,-494,-406,-298,-268,-425,-88,-320,-371,-5,36,89,-194,-140,-278,-65,-38,-144,-407,-235,-426,-219,62,-299,1,-454,-247,-146,24,2,-59,-389,-77,-19,-311,18,-442,-186,-334,41,-84,21,-100,65,-491,94,-346,-412,-371,89,-56,-365,-249,-454,-226,-473,91,-412,-30,-248,-36,-95,-395,-74,-432,47,-259,-474,-409,-429,-215,-102,-63,80,65,63,-452,-462,-449,87,-319,-156,-82,30,-102,68,-472,-463,-212,-267,-302,-471,-245,-165,43,-288,-379,-243,35,-288,62,23,-444,-91,-24,-110,-28,-305,-81,-169,-348,-184,79,-262,13,-459,-345,70,-24,-343,-308,-123,-310,-239,83,-127,-482,-179,-11,-60,35,-107,-389,-427,-210,-238,-184,90,-211,-250,-147,-272,43,-99,87,-267,-270,-432,-272,-26,-327,-409,-353,-475,-210,-14,-145,-164,-300,-327,-138,-408,-421,-26,-375,-263,7,-201,-22,-402,-241,67,-334,-452,-367,-284,-95,-122,-444,-456,-152,25,21,61,-320,-87,98,16,-124,-299,-415,-273,-200,-146,-437,-457,75,84,-233,-54,-292,-319,-99,-28,-97,-435,-479,-255,-234,-447,-157,82,-450,86,-478,-58,9,-500,-87,29,-286,-378,-466,88,-366,-425,-38,-134,-184,32,-13,-263,-371,-246,33,-41,-192,-14,-311,-478,-374,-186,-353,-334,-265,-169,-418,63,77,77,-197,-211,-276,-190,-68,-184,-185,-235,-31,-465,-297,-277,-456,-181,-219,-329,40,-341,-476,28,-313,-78,-165,-310,-496,-450,-318,-483,-22,-84,83,-185,-140,-62,-114,-141,-189,-395,-63,-359,26,-318,86,-449,-419,-2,81,-326,-339,-56,-123,10,-463,41,-458,-409,-314,-125,-495,-256,-388,75,40,-37,-449,-485,-487,-376,-262,57,-321,-364,-246,-330,-36,-473,-482,-94,-63,-414,-159,-200,-13,-405,-268,-455,-293,-298,-416,-222,-207,-473,-377,-167,56,-488,-447,-206,-215,-176,76,-304,-163,-28,-210,-18,-484,45,10,79,-441,-197,-16,-145,-422,-124,79,-464,-60,-214,-457,-400,-36,47,8,-151,-489,-327,85,-297,-395,-258,-31,-56,-500,-61,-18,-474,-426,-162,-79,25,-361,-88,-241,-225,-367,-440,-200,38,-248,-429,-284,-23,19,-220,-105,-81,-269,-488,-204,-28,-138,39,-389,40,-263,-297,-400,-158,-310,-270,-107,-336,-164,36,11,-192,-359,-136,-230,-410,-66,67,-396,-146,-158,-264,-13,-15,-425,58,-25,-241,85,-82,-49,-150,-37,-493,-284,-107,93,-183,-60,-261,-310,-380});
        Interval i1 = new Interval(1,3);
        Interval i2 = new Interval(6, 8);
        Interval i3 = new Interval(8, 12);
        Interval mergeInt = new Interval(2, 9);

        ArrayList<Interval> input = new ArrayList<>();
        input.add(i1);
        input.add(i2);
        input.add(i3);

        ArrayList<Interval> output = insert(input, mergeInt);
        System.out.println(output);
    }

    public static int rainWaterHarvesting(int[] A){
        int n = A.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = -1;
        leftMax[1] = A[0];
        rightMax[n-1] = -1;
        rightMax[n-2] = A[n-1];

        for(int i = 2; i<n; i++){
            leftMax[i] = Math.max(leftMax[i-1],A[i-1]);
        }

        for(int i = n-3; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], A[i+1]);
        }

        int ans = 0;
        for(int i = 1; i<n-1; i++){
            int waterTrapped = Math.min(leftMax[i], rightMax[i])-A[i];
            if(waterTrapped>0)
                ans += waterTrapped;
        }

        return ans;



    }

    public static int firstMissingPositiveGreaterThan0(int[] A){
        int n = A.length;
        for(int i = 0; i<n; i++){
            while(A[i] != i+1 && A[i] >= 1 && A[i] <= n && A[i] != A[A[i]-1]){
                int swapPostion1 = i;
                int swapPostion2 = A[i]-1;
                int temp = A[swapPostion1];
                A[swapPostion1] = A[swapPostion2];
                A[swapPostion2] = temp;
            }
        }

        for(int i = 0; i<n; i++){
            if(A[i]!= i+1){
                System.out.println(i+1);
                return i+1;
            }
        }
        return n+1;
    }

    public static int maxArr(int[] A) {

        int PMax = Integer.MIN_VALUE, PMin=Integer.MAX_VALUE, QMax=Integer.MIN_VALUE, QMin=Integer.MAX_VALUE;

        for(int i = 0; i<A.length; i++){
            PMax = Math.max(PMax, A[i]-i);
            PMin = Math.min(PMin, A[i]-i);
            QMax = Math.max(QMax, A[i]+i);
            QMin = Math.min(QMin, A[i]+i);
        }

        return Math.max(PMax-PMin, QMax-QMin);

    }

    public static int maxSumSubarray(int[] A){
        int n = A.length;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i = 0;  i<A.length; i++){
            int newSum = currSum+A[i];
            maxSum = Math.max(newSum, maxSum);
            if(newSum < 0){
                currSum = 0;
            }
        }

        return maxSum;
    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> ans = new ArrayList<>();
        boolean mergeHappened = false;

        for(Interval i: intervals){
            if(i.end > newInterval.start && i.start < newInterval.start){
                // interval comes in-between
                mergeHappened = true;
                ans.add(new Interval(i.start, newInterval.end));
            } else {
                ans.add(i);
            }
        }
        if(!mergeHappened){
            ans.add(newInterval);
        }

        ArrayList<Interval> finalList = new ArrayList<>();

        // find if any interval overlapping
        for(int i = 0; i< ans.size()-1; i++){
            Interval intvl1 = ans.get(i);
            int k = i+1;
            Interval intvl2 = ans.get(k);
            if(intvl1.end >= intvl2.start){
                int intervalsToBeRemoved = 0;
                while(intvl1.end >= intvl2.start && k<ans.size()){
                    intervalsToBeRemoved++;
                    intvl2 = ans.get(k);
                    k++;
                }
                while (intervalsToBeRemoved-->0){
                    ans.remove(i+1);
                }
                ans.set(i, new Interval(intvl1.start, intvl2.end));
                break;
            }
        }

        return ans;

    }

     static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

}
