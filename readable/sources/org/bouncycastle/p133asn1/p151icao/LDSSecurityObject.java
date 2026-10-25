package org.bouncycastle.p133asn1.p151icao;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public class LDSSecurityObject extends ASN1Object implements ICAOObjectIdentifiers {
    public static final int ub_DataGroups = 16;
    private DataGroupHash[] datagroupHash;
    private AlgorithmIdentifier digestAlgorithmIdentifier;

    /* renamed from: version */
    private ASN1Integer f18406version;
    private LDSVersionInfo versionInfo;

    private LDSSecurityObject(ASN1Sequence aSN1Sequence) {
        this.f18406version = ASN1Integer.f17922ZERO;
        if (aSN1Sequence == null || aSN1Sequence.mo14450size() == 0) {
            throw new IllegalArgumentException("null or empty sequence passed.");
        }
        Enumeration objects = aSN1Sequence.getObjects();
        this.f18406version = ASN1Integer.getInstance(objects.nextElement());
        this.digestAlgorithmIdentifier = AlgorithmIdentifier.getInstance(objects.nextElement());
        ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(objects.nextElement());
        if (this.f18406version.hasValue(1)) {
            this.versionInfo = LDSVersionInfo.getInstance(objects.nextElement());
        }
        checkDatagroupHashSeqSize(aSN1Sequence2.mo14450size());
        this.datagroupHash = new DataGroupHash[aSN1Sequence2.mo14450size()];
        for (int i = 0; i < aSN1Sequence2.mo14450size(); i++) {
            this.datagroupHash[i] = DataGroupHash.getInstance(aSN1Sequence2.getObjectAt(i));
        }
    }

    private void checkDatagroupHashSeqSize(int i) {
        if (i < 2 || i > 16) {
            throw new IllegalArgumentException("wrong size in DataGroupHashValues : not in (2..16)");
        }
    }

    /* renamed from: copy */
    private DataGroupHash[] m14614copy(DataGroupHash[] dataGroupHashArr) {
        int length = dataGroupHashArr.length;
        DataGroupHash[] dataGroupHashArr2 = new DataGroupHash[length];
        System.arraycopy(dataGroupHashArr, 0, dataGroupHashArr2, 0, length);
        return dataGroupHashArr2;
    }

    public static LDSSecurityObject getInstance(Object obj) {
        if (obj instanceof LDSSecurityObject) {
            return (LDSSecurityObject) obj;
        }
        if (obj != null) {
            return new LDSSecurityObject(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public DataGroupHash[] getDatagroupHash() {
        return m14614copy(this.datagroupHash);
    }

    public AlgorithmIdentifier getDigestAlgorithmIdentifier() {
        return this.digestAlgorithmIdentifier;
    }

    public int getVersion() {
        return this.f18406version.intValueExact();
    }

    public LDSVersionInfo getVersionInfo() {
        return this.versionInfo;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
        aSN1EncodableVector.m14420add(this.f18406version);
        aSN1EncodableVector.m14420add(this.digestAlgorithmIdentifier);
        aSN1EncodableVector.m14420add(new DERSequence(this.datagroupHash));
        LDSVersionInfo lDSVersionInfo = this.versionInfo;
        if (lDSVersionInfo != null) {
            aSN1EncodableVector.m14420add(lDSVersionInfo);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public LDSSecurityObject(AlgorithmIdentifier algorithmIdentifier, DataGroupHash[] dataGroupHashArr) {
        this.f18406version = ASN1Integer.f17922ZERO;
        this.digestAlgorithmIdentifier = algorithmIdentifier;
        this.datagroupHash = m14614copy(dataGroupHashArr);
        checkDatagroupHashSeqSize(dataGroupHashArr.length);
    }

    public LDSSecurityObject(AlgorithmIdentifier algorithmIdentifier, DataGroupHash[] dataGroupHashArr, LDSVersionInfo lDSVersionInfo) {
        this.f18406version = ASN1Integer.f17922ZERO;
        this.f18406version = ASN1Integer.f17918ONE;
        this.digestAlgorithmIdentifier = algorithmIdentifier;
        this.datagroupHash = m14614copy(dataGroupHashArr);
        this.versionInfo = lDSVersionInfo;
        checkDatagroupHashSeqSize(dataGroupHashArr.length);
    }
}
