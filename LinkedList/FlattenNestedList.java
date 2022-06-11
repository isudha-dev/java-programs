package LinkedList;

import java.util.ArrayList;
import java.util.Iterator;

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

        Iterator<NestedInteger> itr;

        NestedIterator(ArrayList<NestedInteger> nestedList) {
            itr = nestedList.iterator();
        }

        int next() {
            return itr.next().getInteger();
        }

        boolean hasNext() {
            if (itr.hasNext()) {
                if (itr.next().isInteger()) {
                    return true;
                } else {
                    ArrayList<NestedInteger> al = itr.next().getList();
                    if (al.size() > 0) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}