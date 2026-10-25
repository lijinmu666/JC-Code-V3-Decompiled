package org.bouncycastle.p249jcajce.provider.symmetric.p277util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import java.util.Map;
import javax.crypto.MacSpi;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p194crypto.p213params.AEADParameters;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p194crypto.p213params.RC2Parameters;
import org.bouncycastle.p194crypto.p213params.SkeinParameters;
import org.bouncycastle.p249jcajce.PKCS12Key;
import org.bouncycastle.p249jcajce.p279spec.AEADParameterSpec;
import org.bouncycastle.p249jcajce.p279spec.SkeinParameterSpec;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.InterfaceC5795PBE;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;

/* renamed from: org.bouncycastle.jcajce.provider.symmetric.util.BaseMac */
/* loaded from: classes2.dex */
public class C5789BaseMac extends MacSpi implements InterfaceC5795PBE {

    /* renamed from: keySize */
    private int f21868keySize;
    private InterfaceC5278Mac macEngine;

    /* renamed from: pbeHash */
    private int f21869pbeHash;

    /* renamed from: scheme */
    private int f21870scheme;

    public C5789BaseMac(int i, InterfaceC5278Mac interfaceC5278Mac) {
        this.f21870scheme = 2;
        this.f21869pbeHash = 1;
        this.f21868keySize = i;
        this.macEngine = interfaceC5278Mac;
    }

    /* renamed from: copyMap */
    private static Hashtable m16178copyMap(Map map) {
        Hashtable hashtable = new Hashtable();
        for (Object obj : map.keySet()) {
            hashtable.put(obj, map.get(obj));
        }
        return hashtable;
    }

    @Override // javax.crypto.MacSpi
    public byte[] engineDoFinal() {
        byte[] bArr = new byte[engineGetMacLength()];
        this.macEngine.mo14975doFinal(bArr, 0);
        return bArr;
    }

    @Override // javax.crypto.MacSpi
    public int engineGetMacLength() {
        return this.macEngine.getMacSize();
    }

    @Override // javax.crypto.MacSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        int i;
        CipherParameters cipherParametersMakePBEMacParameters;
        if (key == null) {
            throw new InvalidKeyException("key is null");
        }
        if (key instanceof PKCS12Key) {
            try {
                SecretKey secretKey = (SecretKey) key;
                try {
                    PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
                    if ((secretKey instanceof PBEKey) && pBEParameterSpec == null) {
                        PBEKey pBEKey = (PBEKey) secretKey;
                        pBEParameterSpec = new PBEParameterSpec(pBEKey.getSalt(), pBEKey.getIterationCount());
                    }
                    int i2 = 256;
                    if (this.macEngine.getAlgorithmName().startsWith("GOST")) {
                        i = 6;
                    } else {
                        InterfaceC5278Mac interfaceC5278Mac = this.macEngine;
                        if (!(interfaceC5278Mac instanceof C5360HMac) || interfaceC5278Mac.getAlgorithmName().startsWith("SHA-1")) {
                            i = 1;
                        } else if (this.macEngine.getAlgorithmName().startsWith("SHA-224")) {
                            i = 7;
                            i2 = InterfaceC5102BERTags.f17976FLAGS;
                        } else if (this.macEngine.getAlgorithmName().startsWith(XMSSKeyParameters.f23621SHA_256)) {
                            i = 4;
                        } else if (this.macEngine.getAlgorithmName().startsWith("SHA-384")) {
                            i = 8;
                            i2 = 384;
                        } else if (this.macEngine.getAlgorithmName().startsWith(XMSSKeyParameters.f23622SHA_512)) {
                            i = 9;
                            i2 = 512;
                        } else {
                            if (!this.macEngine.getAlgorithmName().startsWith("RIPEMD160")) {
                                throw new InvalidAlgorithmParameterException("no PKCS12 mapping for HMAC: " + this.macEngine.getAlgorithmName());
                            }
                            i = 2;
                        }
                        i2 = 160;
                    }
                    cipherParametersMakePBEMacParameters = InterfaceC5795PBE.Util.makePBEMacParameters(secretKey, 2, i, i2, pBEParameterSpec);
                } catch (Exception unused) {
                    throw new InvalidAlgorithmParameterException("PKCS12 requires a PBEParameterSpec");
                }
            } catch (Exception unused2) {
                throw new InvalidKeyException("PKCS12 requires a SecretKey/PBEKey");
            }
        } else if (key instanceof BCPBEKey) {
            BCPBEKey bCPBEKey = (BCPBEKey) key;
            if (bCPBEKey.getParam() != null) {
                cipherParametersMakePBEMacParameters = bCPBEKey.getParam();
            } else {
                if (!(algorithmParameterSpec instanceof PBEParameterSpec)) {
                    throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
                }
                cipherParametersMakePBEMacParameters = InterfaceC5795PBE.Util.makePBEMacParameters(bCPBEKey, algorithmParameterSpec);
            }
        } else {
            if (algorithmParameterSpec instanceof PBEParameterSpec) {
                throw new InvalidAlgorithmParameterException("inappropriate parameter type: " + algorithmParameterSpec.getClass().getName());
            }
            cipherParametersMakePBEMacParameters = new KeyParameter(key.getEncoded());
        }
        KeyParameter keyParameter = cipherParametersMakePBEMacParameters instanceof ParametersWithIV ? (KeyParameter) ((ParametersWithIV) cipherParametersMakePBEMacParameters).getParameters() : (KeyParameter) cipherParametersMakePBEMacParameters;
        if (algorithmParameterSpec instanceof AEADParameterSpec) {
            AEADParameterSpec aEADParameterSpec = (AEADParameterSpec) algorithmParameterSpec;
            cipherParametersMakePBEMacParameters = new AEADParameters(keyParameter, aEADParameterSpec.getMacSizeInBits(), aEADParameterSpec.getNonce(), aEADParameterSpec.getAssociatedData());
        } else if (algorithmParameterSpec instanceof IvParameterSpec) {
            cipherParametersMakePBEMacParameters = new ParametersWithIV(keyParameter, ((IvParameterSpec) algorithmParameterSpec).getIV());
        } else if (algorithmParameterSpec instanceof RC2ParameterSpec) {
            RC2ParameterSpec rC2ParameterSpec = (RC2ParameterSpec) algorithmParameterSpec;
            cipherParametersMakePBEMacParameters = new ParametersWithIV(new RC2Parameters(keyParameter.m15773getKey(), rC2ParameterSpec.getEffectiveKeyBits()), rC2ParameterSpec.getIV());
        } else if (algorithmParameterSpec instanceof SkeinParameterSpec) {
            cipherParametersMakePBEMacParameters = new SkeinParameters.C5375Builder(m16178copyMap(((SkeinParameterSpec) algorithmParameterSpec).getParameters())).m15830setKey(keyParameter.m15773getKey()).m15828build();
        } else if (algorithmParameterSpec == null) {
            cipherParametersMakePBEMacParameters = new KeyParameter(key.getEncoded());
        } else if (GcmSpecUtil.isGcmSpec(algorithmParameterSpec)) {
            cipherParametersMakePBEMacParameters = GcmSpecUtil.extractAeadParameters(keyParameter, algorithmParameterSpec);
        } else if (!(algorithmParameterSpec instanceof PBEParameterSpec)) {
            throw new InvalidAlgorithmParameterException("unknown parameter type: " + algorithmParameterSpec.getClass().getName());
        }
        try {
            this.macEngine.mo14976init(cipherParametersMakePBEMacParameters);
        } catch (Exception e) {
            throw new InvalidAlgorithmParameterException("cannot initialize MAC: " + e.getMessage());
        }
    }

    @Override // javax.crypto.MacSpi
    public void engineReset() {
        this.macEngine.mo14977reset();
    }

    @Override // javax.crypto.MacSpi
    public void engineUpdate(byte b) {
        this.macEngine.mo14978update(b);
    }

    public C5789BaseMac(InterfaceC5278Mac interfaceC5278Mac) {
        this.f21870scheme = 2;
        this.f21869pbeHash = 1;
        this.f21868keySize = 160;
        this.macEngine = interfaceC5278Mac;
    }

    @Override // javax.crypto.MacSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.macEngine.mo14979update(bArr, i, i2);
    }

    public C5789BaseMac(InterfaceC5278Mac interfaceC5278Mac, int i, int i2, int i3) {
        this.macEngine = interfaceC5278Mac;
        this.f21870scheme = i;
        this.f21869pbeHash = i2;
        this.f21868keySize = i3;
    }
}
