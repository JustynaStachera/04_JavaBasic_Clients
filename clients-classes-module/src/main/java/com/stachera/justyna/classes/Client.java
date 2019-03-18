package com.stachera.justyna.classes;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * Developed by Justyna Stachera on 22.02.2019.
 * Package name: com.stachera.justyna.classes
 * Last modified 20:48.
 * Copyright (c) 2019. All rights reserved.
 */
public class Client
{
    private String name;
    private String surname;
    private int age;
    private BigDecimal money;
    private List<Integer> preferences;

    public static ClientBuilder builder()
    {
        return new ClientBuilder();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public BigDecimal getMoney()
    {
        return money;
    }

    public void setMoney(BigDecimal money)
    {
        this.money = money;
    }

    public List<Integer> getPreferences()
    {
        return preferences;
    }

    public void setPreferences(List<Integer> preferences)
    {
        this.preferences = preferences;
    }

    @Override
    public String toString()
    {
        return "Client{" + "name='" + name + '\'' + ", surname='" + surname + '\'' + ", age=" + age + ", money=" +
                money + ", preferences=" + preferences + '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return age == client.age && Objects.equals(name, client.name) && Objects.equals(surname, client.surname) &&
                Objects.equals(money, client.money) && Objects.equals(preferences, client.preferences);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, surname, age, money, preferences);
    }

    public static final class ClientBuilder
    {
        private String name;
        private String surname;
        private int age;
        private BigDecimal money;
        private List<Integer> preferences;

        public ClientBuilder name(String name)
        {
            this.name = name;
            return this;
        }

        public ClientBuilder surname(String surname)
        {
            this.surname = surname;
            return this;
        }

        public ClientBuilder age(int age)
        {
            this.age = age;
            return this;
        }

        public ClientBuilder money(BigDecimal money)
        {
            this.money = money;
            return this;
        }

        public ClientBuilder preferences(List<Integer> preferences)
        {
            this.preferences = preferences;
            return this;
        }

        public Client build()
        {
            Client client = new Client();
            client.money = this.money;
            client.preferences = this.preferences;
            client.name = this.name;
            client.age = this.age;
            client.surname = this.surname;
            return client;
        }
    }
}
