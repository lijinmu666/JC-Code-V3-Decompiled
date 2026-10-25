package p131o;

/* renamed from: o.LB */
/* loaded from: classes.dex */
public final class C2355LB implements InterfaceC3481cC {

    /* renamed from: AZxh */
    public final EnumC3213YB f9410AZxh;

    /* renamed from: mjFkc */
    public final int f9411mjFkc;

    public C2355LB(int i, EnumC3213YB enumC3213YB) {
        this.f9411mjFkc = i;
        this.f9410AZxh = enumC3213YB;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return InterfaceC3481cC.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InterfaceC3481cC)) {
            return false;
        }
        InterfaceC3481cC interfaceC3481cC = (InterfaceC3481cC) obj;
        return this.f9411mjFkc == interfaceC3481cC.mo9362zza() && this.f9410AZxh.equals(interfaceC3481cC.mo9363zzb());
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (this.f9411mjFkc ^ 14552422) + (this.f9410AZxh.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f9411mjFkc + "intEncoding=" + this.f9410AZxh + ')';
    }

    @Override // p131o.InterfaceC3481cC
    /* renamed from: zza */
    public final int mo9362zza() {
        return this.f9411mjFkc;
    }

    @Override // p131o.InterfaceC3481cC
    /* renamed from: zzb */
    public final EnumC3213YB mo9363zzb() {
        return this.f9410AZxh;
    }
}
