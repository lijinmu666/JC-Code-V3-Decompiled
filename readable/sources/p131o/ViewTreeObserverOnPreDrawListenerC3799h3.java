package p131o;

import android.view.View;
import android.view.ViewTreeObserver;

/* renamed from: o.h3 */
/* loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC3799h3 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: AZxh */
    public ViewTreeObserver f13917AZxh;

    /* renamed from: mjFkc */
    public final View f13918mjFkc;

    /* renamed from: wA */
    public final Runnable f13919wA;

    public ViewTreeObserverOnPreDrawListenerC3799h3(View view, Runnable runnable) {
        this.f13918mjFkc = view;
        this.f13917AZxh = view.getViewTreeObserver();
        this.f13919wA = runnable;
    }

    /* renamed from: mjFkc */
    public static ViewTreeObserverOnPreDrawListenerC3799h3 m12163mjFkc(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        ViewTreeObserverOnPreDrawListenerC3799h3 viewTreeObserverOnPreDrawListenerC3799h3 = new ViewTreeObserverOnPreDrawListenerC3799h3(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC3799h3);
        view.addOnAttachStateChangeListener(viewTreeObserverOnPreDrawListenerC3799h3);
        return viewTreeObserverOnPreDrawListenerC3799h3;
    }

    /* renamed from: AZxh */
    public void m12164AZxh() {
        if (this.f13917AZxh.isAlive()) {
            this.f13917AZxh.removeOnPreDrawListener(this);
        } else {
            this.f13918mjFkc.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f13918mjFkc.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        m12164AZxh();
        this.f13919wA.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f13917AZxh = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        m12164AZxh();
    }
}
