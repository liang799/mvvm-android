package codingflow.com.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import codingflow.com.R;
import codingflow.com.data.room.Note;

public class MainActivity extends AppCompatActivity {
    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
//        noteViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
//                .get(LoginViewModel.class);

        // Retrieving View Model and attaching observer to live data
        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class); // Ask Android system for new model (will provide if already exists, if not create an object)
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {// this -> current activity
            @Override
            public void onChanged(List<Note> notes) {
                // TODO: update recycler view
                Toast.makeText(MainActivity.this, "onChanged", Toast.LENGTH_SHORT).show();
            }
        });
    }
}