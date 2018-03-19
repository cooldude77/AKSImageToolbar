package com.instanect.aksimagetoolbar.di;

import com.instanect.imagetoolbar.image.imageView.AppImageView;
import com.instanect.imagetoolbar.image.toolbar.AppImageToolbarMediator;
import com.instanect.imagetoolbar.image.toolbar.interfaces.AppImageToolbarEventListenerInterface;
import com.instanect.imagetoolbar.image.toolbar.view.AppImageToolbarView;

/**
 * Created by AKS on 2/6/2018.
 */

public class AppImageToolbarProvider {


    public AppImageToolbarMediator getInstance(AppImageToolbarView appImageToolbarView,
                                               AppImageView appImageView,
                                               AppImageToolbarEventListenerInterface appImageToolbarEventListenerInterface) {


        return new AppImageToolbarMediator(appImageToolbarView,
                appImageView,
                appImageToolbarEventListenerInterface);


    }
}
