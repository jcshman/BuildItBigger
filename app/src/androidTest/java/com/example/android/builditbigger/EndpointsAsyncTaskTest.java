package com.example.android.builditbigger;

import android.os.AsyncTask;
import android.support.test.rule.UiThreadTestRule;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.ShowCallback;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotEquals;

/**
 *   Test for EndpointsAsyncTask
 */

public class EndpointsAsyncTaskTest extends UiThreadTestRule implements ShowCallback
{
    private String joke = "";
    private CountDownLatch latch = new CountDownLatch(1);

    /**
     *    Retrieves joke string and tests that it is not an empty string;
     *    also fails if timeout exceeds 10 sec
     *
     *    @throws Exception
     */

    @Test
    public void retrievedJokeStringIsNotEmpty() throws Exception
    {
        AsyncTask task = new EndpointsAsyncTask(this);
        task.execute();

        // waits for joke via latch
        this.latch.await(10, TimeUnit.SECONDS);

        assertNotEquals(this.joke, "");
    }

    /**
     *   Returns the joke to be displayed
     *
     *   @param joke joke string
     */

    public void show(String joke)
    {
        this.joke = joke;

        // notifies testing thread to continue
        this.latch.countDown();
    }
}
