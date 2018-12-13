import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        ArrayList<Song> list = new ArrayList<Song>();
        QuickSort qs = new QuickSort();
        Scanner reader = new Scanner(System.in);
        System.out.println("How many best songs to print?");
        int n = reader.nextInt();
        reader.close();
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
                        list.add(song);
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }
            } finally {
                br.close();
                Song[] arr = new Song[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    arr[i] = list.get(i);
                }
                qs.quickSort(arr, 0, arr.length - 1);
                for (int i = 0; i < n; i++) {
                    System.out.println(arr[i].id + " " + arr[i].title + " " + arr[i].likes);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}