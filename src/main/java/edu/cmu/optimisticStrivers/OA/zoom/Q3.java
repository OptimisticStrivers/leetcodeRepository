package edu.cmu.optimisticStrivers.OA.zoom;

/**
 * @ClassName: Q3
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/10/24 10:04 AM
 * @Version 1.0
 */
public class Q3 {

    static int[] solution(int[] memory, int[][] queries) {
        int idCounter = 1;
        int queryLen = queries.length;
        int[] res = new int[queryLen];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if (query[0] == 0) { //alloc
                int needSpace = query[1];
                int curSpace = 0;
                int from = 0;
                int to = 0;
                boolean hasFound = false;
                for (int j = 0; j < memory.length; j++) {
                    if (memory[j] == 0) {
                        curSpace++;
                        to = j;
                        if (curSpace == needSpace) {
                            for (int j2 = from; j2 <= to; j2++) {
                                memory[j2] = idCounter;
                            }
                            idCounter++;
                            res[i] = from;
                            hasFound = true;
                            break;
                        }
                    } else {
                        //rest
                        curSpace = 0;
                        from = j + 1;
                        to = j + 1;
                    }
                }
                if (!hasFound) res[i] = -1;
            } else { //erase
                int requiredId = query[1];
                int returnLen = 0;
                for (int j = 0; j < memory.length; j++) {
                    if (memory[j] == requiredId) {
                        memory[j] = 0;
                        returnLen++;
                    }
                }
                if (returnLen == 0) {
                    res[i] = -1;
                } else {
                    res[i] = returnLen;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
