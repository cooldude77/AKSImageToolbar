package com.instanect.aksimagetoolbar.toolbar;

import android.net.Uri;

import com.instanect.imagetoolbar.image.imageView.AppImageView;
import com.instanect.imagetoolbar.image.imageView.interfaces.AppImageViewChangedListenerInterface;
import com.instanect.imagetoolbar.image.toolbar.interfaces.AppImageToolbarEventListenerInterface;
import com.instanect.imagetoolbar.image.toolbar.view.AppImageToolbarView;
import com.instanect.imagetoolbar.image.toolbar.view.interfaces.OnToolbarViewDeleteButtonClickListener;
import com.instanect.imagetoolbar.image.toolbar.view.interfaces.OnToolbarViewUndoButtonClickListener;

/**
 * Created by AKS on 2/7/2018.
 */

public class AppImageToolbarMediator implements OnToolbarViewDeleteButtonClickListener, OnToolbarViewUndoButtonClickListener, AppImageViewChangedListenerInterface {

    private final AppImageToolbarView appImageToolbarView;
    private final AppImageView appImageView;
    private final AppImageToolbarEventListenerInterface appImageToolbarEventListenerInterface;
    private Uri imageViewUri;

    public AppImageToolbarMediator(
            AppImageToolbarView appImageToolbarView,
            AppImageView appImageView,
            AppImageToolbarEventListenerInterface appImageToolbarEventListenerInterface
    ) {

        this.appImageToolbarView = appImageToolbarView;
        this.appImageView = appImageView;
        this.appImageToolbarEventListenerInterface = appImageToolbarEventListenerInterface;

        // register for events
        appImageToolbarView.setOnDeleteClickListener(this);
        appImageToolbarView.setOnUndoButtonClickListener(this);

        appImageView.setImageChangedListener(this);
        appImageToolbarView.initializeButtonsStatus(appImageView.getImageViewUri() != null);


    }

    @Override
    public void onToolbarDeleteButtonClicked() {

        imageViewUri = appImageView.getImageViewUri();
        appImageView.setImageViewUriNoPropagation(null);

        // Any listener to toolbar main events
        if (appImageToolbarEventListenerInterface != null)
            appImageToolbarEventListenerInterface.onToolbarDeleteButtonClicked();

    }

    @Override
    public void onToolbarUndoButtonClicked() {

        appImageView.setImageURI(imageViewUri);
        imageViewUri = null;

        // Any listener to toolbar main events
        if (appImageToolbarEventListenerInterface != null)
            appImageToolbarEventListenerInterface.onToolbarUndoButtonClicked();

    }

    /**
     * Event from AppImageView
     */
    @Override
    public void onAppImageViewImageSet() {

        imageViewUri = appImageView.getImageViewUri();

        appImageToolbarView.onAppImageViewSet();

    }

}
