package p131o;

import java.lang.ref.WeakReference;

/* renamed from: o.TO */
/* loaded from: classes.dex */
public abstract class AbstractBinderC2892TO extends AbstractBinderC1821DM {

    /* renamed from: wA */
    public static final WeakReference f10694wA = new WeakReference(null);

    /* renamed from: AZxh */
    public WeakReference f10695AZxh;

    public AbstractBinderC2892TO(byte[] bArr) {
        super(bArr);
        this.f10695AZxh = f10694wA;
    }

    /* renamed from: Ucbh */
    public abstract byte[] mo10412Ucbh();

    @Override // p131o.AbstractBinderC1821DM
    /* renamed from: xJ */
    public final byte[] mo7995xJ() {
        byte[] bArrMo10412Ucbh;
        synchronized (this) {
            try {
                bArrMo10412Ucbh = (byte[]) this.f10695AZxh.get();
                if (bArrMo10412Ucbh == null) {
                    bArrMo10412Ucbh = mo10412Ucbh();
                    this.f10695AZxh = new WeakReference(bArrMo10412Ucbh);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrMo10412Ucbh;
    }
}
