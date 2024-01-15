import java.util.ArrayList;

class CollectionsData {
    public static ArrayList<Playlist> playlists = new ArrayList<>();
    public static ArrayList<Album> albums = new ArrayList<>();
    public static ArrayList<Listener> listeners = new ArrayList<>();
    public static ArrayList<Song> songs = new ArrayList<>();
    public static ArrayList<Podcast> podcasts = new ArrayList<>();

    public static Playlist findPlaylist(String name) {
        for (Playlist playlist : playlists) {
            if (playlist.getTitle().equals(name)) {
                return playlist;
            }
        }
        return null;
    }

    public static Album findAlbum(String name) {
        for (Album album : albums) {
            if (album.getTitle().equals(name)) {
                return album;
            }
        }
        return null;
    }

    public static Listener findListener(int listenerId) {
        for (Listener listener : listeners) {
            if (listener.getId() == listenerId) {
                return listener;
            }
        }
        return null;
    }

    public static Song findSong(String name) {
        for (Song song : songs) {
            if (song.getTitle().equals(name)) {
                return song;
            }
        }
        return null;
    }

    public static Podcast findPodcast(String name) {
        for (Podcast podcast : podcasts) {
            if (podcast.getTitle().equals(name)) {
                return podcast;
            }
        }
        return null;
    }

    public static Content findContent(String name) {
        Content content = findSong(name);
        if (content != null) {
            return content;
        }

        content = findPodcast(name);
        if (content != null) {
            return content;
        }

        return null;
    }
}

class FileManager {
    public static void exportFavorites(Listener listener, String fileName) {
        // Logic to export favorites to file
        System.out.println("Exporting favorites to file: " + fileName);
    }
}