public abstract class Accounts {
    private int m_ID;
    
    public Accounts(int id) {
        m_ID = id;
    }

    public String toString() {
        String s = "User ID: " + m_ID + "\n";
        
        return s;
    }
}