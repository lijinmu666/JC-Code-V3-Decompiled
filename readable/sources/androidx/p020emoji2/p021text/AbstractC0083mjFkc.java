package androidx.p020emoji2.p021text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.util.Log;
import androidx.p020emoji2.p021text.C0084wA;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p131o.AbstractC2280K3;
import p131o.C3395avDfWJ;

/* renamed from: androidx.emoji2.text.mjFkc */
/* loaded from: classes.dex */
public abstract class AbstractC0083mjFkc {

    /* renamed from: androidx.emoji2.text.mjFkc$AZxh */
    public static class AZxh {
        /* renamed from: AZxh */
        public abstract Signature[] mo677AZxh(PackageManager packageManager, String str);

        /* renamed from: mjFkc */
        public abstract ProviderInfo mo678mjFkc(ResolveInfo resolveInfo);

        /* renamed from: wA */
        public abstract List mo679wA(PackageManager packageManager, Intent intent, int i);
    }

    /* renamed from: androidx.emoji2.text.mjFkc$ZfxDd */
    public static class ZfxDd extends wA {
        @Override // androidx.p020emoji2.p021text.AbstractC0083mjFkc.AZxh
        /* renamed from: AZxh */
        public Signature[] mo677AZxh(PackageManager packageManager, String str) {
            return packageManager.getPackageInfo(str, 64).signatures;
        }
    }

    /* renamed from: androidx.emoji2.text.mjFkc$mjFkc */
    public static class mjFkc {

        /* renamed from: mjFkc */
        public final AZxh f1028mjFkc;

        public mjFkc(AZxh aZxh) {
            this.f1028mjFkc = aZxh == null ? m680KLFTb() : aZxh;
        }

        /* renamed from: KLFTb */
        public static AZxh m680KLFTb() {
            return new ZfxDd();
        }

        /* renamed from: AZxh */
        public final List m681AZxh(Signature[] signatureArr) {
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            return Collections.singletonList(arrayList);
        }

        /* renamed from: JHa */
        public final boolean m682JHa(ProviderInfo providerInfo) {
            ApplicationInfo applicationInfo;
            return (providerInfo == null || (applicationInfo = providerInfo.applicationInfo) == null || (applicationInfo.flags & 1) != 1) ? false : true;
        }

        /* renamed from: ZfxDd */
        public final C3395avDfWJ m683ZfxDd(ProviderInfo providerInfo, PackageManager packageManager) {
            String str = providerInfo.authority;
            String str2 = providerInfo.packageName;
            return new C3395avDfWJ(str, str2, "emojicompat-emoji-font", m681AZxh(this.f1028mjFkc.mo677AZxh(packageManager, str2)));
        }

        /* renamed from: lgHUyS */
        public C3395avDfWJ m684lgHUyS(Context context) {
            PackageManager packageManager = context.getPackageManager();
            AbstractC2280K3.m9122lgHUyS(packageManager, "Package manager required to locate emoji font provider");
            ProviderInfo providerInfoM687xJ = m687xJ(packageManager);
            if (providerInfoM687xJ == null) {
                return null;
            }
            try {
                return m683ZfxDd(providerInfoM687xJ, packageManager);
            } catch (PackageManager.NameNotFoundException e) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e);
                return null;
            }
        }

        /* renamed from: mjFkc */
        public final C0084wA.wA m685mjFkc(Context context, C3395avDfWJ c3395avDfWJ) {
            if (c3395avDfWJ == null) {
                return null;
            }
            return new C0081KLFTb(context, c3395avDfWJ);
        }

        /* renamed from: wA */
        public C0084wA.wA m686wA(Context context) {
            return m685mjFkc(context, m684lgHUyS(context));
        }

        /* renamed from: xJ */
        public final ProviderInfo m687xJ(PackageManager packageManager) {
            Iterator it = this.f1028mjFkc.mo679wA(packageManager, new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
            while (it.hasNext()) {
                ProviderInfo providerInfoMo678mjFkc = this.f1028mjFkc.mo678mjFkc((ResolveInfo) it.next());
                if (m682JHa(providerInfoMo678mjFkc)) {
                    return providerInfoMo678mjFkc;
                }
            }
            return null;
        }
    }

    /* renamed from: androidx.emoji2.text.mjFkc$wA */
    public static class wA extends AZxh {
        @Override // androidx.p020emoji2.p021text.AbstractC0083mjFkc.AZxh
        /* renamed from: mjFkc */
        public ProviderInfo mo678mjFkc(ResolveInfo resolveInfo) {
            return resolveInfo.providerInfo;
        }

        @Override // androidx.p020emoji2.p021text.AbstractC0083mjFkc.AZxh
        /* renamed from: wA */
        public List mo679wA(PackageManager packageManager, Intent intent, int i) {
            return packageManager.queryIntentContentProviders(intent, i);
        }
    }

    /* renamed from: mjFkc */
    public static C0081KLFTb m676mjFkc(Context context) {
        return (C0081KLFTb) new mjFkc(null).m686wA(context);
    }
}
