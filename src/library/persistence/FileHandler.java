package library.persistence;

import library.LibraryManager;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import media.Book;
import media.MediaItem;
import java.io.IOException;


public class FileHandler {
    public void saveCatalog(LibraryManager manager, String path) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (MediaItem item : manager.getCatalog()) {
                writer.write(item.getId() + "," + item.getTitle() + "," + item.getGenre());
                writer.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadCatalog(LibraryManager manager, String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                String id = parts[0]; 
                String title = parts[1];
                String genre = parts[2];

                
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
