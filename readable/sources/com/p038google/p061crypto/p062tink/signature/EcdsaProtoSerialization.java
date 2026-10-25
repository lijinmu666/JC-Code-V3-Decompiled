package com.p038google.p061crypto.p062tink.signature;

import com.p038google.p061crypto.p062tink.AbstractC0308Key;
import com.p038google.p061crypto.p062tink.AccessesPartialKey;
import com.p038google.p061crypto.p062tink.Parameters;
import com.p038google.p061crypto.p062tink.SecretKeyAccess;
import com.p038google.p061crypto.p062tink.internal.BigIntegerEncoding;
import com.p038google.p061crypto.p062tink.internal.C0431Util;
import com.p038google.p061crypto.p062tink.internal.KeyParser;
import com.p038google.p061crypto.p062tink.internal.KeySerializer;
import com.p038google.p061crypto.p062tink.internal.MutableSerializationRegistry;
import com.p038google.p061crypto.p062tink.internal.ParametersParser;
import com.p038google.p061crypto.p062tink.internal.ParametersSerializer;
import com.p038google.p061crypto.p062tink.internal.ProtoKeySerialization;
import com.p038google.p061crypto.p062tink.internal.ProtoParametersSerialization;
import com.p038google.p061crypto.p062tink.internal.Serialization;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.EcdsaKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.EcdsaParams;
import com.p038google.p061crypto.p062tink.p073proto.EcdsaPrivateKey;
import com.p038google.p061crypto.p062tink.p073proto.EcdsaPublicKey;
import com.p038google.p061crypto.p062tink.p073proto.EcdsaSignatureEncoding;
import com.p038google.p061crypto.p062tink.p073proto.EllipticCurveType;
import com.p038google.p061crypto.p062tink.p073proto.HashType;
import com.p038google.p061crypto.p062tink.p073proto.KeyTemplate;
import com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.InvalidProtocolBufferException;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;
import com.p038google.p061crypto.p062tink.p078util.SecretBigInteger;
import com.p038google.p061crypto.p062tink.signature.EcdsaParameters;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import javax.annotation.Nullable;

@AccessesPartialKey
/* loaded from: classes.dex */
final class EcdsaProtoSerialization {
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER;
    private static final ParametersSerializer<EcdsaParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER;
    private static final KeyParser<ProtoKeySerialization> PRIVATE_KEY_PARSER;
    private static final KeySerializer<EcdsaPrivateKey, ProtoKeySerialization> PRIVATE_KEY_SERIALIZER;
    private static final String PRIVATE_TYPE_URL = "type.googleapis.com/google.crypto.tink.EcdsaPrivateKey";
    private static final C0878Bytes PRIVATE_TYPE_URL_BYTES;
    private static final KeyParser<ProtoKeySerialization> PUBLIC_KEY_PARSER;
    private static final KeySerializer<EcdsaPublicKey, ProtoKeySerialization> PUBLIC_KEY_SERIALIZER;
    private static final String PUBLIC_TYPE_URL = "type.googleapis.com/google.crypto.tink.EcdsaPublicKey";
    private static final C0878Bytes PUBLIC_TYPE_URL_BYTES;

    /* renamed from: com.google.crypto.tink.signature.EcdsaProtoSerialization$1 */
    public static /* synthetic */ class C08181 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$EcdsaSignatureEncoding;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$EllipticCurveType;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HashType;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType;

        static {
            int[] iArr = new int[EcdsaSignatureEncoding.m3604values().length];
            $SwitchMap$com$google$crypto$tink$proto$EcdsaSignatureEncoding = iArr;
            try {
                iArr[EcdsaSignatureEncoding.IEEE_P1363.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$EcdsaSignatureEncoding[EcdsaSignatureEncoding.DER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[EllipticCurveType.m3626values().length];
            $SwitchMap$com$google$crypto$tink$proto$EllipticCurveType = iArr2;
            try {
                iArr2[EllipticCurveType.NIST_P256.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$EllipticCurveType[EllipticCurveType.NIST_P384.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$EllipticCurveType[EllipticCurveType.NIST_P521.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[OutputPrefixType.m3816values().length];
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = iArr3;
            try {
                iArr3[OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.CRUNCHY.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.LEGACY.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.RAW.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr4 = new int[HashType.m3630values().length];
            $SwitchMap$com$google$crypto$tink$proto$HashType = iArr4;
            try {
                iArr4[HashType.SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA384.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA512.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    static {
        C0878Bytes bytesFromPrintableAscii = C0431Util.toBytesFromPrintableAscii(PRIVATE_TYPE_URL);
        PRIVATE_TYPE_URL_BYTES = bytesFromPrintableAscii;
        C0878Bytes bytesFromPrintableAscii2 = C0431Util.toBytesFromPrintableAscii(PUBLIC_TYPE_URL);
        PUBLIC_TYPE_URL_BYTES = bytesFromPrintableAscii2;
        PARAMETERS_SERIALIZER = ParametersSerializer.m3494create(new ParametersSerializer.ParametersSerializationFunction() { // from class: com.google.crypto.tink.signature.mjFkc
            @Override // com.google.crypto.tink.internal.ParametersSerializer.ParametersSerializationFunction
            public final Serialization serializeParameters(Parameters parameters) {
                return EcdsaProtoSerialization.serializeParameters((EcdsaParameters) parameters);
            }
        }, EcdsaParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.m3493create(new ParametersParser.ParametersParsingFunction() { // from class: com.google.crypto.tink.signature.AZxh
            @Override // com.google.crypto.tink.internal.ParametersParser.ParametersParsingFunction
            public final Parameters parseParameters(Serialization serialization) {
                return EcdsaProtoSerialization.parseParameters((ProtoParametersSerialization) serialization);
            }
        }, bytesFromPrintableAscii, ProtoParametersSerialization.class);
        PUBLIC_KEY_SERIALIZER = KeySerializer.m3486create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.signature.wA
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(AbstractC0308Key abstractC0308Key, SecretKeyAccess secretKeyAccess) {
                return EcdsaProtoSerialization.serializePublicKey((EcdsaPublicKey) abstractC0308Key, secretKeyAccess);
            }
        }, EcdsaPublicKey.class, ProtoKeySerialization.class);
        PUBLIC_KEY_PARSER = KeyParser.m3485create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.signature.ZfxDd
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final AbstractC0308Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                return EcdsaProtoSerialization.parsePublicKey((ProtoKeySerialization) serialization, secretKeyAccess);
            }
        }, bytesFromPrintableAscii2, ProtoKeySerialization.class);
        PRIVATE_KEY_SERIALIZER = KeySerializer.m3486create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.signature.KLFTb
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(AbstractC0308Key abstractC0308Key, SecretKeyAccess secretKeyAccess) {
                return EcdsaProtoSerialization.serializePrivateKey((EcdsaPrivateKey) abstractC0308Key, secretKeyAccess);
            }
        }, EcdsaPrivateKey.class, ProtoKeySerialization.class);
        PRIVATE_KEY_PARSER = KeyParser.m3485create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.signature.JHa
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final AbstractC0308Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                return EcdsaProtoSerialization.parsePrivateKey((ProtoKeySerialization) serialization, secretKeyAccess);
            }
        }, bytesFromPrintableAscii, ProtoKeySerialization.class);
    }

    private EcdsaProtoSerialization() {
    }

    private static int getEncodingLength(EcdsaParameters.CurveType curveType) throws GeneralSecurityException {
        if (EcdsaParameters.CurveType.NIST_P256.equals(curveType)) {
            return 33;
        }
        if (EcdsaParameters.CurveType.NIST_P384.equals(curveType)) {
            return 49;
        }
        if (EcdsaParameters.CurveType.NIST_P521.equals(curveType)) {
            return 67;
        }
        throw new GeneralSecurityException("Unable to serialize CurveType " + curveType);
    }

    private static EcdsaParams getProtoParams(EcdsaParameters ecdsaParameters) {
        return EcdsaParams.newBuilder().setHashType(toProtoHashType(ecdsaParameters.getHashType())).setCurve(toProtoCurveType(ecdsaParameters.getCurveType())).setEncoding(toProtoSignatureEncoding(ecdsaParameters.getSignatureEncoding())).mo3555build();
    }

    private static EcdsaPublicKey getProtoPublicKey(EcdsaPublicKey ecdsaPublicKey) throws GeneralSecurityException {
        int encodingLength = getEncodingLength(ecdsaPublicKey.getParameters().getCurveType());
        ECPoint publicPoint = ecdsaPublicKey.getPublicPoint();
        return EcdsaPublicKey.newBuilder().setParams(getProtoParams(ecdsaPublicKey.getParameters())).m3600setX(ByteString.copyFrom(BigIntegerEncoding.toBigEndianBytesOfFixedLength(publicPoint.getAffineX(), encodingLength))).m3601setY(ByteString.copyFrom(BigIntegerEncoding.toBigEndianBytesOfFixedLength(publicPoint.getAffineY(), encodingLength))).mo3555build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static EcdsaParameters parseParameters(ProtoParametersSerialization protoParametersSerialization) throws GeneralSecurityException {
        if (protoParametersSerialization.getKeyTemplate().getTypeUrl().equals(PRIVATE_TYPE_URL)) {
            try {
                EcdsaKeyFormat from = EcdsaKeyFormat.parseFrom(protoParametersSerialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());
                return EcdsaParameters.m4194builder().setHashType(toHashType(from.getParams().getHashType())).setSignatureEncoding(toSignatureEncoding(from.getParams().getEncoding())).setCurveType(toCurveType(from.getParams().getCurve())).setVariant(toVariant(protoParametersSerialization.getKeyTemplate().getOutputPrefixType())).m4196build();
            } catch (InvalidProtocolBufferException e) {
                throw new GeneralSecurityException("Parsing EcdsaParameters failed: ", e);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to EcdsaProtoSerialization.parseParameters: " + protoParametersSerialization.getKeyTemplate().getTypeUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static EcdsaPrivateKey parsePrivateKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (!protoKeySerialization.getTypeUrl().equals(PRIVATE_TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to EcdsaProtoSerialization.parsePrivateKey: " + protoKeySerialization.getTypeUrl());
        }
        try {
            EcdsaPrivateKey from = EcdsaPrivateKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (from.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            EcdsaPublicKey publicKey = from.getPublicKey();
            return EcdsaPrivateKey.m4197builder().setPublicKey(EcdsaPublicKey.m4205builder().setParameters(EcdsaParameters.m4194builder().setHashType(toHashType(publicKey.getParams().getHashType())).setSignatureEncoding(toSignatureEncoding(publicKey.getParams().getEncoding())).setCurveType(toCurveType(publicKey.getParams().getCurve())).setVariant(toVariant(protoKeySerialization.getOutputPrefixType())).m4196build()).setPublicPoint(new ECPoint(BigIntegerEncoding.fromUnsignedBigEndianBytes(publicKey.mo3596getX().toByteArray()), BigIntegerEncoding.fromUnsignedBigEndianBytes(publicKey.mo3597getY().toByteArray()))).setIdRequirement(protoKeySerialization.getIdRequirementOrNull()).m4206build()).setPrivateValue(SecretBigInteger.fromBigInteger(BigIntegerEncoding.fromUnsignedBigEndianBytes(from.getKeyValue().toByteArray()), SecretKeyAccess.requireAccess(secretKeyAccess))).m4198build();
        } catch (InvalidProtocolBufferException | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing EcdsaPrivateKey failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static EcdsaPublicKey parsePublicKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (!protoKeySerialization.getTypeUrl().equals(PUBLIC_TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to EcdsaProtoSerialization.parsePublicKey: " + protoKeySerialization.getTypeUrl());
        }
        try {
            EcdsaPublicKey from = EcdsaPublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (from.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return EcdsaPublicKey.m4205builder().setParameters(EcdsaParameters.m4194builder().setHashType(toHashType(from.getParams().getHashType())).setSignatureEncoding(toSignatureEncoding(from.getParams().getEncoding())).setCurveType(toCurveType(from.getParams().getCurve())).setVariant(toVariant(protoKeySerialization.getOutputPrefixType())).m4196build()).setPublicPoint(new ECPoint(BigIntegerEncoding.fromUnsignedBigEndianBytes(from.mo3596getX().toByteArray()), BigIntegerEncoding.fromUnsignedBigEndianBytes(from.mo3597getY().toByteArray()))).setIdRequirement(protoKeySerialization.getIdRequirementOrNull()).m4206build();
        } catch (InvalidProtocolBufferException | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing EcdsaPublicKey failed");
        }
    }

    public static void register() {
        register(MutableSerializationRegistry.globalInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoParametersSerialization serializeParameters(EcdsaParameters ecdsaParameters) {
        return ProtoParametersSerialization.m3500create(KeyTemplate.newBuilder().setTypeUrl(PRIVATE_TYPE_URL).setValue(EcdsaKeyFormat.newBuilder().setParams(getProtoParams(ecdsaParameters)).mo3555build().toByteString()).setOutputPrefixType(toProtoOutputPrefixType(ecdsaParameters.getVariant())).mo3555build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializePrivateKey(EcdsaPrivateKey ecdsaPrivateKey, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        return ProtoKeySerialization.m3499create(PRIVATE_TYPE_URL, EcdsaPrivateKey.newBuilder().setPublicKey(getProtoPublicKey(ecdsaPrivateKey.getPublicKey())).setKeyValue(ByteString.copyFrom(BigIntegerEncoding.toBigEndianBytesOfFixedLength(ecdsaPrivateKey.getPrivateValue().getBigInteger(SecretKeyAccess.requireAccess(secretKeyAccess)), getEncodingLength(ecdsaPrivateKey.getParameters().getCurveType())))).mo3555build().toByteString(), C0669KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE, toProtoOutputPrefixType(ecdsaPrivateKey.getParameters().getVariant()), ecdsaPrivateKey.getIdRequirementOrNull());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializePublicKey(EcdsaPublicKey ecdsaPublicKey, @Nullable SecretKeyAccess secretKeyAccess) {
        return ProtoKeySerialization.m3499create(PUBLIC_TYPE_URL, getProtoPublicKey(ecdsaPublicKey).toByteString(), C0669KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, toProtoOutputPrefixType(ecdsaPublicKey.getParameters().getVariant()), ecdsaPublicKey.getIdRequirementOrNull());
    }

    private static EcdsaParameters.CurveType toCurveType(EllipticCurveType ellipticCurveType) throws GeneralSecurityException {
        int i = C08181.$SwitchMap$com$google$crypto$tink$proto$EllipticCurveType[ellipticCurveType.ordinal()];
        if (i == 1) {
            return EcdsaParameters.CurveType.NIST_P256;
        }
        if (i == 2) {
            return EcdsaParameters.CurveType.NIST_P384;
        }
        if (i == 3) {
            return EcdsaParameters.CurveType.NIST_P521;
        }
        throw new GeneralSecurityException("Unable to parse EllipticCurveType: " + ellipticCurveType.getNumber());
    }

    private static EcdsaParameters.HashType toHashType(HashType hashType) throws GeneralSecurityException {
        int i = C08181.$SwitchMap$com$google$crypto$tink$proto$HashType[hashType.ordinal()];
        if (i == 1) {
            return EcdsaParameters.HashType.f3851SHA256;
        }
        if (i == 2) {
            return EcdsaParameters.HashType.f3852SHA384;
        }
        if (i == 3) {
            return EcdsaParameters.HashType.f3853SHA512;
        }
        throw new GeneralSecurityException("Unable to parse HashType: " + hashType.getNumber());
    }

    private static EllipticCurveType toProtoCurveType(EcdsaParameters.CurveType curveType) throws GeneralSecurityException {
        if (EcdsaParameters.CurveType.NIST_P256.equals(curveType)) {
            return EllipticCurveType.NIST_P256;
        }
        if (EcdsaParameters.CurveType.NIST_P384.equals(curveType)) {
            return EllipticCurveType.NIST_P384;
        }
        if (EcdsaParameters.CurveType.NIST_P521.equals(curveType)) {
            return EllipticCurveType.NIST_P521;
        }
        throw new GeneralSecurityException("Unable to serialize CurveType " + curveType);
    }

    private static HashType toProtoHashType(EcdsaParameters.HashType hashType) throws GeneralSecurityException {
        if (EcdsaParameters.HashType.f3851SHA256.equals(hashType)) {
            return HashType.SHA256;
        }
        if (EcdsaParameters.HashType.f3852SHA384.equals(hashType)) {
            return HashType.SHA384;
        }
        if (EcdsaParameters.HashType.f3853SHA512.equals(hashType)) {
            return HashType.SHA512;
        }
        throw new GeneralSecurityException("Unable to serialize HashType " + hashType);
    }

    private static OutputPrefixType toProtoOutputPrefixType(EcdsaParameters.C0815Variant c0815Variant) throws GeneralSecurityException {
        if (EcdsaParameters.C0815Variant.f3859TINK.equals(c0815Variant)) {
            return OutputPrefixType.TINK;
        }
        if (EcdsaParameters.C0815Variant.f3857CRUNCHY.equals(c0815Variant)) {
            return OutputPrefixType.CRUNCHY;
        }
        if (EcdsaParameters.C0815Variant.NO_PREFIX.equals(c0815Variant)) {
            return OutputPrefixType.RAW;
        }
        if (EcdsaParameters.C0815Variant.f3858LEGACY.equals(c0815Variant)) {
            return OutputPrefixType.LEGACY;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + c0815Variant);
    }

    private static EcdsaSignatureEncoding toProtoSignatureEncoding(EcdsaParameters.SignatureEncoding signatureEncoding) throws GeneralSecurityException {
        if (EcdsaParameters.SignatureEncoding.IEEE_P1363.equals(signatureEncoding)) {
            return EcdsaSignatureEncoding.IEEE_P1363;
        }
        if (EcdsaParameters.SignatureEncoding.f3855DER.equals(signatureEncoding)) {
            return EcdsaSignatureEncoding.DER;
        }
        throw new GeneralSecurityException("Unable to serialize SignatureEncoding " + signatureEncoding);
    }

    private static EcdsaParameters.SignatureEncoding toSignatureEncoding(EcdsaSignatureEncoding ecdsaSignatureEncoding) throws GeneralSecurityException {
        int i = C08181.$SwitchMap$com$google$crypto$tink$proto$EcdsaSignatureEncoding[ecdsaSignatureEncoding.ordinal()];
        if (i == 1) {
            return EcdsaParameters.SignatureEncoding.IEEE_P1363;
        }
        if (i == 2) {
            return EcdsaParameters.SignatureEncoding.f3855DER;
        }
        throw new GeneralSecurityException("Unable to parse EcdsaSignatureEncoding: " + ecdsaSignatureEncoding.getNumber());
    }

    private static EcdsaParameters.C0815Variant toVariant(OutputPrefixType outputPrefixType) throws GeneralSecurityException {
        int i = C08181.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (i == 1) {
            return EcdsaParameters.C0815Variant.f3859TINK;
        }
        if (i == 2) {
            return EcdsaParameters.C0815Variant.f3857CRUNCHY;
        }
        if (i == 3) {
            return EcdsaParameters.C0815Variant.f3858LEGACY;
        }
        if (i == 4) {
            return EcdsaParameters.C0815Variant.NO_PREFIX;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + outputPrefixType.getNumber());
    }

    public static void register(MutableSerializationRegistry mutableSerializationRegistry) {
        mutableSerializationRegistry.registerParametersSerializer(PARAMETERS_SERIALIZER);
        mutableSerializationRegistry.registerParametersParser(PARAMETERS_PARSER);
        mutableSerializationRegistry.registerKeySerializer(PUBLIC_KEY_SERIALIZER);
        mutableSerializationRegistry.registerKeyParser(PUBLIC_KEY_PARSER);
        mutableSerializationRegistry.registerKeySerializer(PRIVATE_KEY_SERIALIZER);
        mutableSerializationRegistry.registerKeyParser(PRIVATE_KEY_PARSER);
    }
}
