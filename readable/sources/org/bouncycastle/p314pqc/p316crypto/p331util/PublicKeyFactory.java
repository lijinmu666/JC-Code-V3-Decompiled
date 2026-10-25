package org.bouncycastle.p314pqc.p316crypto.p331util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.internal.p231asn1.p238isara.IsaraObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.p135bc.BCObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p314pqc.p315asn1.CMCEPublicKey;
import org.bouncycastle.p314pqc.p315asn1.PQCObjectIdentifiers;
import org.bouncycastle.p314pqc.p315asn1.SPHINCS256KeyParams;
import org.bouncycastle.p314pqc.p315asn1.XMSSKeyParams;
import org.bouncycastle.p314pqc.p315asn1.XMSSMTKeyParams;
import org.bouncycastle.p314pqc.p315asn1.XMSSPublicKey;
import org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.DilithiumParameters;
import org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.DilithiumPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruplus.NTRUPlusPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.NTRULPRimePublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.SNTRUPrimePublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p317cmce.CMCEPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p318falcon.FalconPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p319frodo.FrodoPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p320hqc.HQCPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.HSSPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.LMSKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p322mayo.MayoPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p323mldsa.MLDSAParameters;
import org.bouncycastle.p314pqc.p316crypto.p323mldsa.MLDSAPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p324mlkem.MLKEMParameters;
import org.bouncycastle.p314pqc.p316crypto.p324mlkem.MLKEMPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p325newhope.NHPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p326ntru.NTRUPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p327saber.SABERPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p328slhdsa.SLHDSAPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p329snova.SnovaPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p330sphincs.SPHINCSPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSMTParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSMTPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSPublicKeyParameters;
import org.bouncycastle.p314pqc.p352legacy.p353bike.BIKEPublicKeyParameters;
import org.bouncycastle.p314pqc.p352legacy.p354picnic.PicnicPublicKeyParameters;
import org.bouncycastle.p314pqc.p352legacy.p355rainbow.RainbowPublicKeyParameters;
import org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusPublicKeyParameters;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class PublicKeyFactory {
    private static Map converters;

    public static class BIKEConverter extends SubjectPublicKeyInfoConverter {
        private BIKEConverter() {
            super();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            try {
                return new BIKEPublicKeyParameters(C6107Utils.bikeParamsLookup(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()), ASN1OctetString.getInstance(subjectPublicKeyInfo.parsePublicKey()).getOctets());
            } catch (Exception unused) {
                return new BIKEPublicKeyParameters(C6107Utils.bikeParamsLookup(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()), subjectPublicKeyInfo.getPublicKeyData().getOctets());
            }
        }
    }

    public static class CMCEConverter extends SubjectPublicKeyInfoConverter {
        private CMCEConverter() {
            super();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            try {
                return new CMCEPublicKeyParameters(C6107Utils.mcElieceParamsLookup(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()), CMCEPublicKey.getInstance(subjectPublicKeyInfo.parsePublicKey()).m17463getT());
            } catch (Exception unused) {
                return new CMCEPublicKeyParameters(C6107Utils.mcElieceParamsLookup(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()), subjectPublicKeyInfo.getPublicKeyData().getOctets());
            }
        }
    }

    public static class DilithiumConverter extends SubjectPublicKeyInfoConverter {
        public DilithiumConverter() {
            super();
        }

        public static DilithiumPublicKeyParameters getPublicKeyParams(DilithiumParameters dilithiumParameters, ASN1BitString aSN1BitString) {
            try {
                ASN1Primitive aSN1PrimitiveFromByteArray = ASN1Primitive.fromByteArray(aSN1BitString.getOctets());
                if (!(aSN1PrimitiveFromByteArray instanceof ASN1Sequence)) {
                    return new DilithiumPublicKeyParameters(dilithiumParameters, ASN1OctetString.getInstance(aSN1PrimitiveFromByteArray).getOctets());
                }
                ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(aSN1PrimitiveFromByteArray);
                return new DilithiumPublicKeyParameters(dilithiumParameters, ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0)).getOctets(), ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets());
            } catch (Exception unused) {
                return new DilithiumPublicKeyParameters(dilithiumParameters, aSN1BitString.getOctets());
            }
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            return getPublicKeyParams(C6107Utils.dilithiumParamsLookup(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()), subjectPublicKeyInfo.getPublicKeyData());
        }
    }

    public static class FalconConverter extends SubjectPublicKeyInfoConverter {
        private FalconConverter() {
            super();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            byte[] octets = subjectPublicKeyInfo.getPublicKeyData().getOctets();
            return new FalconPublicKeyParameters(C6107Utils.falconParamsLookup(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()), C6238Arrays.copyOfRange(octets, 1, octets.length));
        }
    }

    public static class FrodoConverter extends SubjectPublicKeyInfoConverter {
        private FrodoConverter() {
            super();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            return new FrodoPublicKeyParameters(C6107Utils.frodoParamsLookup(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()), ASN1OctetString.getInstance(subjectPublicKeyInfo.parsePublicKey()).getOctets());
        }
    }

    public static class HQCConverter extends SubjectPublicKeyInfoConverter {
        private HQCConverter() {
            super();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            try {
                return new HQCPublicKeyParameters(C6107Utils.hqcParamsLookup(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()), ASN1OctetString.getInstance(subjectPublicKeyInfo.parsePublicKey()).getOctets());
            } catch (Exception unused) {
                return new HQCPublicKeyParameters(C6107Utils.hqcParamsLookup(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()), subjectPublicKeyInfo.getPublicKeyData().getOctets());
            }
        }
    }

    public static class LMSConverter extends SubjectPublicKeyInfoConverter {
        private LMSConverter() {
            super();
        }

        private LMSKeyParameters getLmsKeyParameters(byte[] bArr) {
            return HSSPublicKeyParameters.getInstance(bArr);
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            byte[] octets = subjectPublicKeyInfo.getPublicKeyData().getOctets();
            ASN1OctetString aSN1OctetString = (ASN1OctetString) C6107Utils.parseData(octets);
            return aSN1OctetString != null ? getLmsKeyParameters(aSN1OctetString.getOctets()) : getLmsKeyParameters(octets);
        }
    }

    public static class MLDSAConverter extends SubjectPublicKeyInfoConverter {
        public MLDSAConverter() {
            super();
        }

        public static MLDSAPublicKeyParameters getPublicKeyParams(MLDSAParameters mLDSAParameters, ASN1BitString aSN1BitString) {
            try {
                ASN1Primitive aSN1PrimitiveFromByteArray = ASN1Primitive.fromByteArray(aSN1BitString.getOctets());
                if (!(aSN1PrimitiveFromByteArray instanceof ASN1Sequence)) {
                    return new MLDSAPublicKeyParameters(mLDSAParameters, ASN1OctetString.getInstance(aSN1PrimitiveFromByteArray).getOctets());
                }
                ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(aSN1PrimitiveFromByteArray);
                return new MLDSAPublicKeyParameters(mLDSAParameters, ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0)).getOctets(), ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets());
            } catch (Exception unused) {
                return new MLDSAPublicKeyParameters(mLDSAParameters, aSN1BitString.getOctets());
            }
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            return getPublicKeyParams(C6107Utils.mldsaParamsLookup(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()), subjectPublicKeyInfo.getPublicKeyData());
        }
    }

    public static class MLKEMConverter extends SubjectPublicKeyInfoConverter {
        public MLKEMConverter() {
            super();
        }

        public static MLKEMPublicKeyParameters getPublicKeyParams(MLKEMParameters mLKEMParameters, ASN1BitString aSN1BitString) {
            try {
                ASN1Primitive aSN1PrimitiveFromByteArray = ASN1Primitive.fromByteArray(aSN1BitString.getOctets());
                if (!(aSN1PrimitiveFromByteArray instanceof ASN1Sequence)) {
                    return new MLKEMPublicKeyParameters(mLKEMParameters, ASN1OctetString.getInstance(aSN1PrimitiveFromByteArray).getOctets());
                }
                ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(aSN1PrimitiveFromByteArray);
                return new MLKEMPublicKeyParameters(mLKEMParameters, ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0)).getOctets(), ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets());
            } catch (Exception unused) {
                return new MLKEMPublicKeyParameters(mLKEMParameters, aSN1BitString.getOctets());
            }
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            return new MLKEMPublicKeyParameters(C6107Utils.mlkemParamsLookup(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()), subjectPublicKeyInfo.getPublicKeyData().getOctets());
        }
    }

    public static class MayoConverter extends SubjectPublicKeyInfoConverter {
        private MayoConverter() {
            super();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            return new MayoPublicKeyParameters(C6107Utils.mayoParamsLookup(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()), ASN1OctetString.getInstance(subjectPublicKeyInfo.parsePublicKey()).getOctets());
        }
    }

    public static class NHConverter extends SubjectPublicKeyInfoConverter {
        private NHConverter() {
            super();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            return new NHPublicKeyParameters(subjectPublicKeyInfo.getPublicKeyData().getBytes());
        }
    }

    public static class NTRULPrimeConverter extends SubjectPublicKeyInfoConverter {
        private NTRULPrimeConverter() {
            super();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            return new NTRULPRimePublicKeyParameters(C6107Utils.ntrulprimeParamsLookup(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()), ASN1OctetString.getInstance(subjectPublicKeyInfo.parsePublicKey()).getOctets());
        }
    }

    public static class NTRUPlusConverter extends SubjectPublicKeyInfoConverter {
        private NTRUPlusConverter() {
            super();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            return new NTRUPlusPublicKeyParameters(C6107Utils.ntruPlusParamsLookup(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()), ASN1OctetString.getInstance(subjectPublicKeyInfo.parsePublicKey()).getOctets());
        }
    }

    public static class NtruConverter extends SubjectPublicKeyInfoConverter {
        private NtruConverter() {
            super();
        }

        private NTRUPublicKeyParameters getNtruPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, byte[] bArr) {
            return new NTRUPublicKeyParameters(C6107Utils.ntruParamsLookup(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()), bArr);
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            byte[] octets = subjectPublicKeyInfo.getPublicKeyData().getOctets();
            ASN1OctetString octetData = C6107Utils.parseOctetData(octets);
            return octetData != null ? getNtruPublicKeyParameters(subjectPublicKeyInfo, octetData.getOctets()) : getNtruPublicKeyParameters(subjectPublicKeyInfo, octets);
        }
    }

    public static class PicnicConverter extends SubjectPublicKeyInfoConverter {
        private PicnicConverter() {
            super();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            return new PicnicPublicKeyParameters(C6107Utils.picnicParamsLookup(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()), ASN1OctetString.getInstance(subjectPublicKeyInfo.parsePublicKey()).getOctets());
        }
    }

    public static class RainbowConverter extends SubjectPublicKeyInfoConverter {
        private RainbowConverter() {
            super();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            return new RainbowPublicKeyParameters(C6107Utils.rainbowParamsLookup(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()), ASN1OctetString.getInstance(subjectPublicKeyInfo.parsePublicKey()).getOctets());
        }
    }

    public static class SABERConverter extends SubjectPublicKeyInfoConverter {
        private SABERConverter() {
            super();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            return new SABERPublicKeyParameters(C6107Utils.saberParamsLookup(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()), ASN1OctetString.getInstance(ASN1Sequence.getInstance(subjectPublicKeyInfo.parsePublicKey()).getObjectAt(0)).getOctets());
        }
    }

    public static class SLHDSAConverter extends SubjectPublicKeyInfoConverter {
        private SLHDSAConverter() {
            super();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            try {
                byte[] octets = ASN1OctetString.getInstance(subjectPublicKeyInfo.parsePublicKey()).getOctets();
                return new SLHDSAPublicKeyParameters(C6107Utils.slhdsaParamsLookup(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()), C6238Arrays.copyOfRange(octets, 4, octets.length));
            } catch (Exception unused) {
                return new SLHDSAPublicKeyParameters(C6107Utils.slhdsaParamsLookup(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()), subjectPublicKeyInfo.getPublicKeyData().getOctets());
            }
        }
    }

    public static class SNTRUPrimeConverter extends SubjectPublicKeyInfoConverter {
        private SNTRUPrimeConverter() {
            super();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            return new SNTRUPrimePublicKeyParameters(C6107Utils.sntruprimeParamsLookup(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()), ASN1OctetString.getInstance(subjectPublicKeyInfo.parsePublicKey()).getOctets());
        }
    }

    public static class SPHINCSConverter extends SubjectPublicKeyInfoConverter {
        private SPHINCSConverter() {
            super();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            return new SPHINCSPublicKeyParameters(subjectPublicKeyInfo.getPublicKeyData().getBytes(), C6107Utils.sphincs256LookupTreeAlgName(SPHINCS256KeyParams.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters())));
        }
    }

    public static class SPHINCSPlusConverter extends SubjectPublicKeyInfoConverter {
        private SPHINCSPlusConverter() {
            super();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            try {
                byte[] octets = ASN1OctetString.getInstance(subjectPublicKeyInfo.parsePublicKey()).getOctets();
                return new SPHINCSPlusPublicKeyParameters(C6107Utils.sphincsPlusParamsLookup(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()), C6238Arrays.copyOfRange(octets, 4, octets.length));
            } catch (Exception unused) {
                return new SPHINCSPlusPublicKeyParameters(C6107Utils.sphincsPlusParamsLookup(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()), subjectPublicKeyInfo.getPublicKeyData().getOctets());
            }
        }
    }

    public static class SnovaConverter extends SubjectPublicKeyInfoConverter {
        private SnovaConverter() {
            super();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            return new SnovaPublicKeyParameters(C6107Utils.snovaParamsLookup(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()), ASN1OctetString.getInstance(subjectPublicKeyInfo.parsePublicKey()).getOctets());
        }
    }

    public static abstract class SubjectPublicKeyInfoConverter {
        private SubjectPublicKeyInfoConverter() {
        }

        public abstract AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj);
    }

    public static class XMSSConverter extends SubjectPublicKeyInfoConverter {
        private XMSSConverter() {
            super();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            XMSSPublicKeyParameters.C6128Builder c6128BuilderWithPublicKey;
            XMSSKeyParams xMSSKeyParams = XMSSKeyParams.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
            if (xMSSKeyParams != null) {
                ASN1ObjectIdentifier algorithm = xMSSKeyParams.getTreeDigest().getAlgorithm();
                XMSSPublicKey xMSSPublicKey = XMSSPublicKey.getInstance(subjectPublicKeyInfo.parsePublicKey());
                c6128BuilderWithPublicKey = new XMSSPublicKeyParameters.C6128Builder(new XMSSParameters(xMSSKeyParams.getHeight(), C6107Utils.getDigest(algorithm))).withPublicSeed(xMSSPublicKey.getPublicSeed()).withRoot(xMSSPublicKey.m17479getRoot());
            } else {
                byte[] octets = ASN1OctetString.getInstance(subjectPublicKeyInfo.parsePublicKey()).getOctets();
                c6128BuilderWithPublicKey = new XMSSPublicKeyParameters.C6128Builder(XMSSParameters.lookupByOID(AbstractC6245Pack.bigEndianToInt(octets, 0))).withPublicKey(octets);
            }
            return c6128BuilderWithPublicKey.m17929build();
        }
    }

    public static class XMSSMTConverter extends SubjectPublicKeyInfoConverter {
        private XMSSMTConverter() {
            super();
        }

        @Override // org.bouncycastle.pqc.crypto.util.PublicKeyFactory.SubjectPublicKeyInfoConverter
        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            XMSSMTPublicKeyParameters.C6121Builder c6121BuilderWithPublicKey;
            XMSSMTKeyParams xMSSMTKeyParams = XMSSMTKeyParams.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
            if (xMSSMTKeyParams != null) {
                ASN1ObjectIdentifier algorithm = xMSSMTKeyParams.getTreeDigest().getAlgorithm();
                XMSSPublicKey xMSSPublicKey = XMSSPublicKey.getInstance(subjectPublicKeyInfo.parsePublicKey());
                c6121BuilderWithPublicKey = new XMSSMTPublicKeyParameters.C6121Builder(new XMSSMTParameters(xMSSMTKeyParams.getHeight(), xMSSMTKeyParams.getLayers(), C6107Utils.getDigest(algorithm))).withPublicSeed(xMSSPublicKey.getPublicSeed()).withRoot(xMSSPublicKey.m17479getRoot());
            } else {
                byte[] octets = ASN1OctetString.getInstance(subjectPublicKeyInfo.parsePublicKey()).getOctets();
                c6121BuilderWithPublicKey = new XMSSMTPublicKeyParameters.C6121Builder(XMSSMTParameters.lookupByOID(AbstractC6245Pack.bigEndianToInt(octets, 0))).withPublicKey(octets);
            }
            return c6121BuilderWithPublicKey.m17919build();
        }
    }

    static {
        HashMap map = new HashMap();
        converters = map;
        map.put(PQCObjectIdentifiers.sphincs256, new SPHINCSConverter());
        converters.put(PQCObjectIdentifiers.f23021newHope, new NHConverter());
        converters.put(PQCObjectIdentifiers.f23024xmss, new XMSSConverter());
        converters.put(PQCObjectIdentifiers.f23025xmss_mt, new XMSSMTConverter());
        converters.put(IsaraObjectIdentifiers.id_alg_xmss, new XMSSConverter());
        converters.put(IsaraObjectIdentifiers.id_alg_xmssmt, new XMSSMTConverter());
        converters.put(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig, new LMSConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_sha2_128s_r3, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_sha2_128f_r3, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_shake_128s_r3, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_shake_128f_r3, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_haraka_128s_r3, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_haraka_128f_r3, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_sha2_192s_r3, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_sha2_192f_r3, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_shake_192s_r3, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_shake_192f_r3, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_haraka_192s_r3, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_haraka_192f_r3, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_sha2_256s_r3, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_sha2_256f_r3, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_shake_256s_r3, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_shake_256f_r3, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_haraka_256s_r3, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_haraka_256f_r3, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_haraka_128s_r3_simple, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_haraka_128f_r3_simple, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_haraka_192s_r3_simple, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_haraka_192f_r3_simple, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_haraka_256s_r3_simple, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_haraka_256f_r3_simple, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_sha2_128s, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_sha2_128f, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_shake_128s, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_shake_128f, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_sha2_192s, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_sha2_192f, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_shake_192s, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_shake_192f, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_sha2_256s, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_sha2_256f, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_shake_256s, new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.sphincsPlus_shake_256f, new SPHINCSPlusConverter());
        converters.put(new ASN1ObjectIdentifier("1.3.9999.6.4.10"), new SPHINCSPlusConverter());
        converters.put(BCObjectIdentifiers.mceliece348864_r3, new CMCEConverter());
        converters.put(BCObjectIdentifiers.mceliece348864f_r3, new CMCEConverter());
        converters.put(BCObjectIdentifiers.mceliece460896_r3, new CMCEConverter());
        converters.put(BCObjectIdentifiers.mceliece460896f_r3, new CMCEConverter());
        converters.put(BCObjectIdentifiers.mceliece6688128_r3, new CMCEConverter());
        converters.put(BCObjectIdentifiers.mceliece6688128f_r3, new CMCEConverter());
        converters.put(BCObjectIdentifiers.mceliece6960119_r3, new CMCEConverter());
        converters.put(BCObjectIdentifiers.mceliece6960119f_r3, new CMCEConverter());
        converters.put(BCObjectIdentifiers.mceliece8192128_r3, new CMCEConverter());
        converters.put(BCObjectIdentifiers.mceliece8192128f_r3, new CMCEConverter());
        converters.put(BCObjectIdentifiers.frodokem640aes, new FrodoConverter());
        converters.put(BCObjectIdentifiers.frodokem640shake, new FrodoConverter());
        converters.put(BCObjectIdentifiers.frodokem976aes, new FrodoConverter());
        converters.put(BCObjectIdentifiers.frodokem976shake, new FrodoConverter());
        converters.put(BCObjectIdentifiers.frodokem1344aes, new FrodoConverter());
        converters.put(BCObjectIdentifiers.frodokem1344shake, new FrodoConverter());
        converters.put(BCObjectIdentifiers.lightsaberkem128r3, new SABERConverter());
        converters.put(BCObjectIdentifiers.saberkem128r3, new SABERConverter());
        converters.put(BCObjectIdentifiers.firesaberkem128r3, new SABERConverter());
        converters.put(BCObjectIdentifiers.lightsaberkem192r3, new SABERConverter());
        converters.put(BCObjectIdentifiers.saberkem192r3, new SABERConverter());
        converters.put(BCObjectIdentifiers.firesaberkem192r3, new SABERConverter());
        converters.put(BCObjectIdentifiers.lightsaberkem256r3, new SABERConverter());
        converters.put(BCObjectIdentifiers.saberkem256r3, new SABERConverter());
        converters.put(BCObjectIdentifiers.firesaberkem256r3, new SABERConverter());
        converters.put(BCObjectIdentifiers.ulightsaberkemr3, new SABERConverter());
        converters.put(BCObjectIdentifiers.usaberkemr3, new SABERConverter());
        converters.put(BCObjectIdentifiers.ufiresaberkemr3, new SABERConverter());
        converters.put(BCObjectIdentifiers.lightsaberkem90sr3, new SABERConverter());
        converters.put(BCObjectIdentifiers.saberkem90sr3, new SABERConverter());
        converters.put(BCObjectIdentifiers.firesaberkem90sr3, new SABERConverter());
        converters.put(BCObjectIdentifiers.ulightsaberkem90sr3, new SABERConverter());
        converters.put(BCObjectIdentifiers.usaberkem90sr3, new SABERConverter());
        converters.put(BCObjectIdentifiers.ufiresaberkem90sr3, new SABERConverter());
        converters.put(BCObjectIdentifiers.picnicl1fs, new PicnicConverter());
        converters.put(BCObjectIdentifiers.picnicl1ur, new PicnicConverter());
        converters.put(BCObjectIdentifiers.picnicl3fs, new PicnicConverter());
        converters.put(BCObjectIdentifiers.picnicl3ur, new PicnicConverter());
        converters.put(BCObjectIdentifiers.picnicl5fs, new PicnicConverter());
        converters.put(BCObjectIdentifiers.picnicl5ur, new PicnicConverter());
        converters.put(BCObjectIdentifiers.picnic3l1, new PicnicConverter());
        converters.put(BCObjectIdentifiers.picnic3l3, new PicnicConverter());
        converters.put(BCObjectIdentifiers.picnic3l5, new PicnicConverter());
        converters.put(BCObjectIdentifiers.picnicl1full, new PicnicConverter());
        converters.put(BCObjectIdentifiers.picnicl3full, new PicnicConverter());
        converters.put(BCObjectIdentifiers.picnicl5full, new PicnicConverter());
        converters.put(BCObjectIdentifiers.ntruhps2048509, new NtruConverter());
        converters.put(BCObjectIdentifiers.ntruhps2048677, new NtruConverter());
        converters.put(BCObjectIdentifiers.ntruhps4096821, new NtruConverter());
        converters.put(BCObjectIdentifiers.ntruhps40961229, new NtruConverter());
        converters.put(BCObjectIdentifiers.ntruhrss701, new NtruConverter());
        converters.put(BCObjectIdentifiers.ntruhrss1373, new NtruConverter());
        converters.put(BCObjectIdentifiers.falcon_512, new FalconConverter());
        converters.put(BCObjectIdentifiers.falcon_1024, new FalconConverter());
        converters.put(BCObjectIdentifiers.old_falcon_512, new FalconConverter());
        converters.put(BCObjectIdentifiers.old_falcon_1024, new FalconConverter());
        converters.put(NISTObjectIdentifiers.id_alg_ml_kem_512, new MLKEMConverter());
        converters.put(NISTObjectIdentifiers.id_alg_ml_kem_768, new MLKEMConverter());
        converters.put(NISTObjectIdentifiers.id_alg_ml_kem_1024, new MLKEMConverter());
        converters.put(BCObjectIdentifiers.kyber512_aes, new MLKEMConverter());
        converters.put(BCObjectIdentifiers.kyber768_aes, new MLKEMConverter());
        converters.put(BCObjectIdentifiers.kyber1024_aes, new MLKEMConverter());
        converters.put(BCObjectIdentifiers.ntrulpr653, new NTRULPrimeConverter());
        converters.put(BCObjectIdentifiers.ntrulpr761, new NTRULPrimeConverter());
        converters.put(BCObjectIdentifiers.ntrulpr857, new NTRULPrimeConverter());
        converters.put(BCObjectIdentifiers.ntrulpr953, new NTRULPrimeConverter());
        converters.put(BCObjectIdentifiers.ntrulpr1013, new NTRULPrimeConverter());
        converters.put(BCObjectIdentifiers.ntrulpr1277, new NTRULPrimeConverter());
        converters.put(BCObjectIdentifiers.sntrup653, new SNTRUPrimeConverter());
        converters.put(BCObjectIdentifiers.sntrup761, new SNTRUPrimeConverter());
        converters.put(BCObjectIdentifiers.sntrup857, new SNTRUPrimeConverter());
        converters.put(BCObjectIdentifiers.sntrup953, new SNTRUPrimeConverter());
        converters.put(BCObjectIdentifiers.sntrup1013, new SNTRUPrimeConverter());
        converters.put(BCObjectIdentifiers.sntrup1277, new SNTRUPrimeConverter());
        converters.put(NISTObjectIdentifiers.id_ml_dsa_44, new MLDSAConverter());
        converters.put(NISTObjectIdentifiers.id_ml_dsa_65, new MLDSAConverter());
        converters.put(NISTObjectIdentifiers.id_ml_dsa_87, new MLDSAConverter());
        converters.put(NISTObjectIdentifiers.id_hash_ml_dsa_44_with_sha512, new MLDSAConverter());
        converters.put(NISTObjectIdentifiers.id_hash_ml_dsa_65_with_sha512, new MLDSAConverter());
        converters.put(NISTObjectIdentifiers.id_hash_ml_dsa_87_with_sha512, new MLDSAConverter());
        converters.put(BCObjectIdentifiers.dilithium2, new DilithiumConverter());
        converters.put(BCObjectIdentifiers.dilithium3, new DilithiumConverter());
        converters.put(BCObjectIdentifiers.dilithium5, new DilithiumConverter());
        converters.put(BCObjectIdentifiers.dilithium2_aes, new DilithiumConverter());
        converters.put(BCObjectIdentifiers.dilithium3_aes, new DilithiumConverter());
        converters.put(BCObjectIdentifiers.dilithium5_aes, new DilithiumConverter());
        converters.put(BCObjectIdentifiers.f18019bike128, new BIKEConverter());
        converters.put(BCObjectIdentifiers.f18020bike192, new BIKEConverter());
        converters.put(BCObjectIdentifiers.f18021bike256, new BIKEConverter());
        converters.put(BCObjectIdentifiers.f18023hqc128, new HQCConverter());
        converters.put(BCObjectIdentifiers.f18024hqc192, new HQCConverter());
        converters.put(BCObjectIdentifiers.f18025hqc256, new HQCConverter());
        converters.put(BCObjectIdentifiers.rainbow_III_classic, new RainbowConverter());
        converters.put(BCObjectIdentifiers.rainbow_III_circumzenithal, new RainbowConverter());
        converters.put(BCObjectIdentifiers.rainbow_III_compressed, new RainbowConverter());
        converters.put(BCObjectIdentifiers.rainbow_V_classic, new RainbowConverter());
        converters.put(BCObjectIdentifiers.rainbow_V_circumzenithal, new RainbowConverter());
        converters.put(BCObjectIdentifiers.rainbow_V_compressed, new RainbowConverter());
        converters.put(NISTObjectIdentifiers.id_slh_dsa_sha2_128s, new SLHDSAConverter());
        converters.put(NISTObjectIdentifiers.id_slh_dsa_sha2_128f, new SLHDSAConverter());
        converters.put(NISTObjectIdentifiers.id_slh_dsa_sha2_192s, new SLHDSAConverter());
        converters.put(NISTObjectIdentifiers.id_slh_dsa_sha2_192f, new SLHDSAConverter());
        converters.put(NISTObjectIdentifiers.id_slh_dsa_sha2_256s, new SLHDSAConverter());
        converters.put(NISTObjectIdentifiers.id_slh_dsa_sha2_256f, new SLHDSAConverter());
        converters.put(NISTObjectIdentifiers.id_slh_dsa_shake_128s, new SLHDSAConverter());
        converters.put(NISTObjectIdentifiers.id_slh_dsa_shake_128f, new SLHDSAConverter());
        converters.put(NISTObjectIdentifiers.id_slh_dsa_shake_192s, new SLHDSAConverter());
        converters.put(NISTObjectIdentifiers.id_slh_dsa_shake_192f, new SLHDSAConverter());
        converters.put(NISTObjectIdentifiers.id_slh_dsa_shake_256s, new SLHDSAConverter());
        converters.put(NISTObjectIdentifiers.id_slh_dsa_shake_256f, new SLHDSAConverter());
        converters.put(NISTObjectIdentifiers.id_hash_slh_dsa_sha2_128s_with_sha256, new SLHDSAConverter());
        converters.put(NISTObjectIdentifiers.id_hash_slh_dsa_sha2_128f_with_sha256, new SLHDSAConverter());
        converters.put(NISTObjectIdentifiers.id_hash_slh_dsa_sha2_192s_with_sha512, new SLHDSAConverter());
        converters.put(NISTObjectIdentifiers.id_hash_slh_dsa_sha2_192f_with_sha512, new SLHDSAConverter());
        converters.put(NISTObjectIdentifiers.id_hash_slh_dsa_sha2_256s_with_sha512, new SLHDSAConverter());
        converters.put(NISTObjectIdentifiers.id_hash_slh_dsa_sha2_256f_with_sha512, new SLHDSAConverter());
        converters.put(NISTObjectIdentifiers.id_hash_slh_dsa_shake_128s_with_shake128, new SLHDSAConverter());
        converters.put(NISTObjectIdentifiers.id_hash_slh_dsa_shake_128f_with_shake128, new SLHDSAConverter());
        converters.put(NISTObjectIdentifiers.id_hash_slh_dsa_shake_192s_with_shake256, new SLHDSAConverter());
        converters.put(NISTObjectIdentifiers.id_hash_slh_dsa_shake_192f_with_shake256, new SLHDSAConverter());
        converters.put(NISTObjectIdentifiers.id_hash_slh_dsa_shake_256s_with_shake256, new SLHDSAConverter());
        converters.put(NISTObjectIdentifiers.id_hash_slh_dsa_shake_256f_with_shake256, new SLHDSAConverter());
        converters.put(BCObjectIdentifiers.f18027mayo1, new MayoConverter());
        converters.put(BCObjectIdentifiers.f18028mayo2, new MayoConverter());
        converters.put(BCObjectIdentifiers.f18029mayo3, new MayoConverter());
        converters.put(BCObjectIdentifiers.f18030mayo5, new MayoConverter());
        converters.put(BCObjectIdentifiers.snova_24_5_4_esk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_24_5_4_ssk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_24_5_4_shake_esk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_24_5_4_shake_ssk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_24_5_5_esk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_24_5_5_ssk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_24_5_5_shake_esk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_24_5_5_shake_ssk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_25_8_3_esk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_25_8_3_ssk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_25_8_3_shake_esk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_25_8_3_shake_ssk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_29_6_5_esk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_29_6_5_ssk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_29_6_5_shake_esk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_29_6_5_shake_ssk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_37_8_4_esk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_37_8_4_ssk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_37_8_4_shake_esk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_37_8_4_shake_ssk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_37_17_2_esk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_37_17_2_ssk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_37_17_2_shake_esk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_37_17_2_shake_ssk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_49_11_3_esk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_49_11_3_ssk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_49_11_3_shake_esk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_49_11_3_shake_ssk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_56_25_2_esk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_56_25_2_ssk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_56_25_2_shake_esk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_56_25_2_shake_ssk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_60_10_4_esk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_60_10_4_ssk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_60_10_4_shake_esk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_60_10_4_shake_ssk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_66_15_3_esk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_66_15_3_ssk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_66_15_3_shake_esk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_66_15_3_shake_ssk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_75_33_2_esk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_75_33_2_ssk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_75_33_2_shake_esk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.snova_75_33_2_shake_ssk, new SnovaConverter());
        converters.put(BCObjectIdentifiers.ntruplus768, new NTRUPlusConverter());
        converters.put(BCObjectIdentifiers.ntruplus864, new NTRUPlusConverter());
        converters.put(BCObjectIdentifiers.ntruplus1152, new NTRUPlusConverter());
    }

    public static AsymmetricKeyParameter createKey(InputStream inputStream) {
        return createKey(SubjectPublicKeyInfo.getInstance(new ASN1InputStream(inputStream).readObject()));
    }

    public static AsymmetricKeyParameter createKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        if (subjectPublicKeyInfo != null) {
            return createKey(subjectPublicKeyInfo, null);
        }
        throw new IllegalArgumentException("keyInfo argument null");
    }

    public static AsymmetricKeyParameter createKey(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) throws IOException {
        if (subjectPublicKeyInfo == null) {
            throw new IllegalArgumentException("keyInfo argument null");
        }
        AlgorithmIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm();
        SubjectPublicKeyInfoConverter subjectPublicKeyInfoConverter = (SubjectPublicKeyInfoConverter) converters.get(algorithm.getAlgorithm());
        if (subjectPublicKeyInfoConverter != null) {
            return subjectPublicKeyInfoConverter.getPublicKeyParameters(subjectPublicKeyInfo, obj);
        }
        throw new IOException("algorithm identifier in public key not recognised: " + algorithm.getAlgorithm());
    }

    public static AsymmetricKeyParameter createKey(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("keyInfoData array null");
        }
        if (bArr.length != 0) {
            return createKey(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(bArr)));
        }
        throw new IllegalArgumentException("keyInfoData array empty");
    }
}
