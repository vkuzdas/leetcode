class Node {
        public String prefix;
        public HashMap<Character, Node> neighbors;
        public boolean endOfWord;
        public Node() {
            prefix = "";
            neighbors = new HashMap<Character, Node>();
        }
        public Node(String _val) {
            prefix = _val;
            neighbors = new HashMap<Character, Node>();
        }
        public Node(String _val, HashMap<Character, Node> _neighbors) {
            prefix = _val;
            neighbors = _neighbors;
        }
    }

class Trie {

        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            char[] str = word.toCharArray();
            Node curr = root;

            // iterate from root until you find a node which does not match suffix
            int i = 0;
            while (curr.neighbors.get(str[i]) != null && i < word.length()-1) {
                curr = curr.neighbors.get(str[i]);
                i ++;
            }
            if (word.length()-1 == i && curr.neighbors.get(str[i]) != null) {
                curr.neighbors.get(str[i]).endOfWord = true;
                return;
            }

            // continue from such node, creating new nodes with the given suffix
            Node prev = curr;
            for (int j = i; j < str.length; j++) {
                Node next = new Node(new String(Arrays.copyOfRange(str, 0, j))+str[j]);
                prev.neighbors.put(str[j], next);
                prev = next;
            }
            prev.endOfWord = true;

        }

        public boolean search(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                curr = curr.neighbors.get(word.charAt(i));
                if (curr == null) {
                    return false;
                }
            }
            return curr.endOfWord;
        }

        public boolean startsWith(String prefix) {
            Node curr = root;
            for (int i = 0; i < prefix.length(); i++) {
                curr = curr.neighbors.get(prefix.charAt(i));
                if (curr == null) {
                    return false;
                }
            }
            return true;
        }
    }