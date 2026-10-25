package org.bouncycastle.p191cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p139cms.CMSObjectIdentifiers;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class CMSProcessableByteArray implements CMSTypedData, CMSReadable {

    /* renamed from: bytes */
    private final byte[] f18977bytes;

    /* renamed from: type */
    private final ASN1ObjectIdentifier f18978type;

    public CMSProcessableByteArray(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr) {
        this.f18978type = aSN1ObjectIdentifier;
        this.f18977bytes = bArr;
    }

    @Override // org.bouncycastle.p191cms.CMSProcessable
    public Object getContent() {
        return C6238Arrays.m18231clone(this.f18977bytes);
    }

    @Override // org.bouncycastle.p191cms.CMSTypedData
    public ASN1ObjectIdentifier getContentType() {
        return this.f18978type;
    }

    @Override // org.bouncycastle.p191cms.CMSReadable
    public InputStream getInputStream() {
        return new ByteArrayInputStream(this.f18977bytes);
    }

    @Override // org.bouncycastle.p191cms.CMSProcessable
    /* renamed from: write */
    public void mo14759write(OutputStream outputStream) throws IOException {
        outputStream.write(this.f18977bytes);
    }

    public CMSProcessableByteArray(byte[] bArr) {
        this(CMSObjectIdentifiers.f18179data, bArr);
    }
}
