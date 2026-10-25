package com.p038google.p061crypto.p062tink;

/* loaded from: classes.dex */
public interface KmsClient {
    boolean doesSupport(String str);

    /* renamed from: getAead */
    InterfaceC0305Aead mo3373getAead(String str);

    KmsClient withCredentials(String str);

    KmsClient withDefaultCredentials();
}
