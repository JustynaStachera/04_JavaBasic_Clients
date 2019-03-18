package com.stachera.justyna.converters;

import com.stachera.justyna.json.JsonConverter;
import com.stachera.justyna.modules.Products;

/**
 * Developed by Justyna Stachera on 22.02.2019.
 * Package name: com.stachera.justyna.converters
 * Last modified 20:41.
 * Copyright (c) 2019. All rights reserved.
 */
public class ProductsJsonConverter extends JsonConverter<Products>
{
    public ProductsJsonConverter(final String jsonFileName)
    {
        super(jsonFileName);
    }
}
