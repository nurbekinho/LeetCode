package leetcode.YY20.MM07;

import java.util.Arrays;
import java.util.Stack;

public class DD18_CourseScheduleII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(2, new int[][]{
                {1, 0}
        })));

        System.out.println(Arrays.toString(findOrder(4, new int[][]{
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        })));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] courses = new int[numCourses];
        for(int[] prerequisite : prerequisites) courses[prerequisite[0]]++;

        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if(courses[i] == 0) stack.push(i);
        }

        int[] result = new int[numCourses];
        int count=0;
        while (!stack.isEmpty()){
            int noInc=stack.pop();
            result[count++] = noInc;

            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == noInc) {
                    courses[prerequisite[0]]--;
                    if (courses[prerequisite[0]] == 0) stack.push(prerequisite[0]);
                }
            }
        }

        return (count == numCourses) ? result : new int[]{};
    }
}
