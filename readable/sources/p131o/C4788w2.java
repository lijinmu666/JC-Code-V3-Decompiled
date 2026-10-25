package p131o;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* renamed from: o.w2 */
/* loaded from: classes.dex */
public class C4788w2 {

    /* renamed from: mjFkc */
    public final C3074W6 f17114mjFkc = new C3074W6();

    /* renamed from: AZxh */
    public final C3074W6 f17113AZxh = new C3074W6();

    /* renamed from: AZxh */
    public static C4788w2 m13809AZxh(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return m13812wA(context, resourceId);
    }

    /* renamed from: ZfxDd */
    public static C4788w2 m13810ZfxDd(List list) {
        C4788w2 c4788w2 = new C4788w2();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            m13811mjFkc(c4788w2, (Animator) list.get(i));
        }
        return c4788w2;
    }

    /* renamed from: mjFkc */
    public static void m13811mjFkc(C4788w2 c4788w2, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            c4788w2.m13814KLFTb(objectAnimator.getPropertyName(), objectAnimator.getValues());
            c4788w2.m13813JHa(objectAnimator.getPropertyName(), C4855x2.m13883mjFkc(objectAnimator));
        } else {
            throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
        }
    }

    /* renamed from: wA */
    public static C4788w2 m13812wA(Context context, int i) throws Resources.NotFoundException {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return m13810ZfxDd(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return m13810ZfxDd(arrayList);
        } catch (Exception e) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i), e);
            return null;
        }
    }

    /* renamed from: JHa */
    public void m13813JHa(String str, C4855x2 c4855x2) {
        this.f17114mjFkc.m10821put(str, c4855x2);
    }

    /* renamed from: KLFTb */
    public void m13814KLFTb(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f17113AZxh.m10821put(str, propertyValuesHolderArr);
    }

    /* renamed from: equals */
    public boolean m13815equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C4788w2) {
            return this.f17114mjFkc.m10816equals(((C4788w2) obj).f17114mjFkc);
        }
        return false;
    }

    public int hashCode() {
        return this.f17114mjFkc.hashCode();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f17114mjFkc + "}\n";
    }
}
