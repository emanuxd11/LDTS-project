package org.l11gr05.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> entries;
    private int currentEntry = 0;

    public Menu() {
        this.entries = Arrays.asList("PLAY", "QUIT");
    }

    public List<String> getEntries() {
        return this.entries;
    }

    public int getEntriesLen() {
        return this.entries.size();
    }

    public boolean isSelected(int i) {
        return i == currentEntry;
    }

    public void previousEntry(){
        if(currentEntry > 0){
            currentEntry--;
        }
    }

    public void nextEntry(){
        if (currentEntry < this.entries.size()-1){
            currentEntry++;
        }
    }

    public String getEntry(int i) {
        return this.entries.get(i);
    }

    public boolean exitSelected() {
        return isSelected(getEntriesLen() - 1);
    }

    public boolean startSelected() {
        return isSelected(0);
    }
}
