package com.instanect.aksimagetoolbaractivity.toolbar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.instanect.aksimagetoolbaractivity.toolbar.view.interfaces.OnToolbarViewDeleteButtonClickListener;
import com.instanect.aksimagetoolbaractivity.toolbar.view.interfaces.OnToolbarViewUndoButtonClickListener;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by AKS on 2/6/2018.
 */

public class AppImageToolbarView extends RelativeLayout implements View.OnClickListener {


    ImageButton deleteButton;
    ImageButton undoButton;

    private OnToolbarViewDeleteButtonClickListener onToolbarViewDeleteButtonClickListener;
    private OnToolbarViewUndoButtonClickListener onToolbarViewUndoButtonClickListener;
    private int deleteButtonResId;
    private int undoButtonResId;

    // NOTE : do not use any operation other than calling super in the constructor
    // or you will have java.lang.reflect.InvocationTargetException
    public AppImageToolbarView(Context context) {
        super(context);
    }

    public AppImageToolbarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AppImageToolbarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // initialization
    public void setDeleteButtonResId(int deleteButtonResId) {

        deleteButton = findViewById(deleteButtonResId);

        if (deleteButton == null)
            throw new IllegalArgumentException("Delete Button is not present");
        deleteButton.setOnClickListener(this);

    }

    public void setUndoButtonResId(int undoButtonResId) {

        undoButton = findViewById(undoButtonResId);

        if (undoButton == null)
            throw new IllegalArgumentException("Undo Button not present");
        undoButton.setOnClickListener(this);

    }


    public void setOnDeleteClickListener(
            OnToolbarViewDeleteButtonClickListener onToolbarViewDeleteButtonClickListener) {

        this.onToolbarViewDeleteButtonClickListener = onToolbarViewDeleteButtonClickListener;
    }

    public void setOnUndoButtonClickListener(OnToolbarViewUndoButtonClickListener onToolbarViewUndoButtonClickListener) {

        this.onToolbarViewUndoButtonClickListener = onToolbarViewUndoButtonClickListener;
    }


    // called by mediator
    public void initializeButtonsStatus(boolean drawableExists) {

        setUndoButtonClickable(false);

        if (drawableExists) {
            setDeleteButtonClickable(true);
        } else {
            setDeleteButtonClickable(false);
        }

    }

    // called by mediator on image set
    public void onAppImageViewSet() {
        setDeleteButtonClickable(true);
        setUndoButtonClickable(false);
    }

    // On click of buttons
    @Override
    public void onClick(View view) {

        if (view.getId() == deleteButton.getId()) {
            assertNotNull(onToolbarViewDeleteButtonClickListener);
            onDeleteButtonClicked();
            onToolbarViewDeleteButtonClickListener.onToolbarDeleteButtonClicked();
        }
        if (view.getId() == undoButton.getId()) {
            assertNotNull(onToolbarViewUndoButtonClickListener);
            onUndoButtonClicked();
            onToolbarViewUndoButtonClickListener.onToolbarUndoButtonClicked();
        }
    }

    private void onUndoButtonClicked() {
        setDeleteButtonClickable(true);
        setUndoButtonClickable(false);
    }

    private void onDeleteButtonClicked() {
        setDeleteButtonClickable(false);
        setUndoButtonClickable(true);
    }

    // set clickable status
    public void setUndoButtonClickable(boolean clickable) {
        assertNotNull(undoButton);
        undoButton.setClickable(clickable);
    }

    public void setDeleteButtonClickable(boolean clickable) {
        assertNotNull(deleteButton);
        deleteButton.setClickable(clickable);
    }

}
