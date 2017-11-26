package org.baali.utils;

public class StringUtils
{
    public static boolean isBlank(String string)
    {
        if(string == null || string.trim().length() < 1)
            return true;

        return false;

    }
}
