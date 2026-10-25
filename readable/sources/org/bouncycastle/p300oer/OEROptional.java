package org.bouncycastle.p300oer;

import java.security.AccessController;
import java.security.PrivilegedAction;
import org.bouncycastle.p133asn1.ASN1Absent;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;

/* loaded from: classes2.dex */
public class OEROptional extends ASN1Object {

    /* renamed from: ABSENT */
    public static final OEROptional f22567ABSENT = new OEROptional(false, null);

    /* renamed from: defined */
    private final boolean f22568defined;

    /* renamed from: value */
    private final ASN1Encodable f22569value;

    private OEROptional(boolean z, ASN1Encodable aSN1Encodable) {
        this.f22568defined = z;
        this.f22569value = aSN1Encodable;
    }

    public static OEROptional getInstance(Object obj) {
        return obj instanceof OEROptional ? (OEROptional) obj : obj instanceof ASN1Encodable ? new OEROptional(true, (ASN1Encodable) obj) : f22567ABSENT;
    }

    public static <T> T getValue(Class<T> cls, Object obj) {
        OEROptional oEROptional = getInstance(obj);
        if (oEROptional.f22568defined) {
            return (T) oEROptional.getObject(cls);
        }
        return null;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object
    /* renamed from: equals */
    public boolean mo14431equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.mo14431equals(obj)) {
            return false;
        }
        OEROptional oEROptional = (OEROptional) obj;
        if (this.f22568defined != oEROptional.f22568defined) {
            return false;
        }
        ASN1Encodable aSN1Encodable = this.f22569value;
        return aSN1Encodable != null ? aSN1Encodable.equals(oEROptional.f22569value) : oEROptional.f22569value == null;
    }

    /* renamed from: get */
    public ASN1Encodable m17167get() {
        return !this.f22568defined ? f22567ABSENT : this.f22569value;
    }

    public <T> T getObject(final Class<T> cls) {
        if (this.f22568defined) {
            return this.f22569value.getClass().isInstance(cls) ? cls.cast(this.f22569value) : (T) AccessController.doPrivileged(new PrivilegedAction<T>(this) { // from class: org.bouncycastle.oer.OEROptional.1

                /* renamed from: this$0 */
                final /* synthetic */ OEROptional f22570this$0;

                {
                    this.f22570this$0 = this;
                }

                @Override // java.security.PrivilegedAction
                public T run() throws NoSuchMethodException, SecurityException {
                    try {
                        return (T) cls.cast(cls.getMethod("getInstance", Object.class).invoke(null, this.f22570this$0.f22569value));
                    } catch (Exception e) {
                        throw new IllegalStateException("could not invoke getInstance on type " + e.getMessage(), e);
                    }
                }
            });
        }
        return null;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object
    public int hashCode() {
        int iHashCode = ((super.hashCode() * 31) + (this.f22568defined ? 1 : 0)) * 31;
        ASN1Encodable aSN1Encodable = this.f22569value;
        return iHashCode + (aSN1Encodable != null ? aSN1Encodable.hashCode() : 0);
    }

    public boolean isDefined() {
        return this.f22568defined;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return !this.f22568defined ? ASN1Absent.INSTANCE : m17167get().toASN1Primitive();
    }

    public String toString() {
        if (!this.f22568defined) {
            return "ABSENT";
        }
        return "OPTIONAL(" + this.f22569value + ")";
    }
}
