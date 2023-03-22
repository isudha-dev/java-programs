package dsa.tree;

public class NextPointerBT {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {

        TreeLinkNode ver = root;
        while (ver != null) {
            TreeLinkNode hor = ver;
            while (hor != null) {
                if (hor.left != null) {
                    if (hor.right != null)
                        hor.left.next = hor.right;
                    else
                        hor.left.next = getNextRight(hor);
                }
                if (hor.right != null) {
                    hor.right.next = getNextRight(hor);
                }
                hor = hor.next;
            }
            if (ver.left != null) {
                ver = ver.left;
            } else if (ver.right != null) {
                ver = ver.right;
            } else {
                ver = getNextRight(ver);
            }
        }

    }

    public TreeLinkNode getNextRight(TreeLinkNode hor) {
        TreeLinkNode curr = hor.next;
        while (curr != null) {
            if (curr.left != null)
                return curr.left;
            if (curr.right != null)
                return curr.right;
            curr = curr.next;
        }
        return curr;
    }

}
