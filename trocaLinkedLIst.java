import java.util.*;

public class trocaLinkedLIst {

    public static int[] trans(String[] arr) {
        int[] numbers = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            numbers[i] = Integer.parseInt(arr[i]);
        }
        return numbers;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = trans(sc.nextLine().split(" "));
        int posicao = sc.nextInt();
        sc.close();
        LinkedList lista = new LinkedList();
        for (int i = 0; i < numbers.length; i++) {
            lista.addLast(numbers[i]);
        }
        lista.swapNodes(posicao);
        System.out.println(lista.toString());

    }
}

class Node {
    Node previous;
    Node next;
    int value;

    public Node(int value) {
        this.next = null;
        this.previous = null;
        this.value = value;
    }
}

class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        return this.size;
    }

    public void addLast(int value) {
        if (this.isEmpty()) {
            Node newnode = new Node(value);
            this.tail = newnode;
            this.head = newnode;
        } else {
            Node newnode = new Node(value);
            this.tail.next = newnode;
            newnode.previous = this.tail;
            this.tail = newnode;
        }
        this.size++;

    }

    public Node get(int index) {
        Node aux = this.head;

        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }
        return aux;
    }

    public void troca(int index1, int index2) {
        Node n1 = get(index1);
        System.out.println(n1.value);

        Node n2 = get(index2);
        System.out.println(n2.value);

        Node aux2pre = n2.previous;
        Node aux2next = n2.next;
        n1.next.previous = n1.previous;
    }

    public void swapNodes(int index) {
        Node node1 = getNodeAtIndex(index);
        Node node2 = node1.next;

        // Update prev and next references of the nodes
        if (node1.previous != null) {
            node1.previous.next = node2;
        } else {
            head = node2;
        }
        if (node2.next != null) {
            node2.next.previous = node1;
        } else {
            tail = node1;
        }
        node1.next = node2.next;
        node2.previous = node1.previous;
        node1.previous = node2;
        node2.next = node1;
    }

    private Node getNodeAtIndex(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    public String toString(){
        Node aux = this.head;
        String out = "";
        while(aux!= null){
            out+= aux.value + " ";
            aux= aux.next;
        }
        return out.trim();
    }
}
