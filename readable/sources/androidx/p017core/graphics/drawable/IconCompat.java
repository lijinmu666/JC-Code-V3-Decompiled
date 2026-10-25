package androidx.p017core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.Charset;
import p131o.AbstractC3003V2;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: ETF */
    public static final PorterDuff.Mode f945ETF = PorterDuff.Mode.SRC_IN;

    /* renamed from: AZxh */
    public Object f946AZxh;

    /* renamed from: Dt */
    public String f947Dt;

    /* renamed from: JHa */
    public int f948JHa;

    /* renamed from: KLFTb */
    public int f949KLFTb;

    /* renamed from: ZfxDd */
    public Parcelable f950ZfxDd;

    /* renamed from: lgHUyS */
    public PorterDuff.Mode f951lgHUyS;

    /* renamed from: mjFkc */
    public int f952mjFkc;

    /* renamed from: qdMbNW */
    public String f953qdMbNW;

    /* renamed from: wA */
    public byte[] f954wA;

    /* renamed from: xJ */
    public ColorStateList f955xJ;

    /* renamed from: androidx.core.graphics.drawable.IconCompat$AZxh */
    public static class C0066AZxh {
        /* renamed from: AZxh */
        public static Icon m554AZxh(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }

        /* renamed from: mjFkc */
        public static Drawable m555mjFkc(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }
    }

    /* renamed from: androidx.core.graphics.drawable.IconCompat$ZfxDd */
    public static class C0067ZfxDd {
        /* renamed from: mjFkc */
        public static Icon m556mjFkc(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    /* renamed from: androidx.core.graphics.drawable.IconCompat$mjFkc */
    public static class C0068mjFkc {
        /* renamed from: AZxh */
        public static String m557AZxh(Object obj) {
            return C0069wA.m563AZxh(obj);
        }

        /* renamed from: JHa */
        public static Icon m558JHa(IconCompat iconCompat, Context context) {
            Icon iconCreateWithBitmap;
            switch (iconCompat.f952mjFkc) {
                case -1:
                    return (Icon) iconCompat.f946AZxh;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f946AZxh);
                    break;
                case 2:
                    iconCreateWithBitmap = Icon.createWithResource(iconCompat.m552wA(), iconCompat.f949KLFTb);
                    break;
                case 3:
                    iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.f946AZxh, iconCompat.f949KLFTb, iconCompat.f948JHa);
                    break;
                case 4:
                    iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.f946AZxh);
                    break;
                case 5:
                    iconCreateWithBitmap = C0066AZxh.m554AZxh((Bitmap) iconCompat.f946AZxh);
                    break;
                case 6:
                    if (Build.VERSION.SDK_INT >= 30) {
                        iconCreateWithBitmap = C0067ZfxDd.m556mjFkc(iconCompat.m548KLFTb());
                        break;
                    } else {
                        if (context == null) {
                            throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.m548KLFTb());
                        }
                        InputStream inputStreamM547JHa = iconCompat.m547JHa(context);
                        if (inputStreamM547JHa == null) {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.m548KLFTb());
                        }
                        iconCreateWithBitmap = C0066AZxh.m554AZxh(BitmapFactory.decodeStream(inputStreamM547JHa));
                        break;
                    }
            }
            ColorStateList colorStateList = iconCompat.f955xJ;
            if (colorStateList != null) {
                iconCreateWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f951lgHUyS;
            if (mode != IconCompat.f945ETF) {
                iconCreateWithBitmap.setTintMode(mode);
            }
            return iconCreateWithBitmap;
        }

        /* renamed from: KLFTb */
        public static Drawable m559KLFTb(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        /* renamed from: ZfxDd */
        public static Uri m560ZfxDd(Object obj) {
            return C0069wA.m564ZfxDd(obj);
        }

        /* renamed from: mjFkc */
        public static int m561mjFkc(Object obj) {
            return C0069wA.m565mjFkc(obj);
        }

        /* renamed from: wA */
        public static int m562wA(Object obj) {
            return C0069wA.m566wA(obj);
        }
    }

    /* renamed from: androidx.core.graphics.drawable.IconCompat$wA */
    public static class C0069wA {
        /* renamed from: AZxh */
        public static String m563AZxh(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        /* renamed from: ZfxDd */
        public static Uri m564ZfxDd(Object obj) {
            return ((Icon) obj).getUri();
        }

        /* renamed from: mjFkc */
        public static int m565mjFkc(Object obj) {
            return ((Icon) obj).getResId();
        }

        /* renamed from: wA */
        public static int m566wA(Object obj) {
            return ((Icon) obj).getType();
        }
    }

    public IconCompat() {
        this.f952mjFkc = -1;
        this.f954wA = null;
        this.f950ZfxDd = null;
        this.f949KLFTb = 0;
        this.f948JHa = 0;
        this.f955xJ = null;
        this.f951lgHUyS = f945ETF;
        this.f953qdMbNW = null;
    }

    /* renamed from: ETF */
    public static String m543ETF(int i) {
        switch (i) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    /* renamed from: mjFkc */
    public static IconCompat m544mjFkc(Resources resources, String str, int i) {
        AbstractC3003V2.m10660wA(str);
        if (i == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f949KLFTb = i;
        if (resources != null) {
            try {
                iconCompat.f946AZxh = resources.getResourceName(i);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f946AZxh = str;
        }
        iconCompat.f947Dt = str;
        return iconCompat;
    }

    /* renamed from: AZxh */
    public int m545AZxh() {
        int i = this.f952mjFkc;
        if (i == -1) {
            return C0068mjFkc.m561mjFkc(this.f946AZxh);
        }
        if (i == 2) {
            return this.f949KLFTb;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    /* renamed from: Dt */
    public Icon m546Dt(Context context) {
        return C0068mjFkc.m558JHa(this, context);
    }

    /* renamed from: JHa */
    public InputStream m547JHa(Context context) {
        Uri uriM548KLFTb = m548KLFTb();
        String scheme = uriM548KLFTb.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uriM548KLFTb);
            } catch (Exception e) {
                Log.w("IconCompat", "Unable to load image from URI: " + uriM548KLFTb, e);
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.f946AZxh));
        } catch (FileNotFoundException e2) {
            Log.w("IconCompat", "Unable to load image from path: " + uriM548KLFTb, e2);
            return null;
        }
    }

    /* renamed from: KLFTb */
    public Uri m548KLFTb() {
        int i = this.f952mjFkc;
        if (i == -1) {
            return C0068mjFkc.m560ZfxDd(this.f946AZxh);
        }
        if (i == 4 || i == 6) {
            return Uri.parse((String) this.f946AZxh);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    /* renamed from: ZfxDd */
    public int m549ZfxDd() {
        int i = this.f952mjFkc;
        return i == -1 ? C0068mjFkc.m562wA(this.f946AZxh) : i;
    }

    /* renamed from: lgHUyS */
    public void m550lgHUyS(boolean z) {
        this.f953qdMbNW = this.f951lgHUyS.name();
        switch (this.f952mjFkc) {
            case -1:
                if (z) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f950ZfxDd = (Parcelable) this.f946AZxh;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z) {
                    this.f950ZfxDd = (Parcelable) this.f946AZxh;
                    return;
                }
                Bitmap bitmap = (Bitmap) this.f946AZxh;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f954wA = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.f954wA = ((String) this.f946AZxh).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f954wA = (byte[]) this.f946AZxh;
                return;
            case 4:
            case 6:
                this.f954wA = this.f946AZxh.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    /* renamed from: qdMbNW */
    public Icon m551qdMbNW() {
        return m546Dt(null);
    }

    public String toString() {
        if (this.f952mjFkc == -1) {
            return String.valueOf(this.f946AZxh);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(m543ETF(this.f952mjFkc));
        switch (this.f952mjFkc) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f946AZxh).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f946AZxh).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f947Dt);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(m545AZxh())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f949KLFTb);
                if (this.f948JHa != 0) {
                    sb.append(" off=");
                    sb.append(this.f948JHa);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f946AZxh);
                break;
        }
        if (this.f955xJ != null) {
            sb.append(" tint=");
            sb.append(this.f955xJ);
        }
        if (this.f951lgHUyS != f945ETF) {
            sb.append(" mode=");
            sb.append(this.f951lgHUyS);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: wA */
    public String m552wA() {
        int i = this.f952mjFkc;
        if (i == -1) {
            return C0068mjFkc.m557AZxh(this.f946AZxh);
        }
        if (i == 2) {
            String str = this.f947Dt;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f946AZxh).split(":", -1)[0] : this.f947Dt;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    /* renamed from: xJ */
    public void m553xJ() {
        this.f951lgHUyS = PorterDuff.Mode.valueOf(this.f953qdMbNW);
        switch (this.f952mjFkc) {
            case -1:
                Parcelable parcelable = this.f950ZfxDd;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                this.f946AZxh = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f950ZfxDd;
                if (parcelable2 != null) {
                    this.f946AZxh = parcelable2;
                    return;
                }
                byte[] bArr = this.f954wA;
                this.f946AZxh = bArr;
                this.f952mjFkc = 3;
                this.f949KLFTb = 0;
                this.f948JHa = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f954wA, Charset.forName("UTF-16"));
                this.f946AZxh = str;
                if (this.f952mjFkc == 2 && this.f947Dt == null) {
                    this.f947Dt = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f946AZxh = this.f954wA;
                return;
        }
    }

    public IconCompat(int i) {
        this.f954wA = null;
        this.f950ZfxDd = null;
        this.f949KLFTb = 0;
        this.f948JHa = 0;
        this.f955xJ = null;
        this.f951lgHUyS = f945ETF;
        this.f953qdMbNW = null;
        this.f952mjFkc = i;
    }
}
