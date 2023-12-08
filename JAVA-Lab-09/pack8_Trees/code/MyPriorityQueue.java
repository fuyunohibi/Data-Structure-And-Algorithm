package code;

public class MyPriorityQueue implements MyQueueInterface {
    private MyMinHeap heap;

    public String toString() {
      return heap.toString();
    }

    // Enqueues a new integer into the queue.
    @Override
    public void enqueue(int d) {
        if (isFull()) {
            throw new RuntimeException("Priority Queue is full");
        }
        heap.insert(d);
    }

    // Dequeues and returns the integer with the highest priority (i.e., the smallest integer).
    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Priority Queue is empty");
        }
        return heap.remove();
    }

    // Returns the integer with the highest priority without removing it.
    @Override
    public int front() {
        return heap.peek();
    }

    // Checks if the queue is full.
    @Override
    public boolean isFull() {
        return heap.isFull();
    }

    // Checks if the queue is empty.
    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }
}