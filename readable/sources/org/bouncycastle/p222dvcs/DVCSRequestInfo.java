package org.bouncycastle.p222dvcs;

import java.math.BigInteger;
import java.util.Date;
import org.bouncycastle.p133asn1.p142dvcs.DVCSRequestInformation;
import org.bouncycastle.p133asn1.p142dvcs.DVCSTime;
import org.bouncycastle.p133asn1.p174x509.GeneralNames;
import org.bouncycastle.p133asn1.p174x509.PolicyInformation;
import org.bouncycastle.p358tsp.TimeStampToken;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class DVCSRequestInfo {

    /* renamed from: data */
    private DVCSRequestInformation f21145data;

    public DVCSRequestInfo(DVCSRequestInformation dVCSRequestInformation) {
        this.f21145data = dVCSRequestInformation;
    }

    private static boolean clientEqualsServer(Object obj, Object obj2) {
        return (obj == null && obj2 == null) || (obj != null && obj.equals(obj2));
    }

    public static boolean validate(DVCSRequestInfo dVCSRequestInfo, DVCSRequestInfo dVCSRequestInfo2) {
        DVCSRequestInformation dVCSRequestInformation = dVCSRequestInfo.f21145data;
        DVCSRequestInformation dVCSRequestInformation2 = dVCSRequestInfo2.f21145data;
        if (dVCSRequestInformation.getVersion() != dVCSRequestInformation2.getVersion() || !clientEqualsServer(dVCSRequestInformation.getService(), dVCSRequestInformation2.getService()) || !clientEqualsServer(dVCSRequestInformation.getRequestTime(), dVCSRequestInformation2.getRequestTime()) || !clientEqualsServer(dVCSRequestInformation.getRequestPolicy(), dVCSRequestInformation2.getRequestPolicy()) || !clientEqualsServer(dVCSRequestInformation.getExtensions(), dVCSRequestInformation2.getExtensions())) {
            return false;
        }
        if (dVCSRequestInformation.getNonce() == null) {
            return true;
        }
        if (dVCSRequestInformation2.getNonce() == null) {
            return false;
        }
        byte[] byteArray = dVCSRequestInformation.getNonce().toByteArray();
        byte[] byteArray2 = dVCSRequestInformation2.getNonce().toByteArray();
        return byteArray2.length >= byteArray.length && C6238Arrays.areEqual(byteArray, C6238Arrays.copyOfRange(byteArray2, 0, byteArray.length));
    }

    public GeneralNames getDVCSNames() {
        return this.f21145data.m14584getDVCS();
    }

    public GeneralNames getDataLocations() {
        return this.f21145data.getDataLocations();
    }

    public BigInteger getNonce() {
        return this.f21145data.getNonce();
    }

    public PolicyInformation getRequestPolicy() {
        if (this.f21145data.getRequestPolicy() != null) {
            return this.f21145data.getRequestPolicy();
        }
        return null;
    }

    public Date getRequestTime() throws DVCSParsingException {
        DVCSTime requestTime = this.f21145data.getRequestTime();
        if (requestTime == null) {
            return null;
        }
        try {
            return requestTime.getGenTime() != null ? requestTime.getGenTime().m14427getDate() : new TimeStampToken(requestTime.getTimeStampToken()).getTimeStampInfo().getGenTime();
        } catch (Exception e) {
            throw new DVCSParsingException("unable to extract time: " + e.getMessage(), e);
        }
    }

    public GeneralNames getRequester() {
        return this.f21145data.getRequester();
    }

    public int getServiceType() {
        return this.f21145data.getService().getValue().intValue();
    }

    public int getVersion() {
        return this.f21145data.getVersion();
    }

    public DVCSRequestInformation toASN1Structure() {
        return this.f21145data;
    }

    public DVCSRequestInfo(byte[] bArr) {
        this(DVCSRequestInformation.getInstance(bArr));
    }
}
