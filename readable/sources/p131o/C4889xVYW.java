package p131o;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import androidx.constraintlayout.p015widget.C0057wA;
import androidx.constraintlayout.p015widget.ConstraintLayout;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: o.xVYW */
/* loaded from: classes.dex */
public class C4889xVYW {

    /* renamed from: mjFkc */
    public final ConstraintLayout f17389mjFkc;

    /* renamed from: AZxh */
    public int f17386AZxh = -1;

    /* renamed from: wA */
    public int f17390wA = -1;

    /* renamed from: ZfxDd */
    public SparseArray f17388ZfxDd = new SparseArray();

    /* renamed from: KLFTb */
    public SparseArray f17387KLFTb = new SparseArray();

    /* renamed from: o.xVYW$AZxh */
    public static class AZxh {

        /* renamed from: AZxh */
        public float f17391AZxh;

        /* renamed from: JHa */
        public C0057wA f17392JHa;

        /* renamed from: KLFTb */
        public int f17393KLFTb;

        /* renamed from: ZfxDd */
        public float f17394ZfxDd;

        /* renamed from: mjFkc */
        public float f17395mjFkc;

        /* renamed from: wA */
        public float f17396wA;

        public AZxh(Context context, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            this.f17395mjFkc = Float.NaN;
            this.f17391AZxh = Float.NaN;
            this.f17396wA = Float.NaN;
            this.f17394ZfxDd = Float.NaN;
            this.f17393KLFTb = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), AbstractC3005V4.f11230uhQ);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == AbstractC3005V4.f11226uAgKP) {
                    this.f17393KLFTb = typedArrayObtainStyledAttributes.getResourceId(index, this.f17393KLFTb);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f17393KLFTb);
                    context.getResources().getResourceName(this.f17393KLFTb);
                    if ("layout".equals(resourceTypeName)) {
                        C0057wA c0057wA = new C0057wA();
                        this.f17392JHa = c0057wA;
                        c0057wA.m422KLFTb(context, this.f17393KLFTb);
                    }
                } else if (index == AbstractC3005V4.f11075UmFn) {
                    this.f17394ZfxDd = typedArrayObtainStyledAttributes.getDimension(index, this.f17394ZfxDd);
                } else if (index == AbstractC3005V4.f10986HPA) {
                    this.f17391AZxh = typedArrayObtainStyledAttributes.getDimension(index, this.f17391AZxh);
                } else if (index == AbstractC3005V4.f11247wfQA) {
                    this.f17396wA = typedArrayObtainStyledAttributes.getDimension(index, this.f17396wA);
                } else if (index == AbstractC3005V4.f11105YxdwU) {
                    this.f17395mjFkc = typedArrayObtainStyledAttributes.getDimension(index, this.f17395mjFkc);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* renamed from: o.xVYW$mjFkc */
    public static class mjFkc {

        /* renamed from: AZxh */
        public ArrayList f17397AZxh = new ArrayList();

        /* renamed from: ZfxDd */
        public C0057wA f17398ZfxDd;

        /* renamed from: mjFkc */
        public int f17399mjFkc;

        /* renamed from: wA */
        public int f17400wA;

        public mjFkc(Context context, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            this.f17400wA = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), AbstractC3005V4.f11168khjiU);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == AbstractC3005V4.f11101YDiFPt) {
                    this.f17399mjFkc = typedArrayObtainStyledAttributes.getResourceId(index, this.f17399mjFkc);
                } else if (index == AbstractC3005V4.f11194olO) {
                    this.f17400wA = typedArrayObtainStyledAttributes.getResourceId(index, this.f17400wA);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f17400wA);
                    context.getResources().getResourceName(this.f17400wA);
                    if ("layout".equals(resourceTypeName)) {
                        C0057wA c0057wA = new C0057wA();
                        this.f17398ZfxDd = c0057wA;
                        c0057wA.m422KLFTb(context, this.f17400wA);
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        /* renamed from: mjFkc */
        public void m13949mjFkc(AZxh aZxh) {
            this.f17397AZxh.add(aZxh);
        }
    }

    public C4889xVYW(Context context, ConstraintLayout constraintLayout, int i) throws XmlPullParserException, Resources.NotFoundException, IOException, NumberFormatException {
        this.f17389mjFkc = constraintLayout;
        m13947mjFkc(context, i);
    }

    /* renamed from: AZxh */
    public final void m13946AZxh(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, NumberFormatException, IOException {
        C0057wA c0057wA = new C0057wA();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if ("id".equals(xmlPullParser.getAttributeName(i))) {
                String attributeValue = xmlPullParser.getAttributeValue(i);
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                c0057wA.m423VA(context, xmlPullParser);
                this.f17387KLFTb.put(identifier, c0057wA);
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005d  */
    /* renamed from: mjFkc */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m13947mjFkc(Context context, int i) throws XmlPullParserException, Resources.NotFoundException, IOException, NumberFormatException {
        char c;
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            mjFkc mjfkc = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                c = 4;
                                break;
                            } else {
                                c = 65535;
                                break;
                            }
                        case 80204913:
                            if (name.equals("State")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                c = 3;
                                break;
                            }
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    if (c != 0 && c != 1) {
                        if (c == 2) {
                            mjfkc = new mjFkc(context, xml);
                            this.f17388ZfxDd.put(mjfkc.f17399mjFkc, mjfkc);
                        } else if (c == 3) {
                            AZxh aZxh = new AZxh(context, xml);
                            if (mjfkc != null) {
                                mjfkc.m13949mjFkc(aZxh);
                            }
                        } else if (c != 4) {
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                        } else {
                            m13946AZxh(context, xml);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: wA */
    public void m13948wA(AbstractC3900ih abstractC3900ih) {
    }
}
