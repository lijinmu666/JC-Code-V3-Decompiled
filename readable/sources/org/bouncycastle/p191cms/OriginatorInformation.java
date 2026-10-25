package org.bouncycastle.p191cms;

import org.bouncycastle.p133asn1.p139cms.OriginatorInfo;
import org.bouncycastle.p361util.InterfaceC6249Store;

/* loaded from: classes2.dex */
public class OriginatorInformation {
    private OriginatorInfo originatorInfo;

    public OriginatorInformation(OriginatorInfo originatorInfo) {
        this.originatorInfo = originatorInfo;
    }

    /* renamed from: getCRLs */
    public InterfaceC6249Store m14887getCRLs() {
        return CMSSignedHelper.INSTANCE.m14876getCRLs(this.originatorInfo.m14547getCRLs());
    }

    public InterfaceC6249Store getCertificates() {
        return CMSSignedHelper.INSTANCE.getCertificates(this.originatorInfo.getCertificates());
    }

    public OriginatorInfo toASN1Structure() {
        return this.originatorInfo;
    }
}
