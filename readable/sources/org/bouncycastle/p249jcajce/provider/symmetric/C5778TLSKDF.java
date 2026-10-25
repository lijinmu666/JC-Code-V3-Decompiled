package org.bouncycastle.p249jcajce.provider.symmetric;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p199digests.SHA384Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p221util.DigestFactory;
import org.bouncycastle.p249jcajce.p279spec.TLSKeyMaterialSpec;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseSecretKeyFactory;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* renamed from: org.bouncycastle.jcajce.provider.symmetric.TLSKDF */
/* loaded from: classes2.dex */
public class C5778TLSKDF {

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.TLSKDF$Mappings */
    public static class Mappings extends AlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21836PREFIX = C5778TLSKDF.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21836PREFIX;
            sb.append(str);
            sb.append("$TLS10");
            configurableProvider.addAlgorithm("SecretKeyFactory.TLS10KDF", sb.toString());
            configurableProvider.addAlgorithm("SecretKeyFactory.TLS11KDF", str + "$TLS11");
            configurableProvider.addAlgorithm("SecretKeyFactory.TLS12WITHSHA256KDF", str + "$TLS12withSHA256");
            configurableProvider.addAlgorithm("SecretKeyFactory.TLS12WITHSHA384KDF", str + "$TLS12withSHA384");
            configurableProvider.addAlgorithm("SecretKeyFactory.TLS12WITHSHA512KDF", str + "$TLS12withSHA512");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.TLSKDF$TLS10 */
    public static final class TLS10 extends TLSKeyMaterialFactory {
        public TLS10() {
            super("TLS10KDF");
        }

        @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseSecretKeyFactory, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof TLSKeyMaterialSpec) {
                return new SecretKeySpec(C5778TLSKDF.PRF_legacy((TLSKeyMaterialSpec) keySpec), this.f21871algName);
            }
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.TLSKDF$TLS11 */
    public static final class TLS11 extends TLSKeyMaterialFactory {
        public TLS11() {
            super("TLS11KDF");
        }

        @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseSecretKeyFactory, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof TLSKeyMaterialSpec) {
                return new SecretKeySpec(C5778TLSKDF.PRF_legacy((TLSKeyMaterialSpec) keySpec), this.f21871algName);
            }
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.TLSKDF$TLS12 */
    public static class TLS12 extends TLSKeyMaterialFactory {

        /* renamed from: prf */
        private final InterfaceC5278Mac f21837prf;

        public TLS12(String str, InterfaceC5278Mac interfaceC5278Mac) {
            super(str);
            this.f21837prf = interfaceC5278Mac;
        }

        /* renamed from: PRF */
        private byte[] m16173PRF(TLSKeyMaterialSpec tLSKeyMaterialSpec, InterfaceC5278Mac interfaceC5278Mac) {
            byte[] bArrConcatenate = C6238Arrays.concatenate(C6250Strings.toByteArray(tLSKeyMaterialSpec.getLabel()), tLSKeyMaterialSpec.m16221getSeed());
            byte[] secret = tLSKeyMaterialSpec.getSecret();
            byte[] bArr = new byte[tLSKeyMaterialSpec.getLength()];
            C5778TLSKDF.hmac_hash(interfaceC5278Mac, secret, bArrConcatenate, bArr);
            return bArr;
        }

        @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseSecretKeyFactory, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof TLSKeyMaterialSpec) {
                return new SecretKeySpec(m16173PRF((TLSKeyMaterialSpec) keySpec, this.f21837prf), this.f21871algName);
            }
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.TLSKDF$TLS12withSHA256 */
    public static final class TLS12withSHA256 extends TLS12 {
        public TLS12withSHA256() {
            super("TLS12withSHA256KDF", new C5360HMac(SHA256Digest.newInstance()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.TLSKDF$TLS12withSHA384 */
    public static final class TLS12withSHA384 extends TLS12 {
        public TLS12withSHA384() {
            super("TLS12withSHA384KDF", new C5360HMac(new SHA384Digest()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.TLSKDF$TLS12withSHA512 */
    public static final class TLS12withSHA512 extends TLS12 {
        public TLS12withSHA512() {
            super("TLS12withSHA512KDF", new C5360HMac(new SHA512Digest()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.TLSKDF$TLSKeyMaterialFactory */
    public static class TLSKeyMaterialFactory extends BaseSecretKeyFactory {
        public TLSKeyMaterialFactory(String str) {
            super(str, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] PRF_legacy(TLSKeyMaterialSpec tLSKeyMaterialSpec) {
        C5360HMac c5360HMac = new C5360HMac(DigestFactory.createMD5());
        C5360HMac c5360HMac2 = new C5360HMac(DigestFactory.createSHA1());
        byte[] bArrConcatenate = C6238Arrays.concatenate(C6250Strings.toByteArray(tLSKeyMaterialSpec.getLabel()), tLSKeyMaterialSpec.m16221getSeed());
        byte[] secret = tLSKeyMaterialSpec.getSecret();
        int length = (secret.length + 1) / 2;
        byte[] bArr = new byte[length];
        byte[] bArr2 = new byte[length];
        System.arraycopy(secret, 0, bArr, 0, length);
        System.arraycopy(secret, secret.length - length, bArr2, 0, length);
        int length2 = tLSKeyMaterialSpec.getLength();
        byte[] bArr3 = new byte[length2];
        byte[] bArr4 = new byte[length2];
        hmac_hash(c5360HMac, bArr, bArrConcatenate, bArr3);
        hmac_hash(c5360HMac2, bArr2, bArrConcatenate, bArr4);
        for (int i = 0; i < length2; i++) {
            bArr3[i] = (byte) (bArr3[i] ^ bArr4[i]);
        }
        return bArr3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hmac_hash(InterfaceC5278Mac interfaceC5278Mac, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        interfaceC5278Mac.mo14976init(new KeyParameter(bArr));
        int macSize = interfaceC5278Mac.getMacSize();
        int length = ((bArr3.length + macSize) - 1) / macSize;
        int macSize2 = interfaceC5278Mac.getMacSize();
        byte[] bArr4 = new byte[macSize2];
        byte[] bArr5 = new byte[interfaceC5278Mac.getMacSize()];
        byte[] bArr6 = bArr2;
        int i = 0;
        while (i < length) {
            interfaceC5278Mac.mo14979update(bArr6, 0, bArr6.length);
            interfaceC5278Mac.mo14975doFinal(bArr4, 0);
            interfaceC5278Mac.mo14979update(bArr4, 0, macSize2);
            interfaceC5278Mac.mo14979update(bArr2, 0, bArr2.length);
            interfaceC5278Mac.mo14975doFinal(bArr5, 0);
            int i2 = macSize * i;
            System.arraycopy(bArr5, 0, bArr3, i2, Math.min(macSize, bArr3.length - i2));
            i++;
            bArr6 = bArr4;
        }
    }
}
