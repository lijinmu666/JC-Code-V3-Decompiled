package p131o;

import android.os.Bundle;
import p131o.C3389aqHPIZ;

/* renamed from: o.T7 */
/* loaded from: classes.dex */
public class C2874T7 implements C3389aqHPIZ.ZfxDd {

    /* renamed from: wA */
    public static final C2874T7 f10642wA = m10216mjFkc().m10220mjFkc();

    /* renamed from: AZxh */
    public final String f10643AZxh;

    /* renamed from: o.T7$mjFkc */
    public static class mjFkc {

        /* renamed from: mjFkc */
        public String f10644mjFkc;

        public /* synthetic */ mjFkc(AbstractC2770Rb abstractC2770Rb) {
        }

        /* renamed from: AZxh */
        public mjFkc m10219AZxh(String str) {
            this.f10644mjFkc = str;
            return this;
        }

        /* renamed from: mjFkc */
        public C2874T7 m10220mjFkc() {
            return new C2874T7(this.f10644mjFkc, null);
        }
    }

    public /* synthetic */ C2874T7(String str, AbstractC2902Tb abstractC2902Tb) {
        this.f10643AZxh = str;
    }

    /* renamed from: mjFkc */
    public static mjFkc m10216mjFkc() {
        return new mjFkc(null);
    }

    /* renamed from: AZxh */
    public final Bundle m10217AZxh() {
        Bundle bundle = new Bundle();
        String str = this.f10643AZxh;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    /* renamed from: equals */
    public final boolean m10218equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2874T7) {
            return AbstractC2931U2.m10465mjFkc(this.f10643AZxh, ((C2874T7) obj).f10643AZxh);
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC2931U2.m10464AZxh(this.f10643AZxh);
    }
}
