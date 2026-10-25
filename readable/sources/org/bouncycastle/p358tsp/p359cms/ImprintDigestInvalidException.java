package org.bouncycastle.p358tsp.p359cms;

import org.bouncycastle.p358tsp.TimeStampToken;

/* loaded from: classes2.dex */
public class ImprintDigestInvalidException extends Exception {

    /* renamed from: token */
    private TimeStampToken f24174token;

    public ImprintDigestInvalidException(String str, TimeStampToken timeStampToken) {
        super(str);
        this.f24174token = timeStampToken;
    }

    public TimeStampToken getTimeStampToken() {
        return this.f24174token;
    }
}
