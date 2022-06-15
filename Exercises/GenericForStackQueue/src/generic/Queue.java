package generic;

public class Queue<T> {
    Node<T> tail;
    Node<T> head;

    public Queue() {
        tail = head =  null;
    }
    public void enqueue(T obj) {
        Node newNode = new Node(obj);
        if (isEmpty()) {
            head = tail = newNode;
            tail.setNext(null);
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    private boolean isEmpty() {
        return head == null;
    }

    public T dequeue() {
        T obj = head.getObj();
        head = head.getNext();
        return obj;
    }

    public T peek() {
        return head.getObj();
    }

}
