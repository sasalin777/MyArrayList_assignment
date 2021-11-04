import java.util.List;
import java.util.NoSuchElementException;
import java.util.*;

/**
 * Singly Linked-list (generic)
 */
public class MyLinkedList<E>  {

  private Node<E> head, tail; // null
  private int size; // 0

  public MyLinkedList() { }

  // O(1)
  public void addFirst(E e) {
    final Node<E> h = head;
    final Node<E> newNode = new Node<>(e, h);
    head = newNode;
    if (h == null) {
      // adding a new node to the empty linked list
      tail = newNode;
    }
    size++;
  }

  // O(1)
  public void addLast(E e) {
    final Node<E> t = tail;
    final Node<E> newNode = new Node<>(e, null);
    tail = newNode;
    if (t == null) {
      head = newNode;
    } else {
      t.next = newNode;
    }
    size++;
  }

  // O(N)
  public void add(int index, E e) {
    if (index < 0 || index > size) {
     throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
    }
    if (index == 0) {
      addFirst(e);
    } else if (index == size) {
      addLast(e);
    } else {
      Node<E> cur = head;
      for (int i = 0; i < index - 1; i++) {
        cur = cur.next;
      }
      cur.next = new Node<>(e, cur.next);
      size++;
    }
  }

  // O(1)
  public E removeFirst() {
    final Node<E> h = head;
    if (h == null) {
      throw new NoSuchElementException("list is empty");
    }

    E data = h.data;
    Node<E> next = h.next;
    h.data = null;
    h.next = null;
    head = next;
    if (next == null) {
      // only one element in the list
      tail = null;
    }
    size--;
    return data;
  }

  // O(1)
  public E removeLast() {
    // TODO: Implement Me;
    final Node<E> t = tail;
    if (t == null) {
      throw new NoSuchElementException("list is empty");
    }
    Node<E> current = head;
    for(int i = 1; i < size - 1; i++) {
      current = current.next;
    }
    Node<E> temp = tail;
    tail = current;
    tail.next = null;
    size--;
    return temp.data;
  }

  // O(1)
  public E getFirst() {
    if (head == null) {
      throw new NoSuchElementException("list is empty");
    }
    return head.data;
  }

  // O(1)
  public E getLast() {
    if (tail == null) {
      throw new NoSuchElementException("list is empty");
    }
    return tail.data;
  }

  private Node<E> getNodeAt(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
    }
    Node<E> cur = head;
    for (int i = 0; i < index; i++) {
      cur = cur.next;
    }
    return cur;
  }

  // O(N)
  public E get(int index) {
    return getNodeAt(index).data;
  }

  // O(N)
  public E set(int index, E e) {
    Node<E> cur = getNodeAt(index);
    E oldValue = cur.data;
    cur.data = e;
    return oldValue;
  }

  // O(N)
  public int indexOf(E e) {
    int index = 0;
    if (e == null) {
      for (Node<E> x = head; x != null; x = x.next) {
        if (x.data == null) {
          return index;
        }
        index++;
      }
    } else {
      for (Node<E> x = head; x != null; x = x.next) {
        if (e.equals(x.data)) {
          return index;
        }
        index++;
      }
    }
    return -1;
  }

  /**
   * Remove the element e from the list
   * @param e
   * @return
   */
  public boolean remove(E e) {
    // TODO: Implement Me
    if (indexOf(e) >=0 ) {
       remove(indexOf(e));
      return true;
    } else {
      return false;}
  }

  /**
   * Remove the element at index
   * O(N)
   * @param index
   * @return
   */
  public boolean remove(int index) {
    // TODO: Implement Me
    if (index >= 0 || index < size) {
      remove(index);
      return true;
    }
    return false;
  }


  /**
   * Returns the index of the last occurrence of element e
   * O(N)
   *
   * ll = [1, 1, 2, 3, 1, 5, 1, 2]
   * ll.lastIndexOf(1) -> 6
   * @param e
   * @return the index of the last occurrence of element e
   */
  public int lastIndexOf(E e) {
    // TODO: Implement Me
    final Node<E> t = tail;
    E data = t.data;
    if(e.equals(t.data)){
  }else {
    Node<E> current = head;
    E data1 = current.data;
    int result = -1;
    for(int i = 1; i < size; i++) {
      current = current.next;
      if(e.equals(current.data)) {
        result = i;
      }
    }
    return result;
  }
    return -1;
  }

  /**
   * Reverses the current linked list
   * "A" -> "B" -> "C" -> null
   * should be
   * "C" -> "B" -> "A" -> null
   */
  public void reverse() {
    // TODO: Implement Me
    if (head.next == null || head.next.next == null){
      return;
    }
    Node reverseHead = new Node(0,null);
    Node cur = head.next;
    Node next = null;
    while (true){
      if (cur == null){
        break;
      }
      next = cur.next;
      cur.next = reverseHead.next;
      reverseHead.next = cur;
      cur = next;
    }
    head.next = reverseHead.next;
  }

  // O(N)
  public boolean contains(E e) {
    return indexOf(e) >= 0;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    for (Node<E> x = head; x != null; x = x.next) {
      s.append(x.data).append(" -> ");
    }
    s.append("null");
    return s.toString();
  }

  public int size() {
    return size;
  }

  // static nested class
  public static class Node<E> {
    E data;
    Node<E> next;

    public Node(E item, Node<E> next) {
      this.data = item;
      this.next = next;
    }
  }
}

