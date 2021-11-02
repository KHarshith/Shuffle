import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 public class Shuffle {

    public static void main(String args[]) throws FileNotFoundException {
        File file = new File("shuffle.dat");
        Scanner console = new Scanner(file);
        while(console.hasNext()){
            int a = console.nextInt();
            if (a ==0){
                break;
            }
            RingBuffer discards = new RingBuffer(a);
            RingBuffer cards = new RingBuffer(a);
            for (int i = 1; i <= a; i++){
                cards.enqueue(i);
            }
            while (cards.size() >= 2){
                discards.enqueue(cards.dequeue());
                cards.enqueue(cards.dequeue());
            }
            System.out.print("Discarded cards: ");
            int size = discards.size();
            for (int i = 0; i < size-1; i++){
                System.out.print((int)discards.dequeue() + ", ");
            }
            if(discards.size() >= 1)
            {
                System.out.print((int)discards.dequeue());
            }
            System.out.println();
            System.out.print("Remaining card: ");
            System.out.println((int)cards.dequeue());
        }
       
    }
}