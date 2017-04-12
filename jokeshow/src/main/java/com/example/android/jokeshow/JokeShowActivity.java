package com.example.android.jokeshow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 *   Activity for displaying a joke
 */

public class JokeShowActivity extends AppCompatActivity
{
    /* Intent key */

    public static final String JOKE_KEY = "joke";

    /**
     *    Displays joke provided by intent
     *
     *    @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_joke_show);

        Intent intent = getIntent();
        String joke = intent.getStringExtra(JOKE_KEY);

        Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();
    }
}
