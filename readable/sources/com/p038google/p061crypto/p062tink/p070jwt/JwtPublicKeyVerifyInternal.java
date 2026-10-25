package com.p038google.p061crypto.p062tink.p070jwt;

import java.util.Optional;

/* loaded from: classes.dex */
public interface JwtPublicKeyVerifyInternal {
    VerifiedJwt verifyAndDecodeWithKid(String str, JwtValidator jwtValidator, Optional<String> optional);
}
