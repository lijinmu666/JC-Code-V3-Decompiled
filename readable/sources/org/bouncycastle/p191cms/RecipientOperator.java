package org.bouncycastle.p191cms;

import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.operator.InputAEADDecryptor;
import org.bouncycastle.operator.InputDecryptor;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.p361util.p362io.TeeInputStream;

/* loaded from: classes2.dex */
public class RecipientOperator {
    private final Object operator;

    public RecipientOperator(InputDecryptor inputDecryptor) {
        this.operator = inputDecryptor;
    }

    public OutputStream getAADStream() {
        return ((InputAEADDecryptor) this.operator).getAADStream();
    }

    public InputStream getInputStream(InputStream inputStream) {
        Object obj = this.operator;
        return obj instanceof InputDecryptor ? ((InputDecryptor) obj).getInputStream(inputStream) : new TeeInputStream(inputStream, ((MacCalculator) this.operator).getOutputStream());
    }

    /* renamed from: getMac */
    public byte[] m14896getMac() {
        Object obj = this.operator;
        if (obj instanceof MacCalculator) {
            return ((MacCalculator) obj).mo14790getMac();
        }
        if (obj instanceof InputAEADDecryptor) {
            return ((InputAEADDecryptor) obj).mo14908getMAC();
        }
        return null;
    }

    public boolean isAEADBased() {
        return this.operator instanceof InputAEADDecryptor;
    }

    public boolean isMacBased() {
        return this.operator instanceof MacCalculator;
    }

    public RecipientOperator(MacCalculator macCalculator) {
        this.operator = macCalculator;
    }
}
