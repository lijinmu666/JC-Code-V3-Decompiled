package org.bouncycastle.p133asn1.p143eac;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p361util.Integers;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class CertificateHolderAuthorization extends ASN1Object {

    /* renamed from: CVCA */
    public static final int f18335CVCA = 192;
    public static final int DV_DOMESTIC = 128;
    public static final int DV_FOREIGN = 64;

    /* renamed from: IS */
    public static final int f18336IS = 0;

    /* renamed from: RADG3 */
    public static final int f18337RADG3 = 1;

    /* renamed from: RADG4 */
    public static final int f18338RADG4 = 2;
    private byte accessRights;

    /* renamed from: oid */
    private ASN1ObjectIdentifier f18339oid;
    public static final ASN1ObjectIdentifier id_role_EAC = EACObjectIdentifiers.f18340bsi_de.m14432branch("3.1.2.1");
    static Map RightsDecodeMap = new HashMap();
    static BidirectionalMap AuthorizationRole = new BidirectionalMap();

    static {
        RightsDecodeMap.put(Integers.m18296valueOf(2), "RADG4");
        RightsDecodeMap.put(Integers.m18296valueOf(1), "RADG3");
        AuthorizationRole.put(Integers.m18296valueOf(192), "CVCA");
        AuthorizationRole.put(Integers.m18296valueOf(128), "DV_DOMESTIC");
        AuthorizationRole.put(Integers.m18296valueOf(64), "DV_FOREIGN");
        AuthorizationRole.put(Integers.m18296valueOf(0), "IS");
    }

    public CertificateHolderAuthorization(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i) {
        m14592setOid(aSN1ObjectIdentifier);
        setAccessRights((byte) i);
    }

    /* renamed from: getFlag */
    public static int m14591getFlag(String str) {
        Integer num = (Integer) AuthorizationRole.getReverse(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("Unknown value " + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String getRoleDescription(int i) {
        return (String) AuthorizationRole.get(Integers.m18296valueOf(i));
    }

    private void setAccessRights(byte b) {
        this.accessRights = b;
    }

    /* renamed from: setOid */
    private void m14592setOid(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.f18339oid = aSN1ObjectIdentifier;
    }

    private void setPrivateData(ASN1Sequence aSN1Sequence) {
        ASN1Primitive aSN1Primitive = (ASN1Primitive) aSN1Sequence.getObjectAt(0);
        if (!(aSN1Primitive instanceof ASN1ObjectIdentifier)) {
            throw new IllegalArgumentException("no Oid in CerticateHolderAuthorization");
        }
        this.f18339oid = (ASN1ObjectIdentifier) aSN1Primitive;
        ASN1Primitive aSN1Primitive2 = (ASN1Primitive) aSN1Sequence.getObjectAt(1);
        if (!(aSN1Primitive2 instanceof ASN1TaggedObject)) {
            throw new IllegalArgumentException("No access rights in CerticateHolderAuthorization");
        }
        this.accessRights = ASN1OctetString.getInstance(ASN1TaggedObject.getInstance(aSN1Primitive2, 64, 19).getBaseUniversal(false, 4)).getOctets()[0];
    }

    public int getAccessRights() {
        return this.accessRights & C1126UByte.MAX_VALUE;
    }

    /* renamed from: getOid */
    public ASN1ObjectIdentifier m14593getOid() {
        return this.f18339oid;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return EACTagged.m14594create(76, new DERSequence(this.f18339oid, EACTagged.m14596create(19, new byte[]{this.accessRights})));
    }

    public CertificateHolderAuthorization(ASN1TaggedObject aSN1TaggedObject) {
        if (!aSN1TaggedObject.mo14457hasTag(64, 76)) {
            throw new IllegalArgumentException("Unrecognized object in CerticateHolderAuthorization");
        }
        setPrivateData(ASN1Sequence.getInstance(aSN1TaggedObject.getBaseUniversal(false, 16)));
    }
}
