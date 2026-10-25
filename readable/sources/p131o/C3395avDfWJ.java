package p131o;

import android.util.Base64;
import java.util.List;

/* renamed from: o.avDfWJ */
/* loaded from: classes.dex */
public final class C3395avDfWJ {

    /* renamed from: AZxh */
    public final String f12828AZxh;

    /* renamed from: JHa */
    public final String f12829JHa;

    /* renamed from: KLFTb */
    public final int f12830KLFTb = 0;

    /* renamed from: ZfxDd */
    public final List f12831ZfxDd;

    /* renamed from: mjFkc */
    public final String f12832mjFkc;

    /* renamed from: wA */
    public final String f12833wA;

    public C3395avDfWJ(String str, String str2, String str3, List list) {
        this.f12832mjFkc = (String) AbstractC2280K3.m9126xJ(str);
        this.f12828AZxh = (String) AbstractC2280K3.m9126xJ(str2);
        this.f12833wA = (String) AbstractC2280K3.m9126xJ(str3);
        this.f12831ZfxDd = (List) AbstractC2280K3.m9126xJ(list);
        this.f12829JHa = m11429mjFkc(str, str2, str3);
    }

    /* renamed from: AZxh */
    public List m11425AZxh() {
        return this.f12831ZfxDd;
    }

    /* renamed from: JHa */
    public String m11426JHa() {
        return this.f12828AZxh;
    }

    /* renamed from: KLFTb */
    public String m11427KLFTb() {
        return this.f12832mjFkc;
    }

    /* renamed from: ZfxDd */
    public String m11428ZfxDd() {
        return this.f12829JHa;
    }

    /* renamed from: mjFkc */
    public final String m11429mjFkc(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f12832mjFkc + ", mProviderPackage: " + this.f12828AZxh + ", mQuery: " + this.f12833wA + ", mCertificates:");
        for (int i = 0; i < this.f12831ZfxDd.size(); i++) {
            sb.append(" [");
            List list = (List) this.f12831ZfxDd.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f12830KLFTb);
        return sb.toString();
    }

    /* renamed from: wA */
    public int m11430wA() {
        return this.f12830KLFTb;
    }

    /* renamed from: xJ */
    public String m11431xJ() {
        return this.f12833wA;
    }
}
