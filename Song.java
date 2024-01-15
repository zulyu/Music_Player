public class Song extends Content {

    public Song(String title, String artist) {
        super(title, artist);
    }
    
    public void play() {
        System.out.println("Song: " + m_title + " has been played");
        m_timesStreamed++;
        m_hasPlayed = true;
    }

    public String getInfo() {
        String s = "Song Title: " + m_title + "\n";
        s += "Artist: " + m_artist + "\n";
        s += "Times Streamed: " + m_timesStreamed + "\n";

        return s;
    }

    public Object getTitle() {
        return null;
    }

}