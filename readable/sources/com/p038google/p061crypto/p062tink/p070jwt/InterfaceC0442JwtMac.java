package com.p038google.p061crypto.p062tink.p070jwt;

/* renamed from: com.google.crypto.tink.jwt.JwtMac */
/* loaded from: classes.dex */
public interface InterfaceC0442JwtMac {
    String computeMacAndEncode(C0454RawJwt c0454RawJwt);

    VerifiedJwt verifyMacAndDecode(String str, JwtValidator jwtValidator);
}
