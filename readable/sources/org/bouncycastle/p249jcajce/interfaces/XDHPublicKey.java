package org.bouncycastle.p249jcajce.interfaces;

import java.math.BigInteger;
import java.security.PublicKey;

/* loaded from: classes2.dex */
public interface XDHPublicKey extends InterfaceC5485XDHKey, PublicKey {
    /* renamed from: getU */
    BigInteger mo16083getU();

    byte[] getUEncoding();
}
