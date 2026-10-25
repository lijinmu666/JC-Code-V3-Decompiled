package org.bouncycastle.p249jcajce.provider.asymmetric.p264util;

import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.internal.p231asn1.p245oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p361util.C6250Strings;

/* renamed from: org.bouncycastle.jcajce.provider.asymmetric.util.DESUtil */
/* loaded from: classes2.dex */
public class C5614DESUtil {

    /* renamed from: des */
    private static final Set<String> f21641des;

    static {
        HashSet hashSet = new HashSet();
        f21641des = hashSet;
        hashSet.add("DES");
        hashSet.add("DESEDE");
        hashSet.add(OIWObjectIdentifiers.f21277desCBC.m14433getId());
        hashSet.add(PKCSObjectIdentifiers.des_EDE3_CBC.m14433getId());
        hashSet.add(PKCSObjectIdentifiers.id_alg_CMS3DESwrap.m14433getId());
    }

    /* renamed from: isDES */
    public static boolean m16139isDES(String str) {
        return f21641des.contains(C6250Strings.toUpperCase(str));
    }

    public static void setOddParity(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            bArr[i] = (byte) (((((b >> 7) ^ ((((((b >> 1) ^ (b >> 2)) ^ (b >> 3)) ^ (b >> 4)) ^ (b >> 5)) ^ (b >> 6))) ^ 1) & 1) | (b & 254));
        }
    }
}
