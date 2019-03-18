package com.stachera.justyna.converters;

import com.stachera.justyna.json.JsonConverter;
import com.stachera.justyna.modules.Clients;

/**
 * Developed by Justyna Stachera on 22.02.2019.
 * Package name: com.stachera.justyna.converters
 * Last modified 20:40.
 * Copyright (c) 2019. All rights reserved.
 */
public class ClientsJsonConverter extends JsonConverter<Clients>
{
    public ClientsJsonConverter(final String jsonFileName)
    {
        super(jsonFileName);
    }
}
