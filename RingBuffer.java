public class RingBuffer {
  private double[] rb;          
  private int first;            
  private int last;             
  private int size;             
  

  public RingBuffer(int capacity) {
    first = 0;
    last = 0;
    size = 0;
    rb = new double[capacity];
  }
  

  public int size() {
    return size;
  }
  

  public boolean isEmpty() {
    return (size == 0);
  }
  

  public boolean isFull() {
    return (size == rb.length);
  }
  

  public void enqueue(double x) {
    

    if (isFull()) {
      throw new RuntimeException("Ring buffer overflow");
    }
    

    rb[last] = x;
    

    last++;
    

    size++;
    

    if (last >= rb.length) {
      last = 0;
    }
  }
  

  public double dequeue() {
    

    if (isEmpty()) {
      throw new RuntimeException("Ring buffer underflow");
    }
    

    double tempValue = rb[first];
    

    first++;
    

    if (first >= rb.length) {
      first = 0;
    }
    

    size--;
    

    return tempValue;
  }
  

  public double peek() {
    

    if (isEmpty()) {
      throw new RuntimeException("Ring buffer underflow");
    }
    

    return rb[first];
  }
  

  
  
}
