package org.bouncycastle.p314pqc.p316crypto.p321lms;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.DisplayText;

/* loaded from: classes2.dex */
public class LMOtsParameters {
    public static final int reserved = 0;
    public static final LMOtsParameters sha256_n24_w1;
    public static final LMOtsParameters sha256_n24_w2;
    public static final LMOtsParameters sha256_n24_w4;
    public static final LMOtsParameters sha256_n24_w8;
    public static final LMOtsParameters sha256_n32_w1;
    public static final LMOtsParameters sha256_n32_w2;
    public static final LMOtsParameters sha256_n32_w4;
    public static final LMOtsParameters sha256_n32_w8;
    public static final LMOtsParameters shake256_n24_w1;
    public static final LMOtsParameters shake256_n24_w2;
    public static final LMOtsParameters shake256_n24_w4;
    public static final LMOtsParameters shake256_n24_w8;
    public static final LMOtsParameters shake256_n32_w1;
    public static final LMOtsParameters shake256_n32_w2;
    public static final LMOtsParameters shake256_n32_w4;
    public static final LMOtsParameters shake256_n32_w8;
    private static final Map<Object, LMOtsParameters> suppliers;
    private final ASN1ObjectIdentifier digestOID;

    /* renamed from: ls */
    private final int f23226ls;

    /* renamed from: n */
    private final int f23227n;

    /* renamed from: p */
    private final int f23228p;

    /* renamed from: sigLen */
    private final int f23229sigLen;

    /* renamed from: type */
    private final int f23230type;

    /* renamed from: w */
    private final int f23231w;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_sha256;
        sha256_n32_w1 = new LMOtsParameters(1, 32, 1, 265, 7, 8516, aSN1ObjectIdentifier);
        sha256_n32_w2 = new LMOtsParameters(2, 32, 2, 133, 6, 4292, aSN1ObjectIdentifier);
        sha256_n32_w4 = new LMOtsParameters(3, 32, 4, 67, 4, 2180, aSN1ObjectIdentifier);
        sha256_n32_w8 = new LMOtsParameters(4, 32, 8, 34, 0, 1124, aSN1ObjectIdentifier);
        sha256_n24_w1 = new LMOtsParameters(5, 24, 1, DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE, 8, 5436, aSN1ObjectIdentifier);
        sha256_n24_w2 = new LMOtsParameters(6, 24, 2, 101, 6, 2940, aSN1ObjectIdentifier);
        sha256_n24_w4 = new LMOtsParameters(7, 24, 4, 51, 4, 1500, aSN1ObjectIdentifier);
        sha256_n24_w8 = new LMOtsParameters(8, 24, 8, 26, 0, 1020, aSN1ObjectIdentifier);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_shake256_len;
        shake256_n32_w1 = new LMOtsParameters(9, 32, 1, 265, 7, 8516, aSN1ObjectIdentifier2);
        shake256_n32_w2 = new LMOtsParameters(10, 32, 2, 133, 6, 4292, aSN1ObjectIdentifier2);
        shake256_n32_w4 = new LMOtsParameters(11, 32, 4, 67, 4, 2180, aSN1ObjectIdentifier2);
        shake256_n32_w8 = new LMOtsParameters(12, 32, 8, 34, 0, 1124, aSN1ObjectIdentifier2);
        shake256_n24_w1 = new LMOtsParameters(13, 24, 1, DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE, 8, 5436, aSN1ObjectIdentifier2);
        shake256_n24_w2 = new LMOtsParameters(14, 24, 2, 101, 6, 2940, aSN1ObjectIdentifier2);
        shake256_n24_w4 = new LMOtsParameters(15, 24, 4, 51, 4, 1500, aSN1ObjectIdentifier2);
        shake256_n24_w8 = new LMOtsParameters(16, 24, 8, 26, 0, 1020, aSN1ObjectIdentifier2);
        suppliers = new HashMap<Object, LMOtsParameters>() { // from class: org.bouncycastle.pqc.crypto.lms.LMOtsParameters.1
            {
                LMOtsParameters lMOtsParameters = LMOtsParameters.sha256_n32_w1;
                put(Integer.valueOf(lMOtsParameters.f23230type), lMOtsParameters);
                LMOtsParameters lMOtsParameters2 = LMOtsParameters.sha256_n32_w2;
                put(Integer.valueOf(lMOtsParameters2.f23230type), lMOtsParameters2);
                LMOtsParameters lMOtsParameters3 = LMOtsParameters.sha256_n32_w4;
                put(Integer.valueOf(lMOtsParameters3.f23230type), lMOtsParameters3);
                LMOtsParameters lMOtsParameters4 = LMOtsParameters.sha256_n32_w8;
                put(Integer.valueOf(lMOtsParameters4.f23230type), lMOtsParameters4);
                LMOtsParameters lMOtsParameters5 = LMOtsParameters.sha256_n24_w1;
                put(Integer.valueOf(lMOtsParameters5.f23230type), lMOtsParameters5);
                LMOtsParameters lMOtsParameters6 = LMOtsParameters.sha256_n24_w2;
                put(Integer.valueOf(lMOtsParameters6.f23230type), lMOtsParameters6);
                LMOtsParameters lMOtsParameters7 = LMOtsParameters.sha256_n24_w4;
                put(Integer.valueOf(lMOtsParameters7.f23230type), lMOtsParameters7);
                LMOtsParameters lMOtsParameters8 = LMOtsParameters.sha256_n24_w8;
                put(Integer.valueOf(lMOtsParameters8.f23230type), lMOtsParameters8);
                LMOtsParameters lMOtsParameters9 = LMOtsParameters.shake256_n32_w1;
                put(Integer.valueOf(lMOtsParameters9.f23230type), lMOtsParameters9);
                LMOtsParameters lMOtsParameters10 = LMOtsParameters.shake256_n32_w2;
                put(Integer.valueOf(lMOtsParameters10.f23230type), lMOtsParameters10);
                LMOtsParameters lMOtsParameters11 = LMOtsParameters.shake256_n32_w4;
                put(Integer.valueOf(lMOtsParameters11.f23230type), lMOtsParameters11);
                LMOtsParameters lMOtsParameters12 = LMOtsParameters.shake256_n32_w8;
                put(Integer.valueOf(lMOtsParameters12.f23230type), lMOtsParameters12);
                LMOtsParameters lMOtsParameters13 = LMOtsParameters.shake256_n24_w1;
                put(Integer.valueOf(lMOtsParameters13.f23230type), lMOtsParameters13);
                LMOtsParameters lMOtsParameters14 = LMOtsParameters.shake256_n24_w2;
                put(Integer.valueOf(lMOtsParameters14.f23230type), lMOtsParameters14);
                LMOtsParameters lMOtsParameters15 = LMOtsParameters.shake256_n24_w4;
                put(Integer.valueOf(lMOtsParameters15.f23230type), lMOtsParameters15);
                LMOtsParameters lMOtsParameters16 = LMOtsParameters.shake256_n24_w8;
                put(Integer.valueOf(lMOtsParameters16.f23230type), lMOtsParameters16);
            }
        };
    }

    public LMOtsParameters(int i, int i2, int i3, int i4, int i5, int i6, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.f23230type = i;
        this.f23227n = i2;
        this.f23231w = i3;
        this.f23228p = i4;
        this.f23226ls = i5;
        this.f23229sigLen = i6;
        this.digestOID = aSN1ObjectIdentifier;
    }

    public static LMOtsParameters getParametersForType(int i) {
        return suppliers.get(Integer.valueOf(i));
    }

    public ASN1ObjectIdentifier getDigestOID() {
        return this.digestOID;
    }

    /* renamed from: getLs */
    public int m17621getLs() {
        return this.f23226ls;
    }

    /* renamed from: getN */
    public int m17622getN() {
        return this.f23227n;
    }

    /* renamed from: getP */
    public int m17623getP() {
        return this.f23228p;
    }

    public int getSigLen() {
        return this.f23229sigLen;
    }

    /* renamed from: getType */
    public int m17624getType() {
        return this.f23230type;
    }

    /* renamed from: getW */
    public int m17625getW() {
        return this.f23231w;
    }
}
