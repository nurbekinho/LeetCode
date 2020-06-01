package May2020;

public class Day31_EditDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("zoologicoarchaeologist", "zoogeologist"));
        System.out.println(minDistance("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopically"));
    }

    public static int minDistance(String word1, String word2) {
        int[][] ops = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i <= word1.length(); i++) ops[i][0] = i;
        for(int i = 1; i <= word2.length(); i++) ops[0][i] = i;

        for(int i = 0; i < word1.length(); i++) {
            char c1 = word1.charAt(i);
            for(int j = 0; j < word2.length(); j++) {
                char c2 = word2.charAt(j);
                if(c1 == c2) ops[i + 1][j + 1] = ops[i][j];
                else ops[i + 1][j + 1] = 1 + Math.min(ops[i][j], Math.min(ops[i][j + 1], ops[i + 1][j]));
            }
        }

        return ops[word1.length()][word2.length()];
    }
}
