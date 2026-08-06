public class ListNode{
    int value;
    int currentmin;
    ListNode next;
    ListNode prev;
    ListNode(int val,int currmin){
        this.value = val;
        this.currentmin = currmin;
    }
}

class MinStack {

    int min;
    ListNode top;

    public MinStack() {
        top = null;
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(top == null){
            min = Math.min(val,min);
            ListNode newnode = new ListNode(val,min);
            top = newnode;
        }
        else{
            min = Math.min(val,min);
            ListNode newnode = new ListNode(val,min);
            top.next = newnode;
            newnode.prev = top;
            top = newnode;
        }
    }
    
    public void pop() {
        top = top.prev;
        if(top != null){
            top.next = null;
            min = top.currentmin;
        }
        else{
            min = Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        return top.value;
    }
    
    public int getMin() {
        return top.currentmin;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */