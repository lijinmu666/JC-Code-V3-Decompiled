package org.bouncycastle.p194crypto.p213params;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
public class SkeinParameters implements CipherParameters {
    public static final int PARAM_TYPE_CONFIG = 4;
    public static final int PARAM_TYPE_KEY = 0;
    public static final int PARAM_TYPE_KEY_IDENTIFIER = 16;
    public static final int PARAM_TYPE_MESSAGE = 48;
    public static final int PARAM_TYPE_NONCE = 20;
    public static final int PARAM_TYPE_OUTPUT = 63;
    public static final int PARAM_TYPE_PERSONALISATION = 8;
    public static final int PARAM_TYPE_PUBLIC_KEY = 12;
    private Hashtable parameters;

    /* renamed from: org.bouncycastle.crypto.params.SkeinParameters$Builder */
    public static class C5375Builder {
        private Hashtable parameters = new Hashtable();

        public C5375Builder() {
        }

        /* renamed from: build */
        public SkeinParameters m15828build() {
            return new SkeinParameters(this.parameters);
        }

        /* renamed from: set */
        public C5375Builder m15829set(int i, byte[] bArr) {
            if (bArr == null) {
                throw new IllegalArgumentException("Parameter value must not be null.");
            }
            if (i != 0 && (i < 4 || i >= 63 || i == 48)) {
                throw new IllegalArgumentException("Parameter types must be in the range 0,5..47,49..62.");
            }
            if (i == 4) {
                throw new IllegalArgumentException("Parameter type 4 is reserved for internal use.");
            }
            this.parameters.put(Integers.m18296valueOf(i), bArr);
            return this;
        }

        /* renamed from: setKey */
        public C5375Builder m15830setKey(byte[] bArr) {
            return m15829set(0, bArr);
        }

        public C5375Builder setKeyIdentifier(byte[] bArr) {
            return m15829set(16, bArr);
        }

        public C5375Builder setNonce(byte[] bArr) {
            return m15829set(20, bArr);
        }

        public C5375Builder setPersonalisation(Date date, String str, String str2) throws IOException {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, "UTF-8");
                outputStreamWriter.write(new SimpleDateFormat("yyyyMMdd").format(date));
                outputStreamWriter.write(" ");
                outputStreamWriter.write(str);
                outputStreamWriter.write(" ");
                outputStreamWriter.write(str2);
                outputStreamWriter.close();
                return m15829set(8, byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException("Byte I/O failed: " + e);
            }
        }

        public C5375Builder setPublicKey(byte[] bArr) {
            return m15829set(12, bArr);
        }

        public C5375Builder(Hashtable hashtable) {
            Enumeration enumerationKeys = hashtable.keys();
            while (enumerationKeys.hasMoreElements()) {
                Integer num = (Integer) enumerationKeys.nextElement();
                this.parameters.put(num, hashtable.get(num));
            }
        }

        public C5375Builder setPersonalisation(Date date, Locale locale, String str, String str2) throws IOException {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, "UTF-8");
                outputStreamWriter.write(new SimpleDateFormat("yyyyMMdd", locale).format(date));
                outputStreamWriter.write(" ");
                outputStreamWriter.write(str);
                outputStreamWriter.write(" ");
                outputStreamWriter.write(str2);
                outputStreamWriter.close();
                return m15829set(8, byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException("Byte I/O failed: " + e);
            }
        }

        public C5375Builder(SkeinParameters skeinParameters) {
            Enumeration enumerationKeys = skeinParameters.parameters.keys();
            while (enumerationKeys.hasMoreElements()) {
                Integer num = (Integer) enumerationKeys.nextElement();
                this.parameters.put(num, skeinParameters.parameters.get(num));
            }
        }

        public C5375Builder setPersonalisation(byte[] bArr) {
            return m15829set(8, bArr);
        }
    }

    public SkeinParameters() {
        this(new Hashtable());
    }

    /* renamed from: getKey */
    public byte[] m15827getKey() {
        return (byte[]) this.parameters.get(Integers.m18296valueOf(0));
    }

    public byte[] getKeyIdentifier() {
        return (byte[]) this.parameters.get(Integers.m18296valueOf(16));
    }

    public byte[] getNonce() {
        return (byte[]) this.parameters.get(Integers.m18296valueOf(20));
    }

    public Hashtable getParameters() {
        return this.parameters;
    }

    public byte[] getPersonalisation() {
        return (byte[]) this.parameters.get(Integers.m18296valueOf(8));
    }

    public byte[] getPublicKey() {
        return (byte[]) this.parameters.get(Integers.m18296valueOf(12));
    }

    private SkeinParameters(Hashtable hashtable) {
        this.parameters = hashtable;
    }
}
