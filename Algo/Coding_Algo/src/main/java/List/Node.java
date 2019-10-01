package List;

/**
 * Created by dpandey on 8/26/17.
 */
public class Node<T> {

    public T element;
    public Node<T> nextNode;

    public Node(T data, Node<T> nextNode) {
        this.element = data;
        this.nextNode = nextNode;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }
}
