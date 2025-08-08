//Problem : CloneGraph 
//Solution : BFS 
//Complexity : O (V + E)
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

 class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

}

class CloneGraph {
    
    public static void main (String args []) {
        Node node  = new Node(1);
        Node node2  = new Node(2);
        Node node3 = new Node(3);
        
        node.neighbors.add(node2);
        node.neighbors.add(node3);
        node2.neighbors.add(node);
        node3.neighbors.add(node);

        Node clonedNode = clone(node);
    }

    public static Node clone(Node node) {
        if (node == null) 
            return null;

        Node currentNode = node;

        Queue<Node> queue = new LinkedList<>();

        HashMap<Node, Node> map = new HashMap<>();
        queue.offer(currentNode);
 

        while (!(queue.isEmpty())) {    
            currentNode = queue.poll();
            if (!(map.containsKey(currentNode))) {
                Node tmpNode = new Node(currentNode.val);
                map.put(currentNode, tmpNode);
            }

            List<Node> neighList = currentNode.neighbors;
            for (int i = 0; i<neighList.size(); ++i) {
                if (!(map.containsKey(neighList.get(i)))){
                    Node tmpNode = new Node(neighList.get(i).val);
                    map.put(neighList.get(i), tmpNode);
                    map.get(currentNode).neighbors.add(tmpNode);
                    queue.offer(neighList.get(i));
                }
                else {
                    map.get(currentNode).neighbors.add(map.get(neighList.get(i)));
                }
            }
        }
 
        return map.get(node);
    }

}
