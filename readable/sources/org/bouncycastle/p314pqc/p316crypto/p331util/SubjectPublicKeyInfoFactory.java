package org.bouncycastle.p314pqc.p316crypto.p331util;

import java.io.IOException;
import org.bouncycastle.internal.p231asn1.p238isara.IsaraObjectIdentifiers;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p314pqc.p315asn1.PQCObjectIdentifiers;
import org.bouncycastle.p314pqc.p315asn1.SPHINCS256KeyParams;
import org.bouncycastle.p314pqc.p315asn1.XMSSKeyParams;
import org.bouncycastle.p314pqc.p315asn1.XMSSMTKeyParams;
import org.bouncycastle.p314pqc.p315asn1.XMSSMTPublicKey;
import org.bouncycastle.p314pqc.p315asn1.XMSSPublicKey;
import org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.DilithiumPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruplus.NTRUPlusPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.NTRULPRimePublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.SNTRUPrimePublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p317cmce.CMCEPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p318falcon.FalconPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p319frodo.FrodoPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p320hqc.HQCPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.Composer;
import org.bouncycastle.p314pqc.p316crypto.p321lms.HSSPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.LMSPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p322mayo.MayoPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p323mldsa.MLDSAPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p324mlkem.MLKEMPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p325newhope.NHPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p326ntru.NTRUPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p327saber.SABERPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p328slhdsa.SLHDSAPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p329snova.SnovaPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p330sphincs.SPHINCSPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSMTPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSPublicKeyParameters;
import org.bouncycastle.p314pqc.p352legacy.p353bike.BIKEPublicKeyParameters;
import org.bouncycastle.p314pqc.p352legacy.p354picnic.PicnicPublicKeyParameters;
import org.bouncycastle.p314pqc.p352legacy.p355rainbow.RainbowPublicKeyParameters;
import org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusPublicKeyParameters;

/* loaded from: classes2.dex */
public class SubjectPublicKeyInfoFactory {
    private SubjectPublicKeyInfoFactory() {
    }

    public static SubjectPublicKeyInfo createSubjectPublicKeyInfo(AsymmetricKeyParameter asymmetricKeyParameter) throws IOException {
        if (asymmetricKeyParameter instanceof SPHINCSPublicKeyParameters) {
            SPHINCSPublicKeyParameters sPHINCSPublicKeyParameters = (SPHINCSPublicKeyParameters) asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.sphincs256, new SPHINCS256KeyParams(C6107Utils.sphincs256LookupTreeAlgID(sPHINCSPublicKeyParameters.getTreeDigest()))), sPHINCSPublicKeyParameters.getKeyData());
        }
        if (asymmetricKeyParameter instanceof NHPublicKeyParameters) {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.f23021newHope), ((NHPublicKeyParameters) asymmetricKeyParameter).getPubData());
        }
        if (asymmetricKeyParameter instanceof LMSPublicKeyParameters) {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig), Composer.m17598compose().m17609u32str(1).m17601bytes((LMSPublicKeyParameters) asymmetricKeyParameter).m17600build());
        }
        if (asymmetricKeyParameter instanceof HSSPublicKeyParameters) {
            HSSPublicKeyParameters hSSPublicKeyParameters = (HSSPublicKeyParameters) asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig), Composer.m17598compose().m17609u32str(hSSPublicKeyParameters.m17618getL()).m17601bytes(hSSPublicKeyParameters.getLMSPublicKey()).m17600build());
        }
        if (asymmetricKeyParameter instanceof SLHDSAPublicKeyParameters) {
            SLHDSAPublicKeyParameters sLHDSAPublicKeyParameters = (SLHDSAPublicKeyParameters) asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(C6107Utils.slhdsaOidLookup(sLHDSAPublicKeyParameters.getParameters())), sLHDSAPublicKeyParameters.getEncoded());
        }
        if (asymmetricKeyParameter instanceof SPHINCSPlusPublicKeyParameters) {
            SPHINCSPlusPublicKeyParameters sPHINCSPlusPublicKeyParameters = (SPHINCSPlusPublicKeyParameters) asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(C6107Utils.sphincsPlusOidLookup(sPHINCSPlusPublicKeyParameters.getParameters())), sPHINCSPlusPublicKeyParameters.getEncoded());
        }
        if (asymmetricKeyParameter instanceof CMCEPublicKeyParameters) {
            CMCEPublicKeyParameters cMCEPublicKeyParameters = (CMCEPublicKeyParameters) asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(C6107Utils.mcElieceOidLookup(cMCEPublicKeyParameters.getParameters())), cMCEPublicKeyParameters.getEncoded());
        }
        if (asymmetricKeyParameter instanceof XMSSPublicKeyParameters) {
            XMSSPublicKeyParameters xMSSPublicKeyParameters = (XMSSPublicKeyParameters) asymmetricKeyParameter;
            byte[] publicSeed = xMSSPublicKeyParameters.getPublicSeed();
            byte[] bArrM17928getRoot = xMSSPublicKeyParameters.m17928getRoot();
            byte[] encoded = xMSSPublicKeyParameters.getEncoded();
            return encoded.length > publicSeed.length + bArrM17928getRoot.length ? new SubjectPublicKeyInfo(new AlgorithmIdentifier(IsaraObjectIdentifiers.id_alg_xmss), new DEROctetString(encoded)) : new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.f23024xmss, new XMSSKeyParams(xMSSPublicKeyParameters.getParameters().getHeight(), C6107Utils.xmssLookupTreeAlgID(xMSSPublicKeyParameters.getTreeDigest()))), new XMSSPublicKey(publicSeed, bArrM17928getRoot));
        }
        if (asymmetricKeyParameter instanceof XMSSMTPublicKeyParameters) {
            XMSSMTPublicKeyParameters xMSSMTPublicKeyParameters = (XMSSMTPublicKeyParameters) asymmetricKeyParameter;
            byte[] publicSeed2 = xMSSMTPublicKeyParameters.getPublicSeed();
            byte[] bArrM17918getRoot = xMSSMTPublicKeyParameters.m17918getRoot();
            byte[] encoded2 = xMSSMTPublicKeyParameters.getEncoded();
            return encoded2.length > publicSeed2.length + bArrM17918getRoot.length ? new SubjectPublicKeyInfo(new AlgorithmIdentifier(IsaraObjectIdentifiers.id_alg_xmssmt), new DEROctetString(encoded2)) : new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.f23025xmss_mt, new XMSSMTKeyParams(xMSSMTPublicKeyParameters.getParameters().getHeight(), xMSSMTPublicKeyParameters.getParameters().getLayers(), C6107Utils.xmssLookupTreeAlgID(xMSSMTPublicKeyParameters.getTreeDigest()))), new XMSSMTPublicKey(xMSSMTPublicKeyParameters.getPublicSeed(), xMSSMTPublicKeyParameters.m17918getRoot()));
        }
        if (asymmetricKeyParameter instanceof FrodoPublicKeyParameters) {
            FrodoPublicKeyParameters frodoPublicKeyParameters = (FrodoPublicKeyParameters) asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(C6107Utils.frodoOidLookup(frodoPublicKeyParameters.getParameters())), new DEROctetString(frodoPublicKeyParameters.getEncoded()));
        }
        if (asymmetricKeyParameter instanceof SABERPublicKeyParameters) {
            SABERPublicKeyParameters sABERPublicKeyParameters = (SABERPublicKeyParameters) asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(C6107Utils.saberOidLookup(sABERPublicKeyParameters.getParameters())), new DERSequence(new DEROctetString(sABERPublicKeyParameters.getEncoded())));
        }
        if (asymmetricKeyParameter instanceof PicnicPublicKeyParameters) {
            PicnicPublicKeyParameters picnicPublicKeyParameters = (PicnicPublicKeyParameters) asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(C6107Utils.picnicOidLookup(picnicPublicKeyParameters.getParameters())), new DEROctetString(picnicPublicKeyParameters.getEncoded()));
        }
        if (asymmetricKeyParameter instanceof NTRUPublicKeyParameters) {
            NTRUPublicKeyParameters nTRUPublicKeyParameters = (NTRUPublicKeyParameters) asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(C6107Utils.ntruOidLookup(nTRUPublicKeyParameters.getParameters())), nTRUPublicKeyParameters.getEncoded());
        }
        if (asymmetricKeyParameter instanceof FalconPublicKeyParameters) {
            FalconPublicKeyParameters falconPublicKeyParameters = (FalconPublicKeyParameters) asymmetricKeyParameter;
            byte[] bArrM17551getH = falconPublicKeyParameters.m17551getH();
            AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(C6107Utils.falconOidLookup(falconPublicKeyParameters.getParameters()));
            byte[] bArr = new byte[bArrM17551getH.length + 1];
            bArr[0] = (byte) falconPublicKeyParameters.getParameters().m17548getLogN();
            System.arraycopy(bArrM17551getH, 0, bArr, 1, bArrM17551getH.length);
            return new SubjectPublicKeyInfo(algorithmIdentifier, bArr);
        }
        if (asymmetricKeyParameter instanceof MLKEMPublicKeyParameters) {
            MLKEMPublicKeyParameters mLKEMPublicKeyParameters = (MLKEMPublicKeyParameters) asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(C6107Utils.mlkemOidLookup(mLKEMPublicKeyParameters.getParameters())), mLKEMPublicKeyParameters.getEncoded());
        }
        if (asymmetricKeyParameter instanceof NTRULPRimePublicKeyParameters) {
            NTRULPRimePublicKeyParameters nTRULPRimePublicKeyParameters = (NTRULPRimePublicKeyParameters) asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(C6107Utils.ntrulprimeOidLookup(nTRULPRimePublicKeyParameters.getParameters())), new DEROctetString(nTRULPRimePublicKeyParameters.getEncoded()));
        }
        if (asymmetricKeyParameter instanceof SNTRUPrimePublicKeyParameters) {
            SNTRUPrimePublicKeyParameters sNTRUPrimePublicKeyParameters = (SNTRUPrimePublicKeyParameters) asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(C6107Utils.sntruprimeOidLookup(sNTRUPrimePublicKeyParameters.getParameters())), new DEROctetString(sNTRUPrimePublicKeyParameters.getEncoded()));
        }
        if (asymmetricKeyParameter instanceof DilithiumPublicKeyParameters) {
            DilithiumPublicKeyParameters dilithiumPublicKeyParameters = (DilithiumPublicKeyParameters) asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(C6107Utils.dilithiumOidLookup(dilithiumPublicKeyParameters.getParameters())), dilithiumPublicKeyParameters.getEncoded());
        }
        if (asymmetricKeyParameter instanceof MLDSAPublicKeyParameters) {
            MLDSAPublicKeyParameters mLDSAPublicKeyParameters = (MLDSAPublicKeyParameters) asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(C6107Utils.mldsaOidLookup(mLDSAPublicKeyParameters.getParameters())), mLDSAPublicKeyParameters.getEncoded());
        }
        if (asymmetricKeyParameter instanceof BIKEPublicKeyParameters) {
            BIKEPublicKeyParameters bIKEPublicKeyParameters = (BIKEPublicKeyParameters) asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(C6107Utils.bikeOidLookup(bIKEPublicKeyParameters.getParameters())), bIKEPublicKeyParameters.getEncoded());
        }
        if (asymmetricKeyParameter instanceof HQCPublicKeyParameters) {
            HQCPublicKeyParameters hQCPublicKeyParameters = (HQCPublicKeyParameters) asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(C6107Utils.hqcOidLookup(hQCPublicKeyParameters.getParameters())), hQCPublicKeyParameters.getEncoded());
        }
        if (asymmetricKeyParameter instanceof RainbowPublicKeyParameters) {
            RainbowPublicKeyParameters rainbowPublicKeyParameters = (RainbowPublicKeyParameters) asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(C6107Utils.rainbowOidLookup(rainbowPublicKeyParameters.getParameters())), new DEROctetString(rainbowPublicKeyParameters.getEncoded()));
        }
        if (asymmetricKeyParameter instanceof MayoPublicKeyParameters) {
            MayoPublicKeyParameters mayoPublicKeyParameters = (MayoPublicKeyParameters) asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(C6107Utils.mayoOidLookup(mayoPublicKeyParameters.getParameters())), new DEROctetString(mayoPublicKeyParameters.getEncoded()));
        }
        if (asymmetricKeyParameter instanceof SnovaPublicKeyParameters) {
            SnovaPublicKeyParameters snovaPublicKeyParameters = (SnovaPublicKeyParameters) asymmetricKeyParameter;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(C6107Utils.snovaOidLookup(snovaPublicKeyParameters.getParameters())), new DEROctetString(snovaPublicKeyParameters.getEncoded()));
        }
        if (!(asymmetricKeyParameter instanceof NTRUPlusPublicKeyParameters)) {
            throw new IOException("key parameters not recognized");
        }
        NTRUPlusPublicKeyParameters nTRUPlusPublicKeyParameters = (NTRUPlusPublicKeyParameters) asymmetricKeyParameter;
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(C6107Utils.ntruPlusOidLookup(nTRUPlusPublicKeyParameters.getParameters())), new DEROctetString(nTRUPlusPublicKeyParameters.getEncoded()));
    }
}
