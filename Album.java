import java.util.ArrayList;

public class Album extends Collections {
    private ArrayList<Song> m_album;

    public Album(String title, ArrayList<Content> collection) {
        super(title);
        m_album = new ArrayList<Song>();

        for (Content c : collection) {
            if (c instanceof Song) {
                Song s = (Song) c;
                m_album.add(s);
            }
        }
    }

    public void play() {
        for (Song s : m_album) {
            s.play();
        }
    }

    public String toString() {
        String s = "" + m_title;
        s += " - Songs: \n";
        s += "-------------------------------------\n";
        for (Content c : m_album) {
            s += c.getInfo() + "\n";
        }

        return s;
    }
}