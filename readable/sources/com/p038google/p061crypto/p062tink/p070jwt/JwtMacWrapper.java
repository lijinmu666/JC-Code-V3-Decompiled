package com.p038google.p061crypto.p062tink.p070jwt;

import com.p038google.p061crypto.p062tink.PrimitiveSet;
import com.p038google.p061crypto.p062tink.PrimitiveWrapper;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class JwtMacWrapper implements PrimitiveWrapper<JwtMacInternal, InterfaceC0442JwtMac> {

    /* renamed from: WRAPPER */
    private static final JwtMacWrapper f3129WRAPPER = new JwtMacWrapper();

    public static class WrappedJwtMac implements InterfaceC0442JwtMac {
        private final PrimitiveSet<JwtMacInternal> primitives;

        @Override // com.p038google.p061crypto.p062tink.p070jwt.InterfaceC0442JwtMac
        public String computeMacAndEncode(C0454RawJwt c0454RawJwt) throws JwtInvalidException {
            PrimitiveSet.C0320Entry<JwtMacInternal> primary = this.primitives.getPrimary();
            return primary.getPrimitive().computeMacAndEncodeWithKid(c0454RawJwt, JwtFormat.m3506getKid(primary.getKeyId(), primary.getOutputPrefixType()));
        }

        @Override // com.p038google.p061crypto.p062tink.p070jwt.InterfaceC0442JwtMac
        public VerifiedJwt verifyMacAndDecode(String str, JwtValidator jwtValidator) throws GeneralSecurityException {
            Iterator<List<PrimitiveSet.C0320Entry<JwtMacInternal>>> it = this.primitives.m3381getAll().iterator();
            GeneralSecurityException generalSecurityException = null;
            while (it.hasNext()) {
                for (PrimitiveSet.C0320Entry<JwtMacInternal> c0320Entry : it.next()) {
                    try {
                        return c0320Entry.getPrimitive().verifyMacAndDecodeWithKid(str, jwtValidator, JwtFormat.m3506getKid(c0320Entry.getKeyId(), c0320Entry.getOutputPrefixType()));
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
            throw new GeneralSecurityException("invalid MAC");
        }

        private WrappedJwtMac(PrimitiveSet<JwtMacInternal> primitiveSet) {
            this.primitives = primitiveSet;
        }
    }

    public static void register() {
        Registry.registerPrimitiveWrapper(f3129WRAPPER);
    }

    private static void validate(PrimitiveSet<JwtMacInternal> primitiveSet) throws GeneralSecurityException {
        if (primitiveSet.getPrimary() == null) {
            throw new GeneralSecurityException("Primitive set has no primary.");
        }
        Iterator<List<PrimitiveSet.C0320Entry<JwtMacInternal>>> it = primitiveSet.m3381getAll().iterator();
        while (it.hasNext()) {
            for (PrimitiveSet.C0320Entry<JwtMacInternal> c0320Entry : it.next()) {
                if (c0320Entry.getOutputPrefixType() != OutputPrefixType.RAW && c0320Entry.getOutputPrefixType() != OutputPrefixType.TINK) {
                    throw new GeneralSecurityException("unsupported OutputPrefixType");
                }
            }
        }
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<JwtMacInternal> getInputPrimitiveClass() {
        return JwtMacInternal.class;
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<InterfaceC0442JwtMac> getPrimitiveClass() {
        return InterfaceC0442JwtMac.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    /* renamed from: wrap */
    public InterfaceC0442JwtMac mo3385wrap(PrimitiveSet<JwtMacInternal> primitiveSet) throws GeneralSecurityException {
        validate(primitiveSet);
        return new WrappedJwtMac(primitiveSet);
    }
}
