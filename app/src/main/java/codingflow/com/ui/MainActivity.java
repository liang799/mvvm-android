package codingflow.com.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import codingflow.com.NoteAdapter;
import codingflow.com.R;
import codingflow.com.data.room.Note;

public class MainActivity extends AppCompatActivity {
    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        NoteAdapter noteAdapter = new NoteAdapter();
        recyclerView.setAdapter(noteAdapter);

//        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
//        noteViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
//                .get(LoginViewModel.class);

        // Retrieving View Model and attaching observer to live data
        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class); // Ask Android system for new model (will provide if already exists, if not create an object)
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {// this -> current activity
            @Override
            public void onChanged(List<Note> notes) {
                noteAdapter.setNotes(notes);
//                Toast.makeText(MainActivity.this, "onChanged", Toast.LENGTH_SHORT).show();
            }
        });
    }
}