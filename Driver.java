import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Collections;

import java.io.*;

public class Driver {
    public static void main(String[] args) {
        /*REAL DRIVER CODE STARTS HERE */
        try {
            getUserInput();
        }
        catch (InputMismatchException ime) {
            System.err.println("Scanner broken through false input...closing program");
        }
        catch (Exception e) {
            System.err.println("OTHER EXCEPTION");
            // e.printStackTrace();
        }
    }

    public static void getUserInput() {
        /* GLOBAL PLAYLISTS AND ALBUMS THAT EVERY LISTENER WILL "HAVE" */
        /* All the playlists and album code will be used in case programmer wants to add more Contents or Playlists/Albums to the ArrayLists */
        Playlist playlist1 = new Playlist("Car Playlist");
        playlist1.add(new Song("Enchanted", "Taylor Swift"));
        playlist1.add(new Song("La Zona", "Bad Bunny"));
        playlist1.add(new Podcast("SuburbTalks", "Nick Grajeda", 1));

        Playlist playlist2 = new Playlist("Study Playlist");
        playlist2.add(new Song("Fur Elise", "Betoven"));
        playlist2.add(new Podcast("Duolingo Spanish Podcast", "Duolingo", 2));

        ArrayList<Content> albumContents = new ArrayList<>();
        albumContents.add(new Song("Good Morning", "Kanye"));
        albumContents.add(new Song("Champion", "Kanye"));

        Album album1 = new Album("Graduation", albumContents);

        ArrayList<Playlist> playlists = new ArrayList<>();
        playlists.add(playlist1);
        playlists.add(playlist2);

        ArrayList<Album> albums = new ArrayList<>();
        albums.add(album1);

        ///
        ArrayList<Listener> users = new ArrayList<Listener>();
        Scanner scanner = new Scanner(System.in);
        // Input variables for different branches of main, menuInput is it's own input while caseInput and ListenerSelection are used when picking out playlists/Listeners
        int menuInput, listenerSelection, caseInput = 0;
        do {
            // prints selection menu at the beginning
            printMenu();
            menuInput = scanner.nextInt();
            // checks user input
            switch (menuInput) {
                // Creates a listener account with an ID as input
                case 1:
                    try {
                        System.out.println("Welcome, let's create an account!");
                        System.out.println();
                        System.out.println("Enter an ID: ");

                        int id = scanner.nextInt();
                        Listener listener = new Listener(id);
                        users.add(listener);

                        System.out.println("Congrats! Account created successfully!");
                        System.out.println("Here are your current stats: ");
                        System.out.println();

                        System.out.println(listener.toString());
                        break;
                    }
                    catch (InputMismatchException ime) {
                        System.err.println("Wrong type used in expression call");
                        break;
                    }
                // Displays all the global playlists and albums
                case 2:
                    Collections.sort(playlists);
                    Collections.sort(albums);
                    System.out.println("Here are your playlists and albums: ");    
                    System.out.println();

                    System.out.println("Playlists:");
                    for (Playlist playlist : playlists) {
                        System.out.println(playlist.toString());

                    }
                    System.out.println("Albums:");
                    for (Album album : albums) {
                        System.out.println(album.toString());
                    }
                    break;
                // Adds a song to a desired playlist
                case 3:
                    try {
                        System.out.println("For which playlist do you want to add a song into?");
                        for (int i = 0; i < playlists.size(); i++) {
                            System.out.print("Enter " + i + " for " + playlists.get(i));
                        }
                        caseInput = scanner.nextInt();
                        System.out.print("Enter a Song title and Song artist separated by spaces: ");
                        playlists.get(caseInput).add(new Song(scanner.next(), scanner.next()));
                    }
                    catch (InputMismatchException ime) {
                        System.err.println("Unexpected type used during input ask");
                        break;
                        // ime.printStackTrace();
                    }
                    catch (IndexOutOfBoundsException ioobe) {
                        System.err.println("Incorrect index given");
                        break;
                    }
                    catch (Exception e) {
                        System.err.println("OTHER ERROR");
                        break;
                        // e.printStackTrace();
                    }
                    break;
                // Plays a desired album/playlist
                case 4:
                    try {
                        if (users.isEmpty()) {
                            System.out.println("Please create a Listener account before proceding!!!");
                        }
                        else {
                            System.out.println("For which user?");
                            for (int i = 0; i < users.size(); i++) {
                                System.out.print("Enter " + i + " for " + users.get(i).toString());
                            }
                            listenerSelection = scanner.nextInt();
                            System.out.println("Do you want to play a playlist or album?");
                            System.out.println("Enter 1 for a Playlist");
                            System.out.println("Enter 2 for an Album");
                            caseInput = scanner.nextInt();
                            if (caseInput == 1) {
                                System.out.println("Which playlist do you want to play?");
                                for (int i = 0; i < playlists.size(); i++) {
                                    System.out.print("Enter " + i + " for " + playlists.get(i));
                                }
                                caseInput = scanner.nextInt();
                                playlists.get(caseInput).play();
                            }
                            else if (caseInput == 2) {
                                System.out.println("Playing " + album1.getTitle());
                                album1.play();
                            }
                        }
                    }
                    catch (InputMismatchException ime) {
                        System.err.println("Unexpected type used during input ask");
                        break;
                        // ime.printStackTrace();
                    }
                    catch (IndexOutOfBoundsException ioobe) {
                        System.err.println("Incorrect index given");
                        break;
                    }
                    catch (Exception e) {
                        System.err.println("OTHER ERROR");
                        break;
                        // e.printStackTrace();
                    }
                    break;
                // Adds a Song or Podcast to m_favorites 
                case 5:
                    try {
                        if (users.isEmpty()) {
                            System.out.println("Please create a Listener account before proceding!!!");
                        }
                        else{
                            System.out.println("For which user?");
                            for (int i = 0; i < users.size(); i++) {
                                System.out.println("Enter " + i + " for " + users.get(i).toString());
                            }
                            listenerSelection = scanner.nextInt();
                            System.out.println("Do you want to add a Podcast or Song to your favorites?");
                            System.out.println("Enter 1 for a Song");
                            System.out.println("Enter 2 for Podcast");
                            caseInput = scanner.nextInt();
                            if (caseInput == 1) {
                                System.out.print("Please enter a Song title and Song artist name separated by a space: ");
                                users.get(listenerSelection).favorite(new Song(scanner.next(), scanner.next()));
                            }
                            else if (caseInput == 2) {
                                System.out.println("Please enter a Podcast title, Podcast artist name, and episode number separated by a space: ");
                                users.get(0).favorite(new Podcast(scanner.next(), scanner.next(), scanner.nextInt()));
                            } 
                            System.out.println("Favorites: " + users.get(0).getFavorites());
                        }
                        
                    }
                    catch (InputMismatchException ime) {
                        System.err.println("Unexpected type used during input ask");
                        break;
                        // ime.printStackTrace();
                    }
                    catch (IndexOutOfBoundsException ioobe) {
                        System.err.println("Incorrect index given");
                        break;
                    }
                    catch (Exception e) {
                        System.err.println("OTHER ERROR");
                        break;
                        // e.printStackTrace();
                    }
                    break;
                // Writes all the songs/podcasts in favorites to a file
                case 6:
                    try {
                        if (users.isEmpty()) {
                            System.out.println("Please create a Listener account before proceding!!!");
                        }
                        else {
                        System.out.println("For which user?");
                        for (int i = 0; i < users.size(); i++) {
                            System.out.println("Enter " + i + " for " + users.get(i).toString());
                        }
                        listenerSelection = scanner.nextInt();
                        PrintWriter pw = new PrintWriter(new FileWriter("Favorites.txt"));
                        pw.println("Favorite content from " + users.get(listenerSelection));
                        for (Content c : users.get(listenerSelection).m_favorites) {
                            pw.println(c.toString());
                        }
                        System.out.println("File Write Successful");
                        pw.close();
                        }
                    }
                    catch (IndexOutOfBoundsException ioobe) {
                        System.err.println("Incorrect index");
                        break;
                        // iooe.printStackTrace();
                    }
                    catch (IOException ioe) {
                        System.err.println("IO ERROR HANDLE IMMEDIATELY");
                        ioe.printStackTrace();
                        break;
                    }
                    break;
                case 7:
                    System.out.println("Exiting.....Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (menuInput != 7);
        scanner.close();
    }
    public static void printMenu() {
        System.out.println("*  *  *  M U S I C   P L A Y E R    M E N U  *  *  *");
        System.out.println("----------------------------------------------------------------");
        System.out.println("--> Enter 1 to create a Listener Account: ");
        System.out.println("--> Enter 2 to list Playlists, Albums and their contents: ");
        System.out.println("--> Enter 3 to add songs into an existing playlist: ");
        System.out.println("--> Enter 4 to shuffle a playlist or to listen to an album: ");
        System.out.println("--> Enter 5 to add a song or podcast to favorites: ");
        System.out.println("--> Enter 6 to export your favorites out to a file: ");
        System.out.println("--> Enter 7 to exit: ");
    }
}