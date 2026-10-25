package p131o;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* renamed from: o.Q */
/* loaded from: classes.dex */
public class ViewOnTouchListenerC2667Q implements View.OnTouchListener {

    /* renamed from: AZxh */
    public final int f10139AZxh;

    /* renamed from: ZfxDd */
    public final int f10140ZfxDd;

    /* renamed from: mjFkc */
    public final Dialog f10141mjFkc;

    /* renamed from: wA */
    public final int f10142wA;

    public ViewOnTouchListenerC2667Q(Dialog dialog, Rect rect) {
        this.f10141mjFkc = dialog;
        this.f10139AZxh = rect.left;
        this.f10142wA = rect.top;
        this.f10140ZfxDd = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View viewFindViewById = view.findViewById(R.id.content);
        int left = this.f10139AZxh + viewFindViewById.getLeft();
        int width = viewFindViewById.getWidth() + left;
        if (new RectF(left, this.f10142wA + viewFindViewById.getTop(), width, viewFindViewById.getHeight() + r3).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            motionEventObtain.setAction(4);
        }
        view.performClick();
        return this.f10141mjFkc.onTouchEvent(motionEventObtain);
    }
}
