package ProblemSolving;

import java.util.*;

public class Problems10_110124 {

    public static void main(String[] args) {
//        System.out.println(findOccurences(new ArrayList<>(Arrays.asList(56, 35, 25, 32, 41, 50, 7, 52, 34, 41, 72, 12, 93, 50, 19, 94, 13, 19))));
//        kthsmallest(new int[] {1, 2,5,4,3,2}, 3);
//        consecutiveElementsWithBubbleSort(new int[] {285,223,327,320,107,127,266,277,324,282,322,260,257,87,288,321,269,86,69,206,66,
//                165,160,67,316,216,161,118,330,337,274,145,256,318,250,187,273,68,105,193,314,137,77,336,287,120,334,
//                278,281,279,289,299,291,307,190,212,286,113,227,226,301,300,174,270,123,317,275,338,202,205,70,101,344,
//                271,102,312,157,224,201,106,88,292,305,343,246,328,138,148,315,254,108,229,346,350,255,304,247,302,208,
//                85,158,63,225,147,172,64,78,89,258,109,323,237,80,191,110,283,83,221,296,111,72,71,155,140,95,252,126,
//                90,91,114,228,163,303,197,162,248,75,339,116,92,209,198,139,112,276,143,306,319,180,173,325,184,335,326,
//                156,240,293,115,261,340,290,351,58,117,341,241,329,311,119,232,121,192,135,308,213,182,313,253,146,103,
//                214,124,331,332,230,349,194,333,259,211,284,294,342,166,309,195,73,264,164,233,98,345,74,136,239,122,
//                231,167,175,183,93,125,84,263,200,347,132,295,128,129,177,130,280,94,234,168,297,141,104,142,207,262,
//                131,298,144,76,154,310,57,348,59,60,265,152,61,153,62,236,65,242,235,79,176,149,133,81,82,96,169,97,210,
//                170,99,268,151,100,251,134,150,267,159,171,272,178,196,179,203,181,185,186,188,189,199,243,204,215,217,
//                218,238,219,220,222,244,245,249});
//        System.out.println(chocolateDist(new ArrayList<>(Arrays.asList(4647632,2905779,6606570,7578874,1074817,7663052,1634778,7231069,982073,7230174,5803012,2648232,1391755,2042043,9350088,8449833,8654167,6489783,2151832,5108534,8241468,201110,7515149,2103735,687072,5003124,778137,7029191,979260,628472,4885206,8143243,6050602,1491775,5722116,7125418,9154827,7356893,6872839,2653251,7103418,5192202,7817834,1011524,7234244,9684274,1977709,8404763,8690408,6645892,6029648,9448227,6847001,6061149,1551961,50424,3580624,4846449,9595967,4559883,5474920,4481172,2703125,4041874,8489299,941592,1167291,7644125,814836,556481,2813727,434605,5748682,631560,3962481,5499278,2832185,5940189,3904040,1522592,2586080,2450039,970819,1949432,8511187,5039131,1999856,2091810,9885580,4112174,9168044,7876851,8593345,4387520,1918724,7082643,7845463,5602367,7243119,1176650,6158847,56845,1611255,1907529,3204757,5573735,9923158,6036941,4030275,3827197,75885,9132706,8793587,3563055,1082137,7304774,1118537,5598344,1912935,1004116,9710517,1080979,1397319,820214,7984850,5832394,7902856,5830313,1434760,5145975,7006962,109959,7719171,1134568,4533839,923927,9224654,4456996,9477220,3254928,800544,2069456,2387633,9594130,8148862,5986122,9415255,9267398,4100817,1328190,2787866,3811334,4925520,4185184,7147899,5426721,17577,5050754,1257033,3968689,2713080,780347,6594999,2948603,1914914,1128837,6388881,1139568,8102184,8382452,6910847,1419079,451907,9298480,1013208,1117120,7800953,2944815,384518,1901769,6789356,3172383,8229454,1714875,9873918,5377352,9657947,9891494,2944458,914980,6376534,8173889,4211678,2971532,1122491,6126591,6616720,7511372,7266158,7235255,5893823,6693357,8654333,8862082,8508188,2183893,9979201,6309140,5128707,2880070,727260,1918062,6052452,8956714,6149288,8442721,6850417,5807234,850567,2311226,9238565,7227100,485115,3450242,2714984,4123957,9576833,1848055,1635328,9359342,9083310,45503,6052698,7737642,1423936,4560885,2437886,3919488,3386376,7566592,6799558,4113636,9484653,5368361,5586701,5633940,3811082,2437117,3957526,4661648,7264695,3196090,1888747,7749809,6646332,7120082,1873765,8739516,8968137,6025445,615209,567798,8587299,9184259,821791,2527586,3745143,3259677,6447073,9647871,826268,3246630,3761506,2827273,8614991,1864558,977564,2426072,6818026,4935089,9604071,4082720,647531,1492817,1832528,9810214,1129251,6222645,8549729,2613739,4764441,1681289,3181536,5868091,865547,4003326,8395676,7127042,9779354,4842748,6774912,605622,605730,3052769,5949246,9220720,4917326,6926809,4163143,1735351,1861898,3767213,5818071,5025780,7776381,166950,4835993,8905631,8905946,5902073,1519369,6186738,7583361,7217256,2054828,8448908,3736934,2966855,8092301,3516287,325955,4867212,6638260,931684,436332,2587505,152403,7870009,2030666,4315545,9605359,6408915,599109,7939781,1434694,8375489,623083,6270686,9797472,2045380,4689110,3833192,8232118,2272470,1050448,2803297,3237729,4787381,5770152,1330029,820019,8612458,6197240,9974631,9544141,9149923,5078487,9696543,7019931,7109152,6528439,9141642,3518066,9643899,9597774,7469111,8019387,220856,3739796,7816858,4782588,945257,1650050,3014705,3217727,5216849,8334353,6455455,2520581,6620856,7785484,3340599,5233313,6499075,3315229,4777453,8165350,910068,6990347,5185280,8019219,6035137,4326921,4053637,5679035,6441047,1522747,6214774,6661902,7778895,4031631,3960841,8724151,8198032,6975545,1941877,3414880,5309898,913684,8451812,1930753,1215519,1792411,9680418,230945,7623991,4457870,8396294,8534058,3964569,6097926,9069629,9999705,2941198,3123265,8195092,9382244,4646011,4409865,8560498,2424905,957847,2521338,1149056,9155879,2013235,5607284,5087110,7323132,9037319,3538922,1770236,252837,7847684,3967005,3000134,5471674,8424875,1396427,6522084,4905795,7494352,5591712,4905499,2951902,8714976,3100590,2334145,5877338,7510454,3410994,8302243,8468301,5932332,1967650,140531,7945566,91285,7743992,7785049,9128604,1282913,2071636,9381440,1646948,6038641,2381573,9634974,6979867,6294352,6157057,1885661,6305055,4265120,9307511,9256956,2980095,2408101,4107453,1373784,2434906,7518446,9676026,3419558,3450777,4160027,3560088,3912694,4251312,3820432,1697742,3379915,5103344,6285730,5277706,6750292,2324370,7659279,6385265,1820588,6469982,5058673,6222600,2775036,9323792,5530110,4548344,4820238,454562,8655796,6194021,2889468,6174241,8386399,8825377,2141370,2546425,4901817,6054063,6797736,8722248,268157,2694002,6341943,6553886,7971708,5608586,1394607,8147338,4510202,3215194,4617319,9568874,9437793,9908706,1409017,7484254,4457049,8745606,7938816,5629196,7455979,3344635,4319789,5842377,4686363,6461158,905153,9588179,2515220,219241,826778,2783376,2913242,7168721,1853613,3401301,2777306,3248219,1548638,9803860,8979764,8682308,9372733,933908,1107366,3298102,8418162,8080766,2043707,8873329,3709962,2016037,2217963,8029750,7858413,6904325,7007259,1279918,9008856,2038830,1499158,9835633,4822206,6928751,9520705,9192170,330052,2298011,2440389,4395041,2101870,1420152,5593701,3990954,2354060,6701066,9805407,3288573,7298183,4365466,2161901,1008144,6381502,6896215,1554245,6756267,3800539,8561503,8036184,5325746,600333,2051693,7677731,7938890,8980443,7198435,9647411,9310494,2012797,2087799,6221887,4114666,6024303,1815587,621972,894714,1033004,2943730,4183286,847538,7309195,6345186,4372034,6207049,3241400,5926278,2963315,9558290,7004133,3515850,4884036,120817,5567542)), 218));

//        int[] A = new int[] {3, 4, 1, 2};
//        System.out.println(inversionCount(A, 0, A.length-1));
//        System.out.println(largestNumber(new ArrayList<>(Arrays.asList(2,3,9,0))));

//        System.out.println(uniqueElem(new int[] {2,4,4,5,5,6,6,9}));
//        nobleInteger(new ArrayList<>(Arrays.asList(2,3,4,4,5,6,6,9)));

//        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
//        a.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
//        a.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
//        a.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
//        setZeroes(a);

//        perfectPeak(new int[] {5, 1, 4, 3, 6, 8, 10, 7, 9});
//        System.out.println(repeatedNumber(new int[] {3, 4, 1, 4, 1}));

        Arrays.stream(sortWithSquares(new int[]{-5, -4, -2, 0, 1})).forEach(System.out::println);


    }

    public static int[] sortWithSquares(int[] A) {
        int n = A.length;
        int p1 = 0; int p2 = n-1;

        int idx = n-1;
        int[] ans = new int[n];

        while (p1<=p2 && p1<n && p2 >= 0){
            int v1 = A[p1]*A[p1];
            int v2 = A[p2]*A[p2];
            if(v1 > v2){
                ans[idx] = A[p1]*A[p1];
                p1++;
            } else {
                ans[idx] = A[p2]*A[p2];
                p2--;
            }
            idx--;
        }

        return ans;
    }
    public static int repeatedNumber(final int[] A) {
        int n = A.length;
        int[] B = new int[n];

        for(int i: A){
            if(i>0 && i<=n)
                B[i-1]++;
        }

        for(int i=0; i<n; i++){
            if(B[i] > 1){
                return i+1;
            }
        }
        return -1;
    }

    public static int firstMissingPositive(int[] A) {
        int n = A.length;
        int[] B = new int[n];

        for(int i: A){
            if(i>0 && i<=n)
                B[i-1]++;
        }

        for(int i=0; i<n; i++){
            if(B[i] == 0){
                return i+1;
            }
        }
        return n+1;

    }

    public static int perfectPeak(int[] A) {
        int n = A.length;
        int[] leftMax = new int[n]; // this should be smaller than A[i]
        int[] rightMin = new int[n]; // this should be greater than A[i]

        int currMax = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            leftMax[i] = Math.max(currMax, A[i]);
            currMax = leftMax[i];
        }

        int currMin = Integer.MAX_VALUE;
        for(int i=n-1; i>=0; i--){
            rightMin[i] = Math.min(currMin, A[i]);
            currMin = rightMin[i];
        }

        for(int i = 1; i<n-1; i++){
            if(leftMax[i-1] < A[i] && A[i] < rightMin[i+1]){
                return 1;
            }
        }

        return 0;
    }
    public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
        // row ith | col 0 to n-1
        // col jth | row o to m-1
        int m = a.size();
        int n = a.get(0).size();

        ArrayList<Integer> b = new ArrayList<>();
        for(int i = 0; i<m; i++){
            boolean isZero = false;
            for(int j = 0; j<n; j++){
                if (a.get(i).get(j) == 0){
                    isZero = true;
                }
            }
            if (isZero)
                b.add(0);
            else
                b.add(-1);
        }

        ArrayList<Integer> c1 = new ArrayList<>();
        for(int i = 0; i<n; i++){
            boolean isZero = false;
            for(int j = 0; j<m; j++){
                if (a.get(j).get(i) == 0){
                    isZero = true;
                }
            }
            if (isZero)
                c1.add(0);
            else
                c1.add(-1);
        }

        // for rows
        for(int r = 0; r<b.size(); r++){
            if(b.get(r) == 0){
                for(int c = 0; c < n; c++){
                    a.get(r).set(c, 0);
                }
            }
        }

        // for cols
        for(int c = 0; c<c1.size(); c++){
            if(c1.get(c) == 0){
                for(int r = 0; r < m; r++){
                    a.get(r).set(c, 0);
                }
            }
        }


        System.out.println();
    }

    public static int nobleInteger(ArrayList<Integer> A) {
        int n = A.size();
        Collections.sort(A);

        if(A.get(0) == n-1 || A.get(n-1) == 0){
            return 1;
        }

        for(int i = 1; i<n-1; i++){
            if(A.get(i) == A.get(i+1)){
                continue;
            } else if(A.get(i) == n-1-i){
                return 1;
            }
        }

        return -1;
    }

    public static ArrayList<Integer> findOccurences(ArrayList<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i: A){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        List<Integer> sortedList = map.keySet().stream().sorted().toList();

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i: sortedList){
            ans.add(map.get(i));
        }

        return ans;

    }

    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        int steps = 0;
        for(int i = 0; i<n-1; i++){
            int x1 = A.get(i);
            int y1 = B.get(i);

            int x2 = A.get(i+1);
            int y2 = B.get(i+1);

            int diffX = Math.abs(x1-x2);
            int diffY = Math.abs(y1-y2);
            steps += Math.min(diffX, diffY);
            steps += Math.abs(diffX-diffY);
        }

        return steps;

    }

    public static int kthsmallest(final int[] A, int B) {
        // selection sort
        for(int i = 0; i<B; i++){
            int currMin = A[i];
            int swapIdx = i;
            for(int j = i+1; j<A.length; j++){
                if(A[j] < currMin){
                    currMin = Math.min(currMin, A[j]);
                    swapIdx = j;
                }
            }
            if(i!=swapIdx){
                int temp = A[i];
                A[i] = A[swapIdx];
                A[swapIdx] = temp;
            }
        }

        return A[B-1];
    }

    public static int consecutiveElementsWithSelectionSort(int[] A) {
        // Note: Selection sort TC is N^2 in all case, so hence not best with |A| = 10^5
        int n = A.length;
        for(int i = 0; i< n; i++){
            if(i == 139){
                System.out.println("break");
            }
            int min = A[i], idx = i;
            for(int j = i; j<n; j++){
                if(A[j] < min){
                    min = A[j];
                    idx = j;
                }
            }
            if( i != idx){
                // make swap
                int temp = A[i];
                A[i] = A[idx];
                A[idx] = temp;
            }
            if(i > 0 && A[i]-A[i-1] > 1){
                return 0;
            }
        }
        return 1;
    }

    public static int consecutiveElementsWithInsertionSort(int[] A) {
        // Note: Using insertion sort.
        // Even insertion sort is running into worst case of checking for all N^2 iterations. I can stop iterations
        // as soon as I find previous element is not 1 less than current. Thereby reducing overall iterations.
        // Let's try bubble sort.
        int n = A.length;

        for(int i = 1; i<n; i++){
            int temp = A[i];
            int j = i-1;
            while (j>=0 && A[j] > temp){
                A[j+1] = A[j];
                j--;
            }
            A[j+1] = temp;

        }

        for (int i = 1; i<n; i++){
            if(A[i] - A[i-1] != 1){
                return 0;
            }
        }

        return 1;
    }

    public static int consecutiveElementsWithBubbleSort(int[] A) {
        // Let's try bubble sort. This did not work either, running into worst case TC of N^2.
        // using library sort now.
        int n = A.length;

        for(int i = 0; i<n; i++){
            int flag = 0;
            for(int j = n-1;j>=i+1; j--){
                if(A[j]<A[j-1]){
                    int temp = A[j];
                    A[j] = A[j-1];
                    A[j-1] = temp;
                    flag=1;
                }
            }
            if(i > 0 && A[i] - A[i-1] != 1){
                return 0;
            }

            if(flag==0)
                break;
        }

        return 1;
    }

    public static int chocolateDist(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int n = A.size();
        int minDiff = Integer.MAX_VALUE;
        for(int i = n-1; i>=B-1; i--){
            int currDiff = A.get(i)-A.get(i+1-B);
            if(currDiff < minDiff){
                minDiff = currDiff;
            }
        }
        return minDiff;
    }

    public static int inversionCount(int[] A, int low, int high){
        if(low>=high){
            return 0;
        }
        int mid = (low + high)/2;
        int l = inversionCount(A, low, mid);
        int r = inversionCount(A, mid+1, high);

        int[] lSorted = Arrays.stream(Arrays.copyOfRange(A,low,mid+1)).sorted().toArray();
        int[] rSorted = Arrays.stream(Arrays.copyOfRange(A,mid+1,high+1)).sorted().toArray();

        int p1 = 0, p2 = 0;
        long totalCount = 0;
        int mod = 1000000007;
        while (p1<lSorted.length && p2<rSorted.length){
            while (p1<lSorted.length && lSorted[p1] <= rSorted[p2]){
                p1++;
            }
            p2++;
            totalCount = (totalCount%mod + (lSorted.length-p1)%mod)%mod;
        }
        return (int) (totalCount+l+r)&mod;
    }

    public static String largestNumber(ArrayList<Integer> A) {
        boolean allZero = true;
        for(int i: A){
            if(i != 0) {
                allZero = false;
                break;
            }
        }
        if(allZero)
            return "0";

        A.sort((o1, o2) -> {
            String s1 = o1 + String.valueOf(o2);
            String s2 = o2 + String.valueOf(o1);
            System.out.println(o1+" " + o2);
            System.out.println(s2 + " " + s1 + ": " + s2.compareTo(s1));
            System.out.println(s1 + " " + s2 + ": " + s1.compareTo(s2));
            return s2.compareTo(s1);
        });
        StringBuilder sb = new StringBuilder();
        for(int i: A){
            sb.append(i);
        }
        return sb.toString();
    }

    public static int uniqueElem(int[] A) {
        Arrays.sort(A);
        int count = 0;
        for(int i = 1; i<A.length; i++){
            if(A[i] == A[i-1]){
                count += A[i-1]+1-A[i];
                A[i]++;
            } else if(A[i] < A[i-1]){
                count += A[i-1]+1-A[i];
                A[i] = A[i-1]+1;
            }
        }
        return count;
    }

}
