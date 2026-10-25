package p131o;

import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* renamed from: o.DM */
/* loaded from: classes.dex */
public abstract class AbstractBinderC1821DM extends AbstractBinderC3698fX {

    /* renamed from: mjFkc */
    public final int f7857mjFkc;

    public AbstractBinderC1821DM(byte[] bArr) {
        AbstractC2138I3.m8645mjFkc(bArr.length == 25);
        this.f7857mjFkc = Arrays.hashCode(bArr);
    }

    /* renamed from: KLFTb */
    public static byte[] m7993KLFTb(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: equals */
    public final boolean m7994equals(Object obj) {
        InterfaceC1929F interfaceC1929FMo7982wA;
        if (obj != null && (obj instanceof InterfaceC1810DB)) {
            try {
                InterfaceC1810DB interfaceC1810DB = (InterfaceC1810DB) obj;
                if (interfaceC1810DB.mo7981mjFkc() == this.f7857mjFkc && (interfaceC1929FMo7982wA = interfaceC1810DB.mo7982wA()) != null) {
                    return Arrays.equals(mo7995xJ(), (byte[]) BinderC2869T2.m10214xJ(interfaceC1929FMo7982wA));
                }
                return false;
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f7857mjFkc;
    }

    @Override // p131o.InterfaceC1810DB
    /* renamed from: mjFkc */
    public final int mo7981mjFkc() {
        return this.f7857mjFkc;
    }

    @Override // p131o.InterfaceC1810DB
    /* renamed from: wA */
    public final InterfaceC1929F mo7982wA() {
        return BinderC2869T2.m10213Ucbh(mo7995xJ());
    }

    /* renamed from: xJ */
    public abstract byte[] mo7995xJ();
}
