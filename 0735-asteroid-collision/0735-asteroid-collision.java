class Solution {
public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        Arrays.stream(asteroids).forEach(asteroid -> pushToStack(stack, asteroid));
        return stack.stream().mapToInt(a -> a).toArray();
    }

    private void pushToStack(Stack<Integer> stack, int asteroid) {
        if (stack.isEmpty() || asteroid * stack.peek() > 0 || (stack.peek() < 0 && asteroid > 0))
            stack.push(asteroid);
        else {
            int prev = stack.pop();

            if (Math.abs(prev) > Math.abs(asteroid))
                stack.push(prev);
            else if (Math.abs(prev) != Math.abs(asteroid))
                pushToStack(stack, asteroid);
        }
    }
}