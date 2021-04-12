import java.util.ArrayList;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * A class to hold details of audio files.
 * 
 * @author Julian Canepa
 * @version Feb 11,2021
 */
public class MusicOrganizer
{
    private ArrayList<String> files;
    private MusicPlayer player;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles()
    {
        for(String filename : files) {
            System.out.println(filename);
        }
    }

    /**
     * List the names of files matching the given search string.
     * @param searchString The string to match.
     */
    public void listMatching(String searchString)
    {
        for(String filename : files) {
            if(filename.contains(searchString)) {
                // A match.
                System.out.println(filename);
            }
        }
    }

    /**
     * Find the index of the first file matching the given
     * search string.
     * @param searchString The string to match.
     * @return The index of the first occurrence, or -1 if
     *         no match is found.
     */
    public int findFirst(String searchString)
    {
        int index = 0;
        int filesCount = files.size();
        boolean searching = true;

        /**
        while (searching && index < filesCount) {
            String filename = files.get(index);

            if (filename.contains(searchString)) {
                searching = false;
            } else {
                index++;
            }
        }
        */
       
        do {
            String filename = files.get(index);

            if (filename.contains(searchString)) {
                searching = false;
            } else {
                index++;
            }
        } while (searching && index < filesCount);

        if (searching) {
            // We didn't find it, return an invalid index.
            return -1;
        } else {
            return index;
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }
}
