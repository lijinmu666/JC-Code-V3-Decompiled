package p131o;

import android.app.RemoteInput;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: o.j5 */
/* loaded from: classes.dex */
public final class C3925j5 {

    /* renamed from: AZxh */
    public final CharSequence f14241AZxh;

    /* renamed from: JHa */
    public final Bundle f14242JHa;

    /* renamed from: KLFTb */
    public final int f14243KLFTb;

    /* renamed from: ZfxDd */
    public final boolean f14244ZfxDd;

    /* renamed from: mjFkc */
    public final String f14245mjFkc;

    /* renamed from: wA */
    public final CharSequence[] f14246wA;

    /* renamed from: xJ */
    public final Set f14247xJ;

    /* renamed from: o.j5$AZxh */
    public static class AZxh {
        /* renamed from: AZxh */
        public static Set<String> m12353AZxh(Object obj) {
            return ((RemoteInput) obj).getAllowedDataTypes();
        }

        /* renamed from: ZfxDd */
        public static RemoteInput.Builder m12354ZfxDd(RemoteInput.Builder builder, String str, boolean z) {
            return builder.setAllowDataType(str, z);
        }

        /* renamed from: mjFkc */
        public static void m12355mjFkc(C3925j5 c3925j5, Intent intent, Map<String, Uri> map) {
            RemoteInput.addDataResultToIntent(C3925j5.m12344mjFkc(c3925j5), intent, map);
        }

        /* renamed from: wA */
        public static Map<String, Uri> m12356wA(Intent intent, String str) {
            return RemoteInput.getDataResultsFromIntent(intent, str);
        }
    }

    /* renamed from: o.j5$ZfxDd */
    public static final class ZfxDd {

        /* renamed from: KLFTb */
        public CharSequence[] f14250KLFTb;

        /* renamed from: ZfxDd */
        public CharSequence f14251ZfxDd;

        /* renamed from: mjFkc */
        public final String f14252mjFkc;

        /* renamed from: AZxh */
        public final Set f14248AZxh = new HashSet();

        /* renamed from: wA */
        public final Bundle f14253wA = new Bundle();

        /* renamed from: JHa */
        public boolean f14249JHa = true;

        /* renamed from: xJ */
        public int f14254xJ = 0;

        public ZfxDd(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Result key can't be null");
            }
            this.f14252mjFkc = str;
        }

        /* renamed from: AZxh */
        public ZfxDd m12357AZxh(CharSequence charSequence) {
            this.f14251ZfxDd = charSequence;
            return this;
        }

        /* renamed from: mjFkc */
        public C3925j5 m12358mjFkc() {
            return new C3925j5(this.f14252mjFkc, this.f14251ZfxDd, this.f14250KLFTb, this.f14249JHa, this.f14254xJ, this.f14253wA, this.f14248AZxh);
        }
    }

    /* renamed from: o.j5$mjFkc */
    public static class mjFkc {
        /* renamed from: AZxh */
        public static RemoteInput m12359AZxh(C3925j5 c3925j5) {
            RemoteInput.Builder builderAddExtras = new RemoteInput.Builder(c3925j5.m12350qdMbNW()).setLabel(c3925j5.m12349lgHUyS()).setChoices(c3925j5.m12347KLFTb()).setAllowFreeFormInput(c3925j5.m12351wA()).addExtras(c3925j5.m12352xJ());
            Set setM12348ZfxDd = c3925j5.m12348ZfxDd();
            if (setM12348ZfxDd != null) {
                Iterator it = setM12348ZfxDd.iterator();
                while (it.hasNext()) {
                    AZxh.m12354ZfxDd(builderAddExtras, (String) it.next(), true);
                }
            }
            wA.m12362AZxh(builderAddExtras, c3925j5.m12346JHa());
            return builderAddExtras.build();
        }

        /* renamed from: mjFkc */
        public static void m12360mjFkc(Object obj, Intent intent, Bundle bundle) {
            RemoteInput.addResultsToIntent((RemoteInput[]) obj, intent, bundle);
        }

        /* renamed from: wA */
        public static Bundle m12361wA(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    /* renamed from: o.j5$wA */
    public static class wA {
        /* renamed from: AZxh */
        public static RemoteInput.Builder m12362AZxh(RemoteInput.Builder builder, int i) {
            return builder.setEditChoicesBeforeSending(i);
        }

        /* renamed from: mjFkc */
        public static int m12363mjFkc(Object obj) {
            return ((RemoteInput) obj).getEditChoicesBeforeSending();
        }
    }

    public C3925j5(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, int i, Bundle bundle, Set set) {
        this.f14245mjFkc = str;
        this.f14241AZxh = charSequence;
        this.f14246wA = charSequenceArr;
        this.f14244ZfxDd = z;
        this.f14243KLFTb = i;
        this.f14242JHa = bundle;
        this.f14247xJ = set;
        if (m12346JHa() == 2 && !m12351wA()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    /* renamed from: AZxh */
    public static RemoteInput[] m12342AZxh(C3925j5[] c3925j5Arr) {
        if (c3925j5Arr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[c3925j5Arr.length];
        for (int i = 0; i < c3925j5Arr.length; i++) {
            remoteInputArr[i] = m12344mjFkc(c3925j5Arr[i]);
        }
        return remoteInputArr;
    }

    /* renamed from: Dt */
    public static Bundle m12343Dt(Intent intent) {
        return mjFkc.m12361wA(intent);
    }

    /* renamed from: mjFkc */
    public static RemoteInput m12344mjFkc(C3925j5 c3925j5) {
        return mjFkc.m12359AZxh(c3925j5);
    }

    /* renamed from: ETF */
    public boolean m12345ETF() {
        return (m12351wA() || (m12347KLFTb() != null && m12347KLFTb().length != 0) || m12348ZfxDd() == null || m12348ZfxDd().isEmpty()) ? false : true;
    }

    /* renamed from: JHa */
    public int m12346JHa() {
        return this.f14243KLFTb;
    }

    /* renamed from: KLFTb */
    public CharSequence[] m12347KLFTb() {
        return this.f14246wA;
    }

    /* renamed from: ZfxDd */
    public Set m12348ZfxDd() {
        return this.f14247xJ;
    }

    /* renamed from: lgHUyS */
    public CharSequence m12349lgHUyS() {
        return this.f14241AZxh;
    }

    /* renamed from: qdMbNW */
    public String m12350qdMbNW() {
        return this.f14245mjFkc;
    }

    /* renamed from: wA */
    public boolean m12351wA() {
        return this.f14244ZfxDd;
    }

    /* renamed from: xJ */
    public Bundle m12352xJ() {
        return this.f14242JHa;
    }
}
