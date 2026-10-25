package org.bouncycastle.p314pqc.p316crypto.p331util;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.p135bc.BCObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p314pqc.p315asn1.CMCEPrivateKey;
import org.bouncycastle.p314pqc.p315asn1.FalconPrivateKey;
import org.bouncycastle.p314pqc.p315asn1.PQCObjectIdentifiers;
import org.bouncycastle.p314pqc.p315asn1.SPHINCS256KeyParams;
import org.bouncycastle.p314pqc.p315asn1.SPHINCSPLUSPrivateKey;
import org.bouncycastle.p314pqc.p315asn1.SPHINCSPLUSPublicKey;
import org.bouncycastle.p314pqc.p315asn1.XMSSKeyParams;
import org.bouncycastle.p314pqc.p315asn1.XMSSMTKeyParams;
import org.bouncycastle.p314pqc.p315asn1.XMSSMTPrivateKey;
import org.bouncycastle.p314pqc.p315asn1.XMSSPrivateKey;
import org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.DilithiumParameters;
import org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.DilithiumPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruplus.NTRUPlusPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.NTRULPRimePrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.SNTRUPrimePrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p317cmce.CMCEPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p318falcon.FalconPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p319frodo.FrodoPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p320hqc.HQCPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.HSSPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p322mayo.MayoPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p323mldsa.MLDSAParameters;
import org.bouncycastle.p314pqc.p316crypto.p323mldsa.MLDSAPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p323mldsa.MLDSAPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p324mlkem.MLKEMParameters;
import org.bouncycastle.p314pqc.p316crypto.p324mlkem.MLKEMPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p324mlkem.MLKEMPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p325newhope.NHPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p326ntru.NTRUPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p327saber.SABERPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p328slhdsa.SLHDSAParameters;
import org.bouncycastle.p314pqc.p316crypto.p328slhdsa.SLHDSAPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p329snova.SnovaPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p330sphincs.SPHINCSPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PublicKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.BDSStateMap;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.C6108BDS;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSMTParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSMTPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSUtil;
import org.bouncycastle.p314pqc.p352legacy.p353bike.BIKEParameters;
import org.bouncycastle.p314pqc.p352legacy.p353bike.BIKEPrivateKeyParameters;
import org.bouncycastle.p314pqc.p352legacy.p354picnic.PicnicPrivateKeyParameters;
import org.bouncycastle.p314pqc.p352legacy.p355rainbow.RainbowPrivateKeyParameters;
import org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusParameters;
import org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusPrivateKeyParameters;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class PrivateKeyFactory {
    /* renamed from: convert */
    private static short[] m17877convert(byte[] bArr) {
        int length = bArr.length / 2;
        short[] sArr = new short[length];
        for (int i = 0; i != length; i++) {
            sArr[i] = AbstractC6245Pack.littleEndianToShort(bArr, i * 2);
        }
        return sArr;
    }

    public static AsymmetricKeyParameter createKey(InputStream inputStream) {
        return createKey(PrivateKeyInfo.getInstance(new ASN1InputStream(inputStream).readObject()));
    }

    private static ASN1OctetString parseOctetString(ASN1OctetString aSN1OctetString, int i) {
        ASN1OctetString octetData;
        byte[] octets = aSN1OctetString.getOctets();
        return (octets.length == i || (octetData = C6107Utils.parseOctetData(octets)) == null) ? aSN1OctetString : ASN1OctetString.getInstance(octetData);
    }

    private static ASN1Primitive parsePrimitiveString(ASN1OctetString aSN1OctetString, int i) {
        byte[] octets = aSN1OctetString.getOctets();
        if (octets.length == i) {
            return aSN1OctetString;
        }
        ASN1Primitive data = C6107Utils.parseData(octets);
        return data instanceof ASN1OctetString ? ASN1OctetString.getInstance(data) : data instanceof ASN1Sequence ? ASN1Sequence.getInstance(data) : aSN1OctetString;
    }

    public static AsymmetricKeyParameter createKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        if (privateKeyInfo == null) {
            throw new IllegalArgumentException("keyInfo array null");
        }
        AlgorithmIdentifier privateKeyAlgorithm = privateKeyInfo.getPrivateKeyAlgorithm();
        ASN1ObjectIdentifier algorithm = privateKeyAlgorithm.getAlgorithm();
        if (algorithm.m14446equals((ASN1Primitive) PQCObjectIdentifiers.sphincs256)) {
            return new SPHINCSPrivateKeyParameters(ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey()).getOctets(), C6107Utils.sphincs256LookupTreeAlgName(SPHINCS256KeyParams.getInstance(privateKeyAlgorithm.getParameters())));
        }
        if (algorithm.m14446equals((ASN1Primitive) PQCObjectIdentifiers.f23021newHope)) {
            return new NHPrivateKeyParameters(m17877convert(ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey()).getOctets()));
        }
        if (algorithm.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.id_alg_hss_lms_hashsig)) {
            byte[] octets = parseOctetString(privateKeyInfo.getPrivateKey(), 64).getOctets();
            ASN1BitString publicKeyData = privateKeyInfo.getPublicKeyData();
            if (publicKeyData != null) {
                return HSSPrivateKeyParameters.getInstance(C6238Arrays.copyOfRange(octets, 4, octets.length), publicKeyData.getOctets());
            }
            return HSSPrivateKeyParameters.getInstance(C6238Arrays.copyOfRange(octets, 4, octets.length));
        }
        if (algorithm.m14435on(BCObjectIdentifiers.sphincsPlus) || algorithm.m14435on(BCObjectIdentifiers.sphincsPlus_interop)) {
            SPHINCSPlusParameters sPHINCSPlusParametersSphincsPlusParamsLookup = C6107Utils.sphincsPlusParamsLookup(algorithm);
            ASN1Encodable privateKey = privateKeyInfo.parsePrivateKey();
            if (!(privateKey instanceof ASN1Sequence)) {
                return new SPHINCSPlusPrivateKeyParameters(sPHINCSPlusParametersSphincsPlusParamsLookup, ASN1OctetString.getInstance(privateKey).getOctets());
            }
            SPHINCSPLUSPrivateKey sPHINCSPLUSPrivateKey = SPHINCSPLUSPrivateKey.getInstance(privateKey);
            SPHINCSPLUSPublicKey publicKey = sPHINCSPLUSPrivateKey.getPublicKey();
            return new SPHINCSPlusPrivateKeyParameters(sPHINCSPlusParametersSphincsPlusParamsLookup, sPHINCSPLUSPrivateKey.getSkseed(), sPHINCSPLUSPrivateKey.getSkprf(), publicKey.getPkseed(), publicKey.getPkroot());
        }
        if (C6107Utils.slhdsaParams.containsKey(algorithm)) {
            SLHDSAParameters sLHDSAParametersSlhdsaParamsLookup = C6107Utils.slhdsaParamsLookup(algorithm);
            return new SLHDSAPrivateKeyParameters(sLHDSAParametersSlhdsaParamsLookup, parseOctetString(privateKeyInfo.getPrivateKey(), sLHDSAParametersSlhdsaParamsLookup.m17836getN() * 4).getOctets());
        }
        if (algorithm.m14435on(BCObjectIdentifiers.f18036picnic)) {
            return new PicnicPrivateKeyParameters(C6107Utils.picnicParamsLookup(algorithm), ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey()).getOctets());
        }
        if (algorithm.m14435on(BCObjectIdentifiers.pqc_kem_mceliece)) {
            CMCEPrivateKey cMCEPrivateKey = CMCEPrivateKey.getInstance(privateKeyInfo.parsePrivateKey());
            return new CMCEPrivateKeyParameters(C6107Utils.mcElieceParamsLookup(algorithm), cMCEPrivateKey.getDelta(), cMCEPrivateKey.m17460getC(), cMCEPrivateKey.m17461getG(), cMCEPrivateKey.getAlpha(), cMCEPrivateKey.m17462getS());
        }
        if (algorithm.m14435on(BCObjectIdentifiers.pqc_kem_frodo)) {
            return new FrodoPrivateKeyParameters(C6107Utils.frodoParamsLookup(algorithm), ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey()).getOctets());
        }
        if (algorithm.m14435on(BCObjectIdentifiers.pqc_kem_saber)) {
            return new SABERPrivateKeyParameters(C6107Utils.saberParamsLookup(algorithm), ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey()).getOctets());
        }
        if (algorithm.m14435on(BCObjectIdentifiers.pqc_kem_ntru)) {
            return new NTRUPrivateKeyParameters(C6107Utils.ntruParamsLookup(algorithm), ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey()).getOctets());
        }
        if (algorithm.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_alg_ml_kem_512) || algorithm.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_alg_ml_kem_768) || algorithm.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_alg_ml_kem_1024)) {
            ASN1Primitive primitiveString = parsePrimitiveString(privateKeyInfo.getPrivateKey(), 64);
            MLKEMParameters mLKEMParametersMlkemParamsLookup = C6107Utils.mlkemParamsLookup(algorithm);
            MLKEMPublicKeyParameters publicKeyParams = privateKeyInfo.getPublicKeyData() != null ? PublicKeyFactory.MLKEMConverter.getPublicKeyParams(mLKEMParametersMlkemParamsLookup, privateKeyInfo.getPublicKeyData()) : null;
            if (primitiveString instanceof ASN1OctetString) {
                return new MLKEMPrivateKeyParameters(mLKEMParametersMlkemParamsLookup, ((ASN1OctetString) primitiveString).getOctets(), publicKeyParams);
            }
            if (!(primitiveString instanceof ASN1Sequence)) {
                throw new IllegalArgumentException("invalid " + mLKEMParametersMlkemParamsLookup.m17711getName() + " private key");
            }
            ASN1Sequence aSN1Sequence = (ASN1Sequence) primitiveString;
            byte[] octets2 = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0)).getOctets();
            byte[] octets3 = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets();
            MLKEMPrivateKeyParameters mLKEMPrivateKeyParameters = new MLKEMPrivateKeyParameters(mLKEMParametersMlkemParamsLookup, octets2, publicKeyParams);
            if (C6238Arrays.constantTimeAreEqual(mLKEMPrivateKeyParameters.getEncoded(), octets3)) {
                return mLKEMPrivateKeyParameters;
            }
            throw new IllegalArgumentException("inconsistent " + mLKEMParametersMlkemParamsLookup.m17711getName() + " private key");
        }
        if (algorithm.m14435on(BCObjectIdentifiers.pqc_kem_ntrulprime)) {
            ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(privateKeyInfo.parsePrivateKey());
            return new NTRULPRimePrivateKeyParameters(C6107Utils.ntrulprimeParamsLookup(algorithm), ASN1OctetString.getInstance(aSN1Sequence2.getObjectAt(0)).getOctets(), ASN1OctetString.getInstance(aSN1Sequence2.getObjectAt(1)).getOctets(), ASN1OctetString.getInstance(aSN1Sequence2.getObjectAt(2)).getOctets(), ASN1OctetString.getInstance(aSN1Sequence2.getObjectAt(3)).getOctets());
        }
        if (algorithm.m14435on(BCObjectIdentifiers.pqc_kem_sntruprime)) {
            ASN1Sequence aSN1Sequence3 = ASN1Sequence.getInstance(privateKeyInfo.parsePrivateKey());
            return new SNTRUPrimePrivateKeyParameters(C6107Utils.sntruprimeParamsLookup(algorithm), ASN1OctetString.getInstance(aSN1Sequence3.getObjectAt(0)).getOctets(), ASN1OctetString.getInstance(aSN1Sequence3.getObjectAt(1)).getOctets(), ASN1OctetString.getInstance(aSN1Sequence3.getObjectAt(2)).getOctets(), ASN1OctetString.getInstance(aSN1Sequence3.getObjectAt(3)).getOctets(), ASN1OctetString.getInstance(aSN1Sequence3.getObjectAt(4)).getOctets());
        }
        if (C6107Utils.mldsaParams.containsKey(algorithm)) {
            ASN1Primitive primitiveString2 = parsePrimitiveString(privateKeyInfo.getPrivateKey(), 32);
            MLDSAParameters mLDSAParametersMldsaParamsLookup = C6107Utils.mldsaParamsLookup(algorithm);
            MLDSAPublicKeyParameters publicKeyParams2 = privateKeyInfo.getPublicKeyData() != null ? PublicKeyFactory.MLDSAConverter.getPublicKeyParams(mLDSAParametersMldsaParamsLookup, privateKeyInfo.getPublicKeyData()) : null;
            if (primitiveString2 instanceof ASN1OctetString) {
                return new MLDSAPrivateKeyParameters(mLDSAParametersMldsaParamsLookup, ((ASN1OctetString) primitiveString2).getOctets(), publicKeyParams2);
            }
            if (!(primitiveString2 instanceof ASN1Sequence)) {
                throw new IllegalArgumentException("invalid " + mLDSAParametersMldsaParamsLookup.m17675getName() + " private key");
            }
            ASN1Sequence aSN1Sequence4 = (ASN1Sequence) primitiveString2;
            byte[] octets4 = ASN1OctetString.getInstance(aSN1Sequence4.getObjectAt(0)).getOctets();
            byte[] octets5 = ASN1OctetString.getInstance(aSN1Sequence4.getObjectAt(1)).getOctets();
            MLDSAPrivateKeyParameters mLDSAPrivateKeyParameters = new MLDSAPrivateKeyParameters(mLDSAParametersMldsaParamsLookup, octets4, publicKeyParams2);
            if (C6238Arrays.constantTimeAreEqual(mLDSAPrivateKeyParameters.getEncoded(), octets5)) {
                return mLDSAPrivateKeyParameters;
            }
            throw new IllegalArgumentException("inconsistent " + mLDSAParametersMldsaParamsLookup.m17675getName() + " private key");
        }
        if (algorithm.m14446equals((ASN1Primitive) BCObjectIdentifiers.dilithium2) || algorithm.m14446equals((ASN1Primitive) BCObjectIdentifiers.dilithium3) || algorithm.m14446equals((ASN1Primitive) BCObjectIdentifiers.dilithium5)) {
            ASN1Encodable privateKey2 = privateKeyInfo.parsePrivateKey();
            DilithiumParameters dilithiumParametersDilithiumParamsLookup = C6107Utils.dilithiumParamsLookup(algorithm);
            if (!(privateKey2 instanceof ASN1Sequence)) {
                if (!(privateKey2 instanceof DEROctetString)) {
                    throw new IOException("not supported");
                }
                byte[] octets6 = ASN1OctetString.getInstance(privateKey2).getOctets();
                return privateKeyInfo.getPublicKeyData() != null ? new DilithiumPrivateKeyParameters(dilithiumParametersDilithiumParamsLookup, octets6, PublicKeyFactory.DilithiumConverter.getPublicKeyParams(dilithiumParametersDilithiumParamsLookup, privateKeyInfo.getPublicKeyData())) : new DilithiumPrivateKeyParameters(dilithiumParametersDilithiumParamsLookup, octets6, null);
            }
            ASN1Sequence aSN1Sequence5 = ASN1Sequence.getInstance(privateKey2);
            int iIntValueExact = ASN1Integer.getInstance(aSN1Sequence5.getObjectAt(0)).intValueExact();
            if (iIntValueExact == 0) {
                if (privateKeyInfo.getPublicKeyData() != null) {
                    return new DilithiumPrivateKeyParameters(dilithiumParametersDilithiumParamsLookup, ASN1BitString.getInstance(aSN1Sequence5.getObjectAt(1)).getOctets(), ASN1BitString.getInstance(aSN1Sequence5.getObjectAt(2)).getOctets(), ASN1BitString.getInstance(aSN1Sequence5.getObjectAt(3)).getOctets(), ASN1BitString.getInstance(aSN1Sequence5.getObjectAt(4)).getOctets(), ASN1BitString.getInstance(aSN1Sequence5.getObjectAt(5)).getOctets(), ASN1BitString.getInstance(aSN1Sequence5.getObjectAt(6)).getOctets(), PublicKeyFactory.DilithiumConverter.getPublicKeyParams(dilithiumParametersDilithiumParamsLookup, privateKeyInfo.getPublicKeyData()).m17524getT1());
                }
                return new DilithiumPrivateKeyParameters(dilithiumParametersDilithiumParamsLookup, ASN1BitString.getInstance(aSN1Sequence5.getObjectAt(1)).getOctets(), ASN1BitString.getInstance(aSN1Sequence5.getObjectAt(2)).getOctets(), ASN1BitString.getInstance(aSN1Sequence5.getObjectAt(3)).getOctets(), ASN1BitString.getInstance(aSN1Sequence5.getObjectAt(4)).getOctets(), ASN1BitString.getInstance(aSN1Sequence5.getObjectAt(5)).getOctets(), ASN1BitString.getInstance(aSN1Sequence5.getObjectAt(6)).getOctets(), null);
            }
            throw new IOException("unknown private key version: " + iIntValueExact);
        }
        if (algorithm.m14446equals((ASN1Primitive) BCObjectIdentifiers.falcon_512) || algorithm.m14446equals((ASN1Primitive) BCObjectIdentifiers.falcon_1024)) {
            FalconPrivateKey falconPrivateKey = FalconPrivateKey.getInstance(privateKeyInfo.parsePrivateKey());
            return new FalconPrivateKeyParameters(C6107Utils.falconParamsLookup(algorithm), falconPrivateKey.m17466getf(), falconPrivateKey.m17465getG(), falconPrivateKey.m17464getF(), falconPrivateKey.getPublicKey().m17467getH());
        }
        if (algorithm.m14446equals((ASN1Primitive) BCObjectIdentifiers.old_falcon_512) || algorithm.m14446equals((ASN1Primitive) BCObjectIdentifiers.old_falcon_1024)) {
            FalconPrivateKey falconPrivateKey2 = FalconPrivateKey.getInstance(privateKeyInfo.parsePrivateKey());
            return new FalconPrivateKeyParameters(C6107Utils.falconParamsLookup(algorithm), falconPrivateKey2.m17466getf(), falconPrivateKey2.m17465getG(), falconPrivateKey2.m17464getF(), falconPrivateKey2.getPublicKey().m17467getH());
        }
        if (algorithm.m14435on(BCObjectIdentifiers.pqc_kem_bike)) {
            byte[] octets7 = ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey()).getOctets();
            BIKEParameters bIKEParametersBikeParamsLookup = C6107Utils.bikeParamsLookup(algorithm);
            return new BIKEPrivateKeyParameters(bIKEParametersBikeParamsLookup, C6238Arrays.copyOfRange(octets7, 0, bIKEParametersBikeParamsLookup.getRByte()), C6238Arrays.copyOfRange(octets7, bIKEParametersBikeParamsLookup.getRByte(), bIKEParametersBikeParamsLookup.getRByte() * 2), C6238Arrays.copyOfRange(octets7, bIKEParametersBikeParamsLookup.getRByte() * 2, octets7.length));
        }
        if (algorithm.m14435on(BCObjectIdentifiers.pqc_kem_hqc)) {
            return new HQCPrivateKeyParameters(C6107Utils.hqcParamsLookup(algorithm), ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey()).getOctets());
        }
        if (algorithm.m14435on(BCObjectIdentifiers.f18038rainbow)) {
            return new RainbowPrivateKeyParameters(C6107Utils.rainbowParamsLookup(algorithm), ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey()).getOctets());
        }
        if (algorithm.m14446equals((ASN1Primitive) PQCObjectIdentifiers.f23024xmss)) {
            XMSSKeyParams xMSSKeyParams = XMSSKeyParams.getInstance(privateKeyAlgorithm.getParameters());
            ASN1ObjectIdentifier algorithm2 = xMSSKeyParams.getTreeDigest().getAlgorithm();
            XMSSPrivateKey xMSSPrivateKey = XMSSPrivateKey.getInstance(privateKeyInfo.parsePrivateKey());
            try {
                XMSSPrivateKeyParameters.C6126Builder c6126BuilderWithRoot = new XMSSPrivateKeyParameters.C6126Builder(new XMSSParameters(xMSSKeyParams.getHeight(), C6107Utils.getDigest(algorithm2))).withIndex(xMSSPrivateKey.getIndex()).withSecretKeySeed(xMSSPrivateKey.getSecretKeySeed()).withSecretKeyPRF(xMSSPrivateKey.getSecretKeyPRF()).withPublicSeed(xMSSPrivateKey.getPublicSeed()).withRoot(xMSSPrivateKey.m17478getRoot());
                if (xMSSPrivateKey.getVersion() != 0) {
                    c6126BuilderWithRoot.withMaxIndex(xMSSPrivateKey.getMaxIndex());
                }
                if (xMSSPrivateKey.getBdsState() != null) {
                    c6126BuilderWithRoot.withBDSState(((C6108BDS) XMSSUtil.deserialize(xMSSPrivateKey.getBdsState(), C6108BDS.class)).withWOTSDigest(algorithm2));
                }
                return c6126BuilderWithRoot.m17927build();
            } catch (ClassNotFoundException e) {
                throw new IOException("ClassNotFoundException processing BDS state: " + e.getMessage());
            }
        }
        if (!algorithm.m14446equals((ASN1Primitive) PQCObjectIdentifiers.f23025xmss_mt)) {
            if (algorithm.m14435on(BCObjectIdentifiers.f18026mayo)) {
                return new MayoPrivateKeyParameters(C6107Utils.mayoParamsLookup(algorithm), ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey()).getOctets());
            }
            if (algorithm.m14435on(BCObjectIdentifiers.f18039snova)) {
                return new SnovaPrivateKeyParameters(C6107Utils.snovaParamsLookup(algorithm), ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey()).getOctets());
            }
            if (algorithm.m14435on(BCObjectIdentifiers.pqc_kem_ntruplus)) {
                return new NTRUPlusPrivateKeyParameters(C6107Utils.ntruPlusParamsLookup(algorithm), ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey()).getOctets());
            }
            throw new RuntimeException("algorithm identifier in private key not recognised");
        }
        XMSSMTKeyParams xMSSMTKeyParams = XMSSMTKeyParams.getInstance(privateKeyAlgorithm.getParameters());
        ASN1ObjectIdentifier algorithm3 = xMSSMTKeyParams.getTreeDigest().getAlgorithm();
        try {
            XMSSMTPrivateKey xMSSMTPrivateKey = XMSSMTPrivateKey.getInstance(privateKeyInfo.parsePrivateKey());
            XMSSMTPrivateKeyParameters.C6119Builder c6119BuilderWithRoot = new XMSSMTPrivateKeyParameters.C6119Builder(new XMSSMTParameters(xMSSMTKeyParams.getHeight(), xMSSMTKeyParams.getLayers(), C6107Utils.getDigest(algorithm3))).withIndex(xMSSMTPrivateKey.getIndex()).withSecretKeySeed(xMSSMTPrivateKey.getSecretKeySeed()).withSecretKeyPRF(xMSSMTPrivateKey.getSecretKeyPRF()).withPublicSeed(xMSSMTPrivateKey.getPublicSeed()).withRoot(xMSSMTPrivateKey.m17476getRoot());
            if (xMSSMTPrivateKey.getVersion() != 0) {
                c6119BuilderWithRoot.withMaxIndex(xMSSMTPrivateKey.getMaxIndex());
            }
            if (xMSSMTPrivateKey.getBdsState() != null) {
                c6119BuilderWithRoot.withBDSState(((BDSStateMap) XMSSUtil.deserialize(xMSSMTPrivateKey.getBdsState(), BDSStateMap.class)).withWOTSDigest(algorithm3));
            }
            return c6119BuilderWithRoot.m17917build();
        } catch (ClassNotFoundException e2) {
            throw new IOException("ClassNotFoundException processing BDS state: " + e2.getMessage());
        }
    }

    public static AsymmetricKeyParameter createKey(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("privateKeyInfoData array null");
        }
        if (bArr.length != 0) {
            return createKey(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray(bArr)));
        }
        throw new IllegalArgumentException("privateKeyInfoData array empty");
    }
}
