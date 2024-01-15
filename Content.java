public abstract class Content implements Comparable<Content> {
    protected String m_title;
    protected String m_artist;
    protected int m_timesStreamed;
    protected boolean m_hasPlayed;

    public Content(String title, String artist) {
        m_title = title;
        m_artist = artist;
        m_timesStreamed = 0;
        m_hasPlayed = false;
    }
  
    public abstract void play();

    public int compareTo(Content c) {
        int ret;
        if (this.m_timesStreamed > c.m_timesStreamed) {
            ret = 1;
        }
        else if (this.m_timesStreamed < c.m_timesStreamed) {
            ret = -1;
        }
        else {
            ret = 0;
        }

        return ret;
    }

    public String toString() {
        String s = "" + m_title;

        return s;
    }
    public boolean getHasPlayed() {
        return m_hasPlayed;
    }
    public void setHasPlayedFalse() {
        m_hasPlayed = false;
    }

    public abstract String getInfo();
  }