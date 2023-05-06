import java.util.NoSuchElementException;
import java.util.Scanner;

class FiltraLinkedList {
	public static int[] trans(String[] arr) {
		int[] n = new int[arr.length];
		for (int i = 0; i < n.length; i++) {
			n[i] = Integer.parseInt(arr[i]);
		}
		return n;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] numbers = trans(sc.nextLine().split(" "));
		int n = sc.nextInt();
		sc.close();
		Linkedlist lista = new Linkedlist();
		for (int i = 0; i < numbers.length; i++) {
			lista.addIndex(numbers[i], i);
		}
		while (lista.contains(n)) {
			if (lista.indexOf(n) != -1) {
				int index = lista.indexOf(n);
				lista.remove(index);

			}
		}
		System.out.println(lista.toString());

	}

}
class Node {
	Node next;
	Node previous;
	int value;

	public Node(int value) {
		this.next = null;
		this.previous = null;
		this.value = value;
	}
}

class Linkedlist {
	private Node head;
	private Node tail;
	private int size;

	public Linkedlist() {
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

	public void addFirst(int value) {
		if (this.isEmpty()) {
			Node newnode = new Node(value);
			this.head = newnode;
			this.tail = newnode;
		}

		else {
			Node newnode = new Node(value);
			this.head.previous = newnode;
			newnode.next = this.head;
			this.head = newnode;
		}
		this.size++;
	}

	public void addIndex(int value, int index) {
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException();
		}
		Node newnode = new Node(value);
		if (this.size == index) {
			addFirst(value);
		} else if (value == this.size - 1) {
			addLast(value);
		} else {
			Node aux = this.head;
			for (int i = 0; i < index - 1; i++) {
				aux = aux.next;
			}
			newnode.next = aux.next;
			aux.next = newnode;
			this.size++;
		}
	}

	public int removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException();
		int aux = this.head.value;
		if (this.head.next == null) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
			this.head.previous = null;
		}
		this.size--;
		return aux;
	}

	public int removeLast() {
		if (isEmpty())
			throw new NoSuchElementException();
		int aux = this.tail.value;
		if (this.head.next == null) {
			this.head = null;
			this.tail = null;
		} else {
			this.tail = this.tail.previous;
			this.tail.next = null;

		}
		this.size--;
		return aux;
	}

	public int get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node aux = this.head;
		for (int i = 0; i < index; i++) {
			aux = aux.next;
		}
		return aux.value;
	}

	public int indexOf(int value) {
		Node aux = this.head;
		int index = 0;
		while (aux != null) {
			if (aux.value == value) {
				return index;
			}
			aux = aux.next;
			index++;

		}
		return -1;
	}

	public boolean contains(int value) {
		return indexOf(value) != -1;
	}

	public int remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0)
			return removeFirst();
		if (index == size - 1)
			return removeLast();
		Node aux = this.head;
		for (int i = 0; i < index; i++) {
			aux = aux.next;
		}
		aux.previous.next = aux.next;
		aux.next.previous = aux.previous;
		size--;
		return aux.value;
	}

	public int getTamanho() {
		Node aux = this.head;
		int j = 0;
		while (aux != null) {
			aux = aux.next;
			j++;
		}
		return j;
	}

	public String toString() {
		String out = "";
		if (this.isEmpty()) return "vazia";
		Node aux = this.tail;
		for (int i = 0; i < size; i++) {
			out += aux.value + " ";
			aux = aux.previous;
		}
		return out.trim();
	}
}
