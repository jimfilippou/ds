import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        ArrayList<Song> list = new ArrayList<Song>();
        QuickSort qs = new QuickSort();
        int linesMet = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("songs.txt"));
            try {
                StringBuilder sb = new StringBuilder();
                try {
                    while (true) {
                        String line = br.readLine();
                        if (line == null)
                            break;
                        linesMet++;
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
                        list.add(song);
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }
            } finally {
                br.close();
                int[] arr = new int[linesMet];
                for (int i = 0; i < list.size(); i++) {
                    arr[i] = list.get(i).likes;
                }
                qs.quickSort(arr, 0, arr.length - 1);
                for (int var : arr) {
                    System.out.println(var);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}