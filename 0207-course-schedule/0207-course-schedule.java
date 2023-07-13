import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.util.Arrays.setAll;
import static java.util.Arrays.stream;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var g = createGraph(numCourses, prerequisites);
        int[] inDegree = createInDegree(numCourses, prerequisites);

        Queue<Integer> q = new LinkedList<>();

        for (int u = 0; u < numCourses; u++)
            if (inDegree[u] == 0)
                q.add(u);

        while (!q.isEmpty()) {
            int u = q.remove();

            for (int v : g[u])
                if (--inDegree[v] == 0)
                    q.add(v);
        }

        return stream(inDegree).allMatch(d -> d == 0);
    }

    private static int[] createInDegree(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];

        for (int[] uv : prerequisites)
            inDegree[uv[0]]++;

        return inDegree;
    }

    private static List<Integer>[] createGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new List[numCourses];
        setAll(g, i -> new ArrayList<>());

        for (int[] uv : prerequisites)
            g[uv[1]].add(uv[0]);

        return g;
    }
}