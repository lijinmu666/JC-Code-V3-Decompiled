package p131o;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* renamed from: o.MF */
/* loaded from: classes.dex */
public final class C2423MF {

    /* renamed from: AZxh */
    public final Map f9560AZxh;

    /* renamed from: mjFkc */
    public final Map f9561mjFkc;

    /* renamed from: wA */
    public final InterfaceC2735R2 f9562wA;

    public C2423MF(Map map, Map map2, InterfaceC2735R2 interfaceC2735R2) {
        this.f9561mjFkc = map;
        this.f9560AZxh = map2;
        this.f9562wA = interfaceC2735R2;
    }

    /* renamed from: mjFkc */
    public final byte[] m9493mjFkc(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new C4801wF(byteArrayOutputStream, this.f9561mjFkc, this.f9560AZxh, this.f9562wA).m13842lgHUyS(obj);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
