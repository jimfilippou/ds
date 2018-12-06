import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) {
        
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
                    String everything = sb.toString();
                    System.out.println(line);
                }
                } catch (Exception e) {
                    //TODO: handle exception
                }
            } finally {
                br.close();
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        
        
    }
}