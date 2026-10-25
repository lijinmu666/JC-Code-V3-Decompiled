package org.bouncycastle.p249jcajce.provider.asymmetric;

import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p249jcajce.p279spec.ContextParameterSpec;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AsymmetricAlgorithmProvider;

/* renamed from: org.bouncycastle.jcajce.provider.asymmetric.CONTEXT */
/* loaded from: classes2.dex */
public class C5486CONTEXT {

    /* renamed from: PREFIX */
    private static final String f21382PREFIX = "org.bouncycastle.jcajce.provider.asymmetric.CONTEXT$";

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.CONTEXT$ContextAlgorithmParametersSpi */
    public static class ContextAlgorithmParametersSpi extends AlgorithmParametersSpi {
        private ContextParameterSpec contextParameterSpec;

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded() {
            throw new IllegalStateException("not implemented");
        }

        @Override // java.security.AlgorithmParametersSpi
        public AlgorithmParameterSpec engineGetParameterSpec(Class cls) {
            if (cls == null) {
                throw new NullPointerException("argument to getParameterSpec must not be null");
            }
            if (cls == ContextParameterSpec.class) {
                return this.contextParameterSpec;
            }
            throw new IllegalArgumentException("argument to getParameterSpec must be ContextParameterSpec.class");
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) {
            if (!(algorithmParameterSpec instanceof ContextParameterSpec)) {
                throw new IllegalArgumentException("argument to engineInit must be a ContextParameterSpec");
            }
            this.contextParameterSpec = (ContextParameterSpec) algorithmParameterSpec;
        }

        @Override // java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "ContextParameterSpec";
        }

        public boolean isASN1FormatString(String str) {
            return str == null || str.equals("ASN.1");
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded(String str) {
            throw new IllegalStateException("not implemented");
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr) {
            throw new IllegalStateException("not implemented");
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr, String str) {
            throw new IllegalStateException("not implemented");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.CONTEXT$Mappings */
    public static class Mappings extends AsymmetricAlgorithmProvider {
        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("AlgorithmParameters.CONTEXT", "org.bouncycastle.jcajce.provider.asymmetric.CONTEXT$ContextAlgorithmParametersSpi");
        }
    }
}
