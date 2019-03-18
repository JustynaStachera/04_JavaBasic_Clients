package com.stachera.justyna.modules;

import com.stachera.justyna.classes.Product;
import com.stachera.justyna.converters.ProductsJsonConverter;
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
public class Products
{
    private final List<Product> products = new ArrayList<>();

    public Products()
    {
    }

    public Products(final String jsonFilePath)
    {
        products.addAll(new ProductsJsonConverter(CustomUtils.prepareFilePath(jsonFilePath)).convert().getProducts());
    }

    public List<Product> getProducts()
    {
        return products;
    }

    public void setProducts(List<Product> products)
    {
        this.products.clear();
        this.products.addAll(products);
    }

    @Override
    public String toString()
    {
        return "Products{" + "products=" + products + '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products1 = (Products) o;
        return Objects.equals(products, products1.products);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(products);
    }
}
