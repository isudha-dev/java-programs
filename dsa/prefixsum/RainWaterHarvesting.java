package dsa.prefixsum;

public class RainWaterHarvesting {

    public static void main(String[] args) {

    }

    /*
     * static int trap(vector<int>& height)
     * {
     * int ans = 0, current = 0;
     * dsa.stack<int> st;
     * while (current < height.size()) {
     * while (!st.empty() && height[current] > height[st.top()]) {
     * int top = st.top();
     * st.pop();
     * if (st.empty())
     * break;
     * int distance = current - st.top() - 1;
     * int bounded_height = min(height[current], height[st.top()]) - height[top];
     * ans += distance * bounded_height;
     * }
     * st.push(current++);
     * }
     * return ans;
     * }
     */
}