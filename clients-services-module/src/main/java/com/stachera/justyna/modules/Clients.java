package com.stachera.justyna.modules;

import com.stachera.justyna.classes.Client;
import com.stachera.justyna.converters.ClientsJsonConverter;
import com.stachera.justyna.utils.CustomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Developed by Justyna Stachera on 22.02.2019.
 * Package name: com.stachera.justyna.modules
 * Last modified 21:14.
 * Copyright (c) 2019. All rights reserved.
 */
public class Clients
{
    private final List<Client> clients = new ArrayList<>();

    public Clients()
    {
    }

    public Clients(final String jsonFileName)
    {
        this.clients.addAll(new ClientsJsonConverter(CustomUtils.prepareFilePath(jsonFileName)).convert().getClients());
    }

    public List<Client> getClients()
    {
        return clients;
    }

    public void setClients(List<Client> clients)
    {
        this.clients.clear();
        this.clients.addAll(clients);
    }

    @Override
    public String toString()
    {
        return "Clients{" + "clients=" + clients + '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clients clients1 = (Clients) o;
        return Objects.equals(clients, clients1.clients);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(clients);
    }
}
