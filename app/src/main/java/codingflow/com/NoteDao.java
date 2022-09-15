package codingflow.com;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao // Data Access Object
public interface NoteDao { // Room will generate all the necessary code
    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    @Query("SELECT * FROM note_table ORDER BY priority DESC")
//    List<Note> getAllNotes();
    LiveData<List<Note>> getAllNotes(); // UI can now observe (as soon as got changed in note_table, will auto update)
}
