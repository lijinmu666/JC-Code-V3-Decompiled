package p131o;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: o.IRE */
/* loaded from: classes.dex */
public abstract class AbstractC2165IRE {

    /* renamed from: o.IRE$AZxh */
    public interface AZxh {
    }

    /* renamed from: o.IRE$KLFTb */
    public static final class KLFTb implements AZxh {

        /* renamed from: AZxh */
        public final int f8729AZxh;

        /* renamed from: ZfxDd */
        public final String f8730ZfxDd;

        /* renamed from: mjFkc */
        public final C3395avDfWJ f8731mjFkc;

        /* renamed from: wA */
        public final int f8732wA;

        public KLFTb(C3395avDfWJ c3395avDfWJ, int i, int i2, String str) {
            this.f8731mjFkc = c3395avDfWJ;
            this.f8732wA = i;
            this.f8729AZxh = i2;
            this.f8730ZfxDd = str;
        }

        /* renamed from: AZxh */
        public C3395avDfWJ m8736AZxh() {
            return this.f8731mjFkc;
        }

        /* renamed from: ZfxDd */
        public int m8737ZfxDd() {
            return this.f8729AZxh;
        }

        /* renamed from: mjFkc */
        public int m8738mjFkc() {
            return this.f8732wA;
        }

        /* renamed from: wA */
        public String m8739wA() {
            return this.f8730ZfxDd;
        }
    }

    /* renamed from: o.IRE$ZfxDd */
    public static final class ZfxDd {

        /* renamed from: AZxh */
        public final int f8733AZxh;

        /* renamed from: JHa */
        public final int f8734JHa;

        /* renamed from: KLFTb */
        public final int f8735KLFTb;

        /* renamed from: ZfxDd */
        public final String f8736ZfxDd;

        /* renamed from: mjFkc */
        public final String f8737mjFkc;

        /* renamed from: wA */
        public final boolean f8738wA;

        public ZfxDd(String str, int i, boolean z, String str2, int i2, int i3) {
            this.f8737mjFkc = str;
            this.f8733AZxh = i;
            this.f8738wA = z;
            this.f8736ZfxDd = str2;
            this.f8735KLFTb = i2;
            this.f8734JHa = i3;
        }

        /* renamed from: AZxh */
        public int m8740AZxh() {
            return this.f8735KLFTb;
        }

        /* renamed from: KLFTb */
        public boolean m8741KLFTb() {
            return this.f8738wA;
        }

        /* renamed from: ZfxDd */
        public int m8742ZfxDd() {
            return this.f8733AZxh;
        }

        /* renamed from: mjFkc */
        public int m8743mjFkc() {
            return this.f8734JHa;
        }

        /* renamed from: wA */
        public String m8744wA() {
            return this.f8736ZfxDd;
        }
    }

    /* renamed from: o.IRE$mjFkc */
    public static class mjFkc {
        /* renamed from: mjFkc */
        public static int m8745mjFkc(TypedArray typedArray, int i) {
            return typedArray.getType(i);
        }
    }

    /* renamed from: o.IRE$wA */
    public static final class wA implements AZxh {

        /* renamed from: mjFkc */
        public final ZfxDd[] f8739mjFkc;

        public wA(ZfxDd[] zfxDdArr) {
            this.f8739mjFkc = zfxDdArr;
        }

        /* renamed from: mjFkc */
        public ZfxDd[] m8746mjFkc() {
            return this.f8739mjFkc;
        }
    }

    /* renamed from: AZxh */
    public static AZxh m8728AZxh(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return m8731ZfxDd(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* renamed from: JHa */
    public static ZfxDd m8729JHa(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), AbstractC3136X4.f11545qGY);
        int i = typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(AbstractC3136X4.f11528HGpJ) ? AbstractC3136X4.f11528HGpJ : AbstractC3136X4.f11529IEE, 400);
        boolean z = 1 == typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(AbstractC3136X4.f11542huTpC) ? AbstractC3136X4.f11542huTpC : AbstractC3136X4.f11533Pq, 0);
        int i2 = typedArrayObtainAttributes.hasValue(AbstractC3136X4.f11548vI) ? AbstractC3136X4.f11548vI : AbstractC3136X4.f11539diqgf;
        String string = typedArrayObtainAttributes.getString(typedArrayObtainAttributes.hasValue(AbstractC3136X4.f11527Gd) ? AbstractC3136X4.f11527Gd : AbstractC3136X4.f11540eyqo);
        int i3 = typedArrayObtainAttributes.getInt(i2, 0);
        int i4 = typedArrayObtainAttributes.hasValue(AbstractC3136X4.f11534Ucbh) ? AbstractC3136X4.f11534Ucbh : AbstractC3136X4.f11541fehf;
        int resourceId = typedArrayObtainAttributes.getResourceId(i4, 0);
        String string2 = typedArrayObtainAttributes.getString(i4);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            m8735xJ(xmlPullParser);
        }
        return new ZfxDd(string2, i, z, string, i3, resourceId);
    }

    /* renamed from: KLFTb */
    public static AZxh m8730KLFTb(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), AbstractC3136X4.f11543lgHUyS);
        String string = typedArrayObtainAttributes.getString(AbstractC3136X4.f11546qdMbNW);
        String string2 = typedArrayObtainAttributes.getString(AbstractC3136X4.f11532MiMN);
        String string3 = typedArrayObtainAttributes.getString(AbstractC3136X4.f11537YoKzxo);
        int resourceId = typedArrayObtainAttributes.getResourceId(AbstractC3136X4.f11525Dt, 0);
        int integer = typedArrayObtainAttributes.getInteger(AbstractC3136X4.f11526ETF, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(AbstractC3136X4.f11535VA, 500);
        String string4 = typedArrayObtainAttributes.getString(AbstractC3136X4.f11547rkYL);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                m8735xJ(xmlPullParser);
            }
            return new KLFTb(new C3395avDfWJ(string, string2, string3, m8734wA(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(m8729JHa(xmlPullParser, resources));
                } else {
                    m8735xJ(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new wA((ZfxDd[]) arrayList.toArray(new ZfxDd[0]));
    }

    /* renamed from: ZfxDd */
    public static AZxh m8731ZfxDd(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return m8730KLFTb(xmlPullParser, resources);
        }
        m8735xJ(xmlPullParser);
        return null;
    }

    /* renamed from: lgHUyS */
    public static List m8732lgHUyS(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    /* renamed from: mjFkc */
    public static int m8733mjFkc(TypedArray typedArray, int i) {
        return mjFkc.m8745mjFkc(typedArray, i);
    }

    /* renamed from: wA */
    public static List m8734wA(Resources resources, int i) throws Resources.NotFoundException {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (m8733mjFkc(typedArrayObtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < typedArrayObtainTypedArray.length(); i2++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(m8732lgHUyS(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(m8732lgHUyS(resources.getStringArray(i)));
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    /* renamed from: xJ */
    public static void m8735xJ(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }
}
