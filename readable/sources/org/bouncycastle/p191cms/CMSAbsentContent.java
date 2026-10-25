package org.bouncycastle.p191cms;

import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p139cms.CMSObjectIdentifiers;

/* loaded from: classes2.dex */
public class CMSAbsentContent implements CMSTypedData, CMSReadable {

    /* renamed from: type */
    private final ASN1ObjectIdentifier f18926type;

    public CMSAbsentContent() {
        this(CMSObjectIdentifiers.f18179data);
    }

    @Override // org.bouncycastle.p191cms.CMSProcessable
    public Object getContent() {
        return null;
    }

    @Override // org.bouncycastle.p191cms.CMSTypedData
    public ASN1ObjectIdentifier getContentType() {
        return this.f18926type;
    }

    @Override // org.bouncycastle.p191cms.CMSReadable
    public InputStream getInputStream() {
        return null;
    }

    @Override // org.bouncycastle.p191cms.CMSProcessable
    /* renamed from: write */
    public void mo14759write(OutputStream outputStream) {
    }

    public CMSAbsentContent(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.f18926type = aSN1ObjectIdentifier;
    }
}
