package com.example.android.jokesvisualizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    public static final String JOKE_EXTRA_KEY = "joke_text_key";
    private String mJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        if (null == savedInstanceState) {
            getJokeFromIntent();
        } else {
            restoreInstanceState(savedInstanceState);
        }

        TextView jokeView = findViewById(R.id.tv_joke);
        jokeView.setText(mJoke);
    }

    private void getJokeFromIntent() {
        if (getIntent().hasExtra(JOKE_EXTRA_KEY)) {
            mJoke = getIntent().getStringExtra(JOKE_EXTRA_KEY);
        }
    }

    private void restoreInstanceState(Bundle inState) {
        mJoke = inState.getString(JOKE_EXTRA_KEY);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(JOKE_EXTRA_KEY, mJoke);
    }
}
