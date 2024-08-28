class MyQueue {
    Stack<Integer> insertor;
    Stack<Integer> revertor;
    int size;

    public MyQueue() {
        insertor = new Stack<>();
        revertor = new Stack<>();
        size = 0;
    }

    public void push(int x) {
        while (!insertor.empty()) {
            revertor.push(insertor.pop());
        }
        insertor.push(x);
        while (!revertor.empty()) {
            insertor.push(revertor.pop());
        }
        size++;
    }

    public int pop() {
        size--;
        return insertor.pop();
    }

    public int peek() {
        return insertor.peek();
    }

    public boolean empty() {
        return size == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */