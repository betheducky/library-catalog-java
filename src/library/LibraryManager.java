package library;

import media.MediaItem;

import java.util.ArrayList;
import java.util.List;

public class LibraryManager {

    private List<MediaItem> catalog;

    public LibraryManager(List<MediaItem> catalog) {
        this.catalog = catalog;
    }

    public void addItem(MediaItem item) {
        catalog.add(item);
        System.out.println(item + " has been added to catalog.");
    }

    public void removeItem(String itemId) {
       MediaItem selectedItem = findById(itemId);
       catalog.remove(selectedItem);
       System.out.println(selectedItem + " has been removed from catalog.");
    }

    public MediaItem findById(String id) {
        for(MediaItem item : catalog) {
            if(item.getId().equals(id)){
                return item;
            }
        }
        return null;
    }

    public List<MediaItem> searchByTitle(String title) {
        List<MediaItem> searchResult = new ArrayList<MediaItem>();
        for(MediaItem item : catalog) {
            if(item.getTitle().contains(title)){
                searchResult.add(item);
            }
        }
        return searchResult;
    }

    public List<MediaItem> filterByGenre(String genre) {
        List<MediaItem> filterResult = new ArrayList<MediaItem>();
        for(MediaItem item : catalog) {
            if(item.getGenre().equals(genre)){
                filterResult.add(item);
            }
        }
        return filterResult;
    }

    
}
