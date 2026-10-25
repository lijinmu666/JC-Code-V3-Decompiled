package org.bouncycastle.p194crypto.p221util;

import java.io.IOException;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Exceptions;

/* renamed from: org.bouncycastle.crypto.util.DerUtil */
/* loaded from: classes2.dex */
class C5404DerUtil {
    public static ASN1OctetString getOctetString(byte[] bArr) {
        return bArr == null ? new DEROctetString(new byte[0]) : new DEROctetString(C6238Arrays.m18231clone(bArr));
    }

    public static byte[] toByteArray(ASN1Primitive aSN1Primitive) {
        try {
            return aSN1Primitive.getEncoded();
        } catch (IOException e) {
            throw Exceptions.illegalStateException("Cannot get encoding: " + e.getMessage(), e);
        }
    }
}
