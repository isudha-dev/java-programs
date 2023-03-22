package dsa.linkedlist;

import java.util.ArrayList;

public class FlattenNestedList {
    public static void main(String[] args) {

    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation.
    class NestedInteger {

        NestedInteger(int x) {
        }

        // Return true if this NestedInteger holds a single integer, rather than a
        // nested list.
        boolean isInteger() {
            return true;
        }

        // Return the single integer that this NestedInteger holds, if it holds a single
        // integer.
        // The result is 1e9 if this NestedInteger holds a nested list.
        int getInteger() {
            return 1;
        }

        // Return the nested list that this NestedInteger holds, if it holds a nested
        // list.
        // The result is an empty ArrayList if this NestedInteger holds a single
        // integer.
        ArrayList<NestedInteger> getList() {
            return null;
        }
    }

    class NestedIterator {

        ArrayList<Integer> actual;
        int idx;
        int n;

        NestedIterator(ArrayList<NestedInteger> nestedList) {
            actual = new ArrayList<>();
            rec(nestedList);
            n = actual.size();
            idx = 0;
        }

        void rec(ArrayList<NestedInteger> nestedList) {
            for (int i = 0; i < nestedList.size(); i++) {
                if (nestedList.get(i).isInteger()) {
                    actual.add(nestedList.get(i).getInteger());
                } else {
                    rec(nestedList.get(i).getList());
                }
            }
        }

        int next() {
            return actual.get(idx++);
        }

        boolean hasNext() {
            if (idx < n)
                return true;
            return false;
        }
    }
}