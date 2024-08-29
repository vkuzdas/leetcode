    class MyQueue {

        int size;
        Stack<Integer> insertor;
        Stack<Integer> revertor;

        public MyQueue() {
            size = 0;
            insertor = new Stack<>();
            revertor = new Stack<>();
        }

        public void push(int x) {
            // empty insertor onto revertor
            while (!insertor.empty()) {
                revertor.push(insertor.pop());
            }

            // insert pushed element onto empty insertor
            insertor.push(x);

            // pop everythin from revertor back onto insertor
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