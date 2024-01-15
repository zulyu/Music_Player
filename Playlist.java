public class Playlist extends Collections {
    
    public Playlist(String title) {
        super(title);
    }
    
    public void play() {
        do {
            this.shuffle();
            for (Content c : m_contentList) {
                m_hash.put(c, c.getHasPlayed());
            }
        } while (m_hash.containsValue(false));

        for (Content c : m_contentList) {
            c.setHasPlayedFalse();
        }
    }

    public void add(Content c) {
        m_contentList.add(c);
    }
    public void remove(Content c) {
        m_contentList.remove(c);
    }
}