package com.astrelion.Vanillapp.util;

import java.util.Random;

public class Util
{
    public static final long TICKS_PER_SECOND = 20L;
    public static final long TICKS_PER_MINUTE = TICKS_PER_SECOND * 60L;
    public static final long TICKS_PER_HOUR = TICKS_PER_MINUTE * 60L;
    public static final long TICKS_PER_DAY = TICKS_PER_HOUR * 24L;

    /**
     * Converts given string to Title Case. Replaces '_' and '-' with spaces.
     * @param string string to convert to Title Case
     * @return the string in Title Case
     */
    public static String toTitleCase(String string)
    {
        StringBuilder builder = new StringBuilder();
        boolean nextWord = true;

        for (char c : string.toCharArray())
        {
            if (Character.isSpaceChar(c) || c == '_' || c == '-')
            {
                c = ' ';
                nextWord = true;
            }
            else if (nextWord)
            {
                c = Character.toTitleCase(c);
                nextWord = false;
            }

            builder.append(c);
        }

        return builder.toString();
    }

    /**
     * Observe a statistical event with given chance
     * @param chance the chance for the event to occur
     * @return true if event occurred, false otherwise
     */
    public static boolean observeEvent(float chance)
    {
        Random random = new Random();
        return observeEvent(chance, random);
    }

    /**
     * Observe a statistical event with given chance
     * @param chance the chance for the event to occur
     * @param random optional Random generator
     * @return true if event occurred, false otherwise
     */
    public static boolean observeEvent(float chance, Random random)
    {
        return (random.nextFloat() * (1.0f - 0.01f)) + 0.01f <= chance;
    }
}
