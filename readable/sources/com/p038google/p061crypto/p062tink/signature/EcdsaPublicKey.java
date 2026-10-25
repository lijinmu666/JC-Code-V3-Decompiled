package com.p038google.p061crypto.p062tink.signature;

import com.p038google.p061crypto.p062tink.AbstractC0308Key;
import com.p038google.p061crypto.p062tink.annotations.InterfaceC0389Alpha;
import com.p038google.p061crypto.p062tink.internal.EllipticCurvesUtil;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;
import com.p038google.p061crypto.p062tink.signature.EcdsaParameters;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import java.util.Objects;
import javax.annotation.Nullable;

@InterfaceC0389Alpha
/* loaded from: classes.dex */
public final class EcdsaPublicKey extends SignaturePublicKey {

    @Nullable
    private final Integer idRequirement;
    private final C0878Bytes outputPrefix;
    private final EcdsaParameters parameters;
    private final ECPoint publicPoint;

    /* renamed from: com.google.crypto.tink.signature.EcdsaPublicKey$Builder */
    public static class C0820Builder {

        @Nullable
        private Integer idRequirement;

        @Nullable
        private EcdsaParameters parameters;

        @Nullable
        private ECPoint publicPoint;

        private C0878Bytes getOutputPrefix() {
            if (this.parameters.getVariant() == EcdsaParameters.C0815Variant.NO_PREFIX) {
                return C0878Bytes.copyFrom(new byte[0]);
            }
            if (this.parameters.getVariant() == EcdsaParameters.C0815Variant.f3858LEGACY || this.parameters.getVariant() == EcdsaParameters.C0815Variant.f3857CRUNCHY) {
                return C0878Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 0).putInt(this.idRequirement.intValue()).array());
            }
            if (this.parameters.getVariant() == EcdsaParameters.C0815Variant.f3859TINK) {
                return C0878Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 1).putInt(this.idRequirement.intValue()).array());
            }
            throw new IllegalStateException("Unknown EcdsaParameters.Variant: " + this.parameters.getVariant());
        }

        /* renamed from: build */
        public EcdsaPublicKey m4206build() throws GeneralSecurityException {
            EcdsaParameters ecdsaParameters = this.parameters;
            if (ecdsaParameters == null) {
                throw new GeneralSecurityException("Cannot build without parameters");
            }
            ECPoint eCPoint = this.publicPoint;
            if (eCPoint == null) {
                throw new GeneralSecurityException("Cannot build without public point");
            }
            EllipticCurvesUtil.checkPointOnCurve(eCPoint, ecdsaParameters.getCurveType().toParameterSpec().getCurve());
            if (this.parameters.hasIdRequirement() && this.idRequirement == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            }
            if (!this.parameters.hasIdRequirement() && this.idRequirement != null) {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            return new EcdsaPublicKey(this.parameters, this.publicPoint, getOutputPrefix(), this.idRequirement);
        }

        public C0820Builder setIdRequirement(@Nullable Integer num) {
            this.idRequirement = num;
            return this;
        }

        public C0820Builder setParameters(EcdsaParameters ecdsaParameters) {
            this.parameters = ecdsaParameters;
            return this;
        }

        public C0820Builder setPublicPoint(ECPoint eCPoint) {
            this.publicPoint = eCPoint;
            return this;
        }

        private C0820Builder() {
            this.parameters = null;
            this.publicPoint = null;
            this.idRequirement = null;
        }
    }

    /* renamed from: builder */
    public static C0820Builder m4205builder() {
        return new C0820Builder();
    }

    @Override // com.p038google.p061crypto.p062tink.AbstractC0308Key
    public boolean equalsKey(AbstractC0308Key abstractC0308Key) {
        if (!(abstractC0308Key instanceof EcdsaPublicKey)) {
            return false;
        }
        EcdsaPublicKey ecdsaPublicKey = (EcdsaPublicKey) abstractC0308Key;
        return ecdsaPublicKey.parameters.m4195equals(this.parameters) && ecdsaPublicKey.publicPoint.equals(this.publicPoint) && Objects.equals(ecdsaPublicKey.idRequirement, this.idRequirement);
    }

    @Override // com.p038google.p061crypto.p062tink.AbstractC0308Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    @Override // com.p038google.p061crypto.p062tink.signature.SignaturePublicKey
    public C0878Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    public ECPoint getPublicPoint() {
        return this.publicPoint;
    }

    private EcdsaPublicKey(EcdsaParameters ecdsaParameters, ECPoint eCPoint, C0878Bytes c0878Bytes, @Nullable Integer num) {
        this.parameters = ecdsaParameters;
        this.publicPoint = eCPoint;
        this.outputPrefix = c0878Bytes;
        this.idRequirement = num;
    }

    @Override // com.p038google.p061crypto.p062tink.signature.SignaturePublicKey, com.p038google.p061crypto.p062tink.AbstractC0308Key
    public EcdsaParameters getParameters() {
        return this.parameters;
    }
}
