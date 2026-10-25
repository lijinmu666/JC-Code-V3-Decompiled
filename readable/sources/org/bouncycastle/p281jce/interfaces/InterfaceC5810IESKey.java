package org.bouncycastle.p281jce.interfaces;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;

/* renamed from: org.bouncycastle.jce.interfaces.IESKey */
/* loaded from: classes2.dex */
public interface InterfaceC5810IESKey extends Key {
    PrivateKey getPrivate();

    PublicKey getPublic();
}
