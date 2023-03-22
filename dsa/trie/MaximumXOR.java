package dsa.trie;

public class MaximumXOR {
    public int solve(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i : A) {
            max = Math.max(max, i);
        }
        int logOfMax = (int) (Math.log(max) / Math.log(2));

        TrieNode root = new TrieNode();
        insertTrie(root, A[0], logOfMax);
        int maxXor = 0;

        for (int j = 1; j < A.length; j++) {
            int xor = findXor(root, A[j], logOfMax);
            maxXor = Math.max(maxXor, xor);
            insertTrie(root, A[j], logOfMax);
        }

        return maxXor;
    }

    class TrieNode {
        TrieNode[] child = new TrieNode[2];
        boolean isEnd;
        int count;

        TrieNode() {
            // TrieNode node;
            for (int i = 0; i < 2; i++) {
                this.child[i] = null;
            }
            this.isEnd = false;
            this.count = 1;
        }
    }

    boolean searchTrie(TrieNode root, int num, int logOfMax) {
        TrieNode temp = root;
        for (int i = logOfMax; i >= 0; i--) {
            int bit = getIthBit(num, i);
            if (temp.child[bit] == null)
                return false;
            temp = temp.child[bit];
        }
        return temp.isEnd;
    }

    void insertTrie(TrieNode root, int num, int logOfMax) {
        TrieNode temp = root;
        for (int i = logOfMax; i >= 0; i--) {
            int bit = getIthBit(num, i);
            if (temp.child[bit] == null)
                temp.child[bit] = new TrieNode();
            temp = temp.child[bit];
            temp.count++;
        }
        temp.isEnd = true;
        return;
    }

    public int findXor(TrieNode root, int x, int logOfMax) {
        TrieNode temp = root;
        int xor = 0;
        for (int i = logOfMax; i >= 0; i--) {
            int bit = getIthBit(x, i);
            int idx = bit == 1 ? 0 : 1;
            if (temp.child[idx] != null) {
                temp = temp.child[idx];
                xor = setIthBit(xor, i);
            } else
                temp = temp.child[bit];
        }

        return xor;
    }

    public int getIthBit(int x, int i) {
        return (x >> i) & 1;
    }

    public int setIthBit(int x, int i) {
        return ((1 << i) | x);
    }

    public static void main(String[] args) {
        MaximumXOR mx = new MaximumXOR();
        int ans = mx.solve(new int[] { 1, 2, 3, 4, 5 });
        System.out.println(ans);
    }

}
