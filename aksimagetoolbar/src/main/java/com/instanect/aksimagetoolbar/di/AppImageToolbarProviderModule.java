package com.instanect.aksimagetoolbar.di;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AKS on 2/6/2018.
 */
@Module
public class AppImageToolbarProviderModule {

    @Provides
    AppImageToolbarProvider provideAppImageToolbarProvider() {
        return new AppImageToolbarProvider();
    }

}
