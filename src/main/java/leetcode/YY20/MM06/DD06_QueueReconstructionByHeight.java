package leetcode.YY20.MM06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DD06_QueueReconstructionByHeight {
    public static void main(String[] args) {
        int[][] reconstructed = reconstructQueue(new int[][]{
                new int[]{7, 0},
                new int[]{4, 4},
                new int[]{7, 1},
                new int[]{5, 0},
                new int[]{6, 1},
                new int[]{5, 2},
        });

        for (int[] r : reconstructed) System.out.println(Arrays.toString(r));
    }

    public static int[][] reconstructQueue(int[][] people) {
        Person[] persons = new Person[people.length];
        for (int i = 0; i < people.length; i++) persons[i] = new Person(people[i][0], people[i][1]);

        Arrays.sort(persons, (p1, p2) -> (p1.h == p2.h) ? p1.k - p2.k : p2.h - p1.h);
        List<Person> reconstructed = new ArrayList<>();
        for (Person person : persons) reconstructed.add(person.k, person);

        for (int i = 0; i < people.length; i++) {
            people[i][0] = reconstructed.get(i).h;
            people[i][1] = reconstructed.get(i).k;
        }

        return people;
    }

    private static class Person {
        int h, k;

        Person(int h, int k) {
            this.h = h;
            this.k = k;
        }
    }
}
