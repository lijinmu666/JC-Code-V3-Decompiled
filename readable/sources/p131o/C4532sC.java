package p131o;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* renamed from: o.sC */
/* loaded from: classes.dex */
public final class C4532sC {

    /* renamed from: AZxh */
    public final Map f16471AZxh;

    /* renamed from: mjFkc */
    public final Map f16472mjFkc;

    /* renamed from: wA */
    public final InterfaceC2735R2 f16473wA;

    public C4532sC(Map map, Map map2, InterfaceC2735R2 interfaceC2735R2) {
        this.f16472mjFkc = map;
        this.f16471AZxh = map2;
        this.f16473wA = interfaceC2735R2;
    }

    /* renamed from: mjFkc */
    public final byte[] m13494mjFkc(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new C3932jC(byteArrayOutputStream, this.f16472mjFkc, this.f16471AZxh, this.f16473wA).m12405lgHUyS(obj);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
