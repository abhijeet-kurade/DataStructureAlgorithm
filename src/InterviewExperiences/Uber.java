package InterviewExperiences;

public class Uber {
    // Given a Binary Search Tree (BST) and a positive integer k,
    // Find the Kth Largest Element with O(1) Space Complexity and O(n) Time Complexity
    // where n is the number of nodes in the BST.
    // For example, in the following BST, if k = 3, then output should be 15, and if k = 5, then output should be 4.
    //             10
    //           /    \
    //          4      20
    //         /      /   \
    //        2     15     40


    class Solution{
        static class Node{
            int val;
            Node left;
            Node right;
            Node parent;

            public Node(int val, Node parent){
                this.val = val;
                this.parent = parent;
            }
        }

        public static void main(String[] args){
            Node bst1 = new Node(10, null);
            bst1.left = new Node(4, bst1);
            bst1.right = new Node(20, bst1);
            bst1.left.left = new Node(2, bst1.left);
            bst1.right.left = new Node(15, bst1.right);
            bst1.right.right = new Node(40, bst1.right);

            System.out.println(getKthLargestNodeInBST(bst1, 13));
        }

        public static int getKthLargestNodeInBST(Node root, int k){
            Node node = root;
            if(node == null) return -1;

            while(node.right != null){
                node = node.right;
            }
            k -= 1;
            while(k > 0){

                if(node.left != null){
                    node = node.left;
                    while(node.right != null){
                        node = node.right;
                    }
                }
                else{
                    while(node.parent != null && node.parent.left == node){
                        node = node.parent;
                    }
                    node = node.parent;
                }
                if(node == null)  return -1;

                k -= 1;
            }
            return node.val;
        }

        public static int getKthLargestNodeInBST1(Node root, int k){
            Node ans = getKthNodeRecursively(root, new int[]{0}, k);
            return ans == null ? -1 : ans.val;
        }

        public static Node getKthNodeRecursively(Node node, int[] count, int k){
            if(node == null) return null;

            // reverse in-order traversal
            Node right = getKthNodeRecursively(node.right, count, k);
            if(right != null){
                return right;
            }
            count[0] += 1;
            if(count[0] == k){
                return node;
            }

            Node left = getKthNodeRecursively(node.left, count, k);
            if(left != null){
                return left;
            }
            return null;
        }

    }
}
