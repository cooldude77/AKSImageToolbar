package com.instanect.aksimagetoolbar.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.instanect.aksimagetoolbar.R;
import com.instanect.aksimagetoolbar.imageView.AppImageView;
import com.instanect.aksimagetoolbar.toolbar.AppImageToolbarMediator;
import com.instanect.aksimagetoolbar.toolbar.interfaces.AppImageToolbarEventListenerInterface;
import com.instanect.aksimagetoolbar.toolbar.view.AppImageToolbarView;


/**
 * Created by AKS on 2/7/2018.
 */

public class ImageToolbarActivity extends AppCompatActivity implements AppImageToolbarEventListenerInterface {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_layout);

        AppImageView imageView = findViewById(R.id.imageView);

        AppImageToolbarView appImageToolbarView = findViewById(R.id.appImageToolbar);

        appImageToolbarView.setDeleteButtonResId(R.id.imageButtonDelete);
        appImageToolbarView.setUndoButtonResId(R.id.imageButtonUndo);

        AppImageToolbarMediator appImageToolbarMediator
                = new AppImageToolbarMediator(
                appImageToolbarView,
                imageView,
                this
        );
    }


    @Override
    public void onToolbarUndoButtonClicked() {

        Toast.makeText(this, "On Undo Button Pressed", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onToolbarDeleteButtonClicked() {
        Toast.makeText(this, "On Delete Button Pressed", Toast.LENGTH_LONG).show();

    }
}

