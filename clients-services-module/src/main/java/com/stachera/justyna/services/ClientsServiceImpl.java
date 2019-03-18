package com.stachera.justyna.services;

import com.stachera.justyna.classes.Client;
import com.stachera.justyna.classes.Preference;
import com.stachera.justyna.classes.Product;
import com.stachera.justyna.dtos.ProductDto;
import com.stachera.justyna.enums.Category;
import com.stachera.justyna.modules.Clients;
import com.stachera.justyna.modules.Preferences;
import com.stachera.justyna.modules.Products;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Developed by Justyna Stachera on 22.02.2019.
 * Package name: com.stachera.justyna.services
 * Last modified 21:40.
 * Copyright (c) 2019. All rights reserved.
 */
public class ClientsServiceImpl
{
    private final Map<Client, List<Product>> clientProductsMap = new HashMap<>();

    private final Map<Integer, Category> preferenceMap = new HashMap<>();

    public ClientsServiceImpl(final String clientsFilePath, final String productsFilePath,
                              final String preferencesFilePath)
    {
        List<Client> clients = new Clients(clientsFilePath).getClients();
        List<Preference> preferences = new Preferences(preferencesFilePath).getPreferences();
        List<Product> products = new Products(productsFilePath).getProducts();

        preferenceMap
                .putAll(preferences.stream().collect(Collectors.toMap(Preference::getId, Preference::getCategory)));

        clients.forEach(client -> {
            List<Product> clientProducts = new ArrayList<>();
            List<Preference> clientPreferences = new ArrayList<>();

            client.getPreferences().forEach(preference -> clientPreferences
                    .add(preferences.stream().filter(p -> p.getId() == preference).findFirst().get()));

            clientPreferences.forEach(
                    preference -> products.stream().filter(p -> p.getCategory().equals(preference.getCategory()))
                            .sorted(Comparator.comparing(
                                    obj -> obj.getPrice().divide(new BigDecimal(obj.getAmount()), RoundingMode.HALF_UP),
                                    Comparator.reverseOrder()))
                            .forEach(product -> addProduct(client, product, clientProducts)));

            clientProductsMap.put(client, clientProducts);
        });
    }

    /**
     * Wyświetl dane klienta, który zakupił najwięcej produktów.
     */
    public List<Client> getClientsWhoBoughtTheBiggestProductAmount()
    {
        return clientProductsMap.entrySet().stream().filter(p -> p.getValue().size() ==
                clientProductsMap.entrySet().stream().map(m -> m.getValue().size())
                        .max(Comparator.comparing(value -> value)).orElse(0)).map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    /**
     * Wyświetl dane klienta, który zakupił produkty o łącznie najwyższej
     * wartości.
     */
    public List<Client> getClientsWhoPaidTheMost()
    {
        BigDecimal maxSumPrice = clientProductsMap.values().stream()
                .map(products -> products.stream().map(m -> m.getPrice().multiply(new BigDecimal(m.getAmount())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add)).max(Comparator.comparing(a -> a))
                .orElse(new BigDecimal(0.0));

        return clientProductsMap.entrySet().stream()
                .filter(p -> p.getValue().stream().map(m -> m.getPrice().multiply(new BigDecimal(m.getAmount())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add).equals(maxSumPrice)).map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    /**
     * Przygotuj zestawienie produktów, które posiada informacje na temat
     * produktu oraz ile razy był wybierany przez wszystkich klientów.
     * Dodatkowo podaj dane produktu najczęściej i najrzadziej
     * wybieranego.
     */
    public Map<ProductDto, Long> prepareProductStatistic()
    {
        List<ProductDto> productDtos =
                clientProductsMap.entrySet().stream().flatMap(clientListEntry -> clientListEntry.getValue().stream())
                        .map(m -> new ProductDto(m.getName(), m.getPrice(), m.getCategory()))
                        .collect(Collectors.toList());

        Map<ProductDto, Long> results = new HashMap<>();

        productDtos.forEach(productDto -> results
                .putIfAbsent(productDto, productDtos.stream().filter(p -> p.equals(productDto)).count()));

        return results;
    }

    public Map<Category, Long> prepareCategoryStatistics()
    {
        List<List<Integer>> preferenceLists =
                clientProductsMap.entrySet().stream().map(m -> m.getKey().getPreferences())
                        .collect(Collectors.toList());

        // TODO

        return null;
    }

    @Override
    public String toString()
    {
        return clientProductsMap.entrySet().stream().map(f -> f.getKey() + "\n" +
                f.getValue().stream().map(Product::toString).collect(Collectors.joining("\n")) + "\n---")
                .collect(Collectors.joining("\n"));
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientsServiceImpl that = (ClientsServiceImpl) o;
        return Objects.equals(clientProductsMap, that.clientProductsMap);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(clientProductsMap);
    }

    private void addProduct(Client client, Product product, Collection<Product> products)
    {
        if (client.getMoney().compareTo(product.getPrice().multiply(new BigDecimal(product.getAmount()))) >= 0)
        {
            products.add(product);
            client.setMoney(
                    client.getMoney().subtract(product.getPrice().multiply(new BigDecimal(product.getAmount()))));
        }
    }
}
