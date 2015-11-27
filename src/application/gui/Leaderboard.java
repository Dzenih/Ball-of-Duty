package application.gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import application.engine.entities.BoDCharacter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class Leaderboard extends ListView<Leaderboard.Entry>
{
    ObservableList<Entry> characters;
    Set<Entry> addedCharacters;

    Queue<Entry> removeQueue;
    Queue<Entry> addQueue;

    public class Entry
    {
        public String nickName;
        public double score;

        public Entry(String name, double score)
        {
            this.nickName = name;
            this.score = score;
        }
    }

    public Leaderboard()
    {
        removeQueue = new ConcurrentLinkedQueue<>();
        addQueue = new ConcurrentLinkedQueue<>();
        characters = FXCollections.observableArrayList();
        addedCharacters = new HashSet<>();
        setItems(characters);
    }

    @Override
    public void refresh()
    {

        while (addQueue.peek() != null)
        {
            characters.add(addQueue.poll());

        }
        while (removeQueue.peek() != null)
        {
            characters.remove(removeQueue.poll());

        }
        characters.sort((c1, c2) -> Double.compare(c2.score, c1.score));
        super.refresh();
    }

    public void addCharacter(String nickname, double score)
    {
        if (!addedCharacters.contains(nickname))
        {
            addQueue.add(nickname, score);
            addedCharacters.add(character);
        }

    }

    public void remove(BoDCharacter character)
    {
        removeQueue.add(character);
        addedCharacters.remove(character);
    }
}
