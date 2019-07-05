package com.instanect.aksimagetoolbaractivity.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.instanect.aksimagetoolbaractivity.imageView.AppImageView;
import com.instanect.aksimagetoolbaractivity.toolbar.AppImageToolbarMediator;
import com.instanect.aksimagetoolbaractivity.toolbar.interfaces.AppImageToolbarEventListenerInterface;
import com.instanect.aksimagetoolbaractivity.toolbar.view.AppImageToolbarView;
import com.instanect.aksimagetoolbarapp.R;


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

