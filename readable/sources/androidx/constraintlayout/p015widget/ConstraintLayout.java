package androidx.constraintlayout.p015widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.bouncycastle.p133asn1.p143eac.C5125EACTags;
import org.xmlpull.v1.XmlPullParserException;
import p131o.AbstractC1767Ca;
import p131o.AbstractC1832Da;
import p131o.AbstractC3005V4;
import p131o.AbstractC3900ih;
import p131o.C3582dkKKW;
import p131o.C3776gjvQ;
import p131o.C4052kw;
import p131o.C4186n;
import p131o.C4446qtZIjO;
import p131o.C4889xVYW;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: AZxh */
    public ArrayList f674AZxh;

    /* renamed from: Dt */
    public C0057wA f675Dt;

    /* renamed from: ETF */
    public C4889xVYW f676ETF;

    /* renamed from: IEE */
    public int f677IEE;

    /* renamed from: JHa */
    public int f678JHa;

    /* renamed from: KLFTb */
    public int f679KLFTb;

    /* renamed from: MiMN */
    public HashMap f680MiMN;

    /* renamed from: Pq */
    public int f681Pq;

    /* renamed from: Ucbh */
    public int f682Ucbh;

    /* renamed from: VA */
    public int f683VA;

    /* renamed from: YoKzxo */
    public int f684YoKzxo;

    /* renamed from: ZfxDd */
    public int f685ZfxDd;

    /* renamed from: diqgf */
    public SparseArray f686diqgf;

    /* renamed from: eyqo */
    public C0054wA f687eyqo;

    /* renamed from: fehf */
    public int f688fehf;

    /* renamed from: huTpC */
    public int f689huTpC;

    /* renamed from: lgHUyS */
    public boolean f690lgHUyS;

    /* renamed from: mjFkc */
    public SparseArray f691mjFkc;

    /* renamed from: qGY */
    public int f692qGY;

    /* renamed from: qdMbNW */
    public int f693qdMbNW;

    /* renamed from: rkYL */
    public int f694rkYL;

    /* renamed from: wA */
    public C4052kw f695wA;

    /* renamed from: xJ */
    public int f696xJ;

    /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$mjFkc */
    public static /* synthetic */ class C0053mjFkc {

        /* renamed from: mjFkc */
        public static final /* synthetic */ int[] f765mjFkc;

        static {
            int[] iArr = new int[C3776gjvQ.AZxh.m12105values().length];
            f765mjFkc = iArr;
            try {
                iArr[C3776gjvQ.AZxh.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f765mjFkc[C3776gjvQ.AZxh.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f765mjFkc[C3776gjvQ.AZxh.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f765mjFkc[C3776gjvQ.AZxh.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$wA */
    public class C0054wA implements C3582dkKKW.AZxh {

        /* renamed from: AZxh */
        public int f766AZxh;

        /* renamed from: JHa */
        public int f767JHa;

        /* renamed from: KLFTb */
        public int f768KLFTb;

        /* renamed from: ZfxDd */
        public int f769ZfxDd;

        /* renamed from: mjFkc */
        public ConstraintLayout f771mjFkc;

        /* renamed from: wA */
        public int f772wA;

        /* renamed from: xJ */
        public int f773xJ;

        public C0054wA(ConstraintLayout constraintLayout) {
            this.f771mjFkc = constraintLayout;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:102:0x016b A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:110:0x0180  */
        /* JADX WARN: Removed duplicated region for block: B:115:0x0192  */
        /* JADX WARN: Removed duplicated region for block: B:118:0x01a3  */
        /* JADX WARN: Removed duplicated region for block: B:119:0x01ac  */
        /* JADX WARN: Removed duplicated region for block: B:121:0x01b6  */
        /* JADX WARN: Removed duplicated region for block: B:122:0x01bf  */
        /* JADX WARN: Removed duplicated region for block: B:125:0x01cb  */
        /* JADX WARN: Removed duplicated region for block: B:126:0x01d0  */
        /* JADX WARN: Removed duplicated region for block: B:129:0x01d5  */
        /* JADX WARN: Removed duplicated region for block: B:132:0x01dd  */
        /* JADX WARN: Removed duplicated region for block: B:133:0x01e2  */
        /* JADX WARN: Removed duplicated region for block: B:136:0x01e7  */
        /* JADX WARN: Removed duplicated region for block: B:141:0x01f8  */
        /* JADX WARN: Removed duplicated region for block: B:149:0x020b  */
        /* JADX WARN: Removed duplicated region for block: B:151:0x020f  */
        /* JADX WARN: Removed duplicated region for block: B:153:0x0215  */
        /* JADX WARN: Removed duplicated region for block: B:156:0x022c  */
        /* JADX WARN: Removed duplicated region for block: B:157:0x022e  */
        /* JADX WARN: Removed duplicated region for block: B:160:0x0234  */
        /* JADX WARN: Removed duplicated region for block: B:164:0x023c  */
        /* JADX WARN: Removed duplicated region for block: B:167:0x0243  */
        /* JADX WARN: Removed duplicated region for block: B:168:0x0245  */
        /* JADX WARN: Removed duplicated region for block: B:170:0x0248  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00b8  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x011d  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x012c  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x012e  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0131  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0133  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0138  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x013f  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0142  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x0149  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x014d  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x0155  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x0158  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x0160  */
        @Override // p131o.C3582dkKKW.AZxh
        /* renamed from: AZxh */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void mo407AZxh(C3776gjvQ c3776gjvQ, C3582dkKKW.mjFkc mjfkc) {
            int iMakeMeasureSpec;
            boolean z;
            int i;
            int iMakeMeasureSpec2;
            boolean z2;
            boolean z3;
            boolean z4;
            int measuredWidth;
            int measuredHeight;
            int baseline;
            int i2;
            int iMax;
            int i3;
            int iMax2;
            int i4;
            int measuredHeight2;
            int i5;
            boolean z5;
            int childMeasureSpec;
            int childMeasureSpec2;
            if (c3776gjvQ == null) {
                return;
            }
            if (c3776gjvQ.m12043NPj() == 8 && !c3776gjvQ.m12035JYn()) {
                mjfkc.f13384KLFTb = 0;
                mjfkc.f13383JHa = 0;
                mjfkc.f13390xJ = 0;
                return;
            }
            C3776gjvQ.AZxh aZxh = mjfkc.f13387mjFkc;
            C3776gjvQ.AZxh aZxh2 = mjfkc.f13381AZxh;
            int i6 = mjfkc.f13389wA;
            int i7 = mjfkc.f13385ZfxDd;
            int i8 = this.f766AZxh + this.f772wA;
            int i9 = this.f769ZfxDd;
            View view = (View) c3776gjvQ.m12072fehf();
            int[] iArr = C0053mjFkc.f765mjFkc;
            int i10 = iArr[aZxh.ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f767JHa, i9, -2);
                    c3776gjvQ.f13814lgHUyS[2] = -2;
                } else if (i10 == 3) {
                    iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f767JHa, i9 + c3776gjvQ.m12095vI(), -1);
                    c3776gjvQ.f13814lgHUyS[2] = -1;
                } else if (i10 != 4) {
                    iMakeMeasureSpec = 0;
                } else {
                    iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f767JHa, i9, -2);
                    boolean z6 = c3776gjvQ.f13793VA == 1;
                    int[] iArr2 = c3776gjvQ.f13814lgHUyS;
                    iArr2[2] = 0;
                    if (mjfkc.f13382Dt) {
                        boolean z7 = (!z6 || iArr2[3] == 0 || iArr2[0] == c3776gjvQ.m12096vadzgd()) ? false : true;
                        if (!z6 || z7) {
                            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(c3776gjvQ.m12096vadzgd(), 1073741824);
                        }
                    }
                }
                z = true;
                i = iArr[aZxh2.ordinal()];
                if (i == 1) {
                    if (i != 2) {
                        if (i == 3) {
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f773xJ, i8 + c3776gjvQ.m12055Vnb(), -1);
                            c3776gjvQ.f13814lgHUyS[3] = -1;
                        } else {
                            if (i != 4) {
                                z2 = false;
                                iMakeMeasureSpec2 = 0;
                                C3776gjvQ.AZxh aZxh3 = C3776gjvQ.AZxh.MATCH_CONSTRAINT;
                                boolean z8 = aZxh != aZxh3;
                                boolean z9 = aZxh2 != aZxh3;
                                C3776gjvQ.AZxh aZxh4 = C3776gjvQ.AZxh.MATCH_PARENT;
                                boolean z10 = aZxh2 != aZxh4 || aZxh2 == C3776gjvQ.AZxh.FIXED;
                                boolean z11 = aZxh != aZxh4 || aZxh == C3776gjvQ.AZxh.FIXED;
                                z3 = !z8 && c3776gjvQ.f13818oCFDzJ > 0.0f;
                                z4 = !z9 && c3776gjvQ.f13818oCFDzJ > 0.0f;
                                C0052AZxh c0052AZxh = (C0052AZxh) view.getLayoutParams();
                                if (mjfkc.f13382Dt && z8 && c3776gjvQ.f13793VA == 0 && z9 && c3776gjvQ.f13781MiMN == 0) {
                                    iMax = 0;
                                    measuredHeight2 = 0;
                                    i5 = -1;
                                    baseline = 0;
                                    i2 = 0;
                                } else {
                                    if ((view instanceof AbstractC1767Ca) || !(c3776gjvQ instanceof AbstractC1832Da)) {
                                        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                    } else {
                                        ((AbstractC1767Ca) view).mo369YoKzxo((AbstractC1832Da) c3776gjvQ, iMakeMeasureSpec, iMakeMeasureSpec2);
                                    }
                                    measuredWidth = view.getMeasuredWidth();
                                    measuredHeight = view.getMeasuredHeight();
                                    baseline = view.getBaseline();
                                    if (z) {
                                        i2 = 0;
                                        int[] iArr3 = c3776gjvQ.f13814lgHUyS;
                                        iArr3[0] = 0;
                                        iArr3[2] = 0;
                                    } else {
                                        int[] iArr4 = c3776gjvQ.f13814lgHUyS;
                                        i2 = 0;
                                        iArr4[0] = measuredWidth;
                                        iArr4[2] = measuredHeight;
                                    }
                                    if (z2) {
                                        int[] iArr5 = c3776gjvQ.f13814lgHUyS;
                                        iArr5[1] = i2;
                                        iArr5[3] = i2;
                                    } else {
                                        int[] iArr6 = c3776gjvQ.f13814lgHUyS;
                                        iArr6[1] = measuredHeight;
                                        iArr6[3] = measuredWidth;
                                    }
                                    int i11 = c3776gjvQ.f13822rkYL;
                                    iMax = i11 <= 0 ? Math.max(i11, measuredWidth) : measuredWidth;
                                    i3 = c3776gjvQ.f13819qGY;
                                    if (i3 > 0) {
                                        iMax = Math.min(i3, iMax);
                                    }
                                    int i12 = c3776gjvQ.f13771IEE;
                                    iMax2 = i12 <= 0 ? Math.max(i12, measuredHeight) : measuredHeight;
                                    i4 = c3776gjvQ.f13787Pq;
                                    if (i4 > 0) {
                                        iMax2 = Math.min(i4, iMax2);
                                    }
                                    if (!z3 && z10) {
                                        iMax = (int) ((iMax2 * c3776gjvQ.f13818oCFDzJ) + 0.5f);
                                    } else if (z4 && z11) {
                                        iMax2 = (int) ((iMax / c3776gjvQ.f13818oCFDzJ) + 0.5f);
                                    }
                                    if (measuredWidth == iMax || measuredHeight != iMax2) {
                                        if (measuredWidth != iMax) {
                                            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
                                        }
                                        if (measuredHeight != iMax2) {
                                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMax2, 1073741824);
                                        }
                                        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                        iMax = view.getMeasuredWidth();
                                        measuredHeight2 = view.getMeasuredHeight();
                                        baseline = view.getBaseline();
                                    } else {
                                        measuredHeight2 = iMax2;
                                    }
                                    i5 = -1;
                                }
                                int i13 = baseline == i5 ? 1 : i2;
                                mjfkc.f13388qdMbNW = (iMax == mjfkc.f13389wA || measuredHeight2 != mjfkc.f13385ZfxDd) ? 1 : i2;
                                z5 = !c0052AZxh.f712JrJO ? 1 : i13;
                                if (z5 != 0 && baseline != -1 && c3776gjvQ.m12062YoKzxo() != baseline) {
                                    mjfkc.f13388qdMbNW = true;
                                }
                                mjfkc.f13384KLFTb = iMax;
                                mjfkc.f13383JHa = measuredHeight2;
                                mjfkc.f13386lgHUyS = z5;
                                mjfkc.f13390xJ = baseline;
                            }
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f773xJ, i8, -2);
                            boolean z12 = c3776gjvQ.f13781MiMN == 1;
                            int[] iArr7 = c3776gjvQ.f13814lgHUyS;
                            iArr7[3] = 0;
                            if (mjfkc.f13382Dt) {
                                boolean z13 = (!z12 || iArr7[2] == 0 || iArr7[1] == c3776gjvQ.m12051Ucbh()) ? false : true;
                                if (!z12 || z13) {
                                    childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(c3776gjvQ.m12051Ucbh(), 1073741824);
                                }
                            }
                        }
                        iMakeMeasureSpec2 = childMeasureSpec2;
                    } else {
                        childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f773xJ, i8, -2);
                        c3776gjvQ.f13814lgHUyS[3] = -2;
                    }
                    iMakeMeasureSpec2 = childMeasureSpec;
                    z2 = true;
                    C3776gjvQ.AZxh aZxh32 = C3776gjvQ.AZxh.MATCH_CONSTRAINT;
                    if (aZxh != aZxh32) {
                    }
                    if (aZxh2 != aZxh32) {
                    }
                    C3776gjvQ.AZxh aZxh42 = C3776gjvQ.AZxh.MATCH_PARENT;
                    if (aZxh2 != aZxh42) {
                    }
                    if (aZxh != aZxh42) {
                    }
                    if (z8) {
                    }
                    if (z9) {
                    }
                    C0052AZxh c0052AZxh2 = (C0052AZxh) view.getLayoutParams();
                    if (mjfkc.f13382Dt) {
                        if (view instanceof AbstractC1767Ca) {
                            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                            measuredWidth = view.getMeasuredWidth();
                            measuredHeight = view.getMeasuredHeight();
                            baseline = view.getBaseline();
                            if (z) {
                            }
                            if (z2) {
                            }
                            int i112 = c3776gjvQ.f13822rkYL;
                            if (i112 <= 0) {
                            }
                            i3 = c3776gjvQ.f13819qGY;
                            if (i3 > 0) {
                            }
                            int i122 = c3776gjvQ.f13771IEE;
                            if (i122 <= 0) {
                            }
                            i4 = c3776gjvQ.f13787Pq;
                            if (i4 > 0) {
                            }
                            if (!z3) {
                                if (z4) {
                                    iMax2 = (int) ((iMax / c3776gjvQ.f13818oCFDzJ) + 0.5f);
                                }
                                if (measuredWidth == iMax) {
                                    if (measuredWidth != iMax) {
                                    }
                                    if (measuredHeight != iMax2) {
                                    }
                                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                                    iMax = view.getMeasuredWidth();
                                    measuredHeight2 = view.getMeasuredHeight();
                                    baseline = view.getBaseline();
                                    i5 = -1;
                                }
                            }
                        }
                    }
                    if (baseline == i5) {
                    }
                    mjfkc.f13388qdMbNW = (iMax == mjfkc.f13389wA || measuredHeight2 != mjfkc.f13385ZfxDd) ? 1 : i2;
                    if (!c0052AZxh2.f712JrJO) {
                    }
                    if (z5 != 0) {
                        mjfkc.f13388qdMbNW = true;
                    }
                    mjfkc.f13384KLFTb = iMax;
                    mjfkc.f13383JHa = measuredHeight2;
                    mjfkc.f13386lgHUyS = z5;
                    mjfkc.f13390xJ = baseline;
                }
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                c3776gjvQ.f13814lgHUyS[3] = i7;
                z2 = false;
                C3776gjvQ.AZxh aZxh322 = C3776gjvQ.AZxh.MATCH_CONSTRAINT;
                if (aZxh != aZxh322) {
                }
                if (aZxh2 != aZxh322) {
                }
                C3776gjvQ.AZxh aZxh422 = C3776gjvQ.AZxh.MATCH_PARENT;
                if (aZxh2 != aZxh422) {
                }
                if (aZxh != aZxh422) {
                }
                if (z8) {
                }
                if (z9) {
                }
                C0052AZxh c0052AZxh22 = (C0052AZxh) view.getLayoutParams();
                if (mjfkc.f13382Dt) {
                }
                if (baseline == i5) {
                }
                mjfkc.f13388qdMbNW = (iMax == mjfkc.f13389wA || measuredHeight2 != mjfkc.f13385ZfxDd) ? 1 : i2;
                if (!c0052AZxh22.f712JrJO) {
                }
                if (z5 != 0) {
                }
                mjfkc.f13384KLFTb = iMax;
                mjfkc.f13383JHa = measuredHeight2;
                mjfkc.f13386lgHUyS = z5;
                mjfkc.f13390xJ = baseline;
            }
            int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
            c3776gjvQ.f13814lgHUyS[2] = i6;
            iMakeMeasureSpec = iMakeMeasureSpec3;
            z = false;
            i = iArr[aZxh2.ordinal()];
            if (i == 1) {
            }
            z2 = false;
            C3776gjvQ.AZxh aZxh3222 = C3776gjvQ.AZxh.MATCH_CONSTRAINT;
            if (aZxh != aZxh3222) {
            }
            if (aZxh2 != aZxh3222) {
            }
            C3776gjvQ.AZxh aZxh4222 = C3776gjvQ.AZxh.MATCH_PARENT;
            if (aZxh2 != aZxh4222) {
            }
            if (aZxh != aZxh4222) {
            }
            if (z8) {
            }
            if (z9) {
            }
            C0052AZxh c0052AZxh222 = (C0052AZxh) view.getLayoutParams();
            if (mjfkc.f13382Dt) {
            }
            if (baseline == i5) {
            }
            mjfkc.f13388qdMbNW = (iMax == mjfkc.f13389wA || measuredHeight2 != mjfkc.f13385ZfxDd) ? 1 : i2;
            if (!c0052AZxh222.f712JrJO) {
            }
            if (z5 != 0) {
            }
            mjfkc.f13384KLFTb = iMax;
            mjfkc.f13383JHa = measuredHeight2;
            mjfkc.f13386lgHUyS = z5;
            mjfkc.f13390xJ = baseline;
        }

        @Override // p131o.C3582dkKKW.AZxh
        /* renamed from: mjFkc */
        public final void mo408mjFkc() {
            int childCount = this.f771mjFkc.getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.f771mjFkc.getChildAt(i);
            }
            int size = this.f771mjFkc.f674AZxh.size();
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    ((AbstractC0050AZxh) this.f771mjFkc.f674AZxh.get(i2)).m373Dt(this.f771mjFkc);
                }
            }
        }

        /* renamed from: wA */
        public void m409wA(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f766AZxh = i3;
            this.f772wA = i4;
            this.f769ZfxDd = i5;
            this.f768KLFTb = i6;
            this.f767JHa = i;
            this.f773xJ = i2;
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        super(context, attributeSet);
        this.f691mjFkc = new SparseArray();
        this.f674AZxh = new ArrayList(4);
        this.f695wA = new C4052kw();
        this.f685ZfxDd = 0;
        this.f679KLFTb = 0;
        this.f678JHa = Integer.MAX_VALUE;
        this.f696xJ = Integer.MAX_VALUE;
        this.f690lgHUyS = true;
        this.f693qdMbNW = 263;
        this.f675Dt = null;
        this.f676ETF = null;
        this.f683VA = -1;
        this.f680MiMN = new HashMap();
        this.f684YoKzxo = -1;
        this.f694rkYL = -1;
        this.f692qGY = -1;
        this.f688fehf = -1;
        this.f677IEE = 0;
        this.f681Pq = 0;
        this.f686diqgf = new SparseArray();
        this.f687eyqo = new C0054wA(this);
        this.f682Ucbh = 0;
        this.f689huTpC = 0;
        m389Dt(attributeSet, 0, 0);
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int iMax2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    /* renamed from: Dt */
    public final void m389Dt(AttributeSet attributeSet, int i, int i2) throws XmlPullParserException, IOException {
        this.f695wA.m12066bbzow(this);
        this.f695wA.m12629mPWV(this.f687eyqo);
        this.f691mjFkc.put(getId(), this);
        this.f675Dt = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC3005V4.f11127dGDT, i, i2);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == AbstractC3005V4.f10936APn) {
                    this.f685ZfxDd = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f685ZfxDd);
                } else if (index == AbstractC3005V4.f11170knzZ) {
                    this.f679KLFTb = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f679KLFTb);
                } else if (index == AbstractC3005V4.f11006Jidt) {
                    this.f678JHa = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f678JHa);
                } else if (index == AbstractC3005V4.f10996IvRQOa) {
                    this.f696xJ = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f696xJ);
                } else if (index == AbstractC3005V4.f11162jpz) {
                    this.f693qdMbNW = typedArrayObtainStyledAttributes.getInt(index, this.f693qdMbNW);
                } else if (index == AbstractC3005V4.f11238vUsV) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            m394MiMN(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f676ETF = null;
                        }
                    }
                } else if (index == AbstractC3005V4.f11190oVXlhB) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        C0057wA c0057wA = new C0057wA();
                        this.f675Dt = c0057wA;
                        c0057wA.m420ETF(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f675Dt = null;
                    }
                    this.f683VA = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f695wA.m12624dkKKW(this.f693qdMbNW);
    }

    /* renamed from: ETF */
    public boolean m390ETF() {
        return (getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[PHI: r2
      0x003e: PHI (r2v4 o.gjvQ$AZxh) = (r2v3 o.gjvQ$AZxh), (r2v0 o.gjvQ$AZxh) binds: [B:21:0x004a, B:17:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: IEE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m391IEE(C4052kw c4052kw, int i, int i2, int i3, int i4) {
        C3776gjvQ.AZxh aZxh;
        C0054wA c0054wA = this.f687eyqo;
        int i5 = c0054wA.f768KLFTb;
        int i6 = c0054wA.f769ZfxDd;
        C3776gjvQ.AZxh aZxh2 = C3776gjvQ.AZxh.FIXED;
        int childCount = getChildCount();
        if (i == Integer.MIN_VALUE) {
            aZxh = C3776gjvQ.AZxh.WRAP_CONTENT;
            if (childCount == 0) {
                i2 = Math.max(0, this.f685ZfxDd);
            }
        } else if (i == 0) {
            aZxh = C3776gjvQ.AZxh.WRAP_CONTENT;
            i2 = childCount == 0 ? Math.max(0, this.f685ZfxDd) : 0;
        } else if (i != 1073741824) {
            aZxh = aZxh2;
        } else {
            i2 = Math.min(this.f678JHa - i6, i2);
            aZxh = aZxh2;
        }
        if (i3 == Integer.MIN_VALUE) {
            aZxh2 = C3776gjvQ.AZxh.WRAP_CONTENT;
            if (childCount == 0) {
                i4 = Math.max(0, this.f679KLFTb);
            }
        } else if (i3 != 0) {
            i4 = i3 != 1073741824 ? 0 : Math.min(this.f696xJ - i5, i4);
        } else {
            aZxh2 = C3776gjvQ.AZxh.WRAP_CONTENT;
            if (childCount == 0) {
                i4 = Math.max(0, this.f679KLFTb);
            }
        }
        if (i2 != c4052kw.m12096vadzgd() || i4 != c4052kw.m12051Ucbh()) {
            c4052kw.m12612IyS();
        }
        c4052kw.m12093uH(0);
        c4052kw.m12090tISON(0);
        c4052kw.m12047Qr(this.f678JHa - i6);
        c4052kw.m12048SOS(this.f696xJ - i5);
        c4052kw.m12075gtIJp(0);
        c4052kw.m12042NKyg(0);
        c4052kw.m12102yfx(aZxh);
        c4052kw.m12078jx(i2);
        c4052kw.m12071fFz(aZxh2);
        c4052kw.m12023ANMGZc(i4);
        c4052kw.m12075gtIJp(this.f685ZfxDd - i6);
        c4052kw.m12042NKyg(this.f679KLFTb - i5);
    }

    /* renamed from: JHa */
    public Object m392JHa(int i, Object obj) {
        if (i != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap map = this.f680MiMN;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f680MiMN.get(str);
    }

    @Override // android.view.ViewGroup
    /* renamed from: KLFTb, reason: merged with bridge method [inline-methods] */
    public C0052AZxh generateLayoutParams(AttributeSet attributeSet) {
        return new C0052AZxh(getContext(), attributeSet);
    }

    /* renamed from: MiMN */
    public void m394MiMN(int i) {
        this.f676ETF = new C4889xVYW(getContext(), this, i);
    }

    /* renamed from: Pq */
    public final boolean m395Pq() throws IllegalAccessException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            if (getChildAt(i).isLayoutRequested()) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            m401qGY();
        }
        return z;
    }

    /* renamed from: VA */
    public final void m396VA() {
        this.f690lgHUyS = true;
        this.f684YoKzxo = -1;
        this.f694rkYL = -1;
        this.f692qGY = -1;
        this.f688fehf = -1;
        this.f677IEE = 0;
        this.f681Pq = 0;
    }

    /* renamed from: YoKzxo */
    public void m397YoKzxo(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        C0054wA c0054wA = this.f687eyqo;
        int i5 = c0054wA.f768KLFTb;
        int iResolveSizeAndState = View.resolveSizeAndState(i3 + c0054wA.f769ZfxDd, i, 0);
        int iResolveSizeAndState2 = View.resolveSizeAndState(i4 + i5, i2, 0) & 16777215;
        int iMin = Math.min(this.f678JHa, iResolveSizeAndState & 16777215);
        int iMin2 = Math.min(this.f696xJ, iResolveSizeAndState2);
        if (z) {
            iMin |= 16777216;
        }
        if (z2) {
            iMin2 |= 16777216;
        }
        setMeasuredDimension(iMin, iMin2);
        this.f684YoKzxo = iMin;
        this.f694rkYL = iMin2;
    }

    @Override // android.view.ViewGroup
    /* renamed from: ZfxDd, reason: merged with bridge method [inline-methods] */
    public C0052AZxh generateDefaultLayoutParams() {
        return new C0052AZxh(-2, -2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0052AZxh;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) throws NumberFormatException {
        Object tag;
        int size;
        ArrayList arrayList = this.f674AZxh;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i = 0; i < size; i++) {
                ((AbstractC0050AZxh) this.f674AZxh.get(i)).m374ETF(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i3 = Integer.parseInt(strArrSplit[0]);
                        int i4 = Integer.parseInt(strArrSplit[1]);
                        int i5 = Integer.parseInt(strArrSplit[2]);
                        int i6 = (int) ((i3 / 1080.0f) * width);
                        int i7 = (int) ((i4 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = i6;
                        float f2 = i7;
                        float f3 = i6 + ((int) ((i5 / 1080.0f) * width));
                        canvas.drawLine(f, f2, f3, f2, paint);
                        float f4 = i7 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f3, f2, f3, f4, paint);
                        canvas.drawLine(f3, f4, f, f4, paint);
                        canvas.drawLine(f, f4, f, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f2, f3, f4, paint);
                        canvas.drawLine(f, f4, f3, f2, paint);
                    }
                }
            }
        }
    }

    /* renamed from: fehf */
    public void m399fehf(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f680MiMN == null) {
                this.f680MiMN = new HashMap();
            }
            String strSubstring = (String) obj;
            int iIndexOf = strSubstring.indexOf("/");
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            Integer num = (Integer) obj2;
            num.intValue();
            this.f680MiMN.put(strSubstring, num);
        }
    }

    @Override // android.view.View
    public void forceLayout() {
        m396VA();
        super.forceLayout();
    }

    public int getMaxHeight() {
        return this.f696xJ;
    }

    public int getMaxWidth() {
        return this.f678JHa;
    }

    public int getMinHeight() {
        return this.f679KLFTb;
    }

    public int getMinWidth() {
        return this.f685ZfxDd;
    }

    public int getOptimizationLevel() {
        return this.f695wA.m12610FbxKQm();
    }

    /* renamed from: lgHUyS */
    public View m400lgHUyS(int i) {
        return (View) this.f691mjFkc.get(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            C0052AZxh c0052AZxh = (C0052AZxh) childAt.getLayoutParams();
            C3776gjvQ c3776gjvQ = c0052AZxh.f760xROA;
            if ((childAt.getVisibility() != 8 || c0052AZxh.f746nxI || c0052AZxh.f727WGXroI || c0052AZxh.f734bbzow || zIsInEditMode) && !c0052AZxh.f729XV) {
                int iM12085oCFDzJ = c3776gjvQ.m12085oCFDzJ();
                int iM12065aqHPIZ = c3776gjvQ.m12065aqHPIZ();
                childAt.layout(iM12085oCFDzJ, iM12065aqHPIZ, c3776gjvQ.m12096vadzgd() + iM12085oCFDzJ, c3776gjvQ.m12051Ucbh() + iM12065aqHPIZ);
            }
        }
        int size = this.f674AZxh.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                ((AbstractC0050AZxh) this.f674AZxh.get(i6)).m381qdMbNW(this);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        this.f682Ucbh = i;
        this.f689huTpC = i2;
        this.f695wA.m12616NV(m390ETF());
        if (this.f690lgHUyS) {
            this.f690lgHUyS = false;
            if (m395Pq()) {
                this.f695wA.m12611IvRQOa();
            }
        }
        m403rkYL(this.f695wA, this.f693qdMbNW, i, i2);
        m397YoKzxo(i, i2, this.f695wA.m12096vadzgd(), this.f695wA.m12051Ucbh(), this.f695wA.m12621Xxz(), this.f695wA.m12631tAfC());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        C3776gjvQ c3776gjvQM402qdMbNW = m402qdMbNW(view);
        if ((view instanceof C0055ZfxDd) && !(c3776gjvQM402qdMbNW instanceof C4186n)) {
            C0052AZxh c0052AZxh = (C0052AZxh) view.getLayoutParams();
            C4186n c4186n = new C4186n();
            c0052AZxh.f760xROA = c4186n;
            c0052AZxh.f746nxI = true;
            c4186n.m12824SKTn(c0052AZxh.f728WrLQs);
        }
        if (view instanceof AbstractC0050AZxh) {
            AbstractC0050AZxh abstractC0050AZxh = (AbstractC0050AZxh) view;
            abstractC0050AZxh.m377MiMN();
            ((C0052AZxh) view.getLayoutParams()).f727WGXroI = true;
            if (!this.f674AZxh.contains(abstractC0050AZxh)) {
                this.f674AZxh.add(abstractC0050AZxh);
            }
        }
        this.f691mjFkc.put(view.getId(), view);
        this.f690lgHUyS = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f691mjFkc.remove(view.getId());
        this.f695wA.m8792XD(m402qdMbNW(view));
        this.f674AZxh.remove(view);
        this.f690lgHUyS = true;
    }

    /* renamed from: qGY */
    public final void m401qGY() throws IllegalAccessException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        boolean zIsInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            C3776gjvQ c3776gjvQM402qdMbNW = m402qdMbNW(getChildAt(i));
            if (c3776gjvQM402qdMbNW != null) {
                c3776gjvQM402qdMbNW.mo8790JrJO();
            }
        }
        if (zIsInEditMode) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    m399fehf(0, resourceName, Integer.valueOf(childAt.getId()));
                    int iIndexOf = resourceName.indexOf(47);
                    if (iIndexOf != -1) {
                        resourceName = resourceName.substring(iIndexOf + 1);
                    }
                    m405xJ(childAt.getId()).m12050SwgkN(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.f683VA != -1) {
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).getId();
            }
        }
        C0057wA c0057wA = this.f675Dt;
        if (c0057wA != null) {
            c0057wA.m425ZfxDd(this, true);
        }
        this.f695wA.m8793gtr();
        int size = this.f674AZxh.size();
        if (size > 0) {
            for (int i4 = 0; i4 < size; i4++) {
                ((AbstractC0050AZxh) this.f674AZxh.get(i4)).m378VA(this);
            }
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5);
        }
        this.f686diqgf.clear();
        this.f686diqgf.put(0, this.f695wA);
        this.f686diqgf.put(getId(), this.f695wA);
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt2 = getChildAt(i6);
            this.f686diqgf.put(childAt2.getId(), m402qdMbNW(childAt2));
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt3 = getChildAt(i7);
            C3776gjvQ c3776gjvQM402qdMbNW2 = m402qdMbNW(childAt3);
            if (c3776gjvQM402qdMbNW2 != null) {
                C0052AZxh c0052AZxh = (C0052AZxh) childAt3.getLayoutParams();
                this.f695wA.m8789AZxh(c3776gjvQM402qdMbNW2);
                m404wA(zIsInEditMode, childAt3, c3776gjvQM402qdMbNW2, c0052AZxh, this.f686diqgf);
            }
        }
    }

    /* renamed from: qdMbNW */
    public final C3776gjvQ m402qdMbNW(View view) {
        if (view == this) {
            return this.f695wA;
        }
        if (view == null) {
            return null;
        }
        return ((C0052AZxh) view.getLayoutParams()).f760xROA;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        m396VA();
        super.requestLayout();
    }

    /* renamed from: rkYL */
    public void m403rkYL(C4052kw c4052kw, int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int iMax = Math.max(0, getPaddingTop());
        int iMax2 = Math.max(0, getPaddingBottom());
        int i4 = iMax + iMax2;
        int paddingWidth = getPaddingWidth();
        this.f687eyqo.m409wA(i2, i3, iMax, iMax2, paddingWidth, i4);
        int iMax3 = Math.max(0, getPaddingStart());
        int iMax4 = Math.max(0, getPaddingEnd());
        if (iMax3 <= 0 && iMax4 <= 0) {
            iMax4 = Math.max(0, getPaddingLeft());
        } else if (!m390ETF()) {
            iMax4 = iMax3;
        }
        int i5 = size - paddingWidth;
        int i6 = size2 - i4;
        m391IEE(c4052kw, mode, i5, mode2, i6);
        c4052kw.m12622Zdbk(i, mode, i5, mode2, i6, this.f684YoKzxo, this.f694rkYL, iMax4, iMax);
    }

    public void setConstraintSet(C0057wA c0057wA) {
        this.f675Dt = c0057wA;
    }

    @Override // android.view.View
    public void setId(int i) {
        this.f691mjFkc.remove(getId());
        super.setId(i);
        this.f691mjFkc.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i == this.f696xJ) {
            return;
        }
        this.f696xJ = i;
        requestLayout();
    }

    public void setMaxWidth(int i) {
        if (i == this.f678JHa) {
            return;
        }
        this.f678JHa = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.f679KLFTb) {
            return;
        }
        this.f679KLFTb = i;
        requestLayout();
    }

    public void setMinWidth(int i) {
        if (i == this.f685ZfxDd) {
            return;
        }
        this.f685ZfxDd = i;
        requestLayout();
    }

    public void setOnConstraintsChanged(AbstractC3900ih abstractC3900ih) {
        C4889xVYW c4889xVYW = this.f676ETF;
        if (c4889xVYW != null) {
            c4889xVYW.m13948wA(abstractC3900ih);
        }
    }

    public void setOptimizationLevel(int i) {
        this.f693qdMbNW = i;
        this.f695wA.m12624dkKKW(i);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* renamed from: wA */
    public void m404wA(boolean z, View view, C3776gjvQ c3776gjvQ, C0052AZxh c0052AZxh, SparseArray sparseArray) throws NumberFormatException {
        float f;
        C3776gjvQ c3776gjvQ2;
        C3776gjvQ c3776gjvQ3;
        C3776gjvQ c3776gjvQ4;
        C3776gjvQ c3776gjvQ5;
        int i;
        c0052AZxh.m406mjFkc();
        c0052AZxh.f707IVlxe = false;
        c3776gjvQ.m12061XtE(view.getVisibility());
        if (c0052AZxh.f729XV) {
            c3776gjvQ.m12041Moer(true);
            c3776gjvQ.m12061XtE(8);
        }
        c3776gjvQ.m12066bbzow(view);
        if (view instanceof AbstractC0050AZxh) {
            ((AbstractC0050AZxh) view).mo370lgHUyS(c3776gjvQ, this.f695wA.m12623dGDT());
        }
        if (c0052AZxh.f746nxI) {
            C4186n c4186n = (C4186n) c3776gjvQ;
            int i2 = c0052AZxh.f752tQ;
            int i3 = c0052AZxh.f762yfx;
            float f2 = c0052AZxh.f756vjlshU;
            if (f2 != -1.0f) {
                c4186n.m12823Rc(f2);
                return;
            } else if (i2 != -1) {
                c4186n.m12826fLidf(i2);
                return;
            } else {
                if (i3 != -1) {
                    c4186n.m12828hvGY(i3);
                    return;
                }
                return;
            }
        }
        int i4 = c0052AZxh.f721SwgkN;
        int i5 = c0052AZxh.f708JBhc;
        int i6 = c0052AZxh.f724Vdz;
        int i7 = c0052AZxh.f741jm;
        int i8 = c0052AZxh.f697ANMGZc;
        int i9 = c0052AZxh.f732alEkx;
        float f3 = c0052AZxh.f737dm;
        int i10 = c0052AZxh.f716MiMN;
        if (i10 != -1) {
            C3776gjvQ c3776gjvQ6 = (C3776gjvQ) sparseArray.get(i10);
            if (c3776gjvQ6 != null) {
                c3776gjvQ.m12027ETF(c3776gjvQ6, c0052AZxh.f751rkYL, c0052AZxh.f730YoKzxo);
            }
        } else {
            if (i4 != -1) {
                C3776gjvQ c3776gjvQ7 = (C3776gjvQ) sparseArray.get(i4);
                if (c3776gjvQ7 != null) {
                    C4446qtZIjO.AZxh aZxh = C4446qtZIjO.AZxh.LEFT;
                    f = f3;
                    c3776gjvQ.m12038KRTLGT(aZxh, c3776gjvQ7, aZxh, ((ViewGroup.MarginLayoutParams) c0052AZxh).leftMargin, i8);
                } else {
                    f = f3;
                }
            } else {
                f = f3;
                if (i5 != -1 && (c3776gjvQ2 = (C3776gjvQ) sparseArray.get(i5)) != null) {
                    c3776gjvQ.m12038KRTLGT(C4446qtZIjO.AZxh.LEFT, c3776gjvQ2, C4446qtZIjO.AZxh.RIGHT, ((ViewGroup.MarginLayoutParams) c0052AZxh).leftMargin, i8);
                }
            }
            if (i6 != -1) {
                C3776gjvQ c3776gjvQ8 = (C3776gjvQ) sparseArray.get(i6);
                if (c3776gjvQ8 != null) {
                    c3776gjvQ.m12038KRTLGT(C4446qtZIjO.AZxh.RIGHT, c3776gjvQ8, C4446qtZIjO.AZxh.LEFT, ((ViewGroup.MarginLayoutParams) c0052AZxh).rightMargin, i9);
                }
            } else if (i7 != -1 && (c3776gjvQ3 = (C3776gjvQ) sparseArray.get(i7)) != null) {
                C4446qtZIjO.AZxh aZxh2 = C4446qtZIjO.AZxh.RIGHT;
                c3776gjvQ.m12038KRTLGT(aZxh2, c3776gjvQ3, aZxh2, ((ViewGroup.MarginLayoutParams) c0052AZxh).rightMargin, i9);
            }
            int i11 = c0052AZxh.f743lgHUyS;
            if (i11 != -1) {
                C3776gjvQ c3776gjvQ9 = (C3776gjvQ) sparseArray.get(i11);
                if (c3776gjvQ9 != null) {
                    C4446qtZIjO.AZxh aZxh3 = C4446qtZIjO.AZxh.TOP;
                    c3776gjvQ.m12038KRTLGT(aZxh3, c3776gjvQ9, aZxh3, ((ViewGroup.MarginLayoutParams) c0052AZxh).topMargin, c0052AZxh.f738eyqo);
                }
            } else {
                int i12 = c0052AZxh.f749qdMbNW;
                if (i12 != -1 && (c3776gjvQ4 = (C3776gjvQ) sparseArray.get(i12)) != null) {
                    c3776gjvQ.m12038KRTLGT(C4446qtZIjO.AZxh.TOP, c3776gjvQ4, C4446qtZIjO.AZxh.BOTTOM, ((ViewGroup.MarginLayoutParams) c0052AZxh).topMargin, c0052AZxh.f738eyqo);
                }
            }
            int i13 = c0052AZxh.f701Dt;
            if (i13 != -1) {
                C3776gjvQ c3776gjvQ10 = (C3776gjvQ) sparseArray.get(i13);
                if (c3776gjvQ10 != null) {
                    c3776gjvQ.m12038KRTLGT(C4446qtZIjO.AZxh.BOTTOM, c3776gjvQ10, C4446qtZIjO.AZxh.TOP, ((ViewGroup.MarginLayoutParams) c0052AZxh).bottomMargin, c0052AZxh.f740huTpC);
                }
            } else {
                int i14 = c0052AZxh.f702ETF;
                if (i14 != -1 && (c3776gjvQ5 = (C3776gjvQ) sparseArray.get(i14)) != null) {
                    C4446qtZIjO.AZxh aZxh4 = C4446qtZIjO.AZxh.BOTTOM;
                    c3776gjvQ.m12038KRTLGT(aZxh4, c3776gjvQ5, aZxh4, ((ViewGroup.MarginLayoutParams) c0052AZxh).bottomMargin, c0052AZxh.f740huTpC);
                }
            }
            int i15 = c0052AZxh.f723VA;
            if (i15 != -1) {
                View view2 = (View) this.f691mjFkc.get(i15);
                C3776gjvQ c3776gjvQ11 = (C3776gjvQ) sparseArray.get(c0052AZxh.f723VA);
                if (c3776gjvQ11 != null && view2 != null && (view2.getLayoutParams() instanceof C0052AZxh)) {
                    C0052AZxh c0052AZxh2 = (C0052AZxh) view2.getLayoutParams();
                    c0052AZxh.f712JrJO = true;
                    c0052AZxh2.f712JrJO = true;
                    C4446qtZIjO.AZxh aZxh5 = C4446qtZIjO.AZxh.BASELINE;
                    c3776gjvQ.mo12040MiMN(aZxh5).m13309AZxh(c3776gjvQ11.mo12040MiMN(aZxh5), 0, -1, true);
                    c3776gjvQ.m12077jm(true);
                    c0052AZxh2.f760xROA.m12077jm(true);
                    c3776gjvQ.mo12040MiMN(C4446qtZIjO.AZxh.TOP).m13315VA();
                    c3776gjvQ.mo12040MiMN(C4446qtZIjO.AZxh.BOTTOM).m13315VA();
                }
            }
            float f4 = f;
            if (f4 >= 0.0f) {
                c3776gjvQ.m12064alEkx(f4);
            }
            float f5 = c0052AZxh.f726VocHEe;
            if (f5 >= 0.0f) {
                c3776gjvQ.m12101yX(f5);
            }
        }
        if (z && ((i = c0052AZxh.f747oCFDzJ) != -1 || c0052AZxh.f733aqHPIZ != -1)) {
            c3776gjvQ.m12079kism(i, c0052AZxh.f733aqHPIZ);
        }
        if (c0052AZxh.f711JYn) {
            c3776gjvQ.m12102yfx(C3776gjvQ.AZxh.FIXED);
            c3776gjvQ.m12078jx(((ViewGroup.MarginLayoutParams) c0052AZxh).width);
            if (((ViewGroup.MarginLayoutParams) c0052AZxh).width == -2) {
                c3776gjvQ.m12102yfx(C3776gjvQ.AZxh.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) c0052AZxh).width == -1) {
            if (c0052AZxh.f715KRTLGT) {
                c3776gjvQ.m12102yfx(C3776gjvQ.AZxh.MATCH_CONSTRAINT);
            } else {
                c3776gjvQ.m12102yfx(C3776gjvQ.AZxh.MATCH_PARENT);
            }
            c3776gjvQ.mo12040MiMN(C4446qtZIjO.AZxh.LEFT).f16247KLFTb = ((ViewGroup.MarginLayoutParams) c0052AZxh).leftMargin;
            c3776gjvQ.mo12040MiMN(C4446qtZIjO.AZxh.RIGHT).f16247KLFTb = ((ViewGroup.MarginLayoutParams) c0052AZxh).rightMargin;
        } else {
            c3776gjvQ.m12102yfx(C3776gjvQ.AZxh.MATCH_CONSTRAINT);
            c3776gjvQ.m12078jx(0);
        }
        if (c0052AZxh.f710JYgkl) {
            c3776gjvQ.m12071fFz(C3776gjvQ.AZxh.FIXED);
            c3776gjvQ.m12023ANMGZc(((ViewGroup.MarginLayoutParams) c0052AZxh).height);
            if (((ViewGroup.MarginLayoutParams) c0052AZxh).height == -2) {
                c3776gjvQ.m12071fFz(C3776gjvQ.AZxh.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) c0052AZxh).height == -1) {
            if (c0052AZxh.f703GMIER) {
                c3776gjvQ.m12071fFz(C3776gjvQ.AZxh.MATCH_CONSTRAINT);
            } else {
                c3776gjvQ.m12071fFz(C3776gjvQ.AZxh.MATCH_PARENT);
            }
            c3776gjvQ.mo12040MiMN(C4446qtZIjO.AZxh.TOP).f16247KLFTb = ((ViewGroup.MarginLayoutParams) c0052AZxh).topMargin;
            c3776gjvQ.mo12040MiMN(C4446qtZIjO.AZxh.BOTTOM).f16247KLFTb = ((ViewGroup.MarginLayoutParams) c0052AZxh).bottomMargin;
        } else {
            c3776gjvQ.m12071fFz(C3776gjvQ.AZxh.MATCH_CONSTRAINT);
            c3776gjvQ.m12023ANMGZc(0);
        }
        c3776gjvQ.m12033JBhc(c0052AZxh.f699BAnRFn);
        c3776gjvQ.m12099xROA(c0052AZxh.f744mByQ);
        c3776gjvQ.m12058XFUzSY(c0052AZxh.f719OjSQV);
        c3776gjvQ.m12069dm(c0052AZxh.f718Ne);
        c3776gjvQ.m12073gYa(c0052AZxh.f700CqaNbM);
        c3776gjvQ.m12097vjlshU(c0052AZxh.f761xrEuO, c0052AZxh.f763zvd, c0052AZxh.f750rWxwaT, c0052AZxh.f717NPj);
        c3776gjvQ.m12060XbiWeM(c0052AZxh.f714KLMXS, c0052AZxh.f735cMLeY, c0052AZxh.f725Vnb, c0052AZxh.f755vadzgd);
    }

    /* renamed from: xJ */
    public final C3776gjvQ m405xJ(int i) {
        if (i == 0) {
            return this.f695wA;
        }
        View viewFindViewById = (View) this.f691mjFkc.get(i);
        if (viewFindViewById == null && (viewFindViewById = findViewById(i)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
            onViewAdded(viewFindViewById);
        }
        if (viewFindViewById == this) {
            return this.f695wA;
        }
        if (viewFindViewById == null) {
            return null;
        }
        return ((C0052AZxh) viewFindViewById.getLayoutParams()).f760xROA;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0052AZxh(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) throws XmlPullParserException, IOException {
        super(context, attributeSet, i);
        this.f691mjFkc = new SparseArray();
        this.f674AZxh = new ArrayList(4);
        this.f695wA = new C4052kw();
        this.f685ZfxDd = 0;
        this.f679KLFTb = 0;
        this.f678JHa = Integer.MAX_VALUE;
        this.f696xJ = Integer.MAX_VALUE;
        this.f690lgHUyS = true;
        this.f693qdMbNW = 263;
        this.f675Dt = null;
        this.f676ETF = null;
        this.f683VA = -1;
        this.f680MiMN = new HashMap();
        this.f684YoKzxo = -1;
        this.f694rkYL = -1;
        this.f692qGY = -1;
        this.f688fehf = -1;
        this.f677IEE = 0;
        this.f681Pq = 0;
        this.f686diqgf = new SparseArray();
        this.f687eyqo = new C0054wA(this);
        this.f682Ucbh = 0;
        this.f689huTpC = 0;
        m389Dt(attributeSet, i, 0);
    }

    /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$AZxh */
    public static class C0052AZxh extends ViewGroup.MarginLayoutParams {

        /* renamed from: ANMGZc */
        public int f697ANMGZc;

        /* renamed from: AZxh */
        public int f698AZxh;

        /* renamed from: BAnRFn */
        public String f699BAnRFn;

        /* renamed from: CqaNbM */
        public int f700CqaNbM;

        /* renamed from: Dt */
        public int f701Dt;

        /* renamed from: ETF */
        public int f702ETF;

        /* renamed from: GMIER */
        public boolean f703GMIER;

        /* renamed from: Gd */
        public int f704Gd;

        /* renamed from: HGpJ */
        public int f705HGpJ;

        /* renamed from: IEE */
        public int f706IEE;

        /* renamed from: IVlxe */
        public boolean f707IVlxe;

        /* renamed from: JBhc */
        public int f708JBhc;

        /* renamed from: JHa */
        public int f709JHa;

        /* renamed from: JYgkl */
        public boolean f710JYgkl;

        /* renamed from: JYn */
        public boolean f711JYn;

        /* renamed from: JrJO */
        public boolean f712JrJO;

        /* renamed from: KLFTb */
        public int f713KLFTb;

        /* renamed from: KLMXS */
        public int f714KLMXS;

        /* renamed from: KRTLGT */
        public boolean f715KRTLGT;

        /* renamed from: MiMN */
        public int f716MiMN;

        /* renamed from: NPj */
        public float f717NPj;

        /* renamed from: Ne */
        public int f718Ne;

        /* renamed from: OjSQV */
        public float f719OjSQV;

        /* renamed from: Pq */
        public int f720Pq;

        /* renamed from: SwgkN */
        public int f721SwgkN;

        /* renamed from: Ucbh */
        public int f722Ucbh;

        /* renamed from: VA */
        public int f723VA;

        /* renamed from: Vdz */
        public int f724Vdz;

        /* renamed from: Vnb */
        public int f725Vnb;

        /* renamed from: VocHEe */
        public float f726VocHEe;

        /* renamed from: WGXroI */
        public boolean f727WGXroI;

        /* renamed from: WrLQs */
        public int f728WrLQs;

        /* renamed from: XV */
        public boolean f729XV;

        /* renamed from: YoKzxo */
        public int f730YoKzxo;

        /* renamed from: ZfxDd */
        public int f731ZfxDd;

        /* renamed from: alEkx */
        public int f732alEkx;

        /* renamed from: aqHPIZ */
        public int f733aqHPIZ;

        /* renamed from: bbzow */
        public boolean f734bbzow;

        /* renamed from: cMLeY */
        public int f735cMLeY;

        /* renamed from: diqgf */
        public int f736diqgf;

        /* renamed from: dm */
        public float f737dm;

        /* renamed from: eyqo */
        public int f738eyqo;

        /* renamed from: fehf */
        public int f739fehf;

        /* renamed from: huTpC */
        public int f740huTpC;

        /* renamed from: jm */
        public int f741jm;

        /* renamed from: lB */
        public float f742lB;

        /* renamed from: lgHUyS */
        public int f743lgHUyS;

        /* renamed from: mByQ */
        public float f744mByQ;

        /* renamed from: mjFkc */
        public int f745mjFkc;

        /* renamed from: nxI */
        public boolean f746nxI;

        /* renamed from: oCFDzJ */
        public int f747oCFDzJ;

        /* renamed from: qGY */
        public int f748qGY;

        /* renamed from: qdMbNW */
        public int f749qdMbNW;

        /* renamed from: rWxwaT */
        public int f750rWxwaT;

        /* renamed from: rkYL */
        public float f751rkYL;

        /* renamed from: tQ */
        public int f752tQ;

        /* renamed from: uHVRx */
        public String f753uHVRx;

        /* renamed from: vI */
        public float f754vI;

        /* renamed from: vadzgd */
        public float f755vadzgd;

        /* renamed from: vjlshU */
        public float f756vjlshU;

        /* renamed from: wA */
        public float f757wA;

        /* renamed from: wJVbdd */
        public int f758wJVbdd;

        /* renamed from: xJ */
        public int f759xJ;

        /* renamed from: xROA */
        public C3776gjvQ f760xROA;

        /* renamed from: xrEuO */
        public int f761xrEuO;

        /* renamed from: yfx */
        public int f762yfx;

        /* renamed from: zvd */
        public int f763zvd;

        /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$AZxh$mjFkc */
        public static class mjFkc {

            /* renamed from: mjFkc */
            public static final SparseIntArray f764mjFkc;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f764mjFkc = sparseIntArray;
                sparseIntArray.append(AbstractC3005V4.f11189oJ, 8);
                sparseIntArray.append(AbstractC3005V4.f11119bWIyu, 9);
                sparseIntArray.append(AbstractC3005V4.f11067UDcil, 10);
                sparseIntArray.append(AbstractC3005V4.f11159jY, 11);
                sparseIntArray.append(AbstractC3005V4.f11064TFbkuO, 12);
                sparseIntArray.append(AbstractC3005V4.f11221tPvjn, 13);
                sparseIntArray.append(AbstractC3005V4.f10982HExgdj, 14);
                sparseIntArray.append(AbstractC3005V4.f11049QyMqpM, 15);
                sparseIntArray.append(AbstractC3005V4.f11197pJeaSR, 16);
                sparseIntArray.append(AbstractC3005V4.f11015KSf, 2);
                sparseIntArray.append(AbstractC3005V4.f11203qrxT, 3);
                sparseIntArray.append(AbstractC3005V4.f11083Vptz, 4);
                sparseIntArray.append(AbstractC3005V4.f11249xBQUgd, 49);
                sparseIntArray.append(AbstractC3005V4.f11023MFekjo, 50);
                sparseIntArray.append(AbstractC3005V4.f11256xbjHT, 5);
                sparseIntArray.append(AbstractC3005V4.f11264zPp, 6);
                sparseIntArray.append(AbstractC3005V4.f11022MC, 7);
                sparseIntArray.append(AbstractC3005V4.f11099Xxz, 1);
                sparseIntArray.append(AbstractC3005V4.f11069UOnCkw, 17);
                sparseIntArray.append(AbstractC3005V4.f11063Sx, 18);
                sparseIntArray.append(AbstractC3005V4.f10963EoC, 19);
                sparseIntArray.append(AbstractC3005V4.f10987HX, 20);
                sparseIntArray.append(AbstractC3005V4.f11167kOlLW, 21);
                sparseIntArray.append(AbstractC3005V4.f11106ZGL, 22);
                sparseIntArray.append(AbstractC3005V4.f11019LlB, 23);
                sparseIntArray.append(AbstractC3005V4.f11070UPU, 24);
                sparseIntArray.append(AbstractC3005V4.f10964Es, 25);
                sparseIntArray.append(AbstractC3005V4.f10991IPpyV, 26);
                sparseIntArray.append(AbstractC3005V4.f11056Rsp, 29);
                sparseIntArray.append(AbstractC3005V4.f11039Otxclu, 30);
                sparseIntArray.append(AbstractC3005V4.f10950CcoH, 44);
                sparseIntArray.append(AbstractC3005V4.f11029Mpf, 45);
                sparseIntArray.append(AbstractC3005V4.f10939ArO, 46);
                sparseIntArray.append(AbstractC3005V4.f11257xfXeiC, 47);
                sparseIntArray.append(AbstractC3005V4.f11040OzIs, 48);
                sparseIntArray.append(AbstractC3005V4.f10958ERt, 27);
                sparseIntArray.append(AbstractC3005V4.f10966FOJ, 28);
                sparseIntArray.append(AbstractC3005V4.f11053RWb, 31);
                sparseIntArray.append(AbstractC3005V4.f11114aDq, 32);
                sparseIntArray.append(AbstractC3005V4.f10961EeoThB, 33);
                sparseIntArray.append(AbstractC3005V4.f11158jTNPnW, 34);
                sparseIntArray.append(AbstractC3005V4.f11126cdjp, 35);
                sparseIntArray.append(AbstractC3005V4.f11065TvfBiy, 36);
                sparseIntArray.append(AbstractC3005V4.f11239vZ, 37);
                sparseIntArray.append(AbstractC3005V4.f10952CqAnRZ, 38);
                sparseIntArray.append(AbstractC3005V4.f10988Hk, 39);
                sparseIntArray.append(AbstractC3005V4.f11244wGscSa, 40);
                sparseIntArray.append(AbstractC3005V4.f11100XyP, 41);
                sparseIntArray.append(AbstractC3005V4.f11186np, 42);
                sparseIntArray.append(AbstractC3005V4.f11003JOe, 43);
                sparseIntArray.append(AbstractC3005V4.f11198peCqC, 51);
            }
        }

        public C0052AZxh(Context context, AttributeSet attributeSet) throws NumberFormatException {
            int i;
            super(context, attributeSet);
            this.f745mjFkc = -1;
            this.f698AZxh = -1;
            this.f757wA = -1.0f;
            this.f731ZfxDd = -1;
            this.f713KLFTb = -1;
            this.f709JHa = -1;
            this.f759xJ = -1;
            this.f743lgHUyS = -1;
            this.f749qdMbNW = -1;
            this.f701Dt = -1;
            this.f702ETF = -1;
            this.f723VA = -1;
            this.f716MiMN = -1;
            this.f730YoKzxo = 0;
            this.f751rkYL = 0.0f;
            this.f748qGY = -1;
            this.f739fehf = -1;
            this.f706IEE = -1;
            this.f720Pq = -1;
            this.f736diqgf = -1;
            this.f738eyqo = -1;
            this.f722Ucbh = -1;
            this.f740huTpC = -1;
            this.f704Gd = -1;
            this.f705HGpJ = -1;
            this.f754vI = 0.5f;
            this.f726VocHEe = 0.5f;
            this.f699BAnRFn = null;
            this.f742lB = 0.0f;
            this.f758wJVbdd = 1;
            this.f744mByQ = -1.0f;
            this.f719OjSQV = -1.0f;
            this.f718Ne = 0;
            this.f700CqaNbM = 0;
            this.f761xrEuO = 0;
            this.f714KLMXS = 0;
            this.f763zvd = 0;
            this.f735cMLeY = 0;
            this.f750rWxwaT = 0;
            this.f725Vnb = 0;
            this.f717NPj = 1.0f;
            this.f755vadzgd = 1.0f;
            this.f747oCFDzJ = -1;
            this.f733aqHPIZ = -1;
            this.f728WrLQs = -1;
            this.f715KRTLGT = false;
            this.f703GMIER = false;
            this.f753uHVRx = null;
            this.f711JYn = true;
            this.f710JYgkl = true;
            this.f712JrJO = false;
            this.f746nxI = false;
            this.f727WGXroI = false;
            this.f729XV = false;
            this.f734bbzow = false;
            this.f721SwgkN = -1;
            this.f708JBhc = -1;
            this.f724Vdz = -1;
            this.f741jm = -1;
            this.f697ANMGZc = -1;
            this.f732alEkx = -1;
            this.f737dm = 0.5f;
            this.f760xROA = new C3776gjvQ();
            this.f707IVlxe = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3005V4.f11127dGDT);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                int i3 = mjFkc.f764mjFkc.get(index);
                switch (i3) {
                    case 1:
                        this.f728WrLQs = typedArrayObtainStyledAttributes.getInt(index, this.f728WrLQs);
                        break;
                    case 2:
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f716MiMN);
                        this.f716MiMN = resourceId;
                        if (resourceId == -1) {
                            this.f716MiMN = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.f730YoKzxo = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f730YoKzxo);
                        break;
                    case 4:
                        float f = typedArrayObtainStyledAttributes.getFloat(index, this.f751rkYL) % 360.0f;
                        this.f751rkYL = f;
                        if (f < 0.0f) {
                            this.f751rkYL = (360.0f - f) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f745mjFkc = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f745mjFkc);
                        break;
                    case 6:
                        this.f698AZxh = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f698AZxh);
                        break;
                    case 7:
                        this.f757wA = typedArrayObtainStyledAttributes.getFloat(index, this.f757wA);
                        break;
                    case 8:
                        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.f731ZfxDd);
                        this.f731ZfxDd = resourceId2;
                        if (resourceId2 == -1) {
                            this.f731ZfxDd = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.f713KLFTb);
                        this.f713KLFTb = resourceId3;
                        if (resourceId3 == -1) {
                            this.f713KLFTb = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.f709JHa);
                        this.f709JHa = resourceId4;
                        if (resourceId4 == -1) {
                            this.f709JHa = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.f759xJ);
                        this.f759xJ = resourceId5;
                        if (resourceId5 == -1) {
                            this.f759xJ = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.f743lgHUyS);
                        this.f743lgHUyS = resourceId6;
                        if (resourceId6 == -1) {
                            this.f743lgHUyS = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.f749qdMbNW);
                        this.f749qdMbNW = resourceId7;
                        if (resourceId7 == -1) {
                            this.f749qdMbNW = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.f701Dt);
                        this.f701Dt = resourceId8;
                        if (resourceId8 == -1) {
                            this.f701Dt = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.f702ETF);
                        this.f702ETF = resourceId9;
                        if (resourceId9 == -1) {
                            this.f702ETF = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.f723VA);
                        this.f723VA = resourceId10;
                        if (resourceId10 == -1) {
                            this.f723VA = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.f748qGY);
                        this.f748qGY = resourceId11;
                        if (resourceId11 == -1) {
                            this.f748qGY = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.f739fehf);
                        this.f739fehf = resourceId12;
                        if (resourceId12 == -1) {
                            this.f739fehf = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.f706IEE);
                        this.f706IEE = resourceId13;
                        if (resourceId13 == -1) {
                            this.f706IEE = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.f720Pq);
                        this.f720Pq = resourceId14;
                        if (resourceId14 == -1) {
                            this.f720Pq = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.f736diqgf = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f736diqgf);
                        break;
                    case 22:
                        this.f738eyqo = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f738eyqo);
                        break;
                    case 23:
                        this.f722Ucbh = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f722Ucbh);
                        break;
                    case 24:
                        this.f740huTpC = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f740huTpC);
                        break;
                    case 25:
                        this.f704Gd = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f704Gd);
                        break;
                    case 26:
                        this.f705HGpJ = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f705HGpJ);
                        break;
                    case 27:
                        this.f715KRTLGT = typedArrayObtainStyledAttributes.getBoolean(index, this.f715KRTLGT);
                        break;
                    case 28:
                        this.f703GMIER = typedArrayObtainStyledAttributes.getBoolean(index, this.f703GMIER);
                        break;
                    case 29:
                        this.f754vI = typedArrayObtainStyledAttributes.getFloat(index, this.f754vI);
                        break;
                    case 30:
                        this.f726VocHEe = typedArrayObtainStyledAttributes.getFloat(index, this.f726VocHEe);
                        break;
                    case InterfaceC5102BERTags.f17975DATE /* 31 */:
                        int i4 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f761xrEuO = i4;
                        if (i4 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i5 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f714KLMXS = i5;
                        if (i5 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.f763zvd = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f763zvd);
                            break;
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f763zvd) == -2) {
                                this.f763zvd = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.f750rWxwaT = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f750rWxwaT);
                            break;
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f750rWxwaT) == -2) {
                                this.f750rWxwaT = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.f717NPj = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f717NPj));
                        this.f761xrEuO = 2;
                        break;
                    case 36:
                        try {
                            this.f735cMLeY = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f735cMLeY);
                            break;
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f735cMLeY) == -2) {
                                this.f735cMLeY = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case C5125EACTags.APPLICATION_EFFECTIVE_DATE /* 37 */:
                        try {
                            this.f725Vnb = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f725Vnb);
                            break;
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f725Vnb) == -2) {
                                this.f725Vnb = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case C5125EACTags.CARD_EFFECTIVE_DATE /* 38 */:
                        this.f755vadzgd = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f755vadzgd));
                        this.f714KLMXS = 2;
                        break;
                    default:
                        switch (i3) {
                            case C5125EACTags.CARDHOLDER_NATIONALITY /* 44 */:
                                String string = typedArrayObtainStyledAttributes.getString(index);
                                this.f699BAnRFn = string;
                                this.f742lB = Float.NaN;
                                this.f758wJVbdd = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int iIndexOf = this.f699BAnRFn.indexOf(44);
                                    if (iIndexOf <= 0 || iIndexOf >= length - 1) {
                                        i = 0;
                                    } else {
                                        String strSubstring = this.f699BAnRFn.substring(0, iIndexOf);
                                        if (strSubstring.equalsIgnoreCase("W")) {
                                            this.f758wJVbdd = 0;
                                        } else if (strSubstring.equalsIgnoreCase("H")) {
                                            this.f758wJVbdd = 1;
                                        }
                                        i = iIndexOf + 1;
                                    }
                                    int iIndexOf2 = this.f699BAnRFn.indexOf(58);
                                    if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                                        String strSubstring2 = this.f699BAnRFn.substring(i);
                                        if (strSubstring2.length() > 0) {
                                            this.f742lB = Float.parseFloat(strSubstring2);
                                            break;
                                        } else {
                                            break;
                                        }
                                    } else {
                                        String strSubstring3 = this.f699BAnRFn.substring(i, iIndexOf2);
                                        String strSubstring4 = this.f699BAnRFn.substring(iIndexOf2 + 1);
                                        if (strSubstring3.length() <= 0 || strSubstring4.length() <= 0) {
                                            break;
                                        } else {
                                            try {
                                                float f2 = Float.parseFloat(strSubstring3);
                                                float f3 = Float.parseFloat(strSubstring4);
                                                if (f2 <= 0.0f || f3 <= 0.0f) {
                                                    break;
                                                } else if (this.f758wJVbdd == 1) {
                                                    this.f742lB = Math.abs(f3 / f2);
                                                    break;
                                                } else {
                                                    this.f742lB = Math.abs(f2 / f3);
                                                    break;
                                                }
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    }
                                } else {
                                    break;
                                }
                                break;
                            case C5125EACTags.LANGUAGE_PREFERENCES /* 45 */:
                                this.f744mByQ = typedArrayObtainStyledAttributes.getFloat(index, this.f744mByQ);
                                break;
                            case 46:
                                this.f719OjSQV = typedArrayObtainStyledAttributes.getFloat(index, this.f719OjSQV);
                                break;
                            case C5125EACTags.PIN_USAGE_POLICY /* 47 */:
                                this.f718Ne = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.f700CqaNbM = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.f747oCFDzJ = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f747oCFDzJ);
                                break;
                            case 50:
                                this.f733aqHPIZ = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f733aqHPIZ);
                                break;
                            case C5125EACTags.TRANSACTION_DATE /* 51 */:
                                this.f753uHVRx = typedArrayObtainStyledAttributes.getString(index);
                                break;
                        }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            m406mjFkc();
        }

        /* renamed from: mjFkc */
        public void m406mjFkc() {
            this.f746nxI = false;
            this.f711JYn = true;
            this.f710JYgkl = true;
            int i = ((ViewGroup.MarginLayoutParams) this).width;
            if (i == -2 && this.f715KRTLGT) {
                this.f711JYn = false;
                if (this.f761xrEuO == 0) {
                    this.f761xrEuO = 1;
                }
            }
            int i2 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i2 == -2 && this.f703GMIER) {
                this.f710JYgkl = false;
                if (this.f714KLMXS == 0) {
                    this.f714KLMXS = 1;
                }
            }
            if (i == 0 || i == -1) {
                this.f711JYn = false;
                if (i == 0 && this.f761xrEuO == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.f715KRTLGT = true;
                }
            }
            if (i2 == 0 || i2 == -1) {
                this.f710JYgkl = false;
                if (i2 == 0 && this.f714KLMXS == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.f703GMIER = true;
                }
            }
            if (this.f757wA == -1.0f && this.f745mjFkc == -1 && this.f698AZxh == -1) {
                return;
            }
            this.f746nxI = true;
            this.f711JYn = true;
            this.f710JYgkl = true;
            if (!(this.f760xROA instanceof C4186n)) {
                this.f760xROA = new C4186n();
            }
            ((C4186n) this.f760xROA).m12824SKTn(this.f728WrLQs);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x007c  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void resolveLayoutDirection(int i) {
            int i2;
            int i3;
            int i4;
            int i5;
            int i6 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int i7 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            super.resolveLayoutDirection(i);
            boolean z = false;
            boolean z2 = 1 == getLayoutDirection();
            this.f724Vdz = -1;
            this.f741jm = -1;
            this.f721SwgkN = -1;
            this.f708JBhc = -1;
            this.f697ANMGZc = this.f736diqgf;
            this.f732alEkx = this.f722Ucbh;
            float f = this.f754vI;
            this.f737dm = f;
            int i8 = this.f745mjFkc;
            this.f752tQ = i8;
            int i9 = this.f698AZxh;
            this.f762yfx = i9;
            float f2 = this.f757wA;
            this.f756vjlshU = f2;
            if (z2) {
                int i10 = this.f748qGY;
                if (i10 != -1) {
                    this.f724Vdz = i10;
                } else {
                    int i11 = this.f739fehf;
                    if (i11 != -1) {
                        this.f741jm = i11;
                    }
                    i2 = this.f706IEE;
                    if (i2 != -1) {
                        this.f708JBhc = i2;
                        z = true;
                    }
                    i3 = this.f720Pq;
                    if (i3 != -1) {
                        this.f721SwgkN = i3;
                        z = true;
                    }
                    i4 = this.f704Gd;
                    if (i4 != -1) {
                        this.f732alEkx = i4;
                    }
                    i5 = this.f705HGpJ;
                    if (i5 != -1) {
                        this.f697ANMGZc = i5;
                    }
                    if (z) {
                        this.f737dm = 1.0f - f;
                    }
                    if (this.f746nxI && this.f728WrLQs == 1) {
                        if (f2 == -1.0f) {
                            this.f756vjlshU = 1.0f - f2;
                            this.f752tQ = -1;
                            this.f762yfx = -1;
                        } else if (i8 != -1) {
                            this.f762yfx = i8;
                            this.f752tQ = -1;
                            this.f756vjlshU = -1.0f;
                        } else if (i9 != -1) {
                            this.f752tQ = i9;
                            this.f762yfx = -1;
                            this.f756vjlshU = -1.0f;
                        }
                    }
                }
                z = true;
                i2 = this.f706IEE;
                if (i2 != -1) {
                }
                i3 = this.f720Pq;
                if (i3 != -1) {
                }
                i4 = this.f704Gd;
                if (i4 != -1) {
                }
                i5 = this.f705HGpJ;
                if (i5 != -1) {
                }
                if (z) {
                }
                if (this.f746nxI) {
                    if (f2 == -1.0f) {
                    }
                }
            } else {
                int i12 = this.f748qGY;
                if (i12 != -1) {
                    this.f708JBhc = i12;
                }
                int i13 = this.f739fehf;
                if (i13 != -1) {
                    this.f721SwgkN = i13;
                }
                int i14 = this.f706IEE;
                if (i14 != -1) {
                    this.f724Vdz = i14;
                }
                int i15 = this.f720Pq;
                if (i15 != -1) {
                    this.f741jm = i15;
                }
                int i16 = this.f704Gd;
                if (i16 != -1) {
                    this.f697ANMGZc = i16;
                }
                int i17 = this.f705HGpJ;
                if (i17 != -1) {
                    this.f732alEkx = i17;
                }
            }
            if (this.f706IEE == -1 && this.f720Pq == -1 && this.f739fehf == -1 && this.f748qGY == -1) {
                int i18 = this.f709JHa;
                if (i18 != -1) {
                    this.f724Vdz = i18;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i7 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).rightMargin = i7;
                    }
                } else {
                    int i19 = this.f759xJ;
                    if (i19 != -1) {
                        this.f741jm = i19;
                        if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i7 > 0) {
                            ((ViewGroup.MarginLayoutParams) this).rightMargin = i7;
                        }
                    }
                }
                int i20 = this.f731ZfxDd;
                if (i20 != -1) {
                    this.f721SwgkN = i20;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i6 <= 0) {
                        return;
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i6;
                    return;
                }
                int i21 = this.f713KLFTb;
                if (i21 != -1) {
                    this.f708JBhc = i21;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i6 <= 0) {
                        return;
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i6;
                }
            }
        }

        public C0052AZxh(int i, int i2) {
            super(i, i2);
            this.f745mjFkc = -1;
            this.f698AZxh = -1;
            this.f757wA = -1.0f;
            this.f731ZfxDd = -1;
            this.f713KLFTb = -1;
            this.f709JHa = -1;
            this.f759xJ = -1;
            this.f743lgHUyS = -1;
            this.f749qdMbNW = -1;
            this.f701Dt = -1;
            this.f702ETF = -1;
            this.f723VA = -1;
            this.f716MiMN = -1;
            this.f730YoKzxo = 0;
            this.f751rkYL = 0.0f;
            this.f748qGY = -1;
            this.f739fehf = -1;
            this.f706IEE = -1;
            this.f720Pq = -1;
            this.f736diqgf = -1;
            this.f738eyqo = -1;
            this.f722Ucbh = -1;
            this.f740huTpC = -1;
            this.f704Gd = -1;
            this.f705HGpJ = -1;
            this.f754vI = 0.5f;
            this.f726VocHEe = 0.5f;
            this.f699BAnRFn = null;
            this.f742lB = 0.0f;
            this.f758wJVbdd = 1;
            this.f744mByQ = -1.0f;
            this.f719OjSQV = -1.0f;
            this.f718Ne = 0;
            this.f700CqaNbM = 0;
            this.f761xrEuO = 0;
            this.f714KLMXS = 0;
            this.f763zvd = 0;
            this.f735cMLeY = 0;
            this.f750rWxwaT = 0;
            this.f725Vnb = 0;
            this.f717NPj = 1.0f;
            this.f755vadzgd = 1.0f;
            this.f747oCFDzJ = -1;
            this.f733aqHPIZ = -1;
            this.f728WrLQs = -1;
            this.f715KRTLGT = false;
            this.f703GMIER = false;
            this.f753uHVRx = null;
            this.f711JYn = true;
            this.f710JYgkl = true;
            this.f712JrJO = false;
            this.f746nxI = false;
            this.f727WGXroI = false;
            this.f729XV = false;
            this.f734bbzow = false;
            this.f721SwgkN = -1;
            this.f708JBhc = -1;
            this.f724Vdz = -1;
            this.f741jm = -1;
            this.f697ANMGZc = -1;
            this.f732alEkx = -1;
            this.f737dm = 0.5f;
            this.f760xROA = new C3776gjvQ();
            this.f707IVlxe = false;
        }

        public C0052AZxh(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f745mjFkc = -1;
            this.f698AZxh = -1;
            this.f757wA = -1.0f;
            this.f731ZfxDd = -1;
            this.f713KLFTb = -1;
            this.f709JHa = -1;
            this.f759xJ = -1;
            this.f743lgHUyS = -1;
            this.f749qdMbNW = -1;
            this.f701Dt = -1;
            this.f702ETF = -1;
            this.f723VA = -1;
            this.f716MiMN = -1;
            this.f730YoKzxo = 0;
            this.f751rkYL = 0.0f;
            this.f748qGY = -1;
            this.f739fehf = -1;
            this.f706IEE = -1;
            this.f720Pq = -1;
            this.f736diqgf = -1;
            this.f738eyqo = -1;
            this.f722Ucbh = -1;
            this.f740huTpC = -1;
            this.f704Gd = -1;
            this.f705HGpJ = -1;
            this.f754vI = 0.5f;
            this.f726VocHEe = 0.5f;
            this.f699BAnRFn = null;
            this.f742lB = 0.0f;
            this.f758wJVbdd = 1;
            this.f744mByQ = -1.0f;
            this.f719OjSQV = -1.0f;
            this.f718Ne = 0;
            this.f700CqaNbM = 0;
            this.f761xrEuO = 0;
            this.f714KLMXS = 0;
            this.f763zvd = 0;
            this.f735cMLeY = 0;
            this.f750rWxwaT = 0;
            this.f725Vnb = 0;
            this.f717NPj = 1.0f;
            this.f755vadzgd = 1.0f;
            this.f747oCFDzJ = -1;
            this.f733aqHPIZ = -1;
            this.f728WrLQs = -1;
            this.f715KRTLGT = false;
            this.f703GMIER = false;
            this.f753uHVRx = null;
            this.f711JYn = true;
            this.f710JYgkl = true;
            this.f712JrJO = false;
            this.f746nxI = false;
            this.f727WGXroI = false;
            this.f729XV = false;
            this.f734bbzow = false;
            this.f721SwgkN = -1;
            this.f708JBhc = -1;
            this.f724Vdz = -1;
            this.f741jm = -1;
            this.f697ANMGZc = -1;
            this.f732alEkx = -1;
            this.f737dm = 0.5f;
            this.f760xROA = new C3776gjvQ();
            this.f707IVlxe = false;
        }
    }
}
