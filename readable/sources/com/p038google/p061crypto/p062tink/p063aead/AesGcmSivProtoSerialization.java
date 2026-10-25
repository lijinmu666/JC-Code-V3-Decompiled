package com.p038google.p061crypto.p062tink.p063aead;

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
import com.p038google.p061crypto.p062tink.p063aead.AesGcmSivParameters;
import com.p038google.p061crypto.p062tink.p073proto.AesGcmSivKey;
import com.p038google.p061crypto.p062tink.p073proto.AesGcmSivKeyFormat;
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
final class AesGcmSivProtoSerialization {
    private static final KeyParser<ProtoKeySerialization> KEY_PARSER;
    private static final KeySerializer<AesGcmSivKey, ProtoKeySerialization> KEY_SERIALIZER;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER;
    private static final ParametersSerializer<AesGcmSivParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    private static final C0878Bytes TYPE_URL_BYTES;

    /* renamed from: com.google.crypto.tink.aead.AesGcmSivProtoSerialization$1 */
    public static /* synthetic */ class C03551 {
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
        PARAMETERS_SERIALIZER = ParametersSerializer.m3494create(new ParametersSerializer.ParametersSerializationFunction() { // from class: com.google.crypto.tink.aead.qdMbNW
            @Override // com.google.crypto.tink.internal.ParametersSerializer.ParametersSerializationFunction
            public final Serialization serializeParameters(Parameters parameters) {
                return AesGcmSivProtoSerialization.serializeParameters((AesGcmSivParameters) parameters);
            }
        }, AesGcmSivParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.m3493create(new ParametersParser.ParametersParsingFunction() { // from class: com.google.crypto.tink.aead.Dt
            @Override // com.google.crypto.tink.internal.ParametersParser.ParametersParsingFunction
            public final Parameters parseParameters(Serialization serialization) {
                return AesGcmSivProtoSerialization.parseParameters((ProtoParametersSerialization) serialization);
            }
        }, bytesFromPrintableAscii, ProtoParametersSerialization.class);
        KEY_SERIALIZER = KeySerializer.m3486create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.aead.ETF
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(AbstractC0308Key abstractC0308Key, SecretKeyAccess secretKeyAccess) {
                return AesGcmSivProtoSerialization.serializeKey((AesGcmSivKey) abstractC0308Key, secretKeyAccess);
            }
        }, AesGcmSivKey.class, ProtoKeySerialization.class);
        KEY_PARSER = KeyParser.m3485create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.aead.VA
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final AbstractC0308Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                return AesGcmSivProtoSerialization.parseKey((ProtoKeySerialization) serialization, secretKeyAccess);
            }
        }, bytesFromPrintableAscii, ProtoKeySerialization.class);
    }

    private AesGcmSivProtoSerialization() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesGcmSivKey parseKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (!protoKeySerialization.getTypeUrl().equals(TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivParameters.parseParameters");
        }
        try {
            AesGcmSivKey from = AesGcmSivKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (from.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return AesGcmSivKey.m3413builder().setParameters(AesGcmSivParameters.m3415builder().setKeySizeBytes(from.getKeyValue().mo3944size()).setVariant(toVariant(protoKeySerialization.getOutputPrefixType())).m3417build()).setKeyBytes(SecretBytes.copyFrom(from.getKeyValue().toByteArray(), SecretKeyAccess.requireAccess(secretKeyAccess))).setIdRequirement(protoKeySerialization.getIdRequirementOrNull()).m3414build();
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesGcmSivParameters parseParameters(ProtoParametersSerialization protoParametersSerialization) throws GeneralSecurityException {
        if (protoParametersSerialization.getKeyTemplate().getTypeUrl().equals(TYPE_URL)) {
            try {
                return AesGcmSivParameters.m3415builder().setKeySizeBytes(AesGcmSivKeyFormat.parseFrom(protoParametersSerialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry()).getKeySize()).setVariant(toVariant(protoParametersSerialization.getKeyTemplate().getOutputPrefixType())).m3417build();
            } catch (InvalidProtocolBufferException e) {
                throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivParameters.parseParameters: " + protoParametersSerialization.getKeyTemplate().getTypeUrl());
    }

    public static void register() {
        register(MutableSerializationRegistry.globalInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializeKey(AesGcmSivKey aesGcmSivKey, @Nullable SecretKeyAccess secretKeyAccess) {
        return ProtoKeySerialization.m3499create(TYPE_URL, AesGcmSivKey.newBuilder().setKeyValue(ByteString.copyFrom(aesGcmSivKey.getKeyBytes().toByteArray(SecretKeyAccess.requireAccess(secretKeyAccess)))).mo3555build().toByteString(), C0669KeyData.KeyMaterialType.SYMMETRIC, toProtoOutputPrefixType(aesGcmSivKey.getParameters().getVariant()), aesGcmSivKey.getIdRequirementOrNull());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoParametersSerialization serializeParameters(AesGcmSivParameters aesGcmSivParameters) {
        return ProtoParametersSerialization.m3500create(KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(AesGcmSivKeyFormat.newBuilder().setKeySize(aesGcmSivParameters.getKeySizeBytes()).mo3555build().toByteString()).setOutputPrefixType(toProtoOutputPrefixType(aesGcmSivParameters.getVariant())).mo3555build());
    }

    private static OutputPrefixType toProtoOutputPrefixType(AesGcmSivParameters.C0354Variant c0354Variant) throws GeneralSecurityException {
        if (AesGcmSivParameters.C0354Variant.f3045TINK.equals(c0354Variant)) {
            return OutputPrefixType.TINK;
        }
        if (AesGcmSivParameters.C0354Variant.f3044CRUNCHY.equals(c0354Variant)) {
            return OutputPrefixType.CRUNCHY;
        }
        if (AesGcmSivParameters.C0354Variant.NO_PREFIX.equals(c0354Variant)) {
            return OutputPrefixType.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + c0354Variant);
    }

    private static AesGcmSivParameters.C0354Variant toVariant(OutputPrefixType outputPrefixType) throws GeneralSecurityException {
        int i = C03551.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (i == 1) {
            return AesGcmSivParameters.C0354Variant.f3045TINK;
        }
        if (i == 2 || i == 3) {
            return AesGcmSivParameters.C0354Variant.f3044CRUNCHY;
        }
        if (i == 4) {
            return AesGcmSivParameters.C0354Variant.NO_PREFIX;
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
