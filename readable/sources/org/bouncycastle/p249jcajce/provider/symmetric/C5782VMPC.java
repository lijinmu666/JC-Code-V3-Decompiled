package org.bouncycastle.p249jcajce.provider.symmetric;

import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.p201engines.VMPCEngine;
import org.bouncycastle.p194crypto.p209macs.C5365VMPCMac;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseStreamCipher;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;

/* renamed from: org.bouncycastle.jcajce.provider.symmetric.VMPC */
/* loaded from: classes2.dex */
public final class C5782VMPC {

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.VMPC$Base */
    public static class Base extends BaseStreamCipher {
        public Base() {
            super(new VMPCEngine(), 16);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.VMPC$KeyGen */
    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("VMPC", 128, new CipherKeyGenerator());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.VMPC$Mac */
    public static class Mac extends C5789BaseMac {
        public Mac() {
            super(new C5365VMPCMac());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.VMPC$Mappings */
    public static class Mappings extends AlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21840PREFIX = C5782VMPC.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21840PREFIX;
            sb.append(str);
            sb.append("$Base");
            configurableProvider.addAlgorithm("Cipher.VMPC", sb.toString());
            configurableProvider.addAlgorithm("KeyGenerator.VMPC", str + "$KeyGen");
            configurableProvider.addAlgorithm("Mac.VMPCMAC", str + "$Mac");
            configurableProvider.addAlgorithm("Alg.Alias.Mac.VMPC", "VMPCMAC");
            configurableProvider.addAlgorithm("Alg.Alias.Mac.VMPC-MAC", "VMPCMAC");
        }
    }

    private C5782VMPC() {
    }
}
