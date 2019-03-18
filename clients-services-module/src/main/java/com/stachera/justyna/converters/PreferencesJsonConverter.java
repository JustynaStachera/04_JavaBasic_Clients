package com.stachera.justyna.converters;

import com.stachera.justyna.json.JsonConverter;
import com.stachera.justyna.modules.Preferences;

/**
 * Developed by Justyna Stachera on 22.02.2019.
 * Package name: com.stachera.justyna.converters
 * Last modified 20:40.
 * Copyright (c) 2019. All rights reserved.
 */
public class PreferencesJsonConverter extends JsonConverter<Preferences>
{
    public PreferencesJsonConverter(final String jsonFileName)
    {
        super(jsonFileName);
    }
}
