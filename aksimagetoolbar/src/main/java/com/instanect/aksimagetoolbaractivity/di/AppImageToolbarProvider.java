package com.instanect.aksimagetoolbaractivity.di;

import com.instanect.aksimagetoolbaractivity.imageView.AppImageView;
import com.instanect.aksimagetoolbaractivity.toolbar.AppImageToolbarMediator;
import com.instanect.aksimagetoolbaractivity.toolbar.interfaces.AppImageToolbarEventListenerInterface;
import com.instanect.aksimagetoolbaractivity.toolbar.view.AppImageToolbarView;

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
