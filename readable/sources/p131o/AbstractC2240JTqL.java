package p131o;

import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import p131o.AbstractC2927Tz;

/* renamed from: o.JTqL */
/* loaded from: classes.dex */
public abstract class AbstractC2240JTqL {

    /* renamed from: mjFkc */
    public static final Comparator f8979mjFkc = new Comparator() { // from class: o.MoUZ
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC2240JTqL.m8974xJ((byte[]) obj, (byte[]) obj2);
        }
    };

    /* renamed from: o.JTqL$AZxh */
    public static class AZxh implements mjFkc {

        /* renamed from: mjFkc */
        public final ContentProviderClient f8980mjFkc;

        public AZxh(Context context, Uri uri) {
            this.f8980mjFkc = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // p131o.AbstractC2240JTqL.mjFkc
        /* renamed from: AZxh */
        public Cursor mo8975AZxh(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.f8980mjFkc;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e) {
                Log.w("FontsProvider", "Unable to query the content provider", e);
                return null;
            }
        }

        @Override // p131o.AbstractC2240JTqL.mjFkc
        /* renamed from: close */
        public void mo8976close() {
            ContentProviderClient contentProviderClient = this.f8980mjFkc;
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
        }
    }

    /* renamed from: o.JTqL$mjFkc */
    public interface mjFkc {
        /* renamed from: mjFkc */
        static mjFkc m8977mjFkc(Context context, Uri uri) {
            return new AZxh(context, uri);
        }

        /* renamed from: AZxh */
        Cursor mo8975AZxh(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);

        /* renamed from: close */
        void mo8976close();
    }

    /* renamed from: AZxh */
    public static List m8967AZxh(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    /* renamed from: JHa */
    public static ProviderInfo m8968JHa(PackageManager packageManager, C3395avDfWJ c3395avDfWJ, Resources resources) throws PackageManager.NameNotFoundException {
        String strM11427KLFTb = c3395avDfWJ.m11427KLFTb();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strM11427KLFTb, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + strM11427KLFTb);
        }
        if (!providerInfoResolveContentProvider.packageName.equals(c3395avDfWJ.m11426JHa())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + strM11427KLFTb + ", but package was not " + c3395avDfWJ.m11426JHa());
        }
        List listM8967AZxh = m8967AZxh(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
        Collections.sort(listM8967AZxh, f8979mjFkc);
        List listM8970ZfxDd = m8970ZfxDd(c3395avDfWJ, resources);
        for (int i = 0; i < listM8970ZfxDd.size(); i++) {
            ArrayList arrayList = new ArrayList((Collection) listM8970ZfxDd.get(i));
            Collections.sort(arrayList, f8979mjFkc);
            if (m8973wA(listM8967AZxh, arrayList)) {
                return providerInfoResolveContentProvider;
            }
        }
        return null;
    }

    /* renamed from: KLFTb */
    public static AbstractC2927Tz.mjFkc m8969KLFTb(Context context, C3395avDfWJ c3395avDfWJ, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfoM8968JHa = m8968JHa(context.getPackageManager(), c3395avDfWJ, context.getResources());
        return providerInfoM8968JHa == null ? AbstractC2927Tz.mjFkc.m10459mjFkc(1, null) : AbstractC2927Tz.mjFkc.m10459mjFkc(0, m8971lgHUyS(context, c3395avDfWJ, providerInfoM8968JHa.authority, cancellationSignal));
    }

    /* renamed from: ZfxDd */
    public static List m8970ZfxDd(C3395avDfWJ c3395avDfWJ, Resources resources) {
        return c3395avDfWJ.m11425AZxh() != null ? c3395avDfWJ.m11425AZxh() : AbstractC2165IRE.m8734wA(resources, c3395avDfWJ.m11430wA());
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00d1  */
    /* renamed from: lgHUyS */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AbstractC2927Tz.AZxh[] m8971lgHUyS(Context context, C3395avDfWJ c3395avDfWJ, String str, CancellationSignal cancellationSignal) {
        ArrayList arrayList;
        Uri uriWithAppendedId;
        boolean z;
        ArrayList arrayList2 = new ArrayList();
        Uri uriBuild = new Uri.Builder().scheme("content").authority(str).build();
        Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        mjFkc mjfkcM8977mjFkc = mjFkc.m8977mjFkc(context, uriBuild);
        Cursor cursorMo8975AZxh = null;
        try {
            cursorMo8975AZxh = mjfkcM8977mjFkc.mo8975AZxh(uriBuild, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{c3395avDfWJ.m11431xJ()}, null, cancellationSignal);
            if (cursorMo8975AZxh != null && cursorMo8975AZxh.getCount() > 0) {
                int columnIndex = cursorMo8975AZxh.getColumnIndex("result_code");
                ArrayList arrayList3 = new ArrayList();
                int columnIndex2 = cursorMo8975AZxh.getColumnIndex("_id");
                int columnIndex3 = cursorMo8975AZxh.getColumnIndex("file_id");
                int columnIndex4 = cursorMo8975AZxh.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursorMo8975AZxh.getColumnIndex("font_weight");
                int columnIndex6 = cursorMo8975AZxh.getColumnIndex("font_italic");
                while (cursorMo8975AZxh.moveToNext()) {
                    int i = columnIndex != -1 ? cursorMo8975AZxh.getInt(columnIndex) : 0;
                    int i2 = columnIndex4 != -1 ? cursorMo8975AZxh.getInt(columnIndex4) : 0;
                    if (columnIndex3 == -1) {
                        arrayList = arrayList3;
                        uriWithAppendedId = ContentUris.withAppendedId(uriBuild, cursorMo8975AZxh.getLong(columnIndex2));
                    } else {
                        arrayList = arrayList3;
                        uriWithAppendedId = ContentUris.withAppendedId(uriBuild2, cursorMo8975AZxh.getLong(columnIndex3));
                    }
                    int i3 = columnIndex5 != -1 ? cursorMo8975AZxh.getInt(columnIndex5) : 400;
                    if (columnIndex6 != -1) {
                        z = true;
                        if (cursorMo8975AZxh.getInt(columnIndex6) != 1) {
                            z = false;
                        }
                    }
                    AbstractC2927Tz.AZxh aZxhM10453mjFkc = AbstractC2927Tz.AZxh.m10453mjFkc(uriWithAppendedId, i2, i3, z, i);
                    arrayList3 = arrayList;
                    arrayList3.add(aZxhM10453mjFkc);
                }
                arrayList2 = arrayList3;
            }
            if (cursorMo8975AZxh != null) {
                cursorMo8975AZxh.close();
            }
            mjfkcM8977mjFkc.mo8976close();
            return (AbstractC2927Tz.AZxh[]) arrayList2.toArray(new AbstractC2927Tz.AZxh[0]);
        } catch (Throwable th) {
            if (cursorMo8975AZxh != null) {
                cursorMo8975AZxh.close();
            }
            mjfkcM8977mjFkc.mo8976close();
            throw th;
        }
    }

    /* renamed from: wA */
    public static boolean m8973wA(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals((byte[]) list.get(i), (byte[]) list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: xJ */
    public static /* synthetic */ int m8974xJ(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            byte b2 = bArr2[i];
            if (b != b2) {
                return b - b2;
            }
        }
        return 0;
    }
}
