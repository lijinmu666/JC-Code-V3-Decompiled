package org.bouncycastle.p194crypto.p221util;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.internal.p231asn1.p245oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.p135bc.BCObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p194crypto.p213params.MLDSAParameters;
import org.bouncycastle.p194crypto.p213params.MLKEMParameters;
import org.bouncycastle.p194crypto.p213params.SLHDSAParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruplus.NTRUPlusParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.NTRULPRimeParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.SNTRUPrimeParameters;
import org.bouncycastle.p314pqc.p316crypto.p317cmce.CMCEParameters;
import org.bouncycastle.p314pqc.p316crypto.p318falcon.FalconParameters;
import org.bouncycastle.p314pqc.p316crypto.p319frodo.FrodoParameters;
import org.bouncycastle.p314pqc.p316crypto.p320hqc.HQCParameters;
import org.bouncycastle.p314pqc.p316crypto.p322mayo.MayoParameters;
import org.bouncycastle.p314pqc.p316crypto.p326ntru.NTRUParameters;
import org.bouncycastle.p314pqc.p316crypto.p327saber.SABERParameters;
import org.bouncycastle.p314pqc.p316crypto.p329snova.SnovaParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;
import p094kotlin.C1126UByte;

/* renamed from: org.bouncycastle.crypto.util.Utils */
/* loaded from: classes2.dex */
class C5431Utils {
    static final AlgorithmIdentifier SPHINCS_SHA3_256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha3_256);
    static final AlgorithmIdentifier SPHINCS_SHA512_256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512_256);
    static final Map dilithiumOids;
    static final Map dilithiumParams;
    static final Map falconOids;
    static final Map falconParams;
    static final Map frodoOids;
    static final Map frodoParams;

    /* renamed from: hqcOids */
    static final Map f21139hqcOids;
    static final Map hqcParams;
    static final Map mayoOids;
    static final Map mayoParams;
    static final Map mcElieceOids;
    static final Map mcElieceParams;
    static final Map mldsaOids;
    static final Map mldsaParams;
    static final Map mlkemOids;
    static final Map mlkemParams;
    static final Map ntruOids;
    static final Map ntruParams;
    static final Map ntruPlusOids;
    static final Map ntruPlusParams;
    static final Map ntruprimeOids;
    static final Map ntruprimeParams;
    static final Map saberOids;
    static final Map saberParams;
    static final Map slhdsaOids;
    static final Map slhdsaParams;
    static final Map snovaOids;
    static final Map snovaParams;
    static final Map sntruprimeOids;
    static final Map sntruprimeParams;
    static final Map sphincsPlusOids;
    static final Map sphincsPlusParams;

    static {
        HashMap map = new HashMap();
        frodoOids = map;
        HashMap map2 = new HashMap();
        frodoParams = map2;
        HashMap map3 = new HashMap();
        saberOids = map3;
        HashMap map4 = new HashMap();
        saberParams = map4;
        HashMap map5 = new HashMap();
        mcElieceOids = map5;
        HashMap map6 = new HashMap();
        mcElieceParams = map6;
        sphincsPlusOids = new HashMap();
        sphincsPlusParams = new HashMap();
        HashMap map7 = new HashMap();
        ntruOids = map7;
        HashMap map8 = new HashMap();
        ntruParams = map8;
        HashMap map9 = new HashMap();
        falconOids = map9;
        HashMap map10 = new HashMap();
        falconParams = map10;
        HashMap map11 = new HashMap();
        ntruprimeOids = map11;
        HashMap map12 = new HashMap();
        ntruprimeParams = map12;
        HashMap map13 = new HashMap();
        sntruprimeOids = map13;
        HashMap map14 = new HashMap();
        sntruprimeParams = map14;
        dilithiumOids = new HashMap();
        dilithiumParams = new HashMap();
        HashMap map15 = new HashMap();
        f21139hqcOids = map15;
        HashMap map16 = new HashMap();
        hqcParams = map16;
        HashMap map17 = new HashMap();
        mlkemOids = map17;
        HashMap map18 = new HashMap();
        mlkemParams = map18;
        HashMap map19 = new HashMap();
        mldsaOids = map19;
        HashMap map20 = new HashMap();
        mldsaParams = map20;
        HashMap map21 = new HashMap();
        slhdsaOids = map21;
        HashMap map22 = new HashMap();
        slhdsaParams = map22;
        HashMap map23 = new HashMap();
        mayoOids = map23;
        HashMap map24 = new HashMap();
        mayoParams = map24;
        HashMap map25 = new HashMap();
        snovaOids = map25;
        HashMap map26 = new HashMap();
        snovaParams = map26;
        HashMap map27 = new HashMap();
        ntruPlusOids = map27;
        HashMap map28 = new HashMap();
        ntruPlusParams = map28;
        CMCEParameters cMCEParameters = CMCEParameters.mceliece348864r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = BCObjectIdentifiers.mceliece348864_r3;
        map5.put(cMCEParameters, aSN1ObjectIdentifier);
        CMCEParameters cMCEParameters2 = CMCEParameters.mceliece348864fr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = BCObjectIdentifiers.mceliece348864f_r3;
        map5.put(cMCEParameters2, aSN1ObjectIdentifier2);
        CMCEParameters cMCEParameters3 = CMCEParameters.mceliece460896r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = BCObjectIdentifiers.mceliece460896_r3;
        map5.put(cMCEParameters3, aSN1ObjectIdentifier3);
        CMCEParameters cMCEParameters4 = CMCEParameters.mceliece460896fr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = BCObjectIdentifiers.mceliece460896f_r3;
        map5.put(cMCEParameters4, aSN1ObjectIdentifier4);
        CMCEParameters cMCEParameters5 = CMCEParameters.mceliece6688128r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = BCObjectIdentifiers.mceliece6688128_r3;
        map5.put(cMCEParameters5, aSN1ObjectIdentifier5);
        CMCEParameters cMCEParameters6 = CMCEParameters.mceliece6688128fr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = BCObjectIdentifiers.mceliece6688128f_r3;
        map5.put(cMCEParameters6, aSN1ObjectIdentifier6);
        CMCEParameters cMCEParameters7 = CMCEParameters.mceliece6960119r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = BCObjectIdentifiers.mceliece6960119_r3;
        map5.put(cMCEParameters7, aSN1ObjectIdentifier7);
        CMCEParameters cMCEParameters8 = CMCEParameters.mceliece6960119fr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = BCObjectIdentifiers.mceliece6960119f_r3;
        map5.put(cMCEParameters8, aSN1ObjectIdentifier8);
        CMCEParameters cMCEParameters9 = CMCEParameters.mceliece8192128r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = BCObjectIdentifiers.mceliece8192128_r3;
        map5.put(cMCEParameters9, aSN1ObjectIdentifier9);
        CMCEParameters cMCEParameters10 = CMCEParameters.mceliece8192128fr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = BCObjectIdentifiers.mceliece8192128f_r3;
        map5.put(cMCEParameters10, aSN1ObjectIdentifier10);
        map6.put(aSN1ObjectIdentifier, cMCEParameters);
        map6.put(aSN1ObjectIdentifier2, cMCEParameters2);
        map6.put(aSN1ObjectIdentifier3, cMCEParameters3);
        map6.put(aSN1ObjectIdentifier4, cMCEParameters4);
        map6.put(aSN1ObjectIdentifier5, cMCEParameters5);
        map6.put(aSN1ObjectIdentifier6, cMCEParameters6);
        map6.put(aSN1ObjectIdentifier7, cMCEParameters7);
        map6.put(aSN1ObjectIdentifier8, cMCEParameters8);
        map6.put(aSN1ObjectIdentifier9, cMCEParameters9);
        map6.put(aSN1ObjectIdentifier10, cMCEParameters10);
        FrodoParameters frodoParameters = FrodoParameters.frodokem640aes;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = BCObjectIdentifiers.frodokem640aes;
        map.put(frodoParameters, aSN1ObjectIdentifier11);
        FrodoParameters frodoParameters2 = FrodoParameters.frodokem640shake;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = BCObjectIdentifiers.frodokem640shake;
        map.put(frodoParameters2, aSN1ObjectIdentifier12);
        FrodoParameters frodoParameters3 = FrodoParameters.frodokem976aes;
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = BCObjectIdentifiers.frodokem976aes;
        map.put(frodoParameters3, aSN1ObjectIdentifier13);
        FrodoParameters frodoParameters4 = FrodoParameters.frodokem976shake;
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = BCObjectIdentifiers.frodokem976shake;
        map.put(frodoParameters4, aSN1ObjectIdentifier14);
        FrodoParameters frodoParameters5 = FrodoParameters.frodokem1344aes;
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = BCObjectIdentifiers.frodokem1344aes;
        map.put(frodoParameters5, aSN1ObjectIdentifier15);
        FrodoParameters frodoParameters6 = FrodoParameters.frodokem1344shake;
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = BCObjectIdentifiers.frodokem1344shake;
        map.put(frodoParameters6, aSN1ObjectIdentifier16);
        map2.put(aSN1ObjectIdentifier11, frodoParameters);
        map2.put(aSN1ObjectIdentifier12, frodoParameters2);
        map2.put(aSN1ObjectIdentifier13, frodoParameters3);
        map2.put(aSN1ObjectIdentifier14, frodoParameters4);
        map2.put(aSN1ObjectIdentifier15, frodoParameters5);
        map2.put(aSN1ObjectIdentifier16, frodoParameters6);
        SABERParameters sABERParameters = SABERParameters.lightsaberkem128r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = BCObjectIdentifiers.lightsaberkem128r3;
        map3.put(sABERParameters, aSN1ObjectIdentifier17);
        SABERParameters sABERParameters2 = SABERParameters.saberkem128r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier18 = BCObjectIdentifiers.saberkem128r3;
        map3.put(sABERParameters2, aSN1ObjectIdentifier18);
        SABERParameters sABERParameters3 = SABERParameters.firesaberkem128r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier19 = BCObjectIdentifiers.firesaberkem128r3;
        map3.put(sABERParameters3, aSN1ObjectIdentifier19);
        SABERParameters sABERParameters4 = SABERParameters.lightsaberkem192r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier20 = BCObjectIdentifiers.lightsaberkem192r3;
        map3.put(sABERParameters4, aSN1ObjectIdentifier20);
        SABERParameters sABERParameters5 = SABERParameters.saberkem192r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier21 = BCObjectIdentifiers.saberkem192r3;
        map3.put(sABERParameters5, aSN1ObjectIdentifier21);
        SABERParameters sABERParameters6 = SABERParameters.firesaberkem192r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier22 = BCObjectIdentifiers.firesaberkem192r3;
        map3.put(sABERParameters6, aSN1ObjectIdentifier22);
        SABERParameters sABERParameters7 = SABERParameters.lightsaberkem256r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier23 = BCObjectIdentifiers.lightsaberkem256r3;
        map3.put(sABERParameters7, aSN1ObjectIdentifier23);
        SABERParameters sABERParameters8 = SABERParameters.saberkem256r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier24 = BCObjectIdentifiers.saberkem256r3;
        map3.put(sABERParameters8, aSN1ObjectIdentifier24);
        SABERParameters sABERParameters9 = SABERParameters.firesaberkem256r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier25 = BCObjectIdentifiers.firesaberkem256r3;
        map3.put(sABERParameters9, aSN1ObjectIdentifier25);
        SABERParameters sABERParameters10 = SABERParameters.ulightsaberkemr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier26 = BCObjectIdentifiers.ulightsaberkemr3;
        map3.put(sABERParameters10, aSN1ObjectIdentifier26);
        SABERParameters sABERParameters11 = SABERParameters.usaberkemr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier27 = BCObjectIdentifiers.usaberkemr3;
        map3.put(sABERParameters11, aSN1ObjectIdentifier27);
        SABERParameters sABERParameters12 = SABERParameters.ufiresaberkemr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier28 = BCObjectIdentifiers.ufiresaberkemr3;
        map3.put(sABERParameters12, aSN1ObjectIdentifier28);
        SABERParameters sABERParameters13 = SABERParameters.lightsaberkem90sr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier29 = BCObjectIdentifiers.lightsaberkem90sr3;
        map3.put(sABERParameters13, aSN1ObjectIdentifier29);
        SABERParameters sABERParameters14 = SABERParameters.saberkem90sr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier30 = BCObjectIdentifiers.saberkem90sr3;
        map3.put(sABERParameters14, aSN1ObjectIdentifier30);
        SABERParameters sABERParameters15 = SABERParameters.firesaberkem90sr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier31 = BCObjectIdentifiers.firesaberkem90sr3;
        map3.put(sABERParameters15, aSN1ObjectIdentifier31);
        SABERParameters sABERParameters16 = SABERParameters.ulightsaberkem90sr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier32 = BCObjectIdentifiers.ulightsaberkem90sr3;
        map3.put(sABERParameters16, aSN1ObjectIdentifier32);
        SABERParameters sABERParameters17 = SABERParameters.usaberkem90sr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier33 = BCObjectIdentifiers.usaberkem90sr3;
        map3.put(sABERParameters17, aSN1ObjectIdentifier33);
        SABERParameters sABERParameters18 = SABERParameters.ufiresaberkem90sr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier34 = BCObjectIdentifiers.ufiresaberkem90sr3;
        map3.put(sABERParameters18, aSN1ObjectIdentifier34);
        map4.put(aSN1ObjectIdentifier17, sABERParameters);
        map4.put(aSN1ObjectIdentifier18, sABERParameters2);
        map4.put(aSN1ObjectIdentifier19, sABERParameters3);
        map4.put(aSN1ObjectIdentifier20, sABERParameters4);
        map4.put(aSN1ObjectIdentifier21, sABERParameters5);
        map4.put(aSN1ObjectIdentifier22, sABERParameters6);
        map4.put(aSN1ObjectIdentifier23, sABERParameters7);
        map4.put(aSN1ObjectIdentifier24, sABERParameters8);
        map4.put(aSN1ObjectIdentifier25, sABERParameters9);
        map4.put(aSN1ObjectIdentifier26, sABERParameters10);
        map4.put(aSN1ObjectIdentifier27, sABERParameters11);
        map4.put(aSN1ObjectIdentifier28, sABERParameters12);
        map4.put(aSN1ObjectIdentifier29, sABERParameters13);
        map4.put(aSN1ObjectIdentifier30, sABERParameters14);
        map4.put(aSN1ObjectIdentifier31, sABERParameters15);
        map4.put(aSN1ObjectIdentifier32, sABERParameters16);
        map4.put(aSN1ObjectIdentifier33, sABERParameters17);
        map4.put(aSN1ObjectIdentifier34, sABERParameters18);
        NTRUParameters nTRUParameters = NTRUParameters.ntruhps2048509;
        ASN1ObjectIdentifier aSN1ObjectIdentifier35 = BCObjectIdentifiers.ntruhps2048509;
        map7.put(nTRUParameters, aSN1ObjectIdentifier35);
        NTRUParameters nTRUParameters2 = NTRUParameters.ntruhps2048677;
        ASN1ObjectIdentifier aSN1ObjectIdentifier36 = BCObjectIdentifiers.ntruhps2048677;
        map7.put(nTRUParameters2, aSN1ObjectIdentifier36);
        NTRUParameters nTRUParameters3 = NTRUParameters.ntruhps4096821;
        ASN1ObjectIdentifier aSN1ObjectIdentifier37 = BCObjectIdentifiers.ntruhps4096821;
        map7.put(nTRUParameters3, aSN1ObjectIdentifier37);
        NTRUParameters nTRUParameters4 = NTRUParameters.ntruhps40961229;
        ASN1ObjectIdentifier aSN1ObjectIdentifier38 = BCObjectIdentifiers.ntruhps40961229;
        map7.put(nTRUParameters4, aSN1ObjectIdentifier38);
        NTRUParameters nTRUParameters5 = NTRUParameters.ntruhrss701;
        ASN1ObjectIdentifier aSN1ObjectIdentifier39 = BCObjectIdentifiers.ntruhrss701;
        map7.put(nTRUParameters5, aSN1ObjectIdentifier39);
        NTRUParameters nTRUParameters6 = NTRUParameters.ntruhrss1373;
        ASN1ObjectIdentifier aSN1ObjectIdentifier40 = BCObjectIdentifiers.ntruhrss1373;
        map7.put(nTRUParameters6, aSN1ObjectIdentifier40);
        map8.put(aSN1ObjectIdentifier35, nTRUParameters);
        map8.put(aSN1ObjectIdentifier36, nTRUParameters2);
        map8.put(aSN1ObjectIdentifier37, nTRUParameters3);
        map8.put(aSN1ObjectIdentifier38, nTRUParameters4);
        map8.put(aSN1ObjectIdentifier39, nTRUParameters5);
        map8.put(aSN1ObjectIdentifier40, nTRUParameters6);
        FalconParameters falconParameters = FalconParameters.falcon_512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier41 = BCObjectIdentifiers.falcon_512;
        map9.put(falconParameters, aSN1ObjectIdentifier41);
        FalconParameters falconParameters2 = FalconParameters.falcon_1024;
        ASN1ObjectIdentifier aSN1ObjectIdentifier42 = BCObjectIdentifiers.falcon_1024;
        map9.put(falconParameters2, aSN1ObjectIdentifier42);
        map10.put(aSN1ObjectIdentifier41, falconParameters);
        map10.put(aSN1ObjectIdentifier42, falconParameters2);
        map10.put(BCObjectIdentifiers.old_falcon_512, falconParameters);
        map10.put(BCObjectIdentifiers.old_falcon_1024, falconParameters2);
        MLKEMParameters mLKEMParameters = MLKEMParameters.ml_kem_512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier43 = NISTObjectIdentifiers.id_alg_ml_kem_512;
        map17.put(mLKEMParameters, aSN1ObjectIdentifier43);
        MLKEMParameters mLKEMParameters2 = MLKEMParameters.ml_kem_768;
        ASN1ObjectIdentifier aSN1ObjectIdentifier44 = NISTObjectIdentifiers.id_alg_ml_kem_768;
        map17.put(mLKEMParameters2, aSN1ObjectIdentifier44);
        MLKEMParameters mLKEMParameters3 = MLKEMParameters.ml_kem_1024;
        ASN1ObjectIdentifier aSN1ObjectIdentifier45 = NISTObjectIdentifiers.id_alg_ml_kem_1024;
        map17.put(mLKEMParameters3, aSN1ObjectIdentifier45);
        map18.put(aSN1ObjectIdentifier43, mLKEMParameters);
        map18.put(aSN1ObjectIdentifier44, mLKEMParameters2);
        map18.put(aSN1ObjectIdentifier45, mLKEMParameters3);
        NTRULPRimeParameters nTRULPRimeParameters = NTRULPRimeParameters.ntrulpr653;
        ASN1ObjectIdentifier aSN1ObjectIdentifier46 = BCObjectIdentifiers.ntrulpr653;
        map11.put(nTRULPRimeParameters, aSN1ObjectIdentifier46);
        NTRULPRimeParameters nTRULPRimeParameters2 = NTRULPRimeParameters.ntrulpr761;
        ASN1ObjectIdentifier aSN1ObjectIdentifier47 = BCObjectIdentifiers.ntrulpr761;
        map11.put(nTRULPRimeParameters2, aSN1ObjectIdentifier47);
        NTRULPRimeParameters nTRULPRimeParameters3 = NTRULPRimeParameters.ntrulpr857;
        ASN1ObjectIdentifier aSN1ObjectIdentifier48 = BCObjectIdentifiers.ntrulpr857;
        map11.put(nTRULPRimeParameters3, aSN1ObjectIdentifier48);
        NTRULPRimeParameters nTRULPRimeParameters4 = NTRULPRimeParameters.ntrulpr953;
        ASN1ObjectIdentifier aSN1ObjectIdentifier49 = BCObjectIdentifiers.ntrulpr953;
        map11.put(nTRULPRimeParameters4, aSN1ObjectIdentifier49);
        NTRULPRimeParameters nTRULPRimeParameters5 = NTRULPRimeParameters.ntrulpr1013;
        ASN1ObjectIdentifier aSN1ObjectIdentifier50 = BCObjectIdentifiers.ntrulpr1013;
        map11.put(nTRULPRimeParameters5, aSN1ObjectIdentifier50);
        NTRULPRimeParameters nTRULPRimeParameters6 = NTRULPRimeParameters.ntrulpr1277;
        ASN1ObjectIdentifier aSN1ObjectIdentifier51 = BCObjectIdentifiers.ntrulpr1277;
        map11.put(nTRULPRimeParameters6, aSN1ObjectIdentifier51);
        map12.put(aSN1ObjectIdentifier46, nTRULPRimeParameters);
        map12.put(aSN1ObjectIdentifier47, nTRULPRimeParameters2);
        map12.put(aSN1ObjectIdentifier48, nTRULPRimeParameters3);
        map12.put(aSN1ObjectIdentifier49, nTRULPRimeParameters4);
        map12.put(aSN1ObjectIdentifier50, nTRULPRimeParameters5);
        map12.put(aSN1ObjectIdentifier51, nTRULPRimeParameters6);
        SNTRUPrimeParameters sNTRUPrimeParameters = SNTRUPrimeParameters.sntrup653;
        ASN1ObjectIdentifier aSN1ObjectIdentifier52 = BCObjectIdentifiers.sntrup653;
        map13.put(sNTRUPrimeParameters, aSN1ObjectIdentifier52);
        SNTRUPrimeParameters sNTRUPrimeParameters2 = SNTRUPrimeParameters.sntrup761;
        ASN1ObjectIdentifier aSN1ObjectIdentifier53 = BCObjectIdentifiers.sntrup761;
        map13.put(sNTRUPrimeParameters2, aSN1ObjectIdentifier53);
        SNTRUPrimeParameters sNTRUPrimeParameters3 = SNTRUPrimeParameters.sntrup857;
        ASN1ObjectIdentifier aSN1ObjectIdentifier54 = BCObjectIdentifiers.sntrup857;
        map13.put(sNTRUPrimeParameters3, aSN1ObjectIdentifier54);
        SNTRUPrimeParameters sNTRUPrimeParameters4 = SNTRUPrimeParameters.sntrup953;
        ASN1ObjectIdentifier aSN1ObjectIdentifier55 = BCObjectIdentifiers.sntrup953;
        map13.put(sNTRUPrimeParameters4, aSN1ObjectIdentifier55);
        SNTRUPrimeParameters sNTRUPrimeParameters5 = SNTRUPrimeParameters.sntrup1013;
        ASN1ObjectIdentifier aSN1ObjectIdentifier56 = BCObjectIdentifiers.sntrup1013;
        map13.put(sNTRUPrimeParameters5, aSN1ObjectIdentifier56);
        SNTRUPrimeParameters sNTRUPrimeParameters6 = SNTRUPrimeParameters.sntrup1277;
        ASN1ObjectIdentifier aSN1ObjectIdentifier57 = BCObjectIdentifiers.sntrup1277;
        map13.put(sNTRUPrimeParameters6, aSN1ObjectIdentifier57);
        map14.put(aSN1ObjectIdentifier52, sNTRUPrimeParameters);
        map14.put(aSN1ObjectIdentifier53, sNTRUPrimeParameters2);
        map14.put(aSN1ObjectIdentifier54, sNTRUPrimeParameters3);
        map14.put(aSN1ObjectIdentifier55, sNTRUPrimeParameters4);
        map14.put(aSN1ObjectIdentifier56, sNTRUPrimeParameters5);
        map14.put(aSN1ObjectIdentifier57, sNTRUPrimeParameters6);
        MLDSAParameters mLDSAParameters = MLDSAParameters.ml_dsa_44;
        ASN1ObjectIdentifier aSN1ObjectIdentifier58 = NISTObjectIdentifiers.id_ml_dsa_44;
        map19.put(mLDSAParameters, aSN1ObjectIdentifier58);
        MLDSAParameters mLDSAParameters2 = MLDSAParameters.ml_dsa_65;
        ASN1ObjectIdentifier aSN1ObjectIdentifier59 = NISTObjectIdentifiers.id_ml_dsa_65;
        map19.put(mLDSAParameters2, aSN1ObjectIdentifier59);
        MLDSAParameters mLDSAParameters3 = MLDSAParameters.ml_dsa_87;
        ASN1ObjectIdentifier aSN1ObjectIdentifier60 = NISTObjectIdentifiers.id_ml_dsa_87;
        map19.put(mLDSAParameters3, aSN1ObjectIdentifier60);
        MLDSAParameters mLDSAParameters4 = MLDSAParameters.ml_dsa_44_with_sha512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier61 = NISTObjectIdentifiers.id_hash_ml_dsa_44_with_sha512;
        map19.put(mLDSAParameters4, aSN1ObjectIdentifier61);
        MLDSAParameters mLDSAParameters5 = MLDSAParameters.ml_dsa_65_with_sha512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier62 = NISTObjectIdentifiers.id_hash_ml_dsa_65_with_sha512;
        map19.put(mLDSAParameters5, aSN1ObjectIdentifier62);
        MLDSAParameters mLDSAParameters6 = MLDSAParameters.ml_dsa_87_with_sha512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier63 = NISTObjectIdentifiers.id_hash_ml_dsa_87_with_sha512;
        map19.put(mLDSAParameters6, aSN1ObjectIdentifier63);
        map20.put(aSN1ObjectIdentifier58, mLDSAParameters);
        map20.put(aSN1ObjectIdentifier59, mLDSAParameters2);
        map20.put(aSN1ObjectIdentifier60, mLDSAParameters3);
        map20.put(aSN1ObjectIdentifier61, mLDSAParameters4);
        map20.put(aSN1ObjectIdentifier62, mLDSAParameters5);
        map20.put(aSN1ObjectIdentifier63, mLDSAParameters6);
        ASN1ObjectIdentifier aSN1ObjectIdentifier64 = BCObjectIdentifiers.f18023hqc128;
        HQCParameters hQCParameters = HQCParameters.f23200hqc128;
        map16.put(aSN1ObjectIdentifier64, hQCParameters);
        ASN1ObjectIdentifier aSN1ObjectIdentifier65 = BCObjectIdentifiers.f18024hqc192;
        HQCParameters hQCParameters2 = HQCParameters.f23201hqc192;
        map16.put(aSN1ObjectIdentifier65, hQCParameters2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier66 = BCObjectIdentifiers.f18025hqc256;
        HQCParameters hQCParameters3 = HQCParameters.f23202hqc256;
        map16.put(aSN1ObjectIdentifier66, hQCParameters3);
        map15.put(hQCParameters, aSN1ObjectIdentifier64);
        map15.put(hQCParameters2, aSN1ObjectIdentifier65);
        map15.put(hQCParameters3, aSN1ObjectIdentifier66);
        SLHDSAParameters sLHDSAParameters = SLHDSAParameters.sha2_128s;
        ASN1ObjectIdentifier aSN1ObjectIdentifier67 = NISTObjectIdentifiers.id_slh_dsa_sha2_128s;
        map21.put(sLHDSAParameters, aSN1ObjectIdentifier67);
        SLHDSAParameters sLHDSAParameters2 = SLHDSAParameters.sha2_128f;
        ASN1ObjectIdentifier aSN1ObjectIdentifier68 = NISTObjectIdentifiers.id_slh_dsa_sha2_128f;
        map21.put(sLHDSAParameters2, aSN1ObjectIdentifier68);
        SLHDSAParameters sLHDSAParameters3 = SLHDSAParameters.sha2_192s;
        ASN1ObjectIdentifier aSN1ObjectIdentifier69 = NISTObjectIdentifiers.id_slh_dsa_sha2_192s;
        map21.put(sLHDSAParameters3, aSN1ObjectIdentifier69);
        SLHDSAParameters sLHDSAParameters4 = SLHDSAParameters.sha2_192f;
        ASN1ObjectIdentifier aSN1ObjectIdentifier70 = NISTObjectIdentifiers.id_slh_dsa_sha2_192f;
        map21.put(sLHDSAParameters4, aSN1ObjectIdentifier70);
        SLHDSAParameters sLHDSAParameters5 = SLHDSAParameters.sha2_256s;
        ASN1ObjectIdentifier aSN1ObjectIdentifier71 = NISTObjectIdentifiers.id_slh_dsa_sha2_256s;
        map21.put(sLHDSAParameters5, aSN1ObjectIdentifier71);
        SLHDSAParameters sLHDSAParameters6 = SLHDSAParameters.sha2_256f;
        ASN1ObjectIdentifier aSN1ObjectIdentifier72 = NISTObjectIdentifiers.id_slh_dsa_sha2_256f;
        map21.put(sLHDSAParameters6, aSN1ObjectIdentifier72);
        SLHDSAParameters sLHDSAParameters7 = SLHDSAParameters.shake_128s;
        ASN1ObjectIdentifier aSN1ObjectIdentifier73 = NISTObjectIdentifiers.id_slh_dsa_shake_128s;
        map21.put(sLHDSAParameters7, aSN1ObjectIdentifier73);
        SLHDSAParameters sLHDSAParameters8 = SLHDSAParameters.shake_128f;
        ASN1ObjectIdentifier aSN1ObjectIdentifier74 = NISTObjectIdentifiers.id_slh_dsa_shake_128f;
        map21.put(sLHDSAParameters8, aSN1ObjectIdentifier74);
        SLHDSAParameters sLHDSAParameters9 = SLHDSAParameters.shake_192s;
        ASN1ObjectIdentifier aSN1ObjectIdentifier75 = NISTObjectIdentifiers.id_slh_dsa_shake_192s;
        map21.put(sLHDSAParameters9, aSN1ObjectIdentifier75);
        SLHDSAParameters sLHDSAParameters10 = SLHDSAParameters.shake_192f;
        ASN1ObjectIdentifier aSN1ObjectIdentifier76 = NISTObjectIdentifiers.id_slh_dsa_shake_192f;
        map21.put(sLHDSAParameters10, aSN1ObjectIdentifier76);
        SLHDSAParameters sLHDSAParameters11 = SLHDSAParameters.shake_256s;
        ASN1ObjectIdentifier aSN1ObjectIdentifier77 = NISTObjectIdentifiers.id_slh_dsa_shake_256s;
        map21.put(sLHDSAParameters11, aSN1ObjectIdentifier77);
        SLHDSAParameters sLHDSAParameters12 = SLHDSAParameters.shake_256f;
        ASN1ObjectIdentifier aSN1ObjectIdentifier78 = NISTObjectIdentifiers.id_slh_dsa_shake_256f;
        map21.put(sLHDSAParameters12, aSN1ObjectIdentifier78);
        SLHDSAParameters sLHDSAParameters13 = SLHDSAParameters.sha2_128s_with_sha256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier79 = NISTObjectIdentifiers.id_hash_slh_dsa_sha2_128s_with_sha256;
        map21.put(sLHDSAParameters13, aSN1ObjectIdentifier79);
        SLHDSAParameters sLHDSAParameters14 = SLHDSAParameters.sha2_128f_with_sha256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier80 = NISTObjectIdentifiers.id_hash_slh_dsa_sha2_128f_with_sha256;
        map21.put(sLHDSAParameters14, aSN1ObjectIdentifier80);
        SLHDSAParameters sLHDSAParameters15 = SLHDSAParameters.sha2_192s_with_sha512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier81 = NISTObjectIdentifiers.id_hash_slh_dsa_sha2_192s_with_sha512;
        map21.put(sLHDSAParameters15, aSN1ObjectIdentifier81);
        SLHDSAParameters sLHDSAParameters16 = SLHDSAParameters.sha2_192f_with_sha512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier82 = NISTObjectIdentifiers.id_hash_slh_dsa_sha2_192f_with_sha512;
        map21.put(sLHDSAParameters16, aSN1ObjectIdentifier82);
        SLHDSAParameters sLHDSAParameters17 = SLHDSAParameters.sha2_256s_with_sha512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier83 = NISTObjectIdentifiers.id_hash_slh_dsa_sha2_256s_with_sha512;
        map21.put(sLHDSAParameters17, aSN1ObjectIdentifier83);
        SLHDSAParameters sLHDSAParameters18 = SLHDSAParameters.sha2_256f_with_sha512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier84 = NISTObjectIdentifiers.id_hash_slh_dsa_sha2_256f_with_sha512;
        map21.put(sLHDSAParameters18, aSN1ObjectIdentifier84);
        SLHDSAParameters sLHDSAParameters19 = SLHDSAParameters.shake_128s_with_shake128;
        ASN1ObjectIdentifier aSN1ObjectIdentifier85 = NISTObjectIdentifiers.id_hash_slh_dsa_shake_128s_with_shake128;
        map21.put(sLHDSAParameters19, aSN1ObjectIdentifier85);
        SLHDSAParameters sLHDSAParameters20 = SLHDSAParameters.shake_128f_with_shake128;
        ASN1ObjectIdentifier aSN1ObjectIdentifier86 = NISTObjectIdentifiers.id_hash_slh_dsa_shake_128f_with_shake128;
        map21.put(sLHDSAParameters20, aSN1ObjectIdentifier86);
        SLHDSAParameters sLHDSAParameters21 = SLHDSAParameters.shake_192s_with_shake256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier87 = NISTObjectIdentifiers.id_hash_slh_dsa_shake_192s_with_shake256;
        map21.put(sLHDSAParameters21, aSN1ObjectIdentifier87);
        SLHDSAParameters sLHDSAParameters22 = SLHDSAParameters.shake_192f_with_shake256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier88 = NISTObjectIdentifiers.id_hash_slh_dsa_shake_192f_with_shake256;
        map21.put(sLHDSAParameters22, aSN1ObjectIdentifier88);
        SLHDSAParameters sLHDSAParameters23 = SLHDSAParameters.shake_256s_with_shake256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier89 = NISTObjectIdentifiers.id_hash_slh_dsa_shake_256s_with_shake256;
        map21.put(sLHDSAParameters23, aSN1ObjectIdentifier89);
        SLHDSAParameters sLHDSAParameters24 = SLHDSAParameters.shake_256f_with_shake256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier90 = NISTObjectIdentifiers.id_hash_slh_dsa_shake_256f_with_shake256;
        map21.put(sLHDSAParameters24, aSN1ObjectIdentifier90);
        map22.put(aSN1ObjectIdentifier67, sLHDSAParameters);
        map22.put(aSN1ObjectIdentifier68, sLHDSAParameters2);
        map22.put(aSN1ObjectIdentifier69, sLHDSAParameters3);
        map22.put(aSN1ObjectIdentifier70, sLHDSAParameters4);
        map22.put(aSN1ObjectIdentifier71, sLHDSAParameters5);
        map22.put(aSN1ObjectIdentifier72, sLHDSAParameters6);
        map22.put(aSN1ObjectIdentifier73, sLHDSAParameters7);
        map22.put(aSN1ObjectIdentifier74, sLHDSAParameters8);
        map22.put(aSN1ObjectIdentifier75, sLHDSAParameters9);
        map22.put(aSN1ObjectIdentifier76, sLHDSAParameters10);
        map22.put(aSN1ObjectIdentifier77, sLHDSAParameters11);
        map22.put(aSN1ObjectIdentifier78, sLHDSAParameters12);
        map22.put(aSN1ObjectIdentifier79, sLHDSAParameters13);
        map22.put(aSN1ObjectIdentifier80, sLHDSAParameters14);
        map22.put(aSN1ObjectIdentifier81, sLHDSAParameters15);
        map22.put(aSN1ObjectIdentifier82, sLHDSAParameters16);
        map22.put(aSN1ObjectIdentifier83, sLHDSAParameters17);
        map22.put(aSN1ObjectIdentifier84, sLHDSAParameters18);
        map22.put(aSN1ObjectIdentifier85, sLHDSAParameters19);
        map22.put(aSN1ObjectIdentifier86, sLHDSAParameters20);
        map22.put(aSN1ObjectIdentifier87, sLHDSAParameters21);
        map22.put(aSN1ObjectIdentifier88, sLHDSAParameters22);
        map22.put(aSN1ObjectIdentifier89, sLHDSAParameters23);
        map22.put(aSN1ObjectIdentifier90, sLHDSAParameters24);
        MayoParameters mayoParameters = MayoParameters.f23275mayo1;
        ASN1ObjectIdentifier aSN1ObjectIdentifier91 = BCObjectIdentifiers.f18027mayo1;
        map23.put(mayoParameters, aSN1ObjectIdentifier91);
        MayoParameters mayoParameters2 = MayoParameters.f23276mayo2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier92 = BCObjectIdentifiers.f18028mayo2;
        map23.put(mayoParameters2, aSN1ObjectIdentifier92);
        MayoParameters mayoParameters3 = MayoParameters.f23277mayo3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier93 = BCObjectIdentifiers.f18029mayo3;
        map23.put(mayoParameters3, aSN1ObjectIdentifier93);
        MayoParameters mayoParameters4 = MayoParameters.f23278mayo5;
        ASN1ObjectIdentifier aSN1ObjectIdentifier94 = BCObjectIdentifiers.f18030mayo5;
        map23.put(mayoParameters4, aSN1ObjectIdentifier94);
        map24.put(aSN1ObjectIdentifier91, mayoParameters);
        map24.put(aSN1ObjectIdentifier92, mayoParameters2);
        map24.put(aSN1ObjectIdentifier93, mayoParameters3);
        map24.put(aSN1ObjectIdentifier94, mayoParameters4);
        SnovaParameters snovaParameters = SnovaParameters.SNOVA_24_5_4_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier95 = BCObjectIdentifiers.snova_24_5_4_ssk;
        map25.put(snovaParameters, aSN1ObjectIdentifier95);
        SnovaParameters snovaParameters2 = SnovaParameters.SNOVA_24_5_4_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier96 = BCObjectIdentifiers.snova_24_5_4_esk;
        map25.put(snovaParameters2, aSN1ObjectIdentifier96);
        SnovaParameters snovaParameters3 = SnovaParameters.SNOVA_24_5_4_SHAKE_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier97 = BCObjectIdentifiers.snova_24_5_4_shake_ssk;
        map25.put(snovaParameters3, aSN1ObjectIdentifier97);
        SnovaParameters snovaParameters4 = SnovaParameters.SNOVA_24_5_4_SHAKE_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier98 = BCObjectIdentifiers.snova_24_5_4_shake_esk;
        map25.put(snovaParameters4, aSN1ObjectIdentifier98);
        SnovaParameters snovaParameters5 = SnovaParameters.SNOVA_24_5_5_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier99 = BCObjectIdentifiers.snova_24_5_5_ssk;
        map25.put(snovaParameters5, aSN1ObjectIdentifier99);
        SnovaParameters snovaParameters6 = SnovaParameters.SNOVA_24_5_5_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier100 = BCObjectIdentifiers.snova_24_5_5_esk;
        map25.put(snovaParameters6, aSN1ObjectIdentifier100);
        SnovaParameters snovaParameters7 = SnovaParameters.SNOVA_24_5_5_SHAKE_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier101 = BCObjectIdentifiers.snova_24_5_5_shake_ssk;
        map25.put(snovaParameters7, aSN1ObjectIdentifier101);
        SnovaParameters snovaParameters8 = SnovaParameters.SNOVA_24_5_5_SHAKE_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier102 = BCObjectIdentifiers.snova_24_5_5_shake_esk;
        map25.put(snovaParameters8, aSN1ObjectIdentifier102);
        SnovaParameters snovaParameters9 = SnovaParameters.SNOVA_25_8_3_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier103 = BCObjectIdentifiers.snova_25_8_3_ssk;
        map25.put(snovaParameters9, aSN1ObjectIdentifier103);
        SnovaParameters snovaParameters10 = SnovaParameters.SNOVA_25_8_3_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier104 = BCObjectIdentifiers.snova_25_8_3_esk;
        map25.put(snovaParameters10, aSN1ObjectIdentifier104);
        SnovaParameters snovaParameters11 = SnovaParameters.SNOVA_25_8_3_SHAKE_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier105 = BCObjectIdentifiers.snova_25_8_3_shake_ssk;
        map25.put(snovaParameters11, aSN1ObjectIdentifier105);
        SnovaParameters snovaParameters12 = SnovaParameters.SNOVA_25_8_3_SHAKE_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier106 = BCObjectIdentifiers.snova_25_8_3_shake_esk;
        map25.put(snovaParameters12, aSN1ObjectIdentifier106);
        SnovaParameters snovaParameters13 = SnovaParameters.SNOVA_29_6_5_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier107 = BCObjectIdentifiers.snova_29_6_5_ssk;
        map25.put(snovaParameters13, aSN1ObjectIdentifier107);
        SnovaParameters snovaParameters14 = SnovaParameters.SNOVA_29_6_5_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier108 = BCObjectIdentifiers.snova_29_6_5_esk;
        map25.put(snovaParameters14, aSN1ObjectIdentifier108);
        SnovaParameters snovaParameters15 = SnovaParameters.SNOVA_29_6_5_SHAKE_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier109 = BCObjectIdentifiers.snova_29_6_5_shake_ssk;
        map25.put(snovaParameters15, aSN1ObjectIdentifier109);
        SnovaParameters snovaParameters16 = SnovaParameters.SNOVA_29_6_5_SHAKE_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier110 = BCObjectIdentifiers.snova_29_6_5_shake_esk;
        map25.put(snovaParameters16, aSN1ObjectIdentifier110);
        SnovaParameters snovaParameters17 = SnovaParameters.SNOVA_37_8_4_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier111 = BCObjectIdentifiers.snova_37_8_4_ssk;
        map25.put(snovaParameters17, aSN1ObjectIdentifier111);
        SnovaParameters snovaParameters18 = SnovaParameters.SNOVA_37_8_4_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier112 = BCObjectIdentifiers.snova_37_8_4_esk;
        map25.put(snovaParameters18, aSN1ObjectIdentifier112);
        SnovaParameters snovaParameters19 = SnovaParameters.SNOVA_37_8_4_SHAKE_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier113 = BCObjectIdentifiers.snova_37_8_4_shake_ssk;
        map25.put(snovaParameters19, aSN1ObjectIdentifier113);
        SnovaParameters snovaParameters20 = SnovaParameters.SNOVA_37_8_4_SHAKE_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier114 = BCObjectIdentifiers.snova_37_8_4_shake_esk;
        map25.put(snovaParameters20, aSN1ObjectIdentifier114);
        SnovaParameters snovaParameters21 = SnovaParameters.SNOVA_37_17_2_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier115 = BCObjectIdentifiers.snova_37_17_2_ssk;
        map25.put(snovaParameters21, aSN1ObjectIdentifier115);
        SnovaParameters snovaParameters22 = SnovaParameters.SNOVA_37_17_2_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier116 = BCObjectIdentifiers.snova_37_17_2_esk;
        map25.put(snovaParameters22, aSN1ObjectIdentifier116);
        SnovaParameters snovaParameters23 = SnovaParameters.SNOVA_37_17_2_SHAKE_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier117 = BCObjectIdentifiers.snova_37_17_2_shake_ssk;
        map25.put(snovaParameters23, aSN1ObjectIdentifier117);
        SnovaParameters snovaParameters24 = SnovaParameters.SNOVA_37_17_2_SHAKE_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier118 = BCObjectIdentifiers.snova_37_17_2_shake_esk;
        map25.put(snovaParameters24, aSN1ObjectIdentifier118);
        SnovaParameters snovaParameters25 = SnovaParameters.SNOVA_49_11_3_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier119 = BCObjectIdentifiers.snova_49_11_3_ssk;
        map25.put(snovaParameters25, aSN1ObjectIdentifier119);
        SnovaParameters snovaParameters26 = SnovaParameters.SNOVA_49_11_3_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier120 = BCObjectIdentifiers.snova_49_11_3_esk;
        map25.put(snovaParameters26, aSN1ObjectIdentifier120);
        SnovaParameters snovaParameters27 = SnovaParameters.SNOVA_49_11_3_SHAKE_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier121 = BCObjectIdentifiers.snova_49_11_3_shake_ssk;
        map25.put(snovaParameters27, aSN1ObjectIdentifier121);
        SnovaParameters snovaParameters28 = SnovaParameters.SNOVA_49_11_3_SHAKE_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier122 = BCObjectIdentifiers.snova_49_11_3_shake_esk;
        map25.put(snovaParameters28, aSN1ObjectIdentifier122);
        SnovaParameters snovaParameters29 = SnovaParameters.SNOVA_56_25_2_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier123 = BCObjectIdentifiers.snova_56_25_2_ssk;
        map25.put(snovaParameters29, aSN1ObjectIdentifier123);
        SnovaParameters snovaParameters30 = SnovaParameters.SNOVA_56_25_2_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier124 = BCObjectIdentifiers.snova_56_25_2_esk;
        map25.put(snovaParameters30, aSN1ObjectIdentifier124);
        SnovaParameters snovaParameters31 = SnovaParameters.SNOVA_56_25_2_SHAKE_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier125 = BCObjectIdentifiers.snova_56_25_2_shake_ssk;
        map25.put(snovaParameters31, aSN1ObjectIdentifier125);
        SnovaParameters snovaParameters32 = SnovaParameters.SNOVA_56_25_2_SHAKE_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier126 = BCObjectIdentifiers.snova_56_25_2_shake_esk;
        map25.put(snovaParameters32, aSN1ObjectIdentifier126);
        SnovaParameters snovaParameters33 = SnovaParameters.SNOVA_60_10_4_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier127 = BCObjectIdentifiers.snova_60_10_4_ssk;
        map25.put(snovaParameters33, aSN1ObjectIdentifier127);
        SnovaParameters snovaParameters34 = SnovaParameters.SNOVA_60_10_4_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier128 = BCObjectIdentifiers.snova_60_10_4_esk;
        map25.put(snovaParameters34, aSN1ObjectIdentifier128);
        SnovaParameters snovaParameters35 = SnovaParameters.SNOVA_60_10_4_SHAKE_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier129 = BCObjectIdentifiers.snova_60_10_4_shake_ssk;
        map25.put(snovaParameters35, aSN1ObjectIdentifier129);
        SnovaParameters snovaParameters36 = SnovaParameters.SNOVA_60_10_4_SHAKE_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier130 = BCObjectIdentifiers.snova_60_10_4_shake_esk;
        map25.put(snovaParameters36, aSN1ObjectIdentifier130);
        SnovaParameters snovaParameters37 = SnovaParameters.SNOVA_66_15_3_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier131 = BCObjectIdentifiers.snova_66_15_3_ssk;
        map25.put(snovaParameters37, aSN1ObjectIdentifier131);
        SnovaParameters snovaParameters38 = SnovaParameters.SNOVA_66_15_3_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier132 = BCObjectIdentifiers.snova_66_15_3_esk;
        map25.put(snovaParameters38, aSN1ObjectIdentifier132);
        SnovaParameters snovaParameters39 = SnovaParameters.SNOVA_66_15_3_SHAKE_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier133 = BCObjectIdentifiers.snova_66_15_3_shake_ssk;
        map25.put(snovaParameters39, aSN1ObjectIdentifier133);
        SnovaParameters snovaParameters40 = SnovaParameters.SNOVA_66_15_3_SHAKE_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier134 = BCObjectIdentifiers.snova_66_15_3_shake_esk;
        map25.put(snovaParameters40, aSN1ObjectIdentifier134);
        SnovaParameters snovaParameters41 = SnovaParameters.SNOVA_75_33_2_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier135 = BCObjectIdentifiers.snova_75_33_2_ssk;
        map25.put(snovaParameters41, aSN1ObjectIdentifier135);
        SnovaParameters snovaParameters42 = SnovaParameters.SNOVA_75_33_2_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier136 = BCObjectIdentifiers.snova_75_33_2_esk;
        map25.put(snovaParameters42, aSN1ObjectIdentifier136);
        SnovaParameters snovaParameters43 = SnovaParameters.SNOVA_75_33_2_SHAKE_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier137 = BCObjectIdentifiers.snova_75_33_2_shake_ssk;
        map25.put(snovaParameters43, aSN1ObjectIdentifier137);
        SnovaParameters snovaParameters44 = SnovaParameters.SNOVA_75_33_2_SHAKE_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier138 = BCObjectIdentifiers.snova_75_33_2_shake_esk;
        map25.put(snovaParameters44, aSN1ObjectIdentifier138);
        map26.put(aSN1ObjectIdentifier95, snovaParameters);
        map26.put(aSN1ObjectIdentifier96, snovaParameters2);
        map26.put(aSN1ObjectIdentifier97, snovaParameters3);
        map26.put(aSN1ObjectIdentifier98, snovaParameters4);
        map26.put(aSN1ObjectIdentifier99, snovaParameters5);
        map26.put(aSN1ObjectIdentifier100, snovaParameters6);
        map26.put(aSN1ObjectIdentifier101, snovaParameters7);
        map26.put(aSN1ObjectIdentifier102, snovaParameters8);
        map26.put(aSN1ObjectIdentifier103, snovaParameters9);
        map26.put(aSN1ObjectIdentifier104, snovaParameters10);
        map26.put(aSN1ObjectIdentifier105, snovaParameters11);
        map26.put(aSN1ObjectIdentifier106, snovaParameters12);
        map26.put(aSN1ObjectIdentifier107, snovaParameters13);
        map26.put(aSN1ObjectIdentifier108, snovaParameters14);
        map26.put(aSN1ObjectIdentifier109, snovaParameters15);
        map26.put(aSN1ObjectIdentifier110, snovaParameters16);
        map26.put(aSN1ObjectIdentifier111, snovaParameters17);
        map26.put(aSN1ObjectIdentifier112, snovaParameters18);
        map26.put(aSN1ObjectIdentifier113, snovaParameters19);
        map26.put(aSN1ObjectIdentifier114, snovaParameters20);
        map26.put(aSN1ObjectIdentifier115, snovaParameters21);
        map26.put(aSN1ObjectIdentifier116, snovaParameters22);
        map26.put(aSN1ObjectIdentifier117, snovaParameters23);
        map26.put(aSN1ObjectIdentifier118, snovaParameters24);
        map26.put(aSN1ObjectIdentifier119, snovaParameters25);
        map26.put(aSN1ObjectIdentifier120, snovaParameters26);
        map26.put(aSN1ObjectIdentifier121, snovaParameters27);
        map26.put(aSN1ObjectIdentifier122, snovaParameters28);
        map26.put(aSN1ObjectIdentifier123, snovaParameters29);
        map26.put(aSN1ObjectIdentifier124, snovaParameters30);
        map26.put(aSN1ObjectIdentifier125, snovaParameters31);
        map26.put(aSN1ObjectIdentifier126, snovaParameters32);
        map26.put(aSN1ObjectIdentifier127, snovaParameters33);
        map26.put(aSN1ObjectIdentifier128, snovaParameters34);
        map26.put(aSN1ObjectIdentifier129, snovaParameters35);
        map26.put(aSN1ObjectIdentifier130, snovaParameters36);
        map26.put(aSN1ObjectIdentifier131, snovaParameters37);
        map26.put(aSN1ObjectIdentifier132, snovaParameters38);
        map26.put(aSN1ObjectIdentifier133, snovaParameters39);
        map26.put(aSN1ObjectIdentifier134, snovaParameters40);
        map26.put(aSN1ObjectIdentifier135, snovaParameters41);
        map26.put(aSN1ObjectIdentifier136, snovaParameters42);
        map26.put(aSN1ObjectIdentifier137, snovaParameters43);
        map26.put(aSN1ObjectIdentifier138, snovaParameters44);
        ASN1ObjectIdentifier aSN1ObjectIdentifier139 = BCObjectIdentifiers.ntruplus768;
        NTRUPlusParameters nTRUPlusParameters = NTRUPlusParameters.ntruplus_kem_768;
        map28.put(aSN1ObjectIdentifier139, nTRUPlusParameters);
        ASN1ObjectIdentifier aSN1ObjectIdentifier140 = BCObjectIdentifiers.ntruplus864;
        NTRUPlusParameters nTRUPlusParameters2 = NTRUPlusParameters.ntruplus_kem_864;
        map28.put(aSN1ObjectIdentifier140, nTRUPlusParameters2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier141 = BCObjectIdentifiers.ntruplus1152;
        NTRUPlusParameters nTRUPlusParameters3 = NTRUPlusParameters.ntruplus_kem_1152;
        map28.put(aSN1ObjectIdentifier141, nTRUPlusParameters3);
        map27.put(nTRUPlusParameters, aSN1ObjectIdentifier139);
        map27.put(nTRUPlusParameters2, aSN1ObjectIdentifier140);
        map27.put(nTRUPlusParameters3, aSN1ObjectIdentifier141);
    }

    public static ASN1ObjectIdentifier falconOidLookup(FalconParameters falconParameters) {
        return (ASN1ObjectIdentifier) falconOids.get(falconParameters);
    }

    public static FalconParameters falconParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (FalconParameters) falconParams.get(aSN1ObjectIdentifier);
    }

    public static ASN1ObjectIdentifier frodoOidLookup(FrodoParameters frodoParameters) {
        return (ASN1ObjectIdentifier) frodoOids.get(frodoParameters);
    }

    public static FrodoParameters frodoParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (FrodoParameters) frodoParams.get(aSN1ObjectIdentifier);
    }

    public static AlgorithmIdentifier getAlgorithmIdentifier(String str) {
        if (str.equals("SHA-1")) {
            return new AlgorithmIdentifier(OIWObjectIdentifiers.f21282idSHA1, C5103DERNull.INSTANCE);
        }
        if (str.equals("SHA-224")) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha224);
        }
        if (str.equals(XMSSKeyParameters.f23621SHA_256)) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256);
        }
        if (str.equals("SHA-384")) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha384);
        }
        if (str.equals(XMSSKeyParameters.f23622SHA_512)) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512);
        }
        throw new IllegalArgumentException("unrecognised digest algorithm: " + str);
    }

    public static InterfaceC5277Digest getDigest(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_sha256)) {
            return new SHA256Digest();
        }
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_sha512)) {
            return new SHA512Digest();
        }
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_shake128)) {
            return new SHAKEDigest(128);
        }
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_shake256)) {
            return new SHAKEDigest(256);
        }
        throw new IllegalArgumentException("unrecognized digest OID: " + aSN1ObjectIdentifier);
    }

    public static String getDigestName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) OIWObjectIdentifiers.f21282idSHA1)) {
            return "SHA-1";
        }
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_sha224)) {
            return "SHA-224";
        }
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_sha256)) {
            return XMSSKeyParameters.f23621SHA_256;
        }
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_sha384)) {
            return "SHA-384";
        }
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_sha512)) {
            return XMSSKeyParameters.f23622SHA_512;
        }
        throw new IllegalArgumentException("unrecognised digest algorithm: " + aSN1ObjectIdentifier);
    }

    public static ASN1ObjectIdentifier hqcOidLookup(HQCParameters hQCParameters) {
        return (ASN1ObjectIdentifier) f21139hqcOids.get(hQCParameters);
    }

    public static HQCParameters hqcParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (HQCParameters) hqcParams.get(aSN1ObjectIdentifier);
    }

    /* renamed from: isRaw */
    private static boolean m15935isRaw(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        byteArrayInputStream.read();
        return m15936readLen(byteArrayInputStream) != byteArrayInputStream.available();
    }

    public static ASN1ObjectIdentifier mayoOidLookup(MayoParameters mayoParameters) {
        return (ASN1ObjectIdentifier) mayoOids.get(mayoParameters);
    }

    public static MayoParameters mayoParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (MayoParameters) mayoParams.get(aSN1ObjectIdentifier);
    }

    public static ASN1ObjectIdentifier mcElieceOidLookup(CMCEParameters cMCEParameters) {
        return (ASN1ObjectIdentifier) mcElieceOids.get(cMCEParameters);
    }

    public static CMCEParameters mcElieceParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (CMCEParameters) mcElieceParams.get(aSN1ObjectIdentifier);
    }

    public static ASN1ObjectIdentifier mldsaOidLookup(MLDSAParameters mLDSAParameters) {
        return (ASN1ObjectIdentifier) mldsaOids.get(mLDSAParameters);
    }

    public static MLDSAParameters mldsaParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (MLDSAParameters) mldsaParams.get(aSN1ObjectIdentifier);
    }

    public static ASN1ObjectIdentifier mlkemOidLookup(MLKEMParameters mLKEMParameters) {
        return (ASN1ObjectIdentifier) mlkemOids.get(mLKEMParameters);
    }

    public static MLKEMParameters mlkemParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (MLKEMParameters) mlkemParams.get(aSN1ObjectIdentifier);
    }

    public static ASN1ObjectIdentifier ntruOidLookup(NTRUParameters nTRUParameters) {
        return (ASN1ObjectIdentifier) ntruOids.get(nTRUParameters);
    }

    public static NTRUParameters ntruParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (NTRUParameters) ntruParams.get(aSN1ObjectIdentifier);
    }

    public static ASN1ObjectIdentifier ntruPlusOidLookup(NTRUPlusParameters nTRUPlusParameters) {
        return (ASN1ObjectIdentifier) ntruPlusOids.get(nTRUPlusParameters);
    }

    public static NTRUPlusParameters ntruPlusParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (NTRUPlusParameters) ntruPlusParams.get(aSN1ObjectIdentifier);
    }

    public static ASN1ObjectIdentifier ntrulprimeOidLookup(NTRULPRimeParameters nTRULPRimeParameters) {
        return (ASN1ObjectIdentifier) ntruprimeOids.get(nTRULPRimeParameters);
    }

    public static NTRULPRimeParameters ntrulprimeParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (NTRULPRimeParameters) ntruprimeParams.get(aSN1ObjectIdentifier);
    }

    public static ASN1Primitive parseData(byte[] bArr) {
        if (m15935isRaw(bArr)) {
            return null;
        }
        byte b = bArr[0];
        if (b == 48) {
            return ASN1Sequence.getInstance(bArr);
        }
        if (b == 4) {
            return ASN1OctetString.getInstance(bArr);
        }
        if ((b & C1126UByte.MAX_VALUE) == 128) {
            return ASN1OctetString.getInstance(ASN1TaggedObject.getInstance(bArr), false);
        }
        return null;
    }

    public static ASN1OctetString parseOctetData(byte[] bArr) {
        if (m15935isRaw(bArr) || bArr[0] != 4) {
            return null;
        }
        return ASN1OctetString.getInstance(bArr);
    }

    /* renamed from: readLen */
    public static int m15936readLen(ByteArrayInputStream byteArrayInputStream) {
        int i = byteArrayInputStream.read();
        if (i < 0) {
            return -1;
        }
        int i2 = i & 127;
        if (i != i2) {
            i = 0;
            while (true) {
                int i3 = i2 - 1;
                if (i2 == 0) {
                    break;
                }
                i = (i << 8) + byteArrayInputStream.read();
                i2 = i3;
            }
        }
        return i;
    }

    public static ASN1ObjectIdentifier saberOidLookup(SABERParameters sABERParameters) {
        return (ASN1ObjectIdentifier) saberOids.get(sABERParameters);
    }

    public static SABERParameters saberParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (SABERParameters) saberParams.get(aSN1ObjectIdentifier);
    }

    public static ASN1ObjectIdentifier slhdsaOidLookup(SLHDSAParameters sLHDSAParameters) {
        return (ASN1ObjectIdentifier) slhdsaOids.get(sLHDSAParameters);
    }

    public static SLHDSAParameters slhdsaParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (SLHDSAParameters) slhdsaParams.get(aSN1ObjectIdentifier);
    }

    public static ASN1ObjectIdentifier snovaOidLookup(SnovaParameters snovaParameters) {
        return (ASN1ObjectIdentifier) snovaOids.get(snovaParameters);
    }

    public static SnovaParameters snovaParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (SnovaParameters) snovaParams.get(aSN1ObjectIdentifier);
    }

    public static ASN1ObjectIdentifier sntruprimeOidLookup(SNTRUPrimeParameters sNTRUPrimeParameters) {
        return (ASN1ObjectIdentifier) sntruprimeOids.get(sNTRUPrimeParameters);
    }

    public static SNTRUPrimeParameters sntruprimeParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (SNTRUPrimeParameters) sntruprimeParams.get(aSN1ObjectIdentifier);
    }
}
