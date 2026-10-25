package com.p038google.p061crypto.p062tink.p075subtle;

import com.p038google.p061crypto.p062tink.p065config.internal.TinkFipsUtil;
import com.p038google.p061crypto.p062tink.p075subtle.EngineWrapper;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* loaded from: classes.dex */
public final class EngineFactory<T_WRAPPER extends EngineWrapper<JcePrimitiveT>, JcePrimitiveT> {

    /* renamed from: policy */
    private final InterfaceC0861Policy<JcePrimitiveT> f3963policy;

    /* renamed from: CIPHER */
    public static final EngineFactory<EngineWrapper.C0862TCipher, Cipher> f3961CIPHER = new EngineFactory<>(new EngineWrapper.C0862TCipher());

    /* renamed from: MAC */
    public static final EngineFactory<EngineWrapper.C0863TMac, Mac> f3962MAC = new EngineFactory<>(new EngineWrapper.C0863TMac());
    public static final EngineFactory<EngineWrapper.TSignature, Signature> SIGNATURE = new EngineFactory<>(new EngineWrapper.TSignature());
    public static final EngineFactory<EngineWrapper.TMessageDigest, MessageDigest> MESSAGE_DIGEST = new EngineFactory<>(new EngineWrapper.TMessageDigest());
    public static final EngineFactory<EngineWrapper.TKeyAgreement, KeyAgreement> KEY_AGREEMENT = new EngineFactory<>(new EngineWrapper.TKeyAgreement());
    public static final EngineFactory<EngineWrapper.TKeyPairGenerator, KeyPairGenerator> KEY_PAIR_GENERATOR = new EngineFactory<>(new EngineWrapper.TKeyPairGenerator());
    public static final EngineFactory<EngineWrapper.TKeyFactory, KeyFactory> KEY_FACTORY = new EngineFactory<>(new EngineWrapper.TKeyFactory());

    public static class AndroidPolicy<JcePrimitiveT> implements InterfaceC0861Policy<JcePrimitiveT> {
        private final EngineWrapper<JcePrimitiveT> jceFactory;

        @Override // com.p038google.p061crypto.p062tink.p075subtle.EngineFactory.InterfaceC0861Policy
        public JcePrimitiveT getInstance(String str) {
            Iterator<Provider> it = EngineFactory.toProviderList("GmsCore_OpenSSL", "AndroidOpenSSL").iterator();
            Exception exc = null;
            while (it.hasNext()) {
                try {
                    return this.jceFactory.getInstance(str, it.next());
                } catch (Exception e) {
                    if (exc == null) {
                        exc = e;
                    }
                }
            }
            return this.jceFactory.getInstance(str, null);
        }

        private AndroidPolicy(EngineWrapper<JcePrimitiveT> engineWrapper) {
            this.jceFactory = engineWrapper;
        }

        @Override // com.p038google.p061crypto.p062tink.p075subtle.EngineFactory.InterfaceC0861Policy
        public JcePrimitiveT getInstance(String str, List<Provider> list) {
            return getInstance(str);
        }
    }

    public static class DefaultPolicy<JcePrimitiveT> implements InterfaceC0861Policy<JcePrimitiveT> {
        private final EngineWrapper<JcePrimitiveT> jceFactory;

        @Override // com.p038google.p061crypto.p062tink.p075subtle.EngineFactory.InterfaceC0861Policy
        public JcePrimitiveT getInstance(String str) {
            return this.jceFactory.getInstance(str, null);
        }

        private DefaultPolicy(EngineWrapper<JcePrimitiveT> engineWrapper) {
            this.jceFactory = engineWrapper;
        }

        @Override // com.p038google.p061crypto.p062tink.p075subtle.EngineFactory.InterfaceC0861Policy
        public JcePrimitiveT getInstance(String str, List<Provider> list) {
            Iterator<Provider> it = list.iterator();
            while (it.hasNext()) {
                try {
                    return this.jceFactory.getInstance(str, it.next());
                } catch (Exception unused) {
                }
            }
            return this.getInstance(str);
        }
    }

    public static class FipsPolicy<JcePrimitiveT> implements InterfaceC0861Policy<JcePrimitiveT> {
        private final EngineWrapper<JcePrimitiveT> jceFactory;

        @Override // com.p038google.p061crypto.p062tink.p075subtle.EngineFactory.InterfaceC0861Policy
        public JcePrimitiveT getInstance(String str) throws GeneralSecurityException {
            Iterator<Provider> it = EngineFactory.toProviderList("GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt").iterator();
            Exception exc = null;
            while (it.hasNext()) {
                try {
                    return this.jceFactory.getInstance(str, it.next());
                } catch (Exception e) {
                    if (exc == null) {
                        exc = e;
                    }
                }
            }
            throw new GeneralSecurityException("No good Provider found.", exc);
        }

        private FipsPolicy(EngineWrapper<JcePrimitiveT> engineWrapper) {
            this.jceFactory = engineWrapper;
        }

        @Override // com.p038google.p061crypto.p062tink.p075subtle.EngineFactory.InterfaceC0861Policy
        public JcePrimitiveT getInstance(String str, List<Provider> list) {
            return getInstance(str);
        }
    }

    /* renamed from: com.google.crypto.tink.subtle.EngineFactory$Policy */
    public interface InterfaceC0861Policy<JcePrimitiveT> {
        JcePrimitiveT getInstance(String str);

        JcePrimitiveT getInstance(String str, List<Provider> list);
    }

    public EngineFactory(T_WRAPPER t_wrapper) {
        if (TinkFipsUtil.useOnlyFips()) {
            this.f3963policy = new FipsPolicy(t_wrapper);
        } else if (SubtleUtil.isAndroid()) {
            this.f3963policy = new AndroidPolicy(t_wrapper);
        } else {
            this.f3963policy = new DefaultPolicy(t_wrapper);
        }
    }

    public static List<Provider> toProviderList(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            }
        }
        return arrayList;
    }

    public JcePrimitiveT getInstance(String str) {
        return this.f3963policy.getInstance(str);
    }

    public JcePrimitiveT getInstance(String str, List<Provider> list) {
        return this.f3963policy.getInstance(str, list);
    }
}
