package p131o;

/* renamed from: o.iF */
/* loaded from: classes.dex */
public final class C3875iF implements InterfaceC4535sF {

    /* renamed from: AZxh */
    public final EnumC4400qF f14139AZxh;

    /* renamed from: mjFkc */
    public final int f14140mjFkc;

    public C3875iF(int i, EnumC4400qF enumC4400qF) {
        this.f14140mjFkc = i;
        this.f14139AZxh = enumC4400qF;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return InterfaceC4535sF.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InterfaceC4535sF)) {
            return false;
        }
        InterfaceC4535sF interfaceC4535sF = (InterfaceC4535sF) obj;
        return this.f14140mjFkc == interfaceC4535sF.mo12291zza() && this.f14139AZxh.equals(interfaceC4535sF.mo12292zzb());
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (this.f14140mjFkc ^ 14552422) + (this.f14139AZxh.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f14140mjFkc + "intEncoding=" + this.f14139AZxh + ')';
    }

    @Override // p131o.InterfaceC4535sF
    /* renamed from: zza */
    public final int mo12291zza() {
        return this.f14140mjFkc;
    }

    @Override // p131o.InterfaceC4535sF
    /* renamed from: zzb */
    public final EnumC4400qF mo12292zzb() {
        return this.f14139AZxh;
    }
}
