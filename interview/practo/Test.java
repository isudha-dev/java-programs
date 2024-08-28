package interview.practo;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println(traverseBuilding(new int[] {9,7,6,3,1}, 3, 1));
    }

    public static int traverseBuilding(int[] heights, int bricks, int ladder){
        if(heights.length == 1){
            return 0;
        }

        int i = 1;
        while(i < heights.length){
            if(heights[i-1] < heights[i]){
                if(ladder > 0){
                    ladder--;
                    i++;
                    continue;
                } else if (bricks > 0) {
                    int diff = heights[i] - heights[i-1];
                    if(bricks >= diff){
                        bricks -= diff;
                        i++;
                        continue;
                    } else
                        break;
                } else {
                    break;
                }
            }
            i++;
        }

        return i-1;
    }
}
