package org.bouncycastle.p302openssl;

import java.io.IOException;
import java.io.Writer;
import org.bouncycastle.p302openssl.p304jcajce.JcaMiscPEMGenerator;
import org.bouncycastle.p361util.p362io.p363pem.PemGenerationException;
import org.bouncycastle.p361util.p362io.p363pem.PemObjectGenerator;
import org.bouncycastle.p361util.p362io.p363pem.PemWriter;

/* loaded from: classes2.dex */
public class PEMWriter extends PemWriter {
    public PEMWriter(Writer writer) {
        super(writer);
    }

    public void writeObject(Object obj) throws IOException {
        writeObject(obj, null);
    }

    public void writeObject(Object obj, PEMEncryptor pEMEncryptor) throws IOException {
        try {
            super.writeObject((PemObjectGenerator) new JcaMiscPEMGenerator(obj, pEMEncryptor));
        } catch (PemGenerationException e) {
            if (!(e.getCause() instanceof IOException)) {
                throw e;
            }
            throw ((IOException) e.getCause());
        }
    }

    @Override // org.bouncycastle.p361util.p362io.p363pem.PemWriter
    public void writeObject(PemObjectGenerator pemObjectGenerator) throws IOException {
        super.writeObject(pemObjectGenerator);
    }
}
