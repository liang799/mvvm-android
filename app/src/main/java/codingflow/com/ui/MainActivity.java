package codingflow.com.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import codingflow.com.R;

public class MainActivity extends AppCompatActivity {
    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        noteViewModel = ViewModelProviders.of(this).
    }
}