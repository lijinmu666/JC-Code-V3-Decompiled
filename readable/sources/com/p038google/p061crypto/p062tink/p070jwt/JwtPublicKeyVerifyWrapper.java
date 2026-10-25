package com.p038google.p061crypto.p062tink.p070jwt;

import com.p038google.p061crypto.p062tink.PrimitiveSet;
import com.p038google.p061crypto.p062tink.PrimitiveWrapper;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class JwtPublicKeyVerifyWrapper implements PrimitiveWrapper<JwtPublicKeyVerifyInternal, JwtPublicKeyVerify> {

    /* renamed from: WRAPPER */
    private static final JwtPublicKeyVerifyWrapper f3131WRAPPER = new JwtPublicKeyVerifyWrapper();

    public static class WrappedJwtPublicKeyVerify implements JwtPublicKeyVerify {
        private final PrimitiveSet<JwtPublicKeyVerifyInternal> primitives;

        public WrappedJwtPublicKeyVerify(PrimitiveSet<JwtPublicKeyVerifyInternal> primitiveSet) {
            this.primitives = primitiveSet;
        }

        @Override // com.p038google.p061crypto.p062tink.p070jwt.JwtPublicKeyVerify
        public VerifiedJwt verifyAndDecode(String str, JwtValidator jwtValidator) throws GeneralSecurityException {
            Iterator<List<PrimitiveSet.C0320Entry<JwtPublicKeyVerifyInternal>>> it = this.primitives.m3381getAll().iterator();
            GeneralSecurityException generalSecurityException = null;
            while (it.hasNext()) {
                for (PrimitiveSet.C0320Entry<JwtPublicKeyVerifyInternal> c0320Entry : it.next()) {
                    try {
                        return c0320Entry.getPrimitive().verifyAndDecodeWithKid(str, jwtValidator, JwtFormat.m3506getKid(c0320Entry.getKeyId(), c0320Entry.getOutputPrefixType()));
                    } catch (GeneralSecurityException e) {
                        if (e instanceof JwtInvalidException) {
                            generalSecurityException = e;
                        }
                    }
                }
            }
            if (generalSecurityException != null) {
                throw generalSecurityException;
            }
            throw new GeneralSecurityException("invalid JWT");
        }
    }

    public static void register() {
        Registry.registerPrimitiveWrapper(f3131WRAPPER);
    }

    private static void validate(PrimitiveSet<JwtPublicKeyVerifyInternal> primitiveSet) throws GeneralSecurityException {
        Iterator<List<PrimitiveSet.C0320Entry<JwtPublicKeyVerifyInternal>>> it = primitiveSet.m3381getAll().iterator();
        while (it.hasNext()) {
            for (PrimitiveSet.C0320Entry<JwtPublicKeyVerifyInternal> c0320Entry : it.next()) {
                if (c0320Entry.getOutputPrefixType() != OutputPrefixType.RAW && c0320Entry.getOutputPrefixType() != OutputPrefixType.TINK) {
                    throw new GeneralSecurityException("unsupported OutputPrefixType");
                }
            }
        }
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<JwtPublicKeyVerifyInternal> getInputPrimitiveClass() {
        return JwtPublicKeyVerifyInternal.class;
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<JwtPublicKeyVerify> getPrimitiveClass() {
        return JwtPublicKeyVerify.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    /* renamed from: wrap */
    public JwtPublicKeyVerify mo3385wrap(PrimitiveSet<JwtPublicKeyVerifyInternal> primitiveSet) throws GeneralSecurityException {
        validate(primitiveSet);
        return new WrappedJwtPublicKeyVerify(primitiveSet);
    }
}
