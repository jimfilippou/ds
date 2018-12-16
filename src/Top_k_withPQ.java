import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Top_k_withPQ
 */
public class Top_k_withPQ {
    public static void main(String[] args) {
        PQ<Song> pq = new PQ<Song>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("songs.txt"));
            try {
                StringBuilder sb = new StringBuilder();
                try {
                    while (true) {
                        String line = br.readLine();
                        if (line == null)
                            break;
                        String[] data = line.split(" ");
                        String title;
                        int likes = Integer.parseInt(data[data.length - 1]);
                        int id = Integer.parseInt(data[0]);
                        if (data.length == 3) {
                            title = data[1];
                        } else {
                            for (int i = 1; i < data.length - 1; i++) {
                                sb.append(data[i]);
                                if (!(i == data.length - 2))
                                    sb.append(" ");
                            }
                            title = sb.toString();
                        }
                        sb = new StringBuilder();
                        Song song = new Song(id, title, likes);
                        pq.insert(song);
                    }
                } catch (Exception e) {
                }
            } finally {
                br.close();
                System.out.println(pq.toString());
            }
        } catch (Exception e) {
        }
    }
}