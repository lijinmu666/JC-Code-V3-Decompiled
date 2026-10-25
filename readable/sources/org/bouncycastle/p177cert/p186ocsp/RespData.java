package org.bouncycastle.p177cert.p186ocsp;

import java.util.Date;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.p164ocsp.ResponseData;
import org.bouncycastle.p133asn1.p164ocsp.SingleResponse;
import org.bouncycastle.p133asn1.p174x509.Extensions;

/* loaded from: classes2.dex */
public class RespData {

    /* renamed from: data */
    private ResponseData f18895data;

    public RespData(ResponseData responseData) {
        this.f18895data = responseData;
    }

    public Date getProducedAt() {
        return OCSPUtils.extractDate(this.f18895data.getProducedAt());
    }

    public C5230RespID getResponderId() {
        return new C5230RespID(this.f18895data.getResponderID());
    }

    public Extensions getResponseExtensions() {
        return this.f18895data.getResponseExtensions();
    }

    public SingleResp[] getResponses() {
        ASN1Sequence responses = this.f18895data.getResponses();
        int iMo14450size = responses.mo14450size();
        SingleResp[] singleRespArr = new SingleResp[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            singleRespArr[i] = new SingleResp(SingleResponse.getInstance(responses.getObjectAt(i)));
        }
        return singleRespArr;
    }

    public int getVersion() {
        return this.f18895data.getVersion().intValueExact() + 1;
    }
}
