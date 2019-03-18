/**
 * Developed by Justyna Stachera on 22.02.2019.
 * Package name:
 * Last modified 20:32.
 * Copyright (c) 2019. All rights reserved.
 */module clients.services.module {
    requires clients.classes.module;
    requires gson.module;
    requires org.eclipse.collections.impl;
    requires org.eclipse.collections.api;

    exports com.stachera.justyna.services;

    opens com.stachera.justyna.modules to gson;
}
