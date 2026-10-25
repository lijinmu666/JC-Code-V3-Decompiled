package com.p038google.p061crypto.p062tink.p075subtle;

import com.p038google.p061crypto.p062tink.p065config.internal.TinkFipsUtil;
import com.p038google.p061crypto.p062tink.p072prf.InterfaceC0504Prf;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

/* loaded from: classes.dex */
public final class PrfHmacJce implements InterfaceC0504Prf {

    /* renamed from: FIPS */
    public static final TinkFipsUtil.AlgorithmFipsCompatibility f3985FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    static final int MIN_KEY_SIZE_IN_BYTES = 16;
    private final String algorithm;

    /* renamed from: key */
    private final Key f3986key;
    private final ThreadLocal<Mac> localMac;
    private final int maxOutputLength;

    public PrfHmacJce(String str, Key key) throws GeneralSecurityException {
        ThreadLocal<Mac> threadLocal = new ThreadLocal<Mac>() { // from class: com.google.crypto.tink.subtle.PrfHmacJce.1
            @Override // java.lang.ThreadLocal
            public Mac initialValue() throws InvalidKeyException {
                try {
                    Mac engineFactory = EngineFactory.f3962MAC.getInstance(PrfHmacJce.this.algorithm);
                    engineFactory.init(PrfHmacJce.this.f3986key);
                    return engineFactory;
                } catch (GeneralSecurityException e) {
                    throw new IllegalStateException(e);
                }
            }
        };
        this.localMac = threadLocal;
        if (!f3985FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.algorithm = str;
        this.f3986key = key;
        if (key.getEncoded().length < 16) {
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
        str.hashCode();
        switch (str) {
            case "HMACSHA1":
                this.maxOutputLength = 20;
                break;
            case "HMACSHA224":
                this.maxOutputLength = 28;
                break;
            case "HMACSHA256":
                this.maxOutputLength = 32;
                break;
            case "HMACSHA384":
                this.maxOutputLength = 48;
                break;
            case "HMACSHA512":
                this.maxOutputLength = 64;
                break;
            default:
                throw new NoSuchAlgorithmException("unknown Hmac algorithm: " + str);
        }
        threadLocal.get();
    }

    @Override // com.p038google.p061crypto.p062tink.p072prf.InterfaceC0504Prf
    /* renamed from: compute */
    public byte[] mo3552compute(byte[] bArr, int i) throws IllegalStateException, InvalidAlgorithmParameterException {
        if (i > this.maxOutputLength) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        this.localMac.get().update(bArr);
        return Arrays.copyOf(this.localMac.get().doFinal(), i);
    }

    public int getMaxOutputLength() {
        return this.maxOutputLength;
    }
}
