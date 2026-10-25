package com.p038google.p061crypto.p062tink.p070jwt;

import com.p038google.p061crypto.p062tink.PrimitiveSet;
import com.p038google.p061crypto.p062tink.PrimitiveWrapper;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class JwtPublicKeySignWrapper implements PrimitiveWrapper<JwtPublicKeySignInternal, JwtPublicKeySign> {

    /* renamed from: WRAPPER */
    private static final JwtPublicKeySignWrapper f3130WRAPPER = new JwtPublicKeySignWrapper();

    public static class WrappedJwtPublicKeySign implements JwtPublicKeySign {
        private final PrimitiveSet<JwtPublicKeySignInternal> primitives;

        public WrappedJwtPublicKeySign(PrimitiveSet<JwtPublicKeySignInternal> primitiveSet) {
            this.primitives = primitiveSet;
        }

        @Override // com.p038google.p061crypto.p062tink.p070jwt.JwtPublicKeySign
        public String signAndEncode(C0454RawJwt c0454RawJwt) throws JwtInvalidException {
            PrimitiveSet.C0320Entry<JwtPublicKeySignInternal> primary = this.primitives.getPrimary();
            return this.primitives.getPrimary().getPrimitive().signAndEncodeWithKid(c0454RawJwt, JwtFormat.m3506getKid(primary.getKeyId(), primary.getOutputPrefixType()));
        }
    }

    public static void register() {
        Registry.registerPrimitiveWrapper(f3130WRAPPER);
    }

    private static void validate(PrimitiveSet<JwtPublicKeySignInternal> primitiveSet) throws GeneralSecurityException {
        if (primitiveSet.getPrimary() == null) {
            throw new GeneralSecurityException("Primitive set has no primary.");
        }
        Iterator<List<PrimitiveSet.C0320Entry<JwtPublicKeySignInternal>>> it = primitiveSet.m3381getAll().iterator();
        while (it.hasNext()) {
            for (PrimitiveSet.C0320Entry<JwtPublicKeySignInternal> c0320Entry : it.next()) {
                if (c0320Entry.getOutputPrefixType() != OutputPrefixType.RAW && c0320Entry.getOutputPrefixType() != OutputPrefixType.TINK) {
                    throw new GeneralSecurityException("unsupported OutputPrefixType");
                }
            }
        }
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<JwtPublicKeySignInternal> getInputPrimitiveClass() {
        return JwtPublicKeySignInternal.class;
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<JwtPublicKeySign> getPrimitiveClass() {
        return JwtPublicKeySign.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    /* renamed from: wrap */
    public JwtPublicKeySign mo3385wrap(PrimitiveSet<JwtPublicKeySignInternal> primitiveSet) throws GeneralSecurityException {
        validate(primitiveSet);
        return new WrappedJwtPublicKeySign(primitiveSet);
    }
}
