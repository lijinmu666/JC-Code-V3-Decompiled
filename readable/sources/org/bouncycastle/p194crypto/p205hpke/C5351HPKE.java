package org.bouncycastle.p194crypto.p205hpke;

import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* renamed from: org.bouncycastle.crypto.hpke.HPKE */
/* loaded from: classes2.dex */
public class C5351HPKE {
    public static final short aead_AES_GCM128 = 1;
    public static final short aead_AES_GCM256 = 2;
    public static final short aead_CHACHA20_POLY1305 = 3;
    public static final short aead_EXPORT_ONLY = -1;
    public static final short kdf_HKDF_SHA256 = 1;
    public static final short kdf_HKDF_SHA384 = 2;
    public static final short kdf_HKDF_SHA512 = 3;
    public static final short kem_P256_SHA256 = 16;
    public static final short kem_P384_SHA348 = 17;
    public static final short kem_P384_SHA384 = 17;
    public static final short kem_P521_SHA512 = 18;
    public static final short kem_X25519_SHA256 = 32;
    public static final short kem_X448_SHA512 = 33;
    public static final byte mode_auth = 2;
    public static final byte mode_auth_psk = 3;
    public static final byte mode_base = 0;
    public static final byte mode_psk = 1;

    /* renamed from: Nk */
    short f20340Nk;

    /* renamed from: aeadId */
    private final short f20341aeadId;
    private final byte[] default_psk = null;
    private final byte[] default_psk_id = null;

    /* renamed from: encSize */
    private final int f20342encSize;

    /* renamed from: hkdf */
    private final C5350HKDF f20343hkdf;

    /* renamed from: kdfId */
    private final short f20344kdfId;

    /* renamed from: kem */
    private final AbstractC5352KEM f20345kem;

    /* renamed from: kemId */
    private final short f20346kemId;

    /* renamed from: mode */
    private final byte f20347mode;

    public C5351HPKE(byte b, short s, short s2, short s3) {
        this.f20347mode = b;
        this.f20346kemId = s;
        this.f20344kdfId = s2;
        this.f20341aeadId = s3;
        this.f20343hkdf = new C5350HKDF(s2);
        C5349DHKEM c5349dhkem = new C5349DHKEM(s);
        this.f20345kem = c5349dhkem;
        this.f20340Nk = s3 == 1 ? (short) 16 : (short) 32;
        this.f20342encSize = c5349dhkem.getEncryptionSize();
    }

    private void VerifyPSKInputs(byte b, byte[] bArr, byte[] bArr2) {
        boolean zAreEqual = C6238Arrays.areEqual(bArr, this.default_psk);
        if ((!zAreEqual) != (!C6238Arrays.areEqual(bArr2, this.default_psk_id))) {
            throw new IllegalArgumentException("Inconsistent PSK inputs");
        }
        if (!zAreEqual && b % 2 == 0) {
            throw new IllegalArgumentException("PSK input provided when not needed");
        }
        if (zAreEqual && b % 2 == 1) {
            throw new IllegalArgumentException("Missing required PSK input");
        }
    }

    private HPKEContext keySchedule(byte b, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        VerifyPSKInputs(b, bArr3, bArr4);
        byte[] bArrConcatenate = C6238Arrays.concatenate(C6250Strings.toByteArray("HPKE"), AbstractC6245Pack.shortToBigEndian(this.f20346kemId), AbstractC6245Pack.shortToBigEndian(this.f20344kdfId), AbstractC6245Pack.shortToBigEndian(this.f20341aeadId));
        byte[] bArrConcatenate2 = C6238Arrays.concatenate(new byte[]{b}, this.f20343hkdf.LabeledExtract(null, bArrConcatenate, "psk_id_hash", bArr4), this.f20343hkdf.LabeledExtract(null, bArrConcatenate, "info_hash", bArr2));
        byte[] bArrLabeledExtract = this.f20343hkdf.LabeledExtract(bArr, bArrConcatenate, "secret", bArr3);
        byte[] bArrLabeledExpand = this.f20343hkdf.LabeledExpand(bArrLabeledExtract, bArrConcatenate, "key", bArrConcatenate2, this.f20340Nk);
        byte[] bArrLabeledExpand2 = this.f20343hkdf.LabeledExpand(bArrLabeledExtract, bArrConcatenate, "base_nonce", bArrConcatenate2, 12);
        C5350HKDF c5350hkdf = this.f20343hkdf;
        return new HPKEContext(new C5348AEAD(this.f20341aeadId, bArrLabeledExpand, bArrLabeledExpand2), this.f20343hkdf, c5350hkdf.LabeledExpand(bArrLabeledExtract, bArrConcatenate, "exp", bArrConcatenate2, c5350hkdf.getHashSize()), bArrConcatenate);
    }

    public HPKEContextWithEncapsulation SetupPSKS(AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[][] bArrMo15541Encap = this.f20345kem.mo15541Encap(asymmetricKeyParameter);
        return new HPKEContextWithEncapsulation(keySchedule((byte) 1, bArrMo15541Encap[0], bArr, bArr2, bArr3), bArrMo15541Encap[1]);
    }

    public AsymmetricCipherKeyPair deriveKeyPair(byte[] bArr) {
        return this.f20345kem.DeriveKeyPair(bArr);
    }

    public AsymmetricCipherKeyPair deserializePrivateKey(byte[] bArr, byte[] bArr2) {
        return this.f20345kem.DeserializePrivateKey(bArr, bArr2);
    }

    public AsymmetricKeyParameter deserializePublicKey(byte[] bArr) {
        return this.f20345kem.DeserializePublicKey(bArr);
    }

    public AsymmetricCipherKeyPair generatePrivateKey() {
        return this.f20345kem.GeneratePrivateKey();
    }

    public short getAeadId() {
        return this.f20341aeadId;
    }

    public int getEncSize() {
        return this.f20342encSize;
    }

    /* renamed from: open */
    public byte[] m15545open(byte[] bArr, AsymmetricCipherKeyPair asymmetricCipherKeyPair, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, AsymmetricKeyParameter asymmetricKeyParameter) {
        HPKEContext hPKEContext;
        byte b = this.f20347mode;
        if (b == 0) {
            hPKEContext = setupBaseR(bArr, asymmetricCipherKeyPair, bArr2);
        } else if (b == 1) {
            hPKEContext = setupPSKR(bArr, asymmetricCipherKeyPair, bArr2, bArr5, bArr6);
        } else if (b == 2) {
            hPKEContext = setupAuthR(bArr, asymmetricCipherKeyPair, bArr2, asymmetricKeyParameter);
        } else {
            if (b != 3) {
                throw new IllegalStateException("Unknown mode");
            }
            hPKEContext = setupAuthPSKR(bArr, asymmetricCipherKeyPair, bArr2, bArr5, bArr6, asymmetricKeyParameter);
        }
        return hPKEContext.m15550open(bArr3, bArr4);
    }

    public byte[] receiveExport(byte[] bArr, AsymmetricCipherKeyPair asymmetricCipherKeyPair, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4, byte[] bArr5, AsymmetricKeyParameter asymmetricKeyParameter) {
        HPKEContext hPKEContext;
        byte b = this.f20347mode;
        if (b == 0) {
            hPKEContext = setupBaseR(bArr, asymmetricCipherKeyPair, bArr2);
        } else if (b == 1) {
            hPKEContext = setupPSKR(bArr, asymmetricCipherKeyPair, bArr2, bArr4, bArr5);
        } else if (b == 2) {
            hPKEContext = setupAuthR(bArr, asymmetricCipherKeyPair, bArr2, asymmetricKeyParameter);
        } else {
            if (b != 3) {
                throw new IllegalStateException("Unknown mode");
            }
            hPKEContext = setupAuthPSKR(bArr, asymmetricCipherKeyPair, bArr2, bArr4, bArr5, asymmetricKeyParameter);
        }
        return hPKEContext.m15548export(bArr3, i);
    }

    /* renamed from: seal */
    public byte[][] m15546seal(AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, AsymmetricCipherKeyPair asymmetricCipherKeyPair) {
        HPKEContextWithEncapsulation hPKEContextWithEncapsulationSetupPSKS;
        byte b = this.f20347mode;
        if (b == 0) {
            hPKEContextWithEncapsulationSetupPSKS = setupBaseS(asymmetricKeyParameter, bArr);
        } else if (b == 1) {
            hPKEContextWithEncapsulationSetupPSKS = SetupPSKS(asymmetricKeyParameter, bArr, bArr4, bArr5);
        } else if (b == 2) {
            hPKEContextWithEncapsulationSetupPSKS = setupAuthS(asymmetricKeyParameter, bArr, asymmetricCipherKeyPair);
        } else {
            if (b != 3) {
                throw new IllegalStateException("Unknown mode");
            }
            hPKEContextWithEncapsulationSetupPSKS = setupAuthPSKS(asymmetricKeyParameter, bArr, bArr4, bArr5, asymmetricCipherKeyPair);
        }
        return new byte[][]{hPKEContextWithEncapsulationSetupPSKS.m15552seal(bArr2, bArr3), hPKEContextWithEncapsulationSetupPSKS.getEncapsulation()};
    }

    public byte[][] sendExport(AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, AsymmetricCipherKeyPair asymmetricCipherKeyPair) {
        HPKEContextWithEncapsulation hPKEContextWithEncapsulationSetupPSKS;
        byte b = this.f20347mode;
        if (b == 0) {
            hPKEContextWithEncapsulationSetupPSKS = setupBaseS(asymmetricKeyParameter, bArr);
        } else if (b == 1) {
            hPKEContextWithEncapsulationSetupPSKS = SetupPSKS(asymmetricKeyParameter, bArr, bArr3, bArr4);
        } else if (b == 2) {
            hPKEContextWithEncapsulationSetupPSKS = setupAuthS(asymmetricKeyParameter, bArr, asymmetricCipherKeyPair);
        } else {
            if (b != 3) {
                throw new IllegalStateException("Unknown mode");
            }
            hPKEContextWithEncapsulationSetupPSKS = setupAuthPSKS(asymmetricKeyParameter, bArr, bArr3, bArr4, asymmetricCipherKeyPair);
        }
        return new byte[][]{hPKEContextWithEncapsulationSetupPSKS.encapsulation, hPKEContextWithEncapsulationSetupPSKS.m15548export(bArr2, i)};
    }

    public byte[] serializePrivateKey(AsymmetricKeyParameter asymmetricKeyParameter) {
        return this.f20345kem.SerializePrivateKey(asymmetricKeyParameter);
    }

    public byte[] serializePublicKey(AsymmetricKeyParameter asymmetricKeyParameter) {
        return this.f20345kem.SerializePublicKey(asymmetricKeyParameter);
    }

    public HPKEContext setupAuthPSKR(byte[] bArr, AsymmetricCipherKeyPair asymmetricCipherKeyPair, byte[] bArr2, byte[] bArr3, byte[] bArr4, AsymmetricKeyParameter asymmetricKeyParameter) {
        return keySchedule((byte) 3, this.f20345kem.AuthDecap(bArr, asymmetricCipherKeyPair, asymmetricKeyParameter), bArr2, bArr3, bArr4);
    }

    public HPKEContextWithEncapsulation setupAuthPSKS(AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr, byte[] bArr2, byte[] bArr3, AsymmetricCipherKeyPair asymmetricCipherKeyPair) {
        byte[][] bArrAuthEncap = this.f20345kem.AuthEncap(asymmetricKeyParameter, asymmetricCipherKeyPair);
        return new HPKEContextWithEncapsulation(keySchedule((byte) 3, bArrAuthEncap[0], bArr, bArr2, bArr3), bArrAuthEncap[1]);
    }

    public HPKEContext setupAuthR(byte[] bArr, AsymmetricCipherKeyPair asymmetricCipherKeyPair, byte[] bArr2, AsymmetricKeyParameter asymmetricKeyParameter) {
        return keySchedule((byte) 2, this.f20345kem.AuthDecap(bArr, asymmetricCipherKeyPair, asymmetricKeyParameter), bArr2, this.default_psk, this.default_psk_id);
    }

    public HPKEContextWithEncapsulation setupAuthS(AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr, AsymmetricCipherKeyPair asymmetricCipherKeyPair) {
        byte[][] bArrAuthEncap = this.f20345kem.AuthEncap(asymmetricKeyParameter, asymmetricCipherKeyPair);
        return new HPKEContextWithEncapsulation(keySchedule((byte) 2, bArrAuthEncap[0], bArr, this.default_psk, this.default_psk_id), bArrAuthEncap[1]);
    }

    public HPKEContext setupBaseR(byte[] bArr, AsymmetricCipherKeyPair asymmetricCipherKeyPair, byte[] bArr2) {
        return keySchedule((byte) 0, this.f20345kem.mo15540Decap(bArr, asymmetricCipherKeyPair), bArr2, this.default_psk, this.default_psk_id);
    }

    public HPKEContextWithEncapsulation setupBaseS(AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr) {
        byte[][] bArrMo15541Encap = this.f20345kem.mo15541Encap(asymmetricKeyParameter);
        return new HPKEContextWithEncapsulation(keySchedule((byte) 0, bArrMo15541Encap[0], bArr, this.default_psk, this.default_psk_id), bArrMo15541Encap[1]);
    }

    public HPKEContext setupPSKR(byte[] bArr, AsymmetricCipherKeyPair asymmetricCipherKeyPair, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        return keySchedule((byte) 1, this.f20345kem.mo15540Decap(bArr, asymmetricCipherKeyPair), bArr2, bArr3, bArr4);
    }

    public C5351HPKE(byte b, short s, short s2, short s3, AbstractC5352KEM abstractC5352KEM, int i) {
        this.f20347mode = b;
        this.f20346kemId = s;
        this.f20344kdfId = s2;
        this.f20341aeadId = s3;
        this.f20343hkdf = new C5350HKDF(s2);
        this.f20345kem = abstractC5352KEM;
        this.f20340Nk = s3 == 1 ? (short) 16 : (short) 32;
        this.f20342encSize = i;
    }

    public HPKEContextWithEncapsulation setupBaseS(AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr, AsymmetricCipherKeyPair asymmetricCipherKeyPair) {
        byte[][] bArrMo15542Encap = this.f20345kem.mo15542Encap(asymmetricKeyParameter, asymmetricCipherKeyPair);
        return new HPKEContextWithEncapsulation(keySchedule((byte) 0, bArrMo15542Encap[0], bArr, this.default_psk, this.default_psk_id), bArrMo15542Encap[1]);
    }
}
