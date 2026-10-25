package com.p038google.p061crypto.p062tink.p075subtle;

import com.p038google.p061crypto.p062tink.InterfaceC0313KeyWrap;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import p094kotlin.C1126UByte;

/* renamed from: com.google.crypto.tink.subtle.Kwp */
/* loaded from: classes.dex */
public class C0867Kwp implements InterfaceC0313KeyWrap {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int MAX_WRAP_KEY_SIZE = 4096;
    static final int MIN_WRAP_KEY_SIZE = 16;

    /* renamed from: PREFIX */
    static final byte[] f3972PREFIX = {-90, 89, 89, -90};

    /* renamed from: ROUNDS */
    static final int f3973ROUNDS = 6;

    /* renamed from: aesKey */
    private final SecretKey f3974aesKey;

    public C0867Kwp(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != 16 && bArr.length != 32) {
            throw new GeneralSecurityException("Unsupported key length");
        }
        this.f3974aesKey = new SecretKeySpec(bArr, "AES");
    }

    private byte[] computeW(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr2.length <= 8 || bArr2.length > 2147483631 || bArr.length != 8) {
            throw new GeneralSecurityException("computeW called with invalid parameters");
        }
        int iWrappingSize = wrappingSize(bArr2.length);
        byte[] bArr3 = new byte[iWrappingSize];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, 8, bArr2.length);
        int i = (iWrappingSize / 8) - 1;
        Cipher engineFactory = EngineFactory.f3961CIPHER.getInstance("AES/ECB/NoPadding");
        engineFactory.init(1, this.f3974aesKey);
        byte[] bArr4 = new byte[16];
        System.arraycopy(bArr3, 0, bArr4, 0, 8);
        for (int i2 = 0; i2 < 6; i2++) {
            int i3 = 0;
            while (i3 < i) {
                int i4 = i3 + 1;
                int i5 = i4 * 8;
                System.arraycopy(bArr3, i5, bArr4, 8, 8);
                engineFactory.doFinal(bArr4, 0, 16, bArr4);
                int i6 = (i2 * i) + i3 + 1;
                for (int i7 = 0; i7 < 4; i7++) {
                    int i8 = 7 - i7;
                    bArr4[i8] = (byte) (bArr4[i8] ^ ((byte) (i6 & 255)));
                    i6 >>>= 8;
                }
                System.arraycopy(bArr4, 8, bArr3, i5, 8);
                i3 = i4;
            }
        }
        System.arraycopy(bArr4, 0, bArr3, 0, 8);
        return bArr3;
    }

    /* renamed from: invertW */
    private byte[] m4276invertW(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length < 24 || bArr.length % 8 != 0) {
            throw new GeneralSecurityException("Incorrect data size");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        int length = bArrCopyOf.length / 8;
        int i = length - 1;
        Cipher engineFactory = EngineFactory.f3961CIPHER.getInstance("AES/ECB/NoPadding");
        engineFactory.init(2, this.f3974aesKey);
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArrCopyOf, 0, bArr2, 0, 8);
        for (int i2 = 5; i2 >= 0; i2--) {
            for (int i3 = length - 2; i3 >= 0; i3--) {
                int i4 = (i3 + 1) * 8;
                System.arraycopy(bArrCopyOf, i4, bArr2, 8, 8);
                int i5 = (i2 * i) + i3 + 1;
                for (int i6 = 0; i6 < 4; i6++) {
                    int i7 = 7 - i6;
                    bArr2[i7] = (byte) (((byte) (i5 & 255)) ^ bArr2[i7]);
                    i5 >>>= 8;
                }
                engineFactory.doFinal(bArr2, 0, 16, bArr2);
                System.arraycopy(bArr2, 8, bArrCopyOf, i4, 8);
            }
        }
        System.arraycopy(bArr2, 0, bArrCopyOf, 0, 8);
        return bArrCopyOf;
    }

    private int wrappingSize(int i) {
        return i + (7 - ((i + 7) % 8)) + 8;
    }

    @Override // com.p038google.p061crypto.p062tink.InterfaceC0313KeyWrap
    /* renamed from: unwrap */
    public byte[] mo3347unwrap(byte[] bArr) throws GeneralSecurityException {
        int i;
        if (bArr.length < wrappingSize(16)) {
            throw new GeneralSecurityException("Wrapped key size is too small");
        }
        if (bArr.length > wrappingSize(4096)) {
            throw new GeneralSecurityException("Wrapped key size is too large");
        }
        if (bArr.length % 8 != 0) {
            throw new GeneralSecurityException("Wrapped key size must be a multiple of 8 bytes");
        }
        byte[] bArrM4276invertW = m4276invertW(bArr);
        boolean z = true;
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= 4) {
                break;
            }
            if (f3972PREFIX[i2] != bArrM4276invertW[i2]) {
                z = false;
            }
            i2++;
        }
        int i3 = 0;
        for (i = 4; i < 8; i++) {
            i3 = (i3 << 8) + (bArrM4276invertW[i] & C1126UByte.MAX_VALUE);
        }
        if (wrappingSize(i3) == bArrM4276invertW.length) {
            for (int i4 = i3 + 8; i4 < bArrM4276invertW.length; i4++) {
                if (bArrM4276invertW[i4] != 0) {
                    z = false;
                }
            }
            z2 = z;
        }
        if (z2) {
            return Arrays.copyOfRange(bArrM4276invertW, 8, i3 + 8);
        }
        throw new BadPaddingException("Invalid padding");
    }

    @Override // com.p038google.p061crypto.p062tink.InterfaceC0313KeyWrap
    /* renamed from: wrap */
    public byte[] mo3348wrap(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length < 16) {
            throw new GeneralSecurityException("Key size of key to wrap too small");
        }
        if (bArr.length > 4096) {
            throw new GeneralSecurityException("Key size of key to wrap too large");
        }
        byte[] bArr2 = new byte[8];
        byte[] bArr3 = f3972PREFIX;
        System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
        for (int i = 0; i < 4; i++) {
            bArr2[i + 4] = (byte) ((bArr.length >> ((3 - i) * 8)) & 255);
        }
        return computeW(bArr2, bArr);
    }
}
