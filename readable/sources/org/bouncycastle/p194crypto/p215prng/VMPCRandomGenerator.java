package org.bouncycastle.p194crypto.p215prng;

import org.bouncycastle.p194crypto.p217signers.PSSSigner;
import org.bouncycastle.p361util.AbstractC6245Pack;
import p094kotlin.C1126UByte;
import p094kotlin.p101io.encoding.C1217Base64;
import p094kotlin.p105jvm.internal.ByteCompanionObject;
import p132okio.C5066Utf8;

/* loaded from: classes2.dex */
public class VMPCRandomGenerator implements RandomGenerator {

    /* renamed from: n */
    private byte f20890n = 0;

    /* renamed from: P */
    private byte[] f20889P = {-69, 44, 98, ByteCompanionObject.MAX_VALUE, -75, -86, -44, 13, -127, -2, -78, -126, -53, -96, -95, 8, 24, 113, 86, -24, 73, 2, 16, -60, -34, 53, -91, -20, ByteCompanionObject.MIN_VALUE, 18, -72, 105, -38, 47, 117, -52, -94, 9, 54, 3, 97, 45, -3, -32, -35, 5, 67, -112, -83, -56, -31, -81, 87, -101, 76, -40, 81, -82, 80, -123, 60, 10, -28, -13, -100, 38, 35, 83, -55, -125, -105, 70, -79, -103, 100, 49, 119, -43, 29, -42, 120, -67, 94, -80, -118, 34, 56, -8, 104, 43, 42, -59, -45, -9, PSSSigner.TRAILER_IMPLICIT, 111, -33, 4, -27, -107, 62, 37, -122, -90, 11, -113, -15, 36, 14, -41, 64, -77, -49, 126, 6, 21, -102, 77, 28, -93, -37, 50, -110, 88, 17, 39, -12, 89, -48, 78, 106, 23, 91, -84, -1, 7, -64, 101, 121, -4, -57, -51, 118, 66, 93, -25, 58, 52, 122, 48, 40, 15, 115, 1, -7, -47, -46, 25, -23, -111, -71, 90, -19, 65, 109, -76, -61, -98, -65, 99, -6, 31, 51, 96, 71, -119, -16, -106, 26, 95, -109, C1217Base64.padSymbol, 55, 75, -39, -88, -63, 27, -10, 57, -117, -73, 12, 32, -50, -120, 110, -74, 116, -114, -115, 22, 41, -14, -121, -11, -21, 112, -29, -5, 85, -97, -58, 68, 74, 69, 125, -30, 107, 92, 108, 102, -87, -116, -18, -124, 19, -89, 30, -99, -36, 103, 72, -70, 46, -26, -92, -85, 124, -108, 0, 33, -17, -22, -66, -54, 114, 79, 82, -104, C5066Utf8.REPLACEMENT_BYTE, -62, 20, 123, 59, 84};

    /* renamed from: s */
    private byte f20891s = -66;

    @Override // org.bouncycastle.p194crypto.p215prng.RandomGenerator
    public void addSeedMaterial(long j) {
        addSeedMaterial(AbstractC6245Pack.longToBigEndian(j));
    }

    @Override // org.bouncycastle.p194crypto.p215prng.RandomGenerator
    public void nextBytes(byte[] bArr) {
        nextBytes(bArr, 0, bArr.length);
    }

    @Override // org.bouncycastle.p194crypto.p215prng.RandomGenerator
    public void addSeedMaterial(byte[] bArr) {
        for (byte b : bArr) {
            byte[] bArr2 = this.f20889P;
            byte b2 = this.f20891s;
            byte b3 = this.f20890n;
            byte b4 = bArr2[(b2 + bArr2[b3 & C1126UByte.MAX_VALUE] + b) & 255];
            this.f20891s = b4;
            byte b5 = bArr2[b3 & C1126UByte.MAX_VALUE];
            bArr2[b3 & C1126UByte.MAX_VALUE] = bArr2[b4 & C1126UByte.MAX_VALUE];
            bArr2[b4 & C1126UByte.MAX_VALUE] = b5;
            this.f20890n = (byte) ((b3 + 1) & 255);
        }
    }

    @Override // org.bouncycastle.p194crypto.p215prng.RandomGenerator
    public void nextBytes(byte[] bArr, int i, int i2) {
        synchronized (this.f20889P) {
            int i3 = i2 + i;
            while (i != i3) {
                try {
                    byte[] bArr2 = this.f20889P;
                    byte b = this.f20891s;
                    byte b2 = this.f20890n;
                    byte b3 = bArr2[(b + bArr2[b2 & C1126UByte.MAX_VALUE]) & 255];
                    this.f20891s = b3;
                    bArr[i] = bArr2[(bArr2[bArr2[b3 & C1126UByte.MAX_VALUE] & C1126UByte.MAX_VALUE] + 1) & 255];
                    byte b4 = bArr2[b2 & C1126UByte.MAX_VALUE];
                    bArr2[b2 & C1126UByte.MAX_VALUE] = bArr2[b3 & C1126UByte.MAX_VALUE];
                    bArr2[b3 & C1126UByte.MAX_VALUE] = b4;
                    this.f20890n = (byte) ((b2 + 1) & 255);
                    i++;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
