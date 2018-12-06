import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        ArrayList<Song> list = new ArrayList<Song>();
        list.add(new Song(114, "Fuego", 51));
        try {
            BufferedReader br = new BufferedReader(new FileReader("songs.txt"));
            try {
                StringBuilder sb = new StringBuilder();
                try {
                    String line = br.readLine();
                    while (line != null) {
                        sb.append(line);
                        sb.append(System.lineSeparator());
                        line = br.readLine();
                        int id = Integer.parseInt(line.split(" ")[0]);
                        String title = line.split(" ")[1];
                        int likes = Integer.parseInt(line.split(" ")[2]);
                        Song song = new Song(id, title, likes);
                        list.add(song);
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }
            } finally {
                br.close();
                for (Song s : list) {
                    System.out.println(s.title);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}