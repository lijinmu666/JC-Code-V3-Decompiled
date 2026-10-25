package org.bouncycastle.p194crypto.p215prng.p216drbg;

import java.util.Hashtable;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p314pqc.p316crypto.p330sphincs.SPHINCSKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;
import org.bouncycastle.p361util.Integers;

/* renamed from: org.bouncycastle.crypto.prng.drbg.Utils */
/* loaded from: classes2.dex */
class C5379Utils {
    static final Hashtable maxSecurityStrengths;

    static {
        Hashtable hashtable = new Hashtable();
        maxSecurityStrengths = hashtable;
        hashtable.put("SHA-1", Integers.m18296valueOf(128));
        hashtable.put("SHA-224", Integers.m18296valueOf(192));
        hashtable.put(XMSSKeyParameters.f23621SHA_256, Integers.m18296valueOf(256));
        hashtable.put("SHA-384", Integers.m18296valueOf(256));
        hashtable.put(XMSSKeyParameters.f23622SHA_512, Integers.m18296valueOf(256));
        hashtable.put("SHA-512/224", Integers.m18296valueOf(192));
        hashtable.put(SPHINCSKeyParameters.SHA512_256, Integers.m18296valueOf(256));
    }

    public static int getMaxSecurityStrength(InterfaceC5277Digest interfaceC5277Digest) {
        return ((Integer) maxSecurityStrengths.get(interfaceC5277Digest.getAlgorithmName())).intValue();
    }

    /* renamed from: hash_df */
    public static byte[] m15855hash_df(InterfaceC5277Digest interfaceC5277Digest, byte[] bArr, int i) {
        int i2 = (i + 7) / 8;
        byte[] bArr2 = new byte[i2];
        int digestSize = i2 / interfaceC5277Digest.getDigestSize();
        int digestSize2 = interfaceC5277Digest.getDigestSize();
        byte[] bArr3 = new byte[digestSize2];
        int i3 = 1;
        int i4 = 0;
        for (int i5 = 0; i5 <= digestSize; i5++) {
            interfaceC5277Digest.mo14969update((byte) i3);
            interfaceC5277Digest.mo14969update((byte) (i >> 24));
            interfaceC5277Digest.mo14969update((byte) (i >> 16));
            interfaceC5277Digest.mo14969update((byte) (i >> 8));
            interfaceC5277Digest.mo14969update((byte) i);
            interfaceC5277Digest.mo14970update(bArr, 0, bArr.length);
            interfaceC5277Digest.mo14967doFinal(bArr3, 0);
            int i6 = i5 * digestSize2;
            int i7 = i2 - i6;
            if (i7 > digestSize2) {
                i7 = digestSize2;
            }
            System.arraycopy(bArr3, 0, bArr2, i6, i7);
            i3++;
        }
        int i8 = i % 8;
        if (i8 != 0) {
            int i9 = 8 - i8;
            int i10 = 0;
            while (i4 != i2) {
                int i11 = bArr2[i4] & 255;
                bArr2[i4] = (byte) ((i10 << (8 - i9)) | (i11 >>> i9));
                i4++;
                i10 = i11;
            }
        }
        return bArr2;
    }

    public static boolean isTooLarge(byte[] bArr, int i) {
        return bArr != null && bArr.length > i;
    }

    public static int getMaxSecurityStrength(InterfaceC5278Mac interfaceC5278Mac) {
        String algorithmName = interfaceC5278Mac.getAlgorithmName();
        return ((Integer) maxSecurityStrengths.get(algorithmName.substring(0, algorithmName.indexOf("/")))).intValue();
    }
}
