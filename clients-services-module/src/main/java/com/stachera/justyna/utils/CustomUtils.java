package com.stachera.justyna.utils;

import java.io.File;
import java.util.regex.Matcher;

/**
 * Developed by Justyna Stachera on 25.02.2019.
 * Package name: com.stachera.justyna.utils
 * Last modified 20:29.
 * Copyright (c) 2019. All rights reserved.
 */
public class CustomUtils
{
    public static String prepareFilePath(final String filePath)
    {
        return new File("").getAbsolutePath()
                .concat(filePath.replaceAll("/", Matcher.quoteReplacement(File.separator)));
    }
}
