package org.bouncycastle.p133asn1.p142dvcs;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.GeneralNames;
import org.bouncycastle.p133asn1.p174x509.PolicyInformation;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class DVCSRequestInformationBuilder {
    private static final int DEFAULT_VERSION = 1;
    private static final int TAG_DATA_LOCATIONS = 3;
    private static final int TAG_DVCS = 2;
    private static final int TAG_EXTENSIONS = 4;
    private static final int TAG_REQUESTER = 0;
    private static final int TAG_REQUEST_POLICY = 1;
    private GeneralNames dataLocations;

    /* renamed from: dvcs */
    private GeneralNames f18312dvcs;
    private Extensions extensions;
    private DVCSRequestInformation initialInfo;

    /* renamed from: nonce */
    private BigInteger f18313nonce;
    private PolicyInformation requestPolicy;
    private DVCSTime requestTime;
    private GeneralNames requester;

    /* renamed from: service */
    private final ServiceType f18314service;

    /* renamed from: version */
    private int f18315version;

    public DVCSRequestInformationBuilder(DVCSRequestInformation dVCSRequestInformation) {
        this.f18315version = 1;
        this.initialInfo = dVCSRequestInformation;
        this.f18314service = dVCSRequestInformation.getService();
        this.f18315version = dVCSRequestInformation.getVersion();
        this.f18313nonce = dVCSRequestInformation.getNonce();
        this.requestTime = dVCSRequestInformation.getRequestTime();
        this.requestPolicy = dVCSRequestInformation.getRequestPolicy();
        this.f18312dvcs = dVCSRequestInformation.m14584getDVCS();
        this.dataLocations = dVCSRequestInformation.getDataLocations();
    }

    /* renamed from: build */
    public DVCSRequestInformation m14585build() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(9);
        int i = this.f18315version;
        if (i != 1) {
            aSN1EncodableVector.m14420add(ASN1Integer.m14429valueOf(i));
        }
        aSN1EncodableVector.m14420add(this.f18314service);
        if (this.f18313nonce != null) {
            aSN1EncodableVector.m14420add(new ASN1Integer(this.f18313nonce));
        }
        DVCSTime dVCSTime = this.requestTime;
        if (dVCSTime != null) {
            aSN1EncodableVector.m14420add(dVCSTime);
        }
        int[] iArr = {0, 1, 2, 3, 4};
        ASN1Encodable[] aSN1EncodableArr = {this.requester, this.requestPolicy, this.f18312dvcs, this.dataLocations, this.extensions};
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            ASN1Encodable aSN1Encodable = aSN1EncodableArr[i2];
            if (aSN1Encodable != null) {
                aSN1EncodableVector.m14420add(new DERTaggedObject(false, i3, aSN1Encodable));
            }
        }
        return DVCSRequestInformation.getInstance(new DERSequence(aSN1EncodableVector));
    }

    /* renamed from: setDVCS */
    public void m14586setDVCS(GeneralName generalName) {
        m14587setDVCS(new GeneralNames(generalName));
    }

    public void setDataLocations(GeneralName generalName) {
        setDataLocations(new GeneralNames(generalName));
    }

    public void setExtensions(Extensions extensions) {
        if (this.initialInfo != null) {
            throw new IllegalStateException("cannot change extensions in existing DVCSRequestInformation");
        }
        this.extensions = extensions;
    }

    public void setNonce(BigInteger bigInteger) {
        DVCSRequestInformation dVCSRequestInformation = this.initialInfo;
        if (dVCSRequestInformation != null) {
            if (dVCSRequestInformation.getNonce() == null) {
                this.f18313nonce = bigInteger;
            } else {
                byte[] byteArray = this.initialInfo.getNonce().toByteArray();
                byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(bigInteger);
                byte[] bArr = new byte[byteArray.length + bArrAsUnsignedByteArray.length];
                System.arraycopy(byteArray, 0, bArr, 0, byteArray.length);
                System.arraycopy(bArrAsUnsignedByteArray, 0, bArr, byteArray.length, bArrAsUnsignedByteArray.length);
                this.f18313nonce = new BigInteger(bArr);
            }
        }
        this.f18313nonce = bigInteger;
    }

    public void setRequestPolicy(PolicyInformation policyInformation) {
        if (this.initialInfo != null) {
            throw new IllegalStateException("cannot change request policy in existing DVCSRequestInformation");
        }
        this.requestPolicy = policyInformation;
    }

    public void setRequestTime(DVCSTime dVCSTime) {
        if (this.initialInfo != null) {
            throw new IllegalStateException("cannot change request time in existing DVCSRequestInformation");
        }
        this.requestTime = dVCSTime;
    }

    public void setRequester(GeneralName generalName) {
        setRequester(new GeneralNames(generalName));
    }

    public void setVersion(int i) {
        if (this.initialInfo != null) {
            throw new IllegalStateException("cannot change version in existing DVCSRequestInformation");
        }
        this.f18315version = i;
    }

    public DVCSRequestInformationBuilder(ServiceType serviceType) {
        this.f18315version = 1;
        this.f18314service = serviceType;
    }

    /* renamed from: setDVCS */
    public void m14587setDVCS(GeneralNames generalNames) {
        this.f18312dvcs = generalNames;
    }

    public void setDataLocations(GeneralNames generalNames) {
        this.dataLocations = generalNames;
    }

    public void setRequester(GeneralNames generalNames) {
        this.requester = generalNames;
    }
}
