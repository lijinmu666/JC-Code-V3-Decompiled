package org.bouncycastle.p191cms;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p139cms.CMSObjectIdentifiers;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
public class CMSProcessableFile implements CMSTypedData, CMSReadable {
    private static final int DEFAULT_BUF_SIZE = 32768;

    /* renamed from: bufSize */
    private final int f18979bufSize;

    /* renamed from: file */
    private final File f18980file;

    /* renamed from: type */
    private final ASN1ObjectIdentifier f18981type;

    public CMSProcessableFile(File file) {
        this(file, 32768);
    }

    @Override // org.bouncycastle.p191cms.CMSProcessable
    public Object getContent() {
        return this.f18980file;
    }

    @Override // org.bouncycastle.p191cms.CMSTypedData
    public ASN1ObjectIdentifier getContentType() {
        return this.f18981type;
    }

    @Override // org.bouncycastle.p191cms.CMSReadable
    public InputStream getInputStream() {
        return new BufferedInputStream(new FileInputStream(this.f18980file), this.f18979bufSize);
    }

    @Override // org.bouncycastle.p191cms.CMSProcessable
    /* renamed from: write */
    public void mo14759write(OutputStream outputStream) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(this.f18980file);
        C6257Streams.m18362pipeAll(fileInputStream, outputStream, this.f18979bufSize);
        fileInputStream.close();
    }

    public CMSProcessableFile(File file, int i) {
        this(CMSObjectIdentifiers.f18179data, file, i);
    }

    public CMSProcessableFile(ASN1ObjectIdentifier aSN1ObjectIdentifier, File file, int i) {
        this.f18981type = aSN1ObjectIdentifier;
        this.f18980file = file;
        this.f18979bufSize = i;
    }
}
