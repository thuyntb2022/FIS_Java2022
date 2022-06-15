package generic;

public class Stack<T> {
    Node<T> head;

    public Stack() {
        head = null;
    }
    public void push(T obj) {
        Node newNode = new Node(obj);
        newNode.setNext(head);
        head = newNode;
    }

    public T pop() {
        T obj = (T) head.getObj();
        head = head.getNext();
        return obj;
    }

    public T peek() {
        return head.getObj();
    }

    public boolean isEmpty() {
        return head == null;
    }
}
