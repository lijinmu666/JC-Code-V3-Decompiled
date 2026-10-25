package org.bouncycastle.p177cert.p180crmf;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1UTF8String;
import org.bouncycastle.p133asn1.DERUTF8String;
import org.bouncycastle.p133asn1.p141crmf.CRMFObjectIdentifiers;

/* loaded from: classes2.dex */
public class RegTokenControl implements InterfaceC5223Control {

    /* renamed from: type */
    private static final ASN1ObjectIdentifier f18841type = CRMFObjectIdentifiers.id_regCtrl_regToken;

    /* renamed from: token */
    private final ASN1UTF8String f18842token;

    public RegTokenControl(String str) {
        this.f18842token = new DERUTF8String(str);
    }

    @Override // org.bouncycastle.p177cert.p180crmf.InterfaceC5223Control
    /* renamed from: getType */
    public ASN1ObjectIdentifier mo14777getType() {
        return f18841type;
    }

    @Override // org.bouncycastle.p177cert.p180crmf.InterfaceC5223Control
    public ASN1Encodable getValue() {
        return this.f18842token;
    }

    public RegTokenControl(ASN1UTF8String aSN1UTF8String) {
        this.f18842token = aSN1UTF8String;
    }
}
