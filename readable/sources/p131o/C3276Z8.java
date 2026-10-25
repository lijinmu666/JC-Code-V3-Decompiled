package p131o;

import java.util.Set;

/* renamed from: o.Z8 */
/* loaded from: classes.dex */
public final class C3276Z8 implements InterfaceC3210Y8 {

    /* renamed from: AZxh */
    public final AbstractC3140X8 f12004AZxh;

    /* renamed from: mjFkc */
    public final Set f12005mjFkc;

    /* renamed from: wA */
    public final InterfaceC3478c9 f12006wA;

    public C3276Z8(Set set, AbstractC3140X8 abstractC3140X8, InterfaceC3478c9 interfaceC3478c9) {
        this.f12005mjFkc = set;
        this.f12004AZxh = abstractC3140X8;
        this.f12006wA = interfaceC3478c9;
    }

    @Override // p131o.InterfaceC3210Y8
    /* renamed from: mjFkc */
    public InterfaceC3009V8 mo11048mjFkc(String str, Class cls, C3569dXmy c3569dXmy, InterfaceC2416M8 interfaceC2416M8) {
        if (this.f12005mjFkc.contains(c3569dXmy)) {
            return new C3411b9(this.f12004AZxh, str, c3569dXmy, interfaceC2416M8, this.f12006wA);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", c3569dXmy, this.f12005mjFkc));
    }
}
