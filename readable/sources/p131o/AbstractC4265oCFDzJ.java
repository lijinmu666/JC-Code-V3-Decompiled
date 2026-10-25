package p131o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: o.oCFDzJ */
/* loaded from: classes.dex */
public abstract class AbstractC4265oCFDzJ {
    /* renamed from: AZxh */
    public static void m12947AZxh(Animator animator) {
        animator.pause();
    }

    /* renamed from: mjFkc */
    public static void m12948mjFkc(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        animator.addPauseListener(animatorListenerAdapter);
    }

    /* renamed from: wA */
    public static void m12949wA(Animator animator) {
        animator.resume();
    }
}
