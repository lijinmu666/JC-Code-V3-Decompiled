package org.bouncycastle.p191cms;

import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.p133asn1.p139cms.OriginatorInfo;
import org.bouncycastle.p133asn1.p157kisa.KISAObjectIdentifiers;
import org.bouncycastle.p133asn1.p158misc.MiscObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p163ntt.NTTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p167sec.SECObjectIdentifiers;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;

/* loaded from: classes2.dex */
public class CMSEnvelopedGenerator {
    protected OriginatorInfo originatorInfo;
    final List recipientInfoGenerators = new ArrayList();
    protected CMSAttributeTableGenerator unprotectedAttributeGenerator = null;
    public static final String DES_EDE3_CBC = PKCSObjectIdentifiers.des_EDE3_CBC.m14433getId();

    /* renamed from: RC2_CBC */
    public static final String f18974RC2_CBC = PKCSObjectIdentifiers.f18490RC2_CBC.m14433getId();
    public static final String IDEA_CBC = MiscObjectIdentifiers.as_sys_sec_alg_ideaCBC.m14433getId();
    public static final String CAST5_CBC = MiscObjectIdentifiers.cast5CBC.m14433getId();
    public static final String AES128_CBC = NISTObjectIdentifiers.id_aes128_CBC.m14433getId();
    public static final String AES192_CBC = NISTObjectIdentifiers.id_aes192_CBC.m14433getId();
    public static final String AES256_CBC = NISTObjectIdentifiers.id_aes256_CBC.m14433getId();
    public static final String CAMELLIA128_CBC = NTTObjectIdentifiers.id_camellia128_cbc.m14433getId();
    public static final String CAMELLIA192_CBC = NTTObjectIdentifiers.id_camellia192_cbc.m14433getId();
    public static final String CAMELLIA256_CBC = NTTObjectIdentifiers.id_camellia256_cbc.m14433getId();
    public static final String SEED_CBC = KISAObjectIdentifiers.id_seedCBC.m14433getId();
    public static final String DES_EDE3_WRAP = PKCSObjectIdentifiers.id_alg_CMS3DESwrap.m14433getId();
    public static final String AES128_WRAP = NISTObjectIdentifiers.id_aes128_wrap.m14433getId();
    public static final String AES192_WRAP = NISTObjectIdentifiers.id_aes192_wrap.m14433getId();
    public static final String AES256_WRAP = NISTObjectIdentifiers.id_aes256_wrap.m14433getId();
    public static final String CAMELLIA128_WRAP = NTTObjectIdentifiers.id_camellia128_wrap.m14433getId();
    public static final String CAMELLIA192_WRAP = NTTObjectIdentifiers.id_camellia192_wrap.m14433getId();
    public static final String CAMELLIA256_WRAP = NTTObjectIdentifiers.id_camellia256_wrap.m14433getId();
    public static final String SEED_WRAP = KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap.m14433getId();
    public static final String ECDH_SHA1KDF = X9ObjectIdentifiers.dhSinglePass_stdDH_sha1kdf_scheme.m14433getId();
    public static final String ECMQV_SHA1KDF = X9ObjectIdentifiers.mqvSinglePass_sha1kdf_scheme.m14433getId();
    public static final String ECMQV_SHA224KDF = SECObjectIdentifiers.mqvSinglePass_sha224kdf_scheme.m14433getId();
    public static final String ECMQV_SHA256KDF = SECObjectIdentifiers.mqvSinglePass_sha256kdf_scheme.m14433getId();
    public static final String ECMQV_SHA384KDF = SECObjectIdentifiers.mqvSinglePass_sha384kdf_scheme.m14433getId();
    public static final String ECMQV_SHA512KDF = SECObjectIdentifiers.mqvSinglePass_sha512kdf_scheme.m14433getId();

    public void addRecipientInfoGenerator(RecipientInfoGenerator recipientInfoGenerator) {
        this.recipientInfoGenerators.add(recipientInfoGenerator);
    }

    public void setOriginatorInfo(OriginatorInformation originatorInformation) {
        this.originatorInfo = originatorInformation.toASN1Structure();
    }

    public void setUnprotectedAttributeGenerator(CMSAttributeTableGenerator cMSAttributeTableGenerator) {
        this.unprotectedAttributeGenerator = cMSAttributeTableGenerator;
    }
}
