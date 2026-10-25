package org.bouncycastle.p194crypto.p201engines;

import java.lang.reflect.Array;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.p199digests.RomulusDigest;
import org.bouncycastle.p194crypto.p201engines.AEADBaseEngine;
import org.bouncycastle.p194crypto.p217signers.PSSSigner;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6240Bytes;
import p094kotlin.C1126UByte;
import p094kotlin.p101io.encoding.C1217Base64;
import p094kotlin.p105jvm.internal.ByteCompanionObject;
import p132okio.C5066Utf8;

/* loaded from: classes2.dex */
public class RomulusEngine extends AEADBaseEngine {
    private static final int AD_BLK_LEN_HALF = 16;

    /* renamed from: CNT */
    private final byte[] f20038CNT;
    private Instance instance;

    /* renamed from: k */
    private byte[] f20039k;

    /* renamed from: npub */
    private byte[] f20040npub;

    /* renamed from: sbox_8 */
    private static final byte[] f20037sbox_8 = {101, 76, 106, 66, 75, 99, 67, 107, 85, 117, 90, 122, 83, 115, 91, 123, 53, -116, 58, -127, -119, 51, ByteCompanionObject.MIN_VALUE, 59, -107, 37, -104, 42, -112, 35, -103, 43, -27, -52, -24, -63, -55, -32, -64, -23, -43, -11, -40, -8, -48, -16, -39, -7, -91, 28, -88, 18, 27, -96, 19, -87, 5, -75, 10, -72, 3, -80, 11, -71, 50, -120, 60, -123, -115, 52, -124, C1217Base64.padSymbol, -111, 34, -100, 44, -108, 36, -99, 45, 98, 74, 108, 69, 77, 100, 68, 109, 82, 114, 92, 124, 84, 116, 93, 125, -95, 26, -84, 21, 29, -92, 20, -83, 2, -79, 12, PSSSigner.TRAILER_IMPLICIT, 4, -76, 13, -67, -31, -56, -20, -59, -51, -28, -60, -19, -47, -15, -36, -4, -44, -12, -35, -3, 54, -114, 56, -126, -117, 48, -125, 57, -106, 38, -102, 40, -109, 32, -101, 41, 102, 78, 104, 65, 73, 96, 64, 105, 86, 118, 88, 120, 80, 112, 89, 121, -90, 30, -86, 17, 25, -93, 16, -85, 6, -74, 8, -70, 0, -77, 9, -69, -26, -50, -22, -62, -53, -29, -61, -21, -42, -10, -38, -6, -45, -13, -37, -5, 49, -118, 62, -122, -113, 55, -121, C5066Utf8.REPLACEMENT_BYTE, -110, 33, -98, 46, -105, 39, -97, 47, 97, 72, 110, 70, 79, 103, 71, 111, 81, 113, 94, 126, 87, 119, 95, ByteCompanionObject.MAX_VALUE, -94, 24, -82, 22, 31, -89, 23, -81, 1, -78, 14, -66, 7, -73, 15, -65, -30, -54, -18, -58, -49, -25, -57, -17, -46, -14, -34, -2, -41, -9, -33, -1};
    private static final byte[] TWEAKEY_P = {9, 15, 8, 13, 10, 14, 12, 11, 0, 1, 2, 3, 4, 5, 6, 7};

    /* renamed from: RC */
    private static final byte[] f20036RC = {1, 3, 7, 15, 31, 62, C1217Base64.padSymbol, 59, 55, 47, 30, 60, 57, 51, 39, 14, 29, 58, 53, 43, 22, 44, 24, 48, 33, 2, 5, 11, 23, 46, 28, 56, 49, 35, 6, 13, 27, 54, 45, 26};

    public interface Instance {
        void processBufferAAD(byte[] bArr, int i);

        void processBufferDecrypt(byte[] bArr, int i, byte[] bArr2, int i2);

        void processBufferEncrypt(byte[] bArr, int i, byte[] bArr2, int i2);

        void processFinalAAD();

        void processFinalBlock(byte[] bArr, int i);

        /* renamed from: reset */
        void mo15388reset();
    }

    public class RomulusM implements Instance {

        /* renamed from: offset */
        private int f20043offset;

        /* renamed from: mac_s */
        private final byte[] f20042mac_s = new byte[16];

        /* renamed from: mac_CNT */
        private final byte[] f20041mac_CNT = new byte[7];

        /* renamed from: s */
        private final byte[] f20044s = new byte[16];

        /* renamed from: twist */
        private boolean f20046twist = true;

        public RomulusM() {
        }

        public int ad_encryption(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2, byte[] bArr4) {
            byte[] bArr5 = new byte[16];
            byte[] bArr6 = new byte[16];
            int iMin = Math.min(i2, 16);
            int i3 = i2 - iMin;
            RomulusEngine.this.m15386pad(bArr, i, bArr6, 16, iMin);
            C6240Bytes.m18281xorTo(16, bArr6, bArr2);
            int i4 = i + iMin;
            this.f20043offset = i4;
            RomulusEngine.this.lfsr_gf56(bArr4);
            if (i3 == 0) {
                return i3;
            }
            int iMin2 = Math.min(i3, 16);
            int i5 = i3 - iMin2;
            RomulusEngine.this.m15386pad(bArr, i4, bArr5, 16, iMin2);
            this.f20043offset = i4 + iMin2;
            RomulusEngine.this.block_cipher(bArr2, bArr3, bArr5, 0, bArr4, (byte) 44);
            RomulusEngine.this.lfsr_gf56(bArr4);
            return i5;
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferAAD(byte[] bArr, int i) {
            if (this.f20046twist) {
                C6240Bytes.m18279xorTo(RomulusEngine.this.MAC_SIZE, bArr, i, this.f20042mac_s);
            } else {
                RomulusEngine romulusEngine = RomulusEngine.this;
                romulusEngine.block_cipher(this.f20042mac_s, romulusEngine.f20039k, bArr, i, this.f20041mac_CNT, (byte) 40);
            }
            this.f20046twist = !this.f20046twist;
            RomulusEngine.this.lfsr_gf56(this.f20041mac_CNT);
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferDecrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferEncrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processFinalAAD() {
            if (RomulusEngine.this.aadOperator.mo15230getLen() == 0) {
                RomulusEngine.this.lfsr_gf56(this.f20041mac_CNT);
            } else {
                RomulusEngine romulusEngine = RomulusEngine.this;
                int i = romulusEngine.m_aadPos;
                if (i != 0) {
                    C6238Arrays.m18250fill(romulusEngine.f19651m_aad, i, romulusEngine.BlockSize - 1, (byte) 0);
                    RomulusEngine romulusEngine2 = RomulusEngine.this;
                    byte[] bArr = romulusEngine2.f19651m_aad;
                    int i2 = romulusEngine2.BlockSize;
                    bArr[i2 - 1] = (byte) (romulusEngine2.m_aadPos & 15);
                    if (this.f20046twist) {
                        C6240Bytes.m18281xorTo(i2, bArr, this.f20042mac_s);
                    } else {
                        romulusEngine2.block_cipher(this.f20042mac_s, romulusEngine2.f20039k, RomulusEngine.this.f19651m_aad, 0, this.f20041mac_CNT, (byte) 40);
                    }
                    RomulusEngine.this.lfsr_gf56(this.f20041mac_CNT);
                }
            }
            RomulusEngine romulusEngine3 = RomulusEngine.this;
            romulusEngine3.m_aadPos = 0;
            romulusEngine3.m_bufPos = romulusEngine3.dataOperator.mo15232getLen();
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0105  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0175  */
        /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void processFinalBlock(byte[] bArr, int i) {
            byte b;
            int i2;
            int i3;
            int i4;
            RomulusEngine romulusEngine;
            int i5;
            int i6;
            RomulusEngine romulusEngine2;
            int i7;
            int iAd_encryption;
            int iAd_encryption2;
            int i8;
            int iMo15230getLen = RomulusEngine.this.aadOperator.mo15230getLen();
            int iMo15232getLen = RomulusEngine.this.dataOperator.mo15232getLen();
            RomulusEngine romulusEngine3 = RomulusEngine.this;
            int i9 = iMo15232getLen - (romulusEngine3.forEncryption ? 0 : romulusEngine3.MAC_SIZE);
            byte[] bytes = ((AEADBaseEngine.StreamDataOperator) romulusEngine3.dataOperator).getBytes();
            int i10 = iMo15230getLen & 31;
            int i11 = 16;
            if (i10 == 0 && iMo15230getLen != 0) {
                i2 = 56;
            } else if (i10 < 16) {
                i2 = 50;
            } else if (i10 != 16) {
                i2 = 58;
            } else {
                b = 48;
                i3 = i9 & 31;
                if (i3 != 0 && i9 != 0) {
                    i4 = b ^ 4;
                } else {
                    if (i3 < 16) {
                        if (i3 != 16) {
                            i4 = b ^ 5;
                        }
                        byte b2 = b;
                        romulusEngine = RomulusEngine.this;
                        int i12 = 0;
                        if (romulusEngine.forEncryption) {
                            if ((b2 & 8) == 0) {
                                byte[] bArr2 = new byte[16];
                                int iMin = Math.min(i9, 16);
                                RomulusEngine.this.m15386pad(bytes, 0, bArr2, 16, iMin);
                                RomulusEngine romulusEngine4 = RomulusEngine.this;
                                romulusEngine4.block_cipher(this.f20042mac_s, romulusEngine4.f20039k, bArr2, 0, this.f20041mac_CNT, (byte) 44);
                                RomulusEngine.this.lfsr_gf56(this.f20041mac_CNT);
                                iAd_encryption2 = i9 - iMin;
                                i8 = iMin;
                            } else {
                                if (i9 == 0) {
                                    romulusEngine.lfsr_gf56(this.f20041mac_CNT);
                                }
                                iAd_encryption2 = i9;
                                i8 = 0;
                            }
                            while (iAd_encryption2 > 0) {
                                this.f20043offset = i8;
                                iAd_encryption2 = ad_encryption(bytes, i8, this.f20042mac_s, RomulusEngine.this.f20039k, iAd_encryption2, this.f20041mac_CNT);
                                i8 = this.f20043offset;
                                bytes = bytes;
                                i11 = i11;
                            }
                            RomulusEngine romulusEngine5 = RomulusEngine.this;
                            i5 = i11;
                            romulusEngine5.block_cipher(this.f20042mac_s, romulusEngine5.f20039k, RomulusEngine.this.f20040npub, 0, this.f20041mac_CNT, b2);
                            RomulusEngine romulusEngine6 = RomulusEngine.this;
                            romulusEngine6.m15385g8A(this.f20042mac_s, romulusEngine6.f19654mac, 0);
                            i12 = i8 - i9;
                            i6 = iAd_encryption2;
                        } else {
                            i5 = 16;
                            System.arraycopy(bytes, i9, romulusEngine.f19654mac, 0, romulusEngine.MAC_SIZE);
                            i6 = i9;
                        }
                        RomulusEngine romulusEngine7 = RomulusEngine.this;
                        romulusEngine7.reset_lfsr_gf56(romulusEngine7.f20038CNT);
                        System.arraycopy(RomulusEngine.this.f19654mac, 0, this.f20044s, 0, i5);
                        if (i9 > 0) {
                            RomulusEngine romulusEngine8 = RomulusEngine.this;
                            romulusEngine8.block_cipher(this.f20044s, romulusEngine8.f20039k, RomulusEngine.this.f20040npub, 0, RomulusEngine.this.f20038CNT, (byte) 36);
                            int i13 = i;
                            int i14 = i12;
                            while (i9 > i5) {
                                i9 -= 16;
                                RomulusEngine.this.m15387rho(bytes, i14, bArr, i13, this.f20044s, 16);
                                i13 += 16;
                                i14 += 16;
                                RomulusEngine romulusEngine9 = RomulusEngine.this;
                                romulusEngine9.lfsr_gf56(romulusEngine9.f20038CNT);
                                RomulusEngine romulusEngine10 = RomulusEngine.this;
                                romulusEngine10.block_cipher(this.f20044s, romulusEngine10.f20039k, RomulusEngine.this.f20040npub, 0, RomulusEngine.this.f20038CNT, (byte) 36);
                            }
                            RomulusEngine.this.m15387rho(bytes, i14, bArr, i13, this.f20044s, i9);
                        }
                        romulusEngine2 = RomulusEngine.this;
                        if (romulusEngine2.forEncryption) {
                            return;
                        }
                        if ((b2 & 8) == 0) {
                            byte[] bArr3 = new byte[i5];
                            int iMin2 = Math.min(i6, i5);
                            RomulusEngine.this.m15386pad(bArr, i, bArr3, 16, iMin2);
                            RomulusEngine romulusEngine11 = RomulusEngine.this;
                            romulusEngine11.block_cipher(this.f20042mac_s, romulusEngine11.f20039k, bArr3, 0, this.f20041mac_CNT, (byte) 44);
                            RomulusEngine.this.lfsr_gf56(this.f20041mac_CNT);
                            iAd_encryption = i6 - iMin2;
                            i7 = i + iMin2;
                        } else {
                            if (i9 == 0) {
                                romulusEngine2.lfsr_gf56(this.f20041mac_CNT);
                            }
                            i7 = i;
                            iAd_encryption = i6;
                        }
                        while (iAd_encryption > 0) {
                            this.f20043offset = i7;
                            iAd_encryption = ad_encryption(bArr, i7, this.f20042mac_s, RomulusEngine.this.f20039k, iAd_encryption, this.f20041mac_CNT);
                            i7 = this.f20043offset;
                            bytes = bytes;
                        }
                        RomulusEngine romulusEngine12 = RomulusEngine.this;
                        romulusEngine12.block_cipher(this.f20042mac_s, romulusEngine12.f20039k, RomulusEngine.this.f20040npub, 0, this.f20041mac_CNT, b2);
                        RomulusEngine romulusEngine13 = RomulusEngine.this;
                        romulusEngine13.m15385g8A(this.f20042mac_s, romulusEngine13.f19654mac, 0);
                        int iMo15232getLen2 = RomulusEngine.this.dataOperator.mo15232getLen();
                        RomulusEngine romulusEngine14 = RomulusEngine.this;
                        int i15 = romulusEngine14.MAC_SIZE;
                        System.arraycopy(bytes, iMo15232getLen2 - i15, romulusEngine14.f19652m_buf, 0, i15);
                        RomulusEngine.this.m_bufPos = 0;
                        return;
                    }
                    i4 = b ^ 1;
                }
                b = (byte) i4;
                byte b22 = b;
                romulusEngine = RomulusEngine.this;
                int i122 = 0;
                if (romulusEngine.forEncryption) {
                }
                RomulusEngine romulusEngine72 = RomulusEngine.this;
                romulusEngine72.reset_lfsr_gf56(romulusEngine72.f20038CNT);
                System.arraycopy(RomulusEngine.this.f19654mac, 0, this.f20044s, 0, i5);
                if (i9 > 0) {
                }
                romulusEngine2 = RomulusEngine.this;
                if (romulusEngine2.forEncryption) {
                }
            }
            b = (byte) i2;
            i3 = i9 & 31;
            if (i3 != 0) {
                if (i3 < 16) {
                }
                b = (byte) i4;
            }
            byte b222 = b;
            romulusEngine = RomulusEngine.this;
            int i1222 = 0;
            if (romulusEngine.forEncryption) {
            }
            RomulusEngine romulusEngine722 = RomulusEngine.this;
            romulusEngine722.reset_lfsr_gf56(romulusEngine722.f20038CNT);
            System.arraycopy(RomulusEngine.this.f19654mac, 0, this.f20044s, 0, i5);
            if (i9 > 0) {
            }
            romulusEngine2 = RomulusEngine.this;
            if (romulusEngine2.forEncryption) {
            }
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        /* renamed from: reset */
        public void mo15388reset() {
            C6238Arrays.m18227clear(this.f20044s);
            C6238Arrays.m18227clear(this.f20042mac_s);
            RomulusEngine.this.reset_lfsr_gf56(this.f20041mac_CNT);
            RomulusEngine romulusEngine = RomulusEngine.this;
            romulusEngine.reset_lfsr_gf56(romulusEngine.f20038CNT);
            this.f20046twist = true;
        }
    }

    public class RomulusN implements Instance {

        /* renamed from: s */
        private final byte[] f20047s = new byte[16];

        /* renamed from: twist */
        boolean f20049twist;

        public RomulusN() {
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferAAD(byte[] bArr, int i) {
            if (this.f20049twist) {
                C6240Bytes.m18279xorTo(16, bArr, i, this.f20047s);
            } else {
                RomulusEngine romulusEngine = RomulusEngine.this;
                romulusEngine.block_cipher(this.f20047s, romulusEngine.f20039k, bArr, i, RomulusEngine.this.f20038CNT, (byte) 8);
            }
            RomulusEngine romulusEngine2 = RomulusEngine.this;
            romulusEngine2.lfsr_gf56(romulusEngine2.f20038CNT);
            this.f20049twist = !this.f20049twist;
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferDecrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
            RomulusEngine.this.m15385g8A(this.f20047s, bArr2, i2);
            for (int i3 = 0; i3 < 16; i3++) {
                int i4 = i3 + i2;
                byte b = (byte) (bArr2[i4] ^ bArr[i3 + i]);
                bArr2[i4] = b;
                byte[] bArr3 = this.f20047s;
                bArr3[i3] = (byte) (b ^ bArr3[i3]);
            }
            RomulusEngine romulusEngine = RomulusEngine.this;
            romulusEngine.lfsr_gf56(romulusEngine.f20038CNT);
            RomulusEngine romulusEngine2 = RomulusEngine.this;
            romulusEngine2.block_cipher(this.f20047s, romulusEngine2.f20039k, RomulusEngine.this.f20040npub, 0, RomulusEngine.this.f20038CNT, (byte) 4);
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferEncrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
            RomulusEngine.this.m15385g8A(this.f20047s, bArr2, i2);
            for (int i3 = 0; i3 < 16; i3++) {
                byte[] bArr3 = this.f20047s;
                int i4 = i3 + i;
                bArr3[i3] = (byte) (bArr3[i3] ^ bArr[i4]);
                int i5 = i3 + i2;
                bArr2[i5] = (byte) (bArr2[i5] ^ bArr[i4]);
            }
            RomulusEngine romulusEngine = RomulusEngine.this;
            romulusEngine.lfsr_gf56(romulusEngine.f20038CNT);
            RomulusEngine romulusEngine2 = RomulusEngine.this;
            romulusEngine2.block_cipher(this.f20047s, romulusEngine2.f20039k, RomulusEngine.this.f20040npub, 0, RomulusEngine.this.f20038CNT, (byte) 4);
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processFinalAAD() {
            int i = RomulusEngine.this.m_aadPos;
            if (i != 0) {
                byte[] bArr = new byte[16];
                int iMin = Math.min(i, 16);
                RomulusEngine romulusEngine = RomulusEngine.this;
                romulusEngine.m15386pad(romulusEngine.f19651m_aad, 0, bArr, 16, iMin);
                if (this.f20049twist) {
                    C6240Bytes.m18281xorTo(16, bArr, this.f20047s);
                } else {
                    RomulusEngine romulusEngine2 = RomulusEngine.this;
                    romulusEngine2.block_cipher(this.f20047s, romulusEngine2.f20039k, bArr, 0, RomulusEngine.this.f20038CNT, (byte) 8);
                }
                RomulusEngine romulusEngine3 = RomulusEngine.this;
                romulusEngine3.lfsr_gf56(romulusEngine3.f20038CNT);
            }
            if (RomulusEngine.this.aadOperator.mo15230getLen() == 0) {
                RomulusEngine romulusEngine4 = RomulusEngine.this;
                romulusEngine4.lfsr_gf56(romulusEngine4.f20038CNT);
                RomulusEngine romulusEngine5 = RomulusEngine.this;
                romulusEngine5.block_cipher(this.f20047s, romulusEngine5.f20039k, RomulusEngine.this.f20040npub, 0, RomulusEngine.this.f20038CNT, (byte) 26);
            } else {
                RomulusEngine romulusEngine6 = RomulusEngine.this;
                int i2 = romulusEngine6.m_aadPos & 15;
                byte[] bArr2 = this.f20047s;
                byte[] bArr3 = romulusEngine6.f20039k;
                if (i2 != 0) {
                    romulusEngine6.block_cipher(bArr2, bArr3, RomulusEngine.this.f20040npub, 0, RomulusEngine.this.f20038CNT, (byte) 26);
                } else {
                    romulusEngine6.block_cipher(bArr2, bArr3, RomulusEngine.this.f20040npub, 0, RomulusEngine.this.f20038CNT, (byte) 24);
                }
            }
            RomulusEngine romulusEngine7 = RomulusEngine.this;
            romulusEngine7.reset_lfsr_gf56(romulusEngine7.f20038CNT);
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processFinalBlock(byte[] bArr, int i) {
            int iMo15232getLen = RomulusEngine.this.dataOperator.mo15232getLen();
            RomulusEngine romulusEngine = RomulusEngine.this;
            if (iMo15232getLen - (romulusEngine.forEncryption ? 0 : romulusEngine.MAC_SIZE) == 0) {
                romulusEngine.lfsr_gf56(romulusEngine.f20038CNT);
                RomulusEngine romulusEngine2 = RomulusEngine.this;
                romulusEngine2.block_cipher(this.f20047s, romulusEngine2.f20039k, RomulusEngine.this.f20040npub, 0, RomulusEngine.this.f20038CNT, (byte) 21);
            } else {
                int i2 = romulusEngine.m_bufPos;
                if (i2 != 0) {
                    int iMin = Math.min(i2, 16);
                    RomulusEngine romulusEngine3 = RomulusEngine.this;
                    romulusEngine3.m15387rho(romulusEngine3.f19652m_buf, 0, bArr, i, this.f20047s, iMin);
                    RomulusEngine romulusEngine4 = RomulusEngine.this;
                    romulusEngine4.lfsr_gf56(romulusEngine4.f20038CNT);
                    RomulusEngine romulusEngine5 = RomulusEngine.this;
                    romulusEngine5.block_cipher(this.f20047s, romulusEngine5.f20039k, RomulusEngine.this.f20040npub, 0, RomulusEngine.this.f20038CNT, RomulusEngine.this.m_bufPos == 16 ? (byte) 20 : (byte) 21);
                }
            }
            RomulusEngine romulusEngine6 = RomulusEngine.this;
            romulusEngine6.m15385g8A(this.f20047s, romulusEngine6.f19654mac, 0);
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        /* renamed from: reset */
        public void mo15388reset() {
            C6238Arrays.m18227clear(this.f20047s);
            RomulusEngine romulusEngine = RomulusEngine.this;
            romulusEngine.reset_lfsr_gf56(romulusEngine.f20038CNT);
            this.f20049twist = true;
        }
    }

    public static class RomulusParameters {
        public static final int ROMULUS_M = 0;
        public static final int ROMULUS_N = 1;
        public static final int ROMULUS_T = 2;
        public static final RomulusParameters RomulusM = new RomulusParameters(0);
        public static final RomulusParameters RomulusN = new RomulusParameters(1);
        public static final RomulusParameters RomulusT = new RomulusParameters(2);

        /* renamed from: ord */
        private final int f20050ord;

        public RomulusParameters(int i) {
            this.f20050ord = i;
        }
    }

    public class RomulusT implements Instance {

        /* renamed from: CNT_Z */
        byte[] f20051CNT_Z;

        /* renamed from: LR */
        byte[] f20052LR;

        /* renamed from: S */
        byte[] f20053S;

        /* renamed from: T */
        byte[] f20054T;

        /* renamed from: Z */
        byte[] f20055Z;

        /* renamed from: g */
        private final byte[] f20056g;

        /* renamed from: h */
        private final byte[] f20057h;

        private RomulusT() {
            this.f20057h = new byte[16];
            this.f20056g = new byte[16];
            this.f20055Z = new byte[16];
            this.f20051CNT_Z = new byte[7];
            this.f20052LR = new byte[32];
            this.f20054T = new byte[16];
            this.f20053S = new byte[16];
        }

        private void processAfterAbsorbCiphertext() {
            RomulusEngine romulusEngine = RomulusEngine.this;
            int i = romulusEngine.m_aadPos;
            int i2 = romulusEngine.BlockSize;
            if (i == i2) {
                RomulusEngine.hirose_128_128_256(this.f20057h, this.f20056g, romulusEngine.f19651m_aad, 0);
                RomulusEngine.this.m_aadPos = 0;
            } else {
                romulusEngine.m_aadPos = i2;
            }
            RomulusEngine.this.lfsr_gf56(this.f20051CNT_Z);
        }

        private void processBuffer(byte[] bArr, int i, byte[] bArr2, int i2) {
            System.arraycopy(RomulusEngine.this.f20040npub, 0, this.f20053S, 0, 16);
            RomulusEngine romulusEngine = RomulusEngine.this;
            romulusEngine.block_cipher(this.f20053S, this.f20055Z, this.f20054T, 0, romulusEngine.f20038CNT, (byte) 64);
            C6240Bytes.m18276xor(16, this.f20053S, bArr, i, bArr2, i2);
            System.arraycopy(RomulusEngine.this.f20040npub, 0, this.f20053S, 0, 16);
            RomulusEngine romulusEngine2 = RomulusEngine.this;
            romulusEngine2.block_cipher(this.f20053S, this.f20055Z, this.f20054T, 0, romulusEngine2.f20038CNT, (byte) 65);
            System.arraycopy(this.f20053S, 0, this.f20055Z, 0, 16);
            RomulusEngine romulusEngine3 = RomulusEngine.this;
            romulusEngine3.lfsr_gf56(romulusEngine3.f20038CNT);
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferAAD(byte[] bArr, int i) {
            RomulusEngine.hirose_128_128_256(this.f20057h, this.f20056g, bArr, i);
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferDecrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
            processBuffer(bArr, i, bArr2, i2);
            RomulusEngine romulusEngine = RomulusEngine.this;
            System.arraycopy(bArr, i, romulusEngine.f19651m_aad, romulusEngine.m_aadPos, romulusEngine.BlockSize);
            processAfterAbsorbCiphertext();
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processBufferEncrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
            processBuffer(bArr, i, bArr2, i2);
            RomulusEngine romulusEngine = RomulusEngine.this;
            System.arraycopy(bArr2, i2, romulusEngine.f19651m_aad, romulusEngine.m_aadPos, romulusEngine.BlockSize);
            processAfterAbsorbCiphertext();
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processFinalAAD() {
            RomulusEngine romulusEngine = RomulusEngine.this;
            C6238Arrays.m18250fill(romulusEngine.f19651m_aad, romulusEngine.m_aadPos, romulusEngine.AADBufferSize - 1, (byte) 0);
            RomulusEngine romulusEngine2 = RomulusEngine.this;
            int i = romulusEngine2.m_aadPos;
            if (i >= 16) {
                byte[] bArr = romulusEngine2.f19651m_aad;
                bArr[romulusEngine2.AADBufferSize - 1] = (byte) (i & 15);
                RomulusEngine.hirose_128_128_256(this.f20057h, this.f20056g, bArr, 0);
                RomulusEngine.this.m_aadPos = 0;
                return;
            }
            if (i < 0 || romulusEngine2.aadOperator.mo15230getLen() == 0) {
                return;
            }
            RomulusEngine romulusEngine3 = RomulusEngine.this;
            byte[] bArr2 = romulusEngine3.f19651m_aad;
            int i2 = romulusEngine3.BlockSize;
            bArr2[i2 - 1] = (byte) (romulusEngine3.m_aadPos & 15);
            romulusEngine3.m_aadPos = i2;
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        public void processFinalBlock(byte[] bArr, int i) {
            char c;
            int iMo15232getLen = RomulusEngine.this.dataOperator.mo15232getLen();
            RomulusEngine romulusEngine = RomulusEngine.this;
            int i2 = iMo15232getLen - (romulusEngine.forEncryption ? 0 : romulusEngine.MAC_SIZE);
            int i3 = romulusEngine.m_bufPos;
            if (i3 != 0) {
                int iMin = Math.min(i3, 16);
                System.arraycopy(RomulusEngine.this.f20040npub, 0, this.f20053S, 0, 16);
                RomulusEngine romulusEngine2 = RomulusEngine.this;
                romulusEngine2.block_cipher(this.f20053S, this.f20055Z, this.f20054T, 0, romulusEngine2.f20038CNT, (byte) 64);
                C6240Bytes.m18278xor(iMin, RomulusEngine.this.f19652m_buf, this.f20053S, bArr, i);
                System.arraycopy(RomulusEngine.this.f20040npub, 0, this.f20053S, 0, 16);
                RomulusEngine romulusEngine3 = RomulusEngine.this;
                romulusEngine3.lfsr_gf56(romulusEngine3.f20038CNT);
                RomulusEngine romulusEngine4 = RomulusEngine.this;
                if (!romulusEngine4.forEncryption) {
                    bArr = romulusEngine4.f19652m_buf;
                    i = 0;
                }
                System.arraycopy(bArr, i, romulusEngine4.f19651m_aad, romulusEngine4.m_aadPos, romulusEngine4.m_bufPos);
                RomulusEngine romulusEngine5 = RomulusEngine.this;
                C6238Arrays.m18250fill(romulusEngine5.f19651m_aad, romulusEngine5.m_aadPos + romulusEngine5.m_bufPos, romulusEngine5.AADBufferSize - 1, (byte) 0);
                RomulusEngine romulusEngine6 = RomulusEngine.this;
                byte[] bArr2 = romulusEngine6.f19651m_aad;
                int i4 = romulusEngine6.m_aadPos;
                bArr2[(romulusEngine6.BlockSize + i4) - 1] = (byte) (romulusEngine6.m_bufPos & 15);
                if (i4 == 0) {
                    byte[] bArr3 = romulusEngine6.f20040npub;
                    RomulusEngine romulusEngine7 = RomulusEngine.this;
                    byte[] bArr4 = romulusEngine7.f19651m_aad;
                    int i5 = romulusEngine7.BlockSize;
                    System.arraycopy(bArr3, 0, bArr4, i5, i5);
                    c = 0;
                } else {
                    c = 16;
                }
                RomulusEngine.hirose_128_128_256(this.f20057h, this.f20056g, RomulusEngine.this.f19651m_aad, 0);
                RomulusEngine.this.lfsr_gf56(this.f20051CNT_Z);
            } else if (romulusEngine.m_aadPos != 0) {
                if (i2 > 0) {
                    C6238Arrays.m18250fill(romulusEngine.f19651m_aad, romulusEngine.BlockSize, romulusEngine.AADBufferSize, (byte) 0);
                } else {
                    if (romulusEngine.aadOperator.mo15230getLen() != 0) {
                        byte[] bArr5 = RomulusEngine.this.f20040npub;
                        RomulusEngine romulusEngine8 = RomulusEngine.this;
                        System.arraycopy(bArr5, 0, romulusEngine8.f19651m_aad, romulusEngine8.m_aadPos, 16);
                        RomulusEngine.this.m_aadPos = 0;
                        c = 0;
                    }
                    RomulusEngine.hirose_128_128_256(this.f20057h, this.f20056g, RomulusEngine.this.f19651m_aad, 0);
                }
                c = 16;
                RomulusEngine.hirose_128_128_256(this.f20057h, this.f20056g, RomulusEngine.this.f19651m_aad, 0);
            } else if (i2 > 0) {
                C6238Arrays.m18250fill(romulusEngine.f19651m_aad, 0, romulusEngine.BlockSize, (byte) 0);
                byte[] bArr6 = RomulusEngine.this.f20040npub;
                RomulusEngine romulusEngine9 = RomulusEngine.this;
                byte[] bArr7 = romulusEngine9.f19651m_aad;
                int i6 = romulusEngine9.BlockSize;
                System.arraycopy(bArr6, 0, bArr7, i6, i6);
                RomulusEngine.hirose_128_128_256(this.f20057h, this.f20056g, RomulusEngine.this.f19651m_aad, 0);
                c = 0;
            } else {
                c = 16;
            }
            if (c == 16) {
                System.arraycopy(RomulusEngine.this.f20040npub, 0, RomulusEngine.this.f19651m_aad, 0, 16);
                System.arraycopy(RomulusEngine.this.f20038CNT, 0, RomulusEngine.this.f19651m_aad, 16, 7);
                C6238Arrays.m18250fill(RomulusEngine.this.f19651m_aad, 23, 31, (byte) 0);
                RomulusEngine.this.f19651m_aad[31] = 23;
            } else {
                System.arraycopy(this.f20051CNT_Z, 0, RomulusEngine.this.f19651m_aad, 0, 7);
                C6238Arrays.m18250fill(RomulusEngine.this.f19651m_aad, 7, 31, (byte) 0);
                RomulusEngine.this.f19651m_aad[31] = 7;
            }
            byte[] bArr8 = this.f20057h;
            bArr8[0] = (byte) (bArr8[0] ^ 2);
            RomulusEngine.hirose_128_128_256(bArr8, this.f20056g, RomulusEngine.this.f19651m_aad, 0);
            System.arraycopy(this.f20057h, 0, this.f20052LR, 0, 16);
            System.arraycopy(this.f20056g, 0, this.f20052LR, 16, 16);
            C6238Arrays.m18227clear(this.f20051CNT_Z);
            RomulusEngine romulusEngine10 = RomulusEngine.this;
            romulusEngine10.block_cipher(this.f20052LR, romulusEngine10.f20039k, this.f20052LR, 16, this.f20051CNT_Z, (byte) 68);
            byte[] bArr9 = this.f20052LR;
            RomulusEngine romulusEngine11 = RomulusEngine.this;
            System.arraycopy(bArr9, 0, romulusEngine11.f19654mac, 0, romulusEngine11.MAC_SIZE);
        }

        @Override // org.bouncycastle.crypto.engines.RomulusEngine.Instance
        /* renamed from: reset */
        public void mo15388reset() {
            C6238Arrays.m18227clear(this.f20057h);
            C6238Arrays.m18227clear(this.f20056g);
            C6238Arrays.m18227clear(this.f20052LR);
            C6238Arrays.m18227clear(this.f20054T);
            C6238Arrays.m18227clear(this.f20053S);
            C6238Arrays.m18227clear(this.f20051CNT_Z);
            RomulusEngine romulusEngine = RomulusEngine.this;
            romulusEngine.reset_lfsr_gf56(romulusEngine.f20038CNT);
            System.arraycopy(RomulusEngine.this.f20040npub, 0, this.f20055Z, 0, RomulusEngine.this.f19650IV_SIZE);
            RomulusEngine romulusEngine2 = RomulusEngine.this;
            romulusEngine2.block_cipher(this.f20055Z, romulusEngine2.f20039k, this.f20054T, 0, this.f20051CNT_Z, (byte) 66);
            RomulusEngine.this.reset_lfsr_gf56(this.f20051CNT_Z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RomulusEngine(RomulusParameters romulusParameters) {
        Instance romulusM;
        this.AADBufferSize = 16;
        this.BlockSize = 16;
        this.MAC_SIZE = 16;
        this.f19650IV_SIZE = 16;
        this.KEY_SIZE = 16;
        this.f20038CNT = new byte[7];
        int i = romulusParameters.f20050ord;
        if (i == 0) {
            this.algorithmName = "Romulus-M";
            romulusM = new RomulusM();
        } else {
            if (i != 1) {
                if (i == 2) {
                    this.algorithmName = "Romulus-T";
                    this.AADBufferSize = 32;
                    romulusM = new RomulusT();
                }
                setInnerMembers(romulusParameters != RomulusParameters.RomulusN ? AEADBaseEngine.ProcessingBufferType.Buffered : AEADBaseEngine.ProcessingBufferType.Immediate, AEADBaseEngine.AADOperatorType.f19656Counter, romulusParameters != RomulusParameters.RomulusM ? AEADBaseEngine.DataOperatorType.f19676Stream : AEADBaseEngine.DataOperatorType.f19672Counter);
            }
            this.algorithmName = "Romulus-N";
            romulusM = new RomulusN();
        }
        this.instance = romulusM;
        setInnerMembers(romulusParameters != RomulusParameters.RomulusN ? AEADBaseEngine.ProcessingBufferType.Buffered : AEADBaseEngine.ProcessingBufferType.Immediate, AEADBaseEngine.AADOperatorType.f19656Counter, romulusParameters != RomulusParameters.RomulusM ? AEADBaseEngine.DataOperatorType.f19676Stream : AEADBaseEngine.DataOperatorType.f19672Counter);
    }

    public static void hirose_128_128_256(RomulusDigest.C5295Friend c5295Friend, byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        if (c5295Friend == null) {
            throw new NullPointerException("This method is only for use by RomulusDigest");
        }
        hirose_128_128_256(bArr, bArr2, bArr3, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset_lfsr_gf56(byte[] bArr) {
        bArr[0] = 1;
        C6238Arrays.m18250fill(bArr, 1, 7, (byte) 0);
    }

    private static void skinny_128_384_plus_enc(byte[] bArr, byte[] bArr2) {
        Class cls = Byte.TYPE;
        byte[][] bArr3 = (byte[][]) Array.newInstance((Class<?>) cls, 4, 4);
        byte[][][] bArr4 = (byte[][][]) Array.newInstance((Class<?>) cls, 3, 4, 4);
        byte[][][] bArr5 = (byte[][][]) Array.newInstance((Class<?>) cls, 3, 4, 4);
        for (int i = 0; i < 4; i++) {
            int i2 = i << 2;
            System.arraycopy(bArr, i2, bArr3[i], 0, 4);
            System.arraycopy(bArr2, i2, bArr4[0][i], 0, 4);
            System.arraycopy(bArr2, i2 + 16, bArr4[1][i], 0, 4);
            System.arraycopy(bArr2, i2 + 32, bArr4[2][i], 0, 4);
        }
        for (int i3 = 0; i3 < 40; i3++) {
            for (int i4 = 0; i4 < 4; i4++) {
                for (int i5 = 0; i5 < 4; i5++) {
                    byte[] bArr6 = bArr3[i4];
                    bArr6[i5] = f20037sbox_8[bArr6[i5] & C1126UByte.MAX_VALUE];
                }
            }
            byte[] bArr7 = bArr3[0];
            byte b = bArr7[0];
            byte[] bArr8 = f20036RC;
            bArr7[0] = (byte) (b ^ (bArr8[i3] & 15));
            byte[] bArr9 = bArr3[1];
            bArr9[0] = (byte) (bArr9[0] ^ ((bArr8[i3] >>> 4) & 3));
            byte[] bArr10 = bArr3[2];
            bArr10[0] = (byte) (bArr10[0] ^ 2);
            for (int i6 = 0; i6 <= 1; i6++) {
                for (int i7 = 0; i7 < 4; i7++) {
                    byte[] bArr11 = bArr3[i6];
                    bArr11[i7] = (byte) (bArr11[i7] ^ ((bArr4[0][i6][i7] ^ bArr4[1][i6][i7]) ^ bArr4[2][i6][i7]));
                }
            }
            for (int i8 = 0; i8 < 4; i8++) {
                for (int i9 = 0; i9 < 4; i9++) {
                    byte b2 = TWEAKEY_P[(i8 << 2) + i9];
                    int i10 = b2 >>> 2;
                    int i11 = b2 & 3;
                    bArr5[0][i8][i9] = bArr4[0][i10][i11];
                    bArr5[1][i8][i9] = bArr4[1][i10][i11];
                    bArr5[2][i8][i9] = bArr4[2][i10][i11];
                }
            }
            int i12 = 0;
            while (i12 <= 1) {
                for (int i13 = 0; i13 < 4; i13++) {
                    bArr4[0][i12][i13] = bArr5[0][i12][i13];
                    byte b3 = bArr5[1][i12][i13];
                    bArr4[1][i12][i13] = (byte) (((b3 >>> 5) & 1) ^ (((b3 << 1) & 254) ^ ((b3 >>> 7) & 1)));
                    byte b4 = bArr5[2][i12][i13];
                    bArr4[2][i12][i13] = (byte) (((b4 << 1) & 128) ^ (((b4 >>> 1) & 127) ^ ((b4 << 7) & 128)));
                }
                i12++;
            }
            while (i12 < 4) {
                for (int i14 = 0; i14 < 4; i14++) {
                    bArr4[0][i12][i14] = bArr5[0][i12][i14];
                    bArr4[1][i12][i14] = bArr5[1][i12][i14];
                    bArr4[2][i12][i14] = bArr5[2][i12][i14];
                }
                i12++;
            }
            byte[] bArr12 = bArr3[1];
            byte b5 = bArr12[3];
            bArr12[3] = bArr12[2];
            bArr12[2] = bArr12[1];
            bArr12[1] = bArr12[0];
            bArr12[0] = b5;
            byte[] bArr13 = bArr3[2];
            byte b6 = bArr13[0];
            bArr13[0] = bArr13[2];
            bArr13[2] = b6;
            byte b7 = bArr13[1];
            bArr13[1] = bArr13[3];
            bArr13[3] = b7;
            byte[] bArr14 = bArr3[3];
            byte b8 = bArr14[0];
            bArr14[0] = bArr14[1];
            bArr14[1] = bArr14[2];
            bArr14[2] = bArr14[3];
            bArr14[3] = b8;
            for (int i15 = 0; i15 < 4; i15++) {
                byte[] bArr15 = bArr3[1];
                byte b9 = bArr15[i15];
                byte[] bArr16 = bArr3[2];
                bArr15[i15] = (byte) (b9 ^ bArr16[i15]);
                byte b10 = bArr16[i15];
                byte[] bArr17 = bArr3[0];
                byte b11 = (byte) (b10 ^ bArr17[i15]);
                bArr16[i15] = b11;
                byte[] bArr18 = bArr3[3];
                byte b12 = (byte) (bArr18[i15] ^ b11);
                bArr18[i15] = b12;
                bArr18[i15] = bArr16[i15];
                bArr16[i15] = bArr15[i15];
                bArr15[i15] = bArr17[i15];
                bArr17[i15] = b12;
            }
        }
        for (int i16 = 0; i16 < 16; i16++) {
            bArr[i16] = (byte) (bArr3[i16 >>> 2][i16 & 3] & C1126UByte.MAX_VALUE);
        }
    }

    public void block_cipher(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4, byte b) {
        byte[] bArr5 = new byte[48];
        System.arraycopy(bArr4, 0, bArr5, 0, 7);
        bArr5[7] = b;
        System.arraycopy(bArr3, i, bArr5, 16, 16);
        System.arraycopy(bArr2, 0, bArr5, 32, 16);
        skinny_128_384_plus_enc(bArr, bArr5);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: doFinal */
    public /* bridge */ /* synthetic */ int mo15224doFinal(byte[] bArr, int i) {
        return super.mo15224doFinal(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void finishAAD(AEADBaseEngine.C5335State c5335State, boolean z) {
        finishAAD1(c5335State);
    }

    /* renamed from: g8A */
    public void m15385g8A(byte[] bArr, byte[] bArr2, int i) {
        int iMin = Math.min(bArr2.length - i, 16);
        for (int i2 = 0; i2 < iMin; i2++) {
            byte b = bArr[i2];
            bArr2[i2 + i] = (byte) (((b & 1) << 7) ^ (((b & C1126UByte.MAX_VALUE) >>> 1) ^ (b & ByteCompanionObject.MIN_VALUE)));
        }
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public /* bridge */ /* synthetic */ String getAlgorithmName() {
        return super.getAlgorithmName();
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public /* bridge */ /* synthetic */ int getIVBytesSize() {
        return super.getIVBytesSize();
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public /* bridge */ /* synthetic */ int getKeyBytesSize() {
        return super.getKeyBytesSize();
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: getMac */
    public /* bridge */ /* synthetic */ byte[] mo15225getMac() {
        return super.mo15225getMac();
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public /* bridge */ /* synthetic */ int getOutputSize(int i) {
        return super.getOutputSize(i);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public /* bridge */ /* synthetic */ int getUpdateOutputSize(int i) {
        return super.getUpdateOutputSize(i);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: init */
    public /* bridge */ /* synthetic */ void mo15226init(boolean z, CipherParameters cipherParameters) {
        super.mo15226init(z, cipherParameters);
    }

    public void lfsr_gf56(byte[] bArr) {
        byte b = bArr[6];
        byte b2 = (byte) ((b & C1126UByte.MAX_VALUE) >>> 7);
        int i = (b & C1126UByte.MAX_VALUE) << 1;
        byte b3 = bArr[5];
        bArr[6] = (byte) (i | ((b3 & C1126UByte.MAX_VALUE) >>> 7));
        int i2 = (b3 & C1126UByte.MAX_VALUE) << 1;
        byte b4 = bArr[4];
        bArr[5] = (byte) (i2 | ((b4 & C1126UByte.MAX_VALUE) >>> 7));
        int i3 = (b4 & C1126UByte.MAX_VALUE) << 1;
        byte b5 = bArr[3];
        bArr[4] = (byte) (i3 | ((b5 & C1126UByte.MAX_VALUE) >>> 7));
        int i4 = (b5 & C1126UByte.MAX_VALUE) << 1;
        byte b6 = bArr[2];
        bArr[3] = (byte) (i4 | ((b6 & C1126UByte.MAX_VALUE) >>> 7));
        int i5 = (b6 & C1126UByte.MAX_VALUE) << 1;
        byte b7 = bArr[1];
        bArr[2] = (byte) (i5 | ((b7 & C1126UByte.MAX_VALUE) >>> 7));
        int i6 = (b7 & C1126UByte.MAX_VALUE) << 1;
        byte b8 = bArr[0];
        bArr[1] = (byte) (i6 | ((b8 & C1126UByte.MAX_VALUE) >>> 7));
        int i7 = (b8 & C1126UByte.MAX_VALUE) << 1;
        if (b2 == 1) {
            bArr[0] = (byte) (i7 ^ 149);
        } else {
            bArr[0] = (byte) i7;
        }
    }

    /* renamed from: pad */
    public void m15386pad(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        bArr2[i2 - 1] = (byte) (i3 & 15);
        System.arraycopy(bArr, i, bArr2, 0, i3);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public /* bridge */ /* synthetic */ void processAADByte(byte b) {
        super.processAADByte(b);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public /* bridge */ /* synthetic */ void processAADBytes(byte[] bArr, int i, int i2) {
        super.processAADBytes(bArr, i, i2);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processBufferAAD(byte[] bArr, int i) {
        this.instance.processBufferAAD(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processBufferDecrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        this.instance.processBufferDecrypt(bArr, i, bArr2, i2);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processBufferEncrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        this.instance.processBufferEncrypt(bArr, i, bArr2, i2);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public /* bridge */ /* synthetic */ int processByte(byte b, byte[] bArr, int i) {
        return super.processByte(b, bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public /* bridge */ /* synthetic */ int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        return super.processBytes(bArr, i, i2, bArr2, i3);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processFinalAAD() {
        this.instance.processFinalAAD();
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processFinalBlock(byte[] bArr, int i) {
        this.instance.processFinalBlock(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: reset */
    public /* bridge */ /* synthetic */ void mo15228reset() {
        super.mo15228reset();
    }

    /* renamed from: rho */
    public void m15387rho(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3) {
        int i4;
        byte[] bArr4 = new byte[16];
        m15386pad(bArr, i, bArr4, 16, i3);
        m15385g8A(bArr3, bArr2, i2);
        if (this.forEncryption) {
            for (int i5 = 0; i5 < 16; i5++) {
                bArr3[i5] = (byte) (bArr3[i5] ^ bArr4[i5]);
                int i6 = i5 + i2;
                if (i5 < i3) {
                    bArr2[i6] = (byte) (bArr2[i6] ^ bArr4[i5]);
                } else {
                    bArr2[i6] = 0;
                }
            }
            return;
        }
        for (int i7 = 0; i7 < 16; i7++) {
            byte b = (byte) (bArr3[i7] ^ bArr4[i7]);
            bArr3[i7] = b;
            if (i7 < i3 && (i4 = i7 + i2) < bArr2.length) {
                bArr3[i7] = (byte) (b ^ bArr2[i4]);
                bArr2[i4] = (byte) (bArr2[i4] ^ bArr4[i7]);
            }
        }
    }

    public static void hirose_128_128_256(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        byte[] bArr4 = new byte[48];
        byte[] bArr5 = new byte[16];
        System.arraycopy(bArr2, 0, bArr4, 0, 16);
        System.arraycopy(bArr, 0, bArr2, 0, 16);
        System.arraycopy(bArr, 0, bArr5, 0, 16);
        bArr2[0] = (byte) (bArr2[0] ^ 1);
        System.arraycopy(bArr3, i, bArr4, 16, 32);
        skinny_128_384_plus_enc(bArr, bArr4);
        skinny_128_384_plus_enc(bArr2, bArr4);
        for (int i2 = 0; i2 < 16; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ bArr5[i2]);
            bArr2[i2] = (byte) (bArr2[i2] ^ bArr5[i2]);
        }
        bArr2[0] = (byte) (bArr2[0] ^ 1);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    /* renamed from: init */
    public void mo15227init(byte[] bArr, byte[] bArr2) {
        this.f20040npub = bArr2;
        this.f20039k = bArr;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    /* renamed from: reset */
    public void mo15229reset(boolean z) {
        super.mo15229reset(z);
        this.instance.mo15388reset();
    }
}
