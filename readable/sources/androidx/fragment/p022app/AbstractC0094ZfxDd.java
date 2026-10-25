package androidx.fragment.p022app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import p131o.AbstractC3538d4;
import p131o.AbstractC4925y4;
import p131o.ViewTreeObserverOnPreDrawListenerC3799h3;

/* renamed from: androidx.fragment.app.ZfxDd */
/* loaded from: classes.dex */
public abstract class AbstractC0094ZfxDd {
    /* renamed from: AZxh */
    public static mjFkc m954AZxh(Context context, Fragment fragment, boolean z, boolean z2) throws Resources.NotFoundException {
        int iM765Gd = fragment.m765Gd();
        int iM955mjFkc = m955mjFkc(fragment, z, z2);
        fragment.m836uH(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.f1151wJVbdd;
        if (viewGroup != null && viewGroup.getTag(AbstractC4925y4.f17476wA) != null) {
            fragment.f1151wJVbdd.setTag(AbstractC4925y4.f17476wA, null);
        }
        ViewGroup viewGroup2 = fragment.f1151wJVbdd;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation animationM771JYgkl = fragment.m771JYgkl(iM765Gd, z, iM955mjFkc);
        if (animationM771JYgkl != null) {
            return new mjFkc(animationM771JYgkl);
        }
        Animator animatorM773JrJO = fragment.m773JrJO(iM765Gd, z, iM955mjFkc);
        if (animatorM773JrJO != null) {
            return new mjFkc(animatorM773JrJO);
        }
        if (iM955mjFkc == 0 && iM765Gd != 0) {
            iM955mjFkc = m956wA(iM765Gd, z);
        }
        if (iM955mjFkc != 0) {
            boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(iM955mjFkc));
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, iM955mjFkc);
                    if (animationLoadAnimation != null) {
                        return new mjFkc(animationLoadAnimation);
                    }
                } catch (Resources.NotFoundException e) {
                    throw e;
                } catch (RuntimeException unused) {
                }
            } else {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, iM955mjFkc);
                    if (animatorLoadAnimator != null) {
                        return new mjFkc(animatorLoadAnimator);
                    }
                } catch (RuntimeException e2) {
                    if (zEquals) {
                        throw e2;
                    }
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, iM955mjFkc);
                    if (animationLoadAnimation2 != null) {
                        return new mjFkc(animationLoadAnimation2);
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: mjFkc */
    public static int m955mjFkc(Fragment fragment, boolean z, boolean z2) {
        return z2 ? z ? fragment.m759BAnRFn() : fragment.m821lB() : z ? fragment.m831rkYL() : fragment.m767IEE();
    }

    /* renamed from: wA */
    public static int m956wA(int i, boolean z) {
        if (i == 4097) {
            return z ? AbstractC3538d4.f13295KLFTb : AbstractC3538d4.f13294JHa;
        }
        if (i == 4099) {
            return z ? AbstractC3538d4.f13298wA : AbstractC3538d4.f13296ZfxDd;
        }
        if (i != 8194) {
            return -1;
        }
        return z ? AbstractC3538d4.f13297mjFkc : AbstractC3538d4.f13293AZxh;
    }

    /* renamed from: androidx.fragment.app.ZfxDd$mjFkc */
    public static class mjFkc {

        /* renamed from: AZxh */
        public final Animator f1252AZxh;

        /* renamed from: mjFkc */
        public final Animation f1253mjFkc;

        public mjFkc(Animation animation) {
            this.f1253mjFkc = animation;
            this.f1252AZxh = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        public mjFkc(Animator animator) {
            this.f1253mjFkc = null;
            this.f1252AZxh = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* renamed from: androidx.fragment.app.ZfxDd$AZxh */
    public static class AZxh extends AnimationSet implements Runnable {

        /* renamed from: AZxh */
        public final View f1247AZxh;

        /* renamed from: KLFTb */
        public boolean f1248KLFTb;

        /* renamed from: ZfxDd */
        public boolean f1249ZfxDd;

        /* renamed from: mjFkc */
        public final ViewGroup f1250mjFkc;

        /* renamed from: wA */
        public boolean f1251wA;

        public AZxh(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f1248KLFTb = true;
            this.f1250mjFkc = viewGroup;
            this.f1247AZxh = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            this.f1248KLFTb = true;
            if (this.f1251wA) {
                return !this.f1249ZfxDd;
            }
            if (!super.getTransformation(j, transformation)) {
                this.f1251wA = true;
                ViewTreeObserverOnPreDrawListenerC3799h3.m12163mjFkc(this.f1250mjFkc, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1251wA || !this.f1248KLFTb) {
                this.f1250mjFkc.endViewTransition(this.f1247AZxh);
                this.f1249ZfxDd = true;
            } else {
                this.f1248KLFTb = false;
                this.f1250mjFkc.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.f1248KLFTb = true;
            if (this.f1251wA) {
                return !this.f1249ZfxDd;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.f1251wA = true;
                ViewTreeObserverOnPreDrawListenerC3799h3.m12163mjFkc(this.f1250mjFkc, this);
            }
            return true;
        }
    }
}
