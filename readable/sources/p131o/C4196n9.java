package p131o;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import p131o.AbstractC2165IRE;
import p131o.AbstractC2927Tz;

/* renamed from: o.n9 */
/* loaded from: classes.dex */
public class C4196n9 extends AbstractC4261o9 {
    /* renamed from: KLFTb */
    public static int m12851KLFTb(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // p131o.AbstractC4261o9
    /* renamed from: AZxh */
    public Typeface mo12852AZxh(Context context, CancellationSignal cancellationSignal, AbstractC2927Tz.AZxh[] aZxhArr, int i) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily.Builder builder = null;
            for (AbstractC2927Tz.AZxh aZxh : aZxhArr) {
                try {
                    parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(aZxh.m10457ZfxDd(), "r", cancellationSignal);
                } catch (IOException unused) {
                }
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                    }
                } else {
                    try {
                        Font fontBuild = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(aZxh.m10456KLFTb()).setSlant(aZxh.m10455JHa() ? 1 : 0).setTtcIndex(aZxh.m10458wA()).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(fontBuild);
                        } else {
                            builder.addFont(fontBuild);
                        }
                    } catch (Throwable th) {
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                parcelFileDescriptorOpenFileDescriptor.close();
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(m12853ZfxDd(fontFamilyBuild, i).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    /* renamed from: ZfxDd */
    public final Font m12853ZfxDd(FontFamily fontFamily, int i) {
        FontStyle fontStyle = new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int iM12851KLFTb = m12851KLFTb(fontStyle, font.getStyle());
        for (int i2 = 1; i2 < fontFamily.getSize(); i2++) {
            Font font2 = fontFamily.getFont(i2);
            int iM12851KLFTb2 = m12851KLFTb(fontStyle, font2.getStyle());
            if (iM12851KLFTb2 < iM12851KLFTb) {
                font = font2;
                iM12851KLFTb = iM12851KLFTb2;
            }
        }
        return font;
    }

    @Override // p131o.AbstractC4261o9
    /* renamed from: mjFkc */
    public Typeface mo12854mjFkc(Context context, AbstractC2165IRE.wA wAVar, Resources resources, int i) throws IOException {
        try {
            FontFamily.Builder builder = null;
            for (AbstractC2165IRE.ZfxDd zfxDd : wAVar.m8746mjFkc()) {
                try {
                    Font fontBuild = new Font.Builder(resources, zfxDd.m8743mjFkc()).setWeight(zfxDd.m8742ZfxDd()).setSlant(zfxDd.m8741KLFTb() ? 1 : 0).setTtcIndex(zfxDd.m8740AZxh()).setFontVariationSettings(zfxDd.m8744wA()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(m12853ZfxDd(fontFamilyBuild, i).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // p131o.AbstractC4261o9
    /* renamed from: wA */
    public Typeface mo12855wA(Context context, Resources resources, int i, String str, int i2) throws IOException {
        try {
            Font fontBuild = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }
}
