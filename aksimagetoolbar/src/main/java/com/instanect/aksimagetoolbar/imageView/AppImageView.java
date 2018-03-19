package com.instanect.aksimagetoolbar.imageView;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.instanect.imagetoolbar.image.imageView.interfaces.AppImageViewChangedListenerInterface;

/**
 AppImageView
 */

public class AppImageView extends android.support.v7.widget.AppCompatImageView {
    private AppImageViewChangedListenerInterface appImageViewChangedListenerInterface;
    private Uri imageViewUri;

    public AppImageView(Context context) {
        super(context);
    }

    public AppImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AppImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setImageChangedListener(AppImageViewChangedListenerInterface
                                                appImageViewChangedListenerInterface) {

        this.appImageViewChangedListenerInterface = appImageViewChangedListenerInterface;
    }

    /**
     * This method is called externally
     * For example by an activity that crops the image
     * <p>
     * It will let listener know that image has been set
     * If you don't want the listener to be invoked, use
     *
     * @param imageViewUri Uri of the image
     */
    @Override
    public void setImageURI(@Nullable Uri imageViewUri) {
        super.setImageURI(imageViewUri);
        this.imageViewUri = imageViewUri;

        if (appImageViewChangedListenerInterface != null)
            appImageViewChangedListenerInterface.onAppImageViewImageSet();
    }

    /**
     * Call this when no listener needs to be notified
     * This is to avoid circular calls to first setting uri here then
     * calling toolbar which calls the listener back
     *
     * @param imageViewUri imageViewUri
     */

    public void setImageViewUriNoPropagation(Uri imageViewUri) {
        super.setImageURI(imageViewUri);
        this.imageViewUri = imageViewUri;
    }

    public Uri getImageViewUri() {
        return imageViewUri;
    }
}
