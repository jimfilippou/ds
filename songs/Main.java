import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
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
                    String[] data = line.split(" ");
                    System.out.println(data.length);
                    if (data.length == 3) {
                        String title = line.split(" ")[1];
                        int likes = Integer.parseInt(line.split(" ")[2]);
                    } else {
                        for (int i = 1; i < (data.length - 2); i++) {
                            String title = line.split(" ")[i];
                        }
                        System.out.println("run");
                        int likes = Integer.parseInt(line.split(" ")[data.length - 1]);
                    }

                    while (line != null) {
                        String[] data2 = line.split(" ");
                        sb.append(line);
                        sb.append(System.lineSeparator());
                        line = br.readLine();
                        int id = Integer.parseInt(line.split(" ")[0]);
                        if (data2.length == 3) {
                            String title = line.split(" ")[1];
                            int likes = Integer.parseInt(line.split(" ")[2]);
                        } else {
                            for (int i = 1; i < (data2.length - 2); i++) {
                                String title = line.split(" ")[i];
                            }
                            System.out.println("run");
                            int likes = Integer.parseInt(line.split(" ")[data.length - 1]);
                        }
                        System.out.println(data2.length);
                        // Song song = new Song(id, title, likes);
                        // list.add(song);
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }
            } finally {
                br.close();
                // for (Song s : list) {
                // System.out.println(s.likes);
                // }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}