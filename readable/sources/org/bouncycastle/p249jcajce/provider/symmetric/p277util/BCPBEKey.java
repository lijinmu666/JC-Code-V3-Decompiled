package org.bouncycastle.p249jcajce.provider.symmetric.p277util;

import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.PBEKeySpec;
import javax.security.auth.Destroyable;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.PBEParametersGenerator;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BCPBEKey implements PBEKey, Destroyable {
    String algorithm;

    /* renamed from: digest */
    int f21845digest;
    private final AtomicBoolean hasBeenDestroyed;
    private final int iterationCount;

    /* renamed from: ivSize */
    int f21846ivSize;

    /* renamed from: keySize */
    int f21847keySize;

    /* renamed from: oid */
    ASN1ObjectIdentifier f21848oid;

    /* renamed from: param */
    private final CipherParameters f21849param;
    private final char[] password;

    /* renamed from: salt */
    private final byte[] f21850salt;
    boolean tryWrong;

    /* renamed from: type */
    int f21851type;

    public BCPBEKey(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, int i, int i2, int i3, int i4, PBEKeySpec pBEKeySpec, CipherParameters cipherParameters) {
        this.hasBeenDestroyed = new AtomicBoolean(false);
        this.tryWrong = false;
        this.algorithm = str;
        this.f21848oid = aSN1ObjectIdentifier;
        this.f21851type = i;
        this.f21845digest = i2;
        this.f21847keySize = i3;
        this.f21846ivSize = i4;
        this.password = pBEKeySpec.getPassword();
        this.iterationCount = pBEKeySpec.getIterationCount();
        this.f21850salt = pBEKeySpec.getSalt();
        this.f21849param = cipherParameters;
    }

    public static void checkDestroyed(Destroyable destroyable) {
        if (destroyable.isDestroyed()) {
            throw new IllegalStateException("key has been destroyed");
        }
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() {
        if (this.hasBeenDestroyed.getAndSet(true)) {
            return;
        }
        char[] cArr = this.password;
        if (cArr != null) {
            C6238Arrays.m18251fill(cArr, (char) 0);
        }
        byte[] bArr = this.f21850salt;
        if (bArr != null) {
            C6238Arrays.m18249fill(bArr, (byte) 0);
        }
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        String str = this.algorithm;
        checkDestroyed(this);
        return str;
    }

    public int getDigest() {
        int i = this.f21845digest;
        checkDestroyed(this);
        return i;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        byte[] bArrPKCS12PasswordToBytes;
        CipherParameters parameters = this.f21849param;
        if (parameters != null) {
            if (parameters instanceof ParametersWithIV) {
                parameters = ((ParametersWithIV) parameters).getParameters();
            }
            bArrPKCS12PasswordToBytes = ((KeyParameter) parameters).m15773getKey();
        } else {
            int i = this.f21851type;
            bArrPKCS12PasswordToBytes = i == 2 ? PBEParametersGenerator.PKCS12PasswordToBytes(this.password) : i == 5 ? PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(this.password) : PBEParametersGenerator.PKCS5PasswordToBytes(this.password);
        }
        checkDestroyed(this);
        return bArrPKCS12PasswordToBytes;
    }

    @Override // java.security.Key
    public String getFormat() {
        checkDestroyed(this);
        return "RAW";
    }

    @Override // javax.crypto.interfaces.PBEKey
    public int getIterationCount() {
        int i = this.iterationCount;
        checkDestroyed(this);
        return i;
    }

    public int getIvSize() {
        int i = this.f21846ivSize;
        checkDestroyed(this);
        return i;
    }

    public int getKeySize() {
        int i = this.f21847keySize;
        checkDestroyed(this);
        return i;
    }

    /* renamed from: getOID */
    public ASN1ObjectIdentifier m16174getOID() {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.f21848oid;
        checkDestroyed(this);
        return aSN1ObjectIdentifier;
    }

    public CipherParameters getParam() {
        CipherParameters cipherParameters = this.f21849param;
        checkDestroyed(this);
        return cipherParameters;
    }

    @Override // javax.crypto.interfaces.PBEKey
    public char[] getPassword() {
        char[] cArrM18233clone = C6238Arrays.m18233clone(this.password);
        checkDestroyed(this);
        if (cArrM18233clone != null) {
            return cArrM18233clone;
        }
        throw new IllegalStateException("no password available");
    }

    @Override // javax.crypto.interfaces.PBEKey
    public byte[] getSalt() {
        byte[] bArrM18231clone = C6238Arrays.m18231clone(this.f21850salt);
        checkDestroyed(this);
        return bArrM18231clone;
    }

    /* renamed from: getType */
    public int m16175getType() {
        int i = this.f21851type;
        checkDestroyed(this);
        return i;
    }

    @Override // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return this.hasBeenDestroyed.get();
    }

    public void setTryWrongPKCS12Zero(boolean z) {
        this.tryWrong = z;
    }

    public boolean shouldTryWrongPKCS12() {
        return this.tryWrong;
    }

    public BCPBEKey(String str, CipherParameters cipherParameters) {
        this.hasBeenDestroyed = new AtomicBoolean(false);
        this.tryWrong = false;
        this.algorithm = str;
        this.f21849param = cipherParameters;
        this.password = null;
        this.iterationCount = -1;
        this.f21850salt = null;
    }
}
