package org.bouncycastle.p249jcajce.p279spec;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.security.spec.AlgorithmParameterSpec;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
public class SkeinParameterSpec implements AlgorithmParameterSpec {
    public static final int PARAM_TYPE_CONFIG = 4;
    public static final int PARAM_TYPE_KEY = 0;
    public static final int PARAM_TYPE_KEY_IDENTIFIER = 16;
    public static final int PARAM_TYPE_MESSAGE = 48;
    public static final int PARAM_TYPE_NONCE = 20;
    public static final int PARAM_TYPE_OUTPUT = 63;
    public static final int PARAM_TYPE_PERSONALISATION = 8;
    public static final int PARAM_TYPE_PUBLIC_KEY = 12;
    private Map parameters;

    /* renamed from: org.bouncycastle.jcajce.spec.SkeinParameterSpec$Builder */
    public static class C5803Builder {
        private Map parameters = new HashMap();

        public C5803Builder() {
        }

        /* renamed from: build */
        public SkeinParameterSpec m16218build() {
            return new SkeinParameterSpec(this.parameters);
        }

        /* renamed from: set */
        public C5803Builder m16219set(int i, byte[] bArr) {
            if (bArr == null) {
                throw new IllegalArgumentException("Parameter value must not be null.");
            }
            if (i != 0 && (i <= 4 || i >= 63 || i == 48)) {
                throw new IllegalArgumentException("Parameter types must be in the range 0,5..47,49..62.");
            }
            if (i == 4) {
                throw new IllegalArgumentException("Parameter type 4 is reserved for internal use.");
            }
            this.parameters.put(Integers.m18296valueOf(i), bArr);
            return this;
        }

        /* renamed from: setKey */
        public C5803Builder m16220setKey(byte[] bArr) {
            return m16219set(0, bArr);
        }

        public C5803Builder setKeyIdentifier(byte[] bArr) {
            return m16219set(16, bArr);
        }

        public C5803Builder setNonce(byte[] bArr) {
            return m16219set(20, bArr);
        }

        public C5803Builder setPersonalisation(Date date, String str, String str2) throws IOException {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, "UTF-8");
                outputStreamWriter.write(new SimpleDateFormat("yyyyMMdd").format(date));
                outputStreamWriter.write(" ");
                outputStreamWriter.write(str);
                outputStreamWriter.write(" ");
                outputStreamWriter.write(str2);
                outputStreamWriter.close();
                return m16219set(8, byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException("Byte I/O failed: " + e);
            }
        }

        public C5803Builder setPublicKey(byte[] bArr) {
            return m16219set(12, bArr);
        }

        public C5803Builder(SkeinParameterSpec skeinParameterSpec) {
            for (Integer num : skeinParameterSpec.parameters.keySet()) {
                this.parameters.put(num, skeinParameterSpec.parameters.get(num));
            }
        }

        public C5803Builder setPersonalisation(Date date, Locale locale, String str, String str2) throws IOException {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, "UTF-8");
                outputStreamWriter.write(new SimpleDateFormat("yyyyMMdd", locale).format(date));
                outputStreamWriter.write(" ");
                outputStreamWriter.write(str);
                outputStreamWriter.write(" ");
                outputStreamWriter.write(str2);
                outputStreamWriter.close();
                return m16219set(8, byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException("Byte I/O failed: " + e);
            }
        }

        public C5803Builder setPersonalisation(byte[] bArr) {
            return m16219set(8, bArr);
        }
    }

    public SkeinParameterSpec() {
        this(new HashMap());
    }

    /* renamed from: getKey */
    public byte[] m16217getKey() {
        return C6238Arrays.m18231clone((byte[]) this.parameters.get(Integers.m18296valueOf(0)));
    }

    public byte[] getKeyIdentifier() {
        return C6238Arrays.m18231clone((byte[]) this.parameters.get(Integers.m18296valueOf(16)));
    }

    public byte[] getNonce() {
        return C6238Arrays.m18231clone((byte[]) this.parameters.get(Integers.m18296valueOf(20)));
    }

    public Map getParameters() {
        return this.parameters;
    }

    public byte[] getPersonalisation() {
        return C6238Arrays.m18231clone((byte[]) this.parameters.get(Integers.m18296valueOf(8)));
    }

    public byte[] getPublicKey() {
        return C6238Arrays.m18231clone((byte[]) this.parameters.get(Integers.m18296valueOf(12)));
    }

    private SkeinParameterSpec(Map map) {
        this.parameters = Collections.unmodifiableMap(map);
    }
}
