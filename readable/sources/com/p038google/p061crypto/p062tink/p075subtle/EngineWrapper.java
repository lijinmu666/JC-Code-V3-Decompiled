package com.p038google.p061crypto.p062tink.p075subtle;

import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* loaded from: classes.dex */
public interface EngineWrapper<T> {

    /* renamed from: com.google.crypto.tink.subtle.EngineWrapper$TCipher */
    public static class C0862TCipher implements EngineWrapper<Cipher> {
        @Override // com.p038google.p061crypto.p062tink.p075subtle.EngineWrapper
        public Cipher getInstance(String str, Provider provider) {
            return provider == null ? Cipher.getInstance(str) : Cipher.getInstance(str, provider);
        }
    }

    public static class TKeyAgreement implements EngineWrapper<KeyAgreement> {
        @Override // com.p038google.p061crypto.p062tink.p075subtle.EngineWrapper
        public KeyAgreement getInstance(String str, Provider provider) {
            return provider == null ? KeyAgreement.getInstance(str) : KeyAgreement.getInstance(str, provider);
        }
    }

    public static class TKeyFactory implements EngineWrapper<KeyFactory> {
        @Override // com.p038google.p061crypto.p062tink.p075subtle.EngineWrapper
        public KeyFactory getInstance(String str, Provider provider) {
            return provider == null ? KeyFactory.getInstance(str) : KeyFactory.getInstance(str, provider);
        }
    }

    public static class TKeyPairGenerator implements EngineWrapper<KeyPairGenerator> {
        @Override // com.p038google.p061crypto.p062tink.p075subtle.EngineWrapper
        public KeyPairGenerator getInstance(String str, Provider provider) {
            return provider == null ? KeyPairGenerator.getInstance(str) : KeyPairGenerator.getInstance(str, provider);
        }
    }

    /* renamed from: com.google.crypto.tink.subtle.EngineWrapper$TMac */
    public static class C0863TMac implements EngineWrapper<Mac> {
        @Override // com.p038google.p061crypto.p062tink.p075subtle.EngineWrapper
        public Mac getInstance(String str, Provider provider) {
            return provider == null ? Mac.getInstance(str) : Mac.getInstance(str, provider);
        }
    }

    public static class TMessageDigest implements EngineWrapper<MessageDigest> {
        @Override // com.p038google.p061crypto.p062tink.p075subtle.EngineWrapper
        public MessageDigest getInstance(String str, Provider provider) {
            return provider == null ? MessageDigest.getInstance(str) : MessageDigest.getInstance(str, provider);
        }
    }

    public static class TSignature implements EngineWrapper<Signature> {
        @Override // com.p038google.p061crypto.p062tink.p075subtle.EngineWrapper
        public Signature getInstance(String str, Provider provider) {
            return provider == null ? Signature.getInstance(str) : Signature.getInstance(str, provider);
        }
    }

    T getInstance(String str, Provider provider);
}
