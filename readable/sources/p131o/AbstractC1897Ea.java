package p131o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import p131o.AbstractC2485N8;

/* renamed from: o.Ea */
/* loaded from: classes.dex */
public abstract class AbstractC1897Ea extends AbstractC2485N8 {

    /* renamed from: zvd */
    public static final String[] f7988zvd = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: KLMXS */
    public int f7989KLMXS = 3;

    /* renamed from: o.Ea$AZxh */
    public static class AZxh extends AnimatorListenerAdapter implements AbstractC2485N8.JHa {

        /* renamed from: AZxh */
        public final int f7990AZxh;

        /* renamed from: JHa */
        public boolean f7991JHa = false;

        /* renamed from: KLFTb */
        public boolean f7992KLFTb;

        /* renamed from: ZfxDd */
        public final boolean f7993ZfxDd;

        /* renamed from: mjFkc */
        public final View f7994mjFkc;

        /* renamed from: wA */
        public final ViewGroup f7995wA;

        public AZxh(View view, int i, boolean z) {
            this.f7994mjFkc = view;
            this.f7990AZxh = i;
            this.f7995wA = (ViewGroup) view.getParent();
            this.f7993ZfxDd = z;
            m8147xJ(true);
        }

        @Override // p131o.AbstractC2485N8.JHa
        /* renamed from: AZxh */
        public void mo8141AZxh(AbstractC2485N8 abstractC2485N8) {
        }

        /* renamed from: JHa */
        public final void m8142JHa() {
            if (!this.f7991JHa) {
                AbstractC4623ta.m13634lgHUyS(this.f7994mjFkc, this.f7990AZxh);
                ViewGroup viewGroup = this.f7995wA;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            m8147xJ(false);
        }

        @Override // p131o.AbstractC2485N8.JHa
        /* renamed from: KLFTb */
        public void mo8143KLFTb(AbstractC2485N8 abstractC2485N8) {
            m8147xJ(true);
        }

        @Override // p131o.AbstractC2485N8.JHa
        /* renamed from: ZfxDd */
        public void mo8144ZfxDd(AbstractC2485N8 abstractC2485N8) {
        }

        @Override // p131o.AbstractC2485N8.JHa
        /* renamed from: mjFkc */
        public void mo8145mjFkc(AbstractC2485N8 abstractC2485N8) {
            m8147xJ(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f7991JHa = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            m8142JHa();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            if (this.f7991JHa) {
                return;
            }
            AbstractC4623ta.m13634lgHUyS(this.f7994mjFkc, this.f7990AZxh);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            if (this.f7991JHa) {
                return;
            }
            AbstractC4623ta.m13634lgHUyS(this.f7994mjFkc, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // p131o.AbstractC2485N8.JHa
        /* renamed from: wA */
        public void mo8146wA(AbstractC2485N8 abstractC2485N8) {
            m8142JHa();
            abstractC2485N8.mo9616aqHPIZ(this);
        }

        /* renamed from: xJ */
        public final void m8147xJ(boolean z) {
            ViewGroup viewGroup;
            if (!this.f7993ZfxDd || this.f7992KLFTb == z || (viewGroup = this.f7995wA) == null) {
                return;
            }
            this.f7992KLFTb = z;
            AbstractC3570da.m11731AZxh(viewGroup, z);
        }
    }

    /* renamed from: o.Ea$mjFkc */
    public class mjFkc extends AbstractC2549O8 {

        /* renamed from: AZxh */
        public final /* synthetic */ View f7996AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ ViewGroup f7998mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ View f7999wA;

        public mjFkc(ViewGroup viewGroup, View view, View view2) {
            this.f7998mjFkc = viewGroup;
            this.f7996AZxh = view;
            this.f7999wA = view2;
        }

        @Override // p131o.AbstractC2549O8, p131o.AbstractC2485N8.JHa
        /* renamed from: KLFTb */
        public void mo8143KLFTb(AbstractC2485N8 abstractC2485N8) {
            if (this.f7996AZxh.getParent() == null) {
                AbstractC3570da.m11732mjFkc(this.f7998mjFkc).mo11529mjFkc(this.f7996AZxh);
            } else {
                AbstractC1897Ea.this.m9625lgHUyS();
            }
        }

        @Override // p131o.AbstractC2549O8, p131o.AbstractC2485N8.JHa
        /* renamed from: mjFkc */
        public void mo8145mjFkc(AbstractC2485N8 abstractC2485N8) {
            AbstractC3570da.m11732mjFkc(this.f7998mjFkc).mo11530wA(this.f7996AZxh);
        }

        @Override // p131o.AbstractC2485N8.JHa
        /* renamed from: wA */
        public void mo8146wA(AbstractC2485N8 abstractC2485N8) {
            this.f7999wA.setTag(AbstractC1734C4.f7550mjFkc, null);
            AbstractC3570da.m11732mjFkc(this.f7998mjFkc).mo11530wA(this.f7996AZxh);
            abstractC2485N8.mo9616aqHPIZ(this);
        }
    }

    /* renamed from: o.Ea$wA */
    public static class wA {

        /* renamed from: AZxh */
        public boolean f8000AZxh;

        /* renamed from: JHa */
        public ViewGroup f8001JHa;

        /* renamed from: KLFTb */
        public ViewGroup f8002KLFTb;

        /* renamed from: ZfxDd */
        public int f8003ZfxDd;

        /* renamed from: mjFkc */
        public boolean f8004mjFkc;

        /* renamed from: wA */
        public int f8005wA;
    }

    /* renamed from: JBhc */
    private void m8129JBhc(C2875T8 c2875t8) {
        c2875t8.f10646mjFkc.put("android:visibility:visibility", Integer.valueOf(c2875t8.f10645AZxh.getVisibility()));
        c2875t8.f10646mjFkc.put("android:visibility:parent", c2875t8.f10645AZxh.getParent());
        int[] iArr = new int[2];
        c2875t8.f10645AZxh.getLocationOnScreen(iArr);
        c2875t8.f10646mjFkc.put("android:visibility:screenLocation", iArr);
    }

    /* renamed from: ANMGZc */
    public Animator m8130ANMGZc(ViewGroup viewGroup, C2875T8 c2875t8, int i, C2875T8 c2875t82, int i2) {
        if ((this.f7989KLMXS & 1) != 1 || c2875t82 == null) {
            return null;
        }
        if (c2875t8 == null) {
            View view = (View) c2875t82.f10645AZxh.getParent();
            if (m8134Vdz(m9609Ucbh(view, false), m9606Ne(view, false)).f8004mjFkc) {
                return null;
            }
        }
        return mo8137jm(viewGroup, c2875t82.f10645AZxh, c2875t8, c2875t82);
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: CqaNbM */
    public boolean mo8131CqaNbM(C2875T8 c2875t8, C2875T8 c2875t82) {
        if (c2875t8 == null && c2875t82 == null) {
            return false;
        }
        if (c2875t8 != null && c2875t82 != null && c2875t82.f10646mjFkc.containsKey("android:visibility:visibility") != c2875t8.f10646mjFkc.containsKey("android:visibility:visibility")) {
            return false;
        }
        wA wAVarM8134Vdz = m8134Vdz(c2875t8, c2875t82);
        if (wAVarM8134Vdz.f8004mjFkc) {
            return wAVarM8134Vdz.f8005wA == 0 || wAVarM8134Vdz.f8003ZfxDd == 0;
        }
        return false;
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: OjSQV */
    public String[] mo8132OjSQV() {
        return f7988zvd;
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: VA */
    public void mo8133VA(C2875T8 c2875t8) {
        m8129JBhc(c2875t8);
    }

    /* renamed from: Vdz */
    public final wA m8134Vdz(C2875T8 c2875t8, C2875T8 c2875t82) {
        wA wAVar = new wA();
        wAVar.f8004mjFkc = false;
        wAVar.f8000AZxh = false;
        if (c2875t8 == null || !c2875t8.f10646mjFkc.containsKey("android:visibility:visibility")) {
            wAVar.f8005wA = -1;
            wAVar.f8002KLFTb = null;
        } else {
            wAVar.f8005wA = ((Integer) c2875t8.f10646mjFkc.get("android:visibility:visibility")).intValue();
            wAVar.f8002KLFTb = (ViewGroup) c2875t8.f10646mjFkc.get("android:visibility:parent");
        }
        if (c2875t82 == null || !c2875t82.f10646mjFkc.containsKey("android:visibility:visibility")) {
            wAVar.f8003ZfxDd = -1;
            wAVar.f8001JHa = null;
        } else {
            wAVar.f8003ZfxDd = ((Integer) c2875t82.f10646mjFkc.get("android:visibility:visibility")).intValue();
            wAVar.f8001JHa = (ViewGroup) c2875t82.f10646mjFkc.get("android:visibility:parent");
        }
        if (c2875t8 != null && c2875t82 != null) {
            int i = wAVar.f8005wA;
            int i2 = wAVar.f8003ZfxDd;
            if (i == i2 && wAVar.f8002KLFTb == wAVar.f8001JHa) {
                return wAVar;
            }
            if (i != i2) {
                if (i == 0) {
                    wAVar.f8000AZxh = false;
                    wAVar.f8004mjFkc = true;
                } else if (i2 == 0) {
                    wAVar.f8000AZxh = true;
                    wAVar.f8004mjFkc = true;
                }
            } else if (wAVar.f8001JHa == null) {
                wAVar.f8000AZxh = false;
                wAVar.f8004mjFkc = true;
            } else if (wAVar.f8002KLFTb == null) {
                wAVar.f8000AZxh = true;
                wAVar.f8004mjFkc = true;
            }
        } else if (c2875t8 == null && wAVar.f8003ZfxDd == 0) {
            wAVar.f8000AZxh = true;
            wAVar.f8004mjFkc = true;
        } else if (c2875t82 == null && wAVar.f8005wA == 0) {
            wAVar.f8000AZxh = false;
            wAVar.f8004mjFkc = true;
        }
        return wAVar;
    }

    /* renamed from: alEkx */
    public abstract Animator mo8135alEkx(ViewGroup viewGroup, View view, C2875T8 c2875t8, C2875T8 c2875t82);

    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0069 A[PHI: r2
      0x0069: PHI (r2v3 android.view.View) = 
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v6 android.view.View)
     binds: [B:26:0x003e, B:31:0x004d, B:37:0x0076, B:39:0x0079, B:41:0x007f, B:43:0x0083, B:34:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: dm */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Animator m8136dm(ViewGroup viewGroup, C2875T8 c2875t8, int i, C2875T8 c2875t82, int i2) {
        View view;
        boolean z;
        boolean z2;
        View view2;
        if ((this.f7989KLMXS & 2) != 2 || c2875t8 == null) {
            return null;
        }
        View view3 = c2875t8.f10645AZxh;
        View viewM10136mjFkc = c2875t82 != null ? c2875t82.f10645AZxh : null;
        View view4 = (View) view3.getTag(AbstractC1734C4.f7550mjFkc);
        if (view4 != null) {
            view2 = null;
            z2 = true;
        } else if (viewM10136mjFkc == null || viewM10136mjFkc.getParent() == null) {
            if (viewM10136mjFkc != null) {
                view = null;
                z = false;
            } else {
                viewM10136mjFkc = null;
                view = null;
                z = true;
            }
            if (z) {
                if (view3.getParent() != null) {
                    if (view3.getParent() instanceof View) {
                        View view5 = (View) view3.getParent();
                        if (m8134Vdz(m9606Ne(view5, true), m9609Ucbh(view5, true)).f8004mjFkc) {
                            int id = view5.getId();
                            if (view5.getParent() != null || id == -1 || viewGroup.findViewById(id) == null || !this.f9682huTpC) {
                            }
                        } else {
                            viewM10136mjFkc = AbstractC2807S8.m10136mjFkc(viewGroup, view3, view5);
                        }
                    }
                    z2 = false;
                    View view6 = view;
                    view4 = viewM10136mjFkc;
                    view2 = view6;
                }
                view2 = view;
                z2 = false;
                view4 = view3;
            } else {
                z2 = false;
                View view62 = view;
                view4 = viewM10136mjFkc;
                view2 = view62;
            }
        } else {
            if (i2 == 4 || view3 == viewM10136mjFkc) {
                view = viewM10136mjFkc;
                z = false;
                viewM10136mjFkc = null;
            }
            if (z) {
            }
        }
        if (view4 == null) {
            if (view2 == null) {
                return null;
            }
            int visibility = view2.getVisibility();
            AbstractC4623ta.m13634lgHUyS(view2, 0);
            Animator animatorMo8135alEkx = mo8135alEkx(viewGroup, view2, c2875t8, c2875t82);
            if (animatorMo8135alEkx != null) {
                AZxh aZxh = new AZxh(view2, i2, true);
                animatorMo8135alEkx.addListener(aZxh);
                AbstractC4265oCFDzJ.m12948mjFkc(animatorMo8135alEkx, aZxh);
                mo9627mjFkc(aZxh);
            } else {
                AbstractC4623ta.m13634lgHUyS(view2, visibility);
            }
            return animatorMo8135alEkx;
        }
        if (!z2) {
            int[] iArr = (int[]) c2875t8.f10646mjFkc.get("android:visibility:screenLocation");
            int i3 = iArr[0];
            int i4 = iArr[1];
            int[] iArr2 = new int[2];
            viewGroup.getLocationOnScreen(iArr2);
            view4.offsetLeftAndRight((i3 - iArr2[0]) - view4.getLeft());
            view4.offsetTopAndBottom((i4 - iArr2[1]) - view4.getTop());
            AbstractC3570da.m11732mjFkc(viewGroup).mo11529mjFkc(view4);
        }
        Animator animatorMo8135alEkx2 = mo8135alEkx(viewGroup, view4, c2875t8, c2875t82);
        if (!z2) {
            if (animatorMo8135alEkx2 == null) {
                AbstractC3570da.m11732mjFkc(viewGroup).mo11530wA(view4);
            } else {
                view3.setTag(AbstractC1734C4.f7550mjFkc, view4);
                mo9627mjFkc(new mjFkc(viewGroup, view4, view3));
            }
        }
        return animatorMo8135alEkx2;
    }

    /* renamed from: jm */
    public abstract Animator mo8137jm(ViewGroup viewGroup, View view, C2875T8 c2875t8, C2875T8 c2875t82);

    @Override // p131o.AbstractC2485N8
    /* renamed from: qGY */
    public Animator mo8138qGY(ViewGroup viewGroup, C2875T8 c2875t8, C2875T8 c2875t82) {
        wA wAVarM8134Vdz = m8134Vdz(c2875t8, c2875t82);
        if (!wAVarM8134Vdz.f8004mjFkc) {
            return null;
        }
        if (wAVarM8134Vdz.f8002KLFTb == null && wAVarM8134Vdz.f8001JHa == null) {
            return null;
        }
        return wAVarM8134Vdz.f8000AZxh ? m8130ANMGZc(viewGroup, c2875t8, wAVarM8134Vdz.f8005wA, c2875t82, wAVarM8134Vdz.f8003ZfxDd) : m8136dm(viewGroup, c2875t8, wAVarM8134Vdz.f8005wA, c2875t82, wAVarM8134Vdz.f8003ZfxDd);
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: qdMbNW */
    public void mo8139qdMbNW(C2875T8 c2875t8) {
        m8129JBhc(c2875t8);
    }

    /* renamed from: tQ */
    public void m8140tQ(int i) {
        if ((i & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.f7989KLMXS = i;
    }
}
