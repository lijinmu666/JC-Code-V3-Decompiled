package androidx.constraintlayout.p015widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import p131o.AbstractC3005V4;

/* renamed from: androidx.constraintlayout.widget.mjFkc */
/* loaded from: classes.dex */
public class C0056mjFkc {

    /* renamed from: AZxh */
    public AZxh f774AZxh;

    /* renamed from: JHa */
    public boolean f775JHa;

    /* renamed from: KLFTb */
    public String f776KLFTb;

    /* renamed from: ZfxDd */
    public float f777ZfxDd;

    /* renamed from: mjFkc */
    public String f778mjFkc;

    /* renamed from: wA */
    public int f779wA;

    /* renamed from: xJ */
    public int f780xJ;

    /* renamed from: androidx.constraintlayout.widget.mjFkc$AZxh */
    public enum AZxh {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE
    }

    /* renamed from: androidx.constraintlayout.widget.mjFkc$mjFkc */
    public static /* synthetic */ class mjFkc {

        /* renamed from: mjFkc */
        public static final /* synthetic */ int[] f789mjFkc;

        static {
            int[] iArr = new int[AZxh.m415values().length];
            f789mjFkc = iArr;
            try {
                iArr[AZxh.COLOR_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f789mjFkc[AZxh.COLOR_DRAWABLE_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f789mjFkc[AZxh.INT_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f789mjFkc[AZxh.FLOAT_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f789mjFkc[AZxh.STRING_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f789mjFkc[AZxh.BOOLEAN_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f789mjFkc[AZxh.DIMENSION_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public C0056mjFkc(String str, AZxh aZxh, Object obj) {
        this.f778mjFkc = str;
        this.f774AZxh = aZxh;
        m413ZfxDd(obj);
    }

    /* renamed from: AZxh */
    public static void m410AZxh(Context context, XmlPullParser xmlPullParser, HashMap map) {
        AZxh aZxh;
        Object string;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), AbstractC3005V4.f11140gJsSk);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        String string2 = null;
        Object objValueOf = null;
        AZxh aZxh2 = null;
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == AbstractC3005V4.f11204qtZIjO) {
                string2 = typedArrayObtainStyledAttributes.getString(index);
                if (string2 != null && string2.length() > 0) {
                    string2 = Character.toUpperCase(string2.charAt(0)) + string2.substring(1);
                }
            } else if (index == AbstractC3005V4.f11255xVYW) {
                objValueOf = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(index, false));
                aZxh2 = AZxh.BOOLEAN_TYPE;
            } else {
                if (index == AbstractC3005V4.f11171kw) {
                    aZxh = AZxh.COLOR_TYPE;
                    string = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else if (index == AbstractC3005V4.f11146gjvQ) {
                    aZxh = AZxh.COLOR_DRAWABLE_TYPE;
                    string = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else if (index == AbstractC3005V4.f11215sZ) {
                    aZxh = AZxh.DIMENSION_TYPE;
                    string = Float.valueOf(TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == AbstractC3005V4.f11153ih) {
                    aZxh = AZxh.DIMENSION_TYPE;
                    string = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == AbstractC3005V4.f11016KbE) {
                    aZxh = AZxh.FLOAT_TYPE;
                    string = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == AbstractC3005V4.f11027MlqoT) {
                    aZxh = AZxh.INT_TYPE;
                    string = Integer.valueOf(typedArrayObtainStyledAttributes.getInteger(index, -1));
                } else if (index == AbstractC3005V4.f11109Zerm) {
                    aZxh = AZxh.STRING_TYPE;
                    string = typedArrayObtainStyledAttributes.getString(index);
                }
                Object obj = string;
                aZxh2 = aZxh;
                objValueOf = obj;
            }
        }
        if (string2 != null && objValueOf != null) {
            map.put(string2, new C0056mjFkc(string2, aZxh2, objValueOf));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: mjFkc */
    public static HashMap m411mjFkc(HashMap map, View view) {
        HashMap map2 = new HashMap();
        Class<?> cls = view.getClass();
        for (String str : map.keySet()) {
            C0056mjFkc c0056mjFkc = (C0056mjFkc) map.get(str);
            try {
                if (str.equals("BackgroundColor")) {
                    map2.put(str, new C0056mjFkc(c0056mjFkc, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                } else {
                    map2.put(str, new C0056mjFkc(c0056mjFkc, cls.getMethod("getMap" + str, null).invoke(view, null)));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
        return map2;
    }

    /* renamed from: wA */
    public static void m412wA(View view, HashMap map) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = view.getClass();
        for (String str : map.keySet()) {
            C0056mjFkc c0056mjFkc = (C0056mjFkc) map.get(str);
            String str2 = "set" + str;
            try {
                switch (mjFkc.f789mjFkc[c0056mjFkc.f774AZxh.ordinal()]) {
                    case 1:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(c0056mjFkc.f780xJ));
                        break;
                    case 2:
                        Method method = cls.getMethod(str2, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(c0056mjFkc.f780xJ);
                        method.invoke(view, colorDrawable);
                        break;
                    case 3:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(c0056mjFkc.f779wA));
                        break;
                    case 4:
                        cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(c0056mjFkc.f777ZfxDd));
                        break;
                    case 5:
                        cls.getMethod(str2, CharSequence.class).invoke(view, c0056mjFkc.f776KLFTb);
                        break;
                    case 6:
                        cls.getMethod(str2, Boolean.TYPE).invoke(view, Boolean.valueOf(c0056mjFkc.f775JHa));
                        break;
                    case 7:
                        cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(c0056mjFkc.f777ZfxDd));
                        break;
                }
            } catch (IllegalAccessException e) {
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                Log.e("TransitionLayout", e2.getMessage());
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                StringBuilder sb = new StringBuilder();
                sb.append(cls.getName());
                sb.append(" must have a method ");
                sb.append(str2);
                Log.e("TransitionLayout", sb.toString());
            } catch (InvocationTargetException e3) {
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                e3.printStackTrace();
            }
        }
    }

    /* renamed from: ZfxDd */
    public void m413ZfxDd(Object obj) {
        switch (mjFkc.f789mjFkc[this.f774AZxh.ordinal()]) {
            case 1:
            case 2:
                this.f780xJ = ((Integer) obj).intValue();
                break;
            case 3:
                this.f779wA = ((Integer) obj).intValue();
                break;
            case 4:
                this.f777ZfxDd = ((Float) obj).floatValue();
                break;
            case 5:
                this.f776KLFTb = (String) obj;
                break;
            case 6:
                this.f775JHa = ((Boolean) obj).booleanValue();
                break;
            case 7:
                this.f777ZfxDd = ((Float) obj).floatValue();
                break;
        }
    }

    public C0056mjFkc(C0056mjFkc c0056mjFkc, Object obj) {
        this.f778mjFkc = c0056mjFkc.f778mjFkc;
        this.f774AZxh = c0056mjFkc.f774AZxh;
        m413ZfxDd(obj);
    }
}
