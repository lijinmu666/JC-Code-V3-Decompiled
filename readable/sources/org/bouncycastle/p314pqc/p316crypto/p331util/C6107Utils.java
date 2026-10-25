package org.bouncycastle.p314pqc.p316crypto.p331util;

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
import org.bouncycastle.p314pqc.p315asn1.SPHINCS256KeyParams;
import org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.DilithiumParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruplus.NTRUPlusParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.NTRULPRimeParameters;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.SNTRUPrimeParameters;
import org.bouncycastle.p314pqc.p316crypto.p317cmce.CMCEParameters;
import org.bouncycastle.p314pqc.p316crypto.p318falcon.FalconParameters;
import org.bouncycastle.p314pqc.p316crypto.p319frodo.FrodoParameters;
import org.bouncycastle.p314pqc.p316crypto.p320hqc.HQCParameters;
import org.bouncycastle.p314pqc.p316crypto.p322mayo.MayoParameters;
import org.bouncycastle.p314pqc.p316crypto.p323mldsa.MLDSAParameters;
import org.bouncycastle.p314pqc.p316crypto.p324mlkem.MLKEMParameters;
import org.bouncycastle.p314pqc.p316crypto.p326ntru.NTRUParameters;
import org.bouncycastle.p314pqc.p316crypto.p327saber.SABERParameters;
import org.bouncycastle.p314pqc.p316crypto.p328slhdsa.SLHDSAParameters;
import org.bouncycastle.p314pqc.p316crypto.p329snova.SnovaParameters;
import org.bouncycastle.p314pqc.p316crypto.p330sphincs.SPHINCSKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;
import org.bouncycastle.p314pqc.p352legacy.p353bike.BIKEParameters;
import org.bouncycastle.p314pqc.p352legacy.p354picnic.PicnicParameters;
import org.bouncycastle.p314pqc.p352legacy.p355rainbow.RainbowParameters;
import org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusParameters;
import p094kotlin.C1126UByte;

/* renamed from: org.bouncycastle.pqc.crypto.util.Utils */
/* loaded from: classes2.dex */
class C6107Utils {
    static final AlgorithmIdentifier SPHINCS_SHA3_256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha3_256);
    static final AlgorithmIdentifier SPHINCS_SHA512_256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512_256);
    static final AlgorithmIdentifier XMSS_SHA256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256);
    static final AlgorithmIdentifier XMSS_SHA512 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512);
    static final AlgorithmIdentifier XMSS_SHAKE128 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_shake128);
    static final AlgorithmIdentifier XMSS_SHAKE256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_shake256);
    static final Map bikeOids;
    static final Map bikeParams;
    static final Map dilithiumOids;
    static final Map dilithiumParams;
    static final Map falconOids;
    static final Map falconParams;
    static final Map frodoOids;
    static final Map frodoParams;

    /* renamed from: hqcOids */
    static final Map f23591hqcOids;
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
    static final Map picnicOids;
    static final Map picnicParams;
    static final Map rainbowOids;
    static final Map rainbowParams;
    static final Map saberOids;
    static final Map saberParams;
    static final Map sikeOids;
    static final Map sikeParams;
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
        picnicOids = map;
        HashMap map2 = new HashMap();
        picnicParams = map2;
        HashMap map3 = new HashMap();
        frodoOids = map3;
        HashMap map4 = new HashMap();
        frodoParams = map4;
        HashMap map5 = new HashMap();
        saberOids = map5;
        HashMap map6 = new HashMap();
        saberParams = map6;
        HashMap map7 = new HashMap();
        mcElieceOids = map7;
        HashMap map8 = new HashMap();
        mcElieceParams = map8;
        HashMap map9 = new HashMap();
        sphincsPlusOids = map9;
        HashMap map10 = new HashMap();
        sphincsPlusParams = map10;
        sikeOids = new HashMap();
        sikeParams = new HashMap();
        HashMap map11 = new HashMap();
        ntruOids = map11;
        HashMap map12 = new HashMap();
        ntruParams = map12;
        HashMap map13 = new HashMap();
        falconOids = map13;
        HashMap map14 = new HashMap();
        falconParams = map14;
        HashMap map15 = new HashMap();
        ntruprimeOids = map15;
        HashMap map16 = new HashMap();
        ntruprimeParams = map16;
        HashMap map17 = new HashMap();
        sntruprimeOids = map17;
        HashMap map18 = new HashMap();
        sntruprimeParams = map18;
        HashMap map19 = new HashMap();
        dilithiumOids = map19;
        HashMap map20 = new HashMap();
        dilithiumParams = map20;
        HashMap map21 = new HashMap();
        bikeOids = map21;
        HashMap map22 = new HashMap();
        bikeParams = map22;
        HashMap map23 = new HashMap();
        f23591hqcOids = map23;
        HashMap map24 = new HashMap();
        hqcParams = map24;
        HashMap map25 = new HashMap();
        rainbowOids = map25;
        HashMap map26 = new HashMap();
        rainbowParams = map26;
        HashMap map27 = new HashMap();
        mlkemOids = map27;
        HashMap map28 = new HashMap();
        mlkemParams = map28;
        HashMap map29 = new HashMap();
        mldsaOids = map29;
        HashMap map30 = new HashMap();
        mldsaParams = map30;
        HashMap map31 = new HashMap();
        slhdsaOids = map31;
        HashMap map32 = new HashMap();
        slhdsaParams = map32;
        HashMap map33 = new HashMap();
        mayoOids = map33;
        HashMap map34 = new HashMap();
        mayoParams = map34;
        HashMap map35 = new HashMap();
        snovaOids = map35;
        HashMap map36 = new HashMap();
        snovaParams = map36;
        HashMap map37 = new HashMap();
        ntruPlusOids = map37;
        HashMap map38 = new HashMap();
        ntruPlusParams = map38;
        CMCEParameters cMCEParameters = CMCEParameters.mceliece348864r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = BCObjectIdentifiers.mceliece348864_r3;
        map7.put(cMCEParameters, aSN1ObjectIdentifier);
        CMCEParameters cMCEParameters2 = CMCEParameters.mceliece348864fr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = BCObjectIdentifiers.mceliece348864f_r3;
        map7.put(cMCEParameters2, aSN1ObjectIdentifier2);
        CMCEParameters cMCEParameters3 = CMCEParameters.mceliece460896r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = BCObjectIdentifiers.mceliece460896_r3;
        map7.put(cMCEParameters3, aSN1ObjectIdentifier3);
        CMCEParameters cMCEParameters4 = CMCEParameters.mceliece460896fr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = BCObjectIdentifiers.mceliece460896f_r3;
        map7.put(cMCEParameters4, aSN1ObjectIdentifier4);
        CMCEParameters cMCEParameters5 = CMCEParameters.mceliece6688128r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = BCObjectIdentifiers.mceliece6688128_r3;
        map7.put(cMCEParameters5, aSN1ObjectIdentifier5);
        CMCEParameters cMCEParameters6 = CMCEParameters.mceliece6688128fr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = BCObjectIdentifiers.mceliece6688128f_r3;
        map7.put(cMCEParameters6, aSN1ObjectIdentifier6);
        CMCEParameters cMCEParameters7 = CMCEParameters.mceliece6960119r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = BCObjectIdentifiers.mceliece6960119_r3;
        map7.put(cMCEParameters7, aSN1ObjectIdentifier7);
        CMCEParameters cMCEParameters8 = CMCEParameters.mceliece6960119fr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = BCObjectIdentifiers.mceliece6960119f_r3;
        map7.put(cMCEParameters8, aSN1ObjectIdentifier8);
        CMCEParameters cMCEParameters9 = CMCEParameters.mceliece8192128r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = BCObjectIdentifiers.mceliece8192128_r3;
        map7.put(cMCEParameters9, aSN1ObjectIdentifier9);
        CMCEParameters cMCEParameters10 = CMCEParameters.mceliece8192128fr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = BCObjectIdentifiers.mceliece8192128f_r3;
        map7.put(cMCEParameters10, aSN1ObjectIdentifier10);
        map8.put(aSN1ObjectIdentifier, cMCEParameters);
        map8.put(aSN1ObjectIdentifier2, cMCEParameters2);
        map8.put(aSN1ObjectIdentifier3, cMCEParameters3);
        map8.put(aSN1ObjectIdentifier4, cMCEParameters4);
        map8.put(aSN1ObjectIdentifier5, cMCEParameters5);
        map8.put(aSN1ObjectIdentifier6, cMCEParameters6);
        map8.put(aSN1ObjectIdentifier7, cMCEParameters7);
        map8.put(aSN1ObjectIdentifier8, cMCEParameters8);
        map8.put(aSN1ObjectIdentifier9, cMCEParameters9);
        map8.put(aSN1ObjectIdentifier10, cMCEParameters10);
        FrodoParameters frodoParameters = FrodoParameters.frodokem640aes;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = BCObjectIdentifiers.frodokem640aes;
        map3.put(frodoParameters, aSN1ObjectIdentifier11);
        FrodoParameters frodoParameters2 = FrodoParameters.frodokem640shake;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = BCObjectIdentifiers.frodokem640shake;
        map3.put(frodoParameters2, aSN1ObjectIdentifier12);
        FrodoParameters frodoParameters3 = FrodoParameters.frodokem976aes;
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = BCObjectIdentifiers.frodokem976aes;
        map3.put(frodoParameters3, aSN1ObjectIdentifier13);
        FrodoParameters frodoParameters4 = FrodoParameters.frodokem976shake;
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = BCObjectIdentifiers.frodokem976shake;
        map3.put(frodoParameters4, aSN1ObjectIdentifier14);
        FrodoParameters frodoParameters5 = FrodoParameters.frodokem1344aes;
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = BCObjectIdentifiers.frodokem1344aes;
        map3.put(frodoParameters5, aSN1ObjectIdentifier15);
        FrodoParameters frodoParameters6 = FrodoParameters.frodokem1344shake;
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = BCObjectIdentifiers.frodokem1344shake;
        map3.put(frodoParameters6, aSN1ObjectIdentifier16);
        map4.put(aSN1ObjectIdentifier11, frodoParameters);
        map4.put(aSN1ObjectIdentifier12, frodoParameters2);
        map4.put(aSN1ObjectIdentifier13, frodoParameters3);
        map4.put(aSN1ObjectIdentifier14, frodoParameters4);
        map4.put(aSN1ObjectIdentifier15, frodoParameters5);
        map4.put(aSN1ObjectIdentifier16, frodoParameters6);
        SABERParameters sABERParameters = SABERParameters.lightsaberkem128r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = BCObjectIdentifiers.lightsaberkem128r3;
        map5.put(sABERParameters, aSN1ObjectIdentifier17);
        SABERParameters sABERParameters2 = SABERParameters.saberkem128r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier18 = BCObjectIdentifiers.saberkem128r3;
        map5.put(sABERParameters2, aSN1ObjectIdentifier18);
        SABERParameters sABERParameters3 = SABERParameters.firesaberkem128r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier19 = BCObjectIdentifiers.firesaberkem128r3;
        map5.put(sABERParameters3, aSN1ObjectIdentifier19);
        SABERParameters sABERParameters4 = SABERParameters.lightsaberkem192r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier20 = BCObjectIdentifiers.lightsaberkem192r3;
        map5.put(sABERParameters4, aSN1ObjectIdentifier20);
        SABERParameters sABERParameters5 = SABERParameters.saberkem192r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier21 = BCObjectIdentifiers.saberkem192r3;
        map5.put(sABERParameters5, aSN1ObjectIdentifier21);
        SABERParameters sABERParameters6 = SABERParameters.firesaberkem192r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier22 = BCObjectIdentifiers.firesaberkem192r3;
        map5.put(sABERParameters6, aSN1ObjectIdentifier22);
        SABERParameters sABERParameters7 = SABERParameters.lightsaberkem256r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier23 = BCObjectIdentifiers.lightsaberkem256r3;
        map5.put(sABERParameters7, aSN1ObjectIdentifier23);
        SABERParameters sABERParameters8 = SABERParameters.saberkem256r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier24 = BCObjectIdentifiers.saberkem256r3;
        map5.put(sABERParameters8, aSN1ObjectIdentifier24);
        SABERParameters sABERParameters9 = SABERParameters.firesaberkem256r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier25 = BCObjectIdentifiers.firesaberkem256r3;
        map5.put(sABERParameters9, aSN1ObjectIdentifier25);
        SABERParameters sABERParameters10 = SABERParameters.ulightsaberkemr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier26 = BCObjectIdentifiers.ulightsaberkemr3;
        map5.put(sABERParameters10, aSN1ObjectIdentifier26);
        SABERParameters sABERParameters11 = SABERParameters.usaberkemr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier27 = BCObjectIdentifiers.usaberkemr3;
        map5.put(sABERParameters11, aSN1ObjectIdentifier27);
        SABERParameters sABERParameters12 = SABERParameters.ufiresaberkemr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier28 = BCObjectIdentifiers.ufiresaberkemr3;
        map5.put(sABERParameters12, aSN1ObjectIdentifier28);
        SABERParameters sABERParameters13 = SABERParameters.lightsaberkem90sr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier29 = BCObjectIdentifiers.lightsaberkem90sr3;
        map5.put(sABERParameters13, aSN1ObjectIdentifier29);
        SABERParameters sABERParameters14 = SABERParameters.saberkem90sr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier30 = BCObjectIdentifiers.saberkem90sr3;
        map5.put(sABERParameters14, aSN1ObjectIdentifier30);
        SABERParameters sABERParameters15 = SABERParameters.firesaberkem90sr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier31 = BCObjectIdentifiers.firesaberkem90sr3;
        map5.put(sABERParameters15, aSN1ObjectIdentifier31);
        SABERParameters sABERParameters16 = SABERParameters.ulightsaberkem90sr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier32 = BCObjectIdentifiers.ulightsaberkem90sr3;
        map5.put(sABERParameters16, aSN1ObjectIdentifier32);
        SABERParameters sABERParameters17 = SABERParameters.usaberkem90sr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier33 = BCObjectIdentifiers.usaberkem90sr3;
        map5.put(sABERParameters17, aSN1ObjectIdentifier33);
        SABERParameters sABERParameters18 = SABERParameters.ufiresaberkem90sr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier34 = BCObjectIdentifiers.ufiresaberkem90sr3;
        map5.put(sABERParameters18, aSN1ObjectIdentifier34);
        map6.put(aSN1ObjectIdentifier17, sABERParameters);
        map6.put(aSN1ObjectIdentifier18, sABERParameters2);
        map6.put(aSN1ObjectIdentifier19, sABERParameters3);
        map6.put(aSN1ObjectIdentifier20, sABERParameters4);
        map6.put(aSN1ObjectIdentifier21, sABERParameters5);
        map6.put(aSN1ObjectIdentifier22, sABERParameters6);
        map6.put(aSN1ObjectIdentifier23, sABERParameters7);
        map6.put(aSN1ObjectIdentifier24, sABERParameters8);
        map6.put(aSN1ObjectIdentifier25, sABERParameters9);
        map6.put(aSN1ObjectIdentifier26, sABERParameters10);
        map6.put(aSN1ObjectIdentifier27, sABERParameters11);
        map6.put(aSN1ObjectIdentifier28, sABERParameters12);
        map6.put(aSN1ObjectIdentifier29, sABERParameters13);
        map6.put(aSN1ObjectIdentifier30, sABERParameters14);
        map6.put(aSN1ObjectIdentifier31, sABERParameters15);
        map6.put(aSN1ObjectIdentifier32, sABERParameters16);
        map6.put(aSN1ObjectIdentifier33, sABERParameters17);
        map6.put(aSN1ObjectIdentifier34, sABERParameters18);
        PicnicParameters picnicParameters = PicnicParameters.picnicl1fs;
        ASN1ObjectIdentifier aSN1ObjectIdentifier35 = BCObjectIdentifiers.picnicl1fs;
        map.put(picnicParameters, aSN1ObjectIdentifier35);
        PicnicParameters picnicParameters2 = PicnicParameters.picnicl1ur;
        ASN1ObjectIdentifier aSN1ObjectIdentifier36 = BCObjectIdentifiers.picnicl1ur;
        map.put(picnicParameters2, aSN1ObjectIdentifier36);
        PicnicParameters picnicParameters3 = PicnicParameters.picnicl3fs;
        ASN1ObjectIdentifier aSN1ObjectIdentifier37 = BCObjectIdentifiers.picnicl3fs;
        map.put(picnicParameters3, aSN1ObjectIdentifier37);
        PicnicParameters picnicParameters4 = PicnicParameters.picnicl3ur;
        ASN1ObjectIdentifier aSN1ObjectIdentifier38 = BCObjectIdentifiers.picnicl3ur;
        map.put(picnicParameters4, aSN1ObjectIdentifier38);
        PicnicParameters picnicParameters5 = PicnicParameters.picnicl5fs;
        ASN1ObjectIdentifier aSN1ObjectIdentifier39 = BCObjectIdentifiers.picnicl5fs;
        map.put(picnicParameters5, aSN1ObjectIdentifier39);
        PicnicParameters picnicParameters6 = PicnicParameters.picnicl5ur;
        ASN1ObjectIdentifier aSN1ObjectIdentifier40 = BCObjectIdentifiers.picnicl5ur;
        map.put(picnicParameters6, aSN1ObjectIdentifier40);
        PicnicParameters picnicParameters7 = PicnicParameters.picnic3l1;
        ASN1ObjectIdentifier aSN1ObjectIdentifier41 = BCObjectIdentifiers.picnic3l1;
        map.put(picnicParameters7, aSN1ObjectIdentifier41);
        PicnicParameters picnicParameters8 = PicnicParameters.picnic3l3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier42 = BCObjectIdentifiers.picnic3l3;
        map.put(picnicParameters8, aSN1ObjectIdentifier42);
        PicnicParameters picnicParameters9 = PicnicParameters.picnic3l5;
        ASN1ObjectIdentifier aSN1ObjectIdentifier43 = BCObjectIdentifiers.picnic3l5;
        map.put(picnicParameters9, aSN1ObjectIdentifier43);
        PicnicParameters picnicParameters10 = PicnicParameters.picnicl1full;
        ASN1ObjectIdentifier aSN1ObjectIdentifier44 = BCObjectIdentifiers.picnicl1full;
        map.put(picnicParameters10, aSN1ObjectIdentifier44);
        PicnicParameters picnicParameters11 = PicnicParameters.picnicl3full;
        ASN1ObjectIdentifier aSN1ObjectIdentifier45 = BCObjectIdentifiers.picnicl3full;
        map.put(picnicParameters11, aSN1ObjectIdentifier45);
        PicnicParameters picnicParameters12 = PicnicParameters.picnicl5full;
        ASN1ObjectIdentifier aSN1ObjectIdentifier46 = BCObjectIdentifiers.picnicl5full;
        map.put(picnicParameters12, aSN1ObjectIdentifier46);
        map2.put(aSN1ObjectIdentifier35, picnicParameters);
        map2.put(aSN1ObjectIdentifier36, picnicParameters2);
        map2.put(aSN1ObjectIdentifier37, picnicParameters3);
        map2.put(aSN1ObjectIdentifier38, picnicParameters4);
        map2.put(aSN1ObjectIdentifier39, picnicParameters5);
        map2.put(aSN1ObjectIdentifier40, picnicParameters6);
        map2.put(aSN1ObjectIdentifier41, picnicParameters7);
        map2.put(aSN1ObjectIdentifier42, picnicParameters8);
        map2.put(aSN1ObjectIdentifier43, picnicParameters9);
        map2.put(aSN1ObjectIdentifier44, picnicParameters10);
        map2.put(aSN1ObjectIdentifier45, picnicParameters11);
        map2.put(aSN1ObjectIdentifier46, picnicParameters12);
        NTRUParameters nTRUParameters = NTRUParameters.ntruhps2048509;
        ASN1ObjectIdentifier aSN1ObjectIdentifier47 = BCObjectIdentifiers.ntruhps2048509;
        map11.put(nTRUParameters, aSN1ObjectIdentifier47);
        NTRUParameters nTRUParameters2 = NTRUParameters.ntruhps2048677;
        ASN1ObjectIdentifier aSN1ObjectIdentifier48 = BCObjectIdentifiers.ntruhps2048677;
        map11.put(nTRUParameters2, aSN1ObjectIdentifier48);
        NTRUParameters nTRUParameters3 = NTRUParameters.ntruhps4096821;
        ASN1ObjectIdentifier aSN1ObjectIdentifier49 = BCObjectIdentifiers.ntruhps4096821;
        map11.put(nTRUParameters3, aSN1ObjectIdentifier49);
        NTRUParameters nTRUParameters4 = NTRUParameters.ntruhps40961229;
        ASN1ObjectIdentifier aSN1ObjectIdentifier50 = BCObjectIdentifiers.ntruhps40961229;
        map11.put(nTRUParameters4, aSN1ObjectIdentifier50);
        NTRUParameters nTRUParameters5 = NTRUParameters.ntruhrss701;
        ASN1ObjectIdentifier aSN1ObjectIdentifier51 = BCObjectIdentifiers.ntruhrss701;
        map11.put(nTRUParameters5, aSN1ObjectIdentifier51);
        NTRUParameters nTRUParameters6 = NTRUParameters.ntruhrss1373;
        ASN1ObjectIdentifier aSN1ObjectIdentifier52 = BCObjectIdentifiers.ntruhrss1373;
        map11.put(nTRUParameters6, aSN1ObjectIdentifier52);
        map12.put(aSN1ObjectIdentifier47, nTRUParameters);
        map12.put(aSN1ObjectIdentifier48, nTRUParameters2);
        map12.put(aSN1ObjectIdentifier49, nTRUParameters3);
        map12.put(aSN1ObjectIdentifier50, nTRUParameters4);
        map12.put(aSN1ObjectIdentifier51, nTRUParameters5);
        map12.put(aSN1ObjectIdentifier52, nTRUParameters6);
        FalconParameters falconParameters = FalconParameters.falcon_512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier53 = BCObjectIdentifiers.falcon_512;
        map13.put(falconParameters, aSN1ObjectIdentifier53);
        FalconParameters falconParameters2 = FalconParameters.falcon_1024;
        ASN1ObjectIdentifier aSN1ObjectIdentifier54 = BCObjectIdentifiers.falcon_1024;
        map13.put(falconParameters2, aSN1ObjectIdentifier54);
        map14.put(aSN1ObjectIdentifier53, falconParameters);
        map14.put(aSN1ObjectIdentifier54, falconParameters2);
        map14.put(BCObjectIdentifiers.old_falcon_512, falconParameters);
        map14.put(BCObjectIdentifiers.old_falcon_1024, falconParameters2);
        MLKEMParameters mLKEMParameters = MLKEMParameters.ml_kem_512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier55 = NISTObjectIdentifiers.id_alg_ml_kem_512;
        map27.put(mLKEMParameters, aSN1ObjectIdentifier55);
        MLKEMParameters mLKEMParameters2 = MLKEMParameters.ml_kem_768;
        ASN1ObjectIdentifier aSN1ObjectIdentifier56 = NISTObjectIdentifiers.id_alg_ml_kem_768;
        map27.put(mLKEMParameters2, aSN1ObjectIdentifier56);
        MLKEMParameters mLKEMParameters3 = MLKEMParameters.ml_kem_1024;
        ASN1ObjectIdentifier aSN1ObjectIdentifier57 = NISTObjectIdentifiers.id_alg_ml_kem_1024;
        map27.put(mLKEMParameters3, aSN1ObjectIdentifier57);
        map28.put(aSN1ObjectIdentifier55, mLKEMParameters);
        map28.put(aSN1ObjectIdentifier56, mLKEMParameters2);
        map28.put(aSN1ObjectIdentifier57, mLKEMParameters3);
        NTRULPRimeParameters nTRULPRimeParameters = NTRULPRimeParameters.ntrulpr653;
        ASN1ObjectIdentifier aSN1ObjectIdentifier58 = BCObjectIdentifiers.ntrulpr653;
        map15.put(nTRULPRimeParameters, aSN1ObjectIdentifier58);
        NTRULPRimeParameters nTRULPRimeParameters2 = NTRULPRimeParameters.ntrulpr761;
        ASN1ObjectIdentifier aSN1ObjectIdentifier59 = BCObjectIdentifiers.ntrulpr761;
        map15.put(nTRULPRimeParameters2, aSN1ObjectIdentifier59);
        NTRULPRimeParameters nTRULPRimeParameters3 = NTRULPRimeParameters.ntrulpr857;
        ASN1ObjectIdentifier aSN1ObjectIdentifier60 = BCObjectIdentifiers.ntrulpr857;
        map15.put(nTRULPRimeParameters3, aSN1ObjectIdentifier60);
        NTRULPRimeParameters nTRULPRimeParameters4 = NTRULPRimeParameters.ntrulpr953;
        ASN1ObjectIdentifier aSN1ObjectIdentifier61 = BCObjectIdentifiers.ntrulpr953;
        map15.put(nTRULPRimeParameters4, aSN1ObjectIdentifier61);
        NTRULPRimeParameters nTRULPRimeParameters5 = NTRULPRimeParameters.ntrulpr1013;
        ASN1ObjectIdentifier aSN1ObjectIdentifier62 = BCObjectIdentifiers.ntrulpr1013;
        map15.put(nTRULPRimeParameters5, aSN1ObjectIdentifier62);
        NTRULPRimeParameters nTRULPRimeParameters6 = NTRULPRimeParameters.ntrulpr1277;
        ASN1ObjectIdentifier aSN1ObjectIdentifier63 = BCObjectIdentifiers.ntrulpr1277;
        map15.put(nTRULPRimeParameters6, aSN1ObjectIdentifier63);
        map16.put(aSN1ObjectIdentifier58, nTRULPRimeParameters);
        map16.put(aSN1ObjectIdentifier59, nTRULPRimeParameters2);
        map16.put(aSN1ObjectIdentifier60, nTRULPRimeParameters3);
        map16.put(aSN1ObjectIdentifier61, nTRULPRimeParameters4);
        map16.put(aSN1ObjectIdentifier62, nTRULPRimeParameters5);
        map16.put(aSN1ObjectIdentifier63, nTRULPRimeParameters6);
        SNTRUPrimeParameters sNTRUPrimeParameters = SNTRUPrimeParameters.sntrup653;
        ASN1ObjectIdentifier aSN1ObjectIdentifier64 = BCObjectIdentifiers.sntrup653;
        map17.put(sNTRUPrimeParameters, aSN1ObjectIdentifier64);
        SNTRUPrimeParameters sNTRUPrimeParameters2 = SNTRUPrimeParameters.sntrup761;
        ASN1ObjectIdentifier aSN1ObjectIdentifier65 = BCObjectIdentifiers.sntrup761;
        map17.put(sNTRUPrimeParameters2, aSN1ObjectIdentifier65);
        SNTRUPrimeParameters sNTRUPrimeParameters3 = SNTRUPrimeParameters.sntrup857;
        ASN1ObjectIdentifier aSN1ObjectIdentifier66 = BCObjectIdentifiers.sntrup857;
        map17.put(sNTRUPrimeParameters3, aSN1ObjectIdentifier66);
        SNTRUPrimeParameters sNTRUPrimeParameters4 = SNTRUPrimeParameters.sntrup953;
        ASN1ObjectIdentifier aSN1ObjectIdentifier67 = BCObjectIdentifiers.sntrup953;
        map17.put(sNTRUPrimeParameters4, aSN1ObjectIdentifier67);
        SNTRUPrimeParameters sNTRUPrimeParameters5 = SNTRUPrimeParameters.sntrup1013;
        ASN1ObjectIdentifier aSN1ObjectIdentifier68 = BCObjectIdentifiers.sntrup1013;
        map17.put(sNTRUPrimeParameters5, aSN1ObjectIdentifier68);
        SNTRUPrimeParameters sNTRUPrimeParameters6 = SNTRUPrimeParameters.sntrup1277;
        ASN1ObjectIdentifier aSN1ObjectIdentifier69 = BCObjectIdentifiers.sntrup1277;
        map17.put(sNTRUPrimeParameters6, aSN1ObjectIdentifier69);
        map18.put(aSN1ObjectIdentifier64, sNTRUPrimeParameters);
        map18.put(aSN1ObjectIdentifier65, sNTRUPrimeParameters2);
        map18.put(aSN1ObjectIdentifier66, sNTRUPrimeParameters3);
        map18.put(aSN1ObjectIdentifier67, sNTRUPrimeParameters4);
        map18.put(aSN1ObjectIdentifier68, sNTRUPrimeParameters5);
        map18.put(aSN1ObjectIdentifier69, sNTRUPrimeParameters6);
        MLDSAParameters mLDSAParameters = MLDSAParameters.ml_dsa_44;
        ASN1ObjectIdentifier aSN1ObjectIdentifier70 = NISTObjectIdentifiers.id_ml_dsa_44;
        map29.put(mLDSAParameters, aSN1ObjectIdentifier70);
        MLDSAParameters mLDSAParameters2 = MLDSAParameters.ml_dsa_65;
        ASN1ObjectIdentifier aSN1ObjectIdentifier71 = NISTObjectIdentifiers.id_ml_dsa_65;
        map29.put(mLDSAParameters2, aSN1ObjectIdentifier71);
        MLDSAParameters mLDSAParameters3 = MLDSAParameters.ml_dsa_87;
        ASN1ObjectIdentifier aSN1ObjectIdentifier72 = NISTObjectIdentifiers.id_ml_dsa_87;
        map29.put(mLDSAParameters3, aSN1ObjectIdentifier72);
        MLDSAParameters mLDSAParameters4 = MLDSAParameters.ml_dsa_44_with_sha512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier73 = NISTObjectIdentifiers.id_hash_ml_dsa_44_with_sha512;
        map29.put(mLDSAParameters4, aSN1ObjectIdentifier73);
        MLDSAParameters mLDSAParameters5 = MLDSAParameters.ml_dsa_65_with_sha512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier74 = NISTObjectIdentifiers.id_hash_ml_dsa_65_with_sha512;
        map29.put(mLDSAParameters5, aSN1ObjectIdentifier74);
        MLDSAParameters mLDSAParameters6 = MLDSAParameters.ml_dsa_87_with_sha512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier75 = NISTObjectIdentifiers.id_hash_ml_dsa_87_with_sha512;
        map29.put(mLDSAParameters6, aSN1ObjectIdentifier75);
        map30.put(aSN1ObjectIdentifier70, mLDSAParameters);
        map30.put(aSN1ObjectIdentifier71, mLDSAParameters2);
        map30.put(aSN1ObjectIdentifier72, mLDSAParameters3);
        map30.put(aSN1ObjectIdentifier73, mLDSAParameters4);
        map30.put(aSN1ObjectIdentifier74, mLDSAParameters5);
        map30.put(aSN1ObjectIdentifier75, mLDSAParameters6);
        DilithiumParameters dilithiumParameters = DilithiumParameters.dilithium2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier76 = BCObjectIdentifiers.dilithium2;
        map19.put(dilithiumParameters, aSN1ObjectIdentifier76);
        DilithiumParameters dilithiumParameters2 = DilithiumParameters.dilithium3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier77 = BCObjectIdentifiers.dilithium3;
        map19.put(dilithiumParameters2, aSN1ObjectIdentifier77);
        DilithiumParameters dilithiumParameters3 = DilithiumParameters.dilithium5;
        ASN1ObjectIdentifier aSN1ObjectIdentifier78 = BCObjectIdentifiers.dilithium5;
        map19.put(dilithiumParameters3, aSN1ObjectIdentifier78);
        map20.put(aSN1ObjectIdentifier76, dilithiumParameters);
        map20.put(aSN1ObjectIdentifier77, dilithiumParameters2);
        map20.put(aSN1ObjectIdentifier78, dilithiumParameters3);
        ASN1ObjectIdentifier aSN1ObjectIdentifier79 = BCObjectIdentifiers.f18019bike128;
        BIKEParameters bIKEParameters = BIKEParameters.f23947bike128;
        map22.put(aSN1ObjectIdentifier79, bIKEParameters);
        ASN1ObjectIdentifier aSN1ObjectIdentifier80 = BCObjectIdentifiers.f18020bike192;
        BIKEParameters bIKEParameters2 = BIKEParameters.f23948bike192;
        map22.put(aSN1ObjectIdentifier80, bIKEParameters2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier81 = BCObjectIdentifiers.f18021bike256;
        BIKEParameters bIKEParameters3 = BIKEParameters.f23949bike256;
        map22.put(aSN1ObjectIdentifier81, bIKEParameters3);
        map21.put(bIKEParameters, aSN1ObjectIdentifier79);
        map21.put(bIKEParameters2, aSN1ObjectIdentifier80);
        map21.put(bIKEParameters3, aSN1ObjectIdentifier81);
        ASN1ObjectIdentifier aSN1ObjectIdentifier82 = BCObjectIdentifiers.f18023hqc128;
        HQCParameters hQCParameters = HQCParameters.f23200hqc128;
        map24.put(aSN1ObjectIdentifier82, hQCParameters);
        ASN1ObjectIdentifier aSN1ObjectIdentifier83 = BCObjectIdentifiers.f18024hqc192;
        HQCParameters hQCParameters2 = HQCParameters.f23201hqc192;
        map24.put(aSN1ObjectIdentifier83, hQCParameters2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier84 = BCObjectIdentifiers.f18025hqc256;
        HQCParameters hQCParameters3 = HQCParameters.f23202hqc256;
        map24.put(aSN1ObjectIdentifier84, hQCParameters3);
        map23.put(hQCParameters, aSN1ObjectIdentifier82);
        map23.put(hQCParameters2, aSN1ObjectIdentifier83);
        map23.put(hQCParameters3, aSN1ObjectIdentifier84);
        ASN1ObjectIdentifier aSN1ObjectIdentifier85 = BCObjectIdentifiers.rainbow_III_classic;
        RainbowParameters rainbowParameters = RainbowParameters.rainbowIIIclassic;
        map26.put(aSN1ObjectIdentifier85, rainbowParameters);
        ASN1ObjectIdentifier aSN1ObjectIdentifier86 = BCObjectIdentifiers.rainbow_III_circumzenithal;
        RainbowParameters rainbowParameters2 = RainbowParameters.rainbowIIIcircumzenithal;
        map26.put(aSN1ObjectIdentifier86, rainbowParameters2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier87 = BCObjectIdentifiers.rainbow_III_compressed;
        RainbowParameters rainbowParameters3 = RainbowParameters.rainbowIIIcompressed;
        map26.put(aSN1ObjectIdentifier87, rainbowParameters3);
        ASN1ObjectIdentifier aSN1ObjectIdentifier88 = BCObjectIdentifiers.rainbow_V_classic;
        RainbowParameters rainbowParameters4 = RainbowParameters.rainbowVclassic;
        map26.put(aSN1ObjectIdentifier88, rainbowParameters4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier89 = BCObjectIdentifiers.rainbow_V_circumzenithal;
        RainbowParameters rainbowParameters5 = RainbowParameters.rainbowVcircumzenithal;
        map26.put(aSN1ObjectIdentifier89, rainbowParameters5);
        ASN1ObjectIdentifier aSN1ObjectIdentifier90 = BCObjectIdentifiers.rainbow_V_compressed;
        RainbowParameters rainbowParameters6 = RainbowParameters.rainbowVcompressed;
        map26.put(aSN1ObjectIdentifier90, rainbowParameters6);
        map25.put(rainbowParameters, aSN1ObjectIdentifier85);
        map25.put(rainbowParameters2, aSN1ObjectIdentifier86);
        map25.put(rainbowParameters3, aSN1ObjectIdentifier87);
        map25.put(rainbowParameters4, aSN1ObjectIdentifier88);
        map25.put(rainbowParameters5, aSN1ObjectIdentifier89);
        map25.put(rainbowParameters6, aSN1ObjectIdentifier90);
        SLHDSAParameters sLHDSAParameters = SLHDSAParameters.sha2_128s;
        ASN1ObjectIdentifier aSN1ObjectIdentifier91 = NISTObjectIdentifiers.id_slh_dsa_sha2_128s;
        map31.put(sLHDSAParameters, aSN1ObjectIdentifier91);
        SLHDSAParameters sLHDSAParameters2 = SLHDSAParameters.sha2_128f;
        ASN1ObjectIdentifier aSN1ObjectIdentifier92 = NISTObjectIdentifiers.id_slh_dsa_sha2_128f;
        map31.put(sLHDSAParameters2, aSN1ObjectIdentifier92);
        SLHDSAParameters sLHDSAParameters3 = SLHDSAParameters.sha2_192s;
        ASN1ObjectIdentifier aSN1ObjectIdentifier93 = NISTObjectIdentifiers.id_slh_dsa_sha2_192s;
        map31.put(sLHDSAParameters3, aSN1ObjectIdentifier93);
        SLHDSAParameters sLHDSAParameters4 = SLHDSAParameters.sha2_192f;
        ASN1ObjectIdentifier aSN1ObjectIdentifier94 = NISTObjectIdentifiers.id_slh_dsa_sha2_192f;
        map31.put(sLHDSAParameters4, aSN1ObjectIdentifier94);
        SLHDSAParameters sLHDSAParameters5 = SLHDSAParameters.sha2_256s;
        ASN1ObjectIdentifier aSN1ObjectIdentifier95 = NISTObjectIdentifiers.id_slh_dsa_sha2_256s;
        map31.put(sLHDSAParameters5, aSN1ObjectIdentifier95);
        SLHDSAParameters sLHDSAParameters6 = SLHDSAParameters.sha2_256f;
        ASN1ObjectIdentifier aSN1ObjectIdentifier96 = NISTObjectIdentifiers.id_slh_dsa_sha2_256f;
        map31.put(sLHDSAParameters6, aSN1ObjectIdentifier96);
        SLHDSAParameters sLHDSAParameters7 = SLHDSAParameters.shake_128s;
        ASN1ObjectIdentifier aSN1ObjectIdentifier97 = NISTObjectIdentifiers.id_slh_dsa_shake_128s;
        map31.put(sLHDSAParameters7, aSN1ObjectIdentifier97);
        SLHDSAParameters sLHDSAParameters8 = SLHDSAParameters.shake_128f;
        ASN1ObjectIdentifier aSN1ObjectIdentifier98 = NISTObjectIdentifiers.id_slh_dsa_shake_128f;
        map31.put(sLHDSAParameters8, aSN1ObjectIdentifier98);
        SLHDSAParameters sLHDSAParameters9 = SLHDSAParameters.shake_192s;
        ASN1ObjectIdentifier aSN1ObjectIdentifier99 = NISTObjectIdentifiers.id_slh_dsa_shake_192s;
        map31.put(sLHDSAParameters9, aSN1ObjectIdentifier99);
        SLHDSAParameters sLHDSAParameters10 = SLHDSAParameters.shake_192f;
        ASN1ObjectIdentifier aSN1ObjectIdentifier100 = NISTObjectIdentifiers.id_slh_dsa_shake_192f;
        map31.put(sLHDSAParameters10, aSN1ObjectIdentifier100);
        SLHDSAParameters sLHDSAParameters11 = SLHDSAParameters.shake_256s;
        ASN1ObjectIdentifier aSN1ObjectIdentifier101 = NISTObjectIdentifiers.id_slh_dsa_shake_256s;
        map31.put(sLHDSAParameters11, aSN1ObjectIdentifier101);
        SLHDSAParameters sLHDSAParameters12 = SLHDSAParameters.shake_256f;
        ASN1ObjectIdentifier aSN1ObjectIdentifier102 = NISTObjectIdentifiers.id_slh_dsa_shake_256f;
        map31.put(sLHDSAParameters12, aSN1ObjectIdentifier102);
        SLHDSAParameters sLHDSAParameters13 = SLHDSAParameters.sha2_128s_with_sha256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier103 = NISTObjectIdentifiers.id_hash_slh_dsa_sha2_128s_with_sha256;
        map31.put(sLHDSAParameters13, aSN1ObjectIdentifier103);
        SLHDSAParameters sLHDSAParameters14 = SLHDSAParameters.sha2_128f_with_sha256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier104 = NISTObjectIdentifiers.id_hash_slh_dsa_sha2_128f_with_sha256;
        map31.put(sLHDSAParameters14, aSN1ObjectIdentifier104);
        SLHDSAParameters sLHDSAParameters15 = SLHDSAParameters.sha2_192s_with_sha512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier105 = NISTObjectIdentifiers.id_hash_slh_dsa_sha2_192s_with_sha512;
        map31.put(sLHDSAParameters15, aSN1ObjectIdentifier105);
        SLHDSAParameters sLHDSAParameters16 = SLHDSAParameters.sha2_192f_with_sha512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier106 = NISTObjectIdentifiers.id_hash_slh_dsa_sha2_192f_with_sha512;
        map31.put(sLHDSAParameters16, aSN1ObjectIdentifier106);
        SLHDSAParameters sLHDSAParameters17 = SLHDSAParameters.sha2_256s_with_sha512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier107 = NISTObjectIdentifiers.id_hash_slh_dsa_sha2_256s_with_sha512;
        map31.put(sLHDSAParameters17, aSN1ObjectIdentifier107);
        SLHDSAParameters sLHDSAParameters18 = SLHDSAParameters.sha2_256f_with_sha512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier108 = NISTObjectIdentifiers.id_hash_slh_dsa_sha2_256f_with_sha512;
        map31.put(sLHDSAParameters18, aSN1ObjectIdentifier108);
        SLHDSAParameters sLHDSAParameters19 = SLHDSAParameters.shake_128s_with_shake128;
        ASN1ObjectIdentifier aSN1ObjectIdentifier109 = NISTObjectIdentifiers.id_hash_slh_dsa_shake_128s_with_shake128;
        map31.put(sLHDSAParameters19, aSN1ObjectIdentifier109);
        SLHDSAParameters sLHDSAParameters20 = SLHDSAParameters.shake_128f_with_shake128;
        ASN1ObjectIdentifier aSN1ObjectIdentifier110 = NISTObjectIdentifiers.id_hash_slh_dsa_shake_128f_with_shake128;
        map31.put(sLHDSAParameters20, aSN1ObjectIdentifier110);
        SLHDSAParameters sLHDSAParameters21 = SLHDSAParameters.shake_192s_with_shake256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier111 = NISTObjectIdentifiers.id_hash_slh_dsa_shake_192s_with_shake256;
        map31.put(sLHDSAParameters21, aSN1ObjectIdentifier111);
        SLHDSAParameters sLHDSAParameters22 = SLHDSAParameters.shake_192f_with_shake256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier112 = NISTObjectIdentifiers.id_hash_slh_dsa_shake_192f_with_shake256;
        map31.put(sLHDSAParameters22, aSN1ObjectIdentifier112);
        SLHDSAParameters sLHDSAParameters23 = SLHDSAParameters.shake_256s_with_shake256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier113 = NISTObjectIdentifiers.id_hash_slh_dsa_shake_256s_with_shake256;
        map31.put(sLHDSAParameters23, aSN1ObjectIdentifier113);
        SLHDSAParameters sLHDSAParameters24 = SLHDSAParameters.shake_256f_with_shake256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier114 = NISTObjectIdentifiers.id_hash_slh_dsa_shake_256f_with_shake256;
        map31.put(sLHDSAParameters24, aSN1ObjectIdentifier114);
        map32.put(aSN1ObjectIdentifier91, sLHDSAParameters);
        map32.put(aSN1ObjectIdentifier92, sLHDSAParameters2);
        map32.put(aSN1ObjectIdentifier93, sLHDSAParameters3);
        map32.put(aSN1ObjectIdentifier94, sLHDSAParameters4);
        map32.put(aSN1ObjectIdentifier95, sLHDSAParameters5);
        map32.put(aSN1ObjectIdentifier96, sLHDSAParameters6);
        map32.put(aSN1ObjectIdentifier97, sLHDSAParameters7);
        map32.put(aSN1ObjectIdentifier98, sLHDSAParameters8);
        map32.put(aSN1ObjectIdentifier99, sLHDSAParameters9);
        map32.put(aSN1ObjectIdentifier100, sLHDSAParameters10);
        map32.put(aSN1ObjectIdentifier101, sLHDSAParameters11);
        map32.put(aSN1ObjectIdentifier102, sLHDSAParameters12);
        map32.put(aSN1ObjectIdentifier103, sLHDSAParameters13);
        map32.put(aSN1ObjectIdentifier104, sLHDSAParameters14);
        map32.put(aSN1ObjectIdentifier105, sLHDSAParameters15);
        map32.put(aSN1ObjectIdentifier106, sLHDSAParameters16);
        map32.put(aSN1ObjectIdentifier107, sLHDSAParameters17);
        map32.put(aSN1ObjectIdentifier108, sLHDSAParameters18);
        map32.put(aSN1ObjectIdentifier109, sLHDSAParameters19);
        map32.put(aSN1ObjectIdentifier110, sLHDSAParameters20);
        map32.put(aSN1ObjectIdentifier111, sLHDSAParameters21);
        map32.put(aSN1ObjectIdentifier112, sLHDSAParameters22);
        map32.put(aSN1ObjectIdentifier113, sLHDSAParameters23);
        map32.put(aSN1ObjectIdentifier114, sLHDSAParameters24);
        ASN1ObjectIdentifier aSN1ObjectIdentifier115 = BCObjectIdentifiers.sphincsPlus_sha2_128s;
        map9.put(sLHDSAParameters, aSN1ObjectIdentifier115);
        ASN1ObjectIdentifier aSN1ObjectIdentifier116 = BCObjectIdentifiers.sphincsPlus_sha2_128f;
        map9.put(sLHDSAParameters2, aSN1ObjectIdentifier116);
        ASN1ObjectIdentifier aSN1ObjectIdentifier117 = BCObjectIdentifiers.sphincsPlus_sha2_192s;
        map9.put(sLHDSAParameters3, aSN1ObjectIdentifier117);
        ASN1ObjectIdentifier aSN1ObjectIdentifier118 = BCObjectIdentifiers.sphincsPlus_sha2_192f;
        map9.put(sLHDSAParameters4, aSN1ObjectIdentifier118);
        ASN1ObjectIdentifier aSN1ObjectIdentifier119 = BCObjectIdentifiers.sphincsPlus_sha2_256s;
        map9.put(sLHDSAParameters5, aSN1ObjectIdentifier119);
        ASN1ObjectIdentifier aSN1ObjectIdentifier120 = BCObjectIdentifiers.sphincsPlus_sha2_256f;
        map9.put(sLHDSAParameters6, aSN1ObjectIdentifier120);
        ASN1ObjectIdentifier aSN1ObjectIdentifier121 = BCObjectIdentifiers.sphincsPlus_shake_128s;
        map9.put(sLHDSAParameters7, aSN1ObjectIdentifier121);
        ASN1ObjectIdentifier aSN1ObjectIdentifier122 = BCObjectIdentifiers.sphincsPlus_shake_128f;
        map9.put(sLHDSAParameters8, aSN1ObjectIdentifier122);
        ASN1ObjectIdentifier aSN1ObjectIdentifier123 = BCObjectIdentifiers.sphincsPlus_shake_192s;
        map9.put(sLHDSAParameters9, aSN1ObjectIdentifier123);
        ASN1ObjectIdentifier aSN1ObjectIdentifier124 = BCObjectIdentifiers.sphincsPlus_shake_192f;
        map9.put(sLHDSAParameters10, aSN1ObjectIdentifier124);
        ASN1ObjectIdentifier aSN1ObjectIdentifier125 = BCObjectIdentifiers.sphincsPlus_shake_256s;
        map9.put(sLHDSAParameters11, aSN1ObjectIdentifier125);
        ASN1ObjectIdentifier aSN1ObjectIdentifier126 = BCObjectIdentifiers.sphincsPlus_shake_256f;
        map9.put(sLHDSAParameters12, aSN1ObjectIdentifier126);
        SPHINCSPlusParameters sPHINCSPlusParameters = SPHINCSPlusParameters.sha2_128s_robust;
        ASN1ObjectIdentifier aSN1ObjectIdentifier127 = BCObjectIdentifiers.sphincsPlus_sha2_128s_r3;
        map9.put(sPHINCSPlusParameters, aSN1ObjectIdentifier127);
        SPHINCSPlusParameters sPHINCSPlusParameters2 = SPHINCSPlusParameters.sha2_128f_robust;
        ASN1ObjectIdentifier aSN1ObjectIdentifier128 = BCObjectIdentifiers.sphincsPlus_sha2_128f_r3;
        map9.put(sPHINCSPlusParameters2, aSN1ObjectIdentifier128);
        SPHINCSPlusParameters sPHINCSPlusParameters3 = SPHINCSPlusParameters.shake_128s_robust;
        ASN1ObjectIdentifier aSN1ObjectIdentifier129 = BCObjectIdentifiers.sphincsPlus_shake_128s_r3;
        map9.put(sPHINCSPlusParameters3, aSN1ObjectIdentifier129);
        SPHINCSPlusParameters sPHINCSPlusParameters4 = SPHINCSPlusParameters.shake_128f_robust;
        ASN1ObjectIdentifier aSN1ObjectIdentifier130 = BCObjectIdentifiers.sphincsPlus_shake_128f_r3;
        map9.put(sPHINCSPlusParameters4, aSN1ObjectIdentifier130);
        SPHINCSPlusParameters sPHINCSPlusParameters5 = SPHINCSPlusParameters.haraka_128s;
        ASN1ObjectIdentifier aSN1ObjectIdentifier131 = BCObjectIdentifiers.sphincsPlus_haraka_128s_r3;
        map9.put(sPHINCSPlusParameters5, aSN1ObjectIdentifier131);
        SPHINCSPlusParameters sPHINCSPlusParameters6 = SPHINCSPlusParameters.haraka_128f;
        ASN1ObjectIdentifier aSN1ObjectIdentifier132 = BCObjectIdentifiers.sphincsPlus_haraka_128f_r3;
        map9.put(sPHINCSPlusParameters6, aSN1ObjectIdentifier132);
        SPHINCSPlusParameters sPHINCSPlusParameters7 = SPHINCSPlusParameters.sha2_192s_robust;
        ASN1ObjectIdentifier aSN1ObjectIdentifier133 = BCObjectIdentifiers.sphincsPlus_sha2_192s_r3;
        map9.put(sPHINCSPlusParameters7, aSN1ObjectIdentifier133);
        SPHINCSPlusParameters sPHINCSPlusParameters8 = SPHINCSPlusParameters.sha2_192f_robust;
        ASN1ObjectIdentifier aSN1ObjectIdentifier134 = BCObjectIdentifiers.sphincsPlus_sha2_192f_r3;
        map9.put(sPHINCSPlusParameters8, aSN1ObjectIdentifier134);
        SPHINCSPlusParameters sPHINCSPlusParameters9 = SPHINCSPlusParameters.shake_192s_robust;
        ASN1ObjectIdentifier aSN1ObjectIdentifier135 = BCObjectIdentifiers.sphincsPlus_shake_192s_r3;
        map9.put(sPHINCSPlusParameters9, aSN1ObjectIdentifier135);
        SPHINCSPlusParameters sPHINCSPlusParameters10 = SPHINCSPlusParameters.shake_192f_robust;
        ASN1ObjectIdentifier aSN1ObjectIdentifier136 = BCObjectIdentifiers.sphincsPlus_shake_192f_r3;
        map9.put(sPHINCSPlusParameters10, aSN1ObjectIdentifier136);
        SPHINCSPlusParameters sPHINCSPlusParameters11 = SPHINCSPlusParameters.haraka_192s;
        ASN1ObjectIdentifier aSN1ObjectIdentifier137 = BCObjectIdentifiers.sphincsPlus_haraka_192s_r3;
        map9.put(sPHINCSPlusParameters11, aSN1ObjectIdentifier137);
        SPHINCSPlusParameters sPHINCSPlusParameters12 = SPHINCSPlusParameters.haraka_192f;
        ASN1ObjectIdentifier aSN1ObjectIdentifier138 = BCObjectIdentifiers.sphincsPlus_haraka_192f_r3;
        map9.put(sPHINCSPlusParameters12, aSN1ObjectIdentifier138);
        SPHINCSPlusParameters sPHINCSPlusParameters13 = SPHINCSPlusParameters.sha2_256s_robust;
        ASN1ObjectIdentifier aSN1ObjectIdentifier139 = BCObjectIdentifiers.sphincsPlus_sha2_256s_r3;
        map9.put(sPHINCSPlusParameters13, aSN1ObjectIdentifier139);
        SPHINCSPlusParameters sPHINCSPlusParameters14 = SPHINCSPlusParameters.sha2_256f_robust;
        ASN1ObjectIdentifier aSN1ObjectIdentifier140 = BCObjectIdentifiers.sphincsPlus_sha2_256f_r3;
        map9.put(sPHINCSPlusParameters14, aSN1ObjectIdentifier140);
        SPHINCSPlusParameters sPHINCSPlusParameters15 = SPHINCSPlusParameters.shake_256s_robust;
        ASN1ObjectIdentifier aSN1ObjectIdentifier141 = BCObjectIdentifiers.sphincsPlus_shake_256s_r3;
        map9.put(sPHINCSPlusParameters15, aSN1ObjectIdentifier141);
        SPHINCSPlusParameters sPHINCSPlusParameters16 = SPHINCSPlusParameters.shake_256f_robust;
        ASN1ObjectIdentifier aSN1ObjectIdentifier142 = BCObjectIdentifiers.sphincsPlus_shake_256f_r3;
        map9.put(sPHINCSPlusParameters16, aSN1ObjectIdentifier142);
        SPHINCSPlusParameters sPHINCSPlusParameters17 = SPHINCSPlusParameters.haraka_256s;
        ASN1ObjectIdentifier aSN1ObjectIdentifier143 = BCObjectIdentifiers.sphincsPlus_haraka_256s_r3;
        map9.put(sPHINCSPlusParameters17, aSN1ObjectIdentifier143);
        SPHINCSPlusParameters sPHINCSPlusParameters18 = SPHINCSPlusParameters.haraka_256f;
        ASN1ObjectIdentifier aSN1ObjectIdentifier144 = BCObjectIdentifiers.sphincsPlus_haraka_256f_r3;
        map9.put(sPHINCSPlusParameters18, aSN1ObjectIdentifier144);
        SPHINCSPlusParameters sPHINCSPlusParameters19 = SPHINCSPlusParameters.haraka_128s_simple;
        ASN1ObjectIdentifier aSN1ObjectIdentifier145 = BCObjectIdentifiers.sphincsPlus_haraka_128s_r3_simple;
        map9.put(sPHINCSPlusParameters19, aSN1ObjectIdentifier145);
        SPHINCSPlusParameters sPHINCSPlusParameters20 = SPHINCSPlusParameters.haraka_128f_simple;
        ASN1ObjectIdentifier aSN1ObjectIdentifier146 = BCObjectIdentifiers.sphincsPlus_haraka_128f_r3_simple;
        map9.put(sPHINCSPlusParameters20, aSN1ObjectIdentifier146);
        SPHINCSPlusParameters sPHINCSPlusParameters21 = SPHINCSPlusParameters.haraka_192s_simple;
        ASN1ObjectIdentifier aSN1ObjectIdentifier147 = BCObjectIdentifiers.sphincsPlus_haraka_192s_r3_simple;
        map9.put(sPHINCSPlusParameters21, aSN1ObjectIdentifier147);
        SPHINCSPlusParameters sPHINCSPlusParameters22 = SPHINCSPlusParameters.haraka_192f_simple;
        ASN1ObjectIdentifier aSN1ObjectIdentifier148 = BCObjectIdentifiers.sphincsPlus_haraka_192f_r3_simple;
        map9.put(sPHINCSPlusParameters22, aSN1ObjectIdentifier148);
        SPHINCSPlusParameters sPHINCSPlusParameters23 = SPHINCSPlusParameters.haraka_256s_simple;
        ASN1ObjectIdentifier aSN1ObjectIdentifier149 = BCObjectIdentifiers.sphincsPlus_haraka_256s_r3_simple;
        map9.put(sPHINCSPlusParameters23, aSN1ObjectIdentifier149);
        SPHINCSPlusParameters sPHINCSPlusParameters24 = SPHINCSPlusParameters.haraka_256f_simple;
        ASN1ObjectIdentifier aSN1ObjectIdentifier150 = BCObjectIdentifiers.sphincsPlus_haraka_256f_r3_simple;
        map9.put(sPHINCSPlusParameters24, aSN1ObjectIdentifier150);
        SPHINCSPlusParameters sPHINCSPlusParameters25 = SPHINCSPlusParameters.sha2_128s;
        map9.put(sPHINCSPlusParameters25, aSN1ObjectIdentifier115);
        SPHINCSPlusParameters sPHINCSPlusParameters26 = SPHINCSPlusParameters.sha2_128f;
        map9.put(sPHINCSPlusParameters26, aSN1ObjectIdentifier116);
        SPHINCSPlusParameters sPHINCSPlusParameters27 = SPHINCSPlusParameters.sha2_192s;
        map9.put(sPHINCSPlusParameters27, aSN1ObjectIdentifier117);
        SPHINCSPlusParameters sPHINCSPlusParameters28 = SPHINCSPlusParameters.sha2_192f;
        map9.put(sPHINCSPlusParameters28, aSN1ObjectIdentifier118);
        SPHINCSPlusParameters sPHINCSPlusParameters29 = SPHINCSPlusParameters.sha2_256s;
        map9.put(sPHINCSPlusParameters29, aSN1ObjectIdentifier119);
        SPHINCSPlusParameters sPHINCSPlusParameters30 = SPHINCSPlusParameters.sha2_256f;
        map9.put(sPHINCSPlusParameters30, aSN1ObjectIdentifier120);
        SPHINCSPlusParameters sPHINCSPlusParameters31 = SPHINCSPlusParameters.shake_128s;
        map9.put(sPHINCSPlusParameters31, aSN1ObjectIdentifier121);
        SPHINCSPlusParameters sPHINCSPlusParameters32 = SPHINCSPlusParameters.shake_128f;
        map9.put(sPHINCSPlusParameters32, aSN1ObjectIdentifier122);
        SPHINCSPlusParameters sPHINCSPlusParameters33 = SPHINCSPlusParameters.shake_192s;
        map9.put(sPHINCSPlusParameters33, aSN1ObjectIdentifier123);
        SPHINCSPlusParameters sPHINCSPlusParameters34 = SPHINCSPlusParameters.shake_192f;
        map9.put(sPHINCSPlusParameters34, aSN1ObjectIdentifier124);
        SPHINCSPlusParameters sPHINCSPlusParameters35 = SPHINCSPlusParameters.shake_256s;
        map9.put(sPHINCSPlusParameters35, aSN1ObjectIdentifier125);
        SPHINCSPlusParameters sPHINCSPlusParameters36 = SPHINCSPlusParameters.shake_256f;
        map9.put(sPHINCSPlusParameters36, aSN1ObjectIdentifier126);
        map10.put(aSN1ObjectIdentifier115, sPHINCSPlusParameters25);
        map10.put(aSN1ObjectIdentifier116, sPHINCSPlusParameters26);
        map10.put(aSN1ObjectIdentifier121, sPHINCSPlusParameters31);
        map10.put(aSN1ObjectIdentifier122, sPHINCSPlusParameters32);
        map10.put(aSN1ObjectIdentifier117, sPHINCSPlusParameters27);
        map10.put(aSN1ObjectIdentifier118, sPHINCSPlusParameters28);
        map10.put(aSN1ObjectIdentifier123, sPHINCSPlusParameters33);
        map10.put(aSN1ObjectIdentifier124, sPHINCSPlusParameters34);
        map10.put(aSN1ObjectIdentifier119, sPHINCSPlusParameters29);
        map10.put(aSN1ObjectIdentifier120, sPHINCSPlusParameters30);
        map10.put(aSN1ObjectIdentifier125, sPHINCSPlusParameters35);
        map10.put(aSN1ObjectIdentifier126, sPHINCSPlusParameters36);
        map10.put(aSN1ObjectIdentifier127, sPHINCSPlusParameters);
        map10.put(aSN1ObjectIdentifier128, sPHINCSPlusParameters2);
        map10.put(aSN1ObjectIdentifier129, sPHINCSPlusParameters3);
        map10.put(aSN1ObjectIdentifier130, sPHINCSPlusParameters4);
        map10.put(aSN1ObjectIdentifier131, sPHINCSPlusParameters5);
        map10.put(aSN1ObjectIdentifier132, sPHINCSPlusParameters6);
        map10.put(aSN1ObjectIdentifier133, sPHINCSPlusParameters7);
        map10.put(aSN1ObjectIdentifier134, sPHINCSPlusParameters8);
        map10.put(aSN1ObjectIdentifier135, sPHINCSPlusParameters9);
        map10.put(aSN1ObjectIdentifier136, sPHINCSPlusParameters10);
        map10.put(aSN1ObjectIdentifier137, sPHINCSPlusParameters11);
        map10.put(aSN1ObjectIdentifier138, sPHINCSPlusParameters12);
        map10.put(aSN1ObjectIdentifier139, sPHINCSPlusParameters13);
        map10.put(aSN1ObjectIdentifier140, sPHINCSPlusParameters14);
        map10.put(aSN1ObjectIdentifier141, sPHINCSPlusParameters15);
        map10.put(aSN1ObjectIdentifier142, sPHINCSPlusParameters16);
        map10.put(aSN1ObjectIdentifier143, sPHINCSPlusParameters17);
        map10.put(aSN1ObjectIdentifier144, sPHINCSPlusParameters18);
        map10.put(BCObjectIdentifiers.sphincsPlus_sha2_128s_r3_simple, sPHINCSPlusParameters25);
        map10.put(BCObjectIdentifiers.sphincsPlus_sha2_128f_r3_simple, sPHINCSPlusParameters26);
        map10.put(BCObjectIdentifiers.sphincsPlus_shake_128s_r3_simple, sPHINCSPlusParameters31);
        map10.put(BCObjectIdentifiers.sphincsPlus_shake_128f_r3_simple, sPHINCSPlusParameters32);
        map10.put(aSN1ObjectIdentifier145, sPHINCSPlusParameters19);
        map10.put(aSN1ObjectIdentifier146, sPHINCSPlusParameters20);
        map10.put(BCObjectIdentifiers.sphincsPlus_sha2_192s_r3_simple, sPHINCSPlusParameters27);
        map10.put(BCObjectIdentifiers.sphincsPlus_sha2_192f_r3_simple, sPHINCSPlusParameters28);
        map10.put(BCObjectIdentifiers.sphincsPlus_shake_192s_r3_simple, sPHINCSPlusParameters33);
        map10.put(BCObjectIdentifiers.sphincsPlus_shake_192f_r3_simple, sPHINCSPlusParameters34);
        map10.put(aSN1ObjectIdentifier147, sPHINCSPlusParameters21);
        map10.put(aSN1ObjectIdentifier148, sPHINCSPlusParameters22);
        map10.put(BCObjectIdentifiers.sphincsPlus_sha2_256s_r3_simple, sPHINCSPlusParameters29);
        map10.put(BCObjectIdentifiers.sphincsPlus_sha2_256f_r3_simple, sPHINCSPlusParameters30);
        map10.put(BCObjectIdentifiers.sphincsPlus_shake_256s_r3_simple, sPHINCSPlusParameters35);
        map10.put(BCObjectIdentifiers.sphincsPlus_shake_256f_r3_simple, sPHINCSPlusParameters36);
        map10.put(aSN1ObjectIdentifier149, sPHINCSPlusParameters23);
        map10.put(aSN1ObjectIdentifier150, sPHINCSPlusParameters24);
        MayoParameters mayoParameters = MayoParameters.f23275mayo1;
        ASN1ObjectIdentifier aSN1ObjectIdentifier151 = BCObjectIdentifiers.f18027mayo1;
        map33.put(mayoParameters, aSN1ObjectIdentifier151);
        MayoParameters mayoParameters2 = MayoParameters.f23276mayo2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier152 = BCObjectIdentifiers.f18028mayo2;
        map33.put(mayoParameters2, aSN1ObjectIdentifier152);
        MayoParameters mayoParameters3 = MayoParameters.f23277mayo3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier153 = BCObjectIdentifiers.f18029mayo3;
        map33.put(mayoParameters3, aSN1ObjectIdentifier153);
        MayoParameters mayoParameters4 = MayoParameters.f23278mayo5;
        ASN1ObjectIdentifier aSN1ObjectIdentifier154 = BCObjectIdentifiers.f18030mayo5;
        map33.put(mayoParameters4, aSN1ObjectIdentifier154);
        map34.put(aSN1ObjectIdentifier151, mayoParameters);
        map34.put(aSN1ObjectIdentifier152, mayoParameters2);
        map34.put(aSN1ObjectIdentifier153, mayoParameters3);
        map34.put(aSN1ObjectIdentifier154, mayoParameters4);
        SnovaParameters snovaParameters = SnovaParameters.SNOVA_24_5_4_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier155 = BCObjectIdentifiers.snova_24_5_4_ssk;
        map35.put(snovaParameters, aSN1ObjectIdentifier155);
        SnovaParameters snovaParameters2 = SnovaParameters.SNOVA_24_5_4_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier156 = BCObjectIdentifiers.snova_24_5_4_esk;
        map35.put(snovaParameters2, aSN1ObjectIdentifier156);
        SnovaParameters snovaParameters3 = SnovaParameters.SNOVA_24_5_4_SHAKE_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier157 = BCObjectIdentifiers.snova_24_5_4_shake_ssk;
        map35.put(snovaParameters3, aSN1ObjectIdentifier157);
        SnovaParameters snovaParameters4 = SnovaParameters.SNOVA_24_5_4_SHAKE_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier158 = BCObjectIdentifiers.snova_24_5_4_shake_esk;
        map35.put(snovaParameters4, aSN1ObjectIdentifier158);
        SnovaParameters snovaParameters5 = SnovaParameters.SNOVA_24_5_5_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier159 = BCObjectIdentifiers.snova_24_5_5_ssk;
        map35.put(snovaParameters5, aSN1ObjectIdentifier159);
        SnovaParameters snovaParameters6 = SnovaParameters.SNOVA_24_5_5_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier160 = BCObjectIdentifiers.snova_24_5_5_esk;
        map35.put(snovaParameters6, aSN1ObjectIdentifier160);
        SnovaParameters snovaParameters7 = SnovaParameters.SNOVA_24_5_5_SHAKE_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier161 = BCObjectIdentifiers.snova_24_5_5_shake_ssk;
        map35.put(snovaParameters7, aSN1ObjectIdentifier161);
        SnovaParameters snovaParameters8 = SnovaParameters.SNOVA_24_5_5_SHAKE_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier162 = BCObjectIdentifiers.snova_24_5_5_shake_esk;
        map35.put(snovaParameters8, aSN1ObjectIdentifier162);
        SnovaParameters snovaParameters9 = SnovaParameters.SNOVA_25_8_3_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier163 = BCObjectIdentifiers.snova_25_8_3_ssk;
        map35.put(snovaParameters9, aSN1ObjectIdentifier163);
        SnovaParameters snovaParameters10 = SnovaParameters.SNOVA_25_8_3_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier164 = BCObjectIdentifiers.snova_25_8_3_esk;
        map35.put(snovaParameters10, aSN1ObjectIdentifier164);
        SnovaParameters snovaParameters11 = SnovaParameters.SNOVA_25_8_3_SHAKE_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier165 = BCObjectIdentifiers.snova_25_8_3_shake_ssk;
        map35.put(snovaParameters11, aSN1ObjectIdentifier165);
        SnovaParameters snovaParameters12 = SnovaParameters.SNOVA_25_8_3_SHAKE_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier166 = BCObjectIdentifiers.snova_25_8_3_shake_esk;
        map35.put(snovaParameters12, aSN1ObjectIdentifier166);
        SnovaParameters snovaParameters13 = SnovaParameters.SNOVA_29_6_5_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier167 = BCObjectIdentifiers.snova_29_6_5_ssk;
        map35.put(snovaParameters13, aSN1ObjectIdentifier167);
        SnovaParameters snovaParameters14 = SnovaParameters.SNOVA_29_6_5_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier168 = BCObjectIdentifiers.snova_29_6_5_esk;
        map35.put(snovaParameters14, aSN1ObjectIdentifier168);
        SnovaParameters snovaParameters15 = SnovaParameters.SNOVA_29_6_5_SHAKE_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier169 = BCObjectIdentifiers.snova_29_6_5_shake_ssk;
        map35.put(snovaParameters15, aSN1ObjectIdentifier169);
        SnovaParameters snovaParameters16 = SnovaParameters.SNOVA_29_6_5_SHAKE_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier170 = BCObjectIdentifiers.snova_29_6_5_shake_esk;
        map35.put(snovaParameters16, aSN1ObjectIdentifier170);
        SnovaParameters snovaParameters17 = SnovaParameters.SNOVA_37_8_4_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier171 = BCObjectIdentifiers.snova_37_8_4_ssk;
        map35.put(snovaParameters17, aSN1ObjectIdentifier171);
        SnovaParameters snovaParameters18 = SnovaParameters.SNOVA_37_8_4_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier172 = BCObjectIdentifiers.snova_37_8_4_esk;
        map35.put(snovaParameters18, aSN1ObjectIdentifier172);
        SnovaParameters snovaParameters19 = SnovaParameters.SNOVA_37_8_4_SHAKE_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier173 = BCObjectIdentifiers.snova_37_8_4_shake_ssk;
        map35.put(snovaParameters19, aSN1ObjectIdentifier173);
        SnovaParameters snovaParameters20 = SnovaParameters.SNOVA_37_8_4_SHAKE_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier174 = BCObjectIdentifiers.snova_37_8_4_shake_esk;
        map35.put(snovaParameters20, aSN1ObjectIdentifier174);
        SnovaParameters snovaParameters21 = SnovaParameters.SNOVA_37_17_2_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier175 = BCObjectIdentifiers.snova_37_17_2_ssk;
        map35.put(snovaParameters21, aSN1ObjectIdentifier175);
        SnovaParameters snovaParameters22 = SnovaParameters.SNOVA_37_17_2_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier176 = BCObjectIdentifiers.snova_37_17_2_esk;
        map35.put(snovaParameters22, aSN1ObjectIdentifier176);
        SnovaParameters snovaParameters23 = SnovaParameters.SNOVA_37_17_2_SHAKE_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier177 = BCObjectIdentifiers.snova_37_17_2_shake_ssk;
        map35.put(snovaParameters23, aSN1ObjectIdentifier177);
        SnovaParameters snovaParameters24 = SnovaParameters.SNOVA_37_17_2_SHAKE_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier178 = BCObjectIdentifiers.snova_37_17_2_shake_esk;
        map35.put(snovaParameters24, aSN1ObjectIdentifier178);
        SnovaParameters snovaParameters25 = SnovaParameters.SNOVA_49_11_3_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier179 = BCObjectIdentifiers.snova_49_11_3_ssk;
        map35.put(snovaParameters25, aSN1ObjectIdentifier179);
        SnovaParameters snovaParameters26 = SnovaParameters.SNOVA_49_11_3_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier180 = BCObjectIdentifiers.snova_49_11_3_esk;
        map35.put(snovaParameters26, aSN1ObjectIdentifier180);
        SnovaParameters snovaParameters27 = SnovaParameters.SNOVA_49_11_3_SHAKE_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier181 = BCObjectIdentifiers.snova_49_11_3_shake_ssk;
        map35.put(snovaParameters27, aSN1ObjectIdentifier181);
        SnovaParameters snovaParameters28 = SnovaParameters.SNOVA_49_11_3_SHAKE_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier182 = BCObjectIdentifiers.snova_49_11_3_shake_esk;
        map35.put(snovaParameters28, aSN1ObjectIdentifier182);
        SnovaParameters snovaParameters29 = SnovaParameters.SNOVA_56_25_2_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier183 = BCObjectIdentifiers.snova_56_25_2_ssk;
        map35.put(snovaParameters29, aSN1ObjectIdentifier183);
        SnovaParameters snovaParameters30 = SnovaParameters.SNOVA_56_25_2_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier184 = BCObjectIdentifiers.snova_56_25_2_esk;
        map35.put(snovaParameters30, aSN1ObjectIdentifier184);
        SnovaParameters snovaParameters31 = SnovaParameters.SNOVA_56_25_2_SHAKE_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier185 = BCObjectIdentifiers.snova_56_25_2_shake_ssk;
        map35.put(snovaParameters31, aSN1ObjectIdentifier185);
        SnovaParameters snovaParameters32 = SnovaParameters.SNOVA_56_25_2_SHAKE_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier186 = BCObjectIdentifiers.snova_56_25_2_shake_esk;
        map35.put(snovaParameters32, aSN1ObjectIdentifier186);
        SnovaParameters snovaParameters33 = SnovaParameters.SNOVA_60_10_4_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier187 = BCObjectIdentifiers.snova_60_10_4_ssk;
        map35.put(snovaParameters33, aSN1ObjectIdentifier187);
        SnovaParameters snovaParameters34 = SnovaParameters.SNOVA_60_10_4_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier188 = BCObjectIdentifiers.snova_60_10_4_esk;
        map35.put(snovaParameters34, aSN1ObjectIdentifier188);
        SnovaParameters snovaParameters35 = SnovaParameters.SNOVA_60_10_4_SHAKE_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier189 = BCObjectIdentifiers.snova_60_10_4_shake_ssk;
        map35.put(snovaParameters35, aSN1ObjectIdentifier189);
        SnovaParameters snovaParameters36 = SnovaParameters.SNOVA_60_10_4_SHAKE_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier190 = BCObjectIdentifiers.snova_60_10_4_shake_esk;
        map35.put(snovaParameters36, aSN1ObjectIdentifier190);
        SnovaParameters snovaParameters37 = SnovaParameters.SNOVA_66_15_3_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier191 = BCObjectIdentifiers.snova_66_15_3_ssk;
        map35.put(snovaParameters37, aSN1ObjectIdentifier191);
        SnovaParameters snovaParameters38 = SnovaParameters.SNOVA_66_15_3_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier192 = BCObjectIdentifiers.snova_66_15_3_esk;
        map35.put(snovaParameters38, aSN1ObjectIdentifier192);
        SnovaParameters snovaParameters39 = SnovaParameters.SNOVA_66_15_3_SHAKE_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier193 = BCObjectIdentifiers.snova_66_15_3_shake_ssk;
        map35.put(snovaParameters39, aSN1ObjectIdentifier193);
        SnovaParameters snovaParameters40 = SnovaParameters.SNOVA_66_15_3_SHAKE_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier194 = BCObjectIdentifiers.snova_66_15_3_shake_esk;
        map35.put(snovaParameters40, aSN1ObjectIdentifier194);
        SnovaParameters snovaParameters41 = SnovaParameters.SNOVA_75_33_2_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier195 = BCObjectIdentifiers.snova_75_33_2_ssk;
        map35.put(snovaParameters41, aSN1ObjectIdentifier195);
        SnovaParameters snovaParameters42 = SnovaParameters.SNOVA_75_33_2_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier196 = BCObjectIdentifiers.snova_75_33_2_esk;
        map35.put(snovaParameters42, aSN1ObjectIdentifier196);
        SnovaParameters snovaParameters43 = SnovaParameters.SNOVA_75_33_2_SHAKE_SSK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier197 = BCObjectIdentifiers.snova_75_33_2_shake_ssk;
        map35.put(snovaParameters43, aSN1ObjectIdentifier197);
        SnovaParameters snovaParameters44 = SnovaParameters.SNOVA_75_33_2_SHAKE_ESK;
        ASN1ObjectIdentifier aSN1ObjectIdentifier198 = BCObjectIdentifiers.snova_75_33_2_shake_esk;
        map35.put(snovaParameters44, aSN1ObjectIdentifier198);
        map36.put(aSN1ObjectIdentifier155, snovaParameters);
        map36.put(aSN1ObjectIdentifier156, snovaParameters2);
        map36.put(aSN1ObjectIdentifier157, snovaParameters3);
        map36.put(aSN1ObjectIdentifier158, snovaParameters4);
        map36.put(aSN1ObjectIdentifier159, snovaParameters5);
        map36.put(aSN1ObjectIdentifier160, snovaParameters6);
        map36.put(aSN1ObjectIdentifier161, snovaParameters7);
        map36.put(aSN1ObjectIdentifier162, snovaParameters8);
        map36.put(aSN1ObjectIdentifier163, snovaParameters9);
        map36.put(aSN1ObjectIdentifier164, snovaParameters10);
        map36.put(aSN1ObjectIdentifier165, snovaParameters11);
        map36.put(aSN1ObjectIdentifier166, snovaParameters12);
        map36.put(aSN1ObjectIdentifier167, snovaParameters13);
        map36.put(aSN1ObjectIdentifier168, snovaParameters14);
        map36.put(aSN1ObjectIdentifier169, snovaParameters15);
        map36.put(aSN1ObjectIdentifier170, snovaParameters16);
        map36.put(aSN1ObjectIdentifier171, snovaParameters17);
        map36.put(aSN1ObjectIdentifier172, snovaParameters18);
        map36.put(aSN1ObjectIdentifier173, snovaParameters19);
        map36.put(aSN1ObjectIdentifier174, snovaParameters20);
        map36.put(aSN1ObjectIdentifier175, snovaParameters21);
        map36.put(aSN1ObjectIdentifier176, snovaParameters22);
        map36.put(aSN1ObjectIdentifier177, snovaParameters23);
        map36.put(aSN1ObjectIdentifier178, snovaParameters24);
        map36.put(aSN1ObjectIdentifier179, snovaParameters25);
        map36.put(aSN1ObjectIdentifier180, snovaParameters26);
        map36.put(aSN1ObjectIdentifier181, snovaParameters27);
        map36.put(aSN1ObjectIdentifier182, snovaParameters28);
        map36.put(aSN1ObjectIdentifier183, snovaParameters29);
        map36.put(aSN1ObjectIdentifier184, snovaParameters30);
        map36.put(aSN1ObjectIdentifier185, snovaParameters31);
        map36.put(aSN1ObjectIdentifier186, snovaParameters32);
        map36.put(aSN1ObjectIdentifier187, snovaParameters33);
        map36.put(aSN1ObjectIdentifier188, snovaParameters34);
        map36.put(aSN1ObjectIdentifier189, snovaParameters35);
        map36.put(aSN1ObjectIdentifier190, snovaParameters36);
        map36.put(aSN1ObjectIdentifier191, snovaParameters37);
        map36.put(aSN1ObjectIdentifier192, snovaParameters38);
        map36.put(aSN1ObjectIdentifier193, snovaParameters39);
        map36.put(aSN1ObjectIdentifier194, snovaParameters40);
        map36.put(aSN1ObjectIdentifier195, snovaParameters41);
        map36.put(aSN1ObjectIdentifier196, snovaParameters42);
        map36.put(aSN1ObjectIdentifier197, snovaParameters43);
        map36.put(aSN1ObjectIdentifier198, snovaParameters44);
        ASN1ObjectIdentifier aSN1ObjectIdentifier199 = BCObjectIdentifiers.ntruplus768;
        NTRUPlusParameters nTRUPlusParameters = NTRUPlusParameters.ntruplus_kem_768;
        map38.put(aSN1ObjectIdentifier199, nTRUPlusParameters);
        ASN1ObjectIdentifier aSN1ObjectIdentifier200 = BCObjectIdentifiers.ntruplus864;
        NTRUPlusParameters nTRUPlusParameters2 = NTRUPlusParameters.ntruplus_kem_864;
        map38.put(aSN1ObjectIdentifier200, nTRUPlusParameters2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier201 = BCObjectIdentifiers.ntruplus1152;
        NTRUPlusParameters nTRUPlusParameters3 = NTRUPlusParameters.ntruplus_kem_1152;
        map38.put(aSN1ObjectIdentifier201, nTRUPlusParameters3);
        map37.put(nTRUPlusParameters, aSN1ObjectIdentifier199);
        map37.put(nTRUPlusParameters2, aSN1ObjectIdentifier200);
        map37.put(nTRUPlusParameters3, aSN1ObjectIdentifier201);
    }

    public static ASN1ObjectIdentifier bikeOidLookup(BIKEParameters bIKEParameters) {
        return (ASN1ObjectIdentifier) bikeOids.get(bIKEParameters);
    }

    public static BIKEParameters bikeParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (BIKEParameters) bikeParams.get(aSN1ObjectIdentifier);
    }

    public static ASN1ObjectIdentifier dilithiumOidLookup(DilithiumParameters dilithiumParameters) {
        return (ASN1ObjectIdentifier) dilithiumOids.get(dilithiumParameters);
    }

    public static DilithiumParameters dilithiumParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (DilithiumParameters) dilithiumParams.get(aSN1ObjectIdentifier);
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
        return (ASN1ObjectIdentifier) f23591hqcOids.get(hQCParameters);
    }

    public static HQCParameters hqcParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (HQCParameters) hqcParams.get(aSN1ObjectIdentifier);
    }

    /* renamed from: isRaw */
    private static boolean m17878isRaw(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        byteArrayInputStream.read();
        return m17879readLen(byteArrayInputStream) != byteArrayInputStream.available();
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
        if (m17878isRaw(bArr)) {
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
        if (m17878isRaw(bArr) || bArr[0] != 4) {
            return null;
        }
        return ASN1OctetString.getInstance(bArr);
    }

    public static ASN1ObjectIdentifier picnicOidLookup(PicnicParameters picnicParameters) {
        return (ASN1ObjectIdentifier) picnicOids.get(picnicParameters);
    }

    public static PicnicParameters picnicParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (PicnicParameters) picnicParams.get(aSN1ObjectIdentifier);
    }

    public static ASN1ObjectIdentifier rainbowOidLookup(RainbowParameters rainbowParameters) {
        return (ASN1ObjectIdentifier) rainbowOids.get(rainbowParameters);
    }

    public static RainbowParameters rainbowParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (RainbowParameters) rainbowParams.get(aSN1ObjectIdentifier);
    }

    /* renamed from: readLen */
    public static int m17879readLen(ByteArrayInputStream byteArrayInputStream) {
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

    public static AlgorithmIdentifier sphincs256LookupTreeAlgID(String str) {
        if (str.equals("SHA3-256")) {
            return SPHINCS_SHA3_256;
        }
        if (str.equals(SPHINCSKeyParameters.SHA512_256)) {
            return SPHINCS_SHA512_256;
        }
        throw new IllegalArgumentException("unknown tree digest: " + str);
    }

    public static String sphincs256LookupTreeAlgName(SPHINCS256KeyParams sPHINCS256KeyParams) {
        AlgorithmIdentifier treeDigest = sPHINCS256KeyParams.getTreeDigest();
        if (treeDigest.getAlgorithm().m14446equals((ASN1Primitive) SPHINCS_SHA3_256.getAlgorithm())) {
            return "SHA3-256";
        }
        if (treeDigest.getAlgorithm().m14446equals((ASN1Primitive) SPHINCS_SHA512_256.getAlgorithm())) {
            return SPHINCSKeyParameters.SHA512_256;
        }
        throw new IllegalArgumentException("unknown tree digest: " + treeDigest.getAlgorithm());
    }

    public static ASN1ObjectIdentifier sphincsPlusOidLookup(SPHINCSPlusParameters sPHINCSPlusParameters) {
        return (ASN1ObjectIdentifier) sphincsPlusOids.get(sPHINCSPlusParameters);
    }

    public static SPHINCSPlusParameters sphincsPlusParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (SPHINCSPlusParameters) sphincsPlusParams.get(aSN1ObjectIdentifier);
    }

    public static AlgorithmIdentifier xmssLookupTreeAlgID(String str) {
        if (str.equals(XMSSKeyParameters.f23621SHA_256)) {
            return XMSS_SHA256;
        }
        if (str.equals(XMSSKeyParameters.f23622SHA_512)) {
            return XMSS_SHA512;
        }
        if (str.equals("SHAKE128")) {
            return XMSS_SHAKE128;
        }
        if (str.equals("SHAKE256")) {
            return XMSS_SHAKE256;
        }
        throw new IllegalArgumentException("unknown tree digest: " + str);
    }
}
