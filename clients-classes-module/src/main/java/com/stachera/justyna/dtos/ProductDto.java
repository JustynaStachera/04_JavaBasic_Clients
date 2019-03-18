package com.stachera.justyna.dtos;

import com.stachera.justyna.enums.Category;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Developed by Justyna Stachera on 18.03.2019.
 * Package name: com.stachera.justyna.dtos
 * Last modified 20:05.
 * Copyright (c) 2019. All rights reserved.
 */
public class ProductDto
{
    private String name;
    private BigDecimal price;
    private Category category;

    public ProductDto()
    {
    }

    public ProductDto(String name, BigDecimal price, Category category)
    {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
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
        return "ProductDto{" + "name='" + name + '\'' + ", price=" + price + ", category=" + category + '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(name, that.name) && Objects.equals(price, that.price) && category == that.category;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, price, category);
    }
}
