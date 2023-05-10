public class LinkdListR {
    private Node head;
    private Node tail;
    private int size;

    public LinkdListR() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null;
    }
    public int indexOf(int value){
        Node aux = this.head;
        int cont = 0;
        while(aux!= null){
            if (value == aux.value) return cont;
            aux = aux.next;
            cont++; 
        }
        return -1;
    }

    public void addLast(int value) {
        Node newnode = new Node(value);
        if (isEmpty()) {
            this.head = newnode;
            this.tail = newnode;
        } else {
            this.tail.next = newnode;
            newnode.previous = this.tail;
            this.tail = newnode;
        }
        size++;
    }

    public void addFirst(int value) {
        Node newnode = new Node(value);
        if (isEmpty()) {
            this.head = newnode;
            this.tail = newnode;
        }
        this.head.previous = newnode;
        newnode.next = this.head;
        this.head = newnode;
        size++;
    }

    public void addR(int value, int index){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        else if (index == 0){
            addFirst(value);
        }
        else if (index == size - 1){
            addLast(value);
        }
        else{
            addR(this.head,value, index, 0);
        }
    }

    private void addR(Node currentnode, int value, int index, int i) {
        if (i == index - 1){
            Node newnode = new Node(value);
            newnode.next = currentnode.next;
            currentnode.next = newnode;
            newnode.next.previous = newnode;
            newnode.previous = currentnode;
            this.size++;
        }else{
            addR(currentnode.next,value,index,i + 1);
        }
    }
    public Node get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        
        Node aux = this.head;
        
        for (int i = 0; i < index; i++)
            aux = aux.next;
        
        return aux;
    }
    public int removeFirst(){
        if (isEmpty()){
            throw new IllegalArgumentException();
        }
        int aluno = this.head.value;

        if (this.head.next == null){
            this.head = null;
            this.tail = null;
        }
        else{
            this.head = this.head.next;
            this.head.previous = null; 
        }
        size--;
        return aluno;
    }
    public int removeLast() {
        
        if (isEmpty()) {
            throw new IllegalArgumentException();
        }
        
        int aluno = this.tail.value;
        
        if (this.head.next == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.previous;
            this.tail.next = null;
        }           
        
        size -= 1;
        return aluno;
    }
    public int remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        
        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();
        
        Node aux = this.head;
        for (int i = 0; i < index; i++)
            aux = aux.next;
        
        aux.previous.next = aux.next;
        aux.next.previous = aux.previous;
        size -= 1;
        return aux.value;
    }
    

}
