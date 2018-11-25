// For every bar, we calculate its largest area with it as the smallest bar in the rectangle;
// So, we need to find the left index and right index who are the first bar that smaller than this bar.
// How to find the left and right index:
// We push each index of the bar into the stack;
// Once we find a bar whose value is smaller than the vlaue of stack.peek(), then this is the right index;
// And the left index is previous item in the stack.
// If stack is not empty, we pop out index one by one from the stack.

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i <= heights.length; i++){
            int h = 0;
            if(i < heights.length) h = heights[i];
            while(!stack.isEmpty() && h < heights[stack.peek()]){
                int cur = stack.pop();
                if(stack.isEmpty()){
                    //System.out.println(heights[cur] + " * " + (i - cur));
                    max = Math.max(max, heights[cur] * i);
                }else{
                    int prev = stack.peek();
                    //System.out.println(heights[cur] + "*" + (i - prev - 1));
                    max = Math.max(max, heights[cur] * (i - prev - 1));
                }
            }
            stack.push(i);
        }
        return max;
    }
}