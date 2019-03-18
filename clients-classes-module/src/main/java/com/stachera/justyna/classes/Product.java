package com.stachera.justyna.classes;

import com.stachera.justyna.enums.Category;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Developed by Justyna Stachera on 22.02.2019.
 * Package name: com.stachera.justyna.classes
 * Last modified 20:48.
 * Copyright (c) 2019. All rights reserved.
 */
public class Product
{
    private String name;
    private int amount;
    private BigDecimal price;
    private Category category;

    public static ProductBuilder builder()
    {
        return new ProductBuilder();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
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
        return "Product{" + "name='" + name + '\'' + ", amount=" + amount + ", price=" + price + ", category=" +
                category + '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return amount == product.amount && Objects.equals(name, product.name) && Objects.equals(price, product.price) &&
                category == product.category;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, amount, price, category);
    }

    public static final class ProductBuilder
    {
        private String name;
        private int amount;
        private BigDecimal price;
        private Category category;

        public ProductBuilder name(String name)
        {
            this.name = name;
            return this;
        }

        public ProductBuilder amount(int amount)
        {
            this.amount = amount;
            return this;
        }

        public ProductBuilder price(BigDecimal price)
        {
            this.price = price;
            return this;
        }

        public ProductBuilder category(Category category)
        {
            this.category = category;
            return this;
        }

        public Product build()
        {
            Product product = new Product();
            product.setName(name);
            product.setAmount(amount);
            product.setPrice(price);
            product.setCategory(category);
            return product;
        }
    }
}
