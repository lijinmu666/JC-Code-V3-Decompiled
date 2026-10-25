package org.bouncycastle.p314pqc.p334jcajce.provider.p341lms;

import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InterfaceC5284Xof;

/* loaded from: classes2.dex */
class DigestUtil {
    public static byte[] getDigestResult(InterfaceC5277Digest interfaceC5277Digest) {
        int digestSize = interfaceC5277Digest.getDigestSize();
        byte[] bArr = new byte[digestSize];
        if (interfaceC5277Digest instanceof InterfaceC5284Xof) {
            ((InterfaceC5284Xof) interfaceC5277Digest).mo14998doFinal(bArr, 0, digestSize);
        } else {
            interfaceC5277Digest.mo14967doFinal(bArr, 0);
        }
        return bArr;
    }
}
