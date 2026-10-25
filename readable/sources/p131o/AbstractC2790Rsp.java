package p131o;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: o.Rsp */
/* loaded from: classes.dex */
public abstract class AbstractC2790Rsp {

    /* renamed from: mjFkc */
    public static final ThreadLocal f10485mjFkc = new ThreadLocal();

    /* renamed from: AZxh */
    public static ColorStateList m10101AZxh(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return m10104ZfxDd(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    /* renamed from: JHa */
    public static int m10102JHa(int i, float f, float f2) {
        boolean z = f2 >= 0.0f && f2 <= 100.0f;
        if (f == 1.0f && !z) {
            return i;
        }
        int iM10211AZxh = AbstractC2868T1.m10211AZxh((int) ((Color.alpha(i) * f) + 0.5f), 0, 255);
        if (z) {
            C2382LeWm c2382LeWmM9380wA = C2382LeWm.m9380wA(i);
            i = C2382LeWm.m9377MiMN(c2382LeWmM9380wA.m9381Dt(), c2382LeWmM9380wA.m9387qdMbNW(), f2);
        }
        return (i & 16777215) | (iM10211AZxh << 24);
    }

    /* renamed from: KLFTb */
    public static boolean m10103KLFTb(Resources resources, int i) throws Resources.NotFoundException {
        TypedValue typedValueM10106wA = m10106wA();
        resources.getValue(i, typedValueM10106wA, true);
        int i2 = typedValueM10106wA.type;
        return i2 >= 28 && i2 <= 31;
    }

    /* renamed from: ZfxDd */
    public static ColorStateList m10104ZfxDd(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int color;
        Resources resources2 = resources;
        int i = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArrM12718mjFkc = new int[20];
        int i2 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayM10107xJ = m10107xJ(resources2, theme, attributeSet, AbstractC3136X4.f11523AZxh);
                int resourceId = typedArrayM10107xJ.getResourceId(AbstractC3136X4.f11549wA, -1);
                if (resourceId == -1 || m10103KLFTb(resources2, resourceId)) {
                    color = typedArrayM10107xJ.getColor(AbstractC3136X4.f11549wA, -65281);
                } else {
                    try {
                        color = m10105mjFkc(resources2, resources2.getXml(resourceId), theme).getDefaultColor();
                    } catch (Exception unused) {
                        color = typedArrayM10107xJ.getColor(AbstractC3136X4.f11549wA, -65281);
                    }
                }
                float f = 1.0f;
                if (typedArrayM10107xJ.hasValue(AbstractC3136X4.f11538ZfxDd)) {
                    f = typedArrayM10107xJ.getFloat(AbstractC3136X4.f11538ZfxDd, 1.0f);
                } else if (typedArrayM10107xJ.hasValue(AbstractC3136X4.f11530JHa)) {
                    f = typedArrayM10107xJ.getFloat(AbstractC3136X4.f11530JHa, 1.0f);
                }
                float f2 = (Build.VERSION.SDK_INT < 31 || !typedArrayM10107xJ.hasValue(AbstractC3136X4.f11531KLFTb)) ? typedArrayM10107xJ.getFloat(AbstractC3136X4.f11550xJ, -1.0f) : typedArrayM10107xJ.getFloat(AbstractC3136X4.f11531KLFTb, -1.0f);
                typedArrayM10107xJ.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i3 = 0;
                for (int i4 = 0; i4 < attributeCount; i4++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i4);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != AbstractC3666f4.f13520mjFkc && attributeNameResource != AbstractC3666f4.f13519AZxh) {
                        int i5 = i3 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i4, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i3] = attributeNameResource;
                        i3 = i5;
                    }
                }
                int[] iArrTrimStateSet = StateSet.trimStateSet(iArr2, i3);
                iArrM12718mjFkc = AbstractC4120m.m12718mjFkc(iArrM12718mjFkc, i2, m10102JHa(color, f, f2));
                iArr = (int[][]) AbstractC4120m.m12717AZxh(iArr, i2, iArrTrimStateSet);
                i2++;
            }
            i = 1;
            resources2 = resources;
        }
        int[] iArr3 = new int[i2];
        int[][] iArr4 = new int[i2][];
        System.arraycopy(iArrM12718mjFkc, 0, iArr3, 0, i2);
        System.arraycopy(iArr, 0, iArr4, 0, i2);
        return new ColorStateList(iArr4, iArr3);
    }

    /* renamed from: mjFkc */
    public static ColorStateList m10105mjFkc(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return m10101AZxh(resources, xmlPullParser, attributeSetAsAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* renamed from: wA */
    public static TypedValue m10106wA() {
        ThreadLocal threadLocal = f10485mjFkc;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    /* renamed from: xJ */
    public static TypedArray m10107xJ(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
