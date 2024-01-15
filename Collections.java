import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public abstract class Collections implements Comparable<Collections> {
    protected String m_title;
    protected HashMap<Content, Boolean> m_hash;
    protected ArrayList<Content> m_contentList;

    public Collections(String title) {
        m_title = title;
        m_contentList = new ArrayList<Content>();
        m_hash = new HashMap<Content, Boolean>();   
    }

    protected void shuffle() {
        Random rand = new Random();
        // System.out.println("SHUFFLE TEST");
        int randInt = rand.nextInt(m_contentList.size());
        
        Content randContent = m_contentList.get(randInt);
        if (randContent.getHasPlayed()) {
            shuffle();
        }
        else {
            randContent.play();
        }

    }
    public abstract void play();

    public int compareTo(Collections c) {
        
        int ret;
        if (this.m_contentList.size() < c.m_contentList.size()) {
            ret = -1;
        }
        else if (this.m_contentList.size() > c.m_contentList.size()) {
            ret = 1;
        }
        else {
            ret = 0;
        }
        return ret;
    }
    
    public String toString() {
        String s = "" + m_title;
        s += " - Contents: \n";
        s += "-------------------------------------\n";
        for (Content c : m_contentList) {
            s += c.getInfo() + "\n";
        }

        return s;
    }
    public String getTitle() {
        return m_title;
    }
}