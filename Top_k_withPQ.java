

/**
 * Top_k_withPQ
 */
public class Top_k_withPQ {
    public static void main(String[] args) {
        System.out.println("yep");
        PQ<Song> pq = new PQ<Song>();
        pq.insert(new Song(1, "a", 23));
        System.out.println(pq.toString());
        pq.insert(new Song(2, "b", 24));
        System.out.println(pq.toString());
    
        pq.getMax();
        System.out.println(pq.toString());
        pq.getMax();
        System.out.println(pq.toString());
    }
}