/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        return maxDepthHelper(root, 0);
    }

    public int maxDepthHelper(Node root, int max){
        if(root == null) return max;
        max++;

        int tmp = max;
        for(Node n: root.children){
            tmp = Math.max(tmp, maxDepthHelper(n, max));
        }

        return tmp;
    }
}
