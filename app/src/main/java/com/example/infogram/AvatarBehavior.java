package com.example.infogram;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.appbar.AppBarLayout;

public class AvatarBehavior extends CoordinatorLayout.Behavior<View> implements AppBarLayout.OnOffsetChangedListener {

    private AppBarLayout appBar;
    private View avatarView;
    private View titleView;

    private boolean measured = false;

    private float avatarInitX = 0f;
    private float avatarInitY = 0f;
    private float targetX = 0f;
    private float targetY = 0f;

    private float targetScale = 0.4f;
    private float fadeStartPercent = 0.7f;

    public AvatarBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        if (dependency instanceof AppBarLayout) {
            appBar = (AppBarLayout) dependency;
            appBar.addOnOffsetChangedListener(this);
        }
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onLayoutChild(@NonNull CoordinatorLayout parent, @NonNull View child, int layoutDirection) {
        parent.onLayoutChild(child, layoutDirection);

        if (!measured) {
            avatarView = child;

            // buscamos el TextView por ID
            int resId = parent.getResources().getIdentifier(
                    "userNme_appbar_profile",
                    "id",
                    parent.getContext().getPackageName()
            );
            titleView = parent.findViewById(resId);

            if (titleView != null) {
                titleView.setAlpha(0f);
            }

            // posición inicial del avatar (centrado)
            avatarInitX = child.getX();
            avatarInitY = child.getY();

            // posición final del avatar (margen izquierdo)
            float marginLeft = dpToPx(parent.getContext(), -40f);
            float marginHeight = dpToPx(parent.getContext(), -45f);
            targetX = marginLeft;
            targetY = marginHeight;

            measured = true;
        }

        return true;
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (!measured) return;

        int totalRange = appBarLayout.getTotalScrollRange();
        if (totalRange == 0) return;

        float scrollPct = Math.min(1f, Math.max(0f, (float) Math.abs(verticalOffset) / totalRange));

        if (avatarView != null) {
            // escala progresiva del logo
            float scale = 1f - (1f - targetScale) * scrollPct;
            avatarView.setScaleX(scale);
            avatarView.setScaleY(scale);

            // movimiento del logo hacia la izquierda
            float deltaX = targetX - avatarInitX;
            float deltaY = targetY - avatarInitY;
            avatarView.setTranslationX(deltaX * scrollPct);
            avatarView.setTranslationY(deltaY * scrollPct);
        }

        if (titleView != null) {
            // aparición del texto al llegar al scroll deseado
            float alpha = scrollPct < fadeStartPercent ? 0f : 1f;
            titleView.setAlpha(alpha);

            // opcional: mover el texto junto con el logo si quieres efecto más fluido
            titleView.setTranslationX(avatarView.getTranslationX() + avatarView.getWidth() + dpToPx(titleView.getContext(), 8f));
            titleView.setTranslationY(avatarView.getTranslationY());
        }
    }

    private float dpToPx(Context context, float dp) {
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                context.getResources().getDisplayMetrics()
        );
    }
}
