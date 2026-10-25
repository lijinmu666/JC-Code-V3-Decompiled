package com.p038google.p061crypto.p062tink.p071mac;

import com.p038google.p061crypto.p062tink.AbstractC0308Key;
import com.p038google.p061crypto.p062tink.AccessesPartialKey;
import com.p038google.p061crypto.p062tink.Parameters;
import com.p038google.p061crypto.p062tink.SecretKeyAccess;
import com.p038google.p061crypto.p062tink.internal.C0431Util;
import com.p038google.p061crypto.p062tink.internal.KeyParser;
import com.p038google.p061crypto.p062tink.internal.KeySerializer;
import com.p038google.p061crypto.p062tink.internal.MutableSerializationRegistry;
import com.p038google.p061crypto.p062tink.internal.ParametersParser;
import com.p038google.p061crypto.p062tink.internal.ParametersSerializer;
import com.p038google.p061crypto.p062tink.internal.ProtoKeySerialization;
import com.p038google.p061crypto.p062tink.internal.ProtoParametersSerialization;
import com.p038google.p061crypto.p062tink.internal.Serialization;
import com.p038google.p061crypto.p062tink.p071mac.AesCmacParameters;
import com.p038google.p061crypto.p062tink.p073proto.AesCmacKey;
import com.p038google.p061crypto.p062tink.p073proto.AesCmacKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.AesCmacParams;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.KeyTemplate;
import com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.InvalidProtocolBufferException;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;
import com.p038google.p061crypto.p062tink.p078util.SecretBytes;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

@AccessesPartialKey
/* loaded from: classes.dex */
final class AesCmacProtoSerialization {
    private static final KeyParser<ProtoKeySerialization> KEY_PARSER;
    private static final KeySerializer<AesCmacKey, ProtoKeySerialization> KEY_SERIALIZER;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER;
    private static final ParametersSerializer<AesCmacParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.AesCmacKey";
    private static final C0878Bytes TYPE_URL_BYTES;

    /* renamed from: com.google.crypto.tink.mac.AesCmacProtoSerialization$1 */
    public static /* synthetic */ class C04631 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType;

        static {
            int[] iArr = new int[OutputPrefixType.m3816values().length];
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = iArr;
            try {
                iArr[OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.CRUNCHY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.LEGACY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.RAW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        C0878Bytes bytesFromPrintableAscii = C0431Util.toBytesFromPrintableAscii(TYPE_URL);
        TYPE_URL_BYTES = bytesFromPrintableAscii;
        PARAMETERS_SERIALIZER = ParametersSerializer.m3494create(new ParametersSerializer.ParametersSerializationFunction() { // from class: com.google.crypto.tink.mac.mjFkc
            @Override // com.google.crypto.tink.internal.ParametersSerializer.ParametersSerializationFunction
            public final Serialization serializeParameters(Parameters parameters) {
                return AesCmacProtoSerialization.serializeParameters((AesCmacParameters) parameters);
            }
        }, AesCmacParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.m3493create(new ParametersParser.ParametersParsingFunction() { // from class: com.google.crypto.tink.mac.AZxh
            @Override // com.google.crypto.tink.internal.ParametersParser.ParametersParsingFunction
            public final Parameters parseParameters(Serialization serialization) {
                return AesCmacProtoSerialization.parseParameters((ProtoParametersSerialization) serialization);
            }
        }, bytesFromPrintableAscii, ProtoParametersSerialization.class);
        KEY_SERIALIZER = KeySerializer.m3486create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.mac.wA
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(AbstractC0308Key abstractC0308Key, SecretKeyAccess secretKeyAccess) {
                return AesCmacProtoSerialization.serializeKey((AesCmacKey) abstractC0308Key, secretKeyAccess);
            }
        }, AesCmacKey.class, ProtoKeySerialization.class);
        KEY_PARSER = KeyParser.m3485create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.mac.ZfxDd
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final AbstractC0308Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                return AesCmacProtoSerialization.parseKey((ProtoKeySerialization) serialization, secretKeyAccess);
            }
        }, bytesFromPrintableAscii, ProtoKeySerialization.class);
    }

    private AesCmacProtoSerialization() {
    }

    private static AesCmacParams getProtoParams(AesCmacParameters aesCmacParameters) {
        return AesCmacParams.newBuilder().setTagSize(aesCmacParameters.getCryptographicTagSizeBytes()).mo3555build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesCmacKey parseKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (!protoKeySerialization.getTypeUrl().equals(TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacParameters.parseParameters");
        }
        try {
            AesCmacKey from = AesCmacKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (from.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return AesCmacKey.m3509builder().setParameters(AesCmacParameters.m3511builder().setKeySizeBytes(from.getKeyValue().mo3944size()).setTagSizeBytes(from.getParams().getTagSize()).setVariant(toVariant(protoKeySerialization.getOutputPrefixType())).m3513build()).setAesKeyBytes(SecretBytes.copyFrom(from.getKeyValue().toByteArray(), SecretKeyAccess.requireAccess(secretKeyAccess))).setIdRequirement(protoKeySerialization.getIdRequirementOrNull()).m3510build();
        } catch (InvalidProtocolBufferException | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing AesCmacKey failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesCmacParameters parseParameters(ProtoParametersSerialization protoParametersSerialization) throws GeneralSecurityException {
        if (protoParametersSerialization.getKeyTemplate().getTypeUrl().equals(TYPE_URL)) {
            try {
                AesCmacKeyFormat from = AesCmacKeyFormat.parseFrom(protoParametersSerialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());
                return AesCmacParameters.m3511builder().setKeySizeBytes(from.getKeySize()).setTagSizeBytes(from.getParams().getTagSize()).setVariant(toVariant(protoParametersSerialization.getKeyTemplate().getOutputPrefixType())).m3513build();
            } catch (InvalidProtocolBufferException e) {
                throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesCmacParameters.parseParameters: " + protoParametersSerialization.getKeyTemplate().getTypeUrl());
    }

    public static void register() {
        register(MutableSerializationRegistry.globalInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializeKey(AesCmacKey aesCmacKey, @Nullable SecretKeyAccess secretKeyAccess) {
        return ProtoKeySerialization.m3499create(TYPE_URL, AesCmacKey.newBuilder().setParams(getProtoParams(aesCmacKey.getParameters())).setKeyValue(ByteString.copyFrom(aesCmacKey.getAesKey().toByteArray(SecretKeyAccess.requireAccess(secretKeyAccess)))).mo3555build().toByteString(), C0669KeyData.KeyMaterialType.SYMMETRIC, toOutputPrefixType(aesCmacKey.getParameters().getVariant()), aesCmacKey.getIdRequirementOrNull());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoParametersSerialization serializeParameters(AesCmacParameters aesCmacParameters) {
        return ProtoParametersSerialization.m3500create(KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(AesCmacKeyFormat.newBuilder().setParams(getProtoParams(aesCmacParameters)).setKeySize(aesCmacParameters.getKeySizeBytes()).mo3555build().toByteString()).setOutputPrefixType(toOutputPrefixType(aesCmacParameters.getVariant())).mo3555build());
    }

    private static OutputPrefixType toOutputPrefixType(AesCmacParameters.C0462Variant c0462Variant) throws GeneralSecurityException {
        if (AesCmacParameters.C0462Variant.f3150TINK.equals(c0462Variant)) {
            return OutputPrefixType.TINK;
        }
        if (AesCmacParameters.C0462Variant.f3148CRUNCHY.equals(c0462Variant)) {
            return OutputPrefixType.CRUNCHY;
        }
        if (AesCmacParameters.C0462Variant.NO_PREFIX.equals(c0462Variant)) {
            return OutputPrefixType.RAW;
        }
        if (AesCmacParameters.C0462Variant.f3149LEGACY.equals(c0462Variant)) {
            return OutputPrefixType.LEGACY;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + c0462Variant);
    }

    private static AesCmacParameters.C0462Variant toVariant(OutputPrefixType outputPrefixType) throws GeneralSecurityException {
        int i = C04631.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (i == 1) {
            return AesCmacParameters.C0462Variant.f3150TINK;
        }
        if (i == 2) {
            return AesCmacParameters.C0462Variant.f3148CRUNCHY;
        }
        if (i == 3) {
            return AesCmacParameters.C0462Variant.f3149LEGACY;
        }
        if (i == 4) {
            return AesCmacParameters.C0462Variant.NO_PREFIX;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + outputPrefixType.getNumber());
    }

    public static void register(MutableSerializationRegistry mutableSerializationRegistry) {
        mutableSerializationRegistry.registerParametersSerializer(PARAMETERS_SERIALIZER);
        mutableSerializationRegistry.registerParametersParser(PARAMETERS_PARSER);
        mutableSerializationRegistry.registerKeySerializer(KEY_SERIALIZER);
        mutableSerializationRegistry.registerKeyParser(KEY_PARSER);
    }
}
