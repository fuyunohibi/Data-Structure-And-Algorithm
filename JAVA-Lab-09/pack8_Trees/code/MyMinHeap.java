package code;

public class MyMinHeap {
  int MAX_SIZE = 100;
  int heap[] = new int[MAX_SIZE];
  int size = 0;

  // Inserts an item to the heap
  public void insert(int d) {
    if (isFull()) {
      throw new RuntimeException("Heap is full");
    }

    heap[size] = d;
    int current = size;

    // Bubble up to ensure min heap property
    while (current != 0 && heap[current] < heap[parent(current)]) {
      swap(current, parent(current));
      current = parent(current);
    }

    size++;
  }

  // Removes and returns the smallest item from the heap
  public int remove() {
    if (isEmpty()) {
      throw new RuntimeException("Heap is empty");
    }

    int popped = heap[0];
    heap[0] = heap[--size];

    // Bubble down to ensure min heap property
    heapify(0);
    return popped;
  }

  // Returns the smallest item without popping it
  public int peek() {
    if (isEmpty()) {
      throw new RuntimeException("Heap is empty");
    }
    return heap[0];
  }

  // Checks if the heap is full
  public boolean isFull() {
    return size == MAX_SIZE;
  }

  // Checks if the heap is empty
  public boolean isEmpty() {
    return size == 0;
  }

  // Returns a string representation of the heap
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; i++) {
      sb.append(heap[i]).append(", ");
    }
    return sb.toString();
  }

  // Helper method to get the parent of a node
  private int parent(int pos) {
    return (pos - 1) / 2;
  }

  // Helper method to get the left child of a node
  private int leftChild(int pos) {
    return (2 * pos) + 1;
  }

  // Helper method to get the right child of a node
  private int rightChild(int pos) {
    return (2 * pos) + 2;
  }

  // Helper method to swap two elements of the heap
  private void swap(int first, int second) {
    int tmp = heap[first];
    heap[first] = heap[second];
    heap[second] = tmp;
  }

  // Ensures the heap property is maintained
  private void heapify(int pos) {
    if (!isLeaf(pos)) {
      if (heap[pos] > heap[leftChild(pos)] ||
          (rightChild(pos) < size && heap[pos] > heap[rightChild(pos)])) {

        if (rightChild(pos) < size && heap[leftChild(pos)] > heap[rightChild(pos)]) {
          swap(pos, rightChild(pos));
          heapify(rightChild(pos));
        } else {
          swap(pos, leftChild(pos));
          heapify(leftChild(pos));
        }
      }
    }
  }

  // Checks if the given position is a leaf
  private boolean isLeaf(int pos) {
    return pos >= (size / 2) && pos < size;
  }
}
