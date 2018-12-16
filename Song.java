class Song implements Comparable<Song> {

    public int id;
    public String title;
    public int likes;

    public Song(int id, String title, int likes) {
        this.id = id;
        this.title = title;
        this.likes = likes;
    }

    public int compareTo(Song k) {
        if (this.equals(k))
            return 0;
        else if (this.likes > k.likes){
            return 1;
        }
        else {
            return -1;
        }
    }

}