package com.udacity.gradle.builditbigger;

/**
 *   Callback for returning joke to display
 */

public interface ShowCallback
{
    /**
     *   Returns a joke for display
     *
     *   @param joke joke string
     */

    public void show(String joke);
}
