package linkedlist;

public class NodeRunner {
    public static void main(String[] args) {
        LinkedList.insert_node(1, 10);
        LinkedList.insert_node(2, 20);
        LinkedList.insert_node(2, 30);
        LinkedList.insert_node(4, 40);
        LinkedList.insert_node(5, 50);
        LinkedList.print_ll();

        LinkedList.delete_node(2);
        LinkedList.print_ll();

        LinkedList.delete_node(3);
        LinkedList.print_ll();
    }

}
