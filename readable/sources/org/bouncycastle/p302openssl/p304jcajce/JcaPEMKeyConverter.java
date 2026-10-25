package org.bouncycastle.p302openssl.p304jcajce;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;
import org.bouncycastle.p302openssl.PEMException;
import org.bouncycastle.p302openssl.PEMKeyPair;

/* loaded from: classes2.dex */
public class JcaPEMKeyConverter {
    private static final Map baseMappings;
    private final Map algorithms;

    /* renamed from: helper */
    private JcaJceHelper f22832helper = new DefaultJcaJceHelper();

    static {
        HashMap map = new HashMap();
        baseMappings = map;
        map.put(X9ObjectIdentifiers.id_ecPublicKey, "ECDSA");
        map.put(PKCSObjectIdentifiers.rsaEncryption, "RSA");
        map.put(X9ObjectIdentifiers.f18789id_dsa, "DSA");
    }

    public JcaPEMKeyConverter() {
        HashMap map = new HashMap();
        this.algorithms = map;
        map.putAll(baseMappings);
    }

    private KeyFactory getKeyFactory(AlgorithmIdentifier algorithmIdentifier) throws NoSuchAlgorithmException {
        ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
        String strM14433getId = (String) this.algorithms.get(algorithm);
        if (strM14433getId == null) {
            strM14433getId = algorithm.m14433getId();
        }
        try {
            return this.f22832helper.createKeyFactory(strM14433getId);
        } catch (NoSuchAlgorithmException e) {
            if (strM14433getId.equals("ECDSA")) {
                return this.f22832helper.createKeyFactory("EC");
            }
            throw e;
        }
    }

    public KeyPair getKeyPair(PEMKeyPair pEMKeyPair) throws PEMException {
        try {
            KeyFactory keyFactory = getKeyFactory(pEMKeyPair.getPrivateKeyInfo().getPrivateKeyAlgorithm());
            return new KeyPair(keyFactory.generatePublic(new X509EncodedKeySpec(pEMKeyPair.getPublicKeyInfo().getEncoded())), keyFactory.generatePrivate(new PKCS8EncodedKeySpec(pEMKeyPair.getPrivateKeyInfo().getEncoded())));
        } catch (Exception e) {
            throw new PEMException("unable to convert key pair: " + e.getMessage(), e);
        }
    }

    public PrivateKey getPrivateKey(PrivateKeyInfo privateKeyInfo) throws PEMException {
        try {
            return getKeyFactory(privateKeyInfo.getPrivateKeyAlgorithm()).generatePrivate(new PKCS8EncodedKeySpec(privateKeyInfo.getEncoded()));
        } catch (Exception e) {
            throw new PEMException("unable to convert key pair: " + e.getMessage(), e);
        }
    }

    public PublicKey getPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws PEMException {
        try {
            return getKeyFactory(subjectPublicKeyInfo.getAlgorithm()).generatePublic(new X509EncodedKeySpec(subjectPublicKeyInfo.getEncoded()));
        } catch (Exception e) {
            throw new PEMException("unable to convert key pair: " + e.getMessage(), e);
        }
    }

    public JcaPEMKeyConverter setAlgorithmMapping(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        this.algorithms.put(aSN1ObjectIdentifier, str);
        return this;
    }

    public JcaPEMKeyConverter setProvider(String str) {
        this.f22832helper = new NamedJcaJceHelper(str);
        return this;
    }

    public JcaPEMKeyConverter setProvider(Provider provider) {
        this.f22832helper = new ProviderJcaJceHelper(provider);
        return this;
    }
}
