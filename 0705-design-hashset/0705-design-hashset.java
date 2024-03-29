class MyHashSet {


    List<Integer> l;
    public MyHashSet() {
        l=new ArrayList();
    }
    
    public void add(int key) {
        if(l.contains(key)==false)
            l.add(key);
    }
    
    public void remove(int key) {
        if(l.contains(key))
            l.remove(l.indexOf(key));
    }
    

    public boolean contains(int key) {
        return l.contains(key);
           
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */