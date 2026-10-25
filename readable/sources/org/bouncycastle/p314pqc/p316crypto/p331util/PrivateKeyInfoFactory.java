package org.bouncycastle.p314pqc.p316crypto.p331util;

import java.io.IOException;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p314pqc.p315asn1.CMCEPrivateKey;
import org.bouncycastle.p314pqc.p315asn1.CMCEPublicKey;
import org.bouncycastle.p314pqc.p315asn1.FalconPrivateKey;
import org.bouncycastle.p314pqc.p315asn1.FalconPublicKey;
import org.bouncycastle.p314pqc.p315asn1.PQCObjectIdentifiers;
import org.bouncycastle.p314pqc.p315asn1.SPHINCS256KeyParams;
import org.bouncycastle.p314pqc.p315asn1.XMSSKeyParams;
import org.bouncycastle.p314pqc.p315asn1.XMSSMTKeyParams;
import org.bouncycastle.p314pqc.p315asn1.XMSSMTPrivateKey;
import org.bouncycastle.p314pqc.p315asn1.XMSSPrivateKey;
import org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.DilithiumPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruplus.NTRUPlusPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.NTRULPRimePrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.SNTRUPrimePrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p317cmce.CMCEPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p318falcon.FalconPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p319frodo.FrodoPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p320hqc.HQCPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.Composer;
import org.bouncycastle.p314pqc.p316crypto.p321lms.HSSPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.LMSPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p322mayo.MayoPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p323mldsa.MLDSAPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p324mlkem.MLKEMPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p325newhope.NHPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p326ntru.NTRUPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p327saber.SABERPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p328slhdsa.SLHDSAPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p329snova.SnovaPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p330sphincs.SPHINCSPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.BDSStateMap;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.C6108BDS;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSMTPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSUtil;
import org.bouncycastle.p314pqc.p352legacy.p353bike.BIKEPrivateKeyParameters;
import org.bouncycastle.p314pqc.p352legacy.p354picnic.PicnicPrivateKeyParameters;
import org.bouncycastle.p314pqc.p352legacy.p355rainbow.RainbowPrivateKeyParameters;
import org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusPrivateKeyParameters;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class PrivateKeyInfoFactory {
    private PrivateKeyInfoFactory() {
    }

    public static PrivateKeyInfo createPrivateKeyInfo(AsymmetricKeyParameter asymmetricKeyParameter) {
        return createPrivateKeyInfo(asymmetricKeyParameter, null);
    }

    private static ASN1Sequence getBasicPQCEncoding(byte[] bArr, byte[] bArr2) {
        return new DERSequence(new DEROctetString(bArr), new DEROctetString(bArr2));
    }

    private static XMSSPrivateKey xmssCreateKeyStructure(XMSSPrivateKeyParameters xMSSPrivateKeyParameters) throws IOException {
        byte[] encoded = xMSSPrivateKeyParameters.getEncoded();
        int treeDigestSize = xMSSPrivateKeyParameters.getParameters().getTreeDigestSize();
        int height = xMSSPrivateKeyParameters.getParameters().getHeight();
        int iBytesToXBigEndian = (int) XMSSUtil.bytesToXBigEndian(encoded, 0, 4);
        if (!XMSSUtil.isIndexValid(height, iBytesToXBigEndian)) {
            throw new IllegalArgumentException("index out of bounds");
        }
        byte[] bArrExtractBytesAtOffset = XMSSUtil.extractBytesAtOffset(encoded, 4, treeDigestSize);
        int i = 4 + treeDigestSize;
        byte[] bArrExtractBytesAtOffset2 = XMSSUtil.extractBytesAtOffset(encoded, i, treeDigestSize);
        int i2 = i + treeDigestSize;
        byte[] bArrExtractBytesAtOffset3 = XMSSUtil.extractBytesAtOffset(encoded, i2, treeDigestSize);
        int i3 = i2 + treeDigestSize;
        byte[] bArrExtractBytesAtOffset4 = XMSSUtil.extractBytesAtOffset(encoded, i3, treeDigestSize);
        int i4 = i3 + treeDigestSize;
        byte[] bArrExtractBytesAtOffset5 = XMSSUtil.extractBytesAtOffset(encoded, i4, encoded.length - i4);
        try {
            C6108BDS c6108bds = (C6108BDS) XMSSUtil.deserialize(bArrExtractBytesAtOffset5, C6108BDS.class);
            return c6108bds.getMaxIndex() != (1 << height) - 1 ? new XMSSPrivateKey(iBytesToXBigEndian, bArrExtractBytesAtOffset, bArrExtractBytesAtOffset2, bArrExtractBytesAtOffset3, bArrExtractBytesAtOffset4, bArrExtractBytesAtOffset5, c6108bds.getMaxIndex()) : new XMSSPrivateKey(iBytesToXBigEndian, bArrExtractBytesAtOffset, bArrExtractBytesAtOffset2, bArrExtractBytesAtOffset3, bArrExtractBytesAtOffset4, bArrExtractBytesAtOffset5);
        } catch (ClassNotFoundException e) {
            throw new IOException("cannot parse BDS: " + e.getMessage());
        }
    }

    private static XMSSMTPrivateKey xmssmtCreateKeyStructure(XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters) throws IOException {
        byte[] encoded = xMSSMTPrivateKeyParameters.getEncoded();
        int treeDigestSize = xMSSMTPrivateKeyParameters.getParameters().getTreeDigestSize();
        int height = xMSSMTPrivateKeyParameters.getParameters().getHeight();
        int i = (height + 7) / 8;
        long jBytesToXBigEndian = (int) XMSSUtil.bytesToXBigEndian(encoded, 0, i);
        if (!XMSSUtil.isIndexValid(height, jBytesToXBigEndian)) {
            throw new IllegalArgumentException("index out of bounds");
        }
        byte[] bArrExtractBytesAtOffset = XMSSUtil.extractBytesAtOffset(encoded, i, treeDigestSize);
        int i2 = i + treeDigestSize;
        byte[] bArrExtractBytesAtOffset2 = XMSSUtil.extractBytesAtOffset(encoded, i2, treeDigestSize);
        int i3 = i2 + treeDigestSize;
        byte[] bArrExtractBytesAtOffset3 = XMSSUtil.extractBytesAtOffset(encoded, i3, treeDigestSize);
        int i4 = i3 + treeDigestSize;
        byte[] bArrExtractBytesAtOffset4 = XMSSUtil.extractBytesAtOffset(encoded, i4, treeDigestSize);
        int i5 = i4 + treeDigestSize;
        byte[] bArrExtractBytesAtOffset5 = XMSSUtil.extractBytesAtOffset(encoded, i5, encoded.length - i5);
        try {
            BDSStateMap bDSStateMap = (BDSStateMap) XMSSUtil.deserialize(bArrExtractBytesAtOffset5, BDSStateMap.class);
            return bDSStateMap.getMaxIndex() != (1 << height) - 1 ? new XMSSMTPrivateKey(jBytesToXBigEndian, bArrExtractBytesAtOffset, bArrExtractBytesAtOffset2, bArrExtractBytesAtOffset3, bArrExtractBytesAtOffset4, bArrExtractBytesAtOffset5, bDSStateMap.getMaxIndex()) : new XMSSMTPrivateKey(jBytesToXBigEndian, bArrExtractBytesAtOffset, bArrExtractBytesAtOffset2, bArrExtractBytesAtOffset3, bArrExtractBytesAtOffset4, bArrExtractBytesAtOffset5);
        } catch (ClassNotFoundException e) {
            throw new IOException("cannot parse BDSStateMap: " + e.getMessage());
        }
    }

    public static PrivateKeyInfo createPrivateKeyInfo(AsymmetricKeyParameter asymmetricKeyParameter, AbstractC5093ASN1Set abstractC5093ASN1Set) throws IOException {
        if (asymmetricKeyParameter instanceof SPHINCSPrivateKeyParameters) {
            SPHINCSPrivateKeyParameters sPHINCSPrivateKeyParameters = (SPHINCSPrivateKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.sphincs256, new SPHINCS256KeyParams(C6107Utils.sphincs256LookupTreeAlgID(sPHINCSPrivateKeyParameters.getTreeDigest()))), new DEROctetString(sPHINCSPrivateKeyParameters.getKeyData()));
        }
        if (asymmetricKeyParameter instanceof NHPrivateKeyParameters) {
            AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(PQCObjectIdentifiers.f23021newHope);
            short[] secData = ((NHPrivateKeyParameters) asymmetricKeyParameter).getSecData();
            byte[] bArr = new byte[secData.length * 2];
            for (int i = 0; i != secData.length; i++) {
                AbstractC6245Pack.shortToLittleEndian(secData[i], bArr, i * 2);
            }
            return new PrivateKeyInfo(algorithmIdentifier, new DEROctetString(bArr));
        }
        if (asymmetricKeyParameter instanceof LMSPrivateKeyParameters) {
            LMSPrivateKeyParameters lMSPrivateKeyParameters = (LMSPrivateKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig), new DEROctetString(Composer.m17598compose().m17609u32str(1).m17601bytes(lMSPrivateKeyParameters).m17600build()), abstractC5093ASN1Set, Composer.m17598compose().m17609u32str(1).m17601bytes(lMSPrivateKeyParameters.getPublicKey()).m17600build());
        }
        if (asymmetricKeyParameter instanceof HSSPrivateKeyParameters) {
            HSSPrivateKeyParameters hSSPrivateKeyParameters = (HSSPrivateKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig), new DEROctetString(Composer.m17598compose().m17609u32str(hSSPrivateKeyParameters.m17614getL()).m17601bytes(hSSPrivateKeyParameters).m17600build()), abstractC5093ASN1Set, Composer.m17598compose().m17609u32str(hSSPrivateKeyParameters.m17614getL()).m17601bytes(hSSPrivateKeyParameters.getPublicKey().getLMSPublicKey()).m17600build());
        }
        if (asymmetricKeyParameter instanceof SPHINCSPlusPrivateKeyParameters) {
            SPHINCSPlusPrivateKeyParameters sPHINCSPlusPrivateKeyParameters = (SPHINCSPlusPrivateKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(C6107Utils.sphincsPlusOidLookup(sPHINCSPlusPrivateKeyParameters.getParameters())), new DEROctetString(sPHINCSPlusPrivateKeyParameters.getEncoded()), abstractC5093ASN1Set, sPHINCSPlusPrivateKeyParameters.getPublicKey());
        }
        if (asymmetricKeyParameter instanceof SLHDSAPrivateKeyParameters) {
            SLHDSAPrivateKeyParameters sLHDSAPrivateKeyParameters = (SLHDSAPrivateKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(C6107Utils.slhdsaOidLookup(sLHDSAPrivateKeyParameters.getParameters())), sLHDSAPrivateKeyParameters.getEncoded(), abstractC5093ASN1Set);
        }
        if (asymmetricKeyParameter instanceof PicnicPrivateKeyParameters) {
            PicnicPrivateKeyParameters picnicPrivateKeyParameters = (PicnicPrivateKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(C6107Utils.picnicOidLookup(picnicPrivateKeyParameters.getParameters())), new DEROctetString(picnicPrivateKeyParameters.getEncoded()), abstractC5093ASN1Set);
        }
        if (asymmetricKeyParameter instanceof CMCEPrivateKeyParameters) {
            CMCEPrivateKeyParameters cMCEPrivateKeyParameters = (CMCEPrivateKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(C6107Utils.mcElieceOidLookup(cMCEPrivateKeyParameters.getParameters())), new CMCEPrivateKey(0, cMCEPrivateKeyParameters.getDelta(), cMCEPrivateKeyParameters.m17501getC(), cMCEPrivateKeyParameters.m17502getG(), cMCEPrivateKeyParameters.getAlpha(), cMCEPrivateKeyParameters.m17503getS(), new CMCEPublicKey(cMCEPrivateKeyParameters.reconstructPublicKey())), abstractC5093ASN1Set);
        }
        if (asymmetricKeyParameter instanceof XMSSPrivateKeyParameters) {
            XMSSPrivateKeyParameters xMSSPrivateKeyParameters = (XMSSPrivateKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.f23024xmss, new XMSSKeyParams(xMSSPrivateKeyParameters.getParameters().getHeight(), C6107Utils.xmssLookupTreeAlgID(xMSSPrivateKeyParameters.getTreeDigest()))), xmssCreateKeyStructure(xMSSPrivateKeyParameters), abstractC5093ASN1Set);
        }
        if (asymmetricKeyParameter instanceof XMSSMTPrivateKeyParameters) {
            XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters = (XMSSMTPrivateKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.f23025xmss_mt, new XMSSMTKeyParams(xMSSMTPrivateKeyParameters.getParameters().getHeight(), xMSSMTPrivateKeyParameters.getParameters().getLayers(), C6107Utils.xmssLookupTreeAlgID(xMSSMTPrivateKeyParameters.getTreeDigest()))), xmssmtCreateKeyStructure(xMSSMTPrivateKeyParameters), abstractC5093ASN1Set);
        }
        if (asymmetricKeyParameter instanceof FrodoPrivateKeyParameters) {
            FrodoPrivateKeyParameters frodoPrivateKeyParameters = (FrodoPrivateKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(C6107Utils.frodoOidLookup(frodoPrivateKeyParameters.getParameters())), new DEROctetString(frodoPrivateKeyParameters.getEncoded()), abstractC5093ASN1Set);
        }
        if (asymmetricKeyParameter instanceof SABERPrivateKeyParameters) {
            SABERPrivateKeyParameters sABERPrivateKeyParameters = (SABERPrivateKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(C6107Utils.saberOidLookup(sABERPrivateKeyParameters.getParameters())), new DEROctetString(sABERPrivateKeyParameters.getEncoded()), abstractC5093ASN1Set);
        }
        if (asymmetricKeyParameter instanceof NTRUPrivateKeyParameters) {
            NTRUPrivateKeyParameters nTRUPrivateKeyParameters = (NTRUPrivateKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(C6107Utils.ntruOidLookup(nTRUPrivateKeyParameters.getParameters())), new DEROctetString(nTRUPrivateKeyParameters.getEncoded()), abstractC5093ASN1Set);
        }
        if (asymmetricKeyParameter instanceof FalconPrivateKeyParameters) {
            FalconPrivateKeyParameters falconPrivateKeyParameters = (FalconPrivateKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(C6107Utils.falconOidLookup(falconPrivateKeyParameters.getParameters())), new FalconPrivateKey(0, falconPrivateKeyParameters.getSpolyf(), falconPrivateKeyParameters.m17550getG(), falconPrivateKeyParameters.getSpolyF(), new FalconPublicKey(falconPrivateKeyParameters.getPublicKey())), abstractC5093ASN1Set);
        }
        if (asymmetricKeyParameter instanceof MLKEMPrivateKeyParameters) {
            MLKEMPrivateKeyParameters mLKEMPrivateKeyParameters = (MLKEMPrivateKeyParameters) asymmetricKeyParameter;
            AlgorithmIdentifier algorithmIdentifier2 = new AlgorithmIdentifier(C6107Utils.mlkemOidLookup(mLKEMPrivateKeyParameters.getParameters()));
            return mLKEMPrivateKeyParameters.getPreferredFormat() == 1 ? new PrivateKeyInfo(algorithmIdentifier2, new DERTaggedObject(false, 0, (ASN1Encodable) new DEROctetString(mLKEMPrivateKeyParameters.m17715getSeed())), abstractC5093ASN1Set) : mLKEMPrivateKeyParameters.getPreferredFormat() == 2 ? new PrivateKeyInfo(algorithmIdentifier2, new DEROctetString(mLKEMPrivateKeyParameters.getEncoded()), abstractC5093ASN1Set) : new PrivateKeyInfo(algorithmIdentifier2, getBasicPQCEncoding(mLKEMPrivateKeyParameters.m17715getSeed(), mLKEMPrivateKeyParameters.getEncoded()), abstractC5093ASN1Set);
        }
        if (asymmetricKeyParameter instanceof NTRULPRimePrivateKeyParameters) {
            NTRULPRimePrivateKeyParameters nTRULPRimePrivateKeyParameters = (NTRULPRimePrivateKeyParameters) asymmetricKeyParameter;
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            aSN1EncodableVector.m14420add(new DEROctetString(nTRULPRimePrivateKeyParameters.m17784getEnca()));
            aSN1EncodableVector.m14420add(new DEROctetString(nTRULPRimePrivateKeyParameters.m17786getPk()));
            aSN1EncodableVector.m14420add(new DEROctetString(nTRULPRimePrivateKeyParameters.m17787getRho()));
            aSN1EncodableVector.m14420add(new DEROctetString(nTRULPRimePrivateKeyParameters.m17785getHash()));
            return new PrivateKeyInfo(new AlgorithmIdentifier(C6107Utils.ntrulprimeOidLookup(nTRULPRimePrivateKeyParameters.getParameters())), new DERSequence(aSN1EncodableVector), abstractC5093ASN1Set);
        }
        if (asymmetricKeyParameter instanceof SNTRUPrimePrivateKeyParameters) {
            SNTRUPrimePrivateKeyParameters sNTRUPrimePrivateKeyParameters = (SNTRUPrimePrivateKeyParameters) asymmetricKeyParameter;
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            aSN1EncodableVector2.m14420add(new DEROctetString(sNTRUPrimePrivateKeyParameters.m17793getF()));
            aSN1EncodableVector2.m14420add(new DEROctetString(sNTRUPrimePrivateKeyParameters.m17794getGinv()));
            aSN1EncodableVector2.m14420add(new DEROctetString(sNTRUPrimePrivateKeyParameters.m17796getPk()));
            aSN1EncodableVector2.m14420add(new DEROctetString(sNTRUPrimePrivateKeyParameters.m17797getRho()));
            aSN1EncodableVector2.m14420add(new DEROctetString(sNTRUPrimePrivateKeyParameters.m17795getHash()));
            return new PrivateKeyInfo(new AlgorithmIdentifier(C6107Utils.sntruprimeOidLookup(sNTRUPrimePrivateKeyParameters.getParameters())), new DERSequence(aSN1EncodableVector2), abstractC5093ASN1Set);
        }
        if (asymmetricKeyParameter instanceof MLDSAPrivateKeyParameters) {
            MLDSAPrivateKeyParameters mLDSAPrivateKeyParameters = (MLDSAPrivateKeyParameters) asymmetricKeyParameter;
            AlgorithmIdentifier algorithmIdentifier3 = new AlgorithmIdentifier(C6107Utils.mldsaOidLookup(mLDSAPrivateKeyParameters.getParameters()));
            return mLDSAPrivateKeyParameters.getPreferredFormat() == 1 ? new PrivateKeyInfo(algorithmIdentifier3, new DERTaggedObject(false, 0, (ASN1Encodable) new DEROctetString(mLDSAPrivateKeyParameters.m17681getSeed())), abstractC5093ASN1Set) : mLDSAPrivateKeyParameters.getPreferredFormat() == 2 ? new PrivateKeyInfo(algorithmIdentifier3, new DEROctetString(mLDSAPrivateKeyParameters.getEncoded()), abstractC5093ASN1Set) : new PrivateKeyInfo(algorithmIdentifier3, getBasicPQCEncoding(mLDSAPrivateKeyParameters.m17681getSeed(), mLDSAPrivateKeyParameters.getEncoded()), abstractC5093ASN1Set);
        }
        if (asymmetricKeyParameter instanceof DilithiumPrivateKeyParameters) {
            DilithiumPrivateKeyParameters dilithiumPrivateKeyParameters = (DilithiumPrivateKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(C6107Utils.dilithiumOidLookup(dilithiumPrivateKeyParameters.getParameters())), new DEROctetString(dilithiumPrivateKeyParameters.getEncoded()), abstractC5093ASN1Set, dilithiumPrivateKeyParameters.getPublicKeyParameters().getEncoded());
        }
        if (asymmetricKeyParameter instanceof BIKEPrivateKeyParameters) {
            BIKEPrivateKeyParameters bIKEPrivateKeyParameters = (BIKEPrivateKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(C6107Utils.bikeOidLookup(bIKEPrivateKeyParameters.getParameters())), new DEROctetString(bIKEPrivateKeyParameters.getEncoded()), abstractC5093ASN1Set);
        }
        if (asymmetricKeyParameter instanceof HQCPrivateKeyParameters) {
            HQCPrivateKeyParameters hQCPrivateKeyParameters = (HQCPrivateKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(C6107Utils.hqcOidLookup(hQCPrivateKeyParameters.getParameters())), new DEROctetString(hQCPrivateKeyParameters.getEncoded()), abstractC5093ASN1Set);
        }
        if (asymmetricKeyParameter instanceof RainbowPrivateKeyParameters) {
            RainbowPrivateKeyParameters rainbowPrivateKeyParameters = (RainbowPrivateKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(C6107Utils.rainbowOidLookup(rainbowPrivateKeyParameters.getParameters())), new DEROctetString(rainbowPrivateKeyParameters.getEncoded()), abstractC5093ASN1Set);
        }
        if (asymmetricKeyParameter instanceof MayoPrivateKeyParameters) {
            MayoPrivateKeyParameters mayoPrivateKeyParameters = (MayoPrivateKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(C6107Utils.mayoOidLookup(mayoPrivateKeyParameters.getParameters())), new DEROctetString(mayoPrivateKeyParameters.getEncoded()), abstractC5093ASN1Set);
        }
        if (asymmetricKeyParameter instanceof SnovaPrivateKeyParameters) {
            SnovaPrivateKeyParameters snovaPrivateKeyParameters = (SnovaPrivateKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(C6107Utils.snovaOidLookup(snovaPrivateKeyParameters.getParameters())), new DEROctetString(snovaPrivateKeyParameters.getEncoded()), abstractC5093ASN1Set);
        }
        if (!(asymmetricKeyParameter instanceof NTRUPlusPrivateKeyParameters)) {
            throw new IOException("key parameters not recognized");
        }
        NTRUPlusPrivateKeyParameters nTRUPlusPrivateKeyParameters = (NTRUPlusPrivateKeyParameters) asymmetricKeyParameter;
        return new PrivateKeyInfo(new AlgorithmIdentifier(C6107Utils.ntruPlusOidLookup(nTRUPlusPrivateKeyParameters.getParameters())), new DEROctetString(nTRUPlusPrivateKeyParameters.getEncoded()), abstractC5093ASN1Set);
    }
}
