package p131o;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: o.SmIWf */
/* loaded from: classes.dex */
public class C2850SmIWf {

    /* renamed from: Dt */
    public final Context f10585Dt;

    /* renamed from: lgHUyS */
    public TextPaint f10590lgHUyS;

    /* renamed from: qdMbNW */
    public final TextView f10592qdMbNW;

    /* renamed from: VA */
    public static final RectF f10582VA = new RectF();

    /* renamed from: MiMN */
    public static ConcurrentHashMap f10581MiMN = new ConcurrentHashMap();

    /* renamed from: YoKzxo */
    public static ConcurrentHashMap f10583YoKzxo = new ConcurrentHashMap();

    /* renamed from: mjFkc */
    public int f10591mjFkc = 0;

    /* renamed from: AZxh */
    public boolean f10584AZxh = false;

    /* renamed from: wA */
    public float f10593wA = -1.0f;

    /* renamed from: ZfxDd */
    public float f10589ZfxDd = -1.0f;

    /* renamed from: KLFTb */
    public float f10588KLFTb = -1.0f;

    /* renamed from: JHa */
    public int[] f10587JHa = new int[0];

    /* renamed from: xJ */
    public boolean f10594xJ = false;

    /* renamed from: ETF */
    public final JHa f10586ETF = new KLFTb();

    /* renamed from: o.SmIWf$AZxh */
    public static final class AZxh {
        /* renamed from: mjFkc */
        public static boolean m10189mjFkc(View view) {
            return view.isInLayout();
        }
    }

    /* renamed from: o.SmIWf$JHa */
    public static class JHa {
        /* renamed from: AZxh */
        public abstract boolean mo10190AZxh(TextView textView);

        /* renamed from: mjFkc */
        public abstract void mo10191mjFkc(StaticLayout.Builder builder, TextView textView);
    }

    /* renamed from: o.SmIWf$KLFTb */
    public static class KLFTb extends ZfxDd {
        @Override // p131o.C2850SmIWf.JHa
        /* renamed from: AZxh */
        public boolean mo10190AZxh(TextView textView) {
            return textView.isHorizontallyScrollable();
        }

        @Override // p131o.C2850SmIWf.JHa
        /* renamed from: mjFkc */
        public void mo10191mjFkc(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }
    }

    /* renamed from: o.SmIWf$ZfxDd */
    public static class ZfxDd extends JHa {
    }

    /* renamed from: o.SmIWf$mjFkc */
    public static final class mjFkc {
        /* renamed from: AZxh */
        public static int m10192AZxh(TextView textView) {
            return textView.getMaxLines();
        }

        /* renamed from: mjFkc */
        public static StaticLayout m10193mjFkc(CharSequence charSequence, Layout.Alignment alignment, int i, TextView textView, TextPaint textPaint) {
            return new StaticLayout(charSequence, textPaint, i, alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
        }
    }

    /* renamed from: o.SmIWf$wA */
    public static final class wA {
        /* renamed from: mjFkc */
        public static StaticLayout m10194mjFkc(CharSequence charSequence, Layout.Alignment alignment, int i, int i2, TextView textView, TextPaint textPaint, JHa jHa) {
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i);
            StaticLayout.Builder hyphenationFrequency = builderObtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i2 == -1) {
                i2 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i2);
            try {
                jHa.mo10191mjFkc(builderObtain, textView);
            } catch (ClassCastException unused) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return builderObtain.build();
        }
    }

    public C2850SmIWf(TextView textView) {
        this.f10592qdMbNW = textView;
        this.f10585Dt = textView.getContext();
    }

    /* renamed from: ETF */
    public static Method m10163ETF(String str) throws SecurityException {
        try {
            Method declaredMethod = (Method) f10581MiMN.get(str);
            if (declaredMethod == null && (declaredMethod = TextView.class.getDeclaredMethod(str, null)) != null) {
                declaredMethod.setAccessible(true);
                f10581MiMN.put(str, declaredMethod);
            }
            return declaredMethod;
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e);
            return null;
        }
    }

    /* renamed from: MiMN */
    public static Object m10164MiMN(Object obj, String str, Object obj2) {
        try {
            return m10163ETF(str).invoke(obj, null);
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e);
            return obj2;
        }
    }

    /* renamed from: AZxh */
    public final int[] m10165AZxh(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr2[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr2;
    }

    /* renamed from: Dt */
    public int m10166Dt() {
        return this.f10591mjFkc;
    }

    /* renamed from: Gd */
    public final boolean m10167Gd(int i, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f10592qdMbNW.getText();
        TransformationMethod transformationMethod = this.f10592qdMbNW.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f10592qdMbNW)) != null) {
            text = transformation;
        }
        int iM10192AZxh = mjFkc.m10192AZxh(this.f10592qdMbNW);
        m10174VA(i);
        StaticLayout staticLayoutM10176ZfxDd = m10176ZfxDd(text, (Layout.Alignment) m10164MiMN(this.f10592qdMbNW, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), iM10192AZxh);
        return (iM10192AZxh == -1 || (staticLayoutM10176ZfxDd.getLineCount() <= iM10192AZxh && staticLayoutM10176ZfxDd.getLineEnd(staticLayoutM10176ZfxDd.getLineCount() - 1) == text.length())) && ((float) staticLayoutM10176ZfxDd.getHeight()) <= rectF.bottom;
    }

    /* renamed from: HGpJ */
    public final boolean m10168HGpJ() {
        return !(this.f10592qdMbNW instanceof AbstractC2862SwgkN);
    }

    /* renamed from: IEE */
    public void m10169IEE(int i) {
        if (m10168HGpJ()) {
            if (i == 0) {
                m10187wA();
                return;
            }
            if (i != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i);
            }
            DisplayMetrics displayMetrics = this.f10585Dt.getResources().getDisplayMetrics();
            m10186vI(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (m10178eyqo()) {
                m10182mjFkc();
            }
        }
    }

    /* renamed from: JHa */
    public int m10170JHa() {
        return Math.round(this.f10588KLFTb);
    }

    /* renamed from: KLFTb */
    public final int m10171KLFTb(RectF rectF) {
        int length = this.f10587JHa.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i = 1;
        int i2 = length - 1;
        int i3 = 0;
        while (i <= i2) {
            int i4 = (i + i2) / 2;
            if (m10167Gd(this.f10587JHa[i4], rectF)) {
                int i5 = i4 + 1;
                i3 = i;
                i = i5;
            } else {
                i3 = i4 - 1;
                i2 = i3;
            }
        }
        return this.f10587JHa[i3];
    }

    /* renamed from: Pq */
    public final void m10172Pq(float f) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (f != this.f10592qdMbNW.getPaint().getTextSize()) {
            this.f10592qdMbNW.getPaint().setTextSize(f);
            boolean zM10189mjFkc = AZxh.m10189mjFkc(this.f10592qdMbNW);
            if (this.f10592qdMbNW.getLayout() != null) {
                this.f10584AZxh = false;
                try {
                    Method methodM10163ETF = m10163ETF("nullLayouts");
                    if (methodM10163ETF != null) {
                        methodM10163ETF.invoke(this.f10592qdMbNW, null);
                    }
                } catch (Exception e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (zM10189mjFkc) {
                    this.f10592qdMbNW.forceLayout();
                } else {
                    this.f10592qdMbNW.requestLayout();
                }
                this.f10592qdMbNW.invalidate();
            }
        }
    }

    /* renamed from: Ucbh */
    public final void m10173Ucbh(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                iArr[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.f10587JHa = m10165AZxh(iArr);
            m10180huTpC();
        }
    }

    /* renamed from: VA */
    public void m10174VA(int i) {
        TextPaint textPaint = this.f10590lgHUyS;
        if (textPaint == null) {
            this.f10590lgHUyS = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f10590lgHUyS.set(this.f10592qdMbNW.getPaint());
        this.f10590lgHUyS.setTextSize(i);
    }

    /* renamed from: YoKzxo */
    public boolean m10175YoKzxo() {
        return m10168HGpJ() && this.f10591mjFkc != 0;
    }

    /* renamed from: ZfxDd */
    public StaticLayout m10176ZfxDd(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        return wA.m10194mjFkc(charSequence, alignment, i, i2, this.f10592qdMbNW, this.f10590lgHUyS, this.f10586ETF);
    }

    /* renamed from: diqgf */
    public void m10177diqgf(int i, float f) {
        Context context = this.f10585Dt;
        m10172Pq(TypedValue.applyDimension(i, f, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    /* renamed from: eyqo */
    public final boolean m10178eyqo() {
        if (m10168HGpJ() && this.f10591mjFkc == 1) {
            if (!this.f10594xJ || this.f10587JHa.length == 0) {
                int iFloor = ((int) Math.floor((this.f10588KLFTb - this.f10589ZfxDd) / this.f10593wA)) + 1;
                int[] iArr = new int[iFloor];
                for (int i = 0; i < iFloor; i++) {
                    iArr[i] = Math.round(this.f10589ZfxDd + (i * this.f10593wA));
                }
                this.f10587JHa = m10165AZxh(iArr);
            }
            this.f10584AZxh = true;
        } else {
            this.f10584AZxh = false;
        }
        return this.f10584AZxh;
    }

    /* renamed from: fehf */
    public void m10179fehf(int[] iArr, int i) {
        if (m10168HGpJ()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f10585Dt.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArrCopyOf[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                this.f10587JHa = m10165AZxh(iArrCopyOf);
                if (!m10180huTpC()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f10594xJ = false;
            }
            if (m10178eyqo()) {
                m10182mjFkc();
            }
        }
    }

    /* renamed from: huTpC */
    public final boolean m10180huTpC() {
        boolean z = this.f10587JHa.length > 0;
        this.f10594xJ = z;
        if (z) {
            this.f10591mjFkc = 1;
            this.f10589ZfxDd = r0[0];
            this.f10588KLFTb = r0[r1 - 1];
            this.f10593wA = -1.0f;
        }
        return z;
    }

    /* renamed from: lgHUyS */
    public int m10181lgHUyS() {
        return Math.round(this.f10593wA);
    }

    /* renamed from: mjFkc */
    public void m10182mjFkc() {
        if (m10175YoKzxo()) {
            if (this.f10584AZxh) {
                if (this.f10592qdMbNW.getMeasuredHeight() <= 0 || this.f10592qdMbNW.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f10586ETF.mo10190AZxh(this.f10592qdMbNW) ? 1048576 : (this.f10592qdMbNW.getMeasuredWidth() - this.f10592qdMbNW.getTotalPaddingLeft()) - this.f10592qdMbNW.getTotalPaddingRight();
                int height = (this.f10592qdMbNW.getHeight() - this.f10592qdMbNW.getCompoundPaddingBottom()) - this.f10592qdMbNW.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f10582VA;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float fM10171KLFTb = m10171KLFTb(rectF);
                        if (fM10171KLFTb != this.f10592qdMbNW.getTextSize()) {
                            m10177diqgf(0, fM10171KLFTb);
                        }
                    } finally {
                    }
                }
            }
            this.f10584AZxh = true;
        }
    }

    /* renamed from: qGY */
    public void m10183qGY(int i, int i2, int i3, int i4) {
        if (m10168HGpJ()) {
            DisplayMetrics displayMetrics = this.f10585Dt.getResources().getDisplayMetrics();
            m10186vI(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (m10178eyqo()) {
                m10182mjFkc();
            }
        }
    }

    /* renamed from: qdMbNW */
    public int[] m10184qdMbNW() {
        return this.f10587JHa;
    }

    /* renamed from: rkYL */
    public void m10185rkYL(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = this.f10585Dt.obtainStyledAttributes(attributeSet, AbstractC3407b5.f12938WrLQs, i, 0);
        TextView textView = this.f10592qdMbNW;
        AbstractC2876T9.m10277jm(textView, textView.getContext(), AbstractC3407b5.f12938WrLQs, attributeSet, typedArrayObtainStyledAttributes, i, 0);
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC3407b5.f12883JYgkl)) {
            this.f10591mjFkc = typedArrayObtainStyledAttributes.getInt(AbstractC3407b5.f12883JYgkl, 0);
        }
        float dimension = typedArrayObtainStyledAttributes.hasValue(AbstractC3407b5.f12884JYn) ? typedArrayObtainStyledAttributes.getDimension(AbstractC3407b5.f12884JYn, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(AbstractC3407b5.f12868GMIER) ? typedArrayObtainStyledAttributes.getDimension(AbstractC3407b5.f12868GMIER, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(AbstractC3407b5.f12890KRTLGT) ? typedArrayObtainStyledAttributes.getDimension(AbstractC3407b5.f12890KRTLGT, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC3407b5.f13019uHVRx) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(AbstractC3407b5.f13019uHVRx, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            m10173Ucbh(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!m10168HGpJ()) {
            this.f10591mjFkc = 0;
            return;
        }
        if (this.f10591mjFkc == 1) {
            if (!this.f10594xJ) {
                DisplayMetrics displayMetrics = this.f10585Dt.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                m10186vI(dimension2, dimension3, dimension);
            }
            m10178eyqo();
        }
    }

    /* renamed from: vI */
    public final void m10186vI(float f, float f2, float f3) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
        }
        if (f2 <= f) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size text size (" + f + "px)");
        }
        if (f3 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f3 + "px) is less or equal to (0px)");
        }
        this.f10591mjFkc = 1;
        this.f10589ZfxDd = f;
        this.f10588KLFTb = f2;
        this.f10593wA = f3;
        this.f10594xJ = false;
    }

    /* renamed from: wA */
    public final void m10187wA() {
        this.f10591mjFkc = 0;
        this.f10589ZfxDd = -1.0f;
        this.f10588KLFTb = -1.0f;
        this.f10593wA = -1.0f;
        this.f10587JHa = new int[0];
        this.f10584AZxh = false;
    }

    /* renamed from: xJ */
    public int m10188xJ() {
        return Math.round(this.f10589ZfxDd);
    }
}
