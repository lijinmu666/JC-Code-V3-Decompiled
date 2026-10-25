package p131o;

import android.content.res.Configuration;
import android.os.LocaleList;

/* renamed from: o.Es */
/* loaded from: classes.dex */
public abstract class AbstractC1921Es {

    /* renamed from: o.Es$mjFkc */
    public static class mjFkc {
        /* renamed from: AZxh */
        public static void m8225AZxh(Configuration configuration, C3663f1 c3663f1) {
            configuration.setLocales((LocaleList) c3663f1.m11880ZfxDd());
        }

        /* renamed from: mjFkc */
        public static LocaleList m8226mjFkc(Configuration configuration) {
            return configuration.getLocales();
        }
    }

    /* renamed from: mjFkc */
    public static C3663f1 m8224mjFkc(Configuration configuration) {
        return C3663f1.m11877KLFTb(mjFkc.m8226mjFkc(configuration));
    }
}
