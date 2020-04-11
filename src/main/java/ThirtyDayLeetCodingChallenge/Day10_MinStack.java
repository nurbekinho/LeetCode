package ThirtyDayLeetCodingChallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day10_MinStack {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }

    static class MinStack {
        List<Integer> data;
        Stack<Integer> stack;

        public MinStack() {
            data = new ArrayList<>();
            stack = new Stack<>();
        }

        public void push(int x) {
            if (stack.isEmpty() || x <= stack.peek()) stack.push(x);
            data.add(x);
        }

        public void pop() {
            int removed = data.remove(data.size() - 1);
            if (stack.peek() == removed) stack.pop();
        }

        public int top() {
            return data.get(data.size() - 1);
        }

        public int getMin() {
            return stack.peek();
        }
    }
}

/*
List<Integer> data;
PriorityQueue<Integer> dataQueue;

public MinStack() {
    data = new ArrayList<>();
    dataQueue = new PriorityQueue<>((element1, element2) -> element1 - element2);
}

public void push(int x) {
    data.add(x);
    dataQueue.add(x);
}

public void pop() {
    int removed = data.remove(data.size() - 1);
    dataQueue.remove(removed);
}

public int top() {
    return data.get(data.size() - 1);
}

public int getMin() {
    return dataQueue.stream().findFirst().orElse(0);
}
 */
