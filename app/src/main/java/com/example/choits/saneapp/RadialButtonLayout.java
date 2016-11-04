package com.example.choits.saneapp;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.lang.ref.WeakReference;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.choits.saneapp.register.registerActivity;
import com.example.choits.saneapp.qna.QnaActivity;
import com.example.choits.saneapp.report.Report_Activity;

/**
 *
 */
public class RadialButtonLayout extends FrameLayout {

    public final static String EXTRA_MESSAGE = "com.example.choits.saneapp.RadialButtonLayout";
    private final static long DURATION_SHORT = 400;
    private WeakReference<Context> weakContext;

    @Bind(R.id.btn_main_red)
    View btnMain;
    @Bind(R.id.btn_QnA_Orange)
    View btnOrange;
    @Bind(R.id.btn_join_yellow)
    View btnYellow;
    @Bind(R.id.btn_report_green)
    View btnGreen;
   /* @Bind(R.id.btn_blue)
    View btnBlue;
    @Bind(R.id.btn_indigo)
    View btnIndigo;*/

    private boolean isOpen = false;
    private Toast toast;
    /**
     * Default constructor
     * @param context
     */
    public RadialButtonLayout(final Context context) {
        this(context, null);
    }

    public RadialButtonLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RadialButtonLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        weakContext = new WeakReference<Context>( context );
        LayoutInflater.from(context).inflate( R.layout.layout_radial_buttons, this);
        if (isInEditMode()) {
            //
        } else{
            ButterKnife.bind(this);
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            //
        } else {

        }
    }

    private void showToast( final int resId ) {
        if ( toast != null )
            toast.cancel();
        toast = Toast.makeText( getContext(), resId, Toast.LENGTH_SHORT );
        toast.show();
    }

    @OnClick( R.id.btn_main_red )
    public void onMainButtonClicked( final View btn ) {
        int resId = 0;
        if ( isOpen ) {
            // close
            hide(btnOrange);
            hide(btnYellow);
            hide(btnGreen);
            //hide(btnBlue);
           // hide(btnIndigo);
            isOpen = false;
            resId = R.string.close;
        } else {
            show(btnOrange, 1, 300);
            show(btnYellow, 2, 300);
            show(btnGreen, 3, 300);
            //show(btnBlue, 4, 300);
            //show(btnIndigo, 5, 300);
            isOpen = true;
            resId = R.string.open;
        }
    //    showToast( resId);
        btn.playSoundEffect( SoundEffectConstants.CLICK);
    }

    @OnClick({ R.id.btn_QnA_Orange, R.id.btn_join_yellow, R.id.btn_report_green, /*R.id.btn_blue, R.id.btn_indigo*/})
    public void onButtonClicked( final View btn ) {
        int resId = 0;
        Intent intent;
        switch ( btn.getId() ) {
            case R.id.btn_QnA_Orange:
                //preferences ( needs to be renamed)
                intent = new Intent(btn.getContext(), QnaActivity.class);
                resId = R.string.QnA;
                break;
            case R.id.btn_join_yellow:
                //new report
                intent = new Intent(btn.getContext(), registerActivity.class);
                resId = R.string.join;
                break;
            case R.id.btn_report_green:
                //view old reports
                intent = new Intent(btn.getContext() , Report_Activity.class);
                resId = R.string.report;
                break;
            /*case R.id.btn_blue:
                intent = new Intent(btn.getContext(), registerActivity.class);
                //other option
                resId = R.string.blue;
                break;
            case R.id.btn_indigo:
                //another option
                intent = new Intent(btn.getContext(), registerActivity.class);
                resId = R.string.indigo;
                break;*/
            default:
                intent = new Intent(btn.getContext(), MainActivity.class);
                resId = R.string.undefined;
        }
        //showToast(resId);
        btn.getContext().startActivity(intent);
        btn.playSoundEffect( SoundEffectConstants.CLICK);
    }

    private final void hide( final View child) {
        child.animate()
                .setDuration(DURATION_SHORT)
                .translationX(0)
                .translationY(0)
                .start();
    }

    private final void show(final View child, final int position, final int radius) {
        float angleDeg = 180.f;
        int dist = radius;
        switch (position) {
            case 1:
                angleDeg += 0.f;
                break;
            case 2:
                angleDeg += 45.f;
                break;
            case 3:
                angleDeg += 90.f;
                break;
            case 4:
                angleDeg += 135.f;
                break;
            case 5:
                angleDeg += 180.f;
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                break;
        }

        final float angleRad = (float) (angleDeg * Math.PI / 180.f);

        final Float x = dist * (float) Math.cos(angleRad);
        final Float y = dist * (float) Math.sin(angleRad);
        child.animate()
                .setDuration(DURATION_SHORT)
                .translationX(x)
                .translationY(y)
                .start();
    }
}
