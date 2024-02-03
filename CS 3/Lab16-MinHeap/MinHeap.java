import java.util.*;
import java.io.*;

public class MinHeap
{
   private static final int DEFAULT_CAPACITY = 8;
   private Integer[] heap;
   private int size; 
   
   
   public MinHeap()
   {
      heap = new Integer[DEFAULT_CAPACITY];
      size = 0;
   }
   
   public MinHeap(int capacity)
   {
      heap = new Integer[capacity];
      size = 0;
   }
   
   public int getSize() { return size; }
   
   public boolean isEmpty() { return size == 0; }
   
   public int peekMinimum() { return heap[1]; }
   
   public int getLeftChildIndex(int index) { return index * 2; }
   
   public int getRightChildIndex(int index) { return getLeftChildIndex(index) + 1; }
   
   public int getParentIndex(int index) { return index / 2; }
   
   private void doubleCapacity()
   {
      Integer[] temp = new Integer[size * 2];
      for (int i = 1; i < heap.length; i++)
      {
         temp[i] = heap[i];
      }
      heap = temp;
   }
   
   public void insert(int value)
   {
      if (size == heap.length) doubleCapacity();
      
      heap[size] = value;
      bubbleUp(size);
      size++;
   }
   
   private void bubbleUp(int index)
   {
      if (index <= 1) return;
      
      int parentIndex = getParentIndex(index);
      
      if (parentIndex < 1) return;
      
      int current = heap[index];
      int parent = heap[parentIndex];
      
      if (current < parent)
      {
         heap[index] = parent;
         heap[parentIndex] = current;  
      }
      
      bubbleUp(parentIndex); 
   }
   
   public int popMinimum()
   {
      int ret = heap[1];
      
      siftDown(1);
   }
   
   private void siftDown(int index)
   {
      if (index >= size) return;
      if (index < 1) return;
      
      int current = heap[index];
      
      int leftIndex = getleftChildIndex(index);
      int rightIndex = getRightChildIndex(index);
      
      int leftChild = Integer.MAX_LIMIT;
      int rightChild = Integer.MAX_LIMIT;
      
      if (leftIndex < size) leftChild = heap[leftIndex];
      if (rightIndex < size) rightChild = heap[rightIndex];
      
      
      
   }
   
}