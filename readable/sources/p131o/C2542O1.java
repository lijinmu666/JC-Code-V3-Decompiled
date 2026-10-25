package p131o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import java.util.BitSet;
import p131o.C2141I6;
import p131o.C2210J6;
import p131o.C2283K6;

/* renamed from: o.O1 */
/* loaded from: classes.dex */
public class C2542O1 extends Drawable implements InterfaceC2350L6 {

    /* renamed from: Gd */
    public static final String f9853Gd = "O1";

    /* renamed from: HGpJ */
    public static final Paint f9854HGpJ;

    /* renamed from: AZxh */
    public final C2283K6.xJ[] f9855AZxh;

    /* renamed from: Dt */
    public final RectF f9856Dt;

    /* renamed from: ETF */
    public final Region f9857ETF;

    /* renamed from: IEE */
    public final C2210J6 f9858IEE;

    /* renamed from: JHa */
    public final Matrix f9859JHa;

    /* renamed from: KLFTb */
    public boolean f9860KLFTb;

    /* renamed from: MiMN */
    public C2141I6 f9861MiMN;

    /* renamed from: Pq */
    public PorterDuffColorFilter f9862Pq;

    /* renamed from: Ucbh */
    public final RectF f9863Ucbh;

    /* renamed from: VA */
    public final Region f9864VA;

    /* renamed from: YoKzxo */
    public final Paint f9865YoKzxo;

    /* renamed from: ZfxDd */
    public final BitSet f9866ZfxDd;

    /* renamed from: diqgf */
    public PorterDuffColorFilter f9867diqgf;

    /* renamed from: eyqo */
    public int f9868eyqo;

    /* renamed from: fehf */
    public final C2210J6.AZxh f9869fehf;

    /* renamed from: huTpC */
    public boolean f9870huTpC;

    /* renamed from: lgHUyS */
    public final Path f9871lgHUyS;

    /* renamed from: mjFkc */
    public wA f9872mjFkc;

    /* renamed from: qGY */
    public final C2073H6 f9873qGY;

    /* renamed from: qdMbNW */
    public final RectF f9874qdMbNW;

    /* renamed from: rkYL */
    public final Paint f9875rkYL;

    /* renamed from: wA */
    public final C2283K6.xJ[] f9876wA;

    /* renamed from: xJ */
    public final Path f9877xJ;

    /* renamed from: o.O1$AZxh */
    public class AZxh implements C2141I6.wA {

        /* renamed from: mjFkc */
        public final /* synthetic */ float f9879mjFkc;

        public AZxh(float f) {
            this.f9879mjFkc = f;
        }

        @Override // p131o.C2141I6.wA
        /* renamed from: mjFkc */
        public InterfaceC3498cQmsjG mo8713mjFkc(InterfaceC3498cQmsjG interfaceC3498cQmsjG) {
            return interfaceC3498cQmsjG instanceof C3801h5 ? interfaceC3498cQmsjG : new C2300KLMXS(this.f9879mjFkc, interfaceC3498cQmsjG);
        }
    }

    /* renamed from: o.O1$mjFkc */
    public class mjFkc implements C2210J6.AZxh {
        public mjFkc() {
        }

        @Override // p131o.C2210J6.AZxh
        /* renamed from: AZxh */
        public void mo8905AZxh(C2283K6 c2283k6, Matrix matrix, int i) {
            C2542O1.this.f9866ZfxDd.set(i, c2283k6.m9132KLFTb());
            C2542O1.this.f9855AZxh[i] = c2283k6.m9131JHa(matrix);
        }

        @Override // p131o.C2210J6.AZxh
        /* renamed from: mjFkc */
        public void mo8906mjFkc(C2283K6 c2283k6, Matrix matrix, int i) {
            C2542O1.this.f9866ZfxDd.set(i + 4, c2283k6.m9132KLFTb());
            C2542O1.this.f9876wA[i] = c2283k6.m9131JHa(matrix);
        }
    }

    static {
        Paint paint = new Paint(1);
        f9854HGpJ = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public C2542O1() {
        this(new C2141I6());
    }

    /* renamed from: MiMN */
    public static C2542O1 m9792MiMN(Context context, float f) {
        int iM9307wA = AbstractC2345L1.m9307wA(context, AbstractC3800h4.f13945lgHUyS, C2542O1.class.getSimpleName());
        C2542O1 c2542o1 = new C2542O1();
        c2542o1.m9827cMLeY(context);
        c2542o1.m9841uHVRx(ColorStateList.valueOf(iM9307wA));
        c2542o1.m9801GMIER(f);
        return c2542o1;
    }

    /* renamed from: oCFDzJ */
    public static int m9794oCFDzJ(int i, int i2) {
        return (i * (i2 + (i2 >>> 7))) >>> 8;
    }

    /* renamed from: ANMGZc */
    public final void m9796ANMGZc() {
        float fM9798CqaNbM = m9798CqaNbM();
        this.f9872mjFkc.f9884IEE = (int) Math.ceil(0.75f * fM9798CqaNbM);
        this.f9872mjFkc.f9888Pq = (int) Math.ceil(fM9798CqaNbM * 0.25f);
        m9832jm();
        m9839rWxwaT();
    }

    /* renamed from: BAnRFn */
    public int m9797BAnRFn() {
        wA wAVar = this.f9872mjFkc;
        return (int) (wAVar.f9888Pq * Math.cos(Math.toRadians(wAVar.f9893diqgf)));
    }

    /* renamed from: CqaNbM */
    public float m9798CqaNbM() {
        return m9831huTpC() + m9812Ne();
    }

    /* renamed from: Dt */
    public final PorterDuffColorFilter m9799Dt(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = m9817VA(colorForState);
        }
        this.f9868eyqo = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    /* renamed from: ETF */
    public final PorterDuffColorFilter m9800ETF(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z) {
        return (colorStateList == null || mode == null) ? m9805JHa(paint, z) : m9799Dt(colorStateList, mode, z);
    }

    /* renamed from: GMIER */
    public void m9801GMIER(float f) {
        wA wAVar = this.f9872mjFkc;
        if (wAVar.f9900rkYL != f) {
            wAVar.f9900rkYL = f;
            m9796ANMGZc();
        }
    }

    /* renamed from: Gd */
    public ColorStateList m9802Gd() {
        return this.f9872mjFkc.f9892ZfxDd;
    }

    /* renamed from: HGpJ */
    public float m9803HGpJ() {
        return this.f9872mjFkc.f9883ETF;
    }

    /* renamed from: IEE */
    public void mo8330IEE(Canvas canvas) {
        m9830fehf(canvas, this.f9875rkYL, this.f9871lgHUyS, this.f9861MiMN, m9816Ucbh());
    }

    /* renamed from: JBhc */
    public void m9804JBhc(float f) {
        this.f9872mjFkc.f9890VA = f;
        invalidateSelf();
    }

    /* renamed from: JHa */
    public final PorterDuffColorFilter m9805JHa(Paint paint, boolean z) {
        if (!z) {
            return null;
        }
        int color = paint.getColor();
        int iM9817VA = m9817VA(color);
        this.f9868eyqo = iM9817VA;
        if (iM9817VA != color) {
            return new PorterDuffColorFilter(iM9817VA, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    /* renamed from: JYgkl */
    public void m9806JYgkl(int i, int i2, int i3, int i4) {
        wA wAVar = this.f9872mjFkc;
        if (wAVar.f9899qdMbNW == null) {
            wAVar.f9899qdMbNW = new Rect();
        }
        this.f9872mjFkc.f9899qdMbNW.set(i, i2, i3, i4);
        invalidateSelf();
    }

    /* renamed from: JYn */
    public void m9807JYn(float f) {
        wA wAVar = this.f9872mjFkc;
        if (wAVar.f9883ETF != f) {
            wAVar.f9883ETF = f;
            this.f9860KLFTb = true;
            invalidateSelf();
        }
    }

    /* renamed from: JrJO */
    public void m9808JrJO(float f) {
        wA wAVar = this.f9872mjFkc;
        if (wAVar.f9891YoKzxo != f) {
            wAVar.f9891YoKzxo = f;
            m9796ANMGZc();
        }
    }

    /* renamed from: KLMXS */
    public final boolean m9809KLMXS() {
        Paint.Style style = this.f9872mjFkc.f9889Ucbh;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    /* renamed from: KRTLGT */
    public void m9810KRTLGT(InterfaceC3498cQmsjG interfaceC3498cQmsjG) {
        setShapeAppearanceModel(this.f9872mjFkc.f9897mjFkc.m8666Gd(interfaceC3498cQmsjG));
    }

    /* renamed from: NPj */
    public boolean m9811NPj() {
        return this.f9872mjFkc.f9897mjFkc.m8674eyqo(m9829eyqo());
    }

    /* renamed from: Ne */
    public float m9812Ne() {
        return this.f9872mjFkc.f9898qGY;
    }

    /* renamed from: OjSQV */
    public float m9813OjSQV() {
        return this.f9872mjFkc.f9897mjFkc.m8673diqgf().mo9185mjFkc(m9829eyqo());
    }

    /* renamed from: Pq */
    public float m9814Pq() {
        return this.f9872mjFkc.f9897mjFkc.m8664Dt().mo9185mjFkc(m9829eyqo());
    }

    /* renamed from: SwgkN */
    public void m9815SwgkN(ColorStateList colorStateList) {
        wA wAVar = this.f9872mjFkc;
        if (wAVar.f9886KLFTb != colorStateList) {
            wAVar.f9886KLFTb = colorStateList;
            onStateChange(getState());
        }
    }

    /* renamed from: Ucbh */
    public final RectF m9816Ucbh() {
        this.f9856Dt.set(m9829eyqo());
        float fM9844wJVbdd = m9844wJVbdd();
        this.f9856Dt.inset(fM9844wJVbdd, fM9844wJVbdd);
        return this.f9856Dt;
    }

    /* renamed from: VA */
    public int m9817VA(int i) {
        float fM9798CqaNbM = m9798CqaNbM() + m9842vI();
        C4711uube c4711uube = this.f9872mjFkc.f9881AZxh;
        return c4711uube != null ? c4711uube.m13735wA(i, fM9798CqaNbM) : i;
    }

    /* renamed from: Vdz */
    public final boolean m9818Vdz(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f9872mjFkc.f9892ZfxDd == null || color2 == (colorForState2 = this.f9872mjFkc.f9892ZfxDd.getColorForState(iArr, (color2 = this.f9865YoKzxo.getColor())))) {
            z = false;
        } else {
            this.f9865YoKzxo.setColor(colorForState2);
            z = true;
        }
        if (this.f9872mjFkc.f9886KLFTb == null || color == (colorForState = this.f9872mjFkc.f9886KLFTb.getColorForState(iArr, (color = this.f9875rkYL.getColor())))) {
            return z;
        }
        this.f9875rkYL.setColor(colorForState);
        return true;
    }

    /* renamed from: Vnb */
    public boolean m9819Vnb() {
        C4711uube c4711uube = this.f9872mjFkc.f9881AZxh;
        return c4711uube != null && c4711uube.m13733ZfxDd();
    }

    /* renamed from: VocHEe */
    public int m9820VocHEe() {
        wA wAVar = this.f9872mjFkc;
        return (int) (wAVar.f9888Pq * Math.sin(Math.toRadians(wAVar.f9893diqgf)));
    }

    /* renamed from: WGXroI */
    public void m9821WGXroI(int i) {
        this.f9873qGY.m8513ZfxDd(i);
        this.f9872mjFkc.f9894eyqo = false;
        m9839rWxwaT();
    }

    /* renamed from: WrLQs */
    public boolean m9822WrLQs() {
        if (m9811NPj()) {
            return false;
        }
        this.f9877xJ.isConvex();
        return false;
    }

    /* renamed from: XV */
    public void m9823XV(float f, int i) {
        m9804JBhc(f);
        m9815SwgkN(ColorStateList.valueOf(i));
    }

    /* renamed from: YoKzxo */
    public final void m9824YoKzxo(Canvas canvas) {
        if (this.f9866ZfxDd.cardinality() > 0) {
            Log.w(f9853Gd, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f9872mjFkc.f9888Pq != 0) {
            canvas.drawPath(this.f9877xJ, this.f9873qGY.m8515wA());
        }
        for (int i = 0; i < 4; i++) {
            this.f9855AZxh[i].m9175AZxh(this.f9873qGY, this.f9872mjFkc.f9884IEE, canvas);
            this.f9876wA[i].m9175AZxh(this.f9873qGY, this.f9872mjFkc.f9884IEE, canvas);
        }
        if (this.f9870huTpC) {
            int iM9820VocHEe = m9820VocHEe();
            int iM9797BAnRFn = m9797BAnRFn();
            canvas.translate(-iM9820VocHEe, -iM9797BAnRFn);
            canvas.drawPath(this.f9877xJ, f9854HGpJ);
            canvas.translate(iM9820VocHEe, iM9797BAnRFn);
        }
    }

    /* renamed from: aqHPIZ */
    public final void m9825aqHPIZ(Canvas canvas) {
        canvas.translate(m9820VocHEe(), m9797BAnRFn());
    }

    /* renamed from: bbzow */
    public void m9826bbzow(float f, ColorStateList colorStateList) {
        m9804JBhc(f);
        m9815SwgkN(colorStateList);
    }

    /* renamed from: cMLeY */
    public void m9827cMLeY(Context context) {
        this.f9872mjFkc.f9881AZxh = new C4711uube(context);
        m9796ANMGZc();
    }

    /* renamed from: diqgf */
    public float m9828diqgf() {
        return this.f9872mjFkc.f9897mjFkc.m8671VA().mo9185mjFkc(m9829eyqo());
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f9865YoKzxo.setColorFilter(this.f9862Pq);
        int alpha = this.f9865YoKzxo.getAlpha();
        this.f9865YoKzxo.setAlpha(m9794oCFDzJ(alpha, this.f9872mjFkc.f9887MiMN));
        this.f9875rkYL.setColorFilter(this.f9867diqgf);
        this.f9875rkYL.setStrokeWidth(this.f9872mjFkc.f9890VA);
        int alpha2 = this.f9875rkYL.getAlpha();
        this.f9875rkYL.setAlpha(m9794oCFDzJ(alpha2, this.f9872mjFkc.f9887MiMN));
        if (this.f9860KLFTb) {
            m9838qdMbNW();
            m9845xJ(m9829eyqo(), this.f9877xJ);
            this.f9860KLFTb = false;
        }
        m9843vadzgd(canvas);
        if (m9809KLMXS()) {
            m9840rkYL(canvas);
        }
        if (m9847zvd()) {
            mo8330IEE(canvas);
        }
        this.f9865YoKzxo.setAlpha(alpha);
        this.f9875rkYL.setAlpha(alpha2);
    }

    /* renamed from: eyqo */
    public RectF m9829eyqo() {
        this.f9874qdMbNW.set(getBounds());
        return this.f9874qdMbNW;
    }

    /* renamed from: fehf */
    public final void m9830fehf(Canvas canvas, Paint paint, Path path, C2141I6 c2141i6, RectF rectF) {
        if (!c2141i6.m8674eyqo(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fMo9185mjFkc = c2141i6.m8673diqgf().mo9185mjFkc(rectF) * this.f9872mjFkc.f9883ETF;
            canvas.drawRoundRect(rectF, fMo9185mjFkc, fMo9185mjFkc, paint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f9872mjFkc.f9887MiMN;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f9872mjFkc;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f9872mjFkc.f9895fehf == 2) {
            return;
        }
        if (m9811NPj()) {
            outline.setRoundRect(getBounds(), m9835mByQ() * this.f9872mjFkc.f9883ETF);
        } else {
            m9845xJ(m9829eyqo(), this.f9877xJ);
            AbstractC2052GmK.m8461mjFkc(outline, this.f9877xJ);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f9872mjFkc.f9899qdMbNW;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f9857ETF.set(getBounds());
        m9845xJ(m9829eyqo(), this.f9877xJ);
        this.f9864VA.setPath(this.f9877xJ, this.f9857ETF);
        this.f9857ETF.op(this.f9864VA, Region.Op.DIFFERENCE);
        return this.f9857ETF;
    }

    /* renamed from: huTpC */
    public float m9831huTpC() {
        return this.f9872mjFkc.f9900rkYL;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f9860KLFTb = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f9872mjFkc.f9902xJ) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f9872mjFkc.f9885JHa) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f9872mjFkc.f9886KLFTb) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f9872mjFkc.f9892ZfxDd) != null && colorStateList4.isStateful())));
    }

    /* renamed from: jm */
    public final boolean m9832jm() {
        PorterDuffColorFilter porterDuffColorFilter = this.f9862Pq;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f9867diqgf;
        wA wAVar = this.f9872mjFkc;
        this.f9862Pq = m9800ETF(wAVar.f9902xJ, wAVar.f9896lgHUyS, this.f9865YoKzxo, true);
        wA wAVar2 = this.f9872mjFkc;
        this.f9867diqgf = m9800ETF(wAVar2.f9885JHa, wAVar2.f9896lgHUyS, this.f9875rkYL, false);
        wA wAVar3 = this.f9872mjFkc;
        if (wAVar3.f9894eyqo) {
            this.f9873qGY.m8513ZfxDd(wAVar3.f9902xJ.getColorForState(getState(), 0));
        }
        return (AbstractC3003V2.m10659mjFkc(porterDuffColorFilter, this.f9862Pq) && AbstractC3003V2.m10659mjFkc(porterDuffColorFilter2, this.f9867diqgf)) ? false : true;
    }

    /* renamed from: lB */
    public C2141I6 m9833lB() {
        return this.f9872mjFkc.f9897mjFkc;
    }

    /* renamed from: lgHUyS */
    public final void m9834lgHUyS(RectF rectF, Path path) {
        C2210J6 c2210j6 = this.f9858IEE;
        wA wAVar = this.f9872mjFkc;
        c2210j6.m8895KLFTb(wAVar.f9897mjFkc, wAVar.f9883ETF, rectF, this.f9869fehf, path);
    }

    /* renamed from: mByQ */
    public float m9835mByQ() {
        return this.f9872mjFkc.f9897mjFkc.m8668IEE().mo9185mjFkc(m9829eyqo());
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f9872mjFkc = new wA(this.f9872mjFkc);
        return this;
    }

    /* renamed from: nxI */
    public void m9836nxI(boolean z) {
        this.f9870huTpC = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f9860KLFTb = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, p131o.C3343a8.AZxh
    public boolean onStateChange(int[] iArr) {
        boolean z = m9818Vdz(iArr) || m9832jm();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    /* renamed from: qGY */
    public void m9837qGY(Canvas canvas, Paint paint, Path path, RectF rectF) {
        m9830fehf(canvas, paint, path, this.f9872mjFkc.f9897mjFkc, rectF);
    }

    /* renamed from: qdMbNW */
    public final void m9838qdMbNW() {
        C2141I6 c2141i6M8667HGpJ = m9833lB().m8667HGpJ(new AZxh(-m9844wJVbdd()));
        this.f9861MiMN = c2141i6M8667HGpJ;
        this.f9858IEE.m8899ZfxDd(c2141i6M8667HGpJ, this.f9872mjFkc.f9883ETF, m9816Ucbh(), this.f9871lgHUyS);
    }

    /* renamed from: rWxwaT */
    public final void m9839rWxwaT() {
        super.invalidateSelf();
    }

    /* renamed from: rkYL */
    public final void m9840rkYL(Canvas canvas) {
        m9830fehf(canvas, this.f9865YoKzxo, this.f9877xJ, this.f9872mjFkc.f9897mjFkc, m9829eyqo());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        wA wAVar = this.f9872mjFkc;
        if (wAVar.f9887MiMN != i) {
            wAVar.f9887MiMN = i;
            m9839rWxwaT();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f9872mjFkc.f9901wA = colorFilter;
        m9839rWxwaT();
    }

    @Override // p131o.InterfaceC2350L6
    public void setShapeAppearanceModel(C2141I6 c2141i6) {
        this.f9872mjFkc.f9897mjFkc = c2141i6;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f9872mjFkc.f9902xJ = colorStateList;
        m9832jm();
        m9839rWxwaT();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        wA wAVar = this.f9872mjFkc;
        if (wAVar.f9896lgHUyS != mode) {
            wAVar.f9896lgHUyS = mode;
            m9832jm();
            m9839rWxwaT();
        }
    }

    /* renamed from: uHVRx */
    public void m9841uHVRx(ColorStateList colorStateList) {
        wA wAVar = this.f9872mjFkc;
        if (wAVar.f9892ZfxDd != colorStateList) {
            wAVar.f9892ZfxDd = colorStateList;
            onStateChange(getState());
        }
    }

    /* renamed from: vI */
    public float m9842vI() {
        return this.f9872mjFkc.f9891YoKzxo;
    }

    /* renamed from: vadzgd */
    public final void m9843vadzgd(Canvas canvas) {
        if (m9846xrEuO()) {
            canvas.save();
            m9825aqHPIZ(canvas);
            if (!this.f9870huTpC) {
                m9824YoKzxo(canvas);
                canvas.restore();
                return;
            }
            int iWidth = (int) (this.f9863Ucbh.width() - getBounds().width());
            int iHeight = (int) (this.f9863Ucbh.height() - getBounds().height());
            if (iWidth < 0 || iHeight < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((int) this.f9863Ucbh.width()) + (this.f9872mjFkc.f9884IEE * 2) + iWidth, ((int) this.f9863Ucbh.height()) + (this.f9872mjFkc.f9884IEE * 2) + iHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            float f = (getBounds().left - this.f9872mjFkc.f9884IEE) - iWidth;
            float f2 = (getBounds().top - this.f9872mjFkc.f9884IEE) - iHeight;
            canvas2.translate(-f, -f2);
            m9824YoKzxo(canvas2);
            canvas.drawBitmap(bitmapCreateBitmap, f, f2, (Paint) null);
            bitmapCreateBitmap.recycle();
            canvas.restore();
        }
    }

    /* renamed from: wJVbdd */
    public final float m9844wJVbdd() {
        if (m9847zvd()) {
            return this.f9875rkYL.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    /* renamed from: xJ */
    public final void m9845xJ(RectF rectF, Path path) {
        m9834lgHUyS(rectF, path);
        if (this.f9872mjFkc.f9882Dt != 1.0f) {
            this.f9859JHa.reset();
            Matrix matrix = this.f9859JHa;
            float f = this.f9872mjFkc.f9882Dt;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f9859JHa);
        }
        path.computeBounds(this.f9863Ucbh, true);
    }

    /* renamed from: xrEuO */
    public final boolean m9846xrEuO() {
        wA wAVar = this.f9872mjFkc;
        int i = wAVar.f9895fehf;
        return i != 1 && wAVar.f9884IEE > 0 && (i == 2 || m9822WrLQs());
    }

    /* renamed from: zvd */
    public final boolean m9847zvd() {
        Paint.Style style = this.f9872mjFkc.f9889Ucbh;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f9875rkYL.getStrokeWidth() > 0.0f;
    }

    public C2542O1(Context context, AttributeSet attributeSet, int i, int i2) {
        this(C2141I6.m8658KLFTb(context, attributeSet, i, i2).m8698MiMN());
    }

    public C2542O1(C2141I6 c2141i6) {
        this(new wA(c2141i6, null));
    }

    public C2542O1(wA wAVar) {
        C2210J6 c2210j6;
        this.f9855AZxh = new C2283K6.xJ[4];
        this.f9876wA = new C2283K6.xJ[4];
        this.f9866ZfxDd = new BitSet(8);
        this.f9859JHa = new Matrix();
        this.f9877xJ = new Path();
        this.f9871lgHUyS = new Path();
        this.f9874qdMbNW = new RectF();
        this.f9856Dt = new RectF();
        this.f9857ETF = new Region();
        this.f9864VA = new Region();
        Paint paint = new Paint(1);
        this.f9865YoKzxo = paint;
        Paint paint2 = new Paint(1);
        this.f9875rkYL = paint2;
        this.f9873qGY = new C2073H6();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            c2210j6 = C2210J6.m8891ETF();
        } else {
            c2210j6 = new C2210J6();
        }
        this.f9858IEE = c2210j6;
        this.f9863Ucbh = new RectF();
        this.f9870huTpC = true;
        this.f9872mjFkc = wAVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        m9832jm();
        m9818Vdz(getState());
        this.f9869fehf = new mjFkc();
    }

    /* renamed from: o.O1$wA */
    public static class wA extends Drawable.ConstantState {

        /* renamed from: AZxh */
        public C4711uube f9881AZxh;

        /* renamed from: Dt */
        public float f9882Dt;

        /* renamed from: ETF */
        public float f9883ETF;

        /* renamed from: IEE */
        public int f9884IEE;

        /* renamed from: JHa */
        public ColorStateList f9885JHa;

        /* renamed from: KLFTb */
        public ColorStateList f9886KLFTb;

        /* renamed from: MiMN */
        public int f9887MiMN;

        /* renamed from: Pq */
        public int f9888Pq;

        /* renamed from: Ucbh */
        public Paint.Style f9889Ucbh;

        /* renamed from: VA */
        public float f9890VA;

        /* renamed from: YoKzxo */
        public float f9891YoKzxo;

        /* renamed from: ZfxDd */
        public ColorStateList f9892ZfxDd;

        /* renamed from: diqgf */
        public int f9893diqgf;

        /* renamed from: eyqo */
        public boolean f9894eyqo;

        /* renamed from: fehf */
        public int f9895fehf;

        /* renamed from: lgHUyS */
        public PorterDuff.Mode f9896lgHUyS;

        /* renamed from: mjFkc */
        public C2141I6 f9897mjFkc;

        /* renamed from: qGY */
        public float f9898qGY;

        /* renamed from: qdMbNW */
        public Rect f9899qdMbNW;

        /* renamed from: rkYL */
        public float f9900rkYL;

        /* renamed from: wA */
        public ColorFilter f9901wA;

        /* renamed from: xJ */
        public ColorStateList f9902xJ;

        public wA(C2141I6 c2141i6, C4711uube c4711uube) {
            this.f9892ZfxDd = null;
            this.f9886KLFTb = null;
            this.f9885JHa = null;
            this.f9902xJ = null;
            this.f9896lgHUyS = PorterDuff.Mode.SRC_IN;
            this.f9899qdMbNW = null;
            this.f9882Dt = 1.0f;
            this.f9883ETF = 1.0f;
            this.f9887MiMN = 255;
            this.f9891YoKzxo = 0.0f;
            this.f9900rkYL = 0.0f;
            this.f9898qGY = 0.0f;
            this.f9895fehf = 0;
            this.f9884IEE = 0;
            this.f9888Pq = 0;
            this.f9893diqgf = 0;
            this.f9894eyqo = false;
            this.f9889Ucbh = Paint.Style.FILL_AND_STROKE;
            this.f9897mjFkc = c2141i6;
            this.f9881AZxh = c4711uube;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            C2542O1 c2542o1 = new C2542O1(this);
            c2542o1.f9860KLFTb = true;
            return c2542o1;
        }

        public wA(wA wAVar) {
            this.f9892ZfxDd = null;
            this.f9886KLFTb = null;
            this.f9885JHa = null;
            this.f9902xJ = null;
            this.f9896lgHUyS = PorterDuff.Mode.SRC_IN;
            this.f9899qdMbNW = null;
            this.f9882Dt = 1.0f;
            this.f9883ETF = 1.0f;
            this.f9887MiMN = 255;
            this.f9891YoKzxo = 0.0f;
            this.f9900rkYL = 0.0f;
            this.f9898qGY = 0.0f;
            this.f9895fehf = 0;
            this.f9884IEE = 0;
            this.f9888Pq = 0;
            this.f9893diqgf = 0;
            this.f9894eyqo = false;
            this.f9889Ucbh = Paint.Style.FILL_AND_STROKE;
            this.f9897mjFkc = wAVar.f9897mjFkc;
            this.f9881AZxh = wAVar.f9881AZxh;
            this.f9890VA = wAVar.f9890VA;
            this.f9901wA = wAVar.f9901wA;
            this.f9892ZfxDd = wAVar.f9892ZfxDd;
            this.f9886KLFTb = wAVar.f9886KLFTb;
            this.f9896lgHUyS = wAVar.f9896lgHUyS;
            this.f9902xJ = wAVar.f9902xJ;
            this.f9887MiMN = wAVar.f9887MiMN;
            this.f9882Dt = wAVar.f9882Dt;
            this.f9888Pq = wAVar.f9888Pq;
            this.f9895fehf = wAVar.f9895fehf;
            this.f9894eyqo = wAVar.f9894eyqo;
            this.f9883ETF = wAVar.f9883ETF;
            this.f9891YoKzxo = wAVar.f9891YoKzxo;
            this.f9900rkYL = wAVar.f9900rkYL;
            this.f9898qGY = wAVar.f9898qGY;
            this.f9884IEE = wAVar.f9884IEE;
            this.f9893diqgf = wAVar.f9893diqgf;
            this.f9885JHa = wAVar.f9885JHa;
            this.f9889Ucbh = wAVar.f9889Ucbh;
            if (wAVar.f9899qdMbNW != null) {
                this.f9899qdMbNW = new Rect(wAVar.f9899qdMbNW);
            }
        }
    }
}
