class DoubleLinkedList
{

DoubleLinkedList prev=null;
DoubleLinkedList next=null;
String url="";
 
 
public DoubleLinkedList(String url)
{
 
 this.url=url;

}

public void next_pointer(DoubleLinkedList next)
 
{
    this.next=next;
 
}

public void prev_pointer(DoubleLinkedList prev)

{
    this.prev=prev;
 
}


}

class BrowserHistory {

    DoubleLinkedList curr=null;

    public BrowserHistory(String homepage) {
        
    
        curr=new DoubleLinkedList(homepage);
        return ;

    }
    
    public void visit(String url) {
        
        DoubleLinkedList next_pointer=new DoubleLinkedList(url);
        curr.next=next_pointer;
        next_pointer.prev=curr;
        curr=next_pointer;

        return ;

    }
    
    public String back(int steps) {
        
        while(steps>0 && (curr.prev!=null))
        {
            curr=curr.prev;
            steps--;
        }
        return curr.url;
    }
    
    public String forward(int steps) {
        
        while(steps>0 && (curr.next!=null))
        {
            curr=curr.next;
            steps--;

        }
        return curr.url;
        
    }
}

