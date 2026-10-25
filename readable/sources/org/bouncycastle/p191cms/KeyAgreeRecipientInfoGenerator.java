package org.bouncycastle.p191cms;

import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.cryptopro.Gost2814789KeyWrapParameters;
import org.bouncycastle.p133asn1.p139cms.KeyAgreeRecipientInfo;
import org.bouncycastle.p133asn1.p139cms.OriginatorIdentifierOrKey;
import org.bouncycastle.p133asn1.p139cms.OriginatorPublicKey;
import org.bouncycastle.p133asn1.p139cms.RecipientInfo;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;

/* loaded from: classes2.dex */
public abstract class KeyAgreeRecipientInfoGenerator implements RecipientInfoGenerator {
    private final ASN1ObjectIdentifier keyAgreementOID;
    private final ASN1ObjectIdentifier keyEncryptionOID;
    private final SubjectPublicKeyInfo originatorKeyInfo;

    public KeyAgreeRecipientInfoGenerator(ASN1ObjectIdentifier aSN1ObjectIdentifier, SubjectPublicKeyInfo subjectPublicKeyInfo, ASN1ObjectIdentifier aSN1ObjectIdentifier2) {
        this.originatorKeyInfo = subjectPublicKeyInfo;
        this.keyAgreementOID = aSN1ObjectIdentifier;
        this.keyEncryptionOID = aSN1ObjectIdentifier2;
    }

    public OriginatorPublicKey createOriginatorPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        return new OriginatorPublicKey(subjectPublicKeyInfo.getAlgorithm(), subjectPublicKeyInfo.getPublicKeyData());
    }

    @Override // org.bouncycastle.p191cms.RecipientInfoGenerator
    public RecipientInfo generate(GenericKey genericKey) {
        OriginatorIdentifierOrKey originatorIdentifierOrKey = new OriginatorIdentifierOrKey(createOriginatorPublicKey(this.originatorKeyInfo));
        AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(this.keyEncryptionOID, (CMSUtils.m14878isDES(this.keyEncryptionOID) || PKCSObjectIdentifiers.id_alg_CMSRC2wrap.m14446equals((ASN1Primitive) this.keyEncryptionOID)) ? C5103DERNull.INSTANCE : CMSUtils.m14880isGOST(this.keyAgreementOID) ? new Gost2814789KeyWrapParameters(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_A_ParamSet) : null);
        AlgorithmIdentifier algorithmIdentifier2 = new AlgorithmIdentifier(this.keyAgreementOID, algorithmIdentifier);
        return new RecipientInfo(new KeyAgreeRecipientInfo(originatorIdentifierOrKey, DEROctetString.fromContentsOptional(getUserKeyingMaterial(algorithmIdentifier2)), algorithmIdentifier2, generateRecipientEncryptedKeys(algorithmIdentifier2, algorithmIdentifier, genericKey)));
    }

    public abstract ASN1Sequence generateRecipientEncryptedKeys(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, GenericKey genericKey);

    public abstract byte[] getUserKeyingMaterial(AlgorithmIdentifier algorithmIdentifier);
}
