package org.bouncycastle.p194crypto.p221util;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public final class DERMacData {

    /* renamed from: macData */
    private final byte[] f21113macData;

    /* renamed from: org.bouncycastle.crypto.util.DERMacData$Builder */
    public static final class C5400Builder {
        private ASN1OctetString ephemDataU;
        private ASN1OctetString ephemDataV;

        /* renamed from: idU */
        private ASN1OctetString f21114idU;

        /* renamed from: idV */
        private ASN1OctetString f21115idV;

        /* renamed from: text */
        private byte[] f21116text;

        /* renamed from: type */
        private final EnumC5401Type f21117type;

        public C5400Builder(EnumC5401Type enumC5401Type, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
            this.f21117type = enumC5401Type;
            this.f21114idU = C5404DerUtil.getOctetString(bArr);
            this.f21115idV = C5404DerUtil.getOctetString(bArr2);
            this.ephemDataU = C5404DerUtil.getOctetString(bArr3);
            this.ephemDataV = C5404DerUtil.getOctetString(bArr4);
        }

        private byte[] concatenate(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6) {
            return C6238Arrays.concatenate(C6238Arrays.concatenate(bArr, bArr2, bArr3), C6238Arrays.concatenate(bArr4, bArr5, bArr6));
        }

        /* renamed from: build */
        public DERMacData m15920build() {
            int iOrdinal = this.f21117type.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        if (iOrdinal != 3) {
                            throw new IllegalStateException("Unknown type encountered in build");
                        }
                    }
                }
                return new DERMacData(concatenate(this.f21117type.getHeader(), C5404DerUtil.toByteArray(this.f21115idV), C5404DerUtil.toByteArray(this.f21114idU), C5404DerUtil.toByteArray(this.ephemDataV), C5404DerUtil.toByteArray(this.ephemDataU), this.f21116text));
            }
            return new DERMacData(concatenate(this.f21117type.getHeader(), C5404DerUtil.toByteArray(this.f21114idU), C5404DerUtil.toByteArray(this.f21115idV), C5404DerUtil.toByteArray(this.ephemDataU), C5404DerUtil.toByteArray(this.ephemDataV), this.f21116text));
        }

        public C5400Builder withText(byte[] bArr) {
            this.f21116text = C5404DerUtil.toByteArray(new DERTaggedObject(false, 0, (ASN1Encodable) C5404DerUtil.getOctetString(bArr)));
            return this;
        }
    }

    /* renamed from: org.bouncycastle.crypto.util.DERMacData$Type */
    public enum EnumC5401Type {
        UNILATERALU("KC_1_U"),
        UNILATERALV("KC_1_V"),
        BILATERALU("KC_2_U"),
        BILATERALV("KC_2_V");


        /* renamed from: enc */
        private final String f21119enc;

        EnumC5401Type(String str) {
            this.f21119enc = str;
        }

        public byte[] getHeader() {
            return C6250Strings.toByteArray(this.f21119enc);
        }
    }

    private DERMacData(byte[] bArr) {
        this.f21113macData = bArr;
    }

    public byte[] getMacData() {
        return C6238Arrays.m18231clone(this.f21113macData);
    }
}
