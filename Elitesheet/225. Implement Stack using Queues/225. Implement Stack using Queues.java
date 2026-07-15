1class MyStack {
2    Queue<Integer> queue;
3
4
5    public MyStack() {
6        queue = new LinkedList<>();
7    }
8    
9    public void push(int x) {
10        queue.add(x);
11
12        for(int i=0;i<queue.size()-1;i++){
13            queue.add(queue.remove());
14        }
15    }
16    
17    public int pop() {
18        return queue.remove();
19    }
20    
21    public int top() {
22        return queue.peek();
23    }
24    
25    public boolean empty() {
26        return queue.isEmpty();
27    }
28}
29
30/**
31 * Your MyStack object will be instantiated and called as such:
32 * MyStack obj = new MyStack();
33 * obj.push(x);
34 * int param_2 = obj.pop();
35 * int param_3 = obj.top();
36 * boolean param_4 = obj.empty();
37 */