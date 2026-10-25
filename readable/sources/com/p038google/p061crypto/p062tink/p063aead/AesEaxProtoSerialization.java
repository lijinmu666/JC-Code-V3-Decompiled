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
import com.p038google.p061crypto.p062tink.p063aead.AesEaxParameters;
import com.p038google.p061crypto.p062tink.p073proto.AesEaxKey;
import com.p038google.p061crypto.p062tink.p073proto.AesEaxKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.AesEaxParams;
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
final class AesEaxProtoSerialization {
    private static final KeyParser<ProtoKeySerialization> KEY_PARSER;
    private static final KeySerializer<AesEaxKey, ProtoKeySerialization> KEY_SERIALIZER;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER;
    private static final ParametersSerializer<AesEaxParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.AesEaxKey";
    private static final C0878Bytes TYPE_URL_BYTES;

    /* renamed from: com.google.crypto.tink.aead.AesEaxProtoSerialization$1 */
    public static /* synthetic */ class C03391 {
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
        PARAMETERS_SERIALIZER = ParametersSerializer.m3494create(new ParametersSerializer.ParametersSerializationFunction() { // from class: com.google.crypto.tink.aead.mjFkc
            @Override // com.google.crypto.tink.internal.ParametersSerializer.ParametersSerializationFunction
            public final Serialization serializeParameters(Parameters parameters) {
                return AesEaxProtoSerialization.serializeParameters((AesEaxParameters) parameters);
            }
        }, AesEaxParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.m3493create(new ParametersParser.ParametersParsingFunction() { // from class: com.google.crypto.tink.aead.AZxh
            @Override // com.google.crypto.tink.internal.ParametersParser.ParametersParsingFunction
            public final Parameters parseParameters(Serialization serialization) {
                return AesEaxProtoSerialization.parseParameters((ProtoParametersSerialization) serialization);
            }
        }, bytesFromPrintableAscii, ProtoParametersSerialization.class);
        KEY_SERIALIZER = KeySerializer.m3486create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.aead.wA
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(AbstractC0308Key abstractC0308Key, SecretKeyAccess secretKeyAccess) {
                return AesEaxProtoSerialization.serializeKey((AesEaxKey) abstractC0308Key, secretKeyAccess);
            }
        }, AesEaxKey.class, ProtoKeySerialization.class);
        KEY_PARSER = KeyParser.m3485create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.aead.ZfxDd
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final AbstractC0308Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                return AesEaxProtoSerialization.parseKey((ProtoKeySerialization) serialization, secretKeyAccess);
            }
        }, bytesFromPrintableAscii, ProtoKeySerialization.class);
    }

    private AesEaxProtoSerialization() {
    }

    private static AesEaxParams getProtoParams(AesEaxParameters aesEaxParameters) throws GeneralSecurityException {
        if (aesEaxParameters.getTagSizeBytes() == 16) {
            return AesEaxParams.newBuilder().setIvSize(aesEaxParameters.getIvSizeBytes()).mo3555build();
        }
        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d. Currently Tink only supports aes eax keys with tag size equal to 16 bytes.", Integer.valueOf(aesEaxParameters.getTagSizeBytes())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesEaxKey parseKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (!protoKeySerialization.getTypeUrl().equals(TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxParameters.parseParameters");
        }
        try {
            AesEaxKey from = AesEaxKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (from.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return AesEaxKey.m3395builder().setParameters(AesEaxParameters.m3397builder().setKeySizeBytes(from.getKeyValue().mo3944size()).setIvSizeBytes(from.getParams().getIvSize()).setTagSizeBytes(16).setVariant(toVariant(protoKeySerialization.getOutputPrefixType())).m3399build()).setKeyBytes(SecretBytes.copyFrom(from.getKeyValue().toByteArray(), SecretKeyAccess.requireAccess(secretKeyAccess))).setIdRequirement(protoKeySerialization.getIdRequirementOrNull()).m3396build();
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Parsing AesEaxcKey failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesEaxParameters parseParameters(ProtoParametersSerialization protoParametersSerialization) throws GeneralSecurityException {
        if (protoParametersSerialization.getKeyTemplate().getTypeUrl().equals(TYPE_URL)) {
            try {
                AesEaxKeyFormat from = AesEaxKeyFormat.parseFrom(protoParametersSerialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());
                return AesEaxParameters.m3397builder().setKeySizeBytes(from.getKeySize()).setIvSizeBytes(from.getParams().getIvSize()).setTagSizeBytes(16).setVariant(toVariant(protoParametersSerialization.getKeyTemplate().getOutputPrefixType())).m3399build();
            } catch (InvalidProtocolBufferException e) {
                throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesEaxParameters.parseParameters: " + protoParametersSerialization.getKeyTemplate().getTypeUrl());
    }

    public static void register() {
        register(MutableSerializationRegistry.globalInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializeKey(AesEaxKey aesEaxKey, @Nullable SecretKeyAccess secretKeyAccess) {
        return ProtoKeySerialization.m3499create(TYPE_URL, AesEaxKey.newBuilder().setParams(getProtoParams(aesEaxKey.getParameters())).setKeyValue(ByteString.copyFrom(aesEaxKey.getKeyBytes().toByteArray(SecretKeyAccess.requireAccess(secretKeyAccess)))).mo3555build().toByteString(), C0669KeyData.KeyMaterialType.SYMMETRIC, toProtoOutputPrefixType(aesEaxKey.getParameters().getVariant()), aesEaxKey.getIdRequirementOrNull());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoParametersSerialization serializeParameters(AesEaxParameters aesEaxParameters) {
        return ProtoParametersSerialization.m3500create(KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(AesEaxKeyFormat.newBuilder().setParams(getProtoParams(aesEaxParameters)).setKeySize(aesEaxParameters.getKeySizeBytes()).mo3555build().toByteString()).setOutputPrefixType(toProtoOutputPrefixType(aesEaxParameters.getVariant())).mo3555build());
    }

    private static OutputPrefixType toProtoOutputPrefixType(AesEaxParameters.C0338Variant c0338Variant) throws GeneralSecurityException {
        if (AesEaxParameters.C0338Variant.f3033TINK.equals(c0338Variant)) {
            return OutputPrefixType.TINK;
        }
        if (AesEaxParameters.C0338Variant.f3032CRUNCHY.equals(c0338Variant)) {
            return OutputPrefixType.CRUNCHY;
        }
        if (AesEaxParameters.C0338Variant.NO_PREFIX.equals(c0338Variant)) {
            return OutputPrefixType.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + c0338Variant);
    }

    private static AesEaxParameters.C0338Variant toVariant(OutputPrefixType outputPrefixType) throws GeneralSecurityException {
        int i = C03391.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (i == 1) {
            return AesEaxParameters.C0338Variant.f3033TINK;
        }
        if (i == 2 || i == 3) {
            return AesEaxParameters.C0338Variant.f3032CRUNCHY;
        }
        if (i == 4) {
            return AesEaxParameters.C0338Variant.NO_PREFIX;
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
