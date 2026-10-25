package com.p038google.p061crypto.p062tink.p072prf;

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
import com.p038google.p061crypto.p062tink.p072prf.HkdfPrfParameters;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.HashType;
import com.p038google.p061crypto.p062tink.p073proto.HkdfPrfKey;
import com.p038google.p061crypto.p062tink.p073proto.HkdfPrfKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.HkdfPrfParams;
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
final class HkdfPrfProtoSerialization {
    private static final KeyParser<ProtoKeySerialization> KEY_PARSER;
    private static final KeySerializer<HkdfPrfKey, ProtoKeySerialization> KEY_SERIALIZER;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER;
    private static final ParametersSerializer<HkdfPrfParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.HkdfPrfKey";
    private static final C0878Bytes TYPE_URL_BYTES;

    /* renamed from: com.google.crypto.tink.prf.HkdfPrfProtoSerialization$1 */
    public static /* synthetic */ class C05001 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HashType;

        static {
            int[] iArr = new int[HashType.m3630values().length];
            $SwitchMap$com$google$crypto$tink$proto$HashType = iArr;
            try {
                iArr[HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA224.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA256.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA384.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA512.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        C0878Bytes bytesFromPrintableAscii = C0431Util.toBytesFromPrintableAscii(TYPE_URL);
        TYPE_URL_BYTES = bytesFromPrintableAscii;
        PARAMETERS_SERIALIZER = ParametersSerializer.m3494create(new ParametersSerializer.ParametersSerializationFunction() { // from class: com.google.crypto.tink.prf.mjFkc
            @Override // com.google.crypto.tink.internal.ParametersSerializer.ParametersSerializationFunction
            public final Serialization serializeParameters(Parameters parameters) {
                return HkdfPrfProtoSerialization.serializeParameters((HkdfPrfParameters) parameters);
            }
        }, HkdfPrfParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.m3493create(new ParametersParser.ParametersParsingFunction() { // from class: com.google.crypto.tink.prf.AZxh
            @Override // com.google.crypto.tink.internal.ParametersParser.ParametersParsingFunction
            public final Parameters parseParameters(Serialization serialization) {
                return HkdfPrfProtoSerialization.parseParameters((ProtoParametersSerialization) serialization);
            }
        }, bytesFromPrintableAscii, ProtoParametersSerialization.class);
        KEY_SERIALIZER = KeySerializer.m3486create(new KeySerializer.KeySerializationFunction() { // from class: com.google.crypto.tink.prf.wA
            @Override // com.google.crypto.tink.internal.KeySerializer.KeySerializationFunction
            public final Serialization serializeKey(AbstractC0308Key abstractC0308Key, SecretKeyAccess secretKeyAccess) {
                return HkdfPrfProtoSerialization.serializeKey((HkdfPrfKey) abstractC0308Key, secretKeyAccess);
            }
        }, HkdfPrfKey.class, ProtoKeySerialization.class);
        KEY_PARSER = KeyParser.m3485create(new KeyParser.KeyParsingFunction() { // from class: com.google.crypto.tink.prf.ZfxDd
            @Override // com.google.crypto.tink.internal.KeyParser.KeyParsingFunction
            public final AbstractC0308Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
                return HkdfPrfProtoSerialization.parseKey((ProtoKeySerialization) serialization, secretKeyAccess);
            }
        }, bytesFromPrintableAscii, ProtoKeySerialization.class);
    }

    private HkdfPrfProtoSerialization() {
    }

    private static HkdfPrfParams getProtoParams(HkdfPrfParameters hkdfPrfParameters) {
        HkdfPrfParams.C0612Builder c0612BuilderM3638setHash = HkdfPrfParams.newBuilder().m3638setHash(toProtoHashType(hkdfPrfParameters.getHashType()));
        if (hkdfPrfParameters.m3545getSalt() != null && hkdfPrfParameters.m3545getSalt().m4292size() > 0) {
            c0612BuilderM3638setHash.m3639setSalt(ByteString.copyFrom(hkdfPrfParameters.m3545getSalt().toByteArray()));
        }
        return c0612BuilderM3638setHash.mo3555build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HkdfPrfKey parseKey(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess secretKeyAccess) throws GeneralSecurityException {
        if (!protoKeySerialization.getTypeUrl().equals(TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to HkdfPrfProtoSerialization.parseKey");
        }
        try {
            HkdfPrfKey from = HkdfPrfKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (from.getVersion() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            if (protoKeySerialization.getIdRequirementOrNull() != null) {
                throw new GeneralSecurityException("ID requirement must be null.");
            }
            return HkdfPrfKey.m3541builder().setParameters(HkdfPrfParameters.m3543builder().setKeySizeBytes(from.getKeyValue().mo3944size()).setHashType(toHashType(from.getParams().mo3636getHash())).m3547setSalt(C0878Bytes.copyFrom(from.getParams().mo3637getSalt().toByteArray())).m3546build()).setKeyBytes(SecretBytes.copyFrom(from.getKeyValue().toByteArray(), SecretKeyAccess.requireAccess(secretKeyAccess))).m3542build();
        } catch (InvalidProtocolBufferException | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing HkdfPrfKey failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HkdfPrfParameters parseParameters(ProtoParametersSerialization protoParametersSerialization) throws GeneralSecurityException {
        if (!protoParametersSerialization.getKeyTemplate().getTypeUrl().equals(TYPE_URL)) {
            throw new IllegalArgumentException("Wrong type URL in call to HkdfPrfProtoSerialization.parseParameters: " + protoParametersSerialization.getKeyTemplate().getTypeUrl());
        }
        try {
            HkdfPrfKeyFormat from = HkdfPrfKeyFormat.parseFrom(protoParametersSerialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());
            if (from.getVersion() == 0) {
                if (protoParametersSerialization.getKeyTemplate().getOutputPrefixType() == OutputPrefixType.RAW) {
                    return HkdfPrfParameters.m3543builder().setKeySizeBytes(from.getKeySize()).setHashType(toHashType(from.getParams().mo3636getHash())).m3547setSalt(C0878Bytes.copyFrom(from.getParams().mo3637getSalt().toByteArray())).m3546build();
                }
                throw new GeneralSecurityException("Parsing HkdfPrfParameters failed: only RAW output prefix type is accepted");
            }
            throw new GeneralSecurityException("Parsing HkdfPrfParameters failed: unknown Version " + from.getVersion());
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Parsing HkdfPrfParameters failed: ", e);
        }
    }

    public static void register() {
        register(MutableSerializationRegistry.globalInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoKeySerialization serializeKey(HkdfPrfKey hkdfPrfKey, @Nullable SecretKeyAccess secretKeyAccess) {
        return ProtoKeySerialization.m3499create(TYPE_URL, HkdfPrfKey.newBuilder().setParams(getProtoParams(hkdfPrfKey.getParameters())).setKeyValue(ByteString.copyFrom(hkdfPrfKey.getKeyBytes().toByteArray(SecretKeyAccess.requireAccess(secretKeyAccess)))).mo3555build().toByteString(), C0669KeyData.KeyMaterialType.SYMMETRIC, OutputPrefixType.RAW, hkdfPrfKey.getIdRequirementOrNull());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtoParametersSerialization serializeParameters(HkdfPrfParameters hkdfPrfParameters) {
        return ProtoParametersSerialization.m3500create(KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(HkdfPrfKeyFormat.newBuilder().setParams(getProtoParams(hkdfPrfParameters)).setKeySize(hkdfPrfParameters.getKeySizeBytes()).mo3555build().toByteString()).setOutputPrefixType(OutputPrefixType.RAW).mo3555build());
    }

    private static HkdfPrfParameters.HashType toHashType(HashType hashType) throws GeneralSecurityException {
        int i = C05001.$SwitchMap$com$google$crypto$tink$proto$HashType[hashType.ordinal()];
        if (i == 1) {
            return HkdfPrfParameters.HashType.f3194SHA1;
        }
        if (i == 2) {
            return HkdfPrfParameters.HashType.f3195SHA224;
        }
        if (i == 3) {
            return HkdfPrfParameters.HashType.f3196SHA256;
        }
        if (i == 4) {
            return HkdfPrfParameters.HashType.f3197SHA384;
        }
        if (i == 5) {
            return HkdfPrfParameters.HashType.f3198SHA512;
        }
        throw new GeneralSecurityException("Unable to parse HashType: " + hashType.getNumber());
    }

    private static HashType toProtoHashType(HkdfPrfParameters.HashType hashType) throws GeneralSecurityException {
        if (HkdfPrfParameters.HashType.f3194SHA1.equals(hashType)) {
            return HashType.SHA1;
        }
        if (HkdfPrfParameters.HashType.f3195SHA224.equals(hashType)) {
            return HashType.SHA224;
        }
        if (HkdfPrfParameters.HashType.f3196SHA256.equals(hashType)) {
            return HashType.SHA256;
        }
        if (HkdfPrfParameters.HashType.f3197SHA384.equals(hashType)) {
            return HashType.SHA384;
        }
        if (HkdfPrfParameters.HashType.f3198SHA512.equals(hashType)) {
            return HashType.SHA512;
        }
        throw new GeneralSecurityException("Unable to serialize HashType " + hashType);
    }

    public static void register(MutableSerializationRegistry mutableSerializationRegistry) {
        mutableSerializationRegistry.registerParametersSerializer(PARAMETERS_SERIALIZER);
        mutableSerializationRegistry.registerParametersParser(PARAMETERS_PARSER);
        mutableSerializationRegistry.registerKeySerializer(KEY_SERIALIZER);
        mutableSerializationRegistry.registerKeyParser(KEY_PARSER);
    }
}
