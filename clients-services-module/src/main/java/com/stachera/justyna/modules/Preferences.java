package com.stachera.justyna.modules;

import com.stachera.justyna.classes.Preference;
import com.stachera.justyna.converters.PreferencesJsonConverter;
import com.stachera.justyna.utils.CustomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Developed by Justyna Stachera on 22.02.2019.
 * Package name: com.stachera.justyna.modules
 * Last modified 21:13.
 * Copyright (c) 2019. All rights reserved.
 */
public class Preferences
{
    private final List<Preference> preferences = new ArrayList<>();

    public Preferences()
    {
    }

    public Preferences(final String jsonFilePath)
    {
        preferences.addAll(new PreferencesJsonConverter(CustomUtils.prepareFilePath(jsonFilePath)).convert()
                .getPreferences());
    }

    public List<Preference> getPreferences()
    {
        return preferences;
    }

    public void setPreferences(List<Preference> preferences)
    {
        this.preferences.clear();
        this.preferences.addAll(preferences);
    }

    @Override
    public String toString()
    {
        return "Preferences{" + "preferences=" + preferences + '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Preferences that = (Preferences) o;
        return Objects.equals(preferences, that.preferences);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(preferences);
    }
}
