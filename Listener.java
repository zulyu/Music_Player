// import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

public class Listener extends Accounts {
    protected ArrayList<Content> m_favorites;
    public Listener(int id) {
        super(id);
        m_favorites = new ArrayList<Content>();
    }

    public void favorite(Content content) {
        m_favorites.add(content);
    }

    public String toString() {
        // Sorting in toString for now for easy debugging
        Collections.sort(m_favorites);
        String s = super.toString();
        // s += "Favorites: " + m_favorites.toString() + "\n"; 

        return s;
    }
    public String getFavorites() {
        return m_favorites.toString();
    }

    public int getId() {
        return 0;
    }
}