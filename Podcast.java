public class Podcast extends Content {
    private int m_episodeNum;

    public Podcast(String title, String artist, int epNum) {
        super(title, artist);
        m_episodeNum = epNum;
    }

    public void play() {
        System.out.println(m_title + " Episode #" + m_episodeNum + " has been played");
        m_timesStreamed++;
        m_hasPlayed = true;
    }

    public String getInfo() {
        String s = "Podcast Title: " + m_title + "\n";
        s += "Artist: " + m_artist + "\n";
        s += "Episode Number: " + m_episodeNum + "\n";
        s += "Times Streamed: " + m_timesStreamed + "\n";

        return s;
    }

    public Object getTitle() {
        return null;
    }
}