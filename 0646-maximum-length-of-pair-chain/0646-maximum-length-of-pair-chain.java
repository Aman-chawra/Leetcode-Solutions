class Solution {
    int result=1;
    Map<Node,Integer> mainMap= new HashMap();
    List<Node> list1=new ArrayList();
    Map<Integer,List<Node>> map = new TreeMap(Collections.reverseOrder());
    List<Node> list= new ArrayList();
    public int findLongestChain(int[][] pairs) {
        for(int i=0;i<pairs.length;i++){
            Node n= new Node(pairs[i][0],pairs[i][1]);
            list.add(n);
            int s=pairs[i][0];
            List<Node> l= map.getOrDefault(s,new ArrayList());
            l.add(n);
            map.put(s,l);
        }
        
        for(Integer start : map.keySet() ){
            trverseMain(start);
        }
        
        return result;
        
    }
    
    private void trverseMain(int start){
        List<Node> list= map.get(start);
        int tChain=0;
        int [] ans= new int [1];
        if(list1.size()==0){
            list1.add(new Node(start,1));
            return;
        }
		for (Node n : list) {
			int t=0;
			ans[0] = -1;
			traverseBinaryScearch(0, list1.size() - 1, n.e, ans);
			if (ans[0] == -1) {
				tChain = Math.max(tChain, 1);
			} else {
				t+=1+ans[0];
				tChain = Math.max(tChain, t);
			}
		}
        Node n=new Node(start,tChain);
        int max=Math.max(list1.get(0).e,tChain);
        this.result=Math.max(result,max);
        list1.add(0,new Node(start,max));
    }
    
    private void traverseBinaryScearch(int i, int j, int target, int [] ans){
        if(i<=j){
            int m= (i+j)/2;
            Node n=list1.get(m);
            if(n.s>target){
                ans[0]=n.e;
                traverseBinaryScearch(i,m-1,target,ans);
            }else{
                traverseBinaryScearch(m+1,j,target,ans);
            }
        }
    }
}

class Node{
    int s;
    // count for list1 
    // right for rest of the Data Structures
    int e;
    public Node(int a,int b){
        this.s=a;
        this.e=b;
    }
}