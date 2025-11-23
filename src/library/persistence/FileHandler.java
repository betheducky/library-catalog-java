package library.persistence;

import media.MediaItem;
import media.Book;
import media.Movie;
import media.AudioBook;
import library.LibraryManager;
import library.exceptions.InvalidDataException;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;


public class FileHandler {
    public void saveCatalog(LibraryManager manager, String path) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (MediaItem item : manager.getCatalog()) {
                writer.write(item.serialize());
                writer.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<MediaItem> loadCatalog(String path) throws InvalidDataException, IOException {
        List<MediaItem> loadedCatalog = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line; 
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                String itemType = parts[0];
                switch (itemType) {
                    case "BOOK":
                        loadedCatalog.add(new Book(parts[1], parts[2], parts[3], parts[4], Integer.parseInt(parts[5])));
                        break;
                    case "MOVIE":
                        loadedCatalog.add(new Movie(parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), parts[5], Double.parseDouble(parts[6])));
                        break;
                    case "AUDIOBOOK":
                        loadedCatalog.add(new AudioBook(parts[1], parts[2], parts[3], parts[4], Integer.parseInt(parts[5])));
                        break;
                    default:
                        throw new InvalidDataException(itemType + "is not a valid MediaItem type");
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return loadedCatalog;
    }
}
