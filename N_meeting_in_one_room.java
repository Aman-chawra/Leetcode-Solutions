
class meeting {
    int start;
    int end;
    int pos;

    meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;

    }

    public String toString() {
        return start + " " + end + " " + pos;
    }
}

class meetComp implements Comparator<meeting> {
    @Override
    public int compare(meeting m1, meeting m2) {
        if (m1.end < m2.end)
            return -1;
        else if (m1.end > m2.end)
            return 1;
        else if (m1.pos < m2.pos)
            return -1;
        return 1;
    }
}

class Solution {

    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n) {
        // add your code here
        ArrayList<meeting> ls = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            ls.add(new meeting(start[i], end[i], i + 1));
        }
        meetComp mcomp = new meetComp();
        Collections.sort(ls, mcomp);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(ls.get(0).pos);
        int limit = ls.get(0).end;
        for (int i = 1; i < start.length; i++) {
            if (ls.get(i).start > limit) {
                limit = ls.get(i).end;
                ans.add(ls.get(i).pos);
            }
        }
        // for(int i=0;i<ans.size();i++) System.out.print(ans.get(i)+" ");
        return ans.size();

    }
}