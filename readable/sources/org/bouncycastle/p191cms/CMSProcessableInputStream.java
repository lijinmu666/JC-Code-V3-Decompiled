package org.bouncycastle.p191cms;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
class CMSProcessableInputStream implements CMSProcessable, CMSReadable {

    /* renamed from: input */
    private InputStream f18982input;

    /* renamed from: used */
    private boolean f18983used = false;

    public CMSProcessableInputStream(InputStream inputStream) {
        this.f18982input = inputStream;
    }

    private synchronized void checkSingleUsage() {
        if (this.f18983used) {
            throw new IllegalStateException("CMSProcessableInputStream can only be used once");
        }
        this.f18983used = true;
    }

    @Override // org.bouncycastle.p191cms.CMSProcessable
    public Object getContent() {
        return getInputStream();
    }

    @Override // org.bouncycastle.p191cms.CMSReadable
    public InputStream getInputStream() {
        checkSingleUsage();
        return this.f18982input;
    }

    @Override // org.bouncycastle.p191cms.CMSProcessable
    /* renamed from: write */
    public void mo14759write(OutputStream outputStream) throws IOException {
        checkSingleUsage();
        C6257Streams.m18361pipeAll(this.f18982input, outputStream);
        this.f18982input.close();
    }
}
