/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.emptyList;
import static java.util.Objects.nonNull;

class Solution {
    private final Map<Integer, List<Integer>> g;
    private final LinkedList<Integer> q;
    private final Set<Integer> visited;

    public Solution() {
        this.g = new HashMap<>();
        this.q = new LinkedList<>();
        this.visited = new HashSet<>();
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        createGraph(root);

        addToQ(target.val);

        while (!q.isEmpty()) {
            if (k == 0)
                return q;

            int size = q.size();

            for (int i = 0; i < size; i++) {
                int u = q.remove();

                for (int v : g.getOrDefault(u, emptyList()))
                    if (!visited.contains(v))
                        addToQ(v);
            }

            k--;
        }
        return emptyList();
    }

    private void addToQ(int u) {
        q.add(u);
        visited.add(u);
    }

    private void createGraph(TreeNode rt) {
        if (nonNull(rt.left)) {
            connect(rt.val, rt.left.val);
            createGraph(rt.left);
        }

        if (nonNull(rt.right)) {
            connect(rt.val, rt.right.val);
            createGraph(rt.right);
        }
    }

    private void connect(int u, int v) {
        g.computeIfAbsent(u, k -> new ArrayList<>())
         .add(v);
        g.computeIfAbsent(v, k -> new ArrayList<>())
         .add(u);
    }
}