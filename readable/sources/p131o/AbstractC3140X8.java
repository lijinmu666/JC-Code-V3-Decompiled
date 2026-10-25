package p131o;

import android.util.Base64;
import org.conscrypt.BuildConfig;
import p131o.C3981jtz;

/* renamed from: o.X8 */
/* loaded from: classes.dex */
public abstract class AbstractC3140X8 {

    /* renamed from: o.X8$mjFkc */
    public static abstract class mjFkc {
        /* renamed from: AZxh */
        public abstract mjFkc mo10891AZxh(String str);

        /* renamed from: ZfxDd */
        public abstract mjFkc mo10892ZfxDd(EnumC2347L3 enumC2347L3);

        /* renamed from: mjFkc */
        public abstract AbstractC3140X8 mo10893mjFkc();

        /* renamed from: wA */
        public abstract mjFkc mo10894wA(byte[] bArr);
    }

    /* renamed from: mjFkc */
    public static mjFkc m10886mjFkc() {
        return new C3981jtz.AZxh().mo10892ZfxDd(EnumC2347L3.DEFAULT);
    }

    /* renamed from: AZxh */
    public abstract String mo10887AZxh();

    /* renamed from: KLFTb */
    public AbstractC3140X8 m10888KLFTb(EnumC2347L3 enumC2347L3) {
        return m10886mjFkc().mo10891AZxh(mo10887AZxh()).mo10892ZfxDd(enumC2347L3).mo10894wA(mo10890wA()).mo10893mjFkc();
    }

    /* renamed from: ZfxDd */
    public abstract EnumC2347L3 mo10889ZfxDd();

    public final String toString() {
        return String.format("TransportContext(%s, %s, %s)", mo10887AZxh(), mo10889ZfxDd(), mo10890wA() == null ? BuildConfig.f24315FLAVOR : Base64.encodeToString(mo10890wA(), 2));
    }

    /* renamed from: wA */
    public abstract byte[] mo10890wA();
}
