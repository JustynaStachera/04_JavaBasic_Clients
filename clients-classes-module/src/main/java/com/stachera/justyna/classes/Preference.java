package com.stachera.justyna.classes;

import com.stachera.justyna.enums.Category;

import java.util.Objects;

/**
 * Developed by Justyna Stachera on 22.02.2019.
 * Package name: com.stachera.justyna.enums
 * Last modified 20:58.
 * Copyright (c) 2019. All rights reserved.
 */
public class Preference
{
    private int id;
    private Category category;

    public static PreferenceBuilder builder()
    {
        return new PreferenceBuilder();
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    @Override
    public String toString()
    {
        return "Preference{" + "id=" + id + ", category=" + category + '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Preference that = (Preference) o;
        return id == that.id && category == that.category;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, category);
    }

    public static final class PreferenceBuilder
    {
        private int id;
        private Category category;

        public PreferenceBuilder id(int id)
        {
            this.id = id;
            return this;
        }

        public PreferenceBuilder category(Category category)
        {
            this.category = category;
            return this;
        }

        public Preference build()
        {
            Preference preference = new Preference();
            preference.id = this.id;
            preference.category = this.category;
            return preference;
        }
    }
}
